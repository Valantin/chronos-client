package it.infn.ba.indigo.chronos.client;

import feign.Feign.Builder;
import feign.auth.BasicAuthRequestInterceptor;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import it.infn.ba.indigo.chronos.client.utils.ChronosException;
import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

import static java.util.Arrays.asList;

public class ChronosClient {
  static class ChronosHeadersInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
      template.header("Accept", "application/json");
      template.header("Content-Type", "application/json");
    }
  }

  static class ChronosErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
      return new ChronosException(response.status(), response.reason());
    }
  }

  public static Chronos getInstance(String endpoint) {
    return getInstance(endpoint, null);
  }

  /**
   * The generalized version of the method that allows more in-depth customizations via
   * {@link RequestInterceptor}s.
   *
   * @param endpoint
   *          URL of Chronos
   */
  public static Chronos getInstance(String endpoint, RequestInterceptor... interceptors) {
    Builder b =
        Feign.builder().encoder(new GsonEncoder(ModelUtils.GSON))
            .decoder(new GsonDecoder(ModelUtils.GSON)).errorDecoder(new ChronosErrorDecoder())
            .requestInterceptor(new ChronosHeadersInterceptor());

    if (interceptors != null)
      b.requestInterceptors(asList(interceptors));

    return b.target(Chronos.class, endpoint);
  }

  /**
   * Creates a Chronos client proxy that performs HTTP basic authentication.
   */
  public static Chronos getInstanceWithBasicAuth(String endpoint, String username,
      String password) {
    return getInstance(endpoint, new BasicAuthRequestInterceptor(username, password));
  }
}
