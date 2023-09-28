package yuyu.common.biz.koutei;

import java.util.Comparator;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 業務共通 工程 工程サマリ取得ソート指定（請求番号証券番号）
 */
public class BzGetProcessSummaryComparatorSknoSyono implements Comparator<BzGetProcessSummaryOutBean> {

    @Override
    public int compare(BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean1, BzGetProcessSummaryOutBean pBzGetProcessSummaryOutBean2) {

        String skNo1 = pBzGetProcessSummaryOutBean1.getSkNo();
        String skNo2 = pBzGetProcessSummaryOutBean2.getSkNo();

        String syoNo1 = pBzGetProcessSummaryOutBean1.getSyoNo();
        String syoNo2 = pBzGetProcessSummaryOutBean2.getSyoNo();

        if (BizUtil.isBlank(skNo1)) {
            if (!BizUtil.isBlank(skNo2)) {
                return -1;
            }

            return syoNo1.compareTo(syoNo2);
        }

        if (BizUtil.isBlank(skNo2)) {
            return 1;
        }

        if (!skNo1.equals(skNo2)) {
            return skNo1.compareTo(skNo2);
        }
        return syoNo1.compareTo(syoNo2);
    }
}
