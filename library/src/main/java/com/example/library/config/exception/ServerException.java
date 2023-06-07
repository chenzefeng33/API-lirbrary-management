package com.example.library.config.exception;

import com.example.library.util.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.whms.framework.common.exception 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServerException extends RuntimeException {

        private int code;
        private String msg;

        public ServerException(String msg) {
            super(msg);
            this.code = ResultEnum.INTERNAL_SERVER_ERROR.getCode();
            this.msg = msg;
        }

        public ServerException(Integer resCode, String resMsg) {
            super(resMsg);
            this.code = resCode;
            this.msg = resMsg;
        }
}
