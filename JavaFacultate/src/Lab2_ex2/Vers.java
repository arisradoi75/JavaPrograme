package Lab2_ex2;

public class Vers {
    private String text;

    public Vers(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text.trim();
    }

    public int numarCuvinte(){
        if(text.trim().isEmpty()) return 0;
        String[] cuvinte = text.split("//s+");
        return cuvinte.length;
    }
    public int numarVocale(){
        int count = 0;
        String lower = text.toLowerCase();
        for(char c : lower.toCharArray()){
            if("aeiouăâîAEIOUĂÂÎ".indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }
    public String majuscule(){
        return text.toUpperCase();
    }

    public boolean seTerminaCu(String secvtenta){
        return text.toLowerCase().endsWith(secvtenta.toLowerCase());
    }




}
