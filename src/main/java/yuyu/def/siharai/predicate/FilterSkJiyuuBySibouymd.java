package yuyu.def.siharai.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.JT_SkJiyuu;

import com.google.common.base.Predicate;

/**
 * 請求事由テーブル 用 Predicate<br/>
 * 死亡日（一致）
 */
public class FilterSkJiyuuBySibouymd implements Predicate<JT_SkJiyuu> {

    BizDate hasseiymd;

    public FilterSkJiyuuBySibouymd(BizDate pHasseiymd) {

        super();
        hasseiymd = pHasseiymd;
    }

    @Override
    public boolean apply(JT_SkJiyuu pJT_SkJiyuu) {

        if (pJT_SkJiyuu.getSibouymd() != null
            && hasseiymd.compareTo(pJT_SkJiyuu.getSibouymd()) <= 0) {

            return true;
        }

        return false;
    }
}
