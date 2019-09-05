package com.shenghao.core;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassScanner {
    public static List<Class<?>> scanClass(String packageName) throws IOException, ClassNotFoundException {
        //用于保存结果的容器
        List<Class<?>> classList = new ArrayList<>();
        //把文件名改为文件路径
        String path = packageName.replace(".", "/");
        //获取默认的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //通过文件路径获取该文件夹下所有资源的URL
        Enumeration<URL> resources = classLoader.getResources(path);

        int index = 0;//测试

        while (resources.hasMoreElements()) {
            System.out.println(++index);//测试

            //拿到下一个资源
            URL resource = resources.nextElement();
            //先判断是否是jar包，因为默认.class文件会被打包为jar包
            if (resource.getProtocol().contains("jar")) {

                System.out.println("拿到一个jar包");//测试

                //把URL强转为jar包链接
                JarURLConnection jarURLConnection = (JarURLConnection) resource.openConnection();
                //根据jar包获取jar包的路径名
                String jarFilePath = jarURLConnection.getJarFile().getName();
                //把jar包下所有的类添加的保存结果的容器中
                classList.addAll(getClassFromJar(jarFilePath, path));
            } else {//也有可能不是jar文件，先放下
                File[] files = getClassFiles(resource.getPath());
                if(files != null){  //如果files不为空的话，对它进行迭代

                    for(File file:files){
                        //取到文件名
                        String fileName=file.getName(); //Column.class
                        if(file.isFile()){//如果取到的是文件
                            //取到对应的类名,这里的类名是权限定名
                            String c = getClassName(packageName, fileName);
                            classList.add(Class.forName(c));
                        }else{
                            List<Class<?>> m = scanClass(packageName + "." + fileName);
                            classList.addAll(m);
                        }
                    }

                }
            }
        }
        return classList;
    }

    /**
     * 获取jar包中所有路径符合的类文件
     *
     * @param jarFilePath
     * @param path
     * @return
     */
    private static List<Class<?>> getClassFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();//保存结果的集合
        JarFile jarFile = new JarFile(jarFilePath);//创建对应jar包的句柄
        Enumeration<JarEntry> jarEntries = jarFile.entries();//拿到jar包中所有的文件
        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();//拿到一个文件
            String entryName = jarEntry.getName();//拿到文件名，大概是这样：com/shenghao/test/Test.class
            if (entryName.startsWith(path) && entryName.endsWith(".class")) {//判断是否是类文件
                String classFullName = entryName.replace("/", ".")
                        .substring(0, entryName.length() - 6);
                classes.add(Class.forName(classFullName));
            }
        }
        return classes;
    }

    /**
     * 获取class文件
     *
     * @param packagePath
     * @return
     */
    private static File[] getClassFiles(String packagePath) {
        //FileFilter文件过滤器
        return new File(packagePath).listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                //如果是.class文件，或者是目录就返回true
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }

        });

    }

    /**
     * 根据传入的包名和文件名返回对应类的全限定名
     * @param packageName 包名
     * @param fileName 文件名 	类名.后缀名
     * @return 包名.类名
     */
    private static String getClassName(String packageName, String fileName) {
        String className=fileName.substring(0,fileName.indexOf("."));
        if(packageName!=null && !"".equals(packageName)){
            className=packageName+"."+className;
        }
        return className;
    }

}
