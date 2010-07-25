package com.eknv.model;

public class JavaTest
{
	int id;
    String foo;
	int bar;

    public JavaTest(int id, String foo, int bar) {
        setId(id);
        setFoo(foo);
        setBar(bar);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }
}

