package br.com.devhernand.starwars.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.domain.Product
import com.squareup.picasso.Picasso

/**
 * Created by Nando on 31/05/2017.
 */


class ProductRecyclerAdapter(private val ctx: Context,
                             private val productList: List<Product>,
                             private val onItemClickListener: (product : Product) -> Unit) : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(v,ctx.getString(R.string.currency),onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View, private val currency: String, private val itemClick: (product : Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var productName: TextView = itemView.findViewById(R.id.productName)
        var productPrice: TextView = itemView.findViewById(R.id.productPrice)
        var productSeller: TextView = itemView.findViewById(R.id.productSeller)

        fun bind(product: Product){
            with(product){
                productName.text = title
                val price = currency + price
                productPrice.text = price
                productSeller.text = seller
                image.setImageBitmap(null)
                Picasso.with(image.context).load(thumbnailHd).into(image)
                itemView.tag = this
                itemView.setOnClickListener {itemClick(this)}
            }
        }
    }


}
