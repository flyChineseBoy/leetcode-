import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ti26 {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

     System.out.println("当前日期=" + dtf.format(date));
     String str = "1";
    }

    static Integer getNewArr(int[] arr){
        if(arr.length==0){
            return 0;
        }
        // 用两个指针来维护，快的先走，慢的等待，当快的不等于慢的。 快的 与 慢的后面一位 交换数值。然后继续。
        return 1;
    }
}
