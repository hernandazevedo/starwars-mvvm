package br.com.devhernand.starwars.view.main

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.domain.usecases.MainUseCase
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MainViewModelTest {


    @Rule @JvmField
    val rule = InstantTaskExecutorRule()

    lateinit var mainViewModel: MainViewModel

    @Mock
    lateinit var mainUseCase: MainUseCase

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(TestSchedulerProvider(),mainUseCase)
    }

    @Test
    fun listProducts() {
        val expectedResult = MutableLiveData<MainViewModelResponse>()
        val product = Product("Product",2000)
        val productList = listOf(product)

        expectedResult.value = MainViewModelResponse(MainViewModelEnum.LIST_SUCCESS,productList)

        `when`(mainUseCase.listProducts()).thenReturn(Single.just(productList))

        mainViewModel.listProducts()

        Assert.assertEquals(expectedResult.value,mainViewModel.response.value)
    }
}