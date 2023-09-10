package yuyu.def.siharai.predicate;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;

import com.google.common.base.Predicate;

/**
 * 死亡仮受付テーブル用 Predicate<br/>
 * 取消フラグ（一致）
 */
public class FilterSibouKariuketsukeByTorikesiflg implements Predicate<JT_SibouKariuketsuke> {

    C_UmuKbn torikesiflg;

    public FilterSibouKariuketsukeByTorikesiflg(C_UmuKbn pTorikesiflg) {

        super();

        torikesiflg = pTorikesiflg;
    }

    @Override
    public boolean apply(JT_SibouKariuketsuke pSibouKariuketsuke) {

        if (torikesiflg.eq(pSibouKariuketsuke.getTorikesiflg())) {

            return true;
        }
        return false;
    }
}
