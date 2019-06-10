package org.fkjava.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="查询数据失败")
public class BookException extends RuntimeException {


}
