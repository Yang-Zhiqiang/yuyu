package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_MosSyouhn;

import com.google.common.base.Predicate;

/**
 * 申込商品テーブル用 Predicate<br/>
 * 商品コード（一致）
 */
public class FilterMosSyouhnBySyouhncd implements Predicate<HT_MosSyouhn> {

    String syouhncd;

    public FilterMosSyouhnBySyouhncd(String pSyouhncd) {
        super();
        syouhncd = pSyouhncd;
    }

    @Override
    public boolean apply(HT_MosSyouhn pHT_MosSyouhn) {

        if (syouhncd.equals(pHT_MosSyouhn.getSyouhncd())) {
            return true;
        }

        return false;
    }
}
