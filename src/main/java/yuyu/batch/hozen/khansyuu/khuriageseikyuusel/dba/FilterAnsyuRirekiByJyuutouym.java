package yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用Predicateクラス
 */
public class FilterAnsyuRirekiByJyuutouym implements Predicate<IT_AnsyuRireki> {

    BizDateYM jyuutouym;

    public FilterAnsyuRirekiByJyuutouym(BizDateYM pJyuutouYm) {
        super();
        jyuutouym = pJyuutouYm;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {

        if (jyuutouym.equals(pAnsyuRireki.getJyuutouym())) {

            return true;
        }

        return false;
    }
}