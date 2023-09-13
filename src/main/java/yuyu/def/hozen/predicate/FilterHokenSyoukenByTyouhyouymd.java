package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_HokenSyouken;

import com.google.common.base.Predicate;

/**
 * 保険証券テーブル用 Predicate<br/>
 * 帳票作成日（一致）<br/>
 */
public class FilterHokenSyoukenByTyouhyouymd implements Predicate<IT_HokenSyouken> {

    BizDate tyouhyouymd;

    public FilterHokenSyoukenByTyouhyouymd(BizDate pTyouhyouymd) {
        super();
        tyouhyouymd = pTyouhyouymd;
    }

    @Override
    public boolean apply(IT_HokenSyouken hokenSyouken) {
        if (tyouhyouymd.equals(hokenSyouken.getTyouhyouymd())) {
            return true;
        }
        return false;
    }
}