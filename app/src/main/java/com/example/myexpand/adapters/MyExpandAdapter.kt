package com.example.myexpand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.myexpand.databinding.ItemChildBinding
import com.example.myexpand.databinding.ItemParentBinding

class MyExpandAdapter(var map: HashMap<String,ArrayList<String>>,var titleList: ArrayList<String>,var expandAction: ExpandAction):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemParent=ItemParentBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemParent.tvNameParent.text = titleList[groupPosition]

        return itemParent.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemChild= ItemChildBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemChild.tvNameChild.text = map[titleList[groupPosition]]?.get(childPosition)
        itemChild.root.setOnClickListener {
            expandAction.childClick(map[titleList[groupPosition]]?.get(childPosition)!!)
        }
        return itemChild.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
    interface ExpandAction{
        fun groupClick(name:String)
        fun childClick(name: String)
    }
}