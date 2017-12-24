package br.com.devhernand.starwars.data.exception

/**
 * Created by Nando on 24/12/2017.
 */
class NetworkConnectionException : Exception {

    constructor() : super() {}

    constructor(cause: Throwable?) : super(cause) {}
}
