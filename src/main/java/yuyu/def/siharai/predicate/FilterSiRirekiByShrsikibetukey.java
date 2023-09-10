package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SiRireki;

import com.google.common.base.Predicate;

/**
 * 支払履歴テーブル用 Predicate<br/>
 * 支払識別キー（一致）<br/>
 */
public class FilterSiRirekiByShrsikibetukey implements Predicate<JT_SiRireki>{

    String shrsikibetukey;

    public FilterSiRirekiByShrsikibetukey(String pShrsikibetukey) {

        super();

        shrsikibetukey = pShrsikibetukey;
    }

    @Override
    public boolean apply(JT_SiRireki pSiRireki) {

        if(shrsikibetukey.equals(pSiRireki.getShrsikibetukey())){

            return true;
        }

        return false;
    }
}
