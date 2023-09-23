package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用Predicateクラス１
 *
 */
public class FilterNyknJissekiRireki1 implements Predicate<IT_NyknJissekiRireki> {

    C_Hrkkaisuu hrkkaisuu;

    public FilterNyknJissekiRireki1(C_Hrkkaisuu pHrkkaisuu) {
        super();
        hrkkaisuu = pHrkkaisuu;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if (C_Nyktrksflg.BLNK.eq(pNyknJissekiRireki.getNyktrksflg())) {
            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                if (C_Hrkkaisuu.TUKI.eq(pNyknJissekiRireki.getHrkkaisuu())) {
                    return true;
                }
            }
            else {
                if (C_Hrkkaisuu.NEN.eq(pNyknJissekiRireki.getHrkkaisuu())
                    ||
                    C_Hrkkaisuu.HALFY.eq(pNyknJissekiRireki.getHrkkaisuu())) {
                    return true;
                }
            }
        }
        return false;
    }
}