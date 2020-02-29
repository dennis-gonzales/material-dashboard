package pro.dennisgonzales.moderndashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dashboard_item.view.*

class ItemAdapter(private val itemList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemLogo: ImageView = itemView.itemLogo
        val itemTitle: TextView = itemView.itemTitle
        val itemInfo: TextView = itemView.itemInfo
        val itemBackground: ConstraintLayout = itemView.itemBackground
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_item,
            parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.itemLogo.setImageResource(currentItem.itemLogo)
        holder.itemBackground.setBackgroundResource(currentItem.itemBackground)
        holder.itemTitle.text = currentItem.itemTitle
        holder.itemInfo.text = currentItem.itemInfo
    }

    override fun getItemCount() = itemList.size
}
