package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
@NoArgsConstructor
public class UserInformation {
    @GeneratedValue(strategy  = GenerationType.SEQUENCE)
    private int userId;
    private String name;
    private String address;

    @JsonCreator public UserInformation(@JsonProperty("userId") Integer userId,
                                        @JsonProperty("username") String username,
                                        @JsonProperty("address") String address){
        this.userId = userId;
        this.name = username;
        this.address = address;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return  this.name;
    }

    public String getAddress(){
        return this.address;
    }
}
