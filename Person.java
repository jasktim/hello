/**
 * @author fkw
 * @description
 * @data 2023/02/22 23:23
 **/
package user;

public class Person {
    protected static String nativePlace;
    protected static String birthday;
    protected static String age;
    protected static String gender;
    protected static String constellation;
    protected static String zodia;

    public Person() {
    }

    public Person(String nativePlace, String birthday, String age, String gender, String constellation, String zodia) {
        this.nativePlace = nativePlace;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.constellation = constellation;
        this.zodia = zodia;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getZodia() {
        return zodia;
    }

    public void setZodia(String zodia) {
        this.zodia = zodia;
    }
    
    @Override
    public String toString() {
        return "个人信息:\n您的居住地：" + nativePlace +
        		"\n您的年龄：" + age + 
                "\n您的出生日期：" + birthday +
                "\n您的性别：" + gender +
                "\n您的星座：" + constellation +
                "\n您的生肖：" + zodia ;
    }
    
}

