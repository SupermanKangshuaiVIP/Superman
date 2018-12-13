package top.kangshuai.supermarketonline.service;

import top.kangshuai.supermarketonline.utils.JsonMessage;
import top.kangshuai.supermarketonline.utils.PageBean;

/**
 * - 测试服务
 *
 * @author DarkKnight
 *
 */
public interface TestService {

  /**
   * -分页查询token
   *
   * @param page
   * @return
   * @throws Exception
   */
  JsonMessage queryTokens(PageBean page) throws Exception;

}
