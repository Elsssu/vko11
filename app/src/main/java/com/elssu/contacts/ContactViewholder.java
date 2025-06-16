package com.elssu.contacts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewholder extends RecyclerView.ViewHolder {

    ImageView ProfilePic, contactDetails, contactDelete;
    TextView Name, phoneNumber, contactType;
    public ContactViewholder(@NonNull View itemView) {
        super(itemView);
        ProfilePic = itemView.findViewById(R.id.ProfilePic);
        Name = itemView.findViewById(R.id.ContactNameText);
        phoneNumber = itemView.findViewById(R.id.ContactNumberText);
        contactType = itemView.findViewById(R.id.ContactGroupText);
        contactDetails = itemView.findViewById(R.id.ContactDetailsButton);
        contactDelete = itemView.findViewById(R.id.ContactDeleteButton);



    }
}
