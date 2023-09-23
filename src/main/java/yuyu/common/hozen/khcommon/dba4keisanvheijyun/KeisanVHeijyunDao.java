package yuyu.common.hozen.khcommon.dba4keisanvheijyun;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.BM_SibouRitu;
import yuyu.def.db.meta.QBM_SibouRitu;

/**
 * 契約保全 契約保全共通 平準払用保険料積立金計算機能ＤＡＯ
 */
public class KeisanVHeijyunDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_SibouRitu> getSibouRitu(String pRyouritusdno, C_Seibetu pSei, int pStartnen, int pEndnen) {

        QBM_SibouRitu qBM_SibouRitu = new QBM_SibouRitu("qBM_SibouRitu");
        String strSql = $SELECT + qBM_SibouRitu +
            $FROM(qBM_SibouRitu) +
            $WHERE + qBM_SibouRitu.ryouritusdno.eq(pRyouritusdno) +
            $AND + qBM_SibouRitu.seibetu.eq(pSei) +
            $AND + qBM_SibouRitu.nenrei.ge(pStartnen) +
            $AND + qBM_SibouRitu.nenrei.le(pEndnen) +
            $ORDER_BY(qBM_SibouRitu.nenrei);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_SibouRitu).getResultList();
    }
}
