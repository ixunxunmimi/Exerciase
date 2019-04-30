package e.l.exercise430.poem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import e.l.exercise430.R;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PoemAdapter extends XRecyclerView.Adapter<PoemAdapter.ViewHolder>{

    List<PoemBean.ResultBean> result = new ArrayList<>();
    private Context context;

    public void refresh(List<PoemBean.ResultBean> result){
        this.result.addAll(result);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_poem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title_textview.setText(result.get(i).getTitle());
        viewHolder.author_textview.setText(result.get(i).getAuthors());
        viewHolder.content_textview.setText(result.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder{

        TextView title_textview,content_textview,author_textview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_textview = itemView.findViewById(R.id.title_tv);
            content_textview = itemView.findViewById(R.id.content_tv);
            author_textview = itemView.findViewById(R.id.author_tv);
        }
    }
}
