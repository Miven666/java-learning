# Serializable
> 只要实现了Serializable，默认序列化时所有属性和方法都会自动序列化
## transient关键字
    HashMap中的‘HashMap.Node<K, V>[] table’、‘Set<Entry<K, V>> entrySet’、‘int size’、‘int modCount’。
    GenericServlet中的‘ServletConfig config’。
- 被transient修饰的变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问
- transient关键字只能修饰变量，而不能修饰方法和类
> 本地变量是不能被transient关键字修饰的
- 一个静态变量不管是否被transient修饰，均不能被序列化
- 若实现的是Externalizable(Serializable的子接口)，因为是手动实例化，不存在能否被自动序列化一说了