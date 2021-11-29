/*
 * Dataspace Connector
 * IDS Connector originally developed by the Fraunhofer ISST
 *
 * OpenAPI spec version: 6.2.0
 * Contact: info@dataspace-connector.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.catenax.semantics.idsadapter.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * RepresentationDesc
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-09-08T16:15:16.333286600+02:00[Europe/Berlin]")
public class RepresentationDesc {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("remoteId")
  private String remoteId = null;

  @JsonProperty("mediaType")
  private String mediaType = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("standard")
  private String standard = null;

  public RepresentationDesc title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @Schema(description = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RepresentationDesc description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

   /**
   * Get remoteId
   * @return remoteId
  **/
  @Schema(description = "")
  public String getRemoteId() {
    return remoteId;
  }

  public RepresentationDesc mediaType(String mediaType) {
    this.mediaType = mediaType;
    return this;
  }

   /**
   * Get mediaType
   * @return mediaType
  **/
  @Schema(description = "")
  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public RepresentationDesc language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Get language
   * @return language
  **/
  @Schema(description = "")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public RepresentationDesc standard(String standard) {
    this.standard = standard;
    return this;
  }

   /**
   * Get standard
   * @return standard
  **/
  @Schema(description = "")
  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepresentationDesc representationDesc = (RepresentationDesc) o;
    return Objects.equals(this.title, representationDesc.title) &&
        Objects.equals(this.description, representationDesc.description) &&
        Objects.equals(this.remoteId, representationDesc.remoteId) &&
        Objects.equals(this.mediaType, representationDesc.mediaType) &&
        Objects.equals(this.language, representationDesc.language) &&
        Objects.equals(this.standard, representationDesc.standard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, remoteId, mediaType, language, standard);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepresentationDesc {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    remoteId: ").append(toIndentedString(remoteId)).append("\n");
    sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    standard: ").append(toIndentedString(standard)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}