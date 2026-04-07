package main.service; // دي الباكدج ولازم تطابق مكان الملف في الفولدر

import main.model.Product; // بنستورد كلاس Product علشان نستخدمه هنا

import java.util.ArrayList; // علشان نستخدم ArrayList لتخزين المنتجات
import java.util.List; // علشان نستخدم List (interface)

public class ProductService { // تعريف كلاس مسؤول عن إدارة المنتجات

    private List<Product> products = new ArrayList<>(); // ليستة بنخزن فيها كل المنتجات

    //إضافة منتج
    public void addProduct(Product product) { // ميثود بتستقبل object من Product

        for (Product p : products) { // بنلف على كل المنتجات الموجودة
            if (p.getId() == product.getId()) { // لو فيه منتج بنفس ال id
                System.out.println("Product with this ID already exists"); // نطبع رسالة
                return; // نخرج من الميثود ومش نضيف المنتج
            }
        }

        products.add(product); // بنضيف المنتج في الليستة
        System.out.println("Product added successfully"); // رسالة تأكيد
    }

    //عرض كل المنتجات
    public List<Product> getAllProducts() { // ميثود بترجع كل المنتجات
        return products; // بيرجع الليستة
    }

    //تعديل منتج باستخدام id
    public void updateProduct(int id, String name, int quantity, double price) { // ميثود لتعديل المنتج

        for (Product p : products) { // بنلف على كل المنتجات
            if (p.getId() == id) { // لو لقينا المنتج المطلوب

                p.setName(name); // نغير الاسم
                p.setQuantity(quantity); // نغير الكمية
                p.setPrice(price); // نغير السعر

                System.out.println("Product updated successfully"); // رسالة نجاح
                return; // نخرج بعد التعديل
            }
        }

        System.out.println("Product not found"); // لو ملقيناش المنتج
    }

    //حذف منتج باستخدام id
    public void deleteProduct(int id) { // ميثود لحذف المنتج

        for (Product p : products) { // بنلف على المنتجات
            if (p.getId() == id) { // لو لقينا المنتج

                products.remove(p); // نحذفه من الليستة
                System.out.println("Product deleted successfully"); // رسالة نجاح
                return; // نخرج
            }
        }

        System.out.println("Product not found"); // لو مش موجود
    }

    //البحث بالاسم
    public List<Product> searchByName(String name) { // ميثود ترجع منتجات بالاسم

        List<Product> result = new ArrayList<>(); // ليستة جديدة نحط فيها النتائج

        for (Product p : products) { // بنلف على كل المنتجات
            if (p.getName().toLowerCase().contains(name.toLowerCase())) { // لو الاسم فيه نفس النص
                result.add(p); // نضيفه في النتيجة
            }
        }

        return result; // نرجع النتائج
    }

    //البحث بالتصنيف
    public List<Product> searchByCategory(String category) { // ميثود ترجع حسب التصنيف

        List<Product> result = new ArrayList<>(); // ليستة للنتائج

        for (Product p : products) { // بنلف على المنتجات
            if (p.getCategory().equalsIgnoreCase(category)) { // لو نفس التصنيف
                result.add(p); // نضيفه
            }
        }

        return result; // نرجع النتيجة
    }

    //البحث بتاريخ الانتهاء
    public List<Product> searchByExpiryDate(java.time.LocalDate date) { // ميثود للبحث بالتاريخ

        List<Product> result = new ArrayList<>(); // ليستة للنتائج

        for (Product p : products) { // بنلف على المنتجات
            if (p.getExpiryDate().isBefore(date)) { // لو تاريخ الانتهاء قبل التاريخ المحدد
                result.add(p); // نضيفه
            }
        }

        return result; // نرجع النتيجة
    }

    //تنبيه المنتجات القريبة من الانتهاء
    public void checkExpiry() { // ميثود للتنبيه

        java.time.LocalDate today = java.time.LocalDate.now(); // بنجيب تاريخ اليوم

        for (Product p : products) { // بنلف على المنتجات
            if (p.getExpiryDate().isBefore(today.plusDays(7))) { // لو فاضل أقل من 7 أيام
                System.out.println("Product قريب من الانتهاء: " + p.getName()); // نطبع تنبيه
            }
        }
    }

    //تنبيه الكمية القليلة
    public void checkLowStock() { // ميثود للتنبيه

        for (Product p : products) { // بنلف على المنتجات
            if (p.getQuantity() <= 5) { // لو الكمية قليلة
                System.out.println("Product الكمية قليلة: " + p.getName()); // نطبع تنبيه
            }
        }
    }
}