package com.example.baitap1

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baitap1.User
import com.example.baitap1.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter(userList)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val buttonSave: Button = findViewById(R.id.buttonSave)
        buttonSave.setOnClickListener { saveUserInfo() }
    }

    private fun saveUserInfo() {
        val name = findViewById<EditText>(R.id.editTextName).text.toString()
        val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
        val phone = findViewById<EditText>(R.id.editTextPhone).text.toString()
        val gender = when (findViewById<RadioGroup>(R.id.radioGroupGender).checkedRadioButtonId) {
            R.id.radioMale -> "Nam"
            R.id.radioFemale -> "Nữ"
            R.id.radioOther -> "Khác"
            else -> ""
        }

        val checkBoxTerms: CheckBox = findViewById(R.id.checkBoxTerms)
        if (checkBoxTerms.isChecked) {
            val user = User(name, email, phone, gender)
            userList.add(user)
            userAdapter.notifyItemInserted(userList.size - 1)
            clearFields()
        } else {
            Toast.makeText(this, "Bạn cần đồng ý với điều khoản sử dụng.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearFields() {
        findViewById<EditText>(R.id.editTextName).text.clear()
        findViewById<EditText>(R.id.editTextEmail).text.clear()
        findViewById<EditText>(R.id.editTextPhone).text.clear()
        findViewById<RadioGroup>(R.id.radioGroupGender).clearCheck()
        findViewById<CheckBox>(R.id.checkBoxTerms).isChecked = false
    }
}