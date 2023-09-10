package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterNyuukinByRenno implements Predicate<HT_Nyuukin>{

    Integer renno;

    public FilterNyuukinByRenno(Integer pRenno){
        super();

        renno = pRenno;
    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {

        if (renno.equals(pNyuukin.getRenno())) {

            return true;
        }
        return false;
    }
}
