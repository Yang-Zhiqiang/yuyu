package yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約 入金 入金／返金状況確認の機能DAOクラスです。
 */
public class SkNyuukinHenkinKakuninDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<NyuukinNyuuryokuInfoBean> getNyuukinNyuuryokuInfo(BizDate pNyksyoriymd) {

        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData("qHT_SkDenpyoData");
        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");

        String strSql = $SELECT + $NEW(NyuukinNyuuryokuInfoBean.class,
            qHT_Nyuukin.mosno,
            qHT_MosKihon.kykkbn,
            qHT_MosKihon.hhknnmkn,
            qHT_MosKihon.kyknmkn,
            qHT_MosKihon.kyktuukasyu,
            qHT_Nyuukin.nyknsyubetu,
            qHT_Nyuukin.ryosyuymd,
            qHT_Nyuukin.rsgaku.getTypeFieldName(),
            qHT_Nyuukin.rsgaku.getValueFieldName(),
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            qHT_SkDenpyoData.denyenkagk.getValueFieldName(),
            qHT_SkDenpyoData.fstpryosyuymd,
            qHT_SkDenpyoData.denkawaserate,
            qHT_Nyuukin.nyuukinsyoritime,
            qHT_Nyuukin.rstuukasyu,
            qHT_SyoriCTL.seiritukbn) +
            $FROM(qHT_Nyuukin,
                qHT_MosKihon,
                qHT_SkDenpyoData,
                qHT_SyoriCTL) +
                $WHERE + qHT_Nyuukin.nyksyoriymd.eq(pNyksyoriymd) +
                $AND + qHT_Nyuukin.nyuukinhenkinsyorikbn.eq(C_NyuukinHenkinSyoriKbn.NYUUKIN) +
                $AND + qHT_Nyuukin.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_Nyuukin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
                $AND + qHT_Nyuukin.edano.eq(qHT_SkDenpyoData.edano) +
                $AND + qHT_Nyuukin.mosno.eq(qHT_SyoriCTL.mosno) +
                $ORDER_BY(qHT_Nyuukin.nyuukinsyoritime.asc());

        return exDBEntityManager.createJPQL(strSql, NyuukinNyuuryokuInfoBean.class).bind(
            qHT_Nyuukin,qHT_MosKihon,qHT_SkDenpyoData,qHT_SyoriCTL).getResultList();
    }

    public List<HenkinNyuuryokuInfoBean> getHenkinNyuuryokuInfo(BizDate pHnknsyoriymd) {

        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData("qHT_SkDenpyoData");
        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");

        String strSql = $SELECT + $NEW(HenkinNyuuryokuInfoBean.class,
            qHT_Henkin.mosno,
            qHT_MosKihon.kykkbn,
            qHT_MosKihon.hhknnmkn,
            qHT_MosKihon.kyknmkn,
            qHT_MosKihon.kyktuukasyu,
            qHT_Henkin.hnknhoukbn,
            qHT_Henkin.hnkngk.getTypeFieldName(),
            $SUM + $(qHT_Henkin.hnkngk.getValueFieldName()),
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName()),
            qHT_SkDenpyoData.fstpryosyuymd,
            qHT_SkDenpyoData.denkawaserate,
            qHT_Henkin.henkinsyoritime,
            qHT_Henkin.hnkntuukasyu,
            qHT_SyoriCTL.seiritukbn) +
            $FROM(qHT_Henkin,
                qHT_MosKihon,
                qHT_SkDenpyoData,
                qHT_SyoriCTL) +
                $WHERE + qHT_Henkin.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_Henkin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
                $AND + qHT_Henkin.edano.eq(qHT_SkDenpyoData.edano) +
                $AND + qHT_Henkin.hnknsyoriymd.eq(pHnknsyoriymd) +
                $AND + qHT_Henkin.mosno.eq(qHT_SyoriCTL.mosno) +

                $GROUP_BY + qHT_Henkin.mosno + "," +
                qHT_Henkin.hnkninputrenno + "," +
                qHT_Henkin.hnknhoukbn + "," +
                qHT_MosKihon.kykkbn + "," +
                qHT_MosKihon.hhknnmkn + "," +
                qHT_MosKihon.kyknmkn + "," +
                qHT_MosKihon.kyktuukasyu + "," +
                qHT_SkDenpyoData.fstpryosyuymd + "," +
                qHT_SkDenpyoData.denkawaserate + "," +
                qHT_Henkin.hnkngk.getTypeFieldName() + "," +
                qHT_SkDenpyoData.denyenkagk.getTypeFieldName() + "," +
                qHT_Henkin.henkinsyoritime + "," +
                qHT_Henkin.hnkntuukasyu + "," +
                qHT_SyoriCTL.seiritukbn +
                $ORDER_BY(qHT_Henkin.henkinsyoritime.asc());

        return exDBEntityManager.createJPQL(strSql, HenkinNyuuryokuInfoBean.class).bind(
            qHT_Henkin,qHT_MosKihon,qHT_SkDenpyoData,qHT_SyoriCTL).getResultList();

    }
}
