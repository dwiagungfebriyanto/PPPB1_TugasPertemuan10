package com.example.myclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myclass.databinding.ActivityProfileDetailBinding

class ProfileDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            // Mendapatkan data dari intent yang dikirim dari activity sebelumnya
            val studentProfileImage = intent.getIntExtra("student_profile_image", R.drawable.img_profile_placeholder)
            val studentGpa          = intent.getDoubleExtra("student_gpa", 0.0)
            val studentSKSK         = intent.getIntExtra("student_credits", 0)
            val studentSemester     = intent.getIntExtra("student_semester", 0)

            // Menampilkan gambar profil mahasiswa
            imgProfile.setImageResource(studentProfileImage)
            // Menampilkan nama mahasiswa
            txtStudentName.text = intent.getStringExtra("student_name")
            // Menampilkan IPK mahasiswa
            txtGpa.text = studentGpa.toString()
            // Menampilkan jumlah SKS
            txtCredits.text = studentSKSK.toString()
            // Menampilkan semester
            txtSemester.text = studentSemester.toString()
            // Menampilkan NIM mahasiswa
            txtStudentId.text = intent.getStringExtra("student_id")
            // Menampilkan deskripsi singkat tentang mahasiswa
            txtAbout.text = intent.getStringExtra("student_about")

            // Mengganti latar belakang profil berdasarkan IPK
            if (studentGpa >= 3) {
                flImgProfile.setBackgroundResource(R.drawable.outline_profile_green)
            } else if (studentGpa >= 2) {
                flImgProfile.setBackgroundResource(R.drawable.outline_profile_yellow)
            } else {
                flImgProfile.setBackgroundResource(R.drawable.outline_profile_red)
            }

            // Mengatur tombol "Back" untuk kembali ke aktivitas sebelumnya
            btnBack.setOnClickListener {
                onBackPressed()
            }

            llGpa.setOnLongClickListener(View.OnLongClickListener {
                Toast.makeText(this@ProfileDetailActivity, "Indeks Prestasi Kumulatif", Toast.LENGTH_SHORT).show()
                true
            })
            llCredits.setOnLongClickListener(View.OnLongClickListener {
                Toast.makeText(this@ProfileDetailActivity, "Satuan Kredit Semester Kumulatif", Toast.LENGTH_SHORT).show()
                true
            })
            llSemester.setOnLongClickListener(View.OnLongClickListener {
                Toast.makeText(this@ProfileDetailActivity, "Semester", Toast.LENGTH_SHORT).show()
                true
            })
        }
    }
}