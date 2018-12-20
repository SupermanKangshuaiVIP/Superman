package top.kangshuai.supermarketonline.model;

import top.kangshuai.supermarketonline.base.BasePageModel;
import top.kangshuai.supermarketonline.entity.TbSubType;
/**
 * 
 * @author kangshuai
 *
 */
public class TbSubTypeModel extends BasePageModel {

  private static final long serialVersionUID = -2295604230705488333L;

  private TbSubType subType = new TbSubType();

  public TbSubTypeModel() {
  }

  public TbSubType getSubType() {
    return subType;
  }

  public void setSubType(TbSubType subType) {
    this.subType = subType;
  }
  
}
