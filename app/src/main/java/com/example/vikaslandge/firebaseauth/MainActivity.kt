package com.example.vikaslandge.firebaseauth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance();
        Loginbutton.setOnClickListener {
            mAuth!!.signInWithEmailAndPassword(editTextEmail.text.toString(),editText2Pass.text.toString()).addOnCompleteListener {
                if (it.isSuccessful){
                    var i= Intent(this,login::class.java)
                    startActivity(i)
                    Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"login Fail",Toast.LENGTH_LONG).show()

                }
            }
        }
        RegisterButton.setOnClickListener {
            if(editTextEmail.text.toString().isEmpty()&&editText2Pass.text.toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();

                //if (editText2Pass.length() < 6) {
                  //  Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth!!.createUserWithEmailAndPassword(editTextEmail.text.toString(), editText2Pass.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Registration Fail", Toast.LENGTH_LONG).show()

                        }


                }
            }

        }
    }
}
