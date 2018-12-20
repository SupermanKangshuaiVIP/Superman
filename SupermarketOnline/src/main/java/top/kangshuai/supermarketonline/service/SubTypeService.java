package top.kangshuai.supermarketonline.service;

import top.kangshuai.supermarketonline.model.TbSubTypeModel;
import top.kangshuai.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author kangshuai
 *
 */
public interface SubTypeService {

  JsonMessage disable(TbSubTypeModel model) throws Exception;

  JsonMessage enable(TbSubTypeModel model) throws Exception;

  JsonMessage update(TbSubTypeModel model) throws Exception;

  JsonMessage add(TbSubTypeModel model) throws Exception;

  JsonMessage queryAll(TbSubTypeModel model) throws Exception;

}
