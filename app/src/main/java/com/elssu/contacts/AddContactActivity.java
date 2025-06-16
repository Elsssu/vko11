package com.elssu.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {

    private EditText FirstnameInput;
    private EditText LastNameInput;
    private EditText NumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirstnameInput = findViewById(R.id.FirstNameEdit);
        LastNameInput = findViewById(R.id.LastNameEdit);
        NumberInput = findViewById(R.id.PhoneNumberEdit);
    }
    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addContact(View view) {
        String firstName = String.valueOf(FirstnameInput.getText());
        String lastName = String.valueOf(LastNameInput.getText());
        String number = String.valueOf(NumberInput.getText());
        String contactGroup = null;

        RadioGroup rgContactType = findViewById(R.id.ContactTypeRadioGroup);
        if (rgContactType.getCheckedRadioButtonId() == R.id.WorkRadioButton) {
            contactGroup = "Työ";
        }
        else if (rgContactType.getCheckedRadioButtonId() == R.id.PersonalRadioButton) {
            contactGroup = "Henkilökohtainen";

        }
        ContactStorage.getInstance().addContact(new Contact(firstName, lastName, number, contactGroup));
    }

}