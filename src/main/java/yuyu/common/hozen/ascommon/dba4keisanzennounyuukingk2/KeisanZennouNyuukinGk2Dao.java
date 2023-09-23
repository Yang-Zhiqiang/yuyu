package yuyu.common.hozen.ascommon.dba4keisanzennounyuukingk2;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu2;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu2;

/**
 * 前納入金額計算２機能DAOクラスです
 */
public class KeisanZennouNyuukinGk2Dao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_ZennouKeikaRiritu2 getZennouKeikaRiritu2(C_Tuukasyu pTuukasyu, Integer pKeikatukisuu, BizDate pKijyunymd) {

        QBM_ZennouKeikaRiritu2 qBM_ZennouKeikaRiritu2 = new QBM_ZennouKeikaRiritu2("t1");

        String query = $SELECT + qBM_ZennouKeikaRiritu2 +
            $FROM(qBM_ZennouKeikaRiritu2) +
            $WHERE + qBM_ZennouKeikaRiritu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouKeikaRiritu2.zennoutkybr1.eq("") +
            $AND + qBM_ZennouKeikaRiritu2.zennoutkybr2.eq("") +
            $AND + qBM_ZennouKeikaRiritu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouKeikaRiritu2.keikatukisuu.eq(pKeikatukisuu) +
            $AND + qBM_ZennouKeikaRiritu2.tekiyoukknfrom.le(String.valueOf(pKijyunymd)) +
            $AND + qBM_ZennouKeikaRiritu2.tekiyoukknkto.ge(String.valueOf(pKijyunymd));

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouKeikaRiritu2).getSingleResult();
    }

    public BM_ZennouGenkaRitu2 getZennouGenkaRitu2(C_Tuukasyu pTuukasyu, Integer pZennounensuu, BizDate pKijyunymd) {

        QBM_ZennouGenkaRitu2 qBM_ZennouGenkaRitu2 = new QBM_ZennouGenkaRitu2("t1");

        String query = $SELECT + qBM_ZennouGenkaRitu2 +
            $FROM(qBM_ZennouGenkaRitu2) +
            $WHERE + qBM_ZennouGenkaRitu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouGenkaRitu2.zennoutkybr1.eq("") +
            $AND + qBM_ZennouGenkaRitu2.zennoutkybr2.eq("") +
            $AND + qBM_ZennouGenkaRitu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouGenkaRitu2.zennounensuu.eq(pZennounensuu) +
            $AND + qBM_ZennouGenkaRitu2.tekiyoukknfrom.le(String.valueOf(pKijyunymd)) +
            $AND + qBM_ZennouGenkaRitu2.tekiyoukknkto.ge(String.valueOf(pKijyunymd));

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouGenkaRitu2).getSingleResult();
    }
}
