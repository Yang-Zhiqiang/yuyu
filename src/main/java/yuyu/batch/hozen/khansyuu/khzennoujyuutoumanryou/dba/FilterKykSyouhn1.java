package yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykSyouhn;
import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用Predicateクラス１
 */
public class FilterKykSyouhn1 implements Predicate<IT_KykSyouhn> {

    C_SyutkKbn syutkkbn;

    C_YuukousyoumetuKbn yuukousyoumetukbn;

    C_Kykjyoutai kykjyoutai;

    public FilterKykSyouhn1(C_SyutkKbn pSyutkkbn, C_YuukousyoumetuKbn pYuukousyoumetukbn, C_Kykjyoutai pKykjyoutai) {
        super();
        syutkkbn = pSyutkkbn;
        yuukousyoumetukbn = pYuukousyoumetukbn;
        kykjyoutai = pKykjyoutai;
    }

    @Override
    public boolean apply(IT_KykSyouhn pKykSyouhn) {
        if (syutkkbn.eq(pKykSyouhn.getSyutkkbn()) &&
            yuukousyoumetukbn.eq(pKykSyouhn.getYuukousyoumetukbn()) &&
            kykjyoutai.eq(pKykSyouhn.getKykjyoutai())) {
            return true;
        }
        return false;
    }
}