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
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private ContactStorage storage;
    private ContactListAdapter adapter;
    private boolean isAscending = true;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        storage = ContactStorage.getInstance();
        adapter = new ContactListAdapter(getApplicationContext(), storage.getContacts());
        recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), storage.getContacts()));
        recyclerView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void sortByGroup(View view) {
        ArrayList<Contact> contacts = storage.getContacts();
        if (contacts == null || contacts.isEmpty()) return;

        // Sort using an anonymous function (Lambda)
        Collections.sort(contacts, (c1, c2) -> isAscending
                ? c1.getContactGroup().compareTo(c2.getContactGroup())
                : c2.getContactGroup().compareTo(c1.getContactGroup()));

        // Use an Iterator to traverse after sorting
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            System.out.println(contact.getContactGroup() + " - " + contact.getFullName());
        }

        adapter.notifyDataSetChanged(); // Refresh RecyclerView
        isAscending = !isAscending; // Toggle sorting order
    }
    public void switchToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }
    public void SortAlphabetically(View view) {
        ArrayList<Contact> contacts = storage.getContacts();
        if (contacts == null || contacts.isEmpty()) return;


        Collections.sort(contacts, (c1, c2) -> isAscending
                ? c1.getFirstName().compareTo(c2.getFirstName())
                : c2.getFirstName().compareTo(c1.getFirstName()));

        adapter.notifyDataSetChanged();
        isAscending = !isAscending;
    }






}