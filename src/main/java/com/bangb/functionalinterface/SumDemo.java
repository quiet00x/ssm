package com.bangb.functionalinterface;

/**
 * 声明是一个函数式接口
 * 只能有一个抽象方法 
 */
@FunctionalInterface
public interface SumDemo {
	// 接口抽象方法
    int sum(int x);
}
