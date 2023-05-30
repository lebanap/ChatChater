package com.example.chatchater;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{
    List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_process, null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        //Log.i("info", message.toString());
        //System.out.println(message);
        if (message.getSentBy() != null && message.getSentBy().equals(Message.SENT_BY_ME))
        {
            holder.aiChat.setVisibility(View.GONE);
            holder.userChat.setVisibility(View.VISIBLE);
            holder.userChatText.setText(message.getMessage());
        }
        else
        {
            holder.userChat.setVisibility(View.GONE);
            holder.aiChat.setVisibility(View.VISIBLE);
            holder.aiChatText.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout aiChat, userChat;
        TextView aiChatText, userChatText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            aiChat = itemView.findViewById(R.id.aiChat);
            userChat = itemView.findViewById(R.id.userChat);
            aiChatText = itemView.findViewById(R.id.aiChatText);
            userChatText = itemView.findViewById(R.id.userChatText);
        }
    }
}
