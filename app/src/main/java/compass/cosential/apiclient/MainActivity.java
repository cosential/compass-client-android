package compass.cosential.apiclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import compass.cosential.apiclient.model.Company;
import compass.cosential.apiclient.model.User;
import compass.cosential.apiclientlibrary.WebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Gson gson = new Gson();

        //  Set server url and firmId.

        WebService.setConfiguration("", "");

        //  Set username, password and firmId.

        WebService.setAuthData("", "", "");

        Call<List<Object>> signInCall = WebService.getInstance().signIn();
        signInCall.enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> signInCall, Response<List<Object>> response) {
                if (response != null) {
                    if (response.body() == null) {
                        Log.d("APIClientLibrary", "Unauthorized.");
                    }
                    else {
                        Object currentUser = response.body().get(0);
                        User user = gson.fromJson(gson.toJson(currentUser), User.class);
                        Log.d("APIClientLibrary", user.firstName);
                    }
                }
                else {
                    Log.d("APIClientLibrary", "Incorrect response from server.");
                }
            }

            @Override
            public void onFailure(Call<List<Object>> signInCall, Throwable t) {
                Log.d("APIClientLibrary", "Connection Error.");
            }
        });

        List<Object> companies = new ArrayList<>();
        Company company = new Company();
        company.setName("Company Name 2019-03-03");

        companies.add(Object.class.cast(company));


        Call<List<Object>> addCompanyCall = WebService.getInstance().addCompanies(companies);

        addCompanyCall.enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> addCompanyCall, Response<List<Object>> response) {
                if (response != null) {
                    if (response.body() == null || response.body().size() == 0) {
                        Log.d("APIClientLibrary", "Error while adding a new company.");
                    }
                    else {
                        List<Object> objectList = response.body();
                        String objectsString = gson.toJson(objectList);
                        List<Company> companyList = Arrays.asList(gson.fromJson(objectsString, Company[].class));
                        Company addedCompany = companyList.get(0);
                        Log.d("APIClientLibrary", addedCompany.getName());
                    }
                }
                else {
                    Log.d("APIClientLibrary", "Error while adding a new company.");
                }
            }

            @Override
            public void onFailure(Call<List<Object>> addCompanyCall, Throwable t) {
                Log.d("APIClientLibrary", "Error while adding a new company.");
            }
        });
    }
}
