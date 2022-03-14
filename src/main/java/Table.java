
import com.github.freva.asciitable.AsciiTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Table {

    public static void show(Map<String, String> move) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> s: move.entrySet()) {
            list.add(s.getValue());
        }

        String[] header = new String[list.size()-1];
        for(int i = 0, j =0; i< list.size()-2;i++,j++){
            if(j == 0) {
                header[j] = "PC/user";
                header[j+1] = list.get(i);
            }
            else  header[j+1] =  list.get(i);
        }
        String[][] body = new String[list.size()-2][list.size()-1];
        for (int i = 0; i < list.size()-2;i++){
            body[i][0] = list.get(i);
            for (int j = 0; j < list.size()-2;j++){


                if(i > j && i <= j + (list.size()-3)/2 )
                    body[i][j+1] = "lose";
                else if(i > j) body[i][j+1] = "win";

                else if(i < j && j<=i+(list.size()-3)/2) body[i][j+1] = "win";


                else if(i<j) body[i][j+1] = "lose";
                else if(i == j) body[i][j+1] = "draw";
            }

        }

        System.out.println(AsciiTable.getTable(header,body));

    }

}

