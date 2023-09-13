package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KykSyouhnRireki;

import com.google.common.base.Predicate;

/**
 * 契約商品履歴テーブル用 Predicate<br/>
 * 効力発生日　＞　I．効力発生日
 */
public class FilterKykSyouhnRirekiByKouryokuhasseiymdGt implements Predicate<IT_KykSyouhnRireki> {

    BizDate kouryokuhasseiymd;

    public FilterKykSyouhnRirekiByKouryokuhasseiymdGt(BizDate pKouryokuhasseiymd) {
        super();
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    @Override
    public boolean apply(IT_KykSyouhnRireki kykSyouhnRireki) {
        if (kykSyouhnRireki.getKouryokuhasseiymd() != null &&
            kouryokuhasseiymd.compareTo(kykSyouhnRireki.getKouryokuhasseiymd()) < 0 ) {
            return true;
        }
        return false;
    }

}
