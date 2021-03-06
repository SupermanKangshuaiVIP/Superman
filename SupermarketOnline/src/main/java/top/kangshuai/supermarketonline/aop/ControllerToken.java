package top.kangshuai.supermarketonline.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.kangshuai.supermarketonline.base.BaseAop;
import top.kangshuai.supermarketonline.base.BaseModel;
import top.kangshuai.supermarketonline.entity.TbToken;
import top.kangshuai.supermarketonline.service.AopService;
import top.kangshuai.supermarketonline.utils.JsonMessage;

/**
 * -控制器token处理
 *
 * @author DarkKnight
 *
 */
@Aspect
@Component
public class ControllerToken extends BaseAop {
  @Autowired
  private AopService aopService;

  /**
   * -处理客户端提交的Token
   *
   * @param pjp
   * @return
   * @throws Exception
   */
  private TbToken processInputToken(ProceedingJoinPoint pjp) throws Exception {
    TbToken token = null;
    BaseModel model = null;
    // 校验是否存在BaseModel参数
    boolean haveBaseModel = false;
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseModel) {
        // 获取客户端token
        haveBaseModel = true;
        model = (BaseModel) arg;
        token = model.makeTbToken();
        break;
      }
    }
    // 处理token信息更新
    token = aopService.createOrUpdateToken(token);
    if (haveBaseModel) {
      // 更新model中的token信息
      model.setToken(token.getToken());
    }
    return token;
  }

  /**
   * -处理应答的Token信息
   *
   * @param result
   * @param token
   * @throws Exception
   */
  private void processResponseToken(Object result, TbToken token) throws Exception {
    // 回发token信息
    if (result instanceof JsonMessage && token != null) {
      JsonMessage json = (JsonMessage) result;
      json.setToken(token.getToken());
    }
  }

  /**
   * -控制器token相关切面处理
   * 
   * @param pjp
   * @return
   * @throws Throwable
   */
  @Around("controllerPointcut()")
  public Object token(ProceedingJoinPoint pjp) throws Throwable {
    TbToken token = processInputToken(pjp);
    Object result = null;
    // 处理业务逻辑
    result = pjp.proceed();
    // 回发token信息
    processResponseToken(result, token);
    return result;
  }

}
