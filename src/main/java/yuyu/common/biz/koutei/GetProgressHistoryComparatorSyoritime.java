package yuyu.common.biz.koutei;

import java.util.Comparator;

/**
 * 業務共通 工程 進捗履歴情報取得ソート指定（処理日時）
 */
public class GetProgressHistoryComparatorSyoritime implements Comparator<GetProgressHistoryOutBean>{

    @Override
    public int compare(GetProgressHistoryOutBean pGetProgressHistoryOutputBean1 ,
        GetProgressHistoryOutBean pGetProgressHistoryOutputBean2) {

        String syoriTime1 = pGetProgressHistoryOutputBean1.getSyoriTime();

        String syoriTime2 = pGetProgressHistoryOutputBean2.getSyoriTime();

        int result = syoriTime2.compareTo(syoriTime1);

        return result;
    }
}
