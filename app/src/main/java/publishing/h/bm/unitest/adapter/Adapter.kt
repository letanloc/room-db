package publishing.h.bm.unitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import publishing.h.bm.unitest.R
import publishing.h.bm.unitest.demo3.UserModel

class Adapter : RecyclerView.Adapter<UserViewHolder>() {
    private var list = ArrayList<UserModel>()
    private lateinit var onclickItem: OnItemClickListener

    fun updateData(list: ArrayList<UserModel>) {
        this.list = list
        this.notifyDataSetChanged()
    }

    fun onItemClickedListener(onItemClickListener: OnItemClickListener) {
        this.onclickItem = onItemClickListener
    }

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var data = list.get(position)
        holder.txtTitle.text = data.mUserName
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                onclickItem.itemClicked(p0!!, position, data)
            }
        })
    }


}

class UserViewHolder : RecyclerView.ViewHolder {
    var txtTitle: TextView

    constructor(view: View) : super(view) {
        txtTitle = view.findViewById(R.id.txtTitle)
    }
}

interface OnItemClickListener {
    fun itemClicked(view: View, position: Int, data: UserModel)
}