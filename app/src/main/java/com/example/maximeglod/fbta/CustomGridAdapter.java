package com.example.maximeglod.fbta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGridAdapter extends BaseAdapter {

    //Propriétés
    public static Map<String, Map<Integer, Integer>> caltolMap = new HashMap<>();
    public static Map<String, Map<Integer, Integer>> dateMap = new HashMap<>();
    //Hashmap des quantités
    public static Map<Integer, Integer> maMap = new HashMap<>();
    //Hashmap des calories
    public static Map<Integer, Integer> calMap = new HashMap<>();
    private static AccesLocal accesLocal;
    private List<Aliments> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomGridAdapter(Context aContext, List<Aliments> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        //Retourne la taille de la liste
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        //Retourne la position de l'item dans la liste
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Retourne la position de l'élément dans l'item de la liste
        return position;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {
        accesLocal = new AccesLocal(context);


        String date = MainAliments.recup_date;

        final String date2 = date.toString();

        final ViewHolder holder;
        ViewHolder holder1;
        if (convertView == null) {
            //On récupère les éléments de notre vue
            convertView = layoutInflater.inflate(R.layout.grid_item_layout, null);
            holder1 = new ViewHolder();
            holder1.imagealimentsView = (ImageView) convertView.findViewById(R.id.imageView_imagealiments);
            holder1.alimentsNameView = (TextView) convertView.findViewById(R.id.textView_alimentsName);
            holder1.caloriesView = (TextView) convertView.findViewById(R.id.textView_calories);
            holder1.qteView = (TextView) convertView.findViewById(R.id.textView_qte);
            holder1.totalcalories = (TextView) convertView.findViewById(R.id.totalcalories);

            holder1.qteView.setTag(position);
            convertView.setTag(holder1);
        }
        //Initialisation de holder1
        holder1 = (ViewHolder) convertView.getTag();
        holder = holder1;

        //On récupère les buttons d'ajout et de retrait d'une unité de quantité
        final ImageView add = (ImageView) convertView.findViewById(R.id.button_add);
        ImageView rm = (ImageView) convertView.findViewById(R.id.button_rm);

        //Listner du button de retrait d'une unité de quantité
        rm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //On donne la vue au button
                rm(v);
            }

            private void rm(View v) {
                //On récupère la vue du button
                ImageView rm = (ImageView) v;
                //calcul du total calorique de l'aliments en fonction de sa quantité
                //Récupération de la valeur calorique
                int b = Integer.parseInt(holder.caloriesView.getText().toString());
                //Récupération de la quantité
                int a = Integer.parseInt(holder.qteView.getText().toString()) - 1;
                //Calcul du produit quantité * calories
                int c = a * b;
                int qtecalorie = c;

                //Boucle permetant de ne pas avoir de total négatif quand on retire des quantités
                if (qtecalorie >= 0) {
                    //Ajout de la valeur calculé dans un hashmap dédié au calcul du total calorique

                    if ((accesLocal.checkalimentation(date2, position)) != "ok") {
                        accesLocal.ajoutalimentation(date2, position, qtecalorie);
                    } else {
                        accesLocal.modifalimentation(date2, position, qtecalorie);
                    }

                }

                //Si on clique sur le button -
                if (rm.isClickable()) {
                    //On enlève 1 à la quantité seulement si elle n'est pas null
                    if (Integer.parseInt(holder.qteView.getText().toString()) > 0) {
                        int qte2 = Integer.parseInt(holder.qteView.getText().toString()) - 1;
                        //Ajout de la valeur en quantité modifié dans un HashMap dédié

                        if ((accesLocal.checkalimentation2(date2, position)) != "ok") {
                            accesLocal.ajoutalimentation2(date2, position, qte2);
                        } else {
                            accesLocal.modifalimentation2(date2, position, qte2);
                        }


                    }
                }

                //Si le HashMap de contient pas la position de l'aliment, alors il n'a pas été modifié donc
                //on défini la quantité à 0 (Sinon la vue est "regonflé")
                maMap.get(position);


                if ((accesLocal.checkalimentation2(date2, position)) != null) {
                    holder.qteView.setText(Integer.toString(accesLocal.qtealiment(date2, position)));
                } else {
                    holder.qteView.setText("0");
                }

            }
        });

        //Listner du button d'ajout d'une unité de quantité
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //On donne la vue au button
                add(v);
            }

            private void add(View v) {

                //calcul du total calorique de l'aliments en fonction de sa quantité
                //Récupération de la valeur calorique
                int b = Integer.parseInt(holder.caloriesView.getText().toString());
                //Récupération de la quantité
                int a = Integer.parseInt(holder.qteView.getText().toString()) + 1;
                //Calcul du produit quantité * calories
                int c = a * b;
                int qtecalorie = c;

                //Ajout de la valeur calculé dans un hashmap dédié au calcul du total calorique

                if ((accesLocal.checkalimentation(date2, position)) != "ok") {
                    accesLocal.ajoutalimentation(date2, position, qtecalorie);
                } else {
                    accesLocal.modifalimentation(date2, position, qtecalorie);
                }


                //Si on clique sur le button +
                if (add.isClickable()) {


                    Boolean verif3 = (caltolMap.get(date2)).isEmpty();
                    if (verif3 == true) {
                    }
                    ;
                    //Augmentation de +1 de la quantité
                    int qte2 = Integer.parseInt(holder.qteView.getText().toString()) + 1;


                    if ((accesLocal.checkalimentation2(date2, position)) != "ok") {
                        accesLocal.ajoutalimentation2(date2, position, qte2);
                    } else {
                        accesLocal.modifalimentation2(date2, position, qte2);
                    }


                }

                //Si le HashMap de contient pas la position de l'aliment, alors il n'a pas été modifié donc
                //on défini la quantité à 0 (Sinon la vue est "regonflé")


                if ((accesLocal.checkalimentation2(date2, position)) != null) {
                    holder.qteView.setText(Integer.toString(accesLocal.qtealiment(date2, position)));
                } else {
                    holder.qteView.setText("0");
                }
            }

        });


        //On alimente la vue avec les données de la liste
        Aliments aliments = this.listData.get(position);
        holder.alimentsNameView.setText(aliments.getNomalimentsName());
        holder.caloriesView.setText("" + aliments.getCalories());

        //Si le HashMap de contient pas la position de l'aliment, alors il n'a pas été modifié donc
        //on défini la quantité à 0 (Sinon la vue est "regonflé")


        Boolean verif2 = (accesLocal.checkalimentation2(date2, position)) != "ok";
        if (verif2 == true) {

            if ((accesLocal.checkalimentation2(date2, position)) != null) {
                holder.qteView.setText(Integer.toString(accesLocal.qtealiment(date2, position)));

            } else {

                holder.qteView.setText(Integer.toString(accesLocal.qtealiment(date2, position)));
            }
        } else {

            holder.qteView.setText(Integer.toString(accesLocal.qtealiment(date2, position)));
        }


        //On va chercher les images correspondantes aux nom d'aliments
        int imageId = this.getMipmapResIdByName(aliments.getImagealimentsName());
        holder.imagealimentsView.setImageResource(imageId);
        //On retourne la vue complétée
        return convertView;

    }

    //Trouver l'image id correspondant au nom de l'image dans le dossier mipmap
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return resID;
    }


    static class ViewHolder {
        public ImageView imagealimentsView;
        TextView alimentsNameView;
        TextView caloriesView;
        TextView qteView;
        TextView totalcalories;
    }


}