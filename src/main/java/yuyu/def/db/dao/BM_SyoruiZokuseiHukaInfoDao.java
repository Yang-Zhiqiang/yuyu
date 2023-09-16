package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.QAM_SyoruiZokusei;
import yuyu.def.db.meta.QAS_SubSystem;
import yuyu.def.db.meta.QBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.QBT_TyouhyouOutputKengen;

/**
 * 書類属性付加情報マスタ(BM_SyoruiZokuseiHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyoruiZokuseiHukaInfoDao extends AbstractDao<BM_SyoruiZokuseiHukaInfo> {

    public BM_SyoruiZokuseiHukaInfoDao() {
        super(BM_SyoruiZokuseiHukaInfo.class);
    }

    public BM_SyoruiZokuseiHukaInfo getSyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd){
        BM_SyoruiZokuseiHukaInfo bM_SyoruiZokuseiHukaInfo =  new BM_SyoruiZokuseiHukaInfo();
        bM_SyoruiZokuseiHukaInfo.setSyoruiCd(pSyoruiCd);
        return this.selectOne(bM_SyoruiZokuseiHukaInfo);
    }

    public List<Object[]> getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(String[] pRoleCd, String[] pSubSystemId) {


        QAM_SyoruiZokusei qAM_SyoruiZokusei = new QAM_SyoruiZokusei();

        QAS_SubSystem qAS_SubSystem = new QAS_SubSystem();

        QBT_TyouhyouOutputKengen qBT_TyouhyouOutputKengen = new QBT_TyouhyouOutputKengen();

        QBM_SyoruiZokuseiHukaInfo qBM_SyoruiZokuseiHukaInfo = new QBM_SyoruiZokuseiHukaInfo();

        String subQuerStr = "";
        for(String subSystemId : pSubSystemId) {


            subQuerStr = subQuerStr + $AND + qBM_SyoruiZokuseiHukaInfo.subSystemId.ne(subSystemId);
        }

        String queryStr = $SELECT + qAM_SyoruiZokusei.syoruiCd + "," +
            qAM_SyoruiZokusei.syoruinm + "," +
            qBM_SyoruiZokuseiHukaInfo.subSystemId + "," +
            qAS_SubSystem.subSystemNm + "," +
            qAM_SyoruiZokusei.kensakuKey1 + "," +
            qAM_SyoruiZokusei.kensakuKey2 + "," +
            qAM_SyoruiZokusei.kensakuKey3 + "," +
            qAM_SyoruiZokusei.kensakuKey4 + "," +
            qAM_SyoruiZokusei.kensakuKey5 + "," +
            qAM_SyoruiZokusei.sortNo + $AS + "syoruiZokuseiSortNo" + "," +
            qAS_SubSystem.sortNo + $AS + "subSystemSortNo" +
            $FROM + qAM_SyoruiZokusei.AM_SyoruiZokusei() + "," +
            qAS_SubSystem.AS_SubSystem() + "," +
            qBT_TyouhyouOutputKengen.BT_TyouhyouOutputKengen() + "," +
            qBM_SyoruiZokuseiHukaInfo.BM_SyoruiZokuseiHukaInfo() +
            $WHERE + qBM_SyoruiZokuseiHukaInfo.subSystemId.eq(qAS_SubSystem.subSystemId) +
            $AND + qAM_SyoruiZokusei.syoruiCd.eq(qBM_SyoruiZokuseiHukaInfo.syoruiCd) +
            subQuerStr +
            $AND + qAM_SyoruiZokusei.syoruiCd.eq(qBT_TyouhyouOutputKengen.syoruiCd) +
            $AND + qBT_TyouhyouOutputKengen.roleCd.in(pRoleCd) +
            $AND + qBT_TyouhyouOutputKengen.kobetuoutputkahikbn.eq(C_KahiKbn.KA) +
            $ORDER_BY(qAS_SubSystem.sortNo.asc(),
                qAM_SyoruiZokusei.sortNo.asc());

        return em.createJPQL(queryStr).bind(qAM_SyoruiZokusei, qAS_SubSystem, qBT_TyouhyouOutputKengen, qBM_SyoruiZokuseiHukaInfo).getResultList();

    }

    public List<BM_SyoruiZokuseiHukaInfo> getSyoruiZokuseiHukaInfosBySubSystemIds(String[] pSubSystemId) {


        QAS_SubSystem qAS_SubSystem = new QAS_SubSystem("q1");


        QBM_SyoruiZokuseiHukaInfo qBM_SyoruiZokuseiHukaInfo = new QBM_SyoruiZokuseiHukaInfo("q2");


        QAM_SyoruiZokusei qAM_SyoruiZokusei = new QAM_SyoruiZokusei("q3");





        String whereQuery = "";




























        whereQuery = qBM_SyoruiZokuseiHukaInfo.subSystemId.in(pSubSystemId);
        whereQuery = whereQuery + $AND;

        String queryStr = $SELECT + qBM_SyoruiZokuseiHukaInfo +
            $FROM + qAM_SyoruiZokusei.AM_SyoruiZokusei() + "," +
            qAS_SubSystem.AS_SubSystem() + "," +
            qBM_SyoruiZokuseiHukaInfo.BM_SyoruiZokuseiHukaInfo() +


            $WHERE + whereQuery +
            qBM_SyoruiZokuseiHukaInfo.subSystemId.eq(qAS_SubSystem.subSystemId) +
            $AND + qBM_SyoruiZokuseiHukaInfo.syoruiCd.eq(qAM_SyoruiZokusei.syoruiCd) +
            $AND + qBM_SyoruiZokuseiHukaInfo.tyouhyououtkinousiyouumu.eq(C_UmuKbn.ARI) +
            $ORDER_BY(qAS_SubSystem.sortNo.asc(),
                qAM_SyoruiZokusei.sortNo.asc());



        return em.createJPQL(queryStr).bind(qAS_SubSystem, qBM_SyoruiZokuseiHukaInfo,
            qAM_SyoruiZokusei).getResultList();
    }
}
