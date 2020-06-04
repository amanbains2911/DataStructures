package com.aman.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mach {

	private static final Map<Character, Character> map1 = new HashMap<>();
	private static final Set<Character> op = new HashSet<>();

	static {
		map1.put(')', '(');
		map1.put('}', '{');
		map1.put(']', '[');
		op.addAll(map1.values());

	}

	public static boolean hasMatch(String input) {
		try {
			Stack<Character> p1 = new Stack<>();
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (op.contains(ch)) {
					p1.push(ch);
				}
				if (map1.containsKey(ch)) {
					Character last = p1.pop();
					if (last != map1.get(ch)) {
						return false;
					}
				}
			}
			return p1.isEmpty();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static void main(String[] args) {
		boolean aman = hasMatch("(ABC){} [DEF]");
		System.out.println("Value -->" + aman);
	}
}
