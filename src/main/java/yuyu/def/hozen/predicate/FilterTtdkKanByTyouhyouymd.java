package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TtdkKan;

import com.google.common.base.Predicate;

/**
 * 手続完了テーブル Predicate<br/>
 * 帳票作成日（一致）<br/>
 */
public class FilterTtdkKanByTyouhyouymd implements Predicate<IT_TtdkKan> {

    BizDate tyouhyouymd;

    public FilterTtdkKanByTyouhyouymd(BizDate pTyouhyouymd) {
        super();
        tyouhyouymd = pTyouhyouymd;
    }

    @Override
    public boolean apply(IT_TtdkKan pTtdkKan) {
        if (pTtdkKan.getTyouhyouymd() != null && tyouhyouymd.equals(pTtdkKan.getTyouhyouymd())) {
            return true;
        }
        return false;
    }
}