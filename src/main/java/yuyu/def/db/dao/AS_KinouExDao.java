package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.meta.QAS_Category;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QBT_KinouHukaInfo;

/**
 * 機能基幹テーブル ( AS_Kinou ) アクセス用の DAO クラスです。
 */
public class AS_KinouExDao extends AbstractDao<AS_Kinou> {

    protected AS_KinouExDao() {
        super(AS_Kinou.class);
    }

    public AS_Kinou getAS_Kinou(String pKinouId) {
        AS_Kinou condEntity = new AS_Kinou();
        condEntity.setKinouId(pKinouId);
        return selectOne(condEntity);
    }

    public List<AS_Kinou> getKinousByTjttrkskahiSubSystemId(C_KahiKbn pTjttrkskahi, String pSubSystemId) {

        QAS_Kinou qAS_Kinou = new QAS_Kinou();


        QBT_KinouHukaInfo qBT_KinouHukaInfo = new QBT_KinouHukaInfo();


        QAS_Category qAS_Category = new QAS_Category();

        String queryStr = $SELECT + qAS_Kinou +
            $FROM + qAS_Kinou.AS_Kinou() + "," +
            qBT_KinouHukaInfo.BT_KinouHukaInfo() + "," +
            qAS_Category.AS_Category() +
            $WHERE + qAS_Kinou.subSystemId.eq(qAS_Category.subSystemId) +
            $AND + qAS_Kinou.categoryId.eq(qAS_Category.categoryId) +
            $AND + qAS_Kinou.kinouId.eq(qBT_KinouHukaInfo.kinouId) +
            $AND + qBT_KinouHukaInfo.tjttrkskahi.eq(pTjttrkskahi) +
            $AND + qAS_Kinou.subSystemId.eq(pSubSystemId) +
            $ORDER_BY(qAS_Category.sortNo.asc(),
                qAS_Kinou.sortNo.asc());

        return em.createJPQL(queryStr).bind(qAS_Kinou, qBT_KinouHukaInfo, qAS_Category).getResultList();
    }

}
