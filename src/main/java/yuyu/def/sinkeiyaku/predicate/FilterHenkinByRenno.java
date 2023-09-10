package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterHenkinByRenno implements Predicate<HT_Henkin>{

    Integer renno;

    public FilterHenkinByRenno(Integer pRenno){
        super();

        renno = pRenno;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {
        if (renno.equals(pHenkin.getRenno())) {

            return true;
        }
        return false;
    }

}
