package ru.relabs.storekeeper.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseAuthLogin(
    val user: AuthLoginUser, val token: String,
)

@Serializable
data class AuthLoginUser(
    val id: Int,
    val login: String,
    val role: String,
)

@Serializable
data class ResponsePublication(
    val id: Int,
    val name: String,
    @SerialName("date") private val _date: String,
    @SerialName("problem_color") val color: Int,
    @SerialName("can_publication_photo") private val _canPubPhoto: Int,
    @SerialName("photo_url") val photoUrl: String?,
    @SerialName("version") private val _version: String,
    @SerialName("photo_owner_id") val photo_owner_id: Int?
)



@Serializable
data class ResponsePublicationInfo(
    val id: Int,
    val name: String,
    @SerialName("date") private val _date: String,
    @SerialName("problem_color") val color: Int,
    @SerialName("can_publication_photo") private val _canPubPhoto: Int,
)


@Serializable
data class ResponsePublicationTrip(
    val id: Int,
    @SerialName("publication_id") val publicationID: Int,
    val name: String,
    @SerialName("load_time") val loadTime: String?,
    @SerialName("unload_time") val unloadTime: String?,
    @SerialName("date") private val _date: String,
    @SerialName("problem_color") val color: Int,
    @SerialName("load_time_color") val loadTimeColor: Int? = null,
    @SerialName("unload_time_color") val unloadTimeColor: Int? = null,
)

@Serializable
data class ResponseTripStoreInfo(
    val store: ResponseRouteStore, val publications: List<ResponseEdition>,
)

@Serializable
data class ResponseTripStoreFull(
    val store: ResponseRouteStore, val printings: List<ResponseEdition>, val contacts: List<ResponseContact>,
)

@Serializable
data class ResponseContact(
    val name: String, val phone: String?,
)

@Serializable
data class ResponseRouteStore(
    val id: Int,
    val address: String,
    val load_time: String?,
    val unload_time: String?,
    @SerialName("date") val _date: String,
    val receiver_name: String,
    val receiver_phone: String,
    val photo: List<String>?,
    @SerialName("problem_color") val problemColor: Int,
    @SerialName("load_time_color") val loadTimeColor: Int? = null,
    @SerialName("unload_time_color") val unloadTimeColor: Int? = null,
    @SerialName("navigate_source") val navigateSource: String? = null,
    @SerialName("navigate_previous") val navigatePrevious: String? = null,
)

@Serializable
data class ResponseEdition(
    @SerialName("id") val id: Int,
    @SerialName("store_id") val store_id: Int,
    @SerialName("name") val name: String,
    @SerialName("plan_edition_count") val countEditionPlan: Int,
    @SerialName("actual_edition_count") val countEditionActual: Int,
    @SerialName("edition_count_color") val editionCountColor: Int? = null,
    @SerialName("plan_leftover_count") val countLeftoverPlan: Int,
    @SerialName("actual_leftover_count") val countLeftoverActual: Int,
    @SerialName("plan_pack_count") val countPackPlan: Int,
    @SerialName("actual_pack_count") val countPackActual: Int,
    @SerialName("plan_time") val timePlan: String?,
    @SerialName("actual_time") val timeActual: String?,
    @SerialName("car_number") val carNumber: String?,
    @SerialName("route_id") val tripID: Int? = null,
)

@Serializable
data class Response<T>(
    val data: T,
)

@Serializable
data class ResponseSuggest(
    val id: Int, val name: String,
)

@Serializable
data class RequestSuggest(
    @SerialName("edition_id") val editionID: Int,
    @SerialName("suggest") val query: String,
    @SerialName("offset") val offset: Int,
)

@Serializable
data class ResponseReport(
    val path: List<String>?,
)

@Serializable
data class ResponseChange(
    val message: String, @SerialName("is_new") private val _isNew: Int,
) {
    val isNew: Boolean get() = _isNew > 0
}



@Serializable
data class RequestProblem(
    @SerialName("t") val type: Int, val comment: String?,
)

@Serializable
data class RequestProblemSolution(
    @SerialName("t") val type: Int,
    val name: String? = null,
    val phone: String? = null,
    @SerialName("store_id") val storeID: Int? = null,
    val address: String? = null,
    val comment: String? = null,
)

@Serializable
data class RequestSetUnloadTime(
    val date: String, @SerialName("route_ids") val routes: String,
)

@Serializable
data class RequestSetLoadTime(
    val date: String, @SerialName("routes") val routes: String, @SerialName("time") val time: String,
)

@Serializable
data class RequestPushToken(
    val token: String,
)

@Serializable
data class ResponseStoreNavigation(
    @SerialName("navigate_source") val source: String, @SerialName("navigate_previous") val previous: String,
)

@Serializable
data class ResponseUpdate(
    @SerialName("last_optional") val optional: ResponseVersionInfo? = null,
    @SerialName("last_required") val required: ResponseVersionInfo? = null,
)

@Serializable
data class ResponseVersionInfo(
    val version: Int, val url: String,
)

@Serializable
class UploadPhotoBody(
    @SerialName("data") val data: String,
)

