package view;

import domain.Record;

import java.util.List;

public class RecordView {

    public void printRecords(List<Record> records) {
        System.out.println("-----------------------------------------");
        for (Record record : records) {
            if (record.getType().equals("입금")) {
                System.out.println("| 입금 내역                              |");
            } else {
                System.out.println("| 출금 내역                              |");
            }

            // 각 출력 항목의 길이를 고정하여 간격 맞춤
            System.out.println(String.format("| %-10s : %,11d원           |", record.getType() + " 금액", record.getMoney()));
            System.out.println(String.format("| %-10s : %-22s |", "메모", record.getMemo()));
            System.out.println("-----------------------------------------");
        }
    }
}
