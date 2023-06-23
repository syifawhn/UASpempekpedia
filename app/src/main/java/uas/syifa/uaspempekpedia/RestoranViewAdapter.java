package uas.syifa.uaspempekpedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uas.syifa.uaspempekpedia.databinding.ItemRestoranBinding;

public class RestoranViewAdapter extends RecyclerView.Adapter<RestoranViewAdapter.ViewHolder> {
    private OnItemClickCallback onItemClickCallback;

    private List<NewrestoranItem> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData(List<NewrestoranItem> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public RestoranViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RestoranViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(View v, NewrestoranItem item, int position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(NewrestoranItem item);
    }
}
