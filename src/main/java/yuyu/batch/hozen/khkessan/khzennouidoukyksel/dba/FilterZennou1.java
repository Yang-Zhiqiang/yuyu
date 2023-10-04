package yuyu.batch.hozen.khkessan.khzennouidoukyksel.dba;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.base.Predicate;

import jp.co.slcs.swak.date.BizDate;

/**
 * 前納用Predicateクラス１
 */
public class FilterZennou1 implements Predicate<IT_Zennou> {

    private BizDate zennoukaisiymd;

    private Integer renno;

    public FilterZennou1(BizDate pZennoukaisiYmd, Integer pRenno) {
        super();
        zennoukaisiymd = pZennoukaisiYmd;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_Zennou pZennou) {
        if (BizDateUtil.compareYmd(zennoukaisiymd, pZennou.getZennoukaisiymd()) == BizDateUtil.COMPARE_EQUAL &&
            renno.equals(pZennou.getRenno())) {
            return true;
        }
        return false;
    }
}
