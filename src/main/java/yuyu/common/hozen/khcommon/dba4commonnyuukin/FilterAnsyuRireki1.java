package yuyu.common.hozen.khcommon.dba4commonnyuukin;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用Predicateクラス１
 */
public class FilterAnsyuRireki1 implements Predicate<IT_AnsyuRireki> {

    C_NyknaiyouKbn nyknaiyouKbn;

    BizDateYM jyuutouym;

    Integer annaino;

    public FilterAnsyuRireki1(C_NyknaiyouKbn pNyknaiyouKbn, BizDateYM pJyuutouym, Integer pAnnaino) {
        super();
        nyknaiyouKbn = pNyknaiyouKbn;
        jyuutouym = pJyuutouym;
        annaino = pAnnaino;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {
        if (nyknaiyouKbn.eq(pAnsyuRireki.getNyknaiyoukbn()) &&
            BizDateUtil.compareYm(jyuutouym, pAnsyuRireki.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL &&
            pAnsyuRireki.getAnnaino().equals(annaino)) {
            return true;
        }
        return false;
    }
}
