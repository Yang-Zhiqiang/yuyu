package yuyu.common.biz.koutei;

import java.util.Comparator;

/**
 * 業務共通 工程 工程サマリ取得ソート指定（ワークリスト表示順）
 */
public class BzGetProcessSummaryComparatorWorkListHyoujijun implements Comparator<BzGetProcessSummaryOutBean> {

    @Override
    public int compare(BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean1, BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean2) {

        String subSystemId1 = pBzGetProcessSummaryOutBean1.getSubSystemId();
        String subSystemId2 = pBzGetProcessSummaryOutBean2.getSubSystemId();

        Integer jimutetuzukiDispOrder1 = pBzGetProcessSummaryOutBean1.getJimutetuzukiDispOrder();
        Integer jimutetuzukiDispOrder2 = pBzGetProcessSummaryOutBean2.getJimutetuzukiDispOrder();

        Integer tskDispOrder1 = pBzGetProcessSummaryOutBean1.getTskDispOrder();
        Integer tskDispOrder2 = pBzGetProcessSummaryOutBean2.getTskDispOrder();

        if (!subSystemId1.equals(subSystemId2)) {
            return subSystemId1.compareTo(subSystemId2);
        }
        else if(!(jimutetuzukiDispOrder1.equals(jimutetuzukiDispOrder2))){
            return jimutetuzukiDispOrder1 - jimutetuzukiDispOrder2;
        }
        else {
            return tskDispOrder1 - tskDispOrder2;
        }
    }
}
