package com.bangb.enums;

/**
 * 	首先枚举是一个特殊的class
 *	这个class相当于final static修饰，不能被继承
 *	他的构造方法强制被私有化，下面有一个默认的构造方法private ColorEnum();
 *	所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类
 * @author Preciousness
 * 枚举型常量
 *
 */
public enum ColorEnum {
	//每个枚举变量都是枚举类ColorEnum的实例，相当于RED=new ColorEnum（1），按序号来。
    //每个成员变量都是final static修饰
    RED, GREEN, BLANK, YELLOW;
	
}

