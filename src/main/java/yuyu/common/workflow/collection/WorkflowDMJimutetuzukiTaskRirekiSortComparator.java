package yuyu.common.workflow.collection;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;

/**
 * 事務手続タスクマスタ履歴保存エンティティリストをソートするためのコンパレータです。<br />
 * ソート条件は｛件数保管日の昇順、表示順 の昇順｝です。
 */
public class WorkflowDMJimutetuzukiTaskRirekiSortComparator implements Comparator<DM_JimutetuzukiTaskRireki> {

    @Override
    public int compare(DM_JimutetuzukiTaskRireki o1, DM_JimutetuzukiTaskRireki o2) {

        BizDate kensuuHokanYmd1 = o1.getKensuuHokanYmd() == null ? BizDate.MAX_VALUE : o1.getKensuuHokanYmd();
        BizDate kensuuHokanYmd2 = o2.getKensuuHokanYmd() == null ? BizDate.MAX_VALUE : o2.getKensuuHokanYmd();
        int hyoujijyun1 = o1.getHyoujijyun() == null ? 0 : o1.getHyoujijyun();
        int hyoujijyun2 = o2.getHyoujijyun() == null ? 0 : o2.getHyoujijyun();

        if (!kensuuHokanYmd1.equals(kensuuHokanYmd2)) {
            return kensuuHokanYmd1.compareTo(kensuuHokanYmd2);
        }

        if (hyoujijyun1 != hyoujijyun2) {
            if (hyoujijyun1 == 0) {
                return -1;
            }
            if (hyoujijyun2 == 0) {
                return 1;
            }
            if (hyoujijyun1 > hyoujijyun2) {
                return 1;
            }
            return -1;
        }
        return 0;
    }
}