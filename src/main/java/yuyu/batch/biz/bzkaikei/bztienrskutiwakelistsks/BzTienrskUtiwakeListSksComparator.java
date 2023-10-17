package yuyu.batch.biz.bzkaikei.bztienrskutiwakelistsks;

import java.util.Comparator;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 業務共通 経理・会計 支払遅延利息内訳リスト作成用Beanソートクラス
 */
public class BzTienrskUtiwakeListSksComparator implements Comparator<BzTienrskUtiwakeListSksBean>{

    @Override
    public int compare(BzTienrskUtiwakeListSksBean pBzTienrskUtiwakeListSksBean1,
        BzTienrskUtiwakeListSksBean pBzTienrskUtiwakeListSksBean2) {

        String shiharaiTienRisoCd1 = pBzTienrskUtiwakeListSksBean1.getShiharaiTienRisoCd() == null ? "" :
            pBzTienrskUtiwakeListSksBean1.getShiharaiTienRisoCd();
        String shiharaiTienRisoCd2 = pBzTienrskUtiwakeListSksBean2.getShiharaiTienRisoCd() == null ? "" :
            pBzTienrskUtiwakeListSksBean2.getShiharaiTienRisoCd();
        String syoriCd1 = pBzTienrskUtiwakeListSksBean1.getSyoriCd() == null ? "" :
            pBzTienrskUtiwakeListSksBean1.getSyoriCd();
        String syoriCd2 = pBzTienrskUtiwakeListSksBean2.getSyoriCd() == null ? "" :
            pBzTienrskUtiwakeListSksBean2.getSyoriCd();

        if (!shiharaiTienRisoCd1.equals(shiharaiTienRisoCd2)) {

            if (BizUtil.isBlank(shiharaiTienRisoCd1)) {

                return -1;
            }
            else if (BizUtil.isBlank(shiharaiTienRisoCd2)) {

                return 1;
            }
            else {

                return shiharaiTienRisoCd1.compareTo(shiharaiTienRisoCd2);
            }
        }

        if (BizUtil.isBlank(syoriCd1)) {

            return -1;
        }
        else if (BizUtil.isBlank(syoriCd2)) {

            return 1;
        }
        else {

            return syoriCd1.compareTo(syoriCd2);

        }
    }
}
