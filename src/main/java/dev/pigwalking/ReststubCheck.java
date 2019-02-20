package dev.pigwalking;

import com.codahale.metrics.health.HealthCheck;

import dev.pigwalking.dao.PersonDAO;

public class ReststubCheck extends HealthCheck {

  private final String version;
  
  public ReststubCheck(String version) {
      this.version = version;
  }

  @Override
  protected Result check() throws Exception {
      if (PersonDAO.getCount() == 0) {
          return Result.unhealthy("No persons in DB! Version: " +
                  this.version);
      }
      return Result.healthy("OK with version: " + this.version +
              ". Persons count: " + PersonDAO.getCount());
  }
}
