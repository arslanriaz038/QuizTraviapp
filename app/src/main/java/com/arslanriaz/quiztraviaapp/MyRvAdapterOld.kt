package com.arslanriaz.quiztraviaapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckedTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arslanriaz.quiztraviaapp.databinding.SinglelistOptionBinding

class MyRvAdapterOld(
    private val onClickListener: RvOnClickListener,
    val result: Result
) : ListAdapter<List<String>, MyRvAdapterOld.ListViewHolder>(MyDiffUtilRv) {

    companion object MyDiffUtilRv : DiffUtil.ItemCallback<List<String>>() {
        override fun areItemsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
        }
    }

    var currentitemSelected = -1
    var list: List<String> = result.getAllOptions()
    var selectedoption = result.selected_opt


    class ListViewHolder(binding: SinglelistOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var ct_option: CheckedTextView = binding.ctOption


        fun bind(list: List<String>) {

            ct_option.text = list[adapterPosition]


            // ct_option.isChecked = (selectedoption == ct_option.text)


            //    if (currentitemSelected== adapterPosition )
            /*  ct_option.isChecked = (currentitemSelected == adapterPosition) //= true

              ct_option.text == selectedOption*/


        }


        // var ct_option: CheckedTextView = itemView.findViewById(R.id.ct_option)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        /*   val itemView2 =
               LayoutInflater.from(parent.context).inflate(R.layout.singlelist_option, parent, false)
           return ListViewHolder(itemView2)*/



        return ListViewHolder(
            SinglelistOptionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {


        //holder.ct_option.text = list[position]


        // ct_option.isChecked = (ct_option.text== selectedoption )
        //   holder.ct_option.isChecked = (result.selected_opt == holder.ct_option.text.toString())

        //  holder.ct_option.isChecked = (      currentitemSelected == holder.adapterPosition)


        holder.itemView.setOnClickListener { adapterView ->

            onClickListener.onClick(result)

            currentitemSelected = holder.adapterPosition

            //  if(    currentitemSelected == holder.adapterPosition)

            //   result.selected_opt = holder.ct_option.text.toString()


            Log.d("selected Option 3", "bind: ${result.selected_opt} ")

            //  holder.ct_option.isChecked =!  holder.equals(selectedoption)

            Log.d("selected Option 2", "bind: ${result.selected_opt} ")

            //  holder.bind(list)

            //  currentitemSelected = holder.adapterPosition
            //  holder.ct_option.isChecked = ( holder.ct_option.text == selectedoption )

            /*       if (list[position] == selectedOption)
                       holder.ct_option.isChecked = true*/

            holder.ct_option.isChecked = (result.selected_opt == holder.ct_option.text)

        }

        //  holder.ct_option.isChecked = (      currentitemSelected == holder.adapterPosition)

        holder.bind(list)


        //  holder.ct_option.isChecked = currentitemSelected == position


        //   lastItemSelectedPos = currentitemSelected


        /*   if (holder.ct_option.text == hashMapAnswers[myadapterPosition]) {

               holder.ct_option.setChecked(true)
               //    holder.ct_option.setBackgroundColor(Color.parseColor("#567845"))
           }
           correctAnswers(holder, hashMapCorrectAnswers, myadapterPosition)*/


        //clicklistner
        /*  holder.ct_option.setOnClickListener { adapterView ->
              currentitemSelected = holder.adapterPosition
              //    hashMapAnswers.put(myadapterPosition, list[position])
              notifyDataSetChanged()

          }*/


    }


    override fun getItemCount(): Int {
        return list.size
    }

    /*  fun correctAnswers(
          holder: MyRvAdapter.ListViewHolder,
          hashMapCorrectAnswers: HashMap<Int, String>,
          myadapterPosition: Int
      ) {

          if (holder.ct_option.text == hashMapCorrectAnswers[myadapterPosition]) {
              //  holder.ct_option.setChecked(true)
              holder.ct_option.setBackgroundColor(Color.parseColor("#6CB66B"))

          }

      }*/

    class RvOnClickListener(val clickListener: (result: Result) -> Unit) {

        fun onClick(result: Result) = clickListener(result)

    }
}



