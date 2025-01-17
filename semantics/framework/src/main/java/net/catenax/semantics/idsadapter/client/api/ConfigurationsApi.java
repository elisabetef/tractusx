package net.catenax.semantics.idsadapter.client.api;

import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;
import net.catenax.semantics.idsadapter.client.invoker.ApiClient;
import net.catenax.semantics.idsadapter.client.invoker.EncodingUtils;
import net.catenax.semantics.idsadapter.client.model.ConfigurationDesc;
import net.catenax.semantics.idsadapter.client.model.ConfigurationView;
import net.catenax.semantics.idsadapter.client.model.PagedModelConfigurationView;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-09-08T16:15:16.333286600+02:00[Europe/Berlin]")public interface ConfigurationsApi extends ApiClient.Api {

  /**
   * Create a base resource
   * 
   * @param body  (required)
   * @return ConfigurationView
   */
  @RequestLine("POST /api/configurations")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*,*/*",
  })
  ConfigurationView create8(ConfigurationDesc body);
  /**
   * Delete a base resource by id
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/configurations/{id}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void delete9(@Param("id") UUID id);
  /**
   * Get a base resource by id
   * 
   * @param id  (required)
   * @return ConfigurationView
   */
  @RequestLine("GET /api/configurations/{id}")
  @Headers({
      "Accept: */*,*/*",
  })
  ConfigurationView get9(@Param("id") UUID id);
  /**
   * Get a list of base resources with pagination
   * 
   * @param page  (optional, default to 0)
   * @param size  (optional, default to 30)
   * @return PagedModelConfigurationView
   */
  @RequestLine("GET /api/configurations?page={page}&size={size}")
  @Headers({
      "Accept: */*,*/*",
  })
  PagedModelConfigurationView getAll9(@Param("page") Integer page, @Param("size") Integer size);

  /**
   * Get a list of base resources with pagination
   * 
   * Note, this is equivalent to the other <code>getAll9</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAll9QueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page -  (optional, default to 0)</li>
   *   <li>size -  (optional, default to 30)</li>
   *   </ul>
   * @return PagedModelConfigurationView

   */
  @RequestLine("GET /api/configurations?page={page}&size={size}")
  @Headers({
      "Content-Type: */*",
      "Accept: */*,*/*",
  })
  PagedModelConfigurationView getAll9(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAll9</code> method in a fluent style.
   */
  public static class GetAll9QueryParams extends HashMap<String, Object> {
    public GetAll9QueryParams page(final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAll9QueryParams size(final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get current configuration
   * 
   * @return ConfigurationView
   */
  @RequestLine("GET /api/configurations/active")
  @Headers({
      "Accept: application/hal+json,application/hal+json",
  })
  ConfigurationView getConfiguration();
  /**
   * Update current configuration
   * 
   * @param id  (required)
   * @return Object
   */
  @RequestLine("PUT /api/configurations/{id}/active")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*,*/*,*/*,*/*,*/*",
  })
  Object setConfiguration(@Param("id") UUID id);
  /**
   * Update a base resource by id
   * 
   * @param body  (required)
   * @param id  (required)
   * @return ConfigurationView
   */
  @RequestLine("PUT /api/configurations/{id}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*,*/*,*/*",
  })
  ConfigurationView update9(ConfigurationDesc body, @Param("id") UUID id);
}
