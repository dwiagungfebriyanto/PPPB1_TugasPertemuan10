package com.example.myclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterStudent = StudentAdapter(generateStudents()) { student ->
            // Menampilkan pesan Toast ketika item mahasiswa di-klik
            Toast.makeText(this@MainActivity, "Menampilkan profil ${student.name}", Toast.LENGTH_SHORT).show()

            // Membuat Intent untuk berpindah ke halaman detail profil mahasiswa
            val intent = Intent(this@MainActivity, ProfileDetailActivity::class.java)

            // Menambahkan data mahasiswa ke dalam Intent
            intent.putExtra("student_profile_image", student.profileImageId)
            intent.putExtra("student_name", student.name)
            intent.putExtra("student_id", student.id)
            intent.putExtra("student_gpa", student.gpa)
            intent.putExtra("student_credits", student.credits)
            intent.putExtra("student_semester", student.semester)
            intent.putExtra("student_about", student.about)

            // Memulai aktivitas baru dengan Intent
            startActivity(intent)
        }

        with(binding) {
            rvStudents.apply {
                // Mengatur adapter untuk RecyclerView
                adapter = adapterStudent

                // Mengatur LayoutManager untuk RecyclerView
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateStudents(): List<Student> {
        return listOf(
            Student(
                "Langit Lintang Radjendra",
                "22/501269/SV/21425",
                3.75, 38, 3,
                "Langit adalah mahasiswa teladan yang rajin belajar dan selalu memberikan yang terbaik. Dia memiliki semangat tinggi dalam mengikuti kegiatan kampus.",
                R.drawable.img_profile_llr),
            Student(
                "Tsania Qurrota A'yunin Qulub",
                "22/505618/SV/21839", 2.65, 16, 2,
                "Tsania adalah mahasiswa yang ceria dan aktif dalam organisasi kampus. Dia memiliki bakat dalam seni dan sering tampil di acara seni kampus."),
            Student(
                "Sena Aji Bayu Murti",
                "22/505018/SV/21751",
                3.85, 10, 1,
                "Sena adalah mahasiswa berprestasi yang baru saja masuk kuliah. Dia memiliki keinginan kuat untuk berhasil dalam studi dan karirnya.",
                R.drawable.img_profile_sabm),
            Student(
                "Andhika Yoga Pratama",
                "22/499593/SV/21342",
                1.95, 58, 4,
                "Andhika adalah mahasiswa yang memiliki semangat sosial tinggi. Dia sering terlibat dalam kegiatan sosial dan suka membantu orang lain.",
                R.drawable.img_profile_ayp),
            Student(
                "Hayya Fatihatuz Zahra",
                "22/505619/SV/21840",
                3.45, 38, 3,
                "Hayya adalah mahasiswa yang cerdas dan penuh semangat. Dia juga aktif dalam kegiatan keagamaan di kampus.",
                R.drawable.img_profile_hfz),
            Student(
                "Ajeng Cerelia Evin",
                "22/506178/SV/22102",
                2.85, 98, 6,
                "Ajeng adalah mahasiswa yang memiliki pengalaman dan wawasan luas. Dia sering memberikan pengaruh positif pada rekan-rekannya."),
            Student(
                "Adiel Boanerge Gananputra",
                "22/500051/SV/21386",
                3.25, 38, 3,
                "Adiel adalah mahasiswa yang berdedikasi dan selalu berusaha keras untuk mencapai tujuannya. Dia memiliki bakat di bidang penulisan.",
                R.drawable.img_profile_abg),
            Student(
                "Isan Faizun Hidar",
                "22/500411/SV/21417",
                3.15, 118, 9,
                "Isan adalah mahasiswa yang sukses dan berpengalaman. Dia sering memberikan ceramah inspiratif kepada mahasiswa lain.",
                R.drawable.img_profile_ifh),
            Student(
                "Lutfi Lisana Shidqi",
                "22/505926/SV/21998",
                1.75, 158, 12,
                "Lutfi adalah mahasiswa yang memiliki semangat tinggi dalam kegiatan olahraga. Dia sering menjadi kapten tim dalam turnamen olahraga kampus.",
                R.drawable.img_profile_lls)
        )
    }

}