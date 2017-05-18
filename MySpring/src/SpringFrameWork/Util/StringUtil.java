package SpringFrameWork.Util;

public class StringUtil {

	
	
	public static String CharAtIndex(String s,int index)
	{
		
		
	//	String newstr= s.substring(0, 1).toUpperCase()+s.substring(1);
	     
		char[] arr=s.toCharArray();
	    arr[index] -=32;
	    String newStr=String.valueOf(arr);
		
		
		return newStr;
	}
	
}
