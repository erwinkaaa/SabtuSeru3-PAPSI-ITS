package com.example.sabtuseru3_papsi_its.test

import com.example.sabtuseru3_papsi_its.TestContextProvider
import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.ui.movie.MovieModel
import com.example.sabtuseru3_papsi_its.ui.movie.MoviePresenter
import com.example.sabtuseru3_papsi_its.ui.movie.MovieResponseModel
import com.example.sabtuseru3_papsi_its.ui.movie.MovieView
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieTest {
    @Mock
    private lateinit var view: MovieView

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var gson: Gson

    private lateinit var presenter: MoviePresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = MoviePresenter(view, gson, apiRepository, TestContextProvider())
    }

    @Test
    fun testMovie(){
        val movies: MutableList<MovieModel> = mutableListOf()
        val response = MovieResponseModel(movies)

        runBlocking {
            Mockito.`when`(apiRepository.doRequestAsync(
                ArgumentMatchers.anyString()
            )).thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await()).thenReturn("")
            Mockito.`when`(
                gson.fromJson("", MovieResponseModel::class.java)
            ).thenReturn(response)
        }

        presenter.loadMovies()
        Thread.sleep(2000)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).processMovieData(movies)
        Mockito.verify(view).hideLoading()
    }
}