package yuyu.common.biz.koutei;

import java.util.Comparator;

/**
 * 業務共通 工程 工程サマリ取得ソート指定（申込番号）
 */
public class BzGetProcessSummaryComparatorMosno implements Comparator<BzGetProcessSummaryOutBean> {

    @Override
    public int compare(BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean1,
            BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean2) {

        String mosNo1 = pBzGetProcessSummaryOutBean1.getMosNo();
        String mosNo2 = pBzGetProcessSummaryOutBean2.getMosNo();

        return mosNo1.compareTo(mosNo2);
    }
}
