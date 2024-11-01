package com.apirest.ariesbackend.ApiKeys.KeysService;

import org.springframework.stereotype.Service;

import com.apirest.ariesbackend.ApiKeys.Keys.ApiKey;
import com.apirest.ariesbackend.ApiKeys.KeysRepository.ApiKeyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService{

    private final ApiKeyRepository apiKeyRepository;

    @Override
    public String findKeyValueByApiKeyName(String apiKeyName) {
        ApiKey apiKey = apiKeyRepository.findByApiKeyName(apiKeyName);
        return apiKey != null ? apiKey.getKeyValue() : null;
    }

}

