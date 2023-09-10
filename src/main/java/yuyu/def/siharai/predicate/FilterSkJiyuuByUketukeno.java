package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SkJiyuu;

import com.google.common.base.Predicate;

/**
 * 請求事由テーブル用 Predicate<br/>
 * 受付番号（一致）<br />
 */
public class FilterSkJiyuuByUketukeno implements Predicate<JT_SkJiyuu>{

    Integer uketukeno;

    public FilterSkJiyuuByUketukeno(Integer pUketukeno) {

        super();

        uketukeno = pUketukeno;
    }

    @Override
    public boolean apply(JT_SkJiyuu pJT_SkJiyuu) {

        if (uketukeno.equals(pJT_SkJiyuu.getUketukeno())) {

            return true;
        }

        return false;
    }
}