package main.model; // بنحدد اسم الباكدج (المسار) ولازم يكون نفس مكان الملف في الفولدرات بالظبط
import java.time.LocalDate; // بنستورد كلاس LocalDate علشان نتعامل مع التواريخ (انتاج / انتهاء)

public class Product { // تعريف كلاس اسمه Product بيمثل المنتج

    private int id; // رقم مميز لكل منتج
    private String name; // اسم المنتج
    private int quantity; // الكمية الموجودة في المخزن
    private double price; // سعر المنتج
    private String category; // نوع المنتج (تصنيف)
    private LocalDate productionDate; // تاريخ انتاج المنتج
    private LocalDate expiryDate; // تاريخ انتهاء المنتج

    public Product(int id, String name, int quantity, double price, String category, LocalDate productionDate,
            LocalDate expiryDate) { // الكونستركتور اللي بنعمل بيه object جديد من المنتج

        this.id = id; // بنخزن قيمة ال id في المتغير الداخلي
        this.name = name; // بنخزن اسم المنتج
        this.quantity = quantity; // بنخزن الكمية
        this.price = price; // بنخزن السعر
        this.category = category; // بنخزن التصنيف
        this.productionDate = productionDate; // بنخزن تاريخ الانتاج
        this.expiryDate = expiryDate; // بنخزن تاريخ الانتهاء

    }

    public int getId() { // ميثود بترجع id المنتج
        return id; // بيرجع قيمة ال id
    }

    public String getName() { // ميثود بترجع اسم المنتج
        return name; // بيرجع الاسم
    }

    public int getQuantity() { // ميثود بترجع الكمية
        return quantity; // بيرجع الكمية
    }

    public double getPrice() { // ميثود بترجع السعر
        return price; // بيرجع السعر
    }

    public String getCategory() { // ميثود بترجع التصنيف
        return category; // بيرجع التصنيف
    }

    public LocalDate getProductionDate() { // ميثود بترجع تاريخ الانتاج
        return productionDate; // بيرجع التاريخ
    }

    public LocalDate getExpiryDate() { // ميثود بترجع تاريخ الانتهاء
        return expiryDate; // بيرجع التاريخ
    }

    public void setId(int id) { // ميثود لتعديل id
        this.id = id; // بيغير قيمة ال id
    }

    public void setName(String name) { // ميثود لتعديل الاسم
        this.name = name; // بيغير الاسم
    }

    public void setQuantity(int quantity) { // ميثود لتعديل الكمية
        this.quantity = quantity; // بيغير الكمية
    }

    public void setPrice(double price) { // ميثود لتعديل السعر
        this.price = price; // بيغير السعر
    }

    public void setCategory(String category) { // ميثود لتعديل التصنيف
        this.category = category; // بيغير التصنيف
    }

    public void setProductionDate(LocalDate productionDate) { // ميثود لتعديل تاريخ الانتاج
        this.productionDate = productionDate; // بيغير التاريخ
    }

    public void setExpiryDate(LocalDate expiryDate) { // ميثود لتعديل تاريخ الانتهاء
        this.expiryDate = expiryDate; // بيغير التاريخ
    }

    @Override // بنعمل override لدالة toString اللي جاية من Object
    public String toString() { // دالة بترجع شكل المنتج كنص
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", quantity=" + quantity + ", price=" + price
                + ", category='" + category + '\'' + ", productionDate=" + productionDate + ", expiryDate=" + expiryDate
                + '}'; // بيرجع نص منظم فيه كل بيانات المنتج
    }

}