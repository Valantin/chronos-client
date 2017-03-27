package it.infn.ba.indigo.chronos.client.model.v1;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

import java.io.Serializable;

public class Parameters implements Serializable {

  private static final long serialVersionUID = 4299892262923776898L;

  private String key;
  private String value;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return ModelUtils.toString(this);
  }
}
