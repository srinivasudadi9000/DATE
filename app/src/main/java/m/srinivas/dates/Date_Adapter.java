package m.srinivas.dates;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by srinivas on 01/02/18.
 */

public class Date_Adapter extends RecyclerView.Adapter<Date_Adapter.Date_holder> {
    Context context;
    private int rowLayout;
    ArrayList<CustomDate> customDates;
    Date_Adapter(Context context,ArrayList<CustomDate> customDates,int rowlayout){
        this.customDates = customDates;;
         this.context = context;
         this.rowLayout = rowlayout;
    }
    @Override
    public Date_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new Date_holder(view);
    }

    @Override
    public void onBindViewHolder(Date_holder holder, int position) {
        holder.date.setText(customDates.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return customDates.size();
    }

    class Date_holder extends RecyclerView.ViewHolder{
        TextView date;
        public Date_holder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
