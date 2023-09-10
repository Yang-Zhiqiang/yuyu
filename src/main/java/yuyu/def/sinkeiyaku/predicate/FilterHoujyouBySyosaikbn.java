package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.db.entity.HT_Houjyou;

import com.google.common.base.Predicate;

/**
 * 報状テーブル用 Predicate<br/>
 * 初診再診区分（一致）
 */
public class FilterHoujyouBySyosaikbn implements Predicate<HT_Houjyou> {

    C_SyosaiKbn Syosaikbn;

    public FilterHoujyouBySyosaikbn(C_SyosaiKbn pSyosaikbn) {
        super();
        Syosaikbn = pSyosaikbn;
    }

    @Override
    public boolean apply(HT_Houjyou pHT_Houjyou) {
        if (Syosaikbn.eq(pHT_Houjyou.getSyosaikbn())) {
            return true;
        }
        return false;
    }
}
