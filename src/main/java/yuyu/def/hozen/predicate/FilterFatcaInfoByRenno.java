package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_FatcaInfo;

import com.google.common.base.Predicate;

/**
 * ＦＡＴＣＡ情報テーブル用 Predicate<br/>
 * 連番（一致）<br/>
 */
public class FilterFatcaInfoByRenno implements Predicate<IT_FatcaInfo> {

    Integer renno;

    public FilterFatcaInfoByRenno(Integer pRenno) {
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_FatcaInfo fatcaInfo) {
        if (renno.equals(fatcaInfo.getRenno())) {
            return true;
        }
        return false;
    }
}