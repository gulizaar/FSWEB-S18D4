package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void validate(Burger burger) {

        if (burger == null) {
            throw new BurgerException(
                    "Burger boş olamaz",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (burger.getName() == null || burger.getName().isBlank()) {
            throw new BurgerException(
                    "Burger adı boş olamaz",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (burger.getPrice() <= 0) {
            throw new BurgerException(
                    "Burger fiyatı 0'dan büyük olmalıdır",
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
