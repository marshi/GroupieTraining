package marshi.app

import com.example.androidtemplate.R
import com.example.androidtemplate.databinding.AppItemBinding
import com.xwray.groupie.*
import com.xwray.groupie.databinding.BindableItem

class Adapter : GroupAdapter<GroupieViewHolder>() {

    private val group: ExpandableGroup

    init {

        val expandableSection = ExpandableSection().apply {
            val list = List(2) { _ ->
                Item("aiueo")
            }
            this.addAll(list)
        }
        group = ExpandableGroup(expandableSection).apply {
            val list = List(2) { _ ->
                Item("iiiii")
            }
            this.add(Section().apply { addAll(list) })
        }
        add(group)
    }

    var isExtend: Boolean = false
        set(value) {
            group.isExpanded = value
            field = value
        }
        get() = group.isExpanded
}

class Item(val text: String) : BindableItem<AppItemBinding>() {
    override fun getLayout(): Int = R.layout.app_item

    override fun bind(viewBinding: AppItemBinding, position: Int) {
        viewBinding.text.text = text
    }
}

class ExpandableSection : Section(), ExpandableItem {
    private lateinit var group: ExpandableGroup
    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        group = onToggleListener
    }
}
