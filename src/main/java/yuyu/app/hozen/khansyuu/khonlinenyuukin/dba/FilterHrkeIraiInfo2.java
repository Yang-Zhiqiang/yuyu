package yuyu.app.hozen.khansyuu.khonlinenyuukin.dba;

import yuyu.def.db.entity.IT_HrkeIraiInfo;
import com.google.common.base.Predicate;

/**
 * 振替依頼情報テーブル用Predicateクラス２<br />
 * 変更識別キー（一致）<br />
 */
public class FilterHrkeIraiInfo2 implements Predicate<IT_HrkeIraiInfo> {
    String henkouSikibetuKey;

    public FilterHrkeIraiInfo2(String pHenkouSikibetuKey) {
        super();
        henkouSikibetuKey = pHenkouSikibetuKey;
    }

    @Override
    public boolean apply(IT_HrkeIraiInfo pHrkeIraiInfo) {
        if (henkouSikibetuKey.equals(pHrkeIraiInfo.getHenkousikibetukey())) {
            return true;
        }

        return false;
    }
}