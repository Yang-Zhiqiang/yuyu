package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブルエンティティ用 Predicate<br/>
 * 有効消滅区分 と 契約状態（一致）<br/>
 */
public class FilterKykSyouhnByYuukousyoumetukbnKykjyoutai implements Predicate<IT_KykSyouhn> {

    C_YuukousyoumetuKbn yuukousyoumetukbn;
    C_Kykjyoutai kykjyoutai;

    public FilterKykSyouhnByYuukousyoumetukbnKykjyoutai(C_YuukousyoumetuKbn pYuukousyoumetukbn,C_Kykjyoutai pKykjyoutai) {

        super();

        yuukousyoumetukbn = pYuukousyoumetukbn;
        kykjyoutai = pKykjyoutai;
    }

    @Override
    public boolean apply(IT_KykSyouhn pKykSyouhn) {

        if (yuukousyoumetukbn.eq(pKykSyouhn.getYuukousyoumetukbn()) &&
                kykjyoutai.eq(pKykSyouhn.getKykjyoutai())) {

            return true;
        }

        return false;
    }
}

