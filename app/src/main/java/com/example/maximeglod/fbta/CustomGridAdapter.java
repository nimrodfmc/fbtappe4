package com.example.maximeglod.fbta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class CustomGridAdapter extends BaseAdapter {

    private List<Aliments> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomGridAdapter(Context aContext, List<Aliments> listData){
        this.context= aContext;
        this.listData= listData;
        layoutInflater= LayoutInflater.from(aContext);
    }

    @Override
    public int getCount(){
        return listData.size();
    }
    @Override
    public Object getItem(int position){
        return listData.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.grid_item_layout, null);
            holder = new ViewHolder();
            holder.imagealimentsView = (ImageView) convertView.findViewById(R.id.imageView_imagealiments);
            holder.alimentsNameView = (TextView) convertView.findViewById(R.id.textView_alimentsName);
            holder.caloriesView = (TextView) convertView.findViewById(R.id.textView_calories);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Aliments aliments = this.listData.get(position);
        holder.alimentsNameView.setText(aliments.getNomalimentsName());
        holder.caloriesView.setText(""+aliments.getCalories());

        int imageId = this.getMipmapResIdByName(aliments.getImagealimentsName());
        holder.imagealimentsView.setImageResource(imageId);
        return convertView;
    }
    //Trouver l'image id correspondant au nom de l'image dans le dossier mipmap
    public int getMipmapResIdByName(String resName){
        String pkgName = context.getPackageName();
        //Retourner 0 si non trouver
        int resID = context.getResources().getIdentifier(resName, "mipmap",pkgName);
        return resID;
    }
    static class ViewHolder {
        public ImageView imagealimentsView;
        ImageView imagesalimentsView;
        TextView alimentsNameView;
        TextView caloriesView;
    }
}

