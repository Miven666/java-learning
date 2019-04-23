package com.miven.array;

import java.util.Arrays;

/**
 * 数组 例子
 *
 * @author mingzhi.xie
 * @date 2019/4/22.
 */
class ArrayExample {

    /**
     * 复制 -> 基本类型(包含 String 类型)拷贝值 -> 浅拷贝
     * @param baseArr 源基本类型数组
     */
    void baseTypeCopy(int[] baseArr) {
        // Arrays.copyOf(defaultArr, 10)
        int[] copied = new int[10];
        System.arraycopy(baseArr, 0, copied, 2, Math.min(baseArr.length, 7));
        System.out.println("baseArr is " + Arrays.toString(baseArr));
        System.out.println("copied is " + Arrays.toString(copied));
        System.out.println();

        baseArr[0] = 9;
        System.out.println("baseArr[0] is set 9");
        System.out.println("Update baseArr after baseArr is " + Arrays.toString(baseArr));
        System.out.println("Update baseArr after copied is " + Arrays.toString(copied));
        System.out.println();

        System.out.println("Clone after baseArr equals cloneArr:" + Arrays.equals(baseArr, copied));
    }

    /**
     * 复制 -> 引用类型拷贝引用-> 浅拷贝
     * @param refArr 源引用类型数组
     */
    void referenceTypeCopy(Person[] refArr) {
        Person[] copied = new Person[10];
        System.arraycopy(refArr, 0, copied, 2, Math.min(refArr.length, 7));
        System.out.println("refArr is " + Arrays.toString(refArr));
        System.out.println("copied is " + Arrays.toString(copied));
        System.out.println();

        refArr[0].setName("99");
        System.out.println("refArr[0] name is set 99");
        System.out.println("Update refArr after refArr is " + Arrays.toString(refArr));
        System.out.println("Update refArr after copied is " + Arrays.toString(copied));
        System.out.println();

        System.out.println("Clone after refArr equals cloneArr:" + Arrays.equals(refArr, copied));
    }

    /**
     * 克隆 -> 基本类型(包含 String 类型)克隆值 -> 浅拷贝
     * @param baseArr 源基本类型数组
     */
    void baseTypeClone(int[] baseArr) {
        int[] cloneArr = baseArr.clone();
        System.out.println("baseArr is " + Arrays.toString(baseArr));
        System.out.println("cloneArr is " + Arrays.toString(cloneArr));
        System.out.println();

        baseArr[0] = 9;
        System.out.println("baseArr[0] is set 9");
        System.out.println("Update baseArr after cloneArr is " + Arrays.toString(baseArr));
        System.out.println("Update baseArr after cloneArr is " + Arrays.toString(cloneArr));
        System.out.println();

        System.out.println("Clone after baseArr equals cloneArr:" + Arrays.equals(baseArr, cloneArr));
    }

    /**
     * 克隆 -> 引用类型克隆引用 -> 浅拷贝
     * @param refArr 源引用类型数组
     */
    void referenceTypeClone(Person[] refArr) {
        Person[] cloneArr = refArr.clone();
        System.out.println("refArr is " + Arrays.toString(refArr));
        System.out.println("cloneArr is " + Arrays.toString(cloneArr));
        System.out.println();

        refArr[0].setName("88");
        System.out.println("refArr[0] name is set 88");
        System.out.println("Update refArr after cloneArr is " + Arrays.toString(refArr));
        System.out.println("Update refArr after cloneArr is " + Arrays.toString(cloneArr));
        System.out.println();

        System.out.println("Clone after refArr equals cloneArr:" + Arrays.equals(refArr, cloneArr));
    }
}
