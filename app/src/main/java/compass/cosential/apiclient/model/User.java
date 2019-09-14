package compass.cosential.apiclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("UserId")
    @Expose
    public int userId;
    public String username;
    public String password;
    public String firmId;

    @SerializedName("FirstName")
    @Expose
    public String firstName;

    @SerializedName("LastName")
    @Expose
    public String lastName;
}
