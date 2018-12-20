package top.kangshuai.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.kangshuai.supermarketonline.model.TbTypeModel;
import top.kangshuai.supermarketonline.service.TypeService;
import top.kangshuai.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author kangshuai
 *
 */
@RestController
@RequestMapping("/type")
public class TypeController {
  @Autowired
  private TypeService typeService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbTypeModel model) throws Exception {
    return typeService.queryAll(model);
  }

  @RequestMapping("/add")
  public JsonMessage add(TbTypeModel model) throws Exception {
    return typeService.add(model);
  }

  @RequestMapping("/queryByKey")
  public JsonMessage queryByKey(TbTypeModel model) throws Exception {
    return typeService.queryByKey(model);
  }

  @RequestMapping("/delete")
  public JsonMessage delete(TbTypeModel model) throws Exception {
    return typeService.delete(model);
  }

  @RequestMapping("/undelete")
  public JsonMessage undelete(TbTypeModel model) throws Exception {
    return typeService.undelete(model);
  }

  @RequestMapping("/update")
  public JsonMessage update(TbTypeModel model) throws Exception {
    return typeService.update(model);
  }

}
