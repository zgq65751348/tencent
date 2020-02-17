package net.yrannosaurus.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SpringCloudException extends  RuntimeException {

    private String code;

    public  SpringCloudException(String code,String message){
        super(message);
        this.code = code;
    }
}
