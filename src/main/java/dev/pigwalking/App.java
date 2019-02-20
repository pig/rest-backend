package dev.pigwalking;

import dev.pigwalking.resource.PersonResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<AppConfig> {
  
  public static void main(String[] args) throws Exception {
    new App().run(args);
  }

  @Override
  public void initialize(Bootstrap<AppConfig> bootstrap) {
    // do nothing
  }

  @Override
  public void run(AppConfig configuration, Environment environment) throws Exception {
    // TODO Auto-generated method stub
    final PersonResource personResource = new PersonResource();
    environment.jersey().register(personResource);
    
    environment.healthChecks().register("template", new ReststubCheck(configuration.getVersion()));
  }
}
