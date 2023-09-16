package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_ImagegazoukaKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.meta.QAM_SyoruiZokusei;
import yuyu.def.db.meta.QBM_TorikomiSyoruiHukaInfo;

/**
 * 取込書類付加情報マスタ(BM_TorikomiSyoruiHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TorikomiSyoruiHukaInfoDao extends AbstractDao<BM_TorikomiSyoruiHukaInfo> {

    public BM_TorikomiSyoruiHukaInfoDao() {
        super(BM_TorikomiSyoruiHukaInfo.class);
    }

    public BM_TorikomiSyoruiHukaInfo getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd){
        BM_TorikomiSyoruiHukaInfo bM_TorikomiSyoruiHukaInfo =  new BM_TorikomiSyoruiHukaInfo();
        bM_TorikomiSyoruiHukaInfo.setSyoruiCd(pSyoruiCd);
        return this.selectOne(bM_TorikomiSyoruiHukaInfo);
    }

    public List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(
        String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn, C_UmuKbn pQrsealumukbn,
        C_SkeijimuKbn... pSkeijimukbn) {


        QBM_TorikomiSyoruiHukaInfo qBM_TorikomiSyoruiHukaInfo = new QBM_TorikomiSyoruiHukaInfo();


        String queryStr = $SELECT + qBM_TorikomiSyoruiHukaInfo +
            $FROM + qBM_TorikomiSyoruiHukaInfo.BM_TorikomiSyoruiHukaInfo() +
            $WHERE + qBM_TorikomiSyoruiHukaInfo.subSystemId.eq(pSubSystemId) +
            $AND + qBM_TorikomiSyoruiHukaInfo.syoruitorikomihoukbn.eq(pSyoruitorikomihoukbn) +
            $AND + qBM_TorikomiSyoruiHukaInfo.skeijimukbn.in(pSkeijimukbn) +
            $AND + qBM_TorikomiSyoruiHukaInfo.qrsealumukbn.eq(pQrsealumukbn) +
            $ORDER_BY(qBM_TorikomiSyoruiHukaInfo.sortNo.asc());

        return em.createJPQL(queryStr).bind(qBM_TorikomiSyoruiHukaInfo).getResultList();
    }

    public Object[] getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn pSyoruiCd) {


        QBM_TorikomiSyoruiHukaInfo qBM_TorikomiSyoruiHukaInfo = new QBM_TorikomiSyoruiHukaInfo();
        QAM_SyoruiZokusei qAM_SyoruiZokusei = new QAM_SyoruiZokusei();


        String strSql = $SELECT + qBM_TorikomiSyoruiHukaInfo + "," +
            qAM_SyoruiZokusei +
            $FROM + qBM_TorikomiSyoruiHukaInfo.BM_TorikomiSyoruiHukaInfo() + "," +
            qAM_SyoruiZokusei.AM_SyoruiZokusei() +
            $WHERE + qBM_TorikomiSyoruiHukaInfo.syoruiCd.eq(pSyoruiCd) +
            $AND + qBM_TorikomiSyoruiHukaInfo.syoruiCd.eq(qAM_SyoruiZokusei.syoruiCd);


        return em.createJPQL(strSql)
            .bind(qBM_TorikomiSyoruiHukaInfo, qAM_SyoruiZokusei).getSingleResult();
    }

    public List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(
        String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn) {

        BM_TorikomiSyoruiHukaInfo bM_TorikomiSyoruiHukaInfo =  new BM_TorikomiSyoruiHukaInfo();
        bM_TorikomiSyoruiHukaInfo.setSubSystemId(pSubSystemId);
        bM_TorikomiSyoruiHukaInfo.setSyoruitorikomihoukbn(pSyoruitorikomihoukbn);
        return this.select(bM_TorikomiSyoruiHukaInfo);
    }

    public List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosByImagegazoukaKbn(
        C_ImagegazoukaKbn pImagegazoukakbn) {

        BM_TorikomiSyoruiHukaInfo bM_TorikomiSyoruiHukaInfo =  new BM_TorikomiSyoruiHukaInfo();
        bM_TorikomiSyoruiHukaInfo.setImagegazoukakbn(pImagegazoukakbn);
        return this.select(bM_TorikomiSyoruiHukaInfo);
    }
}
