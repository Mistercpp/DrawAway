package com.example.app;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;


import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

        EditText largeur;
        EditText hauteur;

        //Booleen de vérouillage de bouton
        public static boolean boolDessin = false;
        public static boolean boolSupr = false;

        public Figure figureEnCour;
        public Figure figureTemp;

        //Variable boite de dialogue des couleurs
        private ColorPicker colorPicker;
        private Button button;
        public int rouge = 0;
        public int vert = 0;
        public int bleu = 0;

        //share all informations with other classes (public static variables)
        public static int X, Y;
        public static int figureSize;


        //Fonction pour la boite de dialogue de selection de couleur
        private void showColorPickerDialogDemo() {

            int initialColor = Color.WHITE;

            ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this, initialColor, new ColorPickerDialog.OnColorSelectedListener() {

                @Override
                public void onColorSelected(int color) {
                    rouge = Color.red(color);
                    bleu = Color.blue(color);
                    vert = Color.green(color);
                }

            });
            colorPickerDialog.show();

        }


        private AdapterView.OnItemSelectedListener figureSelected;
        {
            public class MainActivity extends ActionBarActivity {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                //Boite de dialogue des couleur
                colorPicker = (ColorPicker) findViewById(R.id.colorPicker);

                button = (Button) findViewById(R.id.couleur);
                button.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //Ouverture de la boite de dialogue
                        showColorPickerDialogDemo();
                        boolDessin = true;
                    }
                });


                //initialize variables of the class
                X =0;
                Y =0;
                figureSize = 50+10;

                //get the View
                //Calque de la vue
                calque  = (GeometryLayer)findViewById(R.id.calque_dessin);

                //initialize the array of figures
                initAvailableForms();

                //initilize touch event
                //Initialisation des evenements
                final View touchView = findViewById(R.id.calque_dessin);
                touchView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        //Coordonnées optenuent du tactile
                        int Xpos = (int) motionEvent.getX();
                        int Ypos = (int) motionEvent.getY();

                        int ilargeur = 0;
                        int ihauteur = 0;

                        if(boolDessin == true){
                            //Coordonnées taper
                            largeur = (EditText)findViewById(R.id.largeur);
                            hauteur = (EditText)findViewById(R.id.hauteur);
                            ilargeur = Integer.parseInt(largeur.getText().toString());
                            ihauteur = Integer.parseInt(hauteur.getText().toString());
                            touchView.setOnTouchListener(
                                    new View.OnTouchListener() {
                                        public boolean onTouch(View myView, MotionEvent event) {
                                            int action = event.getAction();

                                            //coordonnées optenuent du tactile
                                            int Xpos = (int) event.getX();
                                            int Ypos = (int) event.getY();

                                            if (action==MotionEvent.ACTION_DOWN)
                                            {

                                                int ilargeur = 0;
                                                int ihauteur = 0;

                                                if (boolDessin == true) {
                                                    //Coordonnées tapés
                                                    largeur = (EditText) findViewById(R.id.largeur);
                                                    hauteur = (EditText) findViewById(R.id.hauteur);
                                                    ilargeur = Integer.parseInt(largeur.getText().toString());
                                                    ihauteur = Integer.parseInt(hauteur.getText().toString());

                                                    //Paramètre de couleur et mise en forme
                                                    Paint myPaint = new Paint();
                                                    myPaint.setARGB(255, rouge, vert, bleu);
                                                    myPaint.setStrokeWidth(3);
                                                    myPaint.setStyle(Paint.Style.STROKE);

                                                    if (figure.equals("Rectangle")) {
                                                        Figure form;
                                                        form = new Rectangle(ilargeur, ihauteur, Xpos, Ypos,myPaint);
                                                        form.setX(Xpos);
                                                        form.setY(Ypos);
                                                        calque.addFigure(form);
                                                        boolDessin = false;
                                                    } else if (figure.equals("Cercle")) {
                                                        Figure form;
                                                        form = new Circle(Xpos, Ypos, ihauteur,myPaint);
                                                        form.setX(Xpos);
                                                        form.setY(Ypos);
                                                        calque.addFigure(form);
                                                        boolDessin = false;
                                                    } else if (figure.equals("Triangle")) {
                                                        Figure form;
                                                        form = new Triangle(Xpos, Ypos, ilargeur, ihauteur,myPaint);
                                                        form.setX(Xpos);
                                                        form.setY(Ypos);
                                                        calque.addFigure(form);
                                                        boolDessin = false;
                                                    }
                                                }

                                                //Récupère au clic la figure la plus proche
                                                figureEnCour = calque.findToMove(Xpos, Ypos);

                                                //Si le boutton supprimer est actif alors on supprime
                                                if(boolSupr){
                                                    calque.removeFigure(figureEnCour);
                                                    boolSupr = false;
                                                }

                                            }
                                            else if (action==MotionEvent.ACTION_UP)
                                            {
                                                //myView.setBackgroundColor(Color.RED);
                                            }
                                            else if (action==MotionEvent.ACTION_MOVE)
                                            {
                                                //Pour le déplacement de la figure la plus proche
	                            /*if(boolSupr!=true && boolDessin!=true){
	                                figureTemp = figureEnCour;
	
	                                System.out.println("avant");
	                                System.out.println("x "+figureTemp.getX());
	                                System.out.println("y "+figureTemp.getY());
	                                figureTemp.setX(Xpos);
	                                figureTemp.setY(Ypos);
	                                System.out.println("apres");
	                                System.out.println("x "+figureTemp.getX());
	                                System.out.println("y "+figureTemp.getY());
	
	
	                                //On supprime la figure passé
                                calque.removeFigure(figureEnCour);
	                                //figureEnCour = figureTemp;
	                                calque.addFigure(figureTemp);
	                            }*/
                                            }

                                            return true;
                                        }
                                    }
                            );


                            if (figure.equals("Rectangle")) {
                                if(boolDessin == true){
                                    Figure form;
                                    form = new Rectangle(ilargeur,ihauteur,Xpos,Ypos);
                                    form.setX(Xpos);
                                    form.setY(Ypos);
                                    calque.addFigure(form);
                                    boolDessin = false;
                                }
                            }else if (figure.equals("Cercle")) {
                                if(boolDessin == true){
                                    Figure form;
                                    form = new Circle(Xpos,Ypos,ihauteur);
                                    form.setX(Xpos);
                                    form.setY(Ypos);
                                    calque.addFigure(form);
                                    boolDessin = false;
                                }
                            } else if (figure.equals("Triangle")) {
                                if(boolDessin == true){
                                    Figure form;
                                    form = new Triangle(Xpos, Ypos,ilargeur,ihauteur);
                                    form.setX(Xpos);
                                    form.setY(Ypos);
                                    calque.addFigure(form);
                                    boolDessin = false;
                                }
                            }

                            view.getId();

                            return true;
                        }
                    });
                }


                public class MainActivity extends ActionBarActivity {

                    //On passe le booleen a vrai et on donne le droit de dessiner
                    boolDessin = true;

                }

                public void SuprFigure(View v) {

                    //On passe le booleen a vrai et on donne le droit de Supprimer
                    boolSupr = true;
                }
