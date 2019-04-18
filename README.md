# Java 学习

## Java类加载机制及自定义加载器
### ClassLoader类加载器
- 隐式加载
- 显示加载
### jvm自带的加载器
- BootStrap ClassLoader
- Extention ClassLoader
- AppClassLoader
### 类加载器的继承关系
- ExtClassLoader，AppClassLoader继承URLClassLoader，而URLClassLoader继承ClassLoader
- BootStrap由C/C++编写，它本身是虚拟机的一部分，并不是一个java类
- 加载顺序：BootStrap ClassLoader->ExtClassLoader->AppClassLoader

### 类加载器之间的父子关系
    AppClassLoader的父加载器为ExtClassLoader，ExtClassLoader的父加载器为null，BoopStrap ClassLoader为顶级加载器。

### 类加载机制-双亲委派机制
    当jvm要加载Test.class的时候
    1) 首先会到自定义加载器中，查找是否有加载过，若有则返回字节码，没有询问上一层加载器
    2) 上一层加载器（AppClassLoader）接收到询问，查找是否有加载过，有则返回字节码，没有继续询问上一层加载器
    3) 上一层加载器（ExtClassLoader）接收到询问，查找是否有加载过，有则返回字节码，没有继续询问上一层加载器
    3) 上一层加载器（BootStrap ClassLoader）接收到询问，查找是否有加载过，有则返回字节码，
        没有则到自己指定类加载路径（sun.boot.class.path）查找是否有Test.class字节码，若有则返回，没有通知下一层
    4) 下一层加载器（ExtClassLoader）接收到通知，查找自己指定加载路径（java.ext.dirs）是否有字节码，若有则返回，没有通知下一层
    4) 下一层加载器（AppClassLoader）接收到通知，查找自己指定加载路径（）是否有字节码，若有则返回，没有通知下一层
- 参考地址 https://www.cnblogs.com/gdpuzxs/p/7044963.html

## Class
### getName()
    获取类名（含包路径）
### getSimpleName()
    获取类名

## Serializable
> 只要实现了Serializable，默认序列化时所有属性和方法都会自动序列化
### transient关键字
    HashMap中的‘HashMap.Node<K, V>[] table’、‘Set<Entry<K, V>> entrySet’、‘int size’、‘int modCount’。
    GenericServlet中的‘ServletConfig config’。
- 被transient修饰的变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问
- transient关键字只能修饰变量，而不能修饰方法和类
> 本地变量是不能被transient关键字修饰的
- 一个静态变量不管是否被transient修饰，均不能被序列化
- 若实现的是Externalizable(Serializable的子接口)，因为是手动实例化，不存在能否被自动序列化一说了
