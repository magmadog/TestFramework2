package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Token {
    @SerializedName("status")
    private String status;
    @SerializedName("generatedToken")
    private String generatedToken;
}
