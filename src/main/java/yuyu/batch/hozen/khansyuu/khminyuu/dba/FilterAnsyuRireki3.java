package yuyu.batch.hozen.khansyuu.khminyuu.dba;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用Predicateクラス３<br/>
 */
public class FilterAnsyuRireki3 implements Predicate<IT_AnsyuRireki> {

    private C_NyknaiyouKbn nyknaiyoukbn;
    private C_Nykkeiro nykkeiro;
    private BizDate uriageymdkon;
    private C_AnnaijkKbn annaijkKbn;

    public FilterAnsyuRireki3(C_NyknaiyouKbn pNyknaiyoukbn, C_Nykkeiro pNykkeiro, BizDate pUriageymdkon,
        C_AnnaijkKbn pAnnaijkKbn) {
        super();
        nyknaiyoukbn = pNyknaiyoukbn;
        nykkeiro = pNykkeiro;
        uriageymdkon = pUriageymdkon;
        annaijkKbn = pAnnaijkKbn;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {
        if (nyknaiyoukbn.eq(pAnsyuRireki.getNyknaiyoukbn()) &&
            nykkeiro.eq(pAnsyuRireki.getNykkeiro()) &&
            BizDateUtil.compareYmd(uriageymdkon, pAnsyuRireki.getUriageymdkon()) == BizDateUtil.COMPARE_EQUAL &&
            annaijkKbn.eq(pAnsyuRireki.getAnnaijkkbn())) {
            return true;
        }
        return false;
    }
}
