package sample.qiitaclient.dagger

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sample.qiitaclient.qlient.ArticleClient
import javax.inject.Singleton

@Module
class ClientModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl("http://qiita.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun provideArticleClient(retrofit: Retrofit): ArticleClient =
            retrofit.create(ArticleClient::class.java)

}