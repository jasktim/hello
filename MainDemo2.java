package check;

import java.text.ParseException;
import java.util.Scanner;

public class MainDemo2 {
	private String idNumber;

	public void IDNumber(String idNumber) {
		this.idNumber = idNumber.toUpperCase();
	}

	public boolean isValid() throws ParseException {
		return check.judId(idNumber);
	}

	public void getInfo() throws ParseException {
//		return getInformation.result(idNumber);
		getInformation.result(idNumber);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("请输入您的身份证号：");
			String idNumber = scanner.nextLine();

			IDNumberVerifier verifier = new IDNumberVerifier(idNumber);

			try {
				if (verifier.isValid()) {
						System.out.println("身份证号：" + idNumber + " 的信息如下：");
//					System.out.println(verifier.getInfo());
						verifier.getInfo();

				} else {
					System.out.println("身份证号有误！\n请重新输入正确的身份证号！");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
