package co.samtel.gen.type;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("UsuarioTypeInput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-11T15:33:38.742056600-05:00[America/Bogota]")
public class UsuarioTypeInput   {
  private @Valid String tblName;
  private @Valid String tblLastname;
  private @Valid LocalDate tblCreateat;

  /**
   **/
  public UsuarioTypeInput tblName(String tblName) {
    this.tblName = tblName;
    return this;
  }

  
  @JsonProperty("tbl_name")
  public String getTblName() {
    return tblName;
  }

  @JsonProperty("tbl_name")
  public void setTblName(String tblName) {
    this.tblName = tblName;
  }

  /**
   **/
  public UsuarioTypeInput tblLastname(String tblLastname) {
    this.tblLastname = tblLastname;
    return this;
  }

  
  @JsonProperty("tbl_lastname")
  public String getTblLastname() {
    return tblLastname;
  }

  @JsonProperty("tbl_lastname")
  public void setTblLastname(String tblLastname) {
    this.tblLastname = tblLastname;
  }

  /**
   **/
  public UsuarioTypeInput tblCreateat(LocalDate tblCreateat) {
    this.tblCreateat = tblCreateat;
    return this;
  }

  
  @JsonProperty("tbl_createat")
  public LocalDate getTblCreateat() {
    return tblCreateat;
  }

  @JsonProperty("tbl_createat")
  public void setTblCreateat(LocalDate tblCreateat) {
    this.tblCreateat = tblCreateat;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsuarioTypeInput usuarioTypeInput = (UsuarioTypeInput) o;
    return Objects.equals(this.tblName, usuarioTypeInput.tblName) &&
        Objects.equals(this.tblLastname, usuarioTypeInput.tblLastname) &&
        Objects.equals(this.tblCreateat, usuarioTypeInput.tblCreateat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tblName, tblLastname, tblCreateat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioTypeInput {\n");
    
    sb.append("    tblName: ").append(toIndentedString(tblName)).append("\n");
    sb.append("    tblLastname: ").append(toIndentedString(tblLastname)).append("\n");
    sb.append("    tblCreateat: ").append(toIndentedString(tblCreateat)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

