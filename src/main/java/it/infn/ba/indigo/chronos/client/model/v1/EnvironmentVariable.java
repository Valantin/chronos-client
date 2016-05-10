package it.infn.ba.indigo.chronos.client.model.v1;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

public class EnvironmentVariable {
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
