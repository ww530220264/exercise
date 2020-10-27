package org.example.asm._1;

import javax.annotation.Resource;

@Deprecated
public class Asm_1<T> implements Runnable{

    @Resource
    public static int a = 10;


    public static void main(String[] args) {

    }
    public T test(T t){
        System.out.println("处理中........");
        return t;
    }

    @Resource
    public static int b;

    @Override
    public void run() {
        System.err.println("Override run方法");
    }

    private int c;
}
