package br.com.devhernand.starwars.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import com.squareup.picasso.Picasso

/**
 * Created by Nando on 31/05/2017.
 */


class ProductRecyclerAdapter(private val ctx: Context, val productList: List<Product>) : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productList[position]

        holder.productName.text = item.title
        val price = ctx.getString(R.string.currency) + item.price

        holder.productPrice.text = price
        holder.productSeller.text = item.seller
        holder.image.setImageBitmap(null)
        Picasso.with(holder.image.context).load(item.thumbnailHd).into(holder.image)
        holder.itemView.tag = item

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var productName: TextView = itemView.findViewById(R.id.productName)
        var productPrice: TextView = itemView.findViewById(R.id.productPrice)
        var productSeller: TextView = itemView.findViewById(R.id.productSeller)
    }
}
