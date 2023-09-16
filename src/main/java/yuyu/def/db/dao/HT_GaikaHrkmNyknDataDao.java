package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.meta.QHT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.result.bean.GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean;

/**
 * 外貨振込入金データテーブル(HT_GaikaHrkmNyknDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_GaikaHrkmNyknDataDao extends AbstractDao<HT_GaikaHrkmNyknData> {

    public HT_GaikaHrkmNyknDataDao() {
        super(HT_GaikaHrkmNyknData.class);
    }

    public HT_GaikaHrkmNyknData getGaikaHrkmNyknData(C_DensysKbn pDensyskbn,
        BizDate pSyoriYmd,
        String pItirenno){
        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData =  new HT_GaikaHrkmNyknData();
        hT_GaikaHrkmNyknData.setDensyskbn(pDensyskbn);
        hT_GaikaHrkmNyknData.setSyoriYmd(pSyoriYmd);
        hT_GaikaHrkmNyknData.setItirenno(pItirenno);
        return this.selectOne(hT_GaikaHrkmNyknData);
    }

    public List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno,
        String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk) {


        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = new HT_GaikaHrkmNyknData();

        hT_GaikaHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hT_GaikaHrkmNyknData.setNykmosno(pMosno);
        hT_GaikaHrkmNyknData.setOyadrtencd(pOyadrtencd);
        hT_GaikaHrkmNyknData.setHrkmirninnm(pHrkmirninnm);
        hT_GaikaHrkmNyknData.setTrhkkgk(pTrhkkgk);


        return select(hT_GaikaHrkmNyknData);
    }

    public ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(BizDate pSyoriYmd, Integer pIribaraikbn) {


        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData();


        String strSql = $SELECT + qHT_GaikaHrkmNyknData +
            $FROM(qHT_GaikaHrkmNyknData) +
            $WHERE + qHT_GaikaHrkmNyknData.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_GaikaHrkmNyknData.iribaraikbn.eq(pIribaraikbn)+
            $ORDER_BY(qHT_GaikaHrkmNyknData.bankcd.asc(),
                qHT_GaikaHrkmNyknData.sitencd.asc());


        return em.createJPQL(strSql).bind(qHT_GaikaHrkmNyknData).getUpdatableResults();
    }

    public List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd,
        String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140, BizDate pSyoriYmd, Integer pIribaraikbn) {


        HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = new HT_GaikaHrkmNyknData();


        hT_GaikaHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hT_GaikaHrkmNyknData.setBankcd(pBankcd);
        hT_GaikaHrkmNyknData.setSitencd(pSitencd);
        hT_GaikaHrkmNyknData.setKouzano(pKouzano);
        hT_GaikaHrkmNyknData.setTrhkkgk(pTrhkkgk);
        hT_GaikaHrkmNyknData.setHrkmirninnm140(pHrkmirninnm140);
        hT_GaikaHrkmNyknData.setSyoriYmd(pSyoriYmd);
        hT_GaikaHrkmNyknData.setIribaraikbn(pIribaraikbn);


        return this.select(hT_GaikaHrkmNyknData);
    }

    public ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {


        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData();


        String strSql = $SELECT + qHT_GaikaHrkmNyknData +
            $FROM + qHT_GaikaHrkmNyknData.HT_GaikaHrkmNyknData() +
            $WHERE + qHT_GaikaHrkmNyknData.syorizumiflg.eq(pSyorizumiflg) +
            $ORDER_BY(qHT_GaikaHrkmNyknData.nykmosno.asc(),
                qHT_GaikaHrkmNyknData.syoriYmd.asc());


        return em.createJPQL(strSql).bind(qHT_GaikaHrkmNyknData).getUpdatableResults();
    }

    public ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdDengk() {


        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData();


        String strSql = $SELECT + qHT_GaikaHrkmNyknData +
            $FROM + qHT_GaikaHrkmNyknData.HT_GaikaHrkmNyknData() +
            $WHERE + qHT_GaikaHrkmNyknData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qHT_GaikaHrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $AND + $NOT + qHT_GaikaHrkmNyknData.dengk.neZero();


        return em.createJPQL(strSql).bind(qHT_GaikaHrkmNyknData).getUpdatableResults();
    }

    public List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean> getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(
        BizDate pSyoriYmd, BizDate pZengetuLastd, C_Tuukasyu pTuukasyu) {


        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData();


        String strWhere = qHT_GaikaHrkmNyknData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qHT_GaikaHrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI);
        if (pSyoriYmd != null) {

            strWhere += $AND;
            strWhere += qHT_GaikaHrkmNyknData.ksnymd.le(pSyoriYmd);
        }

        if (pZengetuLastd != null) {

            strWhere += $AND;
            strWhere += qHT_GaikaHrkmNyknData.ksnymd.gt(pZengetuLastd);
        }
        strWhere += $AND;
        strWhere += qHT_GaikaHrkmNyknData.tuukasyu.eq(pTuukasyu);


        String strSql = $SELECT + $NEW(GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean.class,
            qHT_GaikaHrkmNyknData.trhkkgk.getTypeFieldName(),
            $SUM + $(qHT_GaikaHrkmNyknData.trhkkgk.getValueFieldName()),
            qHT_GaikaHrkmNyknData.dengk.getTypeFieldName(),
            $SUM + $(qHT_GaikaHrkmNyknData.dengk.getValueFieldName()),
            $COUNT(qHT_GaikaHrkmNyknData.syoriYmd)) +
            $FROM + qHT_GaikaHrkmNyknData.HT_GaikaHrkmNyknData() +
            $WHERE + strWhere +
            $GROUP_BY + qHT_GaikaHrkmNyknData.trhkkgk.getTypeFieldName() + "," +
            qHT_GaikaHrkmNyknData.dengk.getTypeFieldName() +
            $ORDER_BY(qHT_GaikaHrkmNyknData.trhkkgk.typeAsc(),
                qHT_GaikaHrkmNyknData.dengk.typeAsc());


        return em.createJPQL(strSql, GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean.class).bind(qHT_GaikaHrkmNyknData).getResultList();
    }


    public List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(
        BizDate pKsnymd, C_Tuukasyu pTuukasyu) {


        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData();


        String strSql = $SELECT + $NEW(GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean.class,
            qHT_GaikaHrkmNyknData.trhkkgk.getTypeFieldName(),
            $SUM + $(qHT_GaikaHrkmNyknData.trhkkgk.getValueFieldName()),
            qHT_GaikaHrkmNyknData.dengk.getTypeFieldName(),
            $SUM + $(qHT_GaikaHrkmNyknData.dengk.getValueFieldName()),
            $COUNT(qHT_GaikaHrkmNyknData.syoriYmd)) +
            $FROM + qHT_GaikaHrkmNyknData.HT_GaikaHrkmNyknData() +
            $WHERE + qHT_GaikaHrkmNyknData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qHT_GaikaHrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $AND + qHT_GaikaHrkmNyknData.ksnymd.le(pKsnymd) +
            $AND + qHT_GaikaHrkmNyknData.tuukasyu.eq(pTuukasyu) +
            $GROUP_BY + qHT_GaikaHrkmNyknData.trhkkgk.getTypeFieldName() + "," +
            qHT_GaikaHrkmNyknData.dengk.getTypeFieldName() +
            $ORDER_BY(qHT_GaikaHrkmNyknData.trhkkgk.typeAsc(),
                qHT_GaikaHrkmNyknData.dengk.typeAsc());


        return em.createJPQL(strSql, GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean.class).bind(qHT_GaikaHrkmNyknData).getResultList();
    }

    public List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate pSyoriYmd,
        C_Tuukasyu pTuukasyu) {


        QHT_GaikaHrkmNyknData qHT_GaikaHrkmNyknData = new QHT_GaikaHrkmNyknData();


        String strSql = $SELECT + $NEW(GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean.class,
            qHT_GaikaHrkmNyknData.trhkkgk.getTypeFieldName(),
            $SUM + $(qHT_GaikaHrkmNyknData.trhkkgk.getValueFieldName()),
            qHT_GaikaHrkmNyknData.dengk.getTypeFieldName(),
            $SUM + $(qHT_GaikaHrkmNyknData.dengk.getValueFieldName()),
            $COUNT(qHT_GaikaHrkmNyknData.syoriYmd)) +
            $FROM + qHT_GaikaHrkmNyknData.HT_GaikaHrkmNyknData() +
            $WHERE + qHT_GaikaHrkmNyknData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qHT_GaikaHrkmNyknData.syoriYmd.eq(pSyoriYmd) +
            $AND +qHT_GaikaHrkmNyknData.tuukasyu.eq(pTuukasyu) +
            $GROUP_BY + qHT_GaikaHrkmNyknData.trhkkgk.getTypeFieldName() + "," +
            qHT_GaikaHrkmNyknData.dengk.getTypeFieldName() +
            $ORDER_BY(qHT_GaikaHrkmNyknData.trhkkgk.typeAsc(),
                qHT_GaikaHrkmNyknData.dengk.typeAsc());


        return em.createJPQL(strSql,GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean.class).bind(qHT_GaikaHrkmNyknData).getResultList();
    }

}
