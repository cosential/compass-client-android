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

    @GET("user/features")
    Call<List<Object>> getFeatures();

    @GET("user/firmsettings")
    Call<Object> getFirmSettings();

    ////////////////////////////////

    //  Contact

    @GET("contacts")
    Call<List<Object>> getContacts(@Query("from") int from, @Query("size") int size, @Query("full") boolean full);

    @GET("contacts/changes")
    Call<List<Object>> getChangedContacts(@Query("includeDeleted") boolean includeDeleted, @Query("version") String version, @Query("reverse") boolean reverse);

    @GET("contacts/{contactId}")
    Call<Object> getContact(@Path("contactId") int contactId);

    @GET("contacts/search")
    Call<List<Object>> searchContactsWithKeyword(@Query("q") String keyword, @Query("from") int from, @Query("size") int size, @Query("fields") String fields);

    @POST("contacts")
    Call<List<Object>> addContacts(@Body ArrayList<Object> contacts);

    @PUT("contacts/{contactId}")
    Call<Object> updateContact(@Path("contactId") int contactId, @Body Object contact);

    @GET("contacts/types")
    Call<List<Object>> getContactTypes();

    @POST("contacts/{contactId}/types")
    Call<List<Object>> addContactTypes(@Path("contactId") int contactId, @Body ArrayList<Object> contactTypes);

    @DELETE("contacts/{contactId}/types")
    Call<Void> deleteContactTypes(@Path("contactId") int contactId);

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

    @DELETE("images/contact/{contactId}/profilepicture")
    Call<Void> deleteContactProfilePicture(@Path("contactId") int contactId);

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

    @PUT("contacts/{contactId}/relationships/{relationshipId}")
    Call<Object> updateContactRelationships(@Path("contactId") int contactId, @Path("relationshipId") int relationshipId, @Body Object relationship);

    @DELETE("contacts/{contactId}/relationships/{relationshipId}")
    Call<Void> deleteContactRelationship(@Path("contactId") int contactId, @Path("relationshipId") int relationshipId);

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

    @GET("contacts/{contactId}/{path}")
    Call<Object> getContactSubData(@Path("contactId") int contactId, @Path("path") String path);

    @POST("contacts/{contactId}/{path}")
    Call<List<Object>> addContactSubData(@Path("contactId") int contactId, @Path("path") String path, @Body List<Object> subData);

    @DELETE("contacts/{contactId}/{path}")
    Call<Void> deleteContactSubData(@Path("contactId") int contactId, @Path("path") String path);

    ////////////////////////////////

    //  Company

    @GET("companies")
    Call<List<Object>> getCompanies(@Query("from") int from, @Query("size") int size, @Query("full") boolean full);

    @GET("companies/changes")
    Call<List<Object>> getChangedCompanies(@Query("includeDeleted") boolean includeDeleted, @Query("version") String version, @Query("reverse") boolean reverse);

    @GET("companies/{companyId}")
    Call<Object> getCompany(@Path("companyId") int companyId);

    @GET("companies/search")
    Call<List<Object>> searchCompaniesWithKeyword(@Query("q") String keyword, @Query("from") int from, @Query("size") int size);

    @POST("companies")
    Call<List<Object>> addCompanies(@Body List<Object> companies);

    @GET("companies/companyTypes")
    Call<List<Object>> getCompanyTypes();

    @GET("companies/{companyId}/companyTypes")
    Call<List<Object>> getCompanyTypes(@Path("companyId") int companyId);

    @POST("companies/{companyId}/companyTypes")
    Call<List<Object>> addCompanyTypes(@Path("companyId") int companyId, @Body ArrayList<Object> companyTypes);

    @DELETE("companies/{companyId}/companyTypes")
    Call<Void> deleteCompanyTypes(@Path("companyId") int companyId);

    @POST("companies/{companyId}/addresses")
    Call<List<Object>> addCompanyAddresses(@Path("companyId") int companyId, @Body List<Object> companyAddresses);

    @PUT("companies/{companyId}/addresses")
    Call<List<Object>> updateCompanyAddresses(@Path("companyId") int companyId, @Body List<Object> companyAddresses);

    @PUT("companies/{companyId}")
    Call<Object> updateCompany(@Path("companyId") int companyId, @Body Object company);

    //  SubData

    @GET("companies/{path}")
    Call<List<Object>> getAllCompanySubData(@Path("path") String path, @Query("from") int from, @Query("size") int size);

    @GET("companies/{companyId}/{path}")
    Call<List<Object>> getCompanySubData(@Path("companyId") int companyId, @Path("path") String path, @Query("from") int from, @Query("size") int size);

    @POST("companies/{companyId}/{path}")
    Call<List<Object>> addCompanySubData(@Path("companyId") int companyId, @Path("path") String path, @Body List<Object> subData);

    @PUT("companies/{companyId}/{path}/{subDataId}")
    Call<Object> updateCompanySubData(@Path("companyId") int companyId, @Path("path") String path, @Path("subDataId") int subDataId);

    @DELETE("companies/{companyId}/{path}")
    Call<Void> deleteAllCompanySubData(@Path("companyId") int companyId, @Path("path") String path);

    @DELETE("companies/{companyId}/{path}/{subDataId}")
    Call<Void> deleteCompanySubData(@Path("companyId") int companyId, @Path("path") String path, @Path("subDataId") int subDataId);

    //  Image

    @GET("images/companies/{companyId}/thumb")
    Call<Object> getCompanyLogoThumbnail(@Path("companyId") int companyId);

    @PUT("images/companies/{companyId}")
    Call<Object> addCompanyLogo(@Path("companyId") int companyId, @Body Object imageData);

    ////////////////////////////////

    //  Personnel

    @GET("personnel")
    Call<List<Object>> getPersonnel(@Query("from") int from, @Query("size") int size, @Query("full") boolean full);

    @GET("personnel/{personnelId}")
    Call<Object> getPersonnelDetail(@Path("personnelId") int personnelId);

    @GET("personnel/{personnelId}/images")
    Call<List<Object>> getPersonnelProfilePictures(@Path("personnelId") int personnelId);

    @GET("images/personnel/{personnelId}/{imageId}/thumb")
    Call<Object> getPersonnelThumbProfilePicture(@Path("personnelId") int personnelId, @Path("imageId") int imageId);

    @GET("personnel/{personnelId}/{path}")
    Call<List<Object>> getPersonnelSubData(@Path("personnelId") int personnelId, @Path("path") String path, @Query("from") int from, @Query("size") int size);

    ////////////////////////////////

    //  CallLog

    @POST("callLogs")
    Call<List<Object>> addCallLogs(@Body List<Object> callLogs);

    @GET("callLogs/{callLogId}/{path}")
    Call<List<Object>> getCallLogSubData(@Path("callLogId") int callLogId, @Path("path") String path, @Query("from") int from, @Query("size") int size);

    @POST("callLogs/{callLogId}/contacts")
    Call<List<Object>> addCallLogContacts(@Path("callLogId") int callLogId, @Body List<Object> contactData);

    @POST("callLogs/{callLogId}/companies")
    Call<List<Object>> addCallLogCompanies(@Path("callLogId") int callLogId, @Body List<Object> companyData);

    @POST("callLogs/{callLogId}/{path}")
    Call<List<Object>> addCallLogSubData(@Path("callLogId") int callLogId, @Path("path") String path, @Body List<Object> recordData);

    @GET("callLogs/search")
    Call<List<Object>> searchCallLogs(@Query("from") int from, @Query("size") int size, @Query("q") String query);

    @GET("callLogs/calldisposition")
    Call<List<Object>> getCallLogDispositions();
    
    @GET("callLogs/calltype")
    Call<List<Object>> getCallLogCallTypes();

    @PUT("callLogs/{callLogId}")
    Call<Object> updateCallLog(@Path("callLogId") int callLogId, @Body Object callLog);

    ////////////////////////////////

    //  Opportunity

    @GET("opportunities/search")
    Call<List<Object>> searchOpportunities(@Query("from") int from, @Query("size") int size, @Query("q") String query);

    ////////////////////////////////

    //  Project

    @GET("projects/search")
    Call<List<Object>> searchProjects(@Query("from") int from, @Query("size") int size, @Query("q") String query);

    ////////////////////////////////

    //  Lead

    @GET("leads/search")
    Call<List<Object>> searchLeads(@Query("from") int from, @Query("size") int size, @Query("q") String query);

    @POST("leads")
    Call<List<Object>> addLeads(@Body List<Object> leads);

    @POST("leads/{leadId}/associatedcontacts")
    Call<List<Object>> addLeadContacts(@Path("leadId") int leadId, @Body List<Object> contactData);

    @POST("leads/{leadId}/potentialclient")
    Call<List<Object>> addLeadCompanies(@Path("leadId") int leadId, @Body List<Object> companyData);

    ////////////////////////////////
}
