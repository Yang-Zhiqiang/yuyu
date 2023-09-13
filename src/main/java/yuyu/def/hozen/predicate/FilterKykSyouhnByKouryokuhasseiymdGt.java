package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用 Predicate<br/>
 * 効力発生日（一致）<br/>
 */
public class FilterKykSyouhnByKouryokuhasseiymdGt implements Predicate<IT_KykSyouhn> {

    BizDate kouryokuhasseiymd;

    public FilterKykSyouhnByKouryokuhasseiymdGt(BizDate pKouryokuhasseiymd) {
        super();
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    @Override
    public boolean apply(IT_KykSyouhn kykSyouhn) {
        if (kykSyouhn.getKouryokuhasseiymd() != null && kouryokuhasseiymd.compareTo(kykSyouhn.getKouryokuhasseiymd()) < 0) {
            return true;
        }
        return false;
    }
}