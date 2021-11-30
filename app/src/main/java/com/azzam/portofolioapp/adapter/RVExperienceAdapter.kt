package com.azzam.portofolioapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azzam.portofolioapp.R
import com.azzam.portofolioapp.data.Portofolio
import com.azzam.portofolioapp.databinding.ItemExperienceBinding

class RVExperienceAdapter: RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>() {

    private val listData = ArrayList<Portofolio>()

    var onItemCliked: ((Portofolio) -> Unit)? = null

    fun setData(data: List<Portofolio>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExperienceViewHolder = ExperienceViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_experience,parent,false)
    )


    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int = listData.size

    inner class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemExperienceBinding.bind(itemView)

        fun bind(data: Portofolio){
            binding.experience = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                onItemCliked?.invoke(listData[adapterPosition])
            }
        }
    }
}