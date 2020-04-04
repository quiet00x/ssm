package com.bangb.enums;

/**
 * 向枚举中添加新方法
 * @author Preciousness
 *
 */
public enum SeasonEunm {
	
	 //每一个枚举变量都是枚举类SeasonEunm的实例化
    //SeasonEunm.SPRING获得的对象相当于new SeasonEunm("春","春困");获得的对象
    SPRING("春","春困"),SUMMER("夏","夏睡"),AUTUMN("秋","秋乏"),WINTER("冬","冬眠");

    //强制私有化的构造方法，因为枚举类默认继承Eunm类，被final static修饰，不能被继承
    //由于被强制private，所以不能使用new去生成枚举对象
    //在SeasonEunm.SPRING获得对象，隐式调用了下面的构造方法
    // 构造方法 ,赋值给成员变量
    private SeasonEunm(String name, String value) {
        this.name = name;
        this.value = value;
    }


    //添加成员变量的原因是，方便够着方法赋值，使用SeasonEunm.SPRING.getName就能获取对应的值
    private String name;
    private String value;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
