package top.kangshuai.supermarketonline.entity;

import java.util.Date;

import top.kangshuai.supermarketonline.base.BaseEntity;
/**
 * 
 * @author kangshuai
 *
 */
public class TbConfig extends BaseEntity{
  private static final long serialVersionUID = -1643592831095177714L;
  private String configKey;
  private String configValue;
  private Date lastupdate;
  public TbConfig(){}
  
  public TbConfig(String configKey, String configValue, Date lastupdate) {
    this.configKey = configKey;
    this.configValue = configValue;
    this.lastupdate = lastupdate;
  }
  public String getConfigKey() {
    return configKey;
  }
  public void setConfigKey(String configKey) {
    this.configKey = configKey;
  }
  public String getConfigValue() {
    return configValue;
  }
  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }
  public Date getLastupdate() {
    return lastupdate;
  }
  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }
  
}
