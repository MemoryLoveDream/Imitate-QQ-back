package com.example.easychat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService<T> {

    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    //value
    public Long increment(String key, Long v) { return redisTemplate.opsForValue().increment(key, v); }

    public void set(String key, T value) { redisTemplate.opsForValue().set(key, value); }

    public void set(String key, T value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void set(String key, T value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public T get(String key) { return redisTemplate.opsForValue().get(key); }

    public boolean expire(String key, long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    public boolean expire(String key, long timeout, TimeUnit unit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }

    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    public Long delete(Collection<String> collection) { return redisTemplate.delete(collection); }

    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    //list
    public Long setCacheList(String key, List<T> dataList) { return redisTemplate.opsForList().rightPushAll(key, dataList); }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public List<T> getCacheList(final String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

//    /**
//     * 缓存Set
//     *
//     * @param key     缓存键值
//     * @param dataSet 缓存的数据
//     * @return 缓存数据的对象
//     */
//    public BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet) {
//        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
//        Iterator<T> it = dataSet.iterator();
//        while (it.hasNext()) {
//            setOperation.add(it.next());
//        }
//        return setOperation;
//    }
//
//    /**
//     * 获得缓存的set
//     *
//     * @param key
//     * @return
//     */
//    public Set<T> getCacheSet(String key) {
//        return redisTemplate.opsForSet().members(key);
//    }
//
//    /**
//     * 增加缓存set
//     */
//    public Long addCacheSetValue(String key, T data) {
//        return redisTemplate.opsForSet().add(key, data);
//    }
//
//    /**
//     * 是否存在set值
//     */
//    public Boolean isSetValue(final String key, final String sValue) {
//        return redisTemplate.opsForSet().isMember(key, sValue);
//    }
//
//    /**
//     * 缓存Map
//     *
//     * @param key
//     * @param dataMap
//     */
//    public void setCacheMap(String key, Map<String, T> dataMap) {
//        if (dataMap != null) {
//            redisTemplate.opsForHash().putAll(key, dataMap);
//        }
//    }
//
//
//    /**
//     * 获得缓存的Map
//     *
//     * @param key
//     * @return
//     */
//    public Map<String, T> getCacheMap(String key) {
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//    /**
//     * 往Hash中存入数据
//     *
//     * @param key   Redis键
//     * @param hKey  Hash键
//     * @param value 值
//     */
//    public void setCacheMapValue(String key, String hKey, T value) {
//        redisTemplate.opsForHash().put(key, hKey, value);
//    }
//
//    /**
//     * 删除Hash中的数据
//     *
//     * @param key   Redis键
//     * @param hKey  Hash键
//     */
//    public void deleteCacheMapValue(String key, String hKey) {
//        redisTemplate.opsForHash().delete(key, hKey);
//    }
//
//    /**
//     * 获取Hash中的数据
//     *
//     * @param key  Redis键
//     * @param hKey Hash键
//     * @return Hash中的对象
//     */
//    public T getCacheMapValue(String key, String hKey) {
//        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
//        return opsForHash.get(key, hKey);
//    }
//
//
//    /**
//     * 调用方法实现对 Hash 对应的 key 的值操作
//     *
//     * @param key
//     * @param hKey
//     * @param v
//     */
//    public void incrementCacheMapValue(String key, String hKey, int v) {
//        redisTemplate.opsForHash().increment(key, hKey, v);
//    }
//
//    /**
//     * 删除Hash中的数据
//     * @param key
//     * @param hashKey
//     */
//    public void delCacheMapValue(String key, String hashKey) {
//        redisTemplate.opsForHash().delete(key, hashKey);
//    }
//
//    /**
//     * 获取多个Hash中的数据
//     * @param key   Redis键
//     * @param hKeys Hash键集合
//     * @return Hash对象集合
//     */
//    public List<T> getMultiCacheMapValue(String key, Collection<T> hKeys) {
//        return redisTemplate.opsForHash().multiGet(key, hKeys);
//    }
//
//    /**
//     * 获得缓存的基本对象列表
//     * @param pattern 字符串前缀
//     * @return 对象列表
//     */
//    public Collection<String> keys(String pattern) {
//        return redisTemplate.keys(pattern);
//    }

}