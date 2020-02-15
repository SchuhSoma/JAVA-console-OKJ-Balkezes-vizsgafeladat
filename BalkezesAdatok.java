/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balkezes_okj;

/**
 *
 * @author Soma
 */
class BalkezesAdatok
{
    //név;első;utolsó;súly;magasság
    public String Nev;
    public String Elso;
    public String Utolso;
    public Integer SulyFont;
    public Integer MagassagInch;

    public BalkezesAdatok(String Nev, String Elso, String Utolso, Integer SulyFont, Integer MagassagInch) {
        this.Nev = Nev;
        this.Elso = Elso;
        this.Utolso = Utolso;
        this.SulyFont = SulyFont;
        this.MagassagInch = MagassagInch;
    }

    public String getNev() {
        return Nev;
    }

    public String getElso() {
        return Elso;
    }

    public String getUtolso() {
        return Utolso;
    }

    public Integer getSulyFont() {
        return SulyFont;
    }

    public Integer getMagassagInch() {
        return MagassagInch;
    }
    
}
