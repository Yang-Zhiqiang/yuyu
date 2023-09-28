package yuyu.common.biz.bzcommon.dba4keisanazukariganrikin;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_AzukariRiritu;
import yuyu.def.db.meta.QBM_AzukariRiritu;

/**
 * 業務共通 業務共通 預り元利金計算の機能DAOクラス
 */
public class KeisanAzukariGanrikinDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_AzukariRiritu> getAzukariRirituByPK(
        C_Tuukasyu pTuukasyu,
        BizDate pTkyfromymd,
        BizDate pTkytoymd) {

        QBM_AzukariRiritu qBM_AzukariRiritu = new QBM_AzukariRiritu("qBM_AzukariRiritu");

        String strSql = $SELECT + qBM_AzukariRiritu +
            $FROM (qBM_AzukariRiritu) +
            $WHERE + qBM_AzukariRiritu.tuukasyu .eq(pTuukasyu) +
            $AND + qBM_AzukariRiritu.tkyfromymd.le(pTkytoymd) +
            $AND + qBM_AzukariRiritu.tkytoymd.ge(pTkyfromymd) +
            $ORDER_BY(qBM_AzukariRiritu.tkyfromymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_AzukariRiritu).getResultList();
    }
}
