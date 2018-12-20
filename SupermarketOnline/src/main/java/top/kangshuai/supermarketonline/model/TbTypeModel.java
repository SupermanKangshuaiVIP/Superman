package top.kangshuai.supermarketonline.model;

import top.kangshuai.supermarketonline.base.BasePageModel;
import top.kangshuai.supermarketonline.entity.TbType;
/**
 * 
 * @author kangshuai
 *
 */
public class TbTypeModel extends BasePageModel {
  private static final long serialVersionUID = 7600686824836762488L;
  private TbType tbType = new TbType();
  public TbTypeModel() {
  }
  public TbType getTbType() {
    return tbType;
  }
  public void setTbType(TbType tbType) {
    this.tbType = tbType;
  }
  
}
