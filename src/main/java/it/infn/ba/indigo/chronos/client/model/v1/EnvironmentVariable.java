package it.infn.ba.indigo.chronos.client.model.v1;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

import java.io.Serializable;

public class EnvironmentVariable implements Serializable {

  private static final long serialVersionUID = 4299892262923776898L;

  private String name;
  private String value;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
