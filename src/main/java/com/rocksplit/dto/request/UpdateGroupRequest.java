package com.rocksplit.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UpdateGroupRequest {
    
    @Size(min = 3, max = 100, message = "Group name must be between 3 and 100 characters")
    private String name;
    
    private String description;
    
    private List<String> addMemberIds;
    
    private List<String> removeMemberIds;
    
    private String currency;
    
    private String groupImage;
}