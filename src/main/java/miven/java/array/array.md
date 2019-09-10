# Array

## 数组复制
    1.复制数组的方法有多种Arrays中的copyOf()、copyOfRange()，System中的arraycopy()，Object中的clone()。
    但其背后只有arraycopy()和clone()两种。
    2.浅拷贝：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝。
      深拷贝：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容。
- arraycopy()
    - 指定新数组大小
    - 基本类型(包含 String 类型)拷贝值
    - 引用类型拷贝引用
- clone()
    - 新数组大小和原数组大小相同
    - 基本类型(包含 String 类型)克隆值
    - 引用类型克隆引用
