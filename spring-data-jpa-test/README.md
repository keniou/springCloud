#Spring Data 解析方法名--规则说明

## 1、规则描述

按照Spring data 定义的规则，查询方法以find|read|get开头（比如 find、findBy、read、readBy、get、getBy），涉及条件查询时，条件的属性用条件关键字连接，要注意的是：条件属性首字母需大写。框架在进行方法名解析时，会先把方法名多余的前缀截取掉，然后对剩下部分进行解析。

如果方法的最后一个参数是 Sort 或者 Pageable 类型，也会提取相关的信息，以便按规则进行排序或者分页查询。

## 2、举例说明

比如 findByUserAddressZip()。框架在解析该方法时，首先剔除 findBy，然后对剩下的属性进行解析，详细规则如下（此处假设该方法针对的域对象为 AccountInfo 类型）：

先判断 userAddressZip （根据 POJO 规范，首字母变为小写，下同）是否为 AccountInfo 的一个属性，如果是，则表示根据该属性进行查询；如果没有该属性，继续第二步；

从右往左截取第一个大写字母开头的字符串（此处为 Zip），然后检查剩下的字符串是否为 AccountInfo 的一个属性，如果是，则表示根据该属性进行查询；如果没有该属性，则重复第二步，继续从右往左截取；最后假设 user 为 AccountInfo 的一个属性；

接着处理剩下部分（ AddressZip ），先判断 user 所对应的类型是否有 addressZip 属性，如果有，则表示该方法最终是根据 "AccountInfo.user.addressZip" 的取值进行查询；否则继续按照步骤 2 的规则从右往左截取，最终表示根据 "AccountInfo.user.address.zip" 的值进行查询。

可能会存在一种特殊情况，比如 AccountInfo 包含一个 user 的属性，也有一个 userAddress 属性，此时会存在混淆。读者可以明确在属性之间加上 "_" 以显式表达意图，比如 "findByUser_AddressZip()" 或者 "findByUserAddress_Zip()"。（强烈建议：无论是否存在混淆，都要在不同类层级之间加上"_" ，增加代码可读性）
