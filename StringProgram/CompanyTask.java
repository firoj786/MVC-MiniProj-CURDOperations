package com.nt.pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CompanyTask {
public static void sortWord(String str) {
      Map<String, Integer> map = new HashMap<>();//2
       List<String> list = new ArrayList<>();//3
		String[] words = str.split(" ");//4
       for (String s : words) {//5,8
			int count = 1;//6
			if (map.containsKey(s)) {//6
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, count);//7,9
			}
		}
		String[] sArray = new String[map.size()];
     	int count = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				sArray[count] = entry.getKey();
				count++;
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() < 2) {
				sArray[count] = entry.getKey();
				count++;
			}

		}

		sort(sArray);
	}

	public static void sort(String[] sArray) {

		for (int i = 2; i < sArray.length - 1; i++) {

			for (int j = 2; j < sArray.length - i + 1; j++) {
				if (sArray[j].length() < sArray[j + 1].length()) {

					String temp = sArray[j];
					sArray[j] = sArray[j + 1];
					sArray[j + 1] = temp;
				}
			}
		}
		List<String> list = new ArrayList<>();

		for (String s : sArray) {
			list.add(s);
		}
		System.out.println(list);
	}
public static void main(String[] args) {
		sortWord("India is a great country and I will work towards making our country the better India");//1
	}
}
//[country, India, towards, making, better, great, will, work, our, the, and, is, a, I]
