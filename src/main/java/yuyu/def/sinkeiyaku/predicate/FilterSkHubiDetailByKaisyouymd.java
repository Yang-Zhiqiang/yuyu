package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_SkHubiDetail;

import com.google.common.base.Predicate;

/**
 * 新契約不備詳細テーブル用 Predicate<br/>
 * 解消日（一致）
 */
public class FilterSkHubiDetailByKaisyouymd implements Predicate<HT_SkHubiDetail> {

    BizDate kaisyouymd;

    public FilterSkHubiDetailByKaisyouymd(BizDate pKaisyouymd) {
        super();
        kaisyouymd = pKaisyouymd;
    }

    @Override
    public boolean apply(HT_SkHubiDetail pHT_SkHubiDetail) {

        if (kaisyouymd == null && pHT_SkHubiDetail.getKaisyouymd() == null) {
            return true;

        } else if (kaisyouymd != null && kaisyouymd.equals(pHT_SkHubiDetail.getKaisyouymd())) {
            return true;
        }

        return false;
    }

}
