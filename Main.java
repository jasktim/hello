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
		// �����������֤��
		Scanner scanner = new Scanner(System.in);
		String idNumber = scanner.nextLine();

		// �������һλΪ x �������Сдת��д
		idNumber = idNumber.toUpperCase();

		// �ж����֤���Ƿ�Ϸ�
		try {
			if (check.judId(idNumber)) {
				getInformation.result(idNumber);
				scanner.close();
			} else
				System.out.println("���֤������\n������������ȷ�����֤�ţ�");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		System.out.println("�������������֤�ţ�");
		while (true) {
			login();
		}

	}
}