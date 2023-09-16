package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.meta.QAS_Category;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QBT_KinouHukaInfo;

/**
 * 機能付加情報テーブル(BT_KinouHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_KinouHukaInfoDao extends AbstractDao<BT_KinouHukaInfo> {

    public BT_KinouHukaInfoDao() {
        super(BT_KinouHukaInfo.class);
    }

    public BT_KinouHukaInfo getKinouHukaInfo(String pKinouId){
        BT_KinouHukaInfo bT_KinouHukaInfo =  new BT_KinouHukaInfo();
        bT_KinouHukaInfo.setKinouId(pKinouId);
        return this.selectOne(bT_KinouHukaInfo);
    }


    public List<AS_Kinou> getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn pTjttrkskahi, String pSubSystemId) {


        QBT_KinouHukaInfo KinouHukaInfo = new QBT_KinouHukaInfo();


        QAS_Category category = new QAS_Category();


        QAS_Kinou kinou = new QAS_Kinou();

        String querySql = $SELECT  + kinou +
            $FROM + KinouHukaInfo.BT_KinouHukaInfo() + "," +
            category.AS_Category() + "," +
            kinou.AS_Kinou() +
            $WHERE + kinou.kinouId.eq(KinouHukaInfo.kinouId) +
            $AND + KinouHukaInfo.tjttrkskahi.eq(pTjttrkskahi) +
            $AND + kinou.subSystemId.eq(category.subSystemId) +
            $AND + kinou.categoryId.eq(category.categoryId) +
            $AND + category.subSystemId.eq(pSubSystemId) +
            $ORDER_BY(category.sortNo.asc(),
                kinou.sortNo.asc());

        return em.createJPQL(querySql).bind(KinouHukaInfo, category, kinou).getResultList();
    }
}
