package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KhHubiDetail;

import com.google.common.base.Predicate;

/**
 * 請求テーブル用 Predicate<br/>
 * 連番（３桁）（一致）<br/>
 */
public class FilterKhHubiDetailByRenno3keta implements Predicate<IT_KhHubiDetail> {

    Integer renno3keta;

    public FilterKhHubiDetailByRenno3keta(Integer pRenno3keta){

        super();

        renno3keta = pRenno3keta;
    }

    @Override
    public boolean apply(IT_KhHubiDetail pKhHubiDetail) {

        if (renno3keta.equals(pKhHubiDetail.getRenno3keta())){

            return true;
        }

        return false;
    }
}
