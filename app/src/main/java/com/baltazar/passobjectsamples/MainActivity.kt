package com.baltazar.passobjectsamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.baltazar.passobjectsamples.dataClasses.Job
import com.baltazar.passobjectsamples.dataClasses.Person
import com.baltazar.passobjectsamples.extensions.bindView
import com.baltazar.passobjectsamples.extensions.bindViews

class MainActivity : AppCompatActivity() {


    private val mInputValues: List<EditText>
            by bindViews(R.id.edit_text_person_name, R.id.edit_text_person_age, R.id.edit_text_job_title, R.id.edit_text_job_salary)

    private val mButtonDialog: Button by bindView(R.id.button_show_dialog)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mButtonDialog.setOnClickListener {
            if (isFormComplete()) {
                val person = createPerson()
                val dialog = PersonDataDialog.newInstance(person)
                dialog.show(supportFragmentManager, "person_data")
            } else {
                Toast.makeText(this, "Data incomplete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isFormComplete(): Boolean {
        return mInputValues.any { it.text.toString().isNotBlank() }
    }

    private fun createPerson(): Person {
        val job = Job(mInputValues[2].text.toString(), mInputValues[3].text.toString().toInt())
        return Person(mInputValues[0].text.toString(), mInputValues[1].text.toString().toInt(), job)
    }
}
