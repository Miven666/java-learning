# ArrayList

## 实现接口
- List
```text
从源码中可以看到，ArrayList 和父类 AbstractList 都 显示实现了List，这种设计的意义其实和反射相关。
Class中的getInterfaces()只返回自身显示实现的接口，不会返回父类实现的接口。
JDK动态代理是基于接口代理的，因此被代理类最好显示实现被代理的接口。
```
- Serializable
    + 支持序列化，能够被序列化传输
- RandomAccess
    + 支持快速随机访问，实际上就是通过下标序号进行快速访问
- Cloneable
    + 支持克隆(浅复制)
    + 构造复制(浅复制)
    ```text
   这两种本质 还是调用 Object 的 clone(浅复制) 和数组的复制（浅复制）,所以想对数组中元素进行 深拷贝，
  需要对象实现 Serializable(IO 流的方式)或 重写 clone() 方法。
  已知框架 commons-lang3 中 SerializationUtils#clone() 方法.
    ```
 ## 并发修改异常（ConcurrentModificationException） 
- 集合截取：截取之后，一旦原集合新增或删除元素（更新不影响），则子集合不可再操作（新增、修改、删除），主要是影响背后数组的索引