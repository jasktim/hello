package check;

import static java.util.regex.Pattern.compile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check {

	// ��ȡ�ַ����ķ���
	public static String Str(String str, int a, int b) {
		b++;
		return str.substring(a, b);
	}

	// �ж����֤�����Ƿ���ȷ
	public static boolean judId(String idNumber) throws ParseException {
		String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };
		String Ai = "";
		// ����ĳ���18λ
		if (idNumber.length() != 18) {
			return false;
		}
		// ���� �����һλ��Ϊ����
		if (idNumber.length() == 18) {
			Ai = idNumber.substring(0, 17);
		}
		if (isNumeric(Ai) == false) {
			// errorInfo = "���֤15λ���붼ӦΪ���� ; 18λ��������һλ�⣬��ӦΪ���֡�";
			return false;
		}
		// ���������Ƿ���Ч
		String strYear = Ai.substring(6, 10);// ���
		String strMonth = Ai.substring(10, 12);// �·�
		String strDay = Ai.substring(12, 14);// ��
		if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
			// ���֤������Ч
			return false;
		}

		// �ж����֤���Ƿ�Ϸ�
		// ϵ���㷨
		String tempId = Str(idNumber, 0, 16);
		int[] coeff = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		char[] end = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		int sum = 0;
		for (int i = 0; i < tempId.length(); i++) {
			int bye = tempId.charAt(i) - '0';
			sum += bye * coeff[i];
		}
		sum %= 11;
		if (end[sum] != Str(idNumber, 17, 17).charAt(0))
			return false;

		// �ж����֤�����Ƿ�����Ч��Χ
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
					|| (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
				// errorInfo = "��";
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
		// errorInfo = "���֤�·���Ч";
			return false;
		}
		if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
		// errorInfo = "���֤������Ч";
			return false;
		}

//        // �жϵ������Ƿ���Ч
//        Hashtable h = GetAreaCode();
//        if (h.get(Ai.substring(0, 2)) == null) {
//            //errorInfo = "���֤�����������";
//            return false;
//        }

		// �ж����һλ��ֵ
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String strVerifyCode = ValCodeArr[modValue];
		Ai = Ai + strVerifyCode;

		if (idNumber.length() == 18) {
			if (Ai.equals(idNumber) == false) {
				// ���֤��Ч�����ǺϷ������֤����
				return false;
			}
		} else {
			return true;
		}
		return true;
	}

	// �ж��ַ����Ƿ�Ϊ����
	private static boolean isNumeric(String str) {
		Pattern pattern = compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}

	// �ж��ַ����Ƿ�Ϊ���ڸ�ʽ
	public static boolean isDate(String strDate) {
		Pattern pattern = compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

}

class IdNumberValidator {
    protected boolean isValidLength(String idNumber) {
        return  idNumber.length() == 18;
    }

    public boolean validate(String idNumber) {
        if (!isValidLength(idNumber)) {
            return false;
        }
        return true;
    }}