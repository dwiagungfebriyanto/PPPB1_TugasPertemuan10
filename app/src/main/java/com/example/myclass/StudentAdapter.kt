package com.example.myclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myclass.databinding.ItemStudentBinding

// Membuat alias untuk tipe data yang digunakan sebagai tindakan ketika mahasiswa diklik
typealias OnClickStudent = (Student) -> Unit

class StudentAdapter(private val listStudent: List<Student>, private val onClickStudent: OnClickStudent) : RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder(private val binding: ItemStudentBinding) :
            RecyclerView.ViewHolder(binding.root) {

                // Fungsi untuk mengikat data mahasiswa ke tampilan
                fun bind(data : Student) {
                    with(binding) {
                        // Menampilkan nama mahasiswa
                        txtStudentName.text = data.name
                        // Menampilkan NIM mahasiswa
                        txtStudentId.text = data.id
                        // Menampilkan gambar profil mahasiswa
                        imgProfile.setImageResource(data.profileImageId)

                        // Mengganti latar belakang profil berdasarkan IPK
                        if (data.gpa >= 3) {
                            flImgProfile.setBackgroundResource(R.drawable.outline_profile_green)
                        } else if (data.gpa >= 2) {
                            flImgProfile.setBackgroundResource(R.drawable.outline_profile_yellow)
                        } else {
                            flImgProfile.setBackgroundResource(R.drawable.outline_profile_red)
                        }

                        // Menambahkan tindakan ketika item mahasiswa diklik
                        itemView.setOnClickListener{
                            onClickStudent(data)
                        }
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }
}