package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_AeoiInfo;

import com.google.common.base.Predicate;

/**
 * ＡＥＯＩ情報テーブルエンティティ用 Predicate<br/>
 * 連番（一致）<br/>
 */
public class FilterAeoiInfoByRenno implements Predicate<IT_AeoiInfo> {

    Integer renno;

    public FilterAeoiInfoByRenno(Integer pRenno) {
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_AeoiInfo pAeoiInfo) {
        if (renno.equals(pAeoiInfo.getRenno())) {
            return true;
        }
        return false;
    }
}