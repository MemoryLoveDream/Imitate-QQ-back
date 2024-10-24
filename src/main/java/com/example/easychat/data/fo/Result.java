package com.example.easychat.data.fo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success() { return new Result<>(200, "成功！"); }

    public static <T> Result<T> error(int code) {
        return new Result<>(code, "失败！");
    }

    public static <T> Result<T> success(T data) { return new Result<>(200, "成功！", data); }

    public static <T> Result<T> error(String message) {
        return new Result<>(500, message);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> error(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> depends(boolean bool) {
        if (bool) return Result.success();
        else return Result.error(500);
    }

    public static <T> Result<T> depends(T data) {
        if (data != null) return Result.success(data);
        else return Result.error(500);
    }

    public static <T> Result<List<T>> depends(List<T> list) {
        if (!list.isEmpty()) return Result.success(list);
        else return Result.error(500);
    }

}
