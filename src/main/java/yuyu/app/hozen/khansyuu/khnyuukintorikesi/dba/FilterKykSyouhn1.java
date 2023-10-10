package yuyu.app.hozen.khansyuu.khnyuukintorikesi.dba;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用 Predicate<br/>
 * 主契約特約区分（一致）<br/>
 */
public class FilterKykSyouhn1 implements Predicate<IT_KykSyouhn> {

    C_SyutkKbn syutkkbn;
    C_YuukousyoumetuKbn yuukousyoumetuKbn;
    C_Kykjyoutai kykjyoutai;
    C_Kykjyoutai kykjyoutai2;

    public FilterKykSyouhn1 (C_SyutkKbn pSyutkkbn,
        C_YuukousyoumetuKbn pYuukousyoumetuKbn, C_Kykjyoutai pKykjyoutai, C_Kykjyoutai pKykjyoutai2) {
        super();
        syutkkbn = pSyutkkbn;
        yuukousyoumetuKbn = pYuukousyoumetuKbn;
        kykjyoutai = pKykjyoutai;
        kykjyoutai2 = pKykjyoutai2;
    }

    @Override
    public boolean apply (IT_KykSyouhn kykSyouhn) {
        if (syutkkbn.eq(kykSyouhn.getSyutkkbn()) && yuukousyoumetuKbn.eq(kykSyouhn.getYuukousyoumetukbn())
            && (kykjyoutai.eq(kykSyouhn.getKykjyoutai()) || kykjyoutai2.eq(kykSyouhn.getKykjyoutai()))) {
            return true;
        }
        return false;
    }
}