package main.model; // الباكدج بتاع الكلاس (مكانه في المشروع)

public class client { // كلاس يمثل العميل

    private String username; // متغير لتخزين اسم المستخدم
    private String password; // متغير لتخزين كلمة المرور

    public client(String username, String password) { // constructor لإنشاء عميل جديد
        this.username = username; // تخزين الاسم داخل الكائن
        this.password = password; // تخزين الباسورد داخل الكائن
    }

    public String getUsername() { // ميثود ترجع اسم المستخدم
        return username; // ترجيع الاسم
    }

    public String getPassword() { // ميثود ترجع الباسورد
        return password; // ترجيع الباسورد
    }

    public void editData(String newUsername, String newPassword) { // تعديل بيانات العميل
        this.username = newUsername; // تحديث الاسم
        this.password = newPassword; // تحديث الباسورد
    }
}