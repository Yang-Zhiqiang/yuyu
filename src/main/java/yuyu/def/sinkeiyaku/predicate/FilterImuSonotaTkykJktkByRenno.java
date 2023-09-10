package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_ImuSonotaTkykJktk;

import com.google.common.base.Predicate;

/**
 * 医務査定その他特約条件付テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterImuSonotaTkykJktkByRenno implements Predicate<HT_ImuSonotaTkykJktk> {

    Integer renno;

    public FilterImuSonotaTkykJktkByRenno(Integer pRenno) {
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(HT_ImuSonotaTkykJktk hT_ImuSonotaTkykJktk) {
        if (renno.equals(hT_ImuSonotaTkykJktk.getRenno())) {
            return true;
        }
        return false;
    }

}
