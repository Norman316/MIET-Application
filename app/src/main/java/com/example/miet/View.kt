package com.example.miet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.miet.databinding.ActivityViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class View : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var view: Upload
    private lateinit var uid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        firebaseAuth = FirebaseAuth.getInstance()
        uid = firebaseAuth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("UploadGoods")

        if(uid.isNotEmpty()){

            getUploadData()
        }

        binding.fab.setOnClickListener{
            val intent = Intent(this, Upload::class.java)
            startActivity(intent)
        }

    }

    private fun getUploadData() {

        databaseReference.child(uid).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                view = snapshot.getValue(Upload::class.java)!!
                binding.textView3.text = view.amount
                binding.textView4.text = view.cnumber
                binding.textView5.text = view.date
                binding.textView6.text = view.cvv
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}