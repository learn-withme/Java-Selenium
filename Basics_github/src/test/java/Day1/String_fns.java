package Day1;

public class String_fns {
	public static void main(String [] args) {
		String s = "Automation";
		String str ="";
		String str1 = "";
		int cnt = 0;
		//StringBuilder sb = new StringBuilder(s);
		//sb.reverse()
		s = s.toLowerCase();
		for (int i =s.length()-1 ;i >=0 ;i--)
		{
			str = str + s.charAt(i);
			if (s.charAt(i) =='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
			{
				cnt =cnt + 1;
			}
			else 
			{
				str1 = str1 + s.charAt(i);
			}
			
		}
		System.out.println("Number of vowles :" + cnt);
		System.out.println("String Without Vowels: "+ str);
		System.out.println("Reverse String using For loop: "+ str1);
		System.out.println(s);
		//System.out.println(sb.reverse());
		/*s = s.toLowerCase();
		for (int j =0;j < s.length();j++)
		{
			if (s.charAt(j) =='a'||s.charAt(j)=='e'||s.charAt(j)=='i'||s.charAt(j)=='o'||s.charAt(j)=='u')
			{
				cnt =cnt + 1;
			}
			else 
			{
				str = str + s.charAt(j);
			}
				
		}
		System.out.println("Number of vowles :" + cnt);
		System.out.println("String Without Vowels  "+ str);*/
		//Spliting a string
		String var_str = "order/12345/waytogo";
		String[] str_arr = var_str.split("/");
		for (String a :str_arr )
			System.out.println(a);
			
		
		
		String url = "http://www.abc.com/alpha/beta/33445566778899/gamma/delta";
		String digitStr = null;
		for(String str3 : url.split("/")){
		    System.out.println(str3);
		    if(str3.matches("[0-9]{10,20}")){
		        digitStr = str3;
		        break;
		    }
		}
		//System.out.println(digitStr);
		
		//Find the vowels in the String in reverse and count the vowels
		int cnt_a = 0,cnt_e =0,cnt_i =0,cnt_o = 0,cnt_u =0;
		String str3 = "";
		String str4 = "";
		for (int i =s.length()-1 ;i >=0 ;i--)
		{
			
			if (s.charAt(i) =='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
			{
				if (s.charAt(i) =='a') 
					cnt_a = cnt_a+1;
				else if (s.charAt(i)=='e')
					cnt_e =  cnt_e +1;
				else if (s.charAt(i)=='i')
					cnt_i =  cnt_i +1;
				else if (s.charAt(i)=='o')
					cnt_o =  cnt_o +1;
				else if (s.charAt(i)=='u')
					cnt_u =  cnt_u +1;
			    str4 = str4 + s.charAt(i);
			}
			else str3 = str3 + s.charAt(i);
		}
		
		System.out.println("The String is :" + s);
		System.out.println("The Vowels in the String :" + str4);
		System.out.println("The Reverse String is :" + str3);
		System.out.println("No of 'a' in the String: " + cnt_a);
		System.out.println("No of 'e' in the String: " + cnt_e);
		System.out.println("No of 'i' in the String: " + cnt_i);
		System.out.println("No of 'o' in the String: " + cnt_o);
		System.out.println("No of 'u' in the String: " + cnt_u);		
	
	}
	
}
