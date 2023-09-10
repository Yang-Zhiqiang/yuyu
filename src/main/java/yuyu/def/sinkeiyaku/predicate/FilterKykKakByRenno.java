package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_KykKak;

import com.google.common.base.Predicate;

/**
 * 契約確認テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterKykKakByRenno implements Predicate<HT_KykKak> {

    Integer renno;

    public FilterKykKakByRenno(Integer pRenno) {
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(HT_KykKak kykKak) {
        if (renno.equals(kykKak.getRenno())) {
            return true;
        }
        return false;
    }
}
