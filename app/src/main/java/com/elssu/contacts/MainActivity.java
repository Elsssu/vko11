package com.elssu.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private ContactStorage storage;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        storage = ContactStorage.getInstance();

        recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), storage.getContacts()));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void switchToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }
    public void SortAlphabetically(View view) {
        Collections.sort(storage.getContacts(), Comparator.comparing(Contact::getFirstName));
        Iterator<Contact> iterator = ContactStorage.getInstance().getContacts().iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            System.out.println(contact.getFirstName() + " - " + contact.getFullName());
        }
        //ContactListAdapter.notifyDataSetChanged();

    }
    public void sortByGroup(View view) {
        ArrayList<Contact> contacts = storage.getContacts();
        if (contacts == null || contacts.isEmpty()) return;

        Collections.sort(contacts, (c1, c2) -> c1.getContactGroup().compareTo(c2.getContactGroup()));

        contacts.iterator().forEachRemaining(c -> System.out.println(c.getContactGroup() + " - " + c.getFullName()));


    }





}