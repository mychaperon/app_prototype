import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clement.app_prototype.Contact;
import com.example.clement.app_prototype.R;

import java.util.List;

/**
 * Created by Clement on 08/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List< Contact > contactList;
    private View.OnLongClickListener longClickListener;

    public RecyclerViewAdapter(List<Contact> contactList, View.OnLongClickListener longClickListener) {
        this.contactList = contactList;
        this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.itemTextView.setText(contact.getName());
        //holder.nameTextView.setText(borrowModel.getPersonName());
        //holder.dateTextView.setText(borrowModel.getBorrowDate().toLocaleString().substring(0, 11));
        holder.itemView.setTag(contact);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void addItems(List<Contact> borrowModelList) {
        this.contactList = borrowModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
     // private TextView nameTextView;
     // private TextView dateTextView;

        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = (TextView) view.findViewById(R.id.itemTextView);
          //  nameTextView = (TextView) view.findViewById(R.id.nameTextView);
          //  dateTextView = (TextView) view.findViewById(R.id.dateTextView);
        }
    }}

