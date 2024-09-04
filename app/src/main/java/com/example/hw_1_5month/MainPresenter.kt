package com.example.homework_1_4month

import com.example.hw_1_5month.CounterContact
import com.example.hw_1_5month.CounterModel

class MainPresenter {

    private val model = CounterModel()
    private var contact: CounterContact? = null

    fun attachContract(contact: CounterContact) {
        this.contact = contact
        contact.showResult(model.count)
    }

    fun onIncrement() {
        model.increment()
        contact?.showResult(model.count)
        if (model.geTCount() == 10) {
            contact?.showToast("Поздравляем")
        } else if (model.geTCount() == 15) {
            contact?.changeColor()
        }
    }

    fun onDecrement() {
        model.decrement()
        contact?.showResult(model.count)
    }

    fun detachContact() {
        contact = null
    }

}