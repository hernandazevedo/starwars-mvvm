package br.com.devhernand.starwars.data.net;

import java.util.List;

import br.com.devhernand.starwars.data.entity.ProductEntity;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Nando on 31/05/2017.
 */

public interface ProductEndpoints {
    @GET("products")
    Single<List<ProductEntity>> listProducts();
}
