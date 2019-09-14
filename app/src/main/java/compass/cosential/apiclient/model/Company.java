package compass.cosential.apiclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by softdev on 3/2/17.
 */

public class Company implements Serializable {
    @SerializedName("CompanyId")
    @Expose
    private int companyId = 0;

    @SerializedName("Name")
    @Expose
    private String name;

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
