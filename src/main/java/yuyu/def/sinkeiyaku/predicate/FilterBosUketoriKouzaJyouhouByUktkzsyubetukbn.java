package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;

import com.google.common.base.Predicate;

/**
 * 募集基本テーブル用 Predicate<br/>
 * 受取口座種別区分（一致）<br/>
 */
public class FilterBosUketoriKouzaJyouhouByUktkzsyubetukbn implements Predicate<HT_BosUketoriKouzaJyouhou> {

    C_UketorikouzasyubetuKbn uktkzsyubetukbn;

    public FilterBosUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {

        super();

        uktkzsyubetukbn = pUktkzsyubetukbn;
    }

    @Override
    public boolean apply(HT_BosUketoriKouzaJyouhou pBosUketoriKouzaJyouhou) {

        if (uktkzsyubetukbn.eq(pBosUketoriKouzaJyouhou.getUktkzsyubetukbn())) {

            return true;
        }

        return false;
    }
}
