package net.yrannosaurus.common.exception;

import lombok.extern.slf4j.Slf4j;
import net.yrannosaurus.common.core.ResultDataBean;
import net.yrannosaurus.common.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultDataBean exceptionHandler(Exception e, HttpServletRequest request){
        ResultDataBean resultDataBean = ResultDataBean.builder().build();
        resultDataBean.setSign("FAIL");
        if(e instanceof  SpringCloudException){
            log.error("异常状态码：{},异常信息提示：{},请求路径：{}",((SpringCloudException) e).getCode(),e.getMessage(),request.getRequestURI());
            resultDataBean.setCode(((SpringCloudException)e).getCode());
            resultDataBean.setMessage(e.getMessage());
        }else{
            resultDataBean.setCode(CodeEnum.SYS_ERROR.getCode());
            resultDataBean.setMessage(CodeEnum.SYS_ERROR.getMsg());
        }
        return resultDataBean;
    }
}
