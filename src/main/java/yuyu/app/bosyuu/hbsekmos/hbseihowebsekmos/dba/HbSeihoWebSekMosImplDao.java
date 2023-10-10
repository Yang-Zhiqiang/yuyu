package yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.meta.QBM_ZennouRiritu2;

/**
 * 保険募集 設計書申込書作成 生保Ｗｅｂ設計書申込書作成DAOクラス
 */
public class HbSeihoWebSekMosImplDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_ZennouRiritu2> getZennouRiritu2(C_Tuukasyu pTuukasyu, BizDate pKijyunymd) {

        QBM_ZennouRiritu2 qBM_ZennouRiritu2 = new QBM_ZennouRiritu2("qBM_ZennouRiritu2");

        String query = $SELECT + qBM_ZennouRiritu2 +
            $FROM(qBM_ZennouRiritu2) +
            $WHERE + qBM_ZennouRiritu2.tuukasyu.eq(pTuukasyu) +
            $AND +   qBM_ZennouRiritu2.zennoutkybr1.eq("") +
            $AND +   qBM_ZennouRiritu2.zennoutkybr2.eq("") +
            $AND +   qBM_ZennouRiritu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouRiritu2.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouRiritu2.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(query).bind(qBM_ZennouRiritu2).getResultList();
    }

}
