package com.techinfinities.pnpcodes.defaultAndStaticMethod;

public class MyClass implements Interface1,Interface2{

    @Override
    public void method1(String str) {

    }

    @Override
    public void method2() {

    }

    // MyClss won't compile without having it's own log() implementation
    @Override
    public void log(String str) {
        System.out.println("MyClass Logging ::: "+ str);
        Interface1.print("abc");
    }


}
