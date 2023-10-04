package yuyu.batch.hozen.khkessan.khkessanzennousel.dba;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.base.Predicate;

/**
 * 前納テーブル用 Predicateクラス１<br/>
 * 前納開始年月日、連番（一致）<br/>
 */
public class FilterZennou1 implements Predicate<IT_Zennou>{

    BizDate  zennoukaisiymd;
    Integer renno;

    public FilterZennou1(BizDate pZennoukaisiymd,Integer pRenno) {
        super();
        zennoukaisiymd = pZennoukaisiymd;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_Zennou pZennou) {

        if (BizDateUtil.compareYmd(zennoukaisiymd, pZennou.getZennoukaisiymd()) == BizDateUtil.COMPARE_EQUAL
            && renno == pZennou.getRenno()) {

            return true;
        }

        return false;
    }
}
