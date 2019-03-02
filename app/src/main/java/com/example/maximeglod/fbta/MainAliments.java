package com.example.maximeglod.fbta;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Dimension;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.example.maximeglod.fbta.CustomGridAdapter.calMap;
import static com.example.maximeglod.fbta.CustomGridAdapter.maMap;

public class MainAliments extends AppCompatActivity {

    public static String recup_date;
    private static AccesLocal accesLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliments);
        accesLocal = new AccesLocal(getApplicationContext());
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        recup_date = date;
        String date2 = date.toString();

        //récupération de l'objectif calorique
        TextView objcal = (TextView) findViewById(R.id.objectif);
        String objecutilisateur = Integer.toString(accesLocal.totalcal());
        objcal.setText(objecutilisateur);


        Boolean verif = dateMap.containsKey(date2);

        if (verif==true){

        }else {


            dateMap.put(date2,new HashMap<Integer, Integer>());
            (dateMap.get(date2)).put(900000,900000);

            caltolMap.put(date2,new HashMap<Integer, Integer>());
            //(caltolMap.get(date2)).put(8000,0);


        }

        // dateMap.put(date2,new HashMap<Integer, Integer>());

        //Instance de Handler pour lancer une fonction à intervalle de temps régulier
        myHandler = new Handler();
        myHandler.postDelayed(myRunnable, 5);


        List<Aliments> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);

        //On utilise notre adapter pour la liste des aliments
        gridView.setAdapter(new CustomGridAdapter(this, image_details));

    }

    //Saisie de tous les aliments en dur

    private List<Aliments> getListData() {
        List<Aliments> list = new ArrayList<Aliments>();
        Aliments ail = new Aliments("Ail", "ail", 5);
        Aliments ailenpoudre = new Aliments("Ail en poudre", "ailenpoudre", 333);
        Aliments amendesblanchiessechees = new Aliments("Amandes Blanchies", "amandesblanchiessechees", 586);
        Aliments amandessechees = new Aliments("Amandes séchées", "amandessechees", 589);
        Aliments anethfraiche = new Aliments("Aneth Fraiche", "anethfraiche", 43);
        Aliments anethsechee = new Aliments("Aneth Séchée", "anethsechee", 253);
        Aliments aromedevanille = new Aliments("Arôme de Vanille", "aromedevanille", 56);
        Aliments aromedevanillealcool = new Aliments("Arôme de Vanille Alcoolisé", "aromedevanillealcool", 237);
        Aliments asperges = new Aliments("Asperges", "asperges", 28);
        Aliments aubergine = new Aliments("Aubergine", "aubergine", 29);
        Aliments avocat = new Aliments("Avocat", "avocat", 208);
        Aliments bacon = new Aliments("Bacon", "bacon", 270);
        Aliments baguette = new Aliments("Baguette", "baguette", 638);
        Aliments banane = new Aliments("Banane", "banane", 100);
        Aliments bananesechee = new Aliments("Banane Séchées", "bananesechee", 292);
        Aliments barloup = new Aliments("Bar Loup", "barloup", 98);
        Aliments basilicfrais = new Aliments("Basilic Frais", "basilicfrais", 27);
        Aliments basilicfinesherbes = new Aliments("Basilic Fines Herbes", "basilicfinesherbes", 251);
        Aliments betaselen = new Aliments("Betaselen", "betaselen", 0);
        Aliments betteraverouge = new Aliments("Betterave Rouge", "betteraverouge", 41);
        Aliments beurre = new Aliments("Beurre", "beurre", 741);
        Aliments biereblonde = new Aliments("Bière Blonde", "biereblonde", 146);
        Aliments biereordinaire = new Aliments("Bière Ordinaire", "biereordinaire", 33);
        Aliments bifteckboeuf = new Aliments("Bifteck de Boeuf", "bifteckboeuf", 174);
        Aliments bifteckcheval = new Aliments("Bifteck de Cheval", "bifteckcheval", 123);
        Aliments bigmac = new Aliments("BigMac", "bigmac", 559);
        Aliments bigorneau = new Aliments("Bigorneau", "bigorneau", 101);
        Aliments biscotte = new Aliments("Biscotte", "biscotte", 411);
        Aliments biscuitsable = new Aliments("Biscuit Sablé", "biscuitsable", 457);
        Aliments blancdepoulet = new Aliments("Blanc de Poulet", "blancdepoulet", 142);
        Aliments blancdoeuf = new Aliments("Blanc d'Oeuf", "blancdoeuf", 49);
        Aliments boudinblanc = new Aliments("Boudin Blanc", "boudinblanc", 330);
        Aliments boudinnoir = new Aliments("Boudin Noir", "boudinnoir", 439);
        Aliments bouillondevolaille = new Aliments("Bouillon de Volaille", "bouillondevolaille", 307);
        Aliments brie = new Aliments("Brie", "brie", 271);
        Aliments brochet = new Aliments("Brochet", "brochet", 93);
        Aliments cabillaud = new Aliments("Cabillaud", "cabillaud", 74);
        Aliments cacahuettes = new Aliments("Cacahuettes", "cacahuettes", 576);
        Aliments cafefiltre = new Aliments("Café Filtré", "cafefiltre", 4);
        Aliments cafenescafe = new Aliments("Café Nescafé", "cafenescafe", 4);
        Aliments cafenescafe1tasse = new Aliments("Café Nescafé 1 Tasse", "cafenescafe1tasse", 4);
        Aliments caille = new Aliments("Caille", "caille", 115);
        Aliments cake = new Aliments("Cake", "cake", 413);
        Aliments calamarfrit = new Aliments("Calamar Frit", "calamarfrit", 167);
        Aliments camambert = new Aliments("Camambert", "camambert", 149);
        Aliments canardroti = new Aliments("Canard Roti", "canardroti", 196);
        Aliments cannelle = new Aliments("Cannelle", "cannelle", 261);
        Aliments capresenboite = new Aliments("Câpres en Boite", "capresenboite", 23);
        Aliments cardamome = new Aliments("Cardamome", "cardamome", 311);
        Aliments carencyl = new Aliments("Carencyl", "carencyl", 0);
        Aliments carotte = new Aliments("Carotte", "carotte", 40);
        Aliments carpe = new Aliments("Carpe", "carpe", 110);
        Aliments carrelet = new Aliments("Carrelet", "carrelet", 65);
        Aliments casis = new Aliments("Cassis", "casis", 54);
        Aliments caviar = new Aliments("Caviar", "caviar", 330);
        Aliments celerifeuille = new Aliments("Céleri en Feuille", "celerifeuille", 21);
        Aliments celeriracine = new Aliments("Céleri en Racine", "celeriracine", 44);
        Aliments cerealescropsyfruit = new Aliments("Céréales Cropsy Fruit", "cerealescropsyfruit", 163);
        Aliments cerealesnature = new Aliments("Céréales Nature", "cerealesnature", 489);
        Aliments cerfeuille = new Aliments("Cerfeuille", "cerfeuille", 236);
        Aliments cerises = new Aliments("cerises", "cerises", 68);
        Aliments chairasaucisse = new Aliments("Chair à Saucisse", "chairasaucisse", 421);
        Aliments champagne = new Aliments("Champagne", "champagne", 60);
        Aliments champignons = new Aliments("Champignons", "champignons", 28);
        Aliments charlottegateau = new Aliments("Charlotte", "charlottegateau", 306);
        Aliments chataignefraiche = new Aliments("Chataigne Fraiche", "chataignefraiche", 200);
        Aliments chevalroti = new Aliments("Cheval Rôti", "chevalroti", 142);
        Aliments chocapic = new Aliments("Chocapic", "chocapic", 375);
        Aliments chocolatacroquer = new Aliments("Chocolat à Croquer", "chocolatacroquer", 500);
        Aliments chocolataulait = new Aliments("Chocolat au Lait", "chocolataulait", 550);
        Aliments chocolatenpoudre = new Aliments("Chocolat en Poudre", "chocolatenpoudre", 400);
        Aliments choucroutte = new Aliments("Choucroutte", "choucroutte", 27);
        Aliments choucru = new Aliments("Chou Cru", "choucru", 27);
        Aliments choufleur = new Aliments("Choufleur", "choufleur", 30);
        Aliments chouxdebruxelles = new Aliments("Choux De Bruxelles", "chouxdebruxelles", 550);
        Aliments chrome = new Aliments("Chrome", "chrome", 0);
        Aliments ciboulettecrue = new Aliments("Ciboulette Crue", "ciboulettecrue", 30);
        Aliments ciboulettelyophilisee = new Aliments("Ciboulette Lyophiliseee", "ciboulettelyophilisee", 311);
        Aliments citronjaune = new Aliments("Citron Jaune", "citronjaune", 34);
        Aliments citronvert = new Aliments("Citron Vert", "citronvert", 31);
        Aliments citrouille = new Aliments("Citrouille", "citrouille", 31);
        Aliments clousdegirofle = new Aliments("Clous de Girofle", "clousdegirofle", 323);
        Aliments calamarnature = new Aliments("Calamar Nature", "calmarnature", 92);
        Aliments cocacola = new Aliments("Coca-Cola", "cocacola", 45);
        Aliments cocacolacanette = new Aliments("Coca-Cola Canette", "cocacolacanette", 148);
        Aliments coeurdeboeuf = new Aliments("Coeur De Boeuf", "coeurdeboeuf", 140);
        Aliments coing = new Aliments("Coing", "coing", 58);
        Aliments colinmerlu = new Aliments("Colin Merlu", "colinmerlu", 91);
        Aliments concombre = new Aliments("Concombre", "concombre", 12);
        Aliments coneglacecreme = new Aliments("Cône glace crème", "coneglacecreme", 377);
        Aliments confiture = new Aliments("Confiture", "confiture", 270);
        Aliments congrepoisson = new Aliments("Congre Poisson", "congrepoisson", 110);
        Aliments contrexeville = new Aliments("Contrexe Ville", "contrexeville", 0);
        Aliments coquillestjacques = new Aliments("Coquilles ST-Jacques", "coquillestjacques", 92);
        Aliments cornflakes = new Aliments("Cornflakes", "cornflakes", 368);
        Aliments cornichon = new Aliments("Cornichon", "cornichon", 13);
        Aliments cotedagneau = new Aliments("Cote d'Agneau", "cotedagneau", 242);
        Aliments cotedeboeufrotie = new Aliments("Cote de boeuf rotie", "cotedeboeufrotie", 199);
        Aliments cotelettedeporc = new Aliments("Cotelette de porc", "cotelettedeporc", 319);
        Aliments courgettes = new Aliments("Courgettes", "courgettes", 33);
        Aliments couscous = new Aliments("Couscous", "couscous", 120);
        Aliments crabechair = new Aliments("Crabe chair", "crabechair", 108);
        Aliments cremechantilly = new Aliments("Crème chantilly", "cremechantilly", 316);
        Aliments cremedasperges = new Aliments("Crème d'Asperges", "cremedasperges", 178);
        Aliments cremefraiche = new Aliments("Crème fraiche", "cremefraiche", 282);
        Aliments cresson = new Aliments("Cresson", "cresson", 21);
        Aliments crevette = new Aliments("Crevette", "crevette", 105);
        Aliments croissant = new Aliments("Croissant", "croissant", 348);
        Aliments cuissedegrnouille = new Aliments("Cuisse de grenouille", "cuissedegrnouille", 69);
        Aliments cuissepouletroti = new Aliments("Cuisse poulet rôti", "cuissepouletroti", 169);
        Aliments cumin = new Aliments("Cumin", "cumin", 333);
        Aliments curry = new Aliments("Curry", "curry", 325);
        Aliments daiquiri = new Aliments("Daiquiri", "daiquiri", 185);
        Aliments dattes = new Aliments("Dattes", "dattes", 315);
        Aliments dorade = new Aliments("Dorade", "dorade", 91);
        Aliments echalote = new Aliments("Echalote", "echalote", 75);
        Aliments echalotelyophilisees = new Aliments("Echalote lyophilisees", "echalotelyophilisees", 348);
        Aliments echalotes = new Aliments("Echalotes", "echalotes", 72);
        Aliments eclairgateau = new Aliments("Eclair", "eclairgateau", 239);
        Aliments ecrevisse = new Aliments("Ecrevisse", "ecrevisse", 64);
        Aliments endives = new Aliments("Endives", "endives", 24);
        Aliments epauleagneaurotie = new Aliments("Epaule d'Agneau Rotie", "epauleagneaurotie", 168);
        Aliments epinard = new Aliments("Epinard", "epinard", 27);
        Aliments escalopededinde = new Aliments("Escalope De Dinde", "escalopededinde", 116);
        Aliments escalopedeveau = new Aliments("Escalope De Veau", "escalopedeveau", 139);
        Aliments escargot = new Aliments("Escargot", "escargot", 75);
        Aliments espadon = new Aliments("Espadon", "espadon", 132);
        Aliments estragon = new Aliments("Estragon", "estragon", 295);
        Aliments esturgeon = new Aliments("Esturgeon", "esturgeon", 115);
        Aliments evian = new Aliments("Evian", "evian", 0);
        Aliments extraitdevanille = new Aliments("Extrait de vanille", "extraitdevanille", 288);
        Aliments faisan = new Aliments("Faisan", "faisan", 108);
        Aliments farinedeble = new Aliments("Farine de blé", "farinedeble", 384);
        Aliments fauxfilet = new Aliments("Faux filet", "fauxfilet", 148);
        Aliments fenouil = new Aliments("Fenouil", "fenouil", 21);
        Aliments feuilledecoriandre = new Aliments("feuille de coriandre", "feuilledecoriandre", 279);
        Aliments feuilledelorier = new Aliments("Feuille de lorier", "feuilledelaurier", 313);
        Aliments feveseche = new Aliments("Fève seche", "feveseche", 345);
        Aliments figuesseches = new Aliments("Figues seches", "figuesseches", 257);
        Aliments filetdeboeuf = new Aliments("Filet de boeuf", "filetdeboeuf", 143);
        Aliments filetmaquerau = new Aliments("Filet maquerau", "filetmaquereau", 184);
        Aliments fletan = new Aliments("Fletan", "fletan", 125);
        Aliments floconsdavoine = new Aliments("Flocons d'avoine", "floconsdavoine", 371);
        Aliments foiedeveau = new Aliments("Foie de veau", "foiedeveau", 138);
        Aliments foiegras = new Aliments("Foie gras", "foiegras", 477);
        Aliments fraise = new Aliments("Fraise", "fraise", 37);
        Aliments frites = new Aliments("Frites", "frites", 318);
        Aliments fromageblanc0mg = new Aliments("Fromage blanc 0 mg", "fromageblanc0mg", 56);
        Aliments fromageblanc20mg = new Aliments("Fromage blanc 20 mg", "fromageblanc20mg", 113);
        Aliments fromagecantal = new Aliments("Fromage cantal", "fromagecantal", 385);
        Aliments fromagecheddar = new Aliments("Fromage cheddar", "fromagecheddar", 395);
        Aliments fromagedechevre = new Aliments("Fromage de chèvre", "fromagedechevre", 320);
        Aliments fromagegouda = new Aliments("Fromage gouda", "fromagegouda", 347);
        Aliments fromagemunster = new Aliments("Fromage munster", "fromagemunster", 320);
        Aliments fruitsausirop = new Aliments("Fruits au sirop", "fruitsausirop", 103);
        Aliments fruitssecsmelange = new Aliments("Fruits secs mélange", "fruitssecsmelange", 335);
        Aliments galantine = new Aliments("Galantine", "galantine", 248);
        Aliments germedeble = new Aliments("Germe de blé", "germedeble", 387);
        Aliments gigotdemouton = new Aliments("Gigot de mouton", "gigotdemouton", 214);
        Aliments gin = new Aliments("Gin", "gin", 255);
        Aliments ginandtonic = new Aliments("Gin and tonic", "ginandtonic", 171);
        Aliments gingembre = new Aliments("Gingembre", "gingembre", 347);
        Aliments glacealavanille = new Aliments("Glace à la vanille", "glacealavanille", 111);
        Aliments glaceauchocolat = new Aliments("Glace au chocolat", "glaceauchocolat", 120);
        Aliments glaceaucitron = new Aliments("Glace au citron", "glaceaucitron", 125);
        Aliments goujon = new Aliments("Goujon", "goujon", 68);
        Aliments goyave = new Aliments("Goyave", "goyave", 53);
        Aliments grainedanis = new Aliments("Graine d'anis", "grainedanis", 337);
        Aliments grainedecoriandre = new Aliments("Graine de coriandre", "grainedecoriandre", 297);
        Aliments grainedefenouil = new Aliments("Graine de fenouil", "grainedefenouil", 345);
        Aliments grainedepavots = new Aliments("Graine de pavots", "grainedepavots", 533);
        Aliments grainesdecumin = new Aliments("Graines de cumin", "grainesdecumin", 374);
        Aliments groseilles = new Aliments("Groseilles", "groseilles", 46);
        Aliments gruyere = new Aliments("Gruyère", "gruyere", 430);
        Aliments haddockfume = new Aliments("Haddock fumé", "haddockfume", 95);
        Aliments haricotsblancs = new Aliments("Haricots blancs", "haricotsblancs", 128);
        Aliments haricotsrouges = new Aliments("Haricots rouges", "haricotsrouges", 328);
        Aliments haricotssecs = new Aliments("Haricots secs", "haricotssecs", 337);
        Aliments haricotsverts = new Aliments("Haricots verts", "haricotsverts", 30);
        Aliments hareng = new Aliments("Hareng", "hareng", 212);
        Aliments harengfume = new Aliments("Hareng fumé", "harengfume", 215);
        Aliments homard = new Aliments("Homard", "homard", 94);
        Aliments huiledecolza = new Aliments("Huile de colza", "huiledecolza", 122);
        Aliments huiledegermedeble = new Aliments("Huile de germe de blé", "huiledegermedeble", 122);
        Aliments huiledesoja = new Aliments("Huile de soja", "huiledesoja", 122);
        Aliments huledetournesol = new Aliments("Huile de tournesol", "huiledetournesol", 122);
        Aliments huiledolive = new Aliments("Huile d'olive", "huiledolive", 121);
        Aliments huitres = new Aliments("huîtres", "huitres", 73);
        Aliments instantmasssportsystem = new Aliments("Instant mass sport system", "instantmasssportsystem", 372);
        Aliments jambondedinde = new Aliments("Jambon de dinde", "jambondedinde", 123);
        Aliments jambonmaigre = new Aliments("Jambon maigre", "jambonmaigre", 56);
        Aliments jaunedoeuf = new Aliments("Jaune d'oeuf", "jaunedoeuf", 358);
        Aliments jusdananas = new Aliments("Jus d'ananas", "jusdananas", 57);
        Aliments jusdecarotte = new Aliments("Jus de carotte", "jusdecarotte", 41);
        Aliments jusdecitron = new Aliments("Jus de citron", "jusdecitron", 5);
        Aliments jusdelegumecocktail = new Aliments("Jus de legume cocktail", "jusdelegumecocktail", 19);
        Aliments jusdepamplemousse = new Aliments("Jus de pamplemousse", "jusdepamplemousse", 39);
        Aliments jusdepomme = new Aliments("Jus de pomme", "jusdepomme", 49);
        Aliments jusderaisin = new Aliments("Jus de raisin", "jusderaisin", 66);
        Aliments jusdetomate = new Aliments("Jus de tomate", "jusdetomate", 20);
        Aliments jusdorange = new Aliments("Jus d'orange", "jusdorange", 51);
        Aliments kaki = new Aliments("Kaki", "kaki", 81);
        Aliments ketchup = new Aliments("Ketchup", "ketchup", 102);
        Aliments kiwi = new Aliments("Kiwi", "kiwi", 46);
        Aliments laitdemiecreme = new Aliments("Lait demi écrémé", "laitdemiecreme", 43);
        Aliments laitdesoja = new Aliments("Lait de soja", "laitdesoja", 49);
        Aliments laitcremeliquide = new Aliments("Lait crème liquide", "laitecremeliquide", 35);
        Aliments laitecremepoudre = new Aliments("Lait écrémé poudre", "laitecremepoudre", 48);
        Aliments laitentierliquide = new Aliments("Lait entier liquide", "laitentierliquide", 63);
        Aliments laitue = new Aliments("Laitue", "laitue", 5);
        Aliments langouste = new Aliments("Langouste", "langouste", 98);
        Aliments languedeboeuf = new Aliments("Langue de boeuf", "languedeboeuf", 229);
        Aliments lapinchasseur = new Aliments("Lapin chasseur", "lapinchasseur", 139);
        Aliments lapincuitencivet = new Aliments("Lapin cuit en civet", "lapincuitencivet", 139);
        Aliments laroscorbineeffervescente = new Aliments("La roscorbine effervescente", "laroscorbineeffervescente", 0);
        Aliments lentillescrues = new Aliments("Lentilles crues", "lentillescrues", 330);
        Aliments lentillescuites = new Aliments("Lentilles Cuites", "lentillescuites", 115);
        Aliments levuredebiere = new Aliments("Levure de bière", "levuredebiere", 381);
        Aliments lieu = new Aliments("Lieu", "lieu", 85);
        Aliments lievre = new Aliments("Lièvre", "lievre", 98);
        Aliments limande = new Aliments("Limande", "limande", 76);
        Aliments liqueur = new Aliments("Liqueur", "liqueur", 574);
        Aliments lotte = new Aliments("Lotte", "lotte", 86);
        Aliments macaroni = new Aliments("Macaroni", "macaroni", 140);
        Aliments macis = new Aliments("Macis", "macis", 475);
        Aliments mais = new Aliments("Mais", "mais", 360);
        Aliments mandarine = new Aliments("Mandarine", "mandarine", 41);
        Aliments mangue = new Aliments("Mangue", "mangue", 64);
        Aliments maquereaualapoelee = new Aliments("Maquereau à la poêlée", "maquereaualapoelee", 224);
        Aliments maquereauenboite = new Aliments("Maquereau en boite", "maquereauenboite", 151);
        Aliments margarine = new Aliments("Margarine", "margarine", 34);
        Aliments margarineenboite = new Aliments("Margarine en boite", "margarineenboite", 34);
        Aliments margarinetartinable = new Aliments("Margarine tartinable", "margarinetartinable", 34);
        Aliments marjolaine = new Aliments("Marjolaine", "marjolaine", 271);
        Aliments marronsgrilles = new Aliments("Marrons grillés", "marronsgrilles", 362);
        Aliments martini = new Aliments("Martini", "martini", 156);
        Aliments mayonnaise = new Aliments("Mayonnaise", "mayonnaise", 99);
        Aliments melon = new Aliments("melon", "melon", 37);
        Aliments merlantfiletnature = new Aliments("Merlan filet nature", "merlanfiletnature", 90);
        Aliments merlanfrit = new Aliments("Merlan frit", "merlanfrit", 134);
        Aliments miel = new Aliments("Miel", "miel", 312);
        Aliments milkeggprotein = new Aliments("Milk egg protein", "milkeggprotein", 361);
        Aliments milo = new Aliments("Milo", "milo", 399);
        Aliments mortadelle = new Aliments("Mortadelle", "mortadelle", 263);
        Aliments moulesnature = new Aliments("Moules nature", "moulesnature", 76);
        Aliments moulespreparees = new Aliments("Moules préparées", "moulespreparees", 146);
        Aliments moutarde = new Aliments("Moutarde", "moutarde", 105);
        Aliments mozarella = new Aliments("Mozarella", "mozarella", 271);
        Aliments muesli = new Aliments("Muesli", "muesli", 360);
        Aliments mures = new Aliments("Mûres", "mures", 57);
        Aliments myrtilles = new Aliments("Myrtilles", "myrtilles", 80);
        Aliments navet = new Aliments("Navet", "navet", 31);
        Aliments nectarine = new Aliments("Nectarine", "nectarine", 59);
        Aliments noisette = new Aliments("Noisette", "noisette", 566);
        Aliments noixdecoco = new Aliments("Noix de coco", "noixdecoco", 362);
        Aliments noixdemuscade = new Aliments("Noix de muscade", "noixdemuscade", 525);
        Aliments oeuf = new Aliments("Oeuf", "oeuf", 149);
        Aliments oeufauplat = new Aliments("Oeuf au plat", "oeufauplat", 92);
        Aliments oeufpoche = new Aliments("Oeuf poché", "oeufpoche", 149);
        Aliments oignon = new Aliments("Oignon", "oignon", 43);
        Aliments oignonenpoudre = new Aliments("Oignon en poudre", "oignonenpoudre", 347);
        Aliments oligonatalgrosesse = new Aliments("Oligo natal grosesse", "oligonatalgrosesse", 0);
        Aliments oliveverte = new Aliments("Olive verte", "oliveverte", 8);
        Aliments omelette = new Aliments("Omelette", "omelette", 152);
        Aliments onglet = new Aliments("Onglet", "onglet", 182);
        Aliments orange = new Aliments("Orange", "orange", 50);
        Aliments origan = new Aliments("Origan", "origan", 306);
        Aliments oseille = new Aliments("Oseille", "oseille", 25);
        Aliments oeufbrouille = new Aliments("Oeuf brouillé", "oueufbrouille", 166);
        Aliments painauraisin = new Aliments("Pain au raisin", "painauraisin", 262);
        Aliments painblanc = new Aliments("Pain blanc", "painblanc", 255);
        Aliments paincomplet = new Aliments("Pain complet", "paincomplet", 240);
        Aliments paindepices = new Aliments("Pain d'épices", "paindepices", 385);
        Aliments paindeseigle = new Aliments("Pain de seigle", "paindeseigle", 241);
        Aliments paingrille = new Aliments("Pain grillés", "paingrille", 355);
        Aliments pamplemousse = new Aliments("Pamplemousse", "pamplemousse", 40);
        Aliments papaye = new Aliments("Papaye", "papaye", 44);
        Aliments paprika = new Aliments("Paprika", "paprika", 289);
        Aliments parmesan = new Aliments("Parmesan", "parmesan", 390);
        Aliments pateaugluten = new Aliments("pâte au gluten", "pateaugluten", 348);
        Aliments patedamandes = new Aliments("pâte d'amandes", "patedamandes", 462);
        Aliments patedefoie = new Aliments("Pâté de foie", "patedefoie", 454);
        Aliments pates = new Aliments("Pâtes", "pates", 361);
        Aliments pavedeboeuf = new Aliments("Pavé de boeuf", "pavedeboeuf", 173);
        Aliments peche = new Aliments("Pêche", "peche", 49);
        Aliments perche = new Aliments("Perche", "perche", 105);
        Aliments perrier = new Aliments("Perrier", "perrier", 0);
        Aliments persil = new Aliments("Persil", "persil", 54);
        Aliments persilseche = new Aliments("Persil séchées", "persilseche", 276);
        Aliments petitspois = new Aliments("Petits pois", "petitspois", 90);
        Aliments petitsuisse = new Aliments("Petit suisse", "petitsuisse", 191);
        Aliments pieuvrepoulpe = new Aliments("Pieuvre/Poulpe", "pieuvrepoulpe", 84);
        Aliments pimentenpoudre = new Aliments("Piment en poudre", "pimentenpoudre", 314);
        Aliments pissenlit = new Aliments("Pissenlit", "pissenlit", 48);
        Aliments pizzajambonfromage = new Aliments("Pizza jambon fromage", "pizzajambonfromage", 254);
        Aliments poire = new Aliments("Poire", "poire", 53);
        Aliments poireau = new Aliments("Poireau", "poireau", 41);
        Aliments poiresausiropleger = new Aliments("Poires au sirop léger", "poiresausiropleger", 72);
        Aliments poiresausiropsucree = new Aliments("Poires au sirop sucrée", "poiresausiropsucree", 108);
        Aliments poischiche = new Aliments("Pois chiche", "poischiche", 364);
        Aliments poivre = new Aliments("poivre", "poivre", 6);
        Aliments poivreblanc = new Aliments("Poivreblanc", "poivreblanc", 296);
        Aliments poivredejamaique = new Aliments("Poivre de Jamaique", "poivredejamaique", 263);
        Aliments poivrenoir = new Aliments("Poivre noir", "poivrenoir", 255);
        Aliments poivrerouge = new Aliments("Poivre rouge", "poivrerouge", 318);
        Aliments poivron = new Aliments("Poivron", "poivron", 22);
        Aliments pomme = new Aliments("Pomme", "pomme", 58);
        Aliments pommedeterre = new Aliments("Pomme de terre", "pommedeterre", 65);
        Aliments popcorn = new Aliments("Pop-corn", "popcorn", 360);
        Aliments portsalut = new Aliments("Port-Salut", "portsalut", 346);
        Aliments prairectustace = new Aliments("Crustacés", "prairectustace", 120);
        Aliments protiplus = new Aliments("Proti-plus", "protiplus", 369);
        Aliments prune = new Aliments("Prune", "prune", 53);
        Aliments pruneau = new Aliments("Pruneau", "pruneau", 295);
        Aliments pucnh = new Aliments("punch", "punch", 230);
        Aliments quakeroats = new Aliments("Quake roats", "quakeroats", 371);
        Aliments radis = new Aliments("Radis", "radis", 21);
        Aliments ragoutdeboeuf = new Aliments("Ragoût de boeuf", "ragoutdeboeuf", 171);
        Aliments raie = new Aliments("Raie", "raie", 93);
        Aliments raisin = new Aliments("Raisin", "raisin", 74);
        Aliments raisinsec = new Aliments("Raisin sec", "raisinsec", 296);
        Aliments rhum = new Aliments("Rhum", "rhum", 24);
        Aliments rilettes = new Aliments("Rilettes", "rilettes", 601);
        Aliments risthymus = new Aliments("Ris de veau", "risthymus", 135);
        Aliments rizblanc = new Aliments("Riz blanc", "rizblanc", 132);
        Aliments rizcomplet = new Aliments("Riz complet", "rizcomplet", 109);
        Aliments rognondeboeuf = new Aliments("Rognon de boeuf", "rognondeboeuf", 117);
        Aliments rognondeveau = new Aliments("Rognon de veau", "rognonsdeveau", 133);
        Aliments romarinseche = new Aliments("Romarin séché", "romarinseche", 331);
        Aliments roquefort = new Aliments("Roquefort", "roquefort", 368);
        Aliments rotidedinde = new Aliments("Rôti de dinde ", "rotidedinde", 124);
        Aliments rotideveau = new Aliments("Rôti de veau", "rotideveau", 121);
        Aliments roussette = new Aliments("Roussette", "roussette", 151);
        Aliments rumsteak = new Aliments("Rumsteak", "rumsteak", 166);
        Aliments safran = new Aliments("Safran", "safran", 310);
        Aliments safrandesindes = new Aliments("Safran des indes", "safrandesindes", 354);
        Aliments salademais = new Aliments("Salade mais", "saladedemais", 8);
        Aliments saladedethon = new Aliments("Salade de thon", "saladedethon", 159);
        Aliments salsifis = new Aliments("Salsifis", "salsifis", 73);
        Aliments sandwichjambonbeurre = new Aliments("Sandwich jambon beurre", "sandwichjambonbeurre", 352);
        Aliments sandwichjambonfromage = new Aliments("Sandwich jambon fromage", "sandwichjambonfromage", 356);
        Aliments sardine = new Aliments("Sardine", "sardine", 142);
        Aliments sardinesalhuile = new Aliments("Sardines à l'huile", "sardinesalhuile", 191);
        Aliments saucesalade = new Aliments("Sauce salade", "saucesalade", 522);
        Aliments saucespaghettis = new Aliments("Sauce spaghettis", "saucespaghettis", 33);
        Aliments saucetomate = new Aliments("Sauce tomate", "saucetomate", 50);
        Aliments saucissedefrancfort = new Aliments("Saucisse de Francfort", "saucissedefrancfort", 236);
        Aliments saucissonsec = new Aliments("Saucisson sec", "saucissonsec", 546);
        Aliments sauge = new Aliments("Sauge", "sauge", 315);
        Aliments saumon = new Aliments("Saumon", "saumon", 179);
        Aliments seiche = new Aliments("Seiche", "seiche", 67);
        Aliments sel = new Aliments("Sel", "sel", 0);
        Aliments selegerme = new Aliments("Sélégerme", "selegerme", 295);
        Aliments semouledeble = new Aliments("Semoule de blé", "semouledeble", 345);
        Aliments semouledemais = new Aliments("Semoule de mais", "semouledemais", 365);
        Aliments seniorssimplexvitall = new Aliments("Seniors simplex vitall", "seniorssimplexvitall", 0);
        Aliments sojafarine = new Aliments("Soja farine", "sojafarine", 358);
        Aliments sojagraine = new Aliments("Soja graine", "sojagraine", 422);
        Aliments sole = new Aliments("Sole", "sole", 75);
        Aliments soupeauxchampignons = new Aliments("Soupe aux champignons", "soupeauxchampignons", 127);
        Aliments soupelegumes = new Aliments("Soupe légumes", "soupelegumes", 123);
        Aliments soupeminestorne = new Aliments("Soupe minestorne", "soupeminestorne", 84);
        Aliments spaghettis = new Aliments("Spaghettis", "spaghettis", 385);
        Aliments steackaloyau = new Aliments("Steack aloyau", "steackaloyau", 163);
        Aliments steackhache = new Aliments("Steack hache", "steackhache", 124);
        Aliments sucreblanc = new Aliments("Sucre blanc", "sucreblanc", 400);
        Aliments sucrebrun = new Aliments("Sucre brun", "sucrebrun", 376);
        Aliments sucreenpoudre = new Aliments("Sucre en poudre", "sucreenpoudre", 389);
        Aliments supercomplexvitall = new Aliments("Super complex vitall", "supercomplexevitall", 0);
        Aliments tapioca = new Aliments("Tapioca", "tapioca", 348);
        Aliments tarteauxcerises = new Aliments("Tarte aux cerises", "tarteauxcerises", 313);
        Aliments tarteauxfraises = new Aliments("Tarte aux fraises", "tarteauxfraises", 191);
        Aliments tarteauxpommes = new Aliments("Tarte aux pommes", "tarteauxpommes", 308);
        Aliments the = new Aliments("Thé", "the", 1);
        Aliments thoncru = new Aliments("Thon cru", "thoncru", 122);
        Aliments thonenboite = new Aliments("Thon en boite", "thonenboite", 178);
        Aliments thymfrais = new Aliments("Thym frais", "thymfrais", 101);
        Aliments tomate = new Aliments("Tomate", "tomate", 21);
        Aliments tripes = new Aliments("Tripes", "tripes", 94);
        Aliments truitedemer = new Aliments("Truite de mer", "truitedemer", 104);
        Aliments truiteplat = new Aliments("Truite plat", "truiteplat", 128);
        Aliments turbot = new Aliments("Turbot", "turbot", 118);
        Aliments vichystyorre = new Aliments("Vichy st-Yorre", "vichystyorre", 0);
        Aliments vinaigre = new Aliments("Vinaigre", "vinaigre", 9);
        Aliments vinrose = new Aliments("Vin rosé", "vinrose", 73);
        Aliments vinrouge = new Aliments("Vin rouge", "vinrouge", 74);
        Aliments vittelgrandesource = new Aliments("Vittel grande source", "vittelgrandesource", 0);
        Aliments vittelhepard = new Aliments("Vittel hépard", "vittelhepard", 0);
        Aliments vodka = new Aliments("Vodka", "vodka", 238);
        Aliments volvic = new Aliments("Volvic", "volvic", 0);
        Aliments whisky = new Aliments("Whisky", "whisky", 238);
        Aliments yaourtbifidusactif = new Aliments("Yaourt bifidus actif", "yaourtbifidusactif", 57);
        Aliments yaourtbulgare = new Aliments("Yaourt bulgare", "yaourtbulgare", 65);
        Aliments yaourtmaigre = new Aliments("Yaourt maigre", "yaourtmaigre", 67);
        Aliments yaourtnature = new Aliments("Yaourt nature", "yaourtnature", 81);
        Aliments yoplaitauxfruits = new Aliments("Yoplait aux fruits", "yoplaitauxfruits", 115);


        list.add(ail);
        list.add(ailenpoudre);
        list.add(amendesblanchiessechees);
        list.add(amandessechees);
        list.add(anethfraiche);
        list.add(anethsechee);
        list.add(aromedevanille);
        list.add(aromedevanillealcool);
        list.add(asperges);
        list.add(aubergine);
        list.add(avocat);
        list.add(bacon);
        list.add(baguette);
        list.add(banane);
        list.add(bananesechee);
        list.add(barloup);
        list.add(basilicfinesherbes);
        list.add(basilicfrais);
        list.add(betaselen);
        list.add(betteraverouge);
        list.add(beurre);
        list.add(biereblonde);
        list.add(biereordinaire);
        list.add(bifteckboeuf);
        list.add(bifteckcheval);
        list.add(bigmac);
        list.add(bigorneau);
        list.add(biscotte);
        list.add(biscuitsable);
        list.add(blancdepoulet);
        list.add(blancdoeuf);
        list.add(boudinblanc);
        list.add(boudinnoir);
        list.add(bouillondevolaille);
        list.add(brie);
        list.add(brochet);
        list.add(cabillaud);
        list.add(cacahuettes);
        list.add(cafefiltre);
        list.add(cafenescafe);
        list.add(cafenescafe1tasse);
        list.add(caille);
        list.add(cake);
        list.add(calamarfrit);
        list.add(calamarnature);
        list.add(camambert);
        list.add(canardroti);
        list.add(cannelle);
        list.add(capresenboite);
        list.add(cardamome);
        list.add(carencyl);
        list.add(carotte);
        list.add(carpe);
        list.add(carrelet);
        list.add(casis);
        list.add(caviar);
        list.add(celerifeuille);
        list.add(celeriracine);
        list.add(cerealescropsyfruit);
        list.add(cerealesnature);
        list.add(cerfeuille);
        list.add(cerises);
        list.add(chairasaucisse);
        list.add(champagne);
        list.add(champignons);
        list.add(charlottegateau);
        list.add(chataignefraiche);
        list.add(chevalroti);
        list.add(chocapic);
        list.add(chocolatacroquer);
        list.add(chocolataulait);
        list.add(chocolatenpoudre);
        list.add(choucroutte);
        list.add(choucru);
        list.add(choufleur);
        list.add(chouxdebruxelles);
        list.add(chrome);
        list.add(ciboulettecrue);
        list.add(ciboulettelyophilisee);
        list.add(citronjaune);
        list.add(citronvert);
        list.add(citrouille);
        list.add(clousdegirofle);
        list.add(cocacola);
        list.add(cocacolacanette);
        list.add(coeurdeboeuf);
        list.add(coing);
        list.add(colinmerlu);
        list.add(concombre);
        list.add(coneglacecreme);
        list.add(confiture);
        list.add(congrepoisson);
        list.add(contrexeville);
        list.add(coquillestjacques);
        list.add(cornflakes);
        list.add(cornichon);
        list.add(cotedagneau);
        list.add(cotedeboeufrotie);
        list.add(cotelettedeporc);
        list.add(courgettes);
        list.add(couscous);
        list.add(crabechair);
        list.add(cremechantilly);
        list.add(cremedasperges);
        list.add(cremefraiche);
        list.add(cresson);
        list.add(crevette);
        list.add(croissant);
        list.add(cuissedegrnouille);
        list.add(cuissepouletroti);
        list.add(cumin);
        list.add(curry);
        list.add(daiquiri);
        list.add(dattes);
        list.add(dorade);
        list.add(echalote);
        list.add(echalotelyophilisees);
        list.add(echalotes);
        list.add(eclairgateau);
        list.add(ecrevisse);
        list.add(endives);
        list.add(epauleagneaurotie);
        list.add(epinard);
        list.add(escalopededinde);
        list.add(escalopedeveau);
        list.add(escargot);
        list.add(espadon);
        list.add(estragon);
        list.add(esturgeon);
        list.add(evian);
        list.add(extraitdevanille);
        list.add(faisan);
        list.add(farinedeble);
        list.add(fauxfilet);
        list.add(fenouil);
        list.add(feuilledecoriandre);
        list.add(feuilledelorier);
        list.add(feveseche);
        list.add(figuesseches);
        list.add(filetdeboeuf);
        list.add(filetmaquerau);
        list.add(fletan);
        list.add(floconsdavoine);
        list.add(foiedeveau);
        list.add(foiegras);
        list.add(fraise);
        list.add(frites);
        list.add(fromageblanc0mg);
        list.add(fromageblanc20mg);
        list.add(fromagecantal);
        list.add(fromagecheddar);
        list.add(fromagedechevre);
        list.add(fromagegouda);
        list.add(fromagemunster);
        list.add(fruitsausirop);
        list.add(fruitssecsmelange);
        list.add(galantine);
        list.add(germedeble);
        list.add(gigotdemouton);
        list.add(gin);
        list.add(ginandtonic);
        list.add(gingembre);
        list.add(glacealavanille);
        list.add(glaceauchocolat);
        list.add(glaceaucitron);
        list.add(goujon);
        list.add(goyave);
        list.add(grainedanis);
        list.add(grainedecoriandre);
        list.add(grainedefenouil);
        list.add(grainedepavots);
        list.add(grainesdecumin);
        list.add(groseilles);
        list.add(gruyere);
        list.add(haddockfume);
        list.add(haricotsblancs);
        list.add(haricotsrouges);
        list.add(haricotssecs);
        list.add(haricotsverts);
        list.add(hareng);
        list.add(harengfume);
        list.add(homard);
        list.add(huiledecolza);
        list.add(huiledegermedeble);
        list.add(huiledesoja);
        list.add(huledetournesol);
        list.add(huiledolive);
        list.add(huitres);
        list.add(instantmasssportsystem);
        list.add(jambondedinde);
        list.add(jambonmaigre);
        list.add(jaunedoeuf);
        list.add(jusdananas);
        list.add(jusdecarotte);
        list.add(jusdecitron);
        list.add(jusdelegumecocktail);
        list.add(jusdepamplemousse);
        list.add(jusdepomme);
        list.add(jusderaisin);
        list.add(jusdetomate);
        list.add(jusdorange);
        list.add(kaki);
        list.add(ketchup);
        list.add(kiwi);
        list.add(laitdemiecreme);
        list.add(laitdesoja);
        list.add(laitcremeliquide);
        list.add(laitecremepoudre);
        list.add(laitentierliquide);
        list.add(laitue);
        list.add(langouste);
        list.add(languedeboeuf);
        list.add(lapinchasseur);
        list.add(lapincuitencivet);
        list.add(laroscorbineeffervescente);
        list.add(lentillescrues);
        list.add(lentillescuites);
        list.add(levuredebiere);
        list.add(lieu);
        list.add(lievre);
        list.add(limande);
        list.add(liqueur);
        list.add(lotte);
        list.add(macaroni);
        list.add(macis);
        list.add(mais);
        list.add(mandarine);
        list.add(mangue);
        list.add(maquereaualapoelee);
        list.add(maquereauenboite);
        list.add(margarine);
        list.add(margarineenboite);
        list.add(margarinetartinable);
        list.add(marjolaine);
        list.add(marronsgrilles);
        list.add(martini);
        list.add(mayonnaise);
        list.add(melon);
        list.add(merlantfiletnature);
        list.add(merlanfrit);
        list.add(miel);
        list.add(milkeggprotein);
        list.add(milo);
        list.add(mortadelle);
        list.add(moulesnature);
        list.add(moulespreparees);
        list.add(moutarde);
        list.add(mozarella);
        list.add(muesli);
        list.add(mures);
        list.add(myrtilles);
        list.add(navet);
        list.add(nectarine);
        list.add(noisette);
        list.add(noixdecoco);
        list.add(noixdemuscade);
        list.add(oeuf);
        list.add(oeufauplat);
        list.add(oeufpoche);
        list.add(oignon);
        list.add(oignonenpoudre);
        list.add(oligonatalgrosesse);
        list.add(oliveverte);
        list.add(omelette);
        list.add(onglet);
        list.add(orange);
        list.add(origan);
        list.add(oseille);
        list.add(oeufbrouille);
        list.add(painauraisin);
        list.add(painblanc);
        list.add(paincomplet);
        list.add(paindepices);
        list.add(paindeseigle);
        list.add(paingrille);
        list.add(pamplemousse);
        list.add(papaye);
        list.add(paprika);
        list.add(parmesan);
        list.add(pateaugluten);
        list.add(patedamandes);
        list.add(patedefoie);
        list.add(pates);
        list.add(pavedeboeuf);
        list.add(peche);
        list.add(perche);
        list.add(perrier);
        list.add(persil);
        list.add(persilseche);
        list.add(petitspois);
        list.add(petitsuisse);
        list.add(pieuvrepoulpe);
        list.add(pimentenpoudre);
        list.add(pissenlit);
        list.add(pizzajambonfromage);
        list.add(poire);
        list.add(poireau);
        list.add(poiresausiropleger);
        list.add(poiresausiropsucree);
        list.add(poischiche);
        list.add(poivre);
        list.add(poivreblanc);
        list.add(poivredejamaique);
        list.add(poivrenoir);
        list.add(poivrerouge);
        list.add(poivron);
        list.add(pomme);
        list.add(pommedeterre);
        list.add(popcorn);
        list.add(portsalut);
        list.add(prairectustace);
        list.add(protiplus);
        list.add(prune);
        list.add(pruneau);
        list.add(pucnh);
        list.add(quakeroats);
        list.add(radis);
        list.add(ragoutdeboeuf);
        list.add(raie);
        list.add(raisin);
        list.add(raisinsec);
        list.add(rhum);
        list.add(rilettes);
        list.add(risthymus);
        list.add(rizblanc);
        list.add(rizcomplet);
        list.add(rognondeboeuf);
        list.add(rognondeveau);
        list.add(romarinseche);
        list.add(roquefort);
        list.add(rotidedinde);
        list.add(rotideveau);
        list.add(roussette);
        list.add(rumsteak);
        list.add(safran);
        list.add(safrandesindes);
        list.add(salademais);
        list.add(saladedethon);
        list.add(salsifis);
        list.add(sandwichjambonbeurre);
        list.add(sandwichjambonfromage);
        list.add(sardine);
        list.add(sardinesalhuile);
        list.add(saucesalade);
        list.add(saucespaghettis);
        list.add(saucetomate);
        list.add(saucissedefrancfort);
        list.add(saucissonsec);
        list.add(sauge);
        list.add(saumon);
        list.add(seiche);
        list.add(sel);
        list.add(selegerme);
        list.add(semouledeble);
        list.add(semouledemais);
        list.add(seniorssimplexvitall);
        list.add(sojafarine);
        list.add(sojagraine);
        list.add(sole);
        list.add(soupeauxchampignons);
        list.add(soupelegumes);
        list.add(soupeminestorne);
        list.add(spaghettis);
        list.add(steackaloyau);
        list.add(steackhache);
        list.add(sucreblanc);
        list.add(sucrebrun);
        list.add(sucreenpoudre);
        list.add(supercomplexvitall);
        list.add(tapioca);
        list.add(tarteauxcerises);
        list.add(tarteauxfraises);
        list.add(tarteauxpommes);
        list.add(the);
        list.add(thoncru);
        list.add(thonenboite);
        list.add(thymfrais);
        list.add(tomate);
        list.add(tripes);
        list.add(truitedemer);
        list.add(truiteplat);
        list.add(turbot);
        list.add(vichystyorre);
        list.add(vinaigre);
        list.add(vinrose);
        list.add(vinrouge);
        list.add(vittelgrandesource);
        list.add(vittelhepard);
        list.add(vodka);
        list.add(volvic);
        list.add(whisky);
        list.add(yaourtbifidusactif);
        list.add(yaourtbulgare);
        list.add(yaourtmaigre);
        list.add(yaourtnature);
        list.add(yoplaitauxfruits);


//Passage de la list a la view
        return list;

    }


    //Déclaration d'un Handler pour tâches automatique
    private Handler myHandler;
    private Runnable myRunnable = new Runnable() {

        @Override
        //On implémente la méthode pour mettre à jour le totalcalorique
        public void run() {

//            int sum = 0;
            //Parcours du Hashmap pour sommer toutes les valeurs caloriques et ainsi récupérer le totalcalorique
            //dans la variable sum
            //calMap.values()


//                for (int f : (caltolMap.get(recup_date)).values()) {
//                    sum += f;
//                }
                Integer sum=accesLocal.sumcal(recup_date);

                //On récupère le champ totalcalories de la vue
                TextView totalcalories = (TextView) findViewById(R.id.totalcalories);
                String sumtotal = Integer.toString(sum);
                //On met à jour le text de totalcalories avec la valeur calculée
                totalcalories.setText(sumtotal);



//            for (int f : (caltolMap.get(recup_date)).values()) {
//                sum += f;
//            }
//
//            //On récupère le champ totalcalories de la vue
//            TextView totalcalories = (TextView) findViewById(R.id.totalcalories);
//            String sumtotal = Integer.toString(sum);
//            //On met à jour le text de totalcalories avec la valeur calculée
//            totalcalories.setText(sumtotal);

            //Changement de la couleur d'un élément si l'objectif n'est pas respecté
            TextView objectifcalories = (TextView) findViewById(R.id.objectif);
            int objectif = Integer.parseInt(objectifcalories.getText().toString());

            if (sum <= objectif) {
                Button b1 = (Button) findViewById(R.id.verif);
                b1.setBackgroundResource(R.drawable.rounded_button_ok);
                b1.setText("V");
                b1.setTextColor(Color.BLACK);
            } else {

                //On tolère une marge de 5% par rapport à l'objectif (Changement de couleur)
                if (sum <= objectif + (objectif * 0.05)) {
                    Button b2 = (Button) findViewById(R.id.verif);
                    b2.setBackgroundResource(R.drawable.rounded_button_mid);
                    b2.setText("~");
                    b2.setTextColor(Color.WHITE);
                } else {
                    Button b1 = (Button) findViewById(R.id.verif);
                    b1.setBackgroundResource(R.drawable.rounded_button_false);
                    b1.setText("X");
                    b1.setTextColor(Color.WHITE);
                }

            }



            //On appel cette fonction toutes les 5 milisecondes
            myHandler.postDelayed(this, 5);


        }
    };


    //Hashmap en fonction de la date
    public static Map<String,Map<Integer,Integer>> dateMap =  CustomGridAdapter.dateMap;
    public static Map<String,Map<Integer,Integer>> caltolMap = CustomGridAdapter.caltolMap;

}