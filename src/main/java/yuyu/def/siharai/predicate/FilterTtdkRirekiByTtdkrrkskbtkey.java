package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_TtdkRireki;

import com.google.common.base.Predicate;

/**
 * 手続履歴テーブル用 Predicate<br/>
 * 手続履歴識別キー（一致）<br/>
 */
public class FilterTtdkRirekiByTtdkrrkskbtkey implements Predicate<JT_TtdkRireki>{

    String ttdkrrkskbtkey;

    public FilterTtdkRirekiByTtdkrrkskbtkey(String pTtdkrrkskbtkey){

        super();

        ttdkrrkskbtkey = pTtdkrrkskbtkey;
    }

    @Override
    public boolean apply(JT_TtdkRireki pTtdkRireki){

        if (ttdkrrkskbtkey.equals(pTtdkRireki.getTtdkrrkskbtkey())) {

            return true;
        }

        return false;
    }
}
