package com.example.hw_1_5month

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.homework_1_4month.MainPresenter
import com.example.hw_1_5month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContact {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = MainPresenter()

    private val contract = object: CounterContact{
        override fun showResult(count: Int) {
            binding.tvCount.text = count.toString()
        }

        override fun showToast(context: String) {

        }

        override fun changeColor() {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        presenter.attachContract(contract)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }

            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }

    }

    override fun showResult(count: Int) = with(binding) {
        tvCount.text = count.toString()
    }

    override fun showToast(context: String) {
        Toast.makeText(this,context,Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.tvCount.setTextColor(ContextCompat.getColor(this,R.color.green))
    }

    override fun onDestroy() {
        presenter.detachContact()
        super.onDestroy()

    }
}