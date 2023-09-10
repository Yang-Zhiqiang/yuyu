package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;

import com.google.common.base.Predicate;

/**
 * 受取口座情報ベリファイテーブル用 Predicate<br />
 * 受取口座種別区分（一致）<br />
 */
public class FilterUketoriKouzaJyouhouVrfByUktkzsyubetukbn implements Predicate<HT_UketoriKouzaJyouhouVrf> {

    C_UketorikouzasyubetuKbn kzsyuruikbn;

    public FilterUketoriKouzaJyouhouVrfByUktkzsyubetukbn(C_UketorikouzasyubetuKbn pKzsyuruikbn) {

        super();

        kzsyuruikbn = pKzsyuruikbn;
    }

    @Override
    public boolean apply(HT_UketoriKouzaJyouhouVrf pUketoriKouzaJyouhouVrf) {

        if (kzsyuruikbn.eq(pUketoriKouzaJyouhouVrf.getUktkzsyubetukbn())) {

            return true;
        }

        return false;
    }
}
