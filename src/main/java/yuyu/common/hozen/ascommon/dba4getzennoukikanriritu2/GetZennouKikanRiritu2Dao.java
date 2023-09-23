package yuyu.common.hozen.ascommon.dba4getzennoukikanriritu2;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu2;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 前納期間利率取得処理２DAOクラス
 */
public class GetZennouKikanRiritu2Dao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_ZennouTumitateRitu2> getZennouTumitateRitu2s(C_Tuukasyu pTuukasyu, BizDate pKijyunymd) {

        QBM_ZennouTumitateRitu2 qBM_ZennouTumitateRitu2 = new QBM_ZennouTumitateRitu2("qBM_ZennouTumitateRitu2");

        String query = $SELECT + qBM_ZennouTumitateRitu2 +
            $FROM(qBM_ZennouTumitateRitu2) +
            $WHERE + qBM_ZennouTumitateRitu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouTumitateRitu2.zennoutkybr1.eq("") +
            $AND + qBM_ZennouTumitateRitu2.zennoutkybr2.eq("") +
            $AND + qBM_ZennouTumitateRitu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouTumitateRitu2.tekiyoukknfrom.le(String.valueOf(pKijyunymd)) +
            $AND + qBM_ZennouTumitateRitu2.tekiyoukknkto.ge(String.valueOf(pKijyunymd)) ;

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouTumitateRitu2).getResultList();
    }
}
