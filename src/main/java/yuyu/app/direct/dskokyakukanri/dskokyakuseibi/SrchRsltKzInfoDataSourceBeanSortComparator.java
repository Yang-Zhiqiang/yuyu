package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;


/**
 * SrchRsltKzInfoDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛表示優先度の昇順、廃止年月日の降順、銀行コードの昇順、支店コードの昇順、ＤＳ顧客番号の昇順、証券番号の昇順｝です。
 *整備理由区分の昇順、ＤＳ顧客番号の昇順、証券番号の昇順
 */
public class SrchRsltKzInfoDataSourceBeanSortComparator implements Comparator<SrchRsltKzInfoDataSourceBean> {

    @Override
    public int compare(SrchRsltKzInfoDataSourceBean o1, SrchRsltKzInfoDataSourceBean o2) {

        Integer hyo1 = o1.getHyoujiyuusendo();
        Integer hyo2 = o2.getHyoujiyuusendo();

        BizDate his1 = o1.getHaisiymd() == null ? BizDate.MAX_VALUE : o1.getHaisiymd();
        BizDate his2 = o2.getHaisiymd() == null ? BizDate.MAX_VALUE : o2.getHaisiymd();

        String bnk1 = o1.getDispbankcd() == null ? "" : o1.getDispbankcd();
        String bnk2 = o2.getDispbankcd() == null ? "" : o2.getDispbankcd();

        String stn1 = o1.getDispsitencd() == null ? "" : o1.getDispsitencd();
        String stn2 = o2.getDispsitencd() == null ? "" : o2.getDispsitencd();

        String kok1 = o1.getDskokno() == null ? "" : o1.getDskokno();
        String kok2 = o2.getDskokno() == null ? "" : o2.getDskokno();

        String syo1 = o1.getSyono() == null ? "" : o1.getSyono();
        String syo2 = o2.getSyono() == null ? "" : o2.getSyono();

        if (hyo1 != hyo2) {
            return hyo1.compareTo(hyo2);
        }
        else if (!his1.equals(his2)) {
            if (BizDateUtil.compareYmd(BizDate.MAX_VALUE, his1) == BizDateUtil.COMPARE_EQUAL) {
                return 1;

            }
            if (BizDateUtil.compareYmd(BizDate.MAX_VALUE, his2) == BizDateUtil.COMPARE_EQUAL) {
                return -1;
            }

            return his2.compareTo(his1);
        }
        else if (!bnk1.equals(bnk2)) {
            if (BizUtil.isBlank(bnk1)) {
                return -1;
            }
            if (BizUtil.isBlank(bnk2)) {
                return 1;
            }

            return bnk1.compareTo(bnk2);
        }
        else if (!stn1.equals(stn2)) {
            if (BizUtil.isBlank(stn1)) {
                return -1;
            }
            if (BizUtil.isBlank(stn2)) {
                return 1;
            }

            return stn1.compareTo(stn2);
        }
        else if (!kok1.equals(kok2)) {
            if (BizUtil.isBlank(kok1)) {
                return -1;
            }
            if (BizUtil.isBlank(kok2)) {
                return 1;
            }

            return kok1.compareTo(kok2);
        }
        else {
            if (BizUtil.isBlank(syo1)) {
                return -1;
            }
            if (BizUtil.isBlank(syo2)) {
                return 1;
            }

            return syo1.compareTo(syo2);
        }
    }
}
