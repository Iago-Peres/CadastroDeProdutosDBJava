
import java.util.Date;
import java.text.SimpleDateFormat; // classe usada para formatar datas

public class ExemploData {

    public static void main(String[] args) {
        Date data = new Date();
        System.out.println(data);//data completa
        System.out.println(data.getDay());
        System.out.println(data.getDate());
        System.out.println(data.getMonth());
        System.out.println(data.getYear()+1900);
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");//MM para mes, mm para minutos
        System.out.println(f.format(data)); //data no formato do banco de dados
    }
}
