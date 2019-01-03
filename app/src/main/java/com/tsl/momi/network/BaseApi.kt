package com.tsl.momi.network

import com.tsl.momi.data.models.Token
import com.tsl.momi.data.models.User
import com.tsl.momi.data.models.authentication.Authenticate
import com.tsl.momi.data.models.campaign.CampaignVideosResult
import com.tsl.momi.utils.AUTHORIZATION
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface BaseApi {
    @POST("register")
    fun signup(@Body user: Authenticate): Observable<User>

    @POST("login")
    fun login(@Body user: Authenticate): Observable<Token>

    @GET("users/me")
    fun getCurrentUser(@Header(AUTHORIZATION) token: String): Observable<User>

    @GET("campaign-videos")
    fun getCampaigns(@Header(AUTHORIZATION) token: String): Observable<PaginatedResponse<CampaignVideosResult>>
}