package com.example.uberprojectentity.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OTP extends BaseModel{
    private String code;

    private String sendToNumber;

    private static OTP make(String phoneNumber) {
        Random random = new Random();
        Integer code = random.nextInt(9000)+1000;
        return OTP.builder().code(code.toString()).sendToNumber(phoneNumber).build();
    }

}
