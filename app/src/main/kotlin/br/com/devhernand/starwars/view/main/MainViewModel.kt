package br.com.devhernand.starwars.view.main

import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.view.base.BaseViewModel
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.MainUseCase

/**
 * Created by Nando on 23/12/2017.
 */
class MainViewModel constructor(schedulerProvider: SchedulerProvider,mainUseCase: MainUseCase)
    : BaseViewModel()