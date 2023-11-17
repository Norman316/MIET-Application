package com.example.miet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miet.databinding.ActivityUploadGoodsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadGoods : AppCompatActivity() {
    private lateinit var binding:ActivityUploadGoodsBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadGoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("UploadGoods")

        binding.saveButton.setOnClickListener {

            val amount = binding.etAmount.text.toString()
            val card = binding.etCardNumber.text.toString()
            val date = binding.etExpiryDate.text.toString()
            val cvv = binding.etCVV.text.toString()


            val pay = Upload(amount,card,date,cvv)

            if(uid!= null){

                databaseReference.child(uid).setValue(pay).addOnCompleteListener {

                    Toast.makeText(this@UploadGoods, "Upload Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }
            }else{
                Toast.makeText(this@UploadGoods, "Upload unSuccessful", Toast.LENGTH_SHORT).show()
            }
        }

    }
}