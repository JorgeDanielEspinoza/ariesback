package com.apirest.ariesbackend.ApiKeys.KeysRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.ariesbackend.ApiKeys.Keys.ApiKey;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, Integer>  {
    ApiKey findByApiKeyName(String apiKeyName);
}

