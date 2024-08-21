package ru.relabs.storekeeper.data.network

import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @POST("/api/v1/shipping/auth")
    suspend fun authLogin(@Body request: Map<String, String>): Response<ResponseAuthLogin>

    @GET("/api/v1/shipping/publications")
    suspend fun getPublicationsList(
        @Header("Cookie") cookie: String,
        @Query("date") date: String,
        @Query("suggest") query: String?
    ): Response<List<ResponsePublication>>

    @GET("/api/v1/shipping/publications/{id}")
    suspend fun getPublication(
        @Header("Cookie") cookie: String,
        @Path("id") id: Int
    ): Response<List<ResponsePublicationInfo>>

    @GET("/api/v1/shipping/publications/{id}/routes/all")
    suspend fun getPublicationTrips(
        @Header("Cookie") cookie: String,
        @Path("id") id: Int,
        @Query("store") storeID: String?,
        @Query("manager") managerID: String?,
        @Query("district") districtID: String?,
        @Query("region") regionID: String?
    ): Response<List<ResponsePublicationTrip>>

    @GET("/api/v1/shipping/publications/{publicationID}/routes/{routeID}/stores")
    suspend fun getRouteStores(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Path("routeID") routeID: Int
    ): Response<List<ResponseTripStoreInfo>>

    @GET("/api/v1/shipping/publications/{publicationID}/routes/{routeID}/stores/{storeID}")
    suspend fun getRouteStore(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Path("routeID") routeID: Int,
        @Path("storeID") storeID: Int
    ): Response<ResponseTripStoreFull>






    @POST("/api/v1/shipping/publications/{publicationID}/routes/{routeID}/stores/{storeID}/problems")
    suspend fun addStoreProblem(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Path("routeID") routeID: Int,
        @Path("storeID") storeID: Int,
        @Body problem: RequestProblem
    )

    @POST("/api/v1/shipping/publications/{publicationID}/routes/{routeID}/stores/{storeID}/problems/{problemID}")
    suspend fun addStoreProblemSolution(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Path("routeID") routeID: Int,
        @Path("storeID") storeID: Int,
        @Path("problemID") problemID: Int,
        @Body solution: RequestProblemSolution
    )



    @POST("/api/v1/shipping/suggest/{type}")
    suspend fun getFilterSuggests(
        @Header("Cookie") cookie: String,
        @Path("type") type: String,
        @Body request: RequestSuggest
    ): Response<List<ResponseSuggest>>

    @GET("/api/v1/shipping/publications/{publicationID}/xls")
    suspend fun getReportUrl(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Query("date") date: String
    ): Response<ResponseReport>

    @GET("/api/v1/shipping/updates")
    suspend fun getChanges(@Header("Cookie") cookie: String): Response<List<ResponseChange>>

    @GET("/api/v1/shipping/problems")
    suspend fun getProblemTrips(@Header("Cookie") cookie: String): Response<List<ResponsePublicationTrip>>

    @POST("/api/v1/shipping/publications/{publication_id}/intime")
    suspend fun shipByPlan(
        @Header("Cookie") cookie: String,
        @Path("publication_id") publicationID: Int,
        @Body body: RequestSetUnloadTime
    )

    @POST("/api/v1/shipping/publications/{publication_id}/set_time_load")
    suspend fun setTimeLoad(
        @Header("Cookie") cookie: String,
        @Path("publication_id") publicationID: Int,
        @Body body: RequestSetLoadTime
    )

    @GET("/api/v1/shipping/publications/{publicationID}/routes/{routeID}/stores/{storeID}/navigator")
    suspend fun getStoreNavigation(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Path("routeID") routeID: Int,
        @Path("storeID") storeID: Int,
    ): Response<ResponseStoreNavigation>

    @GET("/api/v1/shipping/update")
    suspend fun getUpdate(): Response<ResponseUpdate>

    @POST("/api/v1/shipping/pushtoken")
    suspend fun addPushToken(
        @Header("Cookie") cookie: String,
        @Body body: RequestPushToken
    )

    @POST("/api/v1/shipping/publications/{publicationID}/upload_photo")
    suspend fun uploadPhoto(
        @Header("Cookie") cookie: String,
        @Path("publicationID") publicationID: Int,
        @Body body: UploadPhotoBody
    )

}




