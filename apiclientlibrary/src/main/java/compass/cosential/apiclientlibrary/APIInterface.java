package compass.cosential.apiclientlibrary;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by softdev0420 on 9/21/16.
 */

public interface APIInterface {

    ////////////////////////////////

    //  User

    @GET("user")
    Call<List<Object>> signIn();

    ////////////////////////////////

    //  Company

    @GET("companies/companytypes")
    Call<List<Object>> getCompanyTypes();

    @GET("companies/{companyId}/companytypes")
    Call<List<Object>> getCompanyTypes(@Path("companyId") int companyId);

    @POST("companies/{companyId}/companytypes")
    Call<List<Object>> addCompanyTypes(@Path("companyId") int companyId, @Body ArrayList<Object> companyTypes);

    @DELETE("companies/{companyId}/companytypes")
    Call<Void> deleteCompanyTypes(@Path("companyId") int companyId);

    @GET("companies/search")
    Call<List<Object>> searchCompaniesWithKeyword(@Query("q") String keyword, @Query("from") int from, @Query("size") int size);

    @POST("companies")
    Call<List<Object>> addCompanies(@Body List<Object> companies);

    @POST("companies/{companyId}/addresses")
    Call<List<Object>> addCompanyAddresses(@Path("companyId") int companyId, @Body List<Object> companyAddresses);

    @PUT("companies/{companyId}")
    Call<Object> updateCompany(@Path("companyId") int companyId, @Body Object company);

    ////////////////////////////////

    //  Contact

    @GET("contacts/types")
    Call<List<Object>> getContactTypes();

    @POST("contacts/{contactId}/types")
    Call<List<Object>> addContactTypes(@Path("contactId") int contactId, @Body ArrayList<Object> contactTypes);

    @DELETE("contacts/{contactId}/types")
    Call<Void> deleteContactTypes(@Path("contactId") int contactId);

    @GET("contacts")
    Call<List<Object>> getContacts(@Query("from") int from, @Query("size") int size, @Query("full") boolean full);

    @GET("contacts/changes")
    Call<List<Object>> getChangedContacts(@Query("includeDeleted") boolean includeDeleted, @Query("version") String version, @Query("reverse") boolean reverse);

    @GET("contacts/{contactId}")
    Call<Object> getContactDetail(@Path("contactId") int contactId);

    @GET("contacts/search")
    Call<List<Object>> searchContactsWithKeyword(@Query("q") String keyword, @Query("from") int from, @Query("size") int size, @Query("q") String fields);

    @POST("contacts")
    Call<List<Object>> addContacts(@Body ArrayList<Object> contacts);

    @PUT("contacts/{contactId}")
    Call<Object> updateContact(@Path("contactId") int contactId, @Body Object contact);

    //  Address

    @GET("contacts/{contactId}/addresses")
    Call<List<Object>> getContactAddresses(@Path("contactId") int contactId);

    @POST("contacts/{contactId}/addresses")
    Call<List<Object>> addContactAddresses(@Path("contactId") int contactId, @Body List<Object> contactAddresses);

    @PUT("contacts/{contactId}/addresses")
    Call<List<Object>> updateContactAddresses(@Path("contactId") int contactId, @Body List<Object> contactAddresses);

    //  Image

    @GET("images/contact/{contactId}/profilepicture")
    Call<Object> getContactProfilePicture(@Path("contactId") int contactId);

    @GET("images/contact/{contact}/cardfront")
    Call<Object> getContactFrontImage(@Path("contactId") int contactId);

    @PUT("images/contact/{contactId}/cardfront")
    Call<Void> addContactFrontImage(@Path("contactId") int contactId, @Body Object imageData);

    @PUT("images/contact/{contactId}/cardback")
    Call<Void> addContactBackImage(@Path("contactId") int contactId, @Body Object imageData);

    @DELETE("contacts/{contactId}")
    Call<String> deleteContact(@Path("contactId") int contactId);

    //  Relationship

    @GET("contacts/relationships/relationship")
    Call<List<Object>> getRelationships();

    @GET("contacts/relationships/relationshipstrength")
    Call<List<Object>> getRelationshipStrengths();

    @GET("contacts/{contactId}/relationships")
    Call<List<Object>> getContactRelationships(@Path("contactId") int contactId);

    @POST("contacts/{contactId}/relationships")
    Call<List<Object>> addContactRelationships(@Path("contactId") int contactId, @Body List<Object> relationships);

    //  MailingList

    @GET("contacts/Contact_MailingList")
    Call<List<Object>> getContactMailingLists();

    @GET("contacts/{contactId}/Contact_MailingList")
    Call<List<Object>> getContactContactMailingLists();

    @POST("contacts/{contactId}/Contact_MailingList")
    Call<List<Object>> addContactContactMailingLists(@Path("contactId") int contactId, @Body List<Object> contactMailingLists);

    ////////////////////////////////

    //  Personnel

    @GET("personnel")
    Call<List<Object>> getPersonnel(@Query("from") int from, @Query("size") int size);

    @GET("personnel/{personnelId}/images")
    Call<List<Object>> getPersonnelProfilePictures(@Path("personnelId") int personnelId);

    @GET("images/personnel/{personnelId}/{imageId}/thumb")
    Call<Object> getPersonnelThumbProfilePicture(@Path("personnelId") int personnelId, @Path("imageId") int imageId);

    ////////////////////////////////
}
