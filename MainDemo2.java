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
			System.out.print("�������������֤�ţ�");
			String idNumber = scanner.nextLine();

			IDNumberVerifier verifier = new IDNumberVerifier(idNumber);

			try {
				if (verifier.isValid()) {
						System.out.println("���֤�ţ�" + idNumber + " ����Ϣ���£�");
//					System.out.println(verifier.getInfo());
						verifier.getInfo();

				} else {
					System.out.println("���֤������\n������������ȷ�����֤�ţ�");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
