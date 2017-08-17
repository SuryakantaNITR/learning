package com.learning.theory;

import java.io.Console;

public class ConsolePackage {
	public static void main(String[] args) {
		Console c = System.console();
		char[] password;
		password = c.readPassword("%s", "pw: ");
		for(char ch: password)
			c.format("%c ", ch);
		c.format("\n");
	}

}
