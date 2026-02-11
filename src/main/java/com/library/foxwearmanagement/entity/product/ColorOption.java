package com.library.foxwearmanagement.entity.product;

import com.library.foxwearmanagement.entity.enums.WearSize;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_color_option", schema = "products")
public class ColorOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String colorName;
    Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "size", referencedColumnName = "id")
    WearSize size;

    Double price;
    Double discountedPrice; // ? endirim tətbiq olunandan sonrakı qiymət

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    Boolean active = true;

    String imageUrl;

    @PrePersist
    @PreUpdate
    public void calculateDiscountedPrice() {
        if (this.product != null && this.product.getDiscount() != null && this.product.getDiscount() > 0) {
            // ? Məhsulun endirimi varsa, qiymətə endirim əlavə et
            this.discountedPrice = this.price * (1 - this.product.getDiscount() / 100.0);
        } else {
            // ? Endirim yoxdursa, qiyməti olduğu kimi saxla
            this.discountedPrice = this.price;
        }

        active = stockQuantity != null && stockQuantity > 0;
    }
}
