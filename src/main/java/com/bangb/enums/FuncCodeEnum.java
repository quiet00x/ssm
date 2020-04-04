package com.bangb.enums;

import com.bangb.bean.FuncCodeBean;

public enum FuncCodeEnum {
	/**
	 * 辖行初审节点，对应机构属性为辖行
	 */
	CITY_BRANCH_FIR("BERSMW0002", "1") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType());  
		}
		/**
		 * 辖行复审节点，对应机构属性为辖行
		 */
	}, CITY_BRANCH_SEC("BERSMW0003", "1") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType());  
		}
		/**
		 * 辖行终审节点，对应机构属性为辖行
		 */
	}, CITY_BRANCH_THR("BERSMW0004", "1") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType());   
		}
		/**
		 * 省直分行初审节点，对应机构属性为省分行
		 */
	}, BRANCH_FIR("BERSMW0005", "2") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType());   
		}
		/**
		 * 省直分行复审节点，对应机构属性为省分行
		 */
	}, BRANCH_SEC("BERSMW0006", "2") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType()); 
		}
		/**
		 * 省直分行终审节点，对应机构属性为省分行
		 */
	}, BRANCH_THR("BERSMW0007", "2") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType()); 
		}
		/**
		 * 总行初审节点，对应机构属性为总行
		 */
	}, HEAD_FIR("BERSMW0008", "3") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType());  
		}
		/**
		 * 总行复审节点，对应机构属性为总行
		 */
	}, HEAD_SEC("BERSMW0009", "3") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType());  
		}
		/**
		 * 会签分派节点，对应机构属性为总行
		 */
	}, SIGN_DISPATCH("BERSMW00010", "3") {
		@Override
		public FuncCodeBean chooseFuncCodeAndOrgType() {
			return new FuncCodeBean(getFuncCode(),getOrgType()); 
		}
	};  
	
    // 功能码
    private String funcCode;
    // 机构属性
    private String orgType;  
    
    // 构造方法 ,赋值给成员变量
    private FuncCodeEnum(String funcCode, String orgType) {  
        this.funcCode = funcCode;  
        this.orgType = orgType;  
    }  
    
    public String getFuncCode() {
        return this.funcCode;
    }
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
    public String getOrgType() {
        return this.orgType;
    }
    public void setName(String orgType) {
        this.orgType = orgType;
    }

    // 抽象方法，每个枚举常量必须实现
    public abstract FuncCodeBean chooseFuncCodeAndOrgType();

}
