package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.HT_MosSyouhn;

import com.google.common.base.Predicate;

/**
 * 申込商品テーブル用 Predicate<br/>
 * 型区分（一致）
 */
public class FilterMosSyouhnByKatakbns implements Predicate<HT_MosSyouhn>{

    C_KataKbn[] katakbn;

    public FilterMosSyouhnByKatakbns(C_KataKbn... pKatakbn){
        super();
        katakbn = pKatakbn;
    }

    @Override
    public boolean apply(HT_MosSyouhn pMosSyouhn) {

        for(C_KataKbn kataKbn: katakbn) {

            if(kataKbn.eq(pMosSyouhn.getKatakbn())) {

                return true;
            }
        }

        return false;
    }

}
