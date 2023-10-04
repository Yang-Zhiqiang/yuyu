package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QHT_HrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.QHW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.QHW_NyuukinJyouhouHuittiWk;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 新契約 入金 自動入金明細リスト作成の機能DAOクラスです
 */
public class SkHurikominyuukinListSakuseiDao {

    @Inject
    ExDBEntityManager em;

    public List<SyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBean> getSyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pRyosyuymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_HrkmNyknTaisyouWk qHW_HrkmNyknTaisyouWk =  new QHW_HrkmNyknTaisyouWk();


        String strWhere = qHW_HrkmNyknTaisyouWk.syoriYmd.eq(pSyoriYmd);
        if (pRyosyuymd != null) {

            strWhere += $AND;
            strWhere += qHW_HrkmNyknTaisyouWk.ryosyuymd.gt(pRyosyuymd);
        }
        strWhere += $AND;
        strWhere += qHW_HrkmNyknTaisyouWk.rstuukasyu.eq(pRstuukasyu);

        String strMainSql = $SELECT + $NEW(SyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBean.class,
            qHW_HrkmNyknTaisyouWk.rsgaku.getTypeFieldName(),
            $SUM + $(qHW_HrkmNyknTaisyouWk.rsgaku.getValueFieldName()),
            qHW_HrkmNyknTaisyouWk.rsgakuen.getTypeFieldName(),
            $SUM + $(qHW_HrkmNyknTaisyouWk.rsgakuen.getValueFieldName()),
            qHW_HrkmNyknTaisyouWk.hrkmtsry.getTypeFieldName(),
            $SUM + $(qHW_HrkmNyknTaisyouWk.hrkmtsry.getValueFieldName()),
            $COUNT(qHW_HrkmNyknTaisyouWk.syoriYmd)) +
            $FROM + qHW_HrkmNyknTaisyouWk.HW_HrkmNyknTaisyouWk() +
            $WHERE + strWhere +
            $AND + qHW_HrkmNyknTaisyouWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_HrkmNyknTaisyouWk.rsgaku.getTypeFieldName() + "," +
            qHW_HrkmNyknTaisyouWk.rsgakuen.getTypeFieldName() + "," +
            qHW_HrkmNyknTaisyouWk.hrkmtsry.getTypeFieldName() +
            $ORDER_BY(qHW_HrkmNyknTaisyouWk.rsgaku.typeAsc(),
                qHW_HrkmNyknTaisyouWk.rsgakuen.typeAsc(),
                qHW_HrkmNyknTaisyouWk.hrkmtsry.typeAsc());

