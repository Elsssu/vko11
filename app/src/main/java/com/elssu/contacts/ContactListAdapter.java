package com.elssu.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewholder> {

    private Context context;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewholder(LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewholder holder, int position) {
        holder.Name.setText(contacts.get(position).getFullName());
        holder.phoneNumber.setText(String.valueOf(contacts.get(position).getNumber()));
        holder.contactType.setText(contacts.get(position).getContactGroup());
        holder.ProfilePic.setImageResource(contacts.get(position).getImage());

        holder.contactDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                ContactStorage.getInstance().removeContact(contacts.get(pos).getFullName());
                notifyItemRemoved(pos);
            }
        });

        holder.contactDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if (holder.phoneNumber.getVisibility() == View.INVISIBLE) {
                    holder.phoneNumber.setVisibility(View.VISIBLE);
                    holder.contactType.setVisibility(View.VISIBLE);
                }
                else {
                    holder.phoneNumber.setVisibility(View.INVISIBLE);
                    holder.contactType.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
