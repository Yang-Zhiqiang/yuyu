package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import java.util.Comparator;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_SeibiRiyuuKbn;

/**
 * SearchresultInfoDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛整備理由区分の昇順、ＤＳ顧客番号の昇順、証券番号の昇順｝です。
 */
public class SearchResultInfoDataSourceBeanSortComparator implements Comparator<SearchResultInfoDataSourceBean> {

    @Override
    public int compare(SearchResultInfoDataSourceBean o1, SearchResultInfoDataSourceBean o2) {

        C_SeibiRiyuuKbn sei1 = o1.getSeibiriyuukbn();
        C_SeibiRiyuuKbn sei2 = o2.getSeibiriyuukbn();

        String kok1 = o1.getDskokno() == null ? "" : o1.getDskokno();
        String kok2 = o2.getDskokno() == null ? "" : o2.getDskokno();

        String syo1 = o1.getSyono() == null ? "" : o1.getSyono();
        String syo2 = o2.getSyono() == null ? "" : o2.getSyono();

        if (!sei1.eq(sei2)) {
            if (C_SeibiRiyuuKbn.BLANK.eq(sei1)) {
                return -1;
            }
            if (C_SeibiRiyuuKbn.BLANK.eq(sei2)) {
                return 1;
            }

            return sei1.compareTo(sei2);
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
