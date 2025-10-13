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
        String[] cuvinte = text.split("//s+"); // cream un string de cuvinte care ii atribuim valorea textului despartit de spatii albe
        return cuvinte.length; // returnam nr de cuvinte
    }
    public int numarVocale(){
        int count = 0; // initilizam un cont cu 0
        String lower = text.toLowerCase(); // convertim sirul in litere mici
        for(char c : lower.toCharArray()){ // tranforma sirul intr un tablou array si folosim un for care sa parcurga pt fiecare element din tablou
            if("aeiouăâîAEIOUĂÂÎ".indexOf(c) >= 0) { // cauta caracterul c si verifica daca este vocala , in momentul in care este count-ul se incrementeaza
                count++;
            }
        }
        return count; // returnam numarul de vocale
    }
    public String majuscule(){
        return text.toUpperCase(); // transformam tot textul in majuscule
    }

    public boolean seTerminaCu(String secvtenta){
        return text.toLowerCase().endsWith(secvtenta.toLowerCase()); // convertim tot textul in litere mici
        //il verificam daca se termina cu secventa data de la tastatura ( care o convertim in litere mici pt a face comparatia )
    }

}
