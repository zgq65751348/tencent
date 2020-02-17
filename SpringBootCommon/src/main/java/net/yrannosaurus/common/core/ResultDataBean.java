package net.yrannosaurus.common.core;

import lombok.*;
import net.yrannosaurus.common.enums.CodeEnum;
import java.io.Serializable;


@Data
//@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultDataBean<T> implements Serializable {

    private static final long serialVersionUID = 8676131899637805509L;

    // 返回编码
    private String code;
    // 返回信息
    private String message;
    // 签名
    @Builder.Default
    private String sign = "";
    // 返回数据封装
    @Builder.Default
    private   T  data = (T) "";

    public ResultDataBean() {
    }

    public static ResultDataBean builderEntity(Object data){
        ResultDataBean<Object> resultDataBean = new ResultDataBean<>();
        resultDataBean.setMessage(CodeEnum.OK.getMsg());
        resultDataBean.setCode(CodeEnum.OK.getCode());
        resultDataBean.setSign("SUCCESS");
        resultDataBean.setData(data);
        return  resultDataBean;
    }
}
