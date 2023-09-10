package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosSyouhn;

import com.google.common.base.Predicate;

/**
 * 申込商品テーブル用 Predicate<br/>
 * がん保障日額有無（一致）
 */
public class FilterMosSyouhnByGanhsyngumu implements Predicate<HT_MosSyouhn>{

    C_UmuKbn ganhsyngumu;

    public FilterMosSyouhnByGanhsyngumu(C_UmuKbn pGanhsyngumu){
        super();
        ganhsyngumu = pGanhsyngumu;
    }

    @Override
    public boolean apply(HT_MosSyouhn pHtMosSyouhn) {

        if(pHtMosSyouhn.getSyouhnZokusei() != null) {

            if (ganhsyngumu.eq(pHtMosSyouhn.getSyouhnZokusei().getGanhsyngumu())){

                return true;
            }
        }
        return false;
    }
}
