package br.edu.ifsp.scl.sdm.tradutorsdmkt.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface TradutorApi {

    /* Com campos de cabeçalho estáticos, é possível defini-los na Interface antes da função de requisição */
    @Headers(
        "app_id: 0be341b9", // Preencha com seu app_id
        "app_key: 378f40573ba9b6d7cb51424dbaa9e999" // Preencha com seu app_key
    )
    /* Função de requisição. Começa com uma anotação denotando o método HTTP e endpoint da requisição
    As anotações dos parâmetros da função descrevem o mapeamento para parâmetros do Path da requisição. */
    @GET("entries/{source_translation_language}/{word_id}/translations={target_translation_language}")
    fun getTraducaoByPath(
        @Path("source_translation_language") stl: String,// stl -> source_translation_language
        @Path("word_id") wId: String, // wId -> word_id
        @Path("target_translation_language") ttl: String // ttl -> target_translation_language
    ): Call<ResponseBody>

    @GET("languages")
    fun getLanguages(): Call<ResponseBody>

    @GET("regions/{lang_id}")
    fun getRegions(
        @Path("lang_id") langId: String // wId -> word_id
    ): Call<ResponseBody>

}