package yuyu.common.hozen.khcommon.dba4commonnyuukin;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.base.Predicate;

/**
 * 前納テーブル用Predicateクラス１
 */
public class FilterZennou1 implements Predicate<IT_Zennou> {

    BizDate zennoustartymd;

    public FilterZennou1(BizDate pZennoustartymd) {
        super();
        zennoustartymd = pZennoustartymd;
    }

    @Override
    public boolean apply(IT_Zennou pZennou) {
        if (BizDateUtil.compareYmd(zennoustartymd, pZennou.getZennoukaisiymd()) == BizDateUtil.COMPARE_EQUAL) {
            return true;
        }
        return false;
    }
}
