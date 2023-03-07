/**
 * @author fkw
 * @description
 * @data 2023/02/21 18:21
 **/
package check;

import java.text.ParseException;
import java.util.Scanner;

import user.Person;

public class Main {

	
	public static void login() {
		// 键盘输入身份证号
		Scanner scanner = new Scanner(System.in);
		String idNumber = scanner.nextLine();

		// 处理最后一位为 x 的情况，小写转大写
		idNumber = idNumber.toUpperCase();

		// 判断身份证号是否合法
		try {
			if (check.judId(idNumber)) {
				getInformation.result(idNumber);
				scanner.close();
			} else
				System.out.println("身份证号有误！\n请重新输入正确的身份证号！");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		System.out.println("请输入您的身份证号：");
		while (true) {
			login();
		}

	}
}