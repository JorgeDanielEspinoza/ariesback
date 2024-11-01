package com.apirest.ariesbackend.ApiKeys.KeysController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.ariesbackend.ApiKeys.KeysService.ApiKeyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/keys")
@CrossOrigin
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    
    @GetMapping("/{apiKeyName}")
    public String getKeyValueByApiKeyName(@PathVariable String apiKeyName) {
        return apiKeyService.findKeyValueByApiKeyName(apiKeyName);
    }
}