        return em.createJPQL(strMainSql, SyougouittiKgsBySyoriYmdRyosyuymdRstuukasyuBean.class).bind(
            qHW_HrkmNyknTaisyouWk).getResultList();
    }

    public List<SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean> getSyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pRyosyuymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_HrkmNyknTaisyouWk qHW_HrkmNyknTaisyouWk =  new QHW_HrkmNyknTaisyouWk();

        String strMainSql = $SELECT + $NEW(SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean.class,
            qHW_HrkmNyknTaisyouWk.rsgaku.getTypeFieldName(),
            $SUM + $(qHW_HrkmNyknTaisyouWk.rsgaku.getValueFieldName()),
            qHW_HrkmNyknTaisyouWk.rsgakuen.getTypeFieldName(),
            $SUM + $(qHW_HrkmNyknTaisyouWk.rsgakuen.getValueFieldName()),
            qHW_HrkmNyknTaisyouWk.hrkmtsry.getTypeFieldName(),
            $SUM + $(qHW_HrkmNyknTaisyouWk.hrkmtsry.getValueFieldName()),
            $COUNT(qHW_HrkmNyknTaisyouWk.syoriYmd)) +
            $FROM + qHW_HrkmNyknTaisyouWk.HW_HrkmNyknTaisyouWk() +
            $WHERE + qHW_HrkmNyknTaisyouWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_HrkmNyknTaisyouWk.ryosyuymd.le(pRyosyuymd) +
            $AND + qHW_HrkmNyknTaisyouWk.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHW_HrkmNyknTaisyouWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_HrkmNyknTaisyouWk.rsgaku.getTypeFieldName() + "," +
            qHW_HrkmNyknTaisyouWk.rsgakuen.getTypeFieldName() + "," +
            qHW_HrkmNyknTaisyouWk.hrkmtsry.getTypeFieldName() +
            $ORDER_BY(qHW_HrkmNyknTaisyouWk.rsgaku.typeAsc(),
                qHW_HrkmNyknTaisyouWk.rsgakuen.typeAsc(),
                qHW_HrkmNyknTaisyouWk.hrkmtsry.typeAsc());

        return em.createJPQL(strMainSql, SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean.class).bind(
            qHW_HrkmNyknTaisyouWk).getResultList();
    }


    public List<SyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBean> getSyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pKnjyymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_NyuukinJyouhouHuittiWk qHW_NyuukinJyouhouHuittiWk = new QHW_NyuukinJyouhouHuittiWk();


        String strWhere = qHW_NyuukinJyouhouHuittiWk.syoriYmd.eq(pSyoriYmd);
        if(pKnjyymd != null) {

            strWhere += $AND;
            strWhere += qHW_NyuukinJyouhouHuittiWk.knjyymd.gt(pKnjyymd);
        }
        strWhere += $AND;
        strWhere += qHW_NyuukinJyouhouHuittiWk.rstuukasyu.eq(pRstuukasyu);

        String strMainSql = $SELECT + $NEW(SyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBean.class
            , qHW_NyuukinJyouhouHuittiWk.trhkkgk.getTypeFieldName()
            , $SUM + $(qHW_NyuukinJyouhouHuittiWk.trhkkgk.getValueFieldName())
            , $COUNT(qHW_NyuukinJyouhouHuittiWk.nyksyoriymd)) +
            $FROM(qHW_NyuukinJyouhouHuittiWk) +
            $WHERE + strWhere +
            $AND + qHW_NyuukinJyouhouHuittiWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_NyuukinJyouhouHuittiWk.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHW_NyuukinJyouhouHuittiWk.trhkkgk.typeAsc());

        return em.createJPQL(strMainSql, SyougouittiNeKgsBySyoriYmdKnjyymdrstuukasyuBean.class).bind(
            qHW_NyuukinJyouhouHuittiWk).getResultList();
    }

    public List<SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean> getSyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pKnjyymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_NyuukinJyouhouHuittiWk qHW_NyuukinJyouhouHuittiWk = new QHW_NyuukinJyouhouHuittiWk();

        String strSql = $SELECT + $NEW(SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean.class
            , qHW_NyuukinJyouhouHuittiWk.trhkkgk.getTypeFieldName()
            , $SUM + $(qHW_NyuukinJyouhouHuittiWk.trhkkgk.getValueFieldName())
            , $COUNT(qHW_NyuukinJyouhouHuittiWk.nyksyoriymd)) +
            $FROM + qHW_NyuukinJyouhouHuittiWk.HW_NyuukinJyouhouHuittiWk() +
            $WHERE + qHW_NyuukinJyouhouHuittiWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_NyuukinJyouhouHuittiWk.knjyymd.le(pKnjyymd) +
            $AND + qHW_NyuukinJyouhouHuittiWk.rstuukasyu.eq(pRstuukasyu)+
            $AND + qHW_NyuukinJyouhouHuittiWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_NyuukinJyouhouHuittiWk.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHW_NyuukinJyouhouHuittiWk.trhkkgk.typeAsc());

        return em.createJPQL(strSql, SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean.class).bind(
            qHW_NyuukinJyouhouHuittiWk).getResultList();
    }

    public List<MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean> getMosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pKnjyymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHT_HrkmNyknSakujyo qHT_HrkmNyknSakujyo = new QHT_HrkmNyknSakujyo();


        String strWhere = qHT_HrkmNyknSakujyo.syoriYmd.eq(pSyoriYmd);
        if (pKnjyymd != null) {

            strWhere += $AND;
            strWhere += qHT_HrkmNyknSakujyo.knjyymd.gt(pKnjyymd);
        }
        strWhere += $AND;
        strWhere += qHT_HrkmNyknSakujyo.rstuukasyu.eq(pRstuukasyu);

        String strMainSql = $SELECT + $NEW(MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean.class
            , qHT_HrkmNyknSakujyo.trhkkgk.getTypeFieldName()
            , $SUM + $(qHT_HrkmNyknSakujyo.trhkkgk.getValueFieldName()),
            $COUNT(qHT_HrkmNyknSakujyo.hrkmdeldataskbtkey)) +
            $FROM + qHT_HrkmNyknSakujyo.HT_HrkmNyknSakujyo() +
            $WHERE + strWhere +
            $AND + qHT_HrkmNyknSakujyo.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHT_HrkmNyknSakujyo.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHT_HrkmNyknSakujyo.trhkkgk.typeAsc());


        return em.createJPQL(strMainSql, MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean.class)
            .bind(qHT_HrkmNyknSakujyo).getResultList();
    }

    public List<MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean> getMosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pKnjyymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHT_HrkmNyknSakujyo qHT_HrkmNyknSakujyo = new QHT_HrkmNyknSakujyo();

        String strSql = $SELECT + $NEW(MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean.class,
            qHT_HrkmNyknSakujyo.trhkkgk.getTypeFieldName(),
            $SUM + $(qHT_HrkmNyknSakujyo.trhkkgk.getValueFieldName()),
            $COUNT(qHT_HrkmNyknSakujyo.hrkmdeldataskbtkey)) +
            $FROM + qHT_HrkmNyknSakujyo.HT_HrkmNyknSakujyo() +
            $WHERE + qHT_HrkmNyknSakujyo.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_HrkmNyknSakujyo.knjyymd.le(pKnjyymd) +
            $AND + qHT_HrkmNyknSakujyo.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_HrkmNyknSakujyo.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHT_HrkmNyknSakujyo.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHT_HrkmNyknSakujyo.trhkkgk.typeAsc());

        return em.createJPQL(strSql, MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean.class)
            .bind(qHT_HrkmNyknSakujyo).getResultList();
    }

    public List<YuukoukknsBySyoriYmdKnjyymdRstuukasyuBean> getYuukoukknsBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pKnjyymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_MosMatiKknKeikaWk qHW_MosMatiKknKeikaWk = new QHW_MosMatiKknKeikaWk();

        String strWhere = qHW_MosMatiKknKeikaWk.syoriYmd.eq(pSyoriYmd);
        if (pKnjyymd != null) {

            strWhere += $AND;
            strWhere += qHW_MosMatiKknKeikaWk.knjyymd.gt(pKnjyymd);
        }
        strWhere += $AND;
        strWhere += qHW_MosMatiKknKeikaWk.rstuukasyu.eq(pRstuukasyu);

        String strSql = $SELECT + $NEW(YuukoukknsBySyoriYmdKnjyymdRstuukasyuBean.class,
            qHW_MosMatiKknKeikaWk.trhkkgk.getTypeFieldName(),
            $SUM + $(qHW_MosMatiKknKeikaWk.trhkkgk.getValueFieldName()),
            $COUNT(qHW_MosMatiKknKeikaWk.nyksyoriymd)) +
            $FROM(qHW_MosMatiKknKeikaWk) +
            $WHERE + strWhere +
            $AND + qHW_MosMatiKknKeikaWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_MosMatiKknKeikaWk.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHW_MosMatiKknKeikaWk.trhkkgk.typeAsc());

        return em.createJPQL(strSql, YuukoukknsBySyoriYmdKnjyymdRstuukasyuBean.class).bind(qHW_MosMatiKknKeikaWk).getResultList();
    }

    public List<YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean> getYuukoukknKsansBySyoriYmdKnjyymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pKnjyymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_MosMatiKknKeikaWk qHW_MosMatiKknKeikaWk = new QHW_MosMatiKknKeikaWk();

        String strSql = $SELECT + $NEW(YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean.class
            , qHW_MosMatiKknKeikaWk.trhkkgk.getTypeFieldName()
            , $SUM + $(qHW_MosMatiKknKeikaWk.trhkkgk.getValueFieldName())
            , $COUNT(qHW_MosMatiKknKeikaWk.nyksyoriymd)) +
            $FROM(qHW_MosMatiKknKeikaWk) +
            $WHERE + qHW_MosMatiKknKeikaWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_MosMatiKknKeikaWk.knjyymd.le(pKnjyymd) +
            $AND + qHW_MosMatiKknKeikaWk.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHW_MosMatiKknKeikaWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_MosMatiKknKeikaWk.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHW_MosMatiKknKeikaWk.trhkkgk.typeAsc());

        return em.createJPQL(strSql, YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean.class).bind(qHW_MosMatiKknKeikaWk).getResultList();
    }

    public List<GinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBean> getGinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pNyksyoriymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_JidouNyknTaisyougaiWk qHW_JidouNyknTaisyougaiWk =  new QHW_JidouNyknTaisyougaiWk();

        String strWhere = qHW_JidouNyknTaisyougaiWk.syoriYmd.eq(pSyoriYmd);
        if (pNyksyoriymd != null) {

            strWhere += $AND;
            strWhere += qHW_JidouNyknTaisyougaiWk.nyksyoriymd.gt(pNyksyoriymd);
        }
        strWhere += $AND;
        strWhere += qHW_JidouNyknTaisyougaiWk.rstuukasyu.eq(pRstuukasyu);

        String strMainSql = $SELECT + $NEW(GinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBean.class
            , qHW_JidouNyknTaisyougaiWk.trhkkgk.getTypeFieldName()
            , $SUM + $(qHW_JidouNyknTaisyougaiWk.trhkkgk.getValueFieldName())
            , $COUNT(qHW_JidouNyknTaisyougaiWk.nyksyoriymd)) +
            $FROM(qHW_JidouNyknTaisyougaiWk) +
            $WHERE + strWhere +
            $AND + qHW_JidouNyknTaisyougaiWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHW_JidouNyknTaisyougaiWk.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHW_JidouNyknTaisyougaiWk.trhkkgk.typeAsc());

        return em.createJPQL(strMainSql, GinkouMdhnJdNyknTsygsBySyoriYmdNyksyoriymdRstuukasyuBean.class).bind(
            qHW_JidouNyknTaisyougaiWk).getResultList();
    }

    public List<GinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBean> getGinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pNyksyoriymd, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHW_JidouNyknTaisyougaiWk qHW_JidouNyknTaisyougaiWk =  new QHW_JidouNyknTaisyougaiWk();

        String strSql = $SELECT + $NEW(GinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBean.class
            , qHW_JidouNyknTaisyougaiWk.trhkkgk.getTypeFieldName()
            , $SUM + $(qHW_JidouNyknTaisyougaiWk.trhkkgk.getValueFieldName())
            , $COUNT(qHW_JidouNyknTaisyougaiWk.nyksyoriymd)) +
            $FROM(qHW_JidouNyknTaisyougaiWk) +
            $WHERE + qHW_JidouNyknTaisyougaiWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_JidouNyknTaisyougaiWk.nyksyoriymd.le(pNyksyoriymd) +
            $AND + qHW_JidouNyknTaisyougaiWk.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHW_JidouNyknTaisyougaiWk.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY +qHW_JidouNyknTaisyougaiWk.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHW_JidouNyknTaisyougaiWk.trhkkgk.typeAsc());

        return em.createJPQL(strSql, GinkouMdhnJdNyknTsygKsansBySyoriYmdNyksyoriymdRstuukasyuBean.class).bind(
            qHW_JidouNyknTaisyougaiWk).getResultList();
    }

    public List<YokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgBean> getYokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgNyktyhyoutlst(
        BizDate pSyoriYmd, BizDate pZengetuLastd, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHT_HrkmNyknData qHT_HrkmNyknData = new QHT_HrkmNyknData();

        String strWhere = qHT_HrkmNyknData.densyskbn.eq(C_DensysKbn.SKEI);
        if(pSyoriYmd != null) {

            strWhere += $AND;
            strWhere += qHT_HrkmNyknData.azkrhrdsymd.le(pSyoriYmd);
        }

        if(pZengetuLastd != null) {

            strWhere += $AND;
            strWhere += qHT_HrkmNyknData.azkrhrdsymd.gt(pZengetuLastd);
        }
        strWhere += $AND;
        strWhere += qHT_HrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI);

        String strMainSql = $SELECT + $NEW(YokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgBean.class
            , qHT_HrkmNyknData.trhkkgk.getTypeFieldName()
            , $SUM + $(qHT_HrkmNyknData.trhkkgk.getValueFieldName())
            , $COUNT(qHT_HrkmNyknData.syoriYmd)) +
            $FROM(qHT_HrkmNyknData) +
            $WHERE + strWhere +
            $AND + qHT_HrkmNyknData.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHT_HrkmNyknData.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHT_HrkmNyknData.trhkkgk.typeAsc());

        return em.createJPQL(strMainSql, YokuziturkKgsByDensyskbnSyoriYmdZengetuLastdSyorizumiflgBean.class).bind(qHT_HrkmNyknData).getResultList();
    }

    public List<YokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdBean> getYokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdNyktyhyoutlst(
        BizDate pAzkrhrdsymd, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHT_HrkmNyknData qHT_HrkmNyknData = new QHT_HrkmNyknData();

        String strSql = $SELECT + $NEW(YokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdBean.class,
            qHT_HrkmNyknData.trhkkgk.getTypeFieldName(),
            $SUM + $(qHT_HrkmNyknData.trhkkgk.getValueFieldName()),
            $COUNT(qHT_HrkmNyknData.syoriYmd)) +
            $FROM + qHT_HrkmNyknData.HT_HrkmNyknData() +
            $WHERE + qHT_HrkmNyknData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qHT_HrkmNyknData.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $AND + qHT_HrkmNyknData.azkrhrdsymd.le(pAzkrhrdsymd) +
            $AND + qHT_HrkmNyknData.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHT_HrkmNyknData.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHT_HrkmNyknData.trhkkgk.typeAsc());

        return em.createJPQL(strSql, YokuziturkKgKsansByDensyskbnSyorizumiflgAzkrhrdsymdBean.class).bind(qHT_HrkmNyknData)
            .getResultList();
    }

    public ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean getZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutList(
        BizDate pSyoriYmd, C_KessanKbn pKessanKbn, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHT_JidouSyuunouMeisai2 qHT_JidouSyuunouMeisai2 = new QHT_JidouSyuunouMeisai2();

        String strSql = $SELECT + $NEW(ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean.class,
            $SUM + $(qHT_JidouSyuunouMeisai2.yokukurikosikensuu),
            qHT_JidouSyuunouMeisai2.yokukurikosigk.getTypeFieldName(),
            $SUM + $(qHT_JidouSyuunouMeisai2.yokukurikosigk.getValueFieldName())) +
            $FROM + qHT_JidouSyuunouMeisai2.HT_JidouSyuunouMeisai2() +
            $WHERE + qHT_JidouSyuunouMeisai2.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_JidouSyuunouMeisai2.kessankbn.eq(pKessanKbn) +
            $AND + qHT_JidouSyuunouMeisai2.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_JidouSyuunouMeisai2.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHT_JidouSyuunouMeisai2.yokukurikosigk.getTypeFieldName() +
            $ORDER_BY(qHT_JidouSyuunouMeisai2.yokukurikosigk.typeAsc());

        return em.createJPQL(strSql, ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean.class).bind(
            qHT_JidouSyuunouMeisai2).getSingleResult();
    }

    public List<TjtKgsByDensyskbnSyoriYmdBean> getTjtKgsByDensyskbnSyoriYmdNyktyhyoutlst(
        BizDate pSyoriYmd, C_NyktyhyoutKbn[] pNyktyhyoutKbnList) {

        QHT_HrkmNyknData qHT_HrkmNyknData = new QHT_HrkmNyknData();

        String strSql = $SELECT + $NEW(TjtKgsByDensyskbnSyoriYmdBean.class ,
            qHT_HrkmNyknData.trhkkgk.getTypeFieldName(),
            $SUM + $(qHT_HrkmNyknData.trhkkgk.getValueFieldName()),
            $COUNT(qHT_HrkmNyknData.syoriYmd)) +
            $FROM + qHT_HrkmNyknData.HT_HrkmNyknData() +
            $WHERE + qHT_HrkmNyknData.densyskbn.eq( C_DensysKbn.SKEI) +
            $AND + qHT_HrkmNyknData.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_HrkmNyknData.nyktyhyoutkbn.in(pNyktyhyoutKbnList) +
            $GROUP_BY + qHT_HrkmNyknData.trhkkgk.getTypeFieldName() +
            $ORDER_BY(qHT_HrkmNyknData.trhkkgk.typeAsc());

        return em.createJPQL(strSql, TjtKgsByDensyskbnSyoriYmdBean.class).bind(qHT_HrkmNyknData).getResultList();
    }

}
