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

public interface APIInterface {

    ////////////////////////////////

    //  User

    @GET("user")
    Call<List<Object>> signIn();

    ////////////////////////////////

    //  Company

    @GET("companies/companyTypes")
    Call<List<Object>> getCompanyTypes();

    @GET("companies/{companyId}/companyTypes")
    Call<List<Object>> getCompanyTypes(@Path("companyId") int companyId);

    @POST("companies/{companyId}/companyTypes")
    Call<List<Object>> addCompanyTypes(@Path("companyId") int companyId, @Body ArrayList<Object> companyTypes);

    @DELETE("companies/{companyId}/companyTypes")
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
    Call<List<Object>> searchContactsWithKeyword(@Query("q") String keyword, @Query("from") int from, @Query("size") int size, @Query("fields") String fields);

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

    @GET("images/contact/{contactId}/{imageType}")
    Call<Object> getContactImage(@Path("contactId") int contactId, @Path("imageType") String imageType);

    @PUT("images/contact/{contactId}/{imageType}")
    Call<Void> addContactImage(@Path("contactId") int contactId, @Path("imageType") String imageType, @Body Object imageData);

    @PUT("images/contact/{contactId}/profilepicture")
    Call<Void> addContactProfilePicture(@Path("contactId") int contactId, @Query("url") String url);

    @DELETE("contacts/{contactId}")
    Call<String> deleteContact(@Path("contactId") int contactId);

    //  Relationship

    @GET("contacts/relationships/relationship")
    Call<List<Object>> getRelationships();

    @GET("contacts/relationships/relationshipStrength")
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

    //  SubData

    @GET("contacts/{path}")
    Call<List<Object>> getAllContactSubData(@Path("path") String path, @Query("from") int from, @Query("size") int size);

    @GET("contacts/{contactId}/{path}")
    Call<List<Object>> getContactSubData(@Path("contactId") int contactId, @Path("path") String path, @Query("from") int from, @Query("size") int size);

    @POST("contacts/{contactId}/{path}")
    Call<List<Object>> addContactSubData(@Path("contactId") int contactId, @Path("path") String path, @Body List<Object> subData);

    @DELETE("contacts/{contactId}/{path}")
    Call<Object> deleteContactSubData(@Path("contactId") int contactId, @Path("path") String path);

    ////////////////////////////////

    //  Personnel

    @GET("personnel")
    Call<List<Object>> getPersonnel(@Query("from") int from, @Query("size") int size);

    @GET("personnel/{personnelId}/images")
    Call<List<Object>> getPersonnelProfilePictures(@Path("personnelId") int personnelId);

    @GET("images/personnel/{personnelId}/{imageId}/thumb")
    Call<Object> getPersonnelThumbProfilePicture(@Path("personnelId") int personnelId, @Path("imageId") int imageId);

    ////////////////////////////////

    //  CallLog

    @GET("callLogs/search")
    Call<List<Object>> getContactCallLogs(@Query("from") int from, @Query("size") int size, @Query("q") String query);

    ////////////////////////////////
}
