package main.model; // تحديد الباكدج (لازم نفس مكان الملف)

import java.time.LocalDate; // استيراد LocalDate للتعامل مع التواريخ

public class order { // كلاس يمثل طلب شراء

    private int orderId; // رقم الطلب
    private String username; // اسم العميل اللي عمل الطلب
    private Product product; // المنتج نفسه (مش اسمه بس)
    private int quantity; // الكمية المطلوبة
    private double totalPrice; // السعر الكلي
    private LocalDate orderDate; // تاريخ الطلب

    public order(int orderId, String username, Product product, int quantity) { // constructor لإنشاء طلب

        this.orderId = orderId; // تخزين رقم الطلب
        this.username = username; // تخزين اسم المستخدم
        this.product = product; // تخزين المنتج كامل (object)
        this.quantity = quantity; // تخزين الكمية
        this.totalPrice = product.getPrice() * quantity; // حساب السعر الكلي
        this.orderDate = LocalDate.now(); // تاريخ الطلب (اليوم)

    }

    public int getOrderId() { // ترجع رقم الطلب
        return orderId;
    }

    public String getUsername() { // ترجع اسم المستخدم
        return username;
    }

    public Product getProduct() { // ترجع المنتج
        return product;
    }

    public int getQuantity() { // ترجع الكمية
        return quantity;
    }

    public double getTotalPrice() { // ترجع السعر الكلي
        return totalPrice;
    }

    public LocalDate getOrderDate() { // ترجع تاريخ الطلب
        return orderDate;
    }

    @Override
    public String toString() { // تحويل الطلب لنص (مهم للـ report)
        return "Order{" +
                "id=" + orderId +
                ", user='" + username + '\'' +
                ", product='" + product.getName() + '\'' +
                ", quantity=" + quantity +
                ", total=" + totalPrice +
                ", date=" + orderDate +
                '}';
    }
}