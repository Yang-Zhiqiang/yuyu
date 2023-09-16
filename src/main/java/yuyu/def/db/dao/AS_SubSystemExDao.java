package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.meta.QAS_SubSystem;
import yuyu.def.db.meta.QBM_SyoruiZokuseiHukaInfo;

/**
 * サブシステム基幹テーブル ( AS_SubSystem ) アクセス用の DAO クラスです。
 */
public class AS_SubSystemExDao extends AbstractDao<AS_SubSystem> {

    public static final String IWF = "iwf";

    protected AS_SubSystemExDao() {
        super(AS_SubSystem.class);
    }

    public AS_SubSystem getAS_SubSystem(String pSubSystemId) {
        AS_SubSystem condEntity = new AS_SubSystem();
        condEntity.setSubSystemId(pSubSystemId);
        return selectOne(condEntity);
    }

    public List<AS_SubSystem> getSubSystemsBySubSystemIds(String[] pSubSystemId) {


        QAS_SubSystem qAS_SubSystem = new QAS_SubSystem("q1");


        QBM_SyoruiZokuseiHukaInfo qBM_SyoruiZokuseiHukaInfo = new QBM_SyoruiZokuseiHukaInfo("q2");

        String queryStr = $SELECT + qBM_SyoruiZokuseiHukaInfo.subSystemId +
                $FROM + qBM_SyoruiZokuseiHukaInfo.BM_SyoruiZokuseiHukaInfo() +
                $WHERE + qBM_SyoruiZokuseiHukaInfo.subSystemId.eq(qAS_SubSystem.subSystemId) +
                $AND + qBM_SyoruiZokuseiHukaInfo.subSystemId.notIn(pSubSystemId) +
                $AND + qBM_SyoruiZokuseiHukaInfo.subSystemId.ne(IWF) +
                $AND + qBM_SyoruiZokuseiHukaInfo.tyouhyououtkinousiyouumu.eq(C_UmuKbn.ARI) ;

        String mainStr = $SELECT + qAS_SubSystem +
                $FROM + qAS_SubSystem.AS_SubSystem() +
                $WHERE + $EXISTS(queryStr) +
                $ORDER_BY(qAS_SubSystem.sortNo.asc());

        return em.createJPQL(mainStr).bind(qAS_SubSystem, qBM_SyoruiZokuseiHukaInfo).getResultList();
    }

}