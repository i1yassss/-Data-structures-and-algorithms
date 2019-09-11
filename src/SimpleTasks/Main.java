package SimpleTasks;

import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {

    enum Type { DEPOSIT, WITHDRAWAL }

    static class Transaction {

        final Type type;
        final String currency;
        final Long amount;

        Transaction(@NotNull Type type,
                    @NotNull String currency,
                    @NotNull Long amount) {
            this.type = type;
            this.currency = currency;
            this.amount = amount;
        }

        String getCurrency() {
            return currency;
        }

        Long getAmount() {
            return amount;
        }

        Type getType() {
            return type;
        }
    }
    /*// не успел довести до ума
    public  Map<String, Double> getAverageDepositAmountByCurrency(List<Transaction> transactions) {
        Map<String, Double> result;
        for(Transaction tr : transactions){
            if(tr.getCurrency().equals(SimpleTasks.Main.Type.DEPOSIT)){
                //смотрим в  Map есть ли там нужный ключ currency, если нет то добавляем
                //затем изменяем значение нашего ключа
            }
        }
        //return result;
    }*/
}
