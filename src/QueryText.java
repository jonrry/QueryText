import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 题目：给定一个 query 和一个 text，均由小写字母组成。要求在 text 中找出以同样的顺序连续出现的
 * 最长连续字母序列的长度。
 * 
 * 例如：query 为 "acbac", text 为 "acaccbabb", 那么 text 中的 "cba" 为最长的连续出现在 query 中的字母序列。
 * 
 *  因此，返回结果应该为其长度为 3
 * 
 */



/**
 * 
 * @author Henry Luo
 *
 *@date: 2014/08/29
 *
 */

public class QueryText {

	
	public static void main(String[] args) throws IOException {
	
		String queryString = null;//查询字符串
		String textString = null;//父字符串
		
		StringBuffer queryBuffer = new StringBuffer();//用来连接 queryString 的所有连续的子串
		
		String[] arrayStrings = {};//接收 StringBuffer 分割后的字符数组（元素为所有子串）
		
		int maxNum = 0;//最后的最大长度
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//输入流
		
		System.out.println("input query string: \n");
		queryString = br.readLine();
		
		System.out.println("\ninput text string: ");
		textString = br.readLine();
		
		for (int i = 0; i < queryString.length(); i++) {
			for (int j = 0; j < queryString.length()-i; j++) {
				for (int k = j; k < j+i+1; k++) {
					//System.out.print(queryString.charAt(k));
					
					queryBuffer.append(queryString.charAt(k));
					
				}
				//System.out.print(",");
				queryBuffer.append(",");
				
			}
		}
		//System.out.println(queryBuffer.toString());

		arrayStrings = queryBuffer.toString().split(",");
		
		for (int i = 0; i < arrayStrings.length; i++) {
			//System.out.println(arrayStrings[i]);
			
			//存在这样的子串
			if (textString.indexOf(arrayStrings[i]) != -1) {
				//System.out.println(arrayStrings[i].length());
				
				if (maxNum < arrayStrings[i].length()) {
					maxNum = arrayStrings[i].length();
				}
			}
			
		}
		System.out.println("最大长度为：" + maxNum);
		
	}
	
}







/**
 * 下面的方法是根据网上一篇帖子修改而来，出处找不到了。。
 */


/*public class QueryText {
	//在动态规划矩阵生成方式当中，每生成一行，前面的那一行就已经没有用了，因此这里只需使用一维数组，而不是常用的二位数组
	public static void getLCString(char[] str1, char[] str2) {
		int len = 0;
		int len1, len2;
		len1 = str1.length;
		len2 = str2.length;
		int maxLen = len1 > len2 ? len1 : len2;

		int[] max = new int[maxLen];// 保存最长子串长度的数组
		int[] maxIndex = new int[maxLen];// 保存最长子串长度最大索引的数组
		int[] c = new int[maxLen];

		int i, j;
		for (i = 0; i < len2; i++) {
			for (j = len1 - 1; j >= 0; j--) {
				if (str2[i] == str1[j]) {
					if ((i == 0) || (j == 0))
						c[j] = 1;
					else
						c[j] = c[j - 1] + 1;//此时C[j-1]还是上次循环中的值，因为还没被重新赋值
				} else {
					c[j] = 0;
				}

				// 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
				if (c[j] > max[0]) {
					max[0] = c[j];
					maxIndex[0] = j;

					for (int k = 1; k < maxLen; k++) {
						max[k] = 0;
						maxIndex[k] = 0;
					}
				}
				// 有多个是相同长度的子串
				else if (c[j] == max[0]) {
					for (int k = 1; k < maxLen; k++) {
						if (max[k] == 0) {
							max[k] = c[j];
							maxIndex[k] = j;
							break; // 在后面加一个就要退出循环了
						}
					}
				}
			}
			for (int temp : c) {
				System.out.print(temp);
			}
			System.out.println();
		}
		
		
		
        //打印最长子字符串
		for (j = 0; j < maxLen; j++) {
			if (max[j] > 0) {
				System.out.println("第" + (j + 1) + "个公共子串:");
				for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++) {
					System.out.print(str1[i]);
					len++;
				}
				System.out.println("\n长度为：" + len);	
				System.out.println(" ");
			}
		}
	}

	public static void main(String[] args) throws IOException {

		String queryString = new String();
		String textString = new String();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//String str1 = new String("12");
		//String str2 = new String("34122");
		
		System.out.println("input query string: \n");
		queryString = br.readLine();
		
		System.out.println("input text string: \n");
		textString = br.readLine();
		
		//getLCString(str1.toCharArray(), str2.toCharArray());
		getLCString(queryString.toCharArray(), textString.toCharArray());
	}
}*/







