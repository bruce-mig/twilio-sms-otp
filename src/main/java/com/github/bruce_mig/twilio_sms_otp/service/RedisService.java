package com.github.bruce_mig.twilio_sms_otp.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * Redis service class.
 *
 * @author Bruce Migeri
 */
@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Inserts a key-value pair into Redis with a TTL of 5 minutes.
     *
     * @param key   The key to insert.
     * @param value The value to insert.
     *
     */
    public void insertOTP(String key, String value) {
        // Set the key-value pair with a TTL of 5 minutes
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(5));
    }

    /**
     * Retrieves the value associated with a key from Redis.
     *
     * @param key The key to retrieve.
     * @return The value or null if not found.
     */
    public String getOTP(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * Deletes a key-value pair from Redis.
     *
     * @param key The key to delete.
     */
    public void deleteOTP(String key) {
        redisTemplate.delete(key);
    }
}
