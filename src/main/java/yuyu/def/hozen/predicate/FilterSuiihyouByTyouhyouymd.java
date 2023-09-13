package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_Suiihyou;

import com.google.common.base.Predicate;

/**
 * 推移表テーブル用 Predicate<br/>
 * 帳票作成日（一致）<br/>
 */
public class FilterSuiihyouByTyouhyouymd implements Predicate<IT_Suiihyou> {

    BizDate tyouhyouymd;

    public FilterSuiihyouByTyouhyouymd(BizDate pTyouhyouymd) {
        super();
        tyouhyouymd = pTyouhyouymd;
    }

    @Override
    public boolean apply(IT_Suiihyou suiihyou) {
        if (tyouhyouymd.equals(suiihyou.getTyouhyouymd())) {
            return true;
        }
        return false;
    }
}