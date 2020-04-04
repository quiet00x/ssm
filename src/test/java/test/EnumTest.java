package test;

import com.bangb.enums.ColorEnum;
import com.bangb.enums.FuncCodeEnum;
import com.bangb.enums.SeasonEunm;
import com.bangb.enums.TypeEnum;

public class EnumTest {
	public static void main(String[] args) {
		for(ColorEnum color:ColorEnum.values()) {
	        System.out.println(color+",ordinal:"+color.ordinal()+",name:"+color.name());
	    }
		
		String typeName = "f5";  
	    TypeEnum type = TypeEnum.fromTypeName(typeName);
	    //type:是TypeEnum类实例化对象     typeName：实例化对象type的值             
	    // ordinal：实例化对象type的序号（int）          排序值(默认自带的属性 ordinal 的值)
	    //name：实化对象的名字（String）                            枚举名称(即默认自带的属性 name 的值)
	    System.out.println(type+",typeName:"+type.getTypeName()+",ordinal:"+type.ordinal()+",name:"+type.name());
		
	    //ordinal返回枚举变量的序号
	    for(SeasonEunm seasion:SeasonEunm.values()) {
	        System.out.println(seasion+",ordinal:"+seasion.ordinal()+",name:"+seasion.name());
	        System.out.println("枚举变量值:"+seasion.getName()+",枚举变量值:"+seasion.getValue());
	    }
	    
	    FuncCodeEnum[] values = FuncCodeEnum.values();
		for(FuncCodeEnum funcEnum : values) {
			System.out.println(funcEnum.chooseFuncCodeAndOrgType());
	    }
		
		FuncCodeEnum funcCodeEnum = FuncCodeEnum.valueOf("BRANCH_FIR");
		System.out.println(funcCodeEnum.chooseFuncCodeAndOrgType());
	    
	}
	
}
