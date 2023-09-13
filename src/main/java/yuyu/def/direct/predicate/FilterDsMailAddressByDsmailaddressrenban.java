package yuyu.def.direct.predicate;

import yuyu.def.db.entity.MT_DsMailAddress;

import com.google.common.base.Predicate;

/**
 * ＤＳメールアドレステーブル用 Predicate<br/>
 * ＤＳメールアドレス連番（一致）<br/>
 */
public class FilterDsMailAddressByDsmailaddressrenban implements Predicate<MT_DsMailAddress>{

    Integer dsmailaddressrenban;

    public FilterDsMailAddressByDsmailaddressrenban(Integer pDsmailaddressrenban) {

        super();
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @Override
    public boolean apply(MT_DsMailAddress pDsMailAddress) {

        if (dsmailaddressrenban.equals(pDsMailAddress.getDsmailaddressrenban())) {

            return true;
        }
        return false;
    }

}
