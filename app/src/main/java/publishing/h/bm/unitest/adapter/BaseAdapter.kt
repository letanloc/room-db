package publishing.h.bm.unitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import publishing.h.bm.unitest.R
import publishing.h.bm.unitest.demo4.User

class BaseAdapter : RecyclerView.Adapter<BaseAdapter.ViewHodler>() {
    private var onItemClick: OnItemClick<User>? = null
    private var list: ArrayList<User> = ArrayList()

    fun initData(list: ArrayList<User>) {
        this.list = list
        this.notifyDataSetChanged()
    }

    fun updateData(list: ArrayList<User>) {
        this.list.clear()
        this.list.addAll(list)
        this.notifyDataSetChanged()
    }

    fun setOnItemClickListener(itemClick: OnItemClick<User>) {
        this.onItemClick = itemClick
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        var data = list.get(position)
        holder.txtTitle.text = data.firstName
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                onItemClick!!.itemClicked(v = p0!!, data = data, pos = position)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        return ViewHodler(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    class ViewHodler : RecyclerView.ViewHolder {
        var txtTitle: TextView

        constructor(view: View) : super(view) {
            txtTitle = view.txtTitle
        }
    }

}

interface OnItemClick<T> {
    fun itemClicked(v: View, data: T, pos: Int)
}