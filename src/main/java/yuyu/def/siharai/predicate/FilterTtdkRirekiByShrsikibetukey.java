package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_TtdkRireki;

import com.google.common.base.Predicate;

/**
 * 手続履歴テーブル用 Predicate<br/>
 * 支払識別キー（一致）<br/>
 */
public class FilterTtdkRirekiByShrsikibetukey implements Predicate<JT_TtdkRireki>{

    String shrsikibetukey;

    public FilterTtdkRirekiByShrsikibetukey(String pShrsikibetukey){

        super();

        shrsikibetukey = pShrsikibetukey;
    }

    @Override
    public boolean apply(JT_TtdkRireki pTtdkRireki){

        if (shrsikibetukey.equals(pTtdkRireki.getShrsikibetukey())) {

            return true;
        }

        return false;
    }
}
