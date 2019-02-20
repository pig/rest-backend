package dev.pigwalking;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class AppConfig extends Configuration {

  @NotEmpty
  private String version;

  @JsonProperty
  public String getVersion() {
    return version;
  }

  @JsonProperty
  public void setVersion(String version) {
    this.version = version;
  }
}
