package yuyu.def.direct.predicate;

import yuyu.def.db.entity.MT_DsHaisinErrorList;

import com.google.common.base.Predicate;
/**
 * ＤＳ配信エラーリストテーブル用  Predicate<br/>
 * ＤＳメールアドレス連番<br/>
 */
public class FilterDsHaisinErrorListByDsmailaddressrenban implements Predicate<MT_DsHaisinErrorList> {
    Integer dsmailaddressrenban;

    public FilterDsHaisinErrorListByDsmailaddressrenban(Integer pDsmailaddressrenban) {

        super();

        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @Override
    public boolean apply(MT_DsHaisinErrorList pDsHaisinErrorList) {

        if (dsmailaddressrenban.equals(pDsHaisinErrorList.getDsmailaddressrenban())) {

            return true;
        }

        return false;
    }
}
