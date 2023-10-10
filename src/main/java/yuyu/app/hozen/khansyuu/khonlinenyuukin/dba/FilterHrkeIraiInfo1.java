package yuyu.app.hozen.khansyuu.khonlinenyuukin.dba;

import yuyu.def.classification.C_HrkeAnnaiJkKbn;
import yuyu.def.db.entity.IT_HrkeIraiInfo;

import com.google.common.base.Predicate;

/**
 * 振替依頼情報テーブル用Predicateクラス１<br />
 * 振替案内状況区分（一致）<br />
 */
public class FilterHrkeIraiInfo1 implements Predicate<IT_HrkeIraiInfo> {
    C_HrkeAnnaiJkKbn hrkeAnnaiJkKbn;

    public FilterHrkeIraiInfo1(C_HrkeAnnaiJkKbn pHrkeAnnaiJkKbn) {
        super();
        hrkeAnnaiJkKbn = pHrkeAnnaiJkKbn;
    }

    @Override
    public boolean apply(IT_HrkeIraiInfo pHrkeIraiInfo) {
        if (hrkeAnnaiJkKbn.eq(pHrkeIraiInfo.getHrkeannaijkkbn())) {
            return true;
        }

        return false;
    }
}