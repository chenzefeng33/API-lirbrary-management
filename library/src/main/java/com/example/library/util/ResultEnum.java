package com.example.library.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author RukunHe
 */

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(200, "成功"),
    INTERNAL_SERVER_ERROR(500, "失败"),
    UNAUTHORIZED(401, "还未授权，不能访问");

    private final int code;
    private final String msg;
}
