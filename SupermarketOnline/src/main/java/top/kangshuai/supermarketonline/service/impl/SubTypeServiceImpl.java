package top.kangshuai.supermarketonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.kangshuai.supermarketonline.dao.TbSubTypeDAO;
import top.kangshuai.supermarketonline.entity.TbSubType;
import top.kangshuai.supermarketonline.entity.TbType;
import top.kangshuai.supermarketonline.model.TbSubTypeModel;
import top.kangshuai.supermarketonline.service.SubTypeService;
import top.kangshuai.supermarketonline.utils.JsonMessage;
import top.kangshuai.supermarketonline.utils.MyUtils;
import top.kangshuai.supermarketonline.utils.PageBean;
/**
 * 
 * @author kangshuai
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SubTypeServiceImpl implements SubTypeService {

  @Autowired
  private TbSubTypeDAO tbSubTypeDAO;

  @Override
  public JsonMessage queryAll(TbSubTypeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    // 查询分类信息
    List<TbType> types = tbSubTypeDAO.queryTypes();
    message.put("types", types);
    // 查询小类信息
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbSubType> list = (Page<TbSubType>) tbSubTypeDAO.queryAll();
    message.put("page", page);
    message.put("list", list);
    return message;
  }

  @Override
  public JsonMessage add(TbSubTypeModel model) throws Exception {
    TbSubType subType=model.getSubType();
    if (subType.getTid()==null||subType.getTid()<1) {
      return JsonMessage.getFail("必须选择类型!");
    }
    if (MyUtils.isEmpty(subType.getSubName())) {
      return JsonMessage.getFail("名称必须填写!");
    }
    if (MyUtils.isEmpty(subType.getSubInfo())) {
      return JsonMessage.getFail("描述必须填写!");
    }
    if (tbSubTypeDAO.queryByTidSubName(subType)!=null) {
      return JsonMessage.getFail("类型以存在");
    }
    int result = tbSubTypeDAO.add(subType);
    return result == 1 ? JsonMessage.getSuccess("添加成功") : JsonMessage.getFail("添加失败");
  }

  @Override
  public JsonMessage update(TbSubTypeModel model) throws Exception {
    int result = tbSubTypeDAO.update(model.getSubType());
    return result == 1 ? JsonMessage.getSuccess("修改成功") : JsonMessage.getFail("修改失败");
  }

  @Override
  public JsonMessage enable(TbSubTypeModel model) throws Exception {
    model.getSubType().setIsEnable("y");
    int result = tbSubTypeDAO.updateIsEnable(model.getSubType());
    return result == 1 ? JsonMessage.getSuccess("启用成功") : JsonMessage.getFail("启用失败");
  }

  @Override
  public JsonMessage disable(TbSubTypeModel model) throws Exception {
    model.getSubType().setIsEnable("n");
    int result = tbSubTypeDAO.updateIsEnable(model.getSubType());
    return result == 1 ? JsonMessage.getSuccess("禁用成功") : JsonMessage.getFail("禁用失败");
  }

}
