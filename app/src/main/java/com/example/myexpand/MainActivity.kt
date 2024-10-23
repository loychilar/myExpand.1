package com.example.myexpand

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myexpand.adapters.MyExpandAdapter
import com.example.myexpand.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyExpandAdapter.ExpandAction {
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    lateinit var myExpandAdapter: MyExpandAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val map = HashMap<String,ArrayList<String>>()
        val android19 = arrayListOf("Alisher","Ibroximjon","Abdumajid aka","Man","Xojakbar")
        val android20 = arrayListOf("Muhammadodil","Elbek","Farrux","Yosir","Boburjon")
        val android23 = arrayListOf("Muhammadsolih","Abdulbosit","Asadbek","Man")

        val titleList = arrayListOf("android19","android20","android21")
        map[titleList[0]] = android19
        map[titleList[1]] = android20
        map[titleList[2]] = android23

        myExpandAdapter = MyExpandAdapter(map,titleList,this)
        binding.myExpand.setAdapter(myExpandAdapter)
    }

    override fun groupClick(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    override fun childClick(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

}