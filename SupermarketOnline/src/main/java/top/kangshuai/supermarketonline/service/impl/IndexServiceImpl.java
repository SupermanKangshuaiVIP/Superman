package top.kangshuai.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kangshuai.supermarketonline.config.MyConfig;
import top.kangshuai.supermarketonline.converter.DateConverter;
import top.kangshuai.supermarketonline.dao.UtilsDAO;
import top.kangshuai.supermarketonline.service.IndexService;
import top.kangshuai.supermarketonline.utils.JsonMessage;

/**
 *
 * @author DarkKnight
 *
 */
@Service
public class IndexServiceImpl implements IndexService {
  @Autowired
  private MyConfig myConfig;
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index() throws Exception {
    JsonMessage message = JsonMessage.getSuccess(String.format("欢迎使用%s，%s", myConfig.appName, DateConverter.SDF_LONG.format(utilsDAO.queryTime())));
    return message;
  }

}
