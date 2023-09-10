package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_Sk;

import com.google.common.base.Predicate;

/**
 * 請求テーブル用 Predicate<br/>
 * 請求履歴番号（一致）<br/>
 */
public class FilterSkBySeikyuurirekino implements Predicate<JT_Sk> {

    Integer seikyuurirekino;

    public FilterSkBySeikyuurirekino(Integer pSeikyuurirekino){

        super();

        seikyuurirekino = pSeikyuurirekino;
    }

    @Override
    public boolean apply(JT_Sk pSk){

        if (seikyuurirekino != null && seikyuurirekino.equals(pSk.getSeikyuurirekino())) {

            return true;
        }

        return false;
    }
}
