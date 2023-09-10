package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;

import com.google.common.base.Predicate;

/**
 * 受取口座情報テーブル用 Predicate<br />
 * 受取口座種別区分（一致）<br />
 */
public class FilterUketoriKouzaJyouhouByUktkzsyubetukbn implements Predicate<HT_UketoriKouzaJyouhou> {

    C_UketorikouzasyubetuKbn uktkzsyubetukbn;

    public FilterUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {

        super();

        uktkzsyubetukbn = pUktkzsyubetukbn;
    }

    @Override
    public boolean apply(HT_UketoriKouzaJyouhou pUktkzsyubetukbn) {

        if (uktkzsyubetukbn.eq(pUktkzsyubetukbn.getUktkzsyubetukbn())) {

            return true;
        }

        return false;
    }
}
