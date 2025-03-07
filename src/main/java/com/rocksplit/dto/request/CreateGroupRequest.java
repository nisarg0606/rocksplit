package com.rocksplit.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroupRequest {
    
    @NotBlank(message = "Group name is required")
    @Size(min = 3, max = 100, message = "Group name must be between 3 and 100 characters")
    private String name;
    
    private String description;
    
    @NotEmpty(message = "At least one member is required")
    private List<String> memberIds;
    
    private String currency = "USD";
    
    private String groupImage;
}