package yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.base.Predicate;

/**
 * 前納テーブル用Predicateクラス１
 */
public class FilterZennou1 implements Predicate<IT_Zennou> {

    BizDate zennoukaisiymd;

    Integer renno;

    public FilterZennou1(BizDate pZennoukaisiymd, Integer pRenno) {
        super();
        zennoukaisiymd = pZennoukaisiymd;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_Zennou pZennou) {
        if (zennoukaisiymd.compareTo(pZennou.getZennoukaisiymd()) == 0 &&
            renno == pZennou.getRenno()) {
            return true;
        }
        return false;
    }
}