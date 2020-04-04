package test;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.PackageUtils;

public class ReaderTest {
	public static void main(String[] args) throws BusinessException {
		String filePath = "D:\\temp\\UserController.java";
		PackageUtils.ReadJavaFile(filePath);
	}
}
