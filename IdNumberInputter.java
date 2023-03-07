/*
 * package check;
 * 
 * import java.util.Scanner;
 * 
 * public class IdNumberInputter { private Scanner scanner; private
 * IdNumberValidator validator;
 * 
 * public IdNumberInputter() { this(new Scanner(System.in), new
 * IdNumberValidator() {}); }
 * 
 * public IdNumberInputter(Scanner scanner, IdNumberValidator validator) {
 * this.scanner = scanner; this.validator = validator; }
 * 
 * public void start() { System.out.println("请输入您的身份证号："); while
 * (scanner.hasNext()) { String idNumber = scanner.nextLine().toUpperCase(); if
 * (validator.validate(idNumber)) { getInformation.result(idNumber);
 * scanner.close(); break; } else {
 * System.out.println("身份证号有误！\n请重新输入正确的身份证号："); } } } }
 */