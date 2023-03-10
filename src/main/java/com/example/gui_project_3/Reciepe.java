package com.example.gui_project_3;

import java.util.ArrayList;
import java.util.Collections;

public class Reciepe {
    private String name;

    public Ingredient[] ingredient;
    static ArrayList<Reciepe> reciepes = new ArrayList<Reciepe>();

    public Reciepe(String name, Ingredient... ingredient) {
        if (ingredient.length >= 2) {
            this.name = name;
            this.ingredient = ingredient;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient[] ingredient) {
        this.ingredient = ingredient;
    }

    public static ArrayList<Reciepe> getReciepes() {
        return reciepes;
    }

    public static void setReciepes(ArrayList<Reciepe> reciepes) {
        Reciepe.reciepes = reciepes;
    }


    public String point(Reciepe reciep) {
        int sweet = 0;
        int salty = 0;
        int bitter = 0; //gorzki
        int sour = 0; //kwasny
        int neutral = 0;
        String res = null;

        for (Ingredient igr : reciep.ingredient) {
            switch (igr.getTaste()) {
                case "Sweet":
                    sweet++;
                    break;

                case "Salty":
                    salty++;
                    break;

                case "Bitter":
                    bitter++;
                    break;

                case "Sour":
                    sour++;
                    break;

                case "Neutral":
                    neutral++;
                    break;
            }
        }
        if (sweet > salty && sweet > bitter && sweet > sour && sweet > neutral) {
            res = "To danie jest tak slodkie, ze nadaje sie na deser!";
        } else if (salty > sweet && salty > bitter && salty > sour && salty > neutral) {
            res = "To danie jest slone!";
        } else if (bitter > sweet && bitter > salty && bitter > sour && bitter > neutral) {
            res = "To danie jest gorzke!";
        } else if (sour > sweet && sour > salty && sour > bitter && sour > neutral) {
            res = "To danie jest kwasne!";
        } else if (neutral > sweet && neutral > salty && neutral > bitter && neutral > sour) {
            res = "To danie jest neutralne!";
        } else if (sweet == 1 && salty == 1 && bitter == 1 && sour == 1 && neutral == 1) {
            res = "To danie jest tak zle ze az ciezko na nie patrzec!";
        } else if (sweet == salty || sweet == bitter || sweet == sour || sweet == neutral) {
            res = "To danie jest zbalansowane";
        } else if (salty == bitter || salty == sour || salty == neutral) {
            res = "To danie jest zbalansowane";
        } else if (bitter == sour || bitter == neutral) {
            res = "To danie jest zbalansowane";
        } else if (sour == neutral) {
            res = "To danie jest zbalansowane";
        }
        return res;
    }
}
