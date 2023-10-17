package yuyu.batch.biz.bzunyo.bztestdataexport.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBM_TestSyonokanri;
import yuyu.def.db.meta.QBT_TestKykData;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QMT_DsNeugokiHanteiKekka;

/**
 * 業務共通 運用 テスト用データ抽出機能DAOクラス
 */
public class BzTestDataExportDao {

    @Inject
    ExDBEntityManager exDBEntityManager;


    public void deleteTestKykData() {

        QBT_TestKykData qBT_TestKykData = new QBT_TestKykData("qBT_TestKykData");

        String strSql = $DELETE_FROM(qBT_TestKykData);

        exDBEntityManager.createJPQL(strSql).bind(qBT_TestKykData).executeUpdate();
    }

    public List<String> getHozenSyonos() {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String subQuery = $SELECT + qIT_KhTtdkRireki.syono +
            $FROM(qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KhTtdkRireki.syono.eq(qIT_KykSyouhn.syono) +
            $GROUP_BY + qIT_KhTtdkRireki.syono +
            $HAVING + $COUNT(qIT_KhTtdkRireki.syono) + $EQ + "1";

        String strSql = $SELECT + $MIN(qIT_KykKihon.syono) +
            $FROM(qIT_KykKihon, qIT_KykSyouhn) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + $EXISTS(subQuery) +
            $GROUP_BY + qIT_KykSyouhn.syouhncd;

        List<String> resultList = exDBEntityManager.createJPQL(strSql)
            .bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KhTtdkRireki).getResultList();

        if (resultList != null && resultList.size() > 30) {
            return resultList.subList(0, 30);
        }
        return resultList;

    }

    public List<String> getDirectSyonos1() {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String strSql = $SELECT + $MAX(qIT_KykSyouhn.syono) +
            $FROM(qIT_KykSyouhn
                ,qIT_KykKihon) +
                $WHERE + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.drctservicemoskbn.eq(C_DirectServiceMosKbn.NOENTRY) +
                $GROUP_BY + (qIT_KykSyouhn.syouhncd) +
                $ORDER_BY(qIT_KykSyouhn.syouhncd.asc());

        List<String> resultList = exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhn, qIT_KykKihon)
            .getResultList();

        if (resultList != null && resultList.size() > 30) {
            return resultList.subList(0, 30);
        }
        return resultList;
    }

    public List<String> getDirectSyonos2() {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String strSql = $SELECT + $MAX(qIT_KykSyouhn.syono) +
            $FROM(qIT_KykSyouhn
                ,qIT_KykKihon) +
                $WHERE + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.drctservicemoskbn.eq(C_DirectServiceMosKbn.ENTRY) +
                $GROUP_BY + (qIT_KykSyouhn.syouhncd) +
                $ORDER_BY(qIT_KykSyouhn.syouhncd.asc());

        List<String> resultList = exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhn, qIT_KykKihon)
            .getResultList();

        if (resultList != null && resultList.size() > 30) {
            return resultList.subList(0, 30);
        }
        return resultList;
    }


    public List<String> getDirectSyonos3() {

        QMT_DsNeugokiHanteiKekka qMT_DsNeugokiHanteiKekka = new QMT_DsNeugokiHanteiKekka("qMT_DsNeugokiHanteiKekka");

        String strSql = $SELECT + qMT_DsNeugokiHanteiKekka.syono +
            $FROM(qMT_DsNeugokiHanteiKekka) +
            $WHERE + qMT_DsNeugokiHanteiKekka.neugokihanteiumukbn.eq(C_UmuKbn.ARI) +
            $ORDER_BY(qMT_DsNeugokiHanteiKekka.dsdatasakuseiymd.desc());

        List<String> resultList = exDBEntityManager.createJPQL(strSql).bind(qMT_DsNeugokiHanteiKekka).getResultList();

        if (resultList != null && resultList.size() > 30) {
            return resultList.subList(0, 30);
        }
        return resultList;
    }

    public Integer getTestSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta, String pBosyuusosikicd) {

        QBM_TestSyonokanri qBM_TestSyonokanri = new QBM_TestSyonokanri("qBM_TestSyonokanri");

        String strSql = $SELECT + $MAX(qBM_TestSyonokanri.syonorenno) +
            $FROM (qBM_TestSyonokanri) +
            $WHERE + qBM_TestSyonokanri.seirekinen2keta.eq(pSeirekinen2keta) +
            $AND + qBM_TestSyonokanri.bosyuusosikicd.eq(pBosyuusosikicd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_TestSyonokanri).getSingleResult();
    }

    public void deleteTestSyoukenNoKanriBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta, String pBosyuusosikicd){

        QBM_TestSyonokanri qBM_TestSyonokanri = new QBM_TestSyonokanri();

        String strSql = $DELETE_FROM(qBM_TestSyonokanri) +
            $WHERE + qBM_TestSyonokanri.seirekinen2keta.eq(pSeirekinen2keta) +
            $AND + qBM_TestSyonokanri.bosyuusosikicd.eq(pBosyuusosikicd);

        exDBEntityManager.createJPQL(strSql).bind(qBM_TestSyonokanri).executeUpdate();
    }
}
