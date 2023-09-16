package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_FatcaInfo;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_HokenSyouken;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.hozen.result.bean.DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean;
import yuyu.def.hozen.result.bean.FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean;
import yuyu.def.hozen.result.bean.FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.result.bean.HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.result.bean.KeizokuriturenrakudateUlfsByBosyuuymBean;
import yuyu.def.hozen.result.bean.KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean;
import yuyu.def.hozen.result.bean.KokyakuYuyukykMeisaiFTaisyouDataBean;
import yuyu.def.hozen.result.bean.KykInfosByKykymDrtencdItemsBean;
import yuyu.def.hozen.result.bean.KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.def.hozen.result.bean.KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.def.hozen.result.bean.SmbckykdtlInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdKykymdBean;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean;

/**
 * 契約基本テーブル(IT_KykKihonDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykKihonDao extends AbstractDao<IT_KykKihon> {

    public IT_KykKihonDao() {
        super(IT_KykKihon.class);
    }

    public IT_KykKihon getKykKihon(String pSyono) {
        IT_KykKihon iT_KykKihon =  new IT_KykKihon( pSyono);
        return this.selectOne(iT_KykKihon);
    }

    public ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(
        BizDate pKouryokuendymd, C_SyutkKbn pSyutkkbn, C_FatcakekKbn[] pFatcakekkbn) {


        QIT_FatcaInfo qIT_FatcaInfo = new QIT_FatcaInfo("qIT_FatcaInfo");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String mainStry = $SELECT + qIT_FatcaInfo + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya + "," +
            qIT_AnsyuKihon +
            $FROM + qIT_FatcaInfo.IT_FatcaInfo() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya()  +  ","  +
            qIT_AnsyuKihon.IT_AnsyuKihon()  +
            $WHERE + qIT_FatcaInfo.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_FatcaInfo.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_FatcaInfo.syono.eq(qIT_KykSya.syono) +
            $AND + qIT_FatcaInfo.syono.eq(qIT_AnsyuKihon.syono) +
            $AND + qIT_FatcaInfo.fatcakekkbn.in(pFatcakekkbn) +
            $AND + "(" + qIT_FatcaInfo.kouryokuendymd.gt(pKouryokuendymd) +
            $OR + qIT_FatcaInfo.kouryokuendymd.isNull() + ")" +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn);

        return em.createJPQL(mainStry).bind(qIT_FatcaInfo, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_AnsyuKihon).getResults(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean.class);
    }

    public ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(BizDateY pSyoriYear) {


        QIT_FatcaInfo qIT_FatcaInfo = new QIT_FatcaInfo("qIT_FatcaInfo");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        String mainStry = $SELECT + qIT_FatcaInfo + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya +
            $FROM + qIT_FatcaInfo.IT_FatcaInfo() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya()  +
            $WHERE + qIT_FatcaInfo.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
            $AND + qIT_FatcaInfo.fatcakekkbn.eq(C_FatcakekKbn.TAISYOUGAIYOU) +
            $AND + qIT_FatcaInfo.syoriYmd.substring(1, 4) + $EQ  + "'" + pSyoriYear + "'" +
            $AND + qIT_FatcaInfo.kouryokuendymd.isNull() +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);

        return em.createJPQL(mainStry).bind(qIT_FatcaInfo, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya).getResults(FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean.class);
    }

    public List<KykInfosByKykymDrtencdItemsBean> getKykInfosByKykymDrtencdItems(BizDateYM pKykym, String pDrtencd, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj
        , BizDate pKykseiymd, String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykDairiten qIT_KykDairiten1 = new QIT_KykDairiten("qIT_KykDairiten1");

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        QIT_KykDairiten qIT_KykDairiten2 = new QIT_KykDairiten("qIT_KykDairiten2");

        String subQuerry = "";

        String subQuerry1 = "";

        String subQuerry2 = "";

        String subQuerry3 = "";

        if (!StringUtil.isNullOrBlank(pDrtencd)) {


            subQuerry = $AND + qIT_KykDairiten2.drtencd.eq(pDrtencd);
        }
        subQuerry1 = $SELECT +  $MIN(qIT_KykDairiten2.drtenrenno) +
            $FROM + qIT_KykDairiten2.IT_KykDairiten() +
            $WHERE + qIT_KykDairiten2.syono.eq(qIT_KykDairiten1.syono) +
            subQuerry;


        if (pKykym != null) {


            subQuerry2 = $AND + qIT_KykSyouhn.kykymd.substring(1, 6).eq(pKykym.toString());
        }


        if (pYuukousyoumetukbn != null && !pYuukousyoumetukbn.eq(C_YuukousyoumetuKbn.BLNK)) {


            subQuerry2 = subQuerry2 + $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(pYuukousyoumetukbn);
        }


        if (!StringUtil.isNullOrBlank(pKyknmkn)) {


            subQuerry2 = subQuerry2 + $AND + qIT_KykSya.kyknmkn.like("%" + pKyknmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pKyknmkj)) {


            subQuerry2 = subQuerry2 + $AND + qIT_KykSya.kyknmkj.like("%" + pKyknmkj + "%");
        }


        if (pKykseiymd != null) {


            subQuerry2 = subQuerry2 + $AND + qIT_KykSya.kykseiymd.eq(pKykseiymd);
        }


        if (!StringUtil.isNullOrBlank(pTelno)) {


            subQuerry2 = subQuerry2 + $AND + "(" + qIT_KykSya.tsintelno.eq(pTelno) +

                $OR + qIT_KykSya.dai2tsintelno.eq(pTelno) + ")" ;
        }


        if (!StringUtil.isNullOrBlank(pTsinyno)) {


            subQuerry2 = subQuerry2 + $AND +  qIT_KykSya.tsinyno.eq(pTsinyno);
        }


        if (!StringUtil.isNullOrBlank(pHhknnmkn)) {


            subQuerry2 = subQuerry2 + $AND + qIT_HhknSya.hhknnmkn.like("%" + pHhknnmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pHhknnmkj)) {


            subQuerry2 = subQuerry2 + $AND + qIT_HhknSya.hhknnmkj.like("%" + pHhknnmkj + "%");
        }


        if (pHhknseiymd != null) {


            subQuerry2 = subQuerry2 + $AND + qIT_HhknSya.hhknseiymd.eq(pHhknseiymd);
        }


        if (!StringUtil.isNullOrBlank(pKyknmkn) || pKykseiymd != null) {

            subQuerry3 = $ORDER_BY(qIT_KykSya.kyknmkn.asc(),
                qIT_KykSya.kykseiymd.asc(),
                qIT_KykKihon.syono.asc());
        }


        else if (!StringUtil.isNullOrBlank(pHhknnmkn) || pHhknseiymd != null) {

            subQuerry3 = $ORDER_BY(qIT_HhknSya.hhknnmkn.asc(),
                qIT_HhknSya.hhknseiymd.asc(),
                qIT_KykKihon.syono.asc());
        }

        else {

            subQuerry3 = $ORDER_BY(qIT_KykKihon.syono.asc());
        }


        String mainQuerry = $SELECT + $NEW(KykInfosByKykymDrtencdItemsBean.class,
            qIT_KykKihon.syono,
            qIT_KykSya.kyknmkn,
            qIT_KykSya.kyknmkj,
            qIT_KykSya.kykseiymd,
            qIT_KykSya.tsintelno,
            qIT_KykSya.dai2tsintelno,
            qIT_HhknSya.hhknnmkn,
            qIT_HhknSya.hhknnmkj,
            qIT_HhknSya.hhknseiymd,
            qBM_SyouhnZokusei.syouhnnm,
            qIT_KykSyouhn.yuukousyoumetukbn)+
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya() + "," +
            qIT_KykDairiten1.IT_KykDairiten() + "," +
            qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykDairiten1.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykDairiten1.drtenrenno + $EQ + $(subQuerry1) +
            $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qBM_SyouhnZokusei.syouhncd.eq(qIT_KykSyouhn.syouhncd) +
            $AND + qBM_SyouhnZokusei.syouhnsdno.eq(qIT_KykSyouhn.syouhnsdno) +
            $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
            subQuerry2 +
            subQuerry3;

        return em.createJPQL(mainQuerry, KykInfosByKykymDrtencdItemsBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya, qIT_KykDairiten1, qBM_SyouhnZokusei, qIT_KykDairiten2).getResultList();
    }

    public ExDBResults<SyainMeiboInfosByKakutyoujobcdKykymdBean> getSyainMeiboInfosByKakutyoujobcdKykymd(BizDate pKykymd) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        QIT_KhTtdkTyuui qIT_KhTtdkTyuui = new QIT_KhTtdkTyuui("qIT_KhTtdkTyuui");

        String mainStry = $SELECT + qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya + "," +
            qBM_SyouhnZokusei + "," +
            qIT_KhTtdkTyuui +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya()  + "," +
            qBM_SyouhnZokusei.BM_SyouhnZokusei() + "," +
            qIT_KhTtdkTyuui.IT_KhTtdkTyuui() +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.kykymd.le(pKykymd) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
            $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
            $AND + qBM_SyouhnZokusei.haitoukbn.ne(C_HaitouKbn.NONE) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KhTtdkTyuui.syono);

        return em.createJPQL(mainStry).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qBM_SyouhnZokusei, qIT_KhTtdkTyuui).getResults(SyainMeiboInfosByKakutyoujobcdKykymdBean.class);
    }


    public ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(
        BizDate pTyouhyouymd) {


        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken("qIT_HokenSyouken");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_HhknSya qIT_HhknSya  = new QIT_HhknSya("qIT_HhknSya");

        String mainStry = $SELECT + qIT_HokenSyouken + "," +
            qIT_KykKihon + "," +
            qIT_KykSya + "," +
            qIT_HhknSya +
            $FROM + qIT_HokenSyouken.IT_HokenSyouken() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya()  +
            $WHERE + qIT_HokenSyouken.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_HokenSyouken.tyouhyouymd.eq(pTyouhyouymd) +
            $ORDER_BY (qIT_KykKihon.syono.asc());

        return em.createJPQL(mainStry).bind(qIT_HokenSyouken, qIT_KykKihon, qIT_KykSya, qIT_HhknSya).getResults(SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean.class);
    }

    public ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(
        C_SyutkKbn pSyutkkbn) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_HhknSya qIT_HhknSya  = new QIT_HhknSya("qIT_HhknSya");

        String mainStry = $SELECT + qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya + "," +
            qIT_HhknSya +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya()  +
            $WHERE + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
            $ORDER_BY (qIT_KykKihon.syono.asc());

        return em.createJPQL(mainStry).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya).getResults(SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean.class);
    }

    public ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(
        BizDate pSyoriYmd) {


        QIT_FatcaInfo qIT_FatcaInfo = new QIT_FatcaInfo("qIT_FatcaInfo");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        String mainStry = $SELECT + qIT_FatcaInfo + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya +
            $FROM + qIT_FatcaInfo.IT_FatcaInfo() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya()  +
            $WHERE + qIT_FatcaInfo.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
            $AND + qIT_FatcaInfo.fatcakekkbn.eq(C_FatcakekKbn.KAKUNINTYUU) +
            $AND + qIT_FatcaInfo.syoriYmd.lt(pSyoriYmd) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $ORDER_BY (qIT_KykKihon.syono.asc());

        return em.createJPQL(mainStry).bind(qIT_FatcaInfo, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya).getResults(KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean.class);
    }

    public ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(
        BizDate pTysytymdFrom, BizDate pTysytymdTo) {


        QIT_FatcaInfo qIT_FatcaInfo = new QIT_FatcaInfo("qIT_FatcaInfo");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        String mainStry = $SELECT + qIT_FatcaInfo + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya +
            $FROM + qIT_FatcaInfo.IT_FatcaInfo() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya()  +
            $WHERE + qIT_FatcaInfo.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
            $AND + qIT_FatcaInfo.fatcakekkbn.ne(C_FatcakekKbn.KAKUNINTYUU) +
            $AND + qIT_FatcaInfo.syoriYmd.ge(pTysytymdFrom) +
            $AND + qIT_FatcaInfo.syoriYmd.le(pTysytymdTo) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $ORDER_BY (qIT_KykKihon.syono.asc());

        return em.createJPQL(mainStry).bind(qIT_FatcaInfo, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya).getResults(KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean.class);
    }

    public IT_KykKihon getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn(String pSyono) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon();

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        String mainStry = $SELECT_DISTINCT + qIT_KykKihon +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qIT_KykKihon.syono.eq(pSyono) +
            $AND + qIT_KykKihon.syono.eq(qHT_SyoriCTL.syono) +
            $AND + qIT_KykKihon.fstphrkkeirokbn.eq(C_FstphrkkeiroKbn.CREDIT) +
            $AND + qHT_SyoriCTL.uriagesousinkbn.eq(C_UriagesousinKbn.SOUSINMATI);

        return em.createJPQL(mainStry).bind(qIT_KykKihon, qHT_SyoriCTL).getSingleResult();
    }

    public List<IT_KykKihon> getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon();
        QIT_KykSya qIT_KykSya = new QIT_KykSya();


        String subSql = $SELECT + qIT_KykSya.syono +
            $FROM + qIT_KykSya.IT_KykSya() +
            $WHERE + qIT_KykSya.syono.eq(qIT_KykKihon.syono);


        String strSql = $SELECT + qIT_KykKihon +
            $FROM + qIT_KykKihon.IT_KykKihon() +
            $WHERE + qIT_KykKihon.drctservicemoskbn.eq(C_DirectServiceMosKbn.CHECK) +
            $AND + qIT_KykKihon.seirituymd.ge(pSyoriYmdFrom) +
            $AND + qIT_KykKihon.seirituymd.le(pSyoriYmdTo) +
            $AND + $EXISTS(subSql) +
            $ORDER_BY (qIT_KykKihon.syono.asc());


        return em.createJPQL(strSql).setFirstResult(0).setMaxResults(501).bind(qIT_KykKihon, qIT_KykSya).getResultList();
    }

    public List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom,
        BizDate pSyoriYmdTo) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd("qMT_DsHonninKakuninCd");


        String strSql = $SELECT + $NEW(KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean.class, qIT_KykKihon.lastkyknmseiymdhenkouymd ,
            qIT_KykKihon.lastkyknmkanakjteiymd ,
            qIT_KykSya.kyknmkj ,
            qIT_KykSya.kyknmkn ,
            qIT_KykSya.kykseiymd ,
            qMT_DsKokyakuKeiyaku.syono ,
            qMT_DsKokyakuKeiyaku.dskokno ,
            qMT_DsKokyakuKanri.dskokyakunmkj ,
            qMT_DsKokyakuKanri.dskokyakunmkn ,
            qMT_DsKokyakuKanri.dskokyakuseiymd ,
            qMT_DsKokyakuKanri.dskokyakuyno ,
            qMT_DsKokyakuKanri.dskokyakujtkbn ,
            qMT_DsHonninKakuninCd.dshnnkakcd ,
            qMT_DsHonninKakuninCd.dskrhnnkakcd )+
            $FROM( qIT_KykKihon,
                qIT_KykSya,
                qMT_DsKokyakuKeiyaku,
                qMT_DsKokyakuKanri,
                qMT_DsHonninKakuninCd) +
                $WHERE + "("+ "(" + qIT_KykKihon.lastkyknmseiymdhenkouymd.ge(pSyoriYmdFrom) +
                $AND + qIT_KykKihon.lastkyknmseiymdhenkouymd.le(pSyoriYmdTo) + ")" +
                $OR + "(" + qIT_KykKihon.lastkyknmkanakjteiymd.ge(pSyoriYmdFrom) +
                $AND + qIT_KykKihon.lastkyknmkanakjteiymd.le(pSyoriYmdTo) + ")" + ")" +
                $AND + qIT_KykKihon.syono.eq(qMT_DsKokyakuKeiyaku.syono) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono)+
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno)+
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsHonninKakuninCd.dskokno)+
                $ORDER_BY(qMT_DsKokyakuKeiyaku.dskokno.asc(),qMT_DsKokyakuKeiyaku.syono.asc());


        return em.createJPQL(strSql).bind(qIT_KykKihon, qIT_KykSya, qMT_DsKokyakuKeiyaku,qMT_DsKokyakuKanri,qMT_DsHonninKakuninCd).getResultList();
    }

    public List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("MT_DsKokyakuKeiyaku");
        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd("qMT_DsHonninKakuninCd");


        String strSql = $SELECT + $NEW(KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean.class,
            qIT_KykKihon.lasttsinynohenkouymd,
            qIT_KykSya.tsinyno ,
            qMT_DsKokyakuKeiyaku.syono ,
            qMT_DsKokyakuKeiyaku.dskokno ,
            qMT_DsKokyakuKanri.dskokyakunmkj ,
            qMT_DsKokyakuKanri.dskokyakunmkn ,
            qMT_DsKokyakuKanri.dskokyakuseiymd ,
            qMT_DsKokyakuKanri.dskokyakuyno ,
            qMT_DsKokyakuKanri.dskokyakujtkbn ,
            qMT_DsHonninKakuninCd.dshnnkakcd ,
            qMT_DsHonninKakuninCd.dskrhnnkakcd )+
            $FROM( qIT_KykKihon,
                qIT_KykSya,
                qMT_DsKokyakuKeiyaku,
                qMT_DsKokyakuKanri,
                qMT_DsHonninKakuninCd) +
                $WHERE + qIT_KykKihon.lasttsinynohenkouymd.ge(pSyoriYmdFrom) +
                $AND + qIT_KykKihon.lasttsinynohenkouymd.le(pSyoriYmdTo) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qMT_DsKokyakuKeiyaku.syono) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK)+
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno)+
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsHonninKakuninCd.dskokno)+
                $ORDER_BY(qMT_DsKokyakuKeiyaku.dskokno.asc(),qMT_DsKokyakuKeiyaku.syono.asc());


        return em.createJPQL(strSql).bind(qIT_KykKihon, qIT_KykSya, qMT_DsKokyakuKeiyaku,qMT_DsKokyakuKanri,qMT_DsHonninKakuninCd).getResultList();
    }

    public ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pGyoumuKousinKinou) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q1");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("q2");


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("q3");


        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("q4");

        String mainStry = $SELECT + qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KhTtdkRireki + "," +
            qIT_KhShrRireki +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KhTtdkRireki.IT_KhTtdkRireki() + "," +
            qIT_KhShrRireki.IT_KhShrRireki()  +
            $WHERE + qIT_KhTtdkRireki.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qIT_KhTtdkRireki.syoriYmd.le(pSyoriYmdTo) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykKihon.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhShrRireki.henkousikibetukey);

        return em.createJPQL(mainStry).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KhTtdkRireki, qIT_KhShrRireki).getResults(HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean.class);
    }

    public ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> getGaikaKokyakuTuutiInfosByKakutyoujobcd() {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q1");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("q2");


        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("q3");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("q4");


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("q5");


        String mainStr = $SELECT + qIT_KykKihon + "," +
            qIT_KykSya + "," +
            qIT_HhknSya + "," +
            qIT_KykSyouhn + "," +
            qBM_SyouhnZokusei +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qBM_SyouhnZokusei.syouhncd.eq(qIT_KykSyouhn.syouhncd) +
            $AND + qBM_SyouhnZokusei.syouhnsdno.eq(qIT_KykSyouhn.syouhnsdno);

        return em.createJPQL(mainStr).bind(qIT_KykKihon,qIT_KykSya,qIT_HhknSya,qIT_KykSyouhn,qBM_SyouhnZokusei).getResults(GaikaKokyakuTuutiInfosByKakutyoujobcdBean.class);
    }

    public ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn() {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q1");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("q2");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("q3");


        String subSql = $SELECT + qMT_DsKokyakuKeiyaku.syono +
            $FROM (qMT_DsKokyakuKeiyaku) +
            $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(qIT_KykKihon.syono);


        String strSql = $SELECT +$NEW(DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.class,
            qIT_KykKihon,
            qIT_KykSya) +
            $FROM (qIT_KykKihon,
                qIT_KykSya) +
                $WHERE + qIT_KykKihon.drctservicemoskbn.ne(C_DirectServiceMosKbn.NOENTRY) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + $NOT_EXISTS(subSql);


        return em.createJPQL(strSql, DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.class).bind(qIT_KykKihon, qIT_KykSya, qMT_DsKokyakuKeiyaku).getResults();
    }

    public ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(
        BizDate pKsnbiymd) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");


        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");


        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri("qIT_KhBikinkanri");


        String subQuery = $SELECT + qIT_KhShrRireki.syono + "," +
            qIT_KhBikinkanri.syono +
            $FROM + qIT_KhBikinkanri.IT_KhBikinkanri() +
            $WHERE + qIT_KhShrRireki.syono.eq(qIT_KhBikinkanri.syono) +
            $AND + qIT_KhBikinkanri.kessankijyunymd.eq(pKsnbiymd) +
            $AND + qIT_KhBikinkanri.bknrigikbn.ne(C_BknrigiKbn.BLNK);


        String mainStr = $SELECT + qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KhShrRireki + "," +
            qIT_KhTtdkRireki + "," +
            qBM_SyouhnZokusei +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KhShrRireki.IT_KhShrRireki()  + "," +
            qIT_KhTtdkRireki.IT_KhTtdkRireki() + "," +
            qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KhShrRireki.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhShrRireki.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
            $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
            $AND + "(" + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.KAIYAKU) +
            $OR + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.GENGAKU) + ")" +
            $AND + qIT_KhShrRireki.shrymd.gt(pKsnbiymd) +
            $AND + qIT_KhShrRireki.syoruiukeymd.le(pKsnbiymd) +
            $AND + $NOT_EXISTS(subQuery);

        return em.createJPQL(mainStr).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KhTtdkRireki, qIT_KhShrRireki, qBM_SyouhnZokusei,qIT_KhBikinkanri).getResults(KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean.class);
    }

    public ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> getSyainMeiboInfosByKakutyoujobcd() {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q1");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("q2");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("q3");

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("q4");


        String strSpl = $SELECT + $NEW(SyainMeiboInfosByKakutyoujobcdBean.class, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qBM_SyouhnZokusei) +
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qBM_SyouhnZokusei) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
            $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
            $AND + qBM_SyouhnZokusei.haitoukbn.ne(C_HaitouKbn.NONE) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono);


        return em.createJPQL(strSpl).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qBM_SyouhnZokusei).getResults();
    }

    public ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> getKeizokuriturenrakudateUlfsByBosyuuym(
        BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q1");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("q2");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("q3");


        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("q4");


        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("q5");


        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("q6");


        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("q7");


        String mainStr = $SELECT + $NEW(KeizokuriturenrakudateUlfsByBosyuuymBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_KykDairiten,
            qIT_AnsyuKihon,
            qIT_KykSonotaTkyk) +
            $FROM (qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KykDairiten,
                qIT_AnsyuKihon,
                qIT_KykSonotaTkyk) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykDairiten.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykKihon.bosyuuym.ge(pBosyuuymFrom) +
                $AND + qIT_KykKihon.bosyuuym.le(pBosyuuymTo);

        return em.createJPQL(mainStr, KeizokuriturenrakudateUlfsByBosyuuymBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya, qIT_KykDairiten,qIT_AnsyuKihon, qIT_KykSonotaTkyk).getResults();
    }

    public ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(
        BizDate pSyoriYmd, String... pGyoumuKousinKinou) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");


        String jpqlStr = $SELECT + $NEW(HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.class,qIT_KykKihon,qIT_KhTtdkRireki,qIT_KykSyouhn,qIT_HhknSya,qIT_KykDairiten,qIT_KykSonotaTkyk,qIT_AnsyuKihon) +
            $FROM(qIT_KykKihon,qIT_KhTtdkRireki,qIT_KykSyouhn,qIT_HhknSya,qIT_KykDairiten,qIT_KykSonotaTkyk,qIT_AnsyuKihon) +
            $WHERE + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.in(pGyoumuKousinKinou) +
            $AND + qIT_KykKihon.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND +qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND +qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
            $AND +qIT_KykKihon.syono.eq(qIT_KykDairiten.syono) +
            $AND +qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
            $AND +qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
            $AND +qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND +qIT_KykDairiten.drtenrenno.eq(1);


        return em.createJPQL(jpqlStr).bind(qIT_KykKihon,qIT_KhTtdkRireki,qIT_KykSyouhn,qIT_HhknSya,qIT_KykDairiten,qIT_KykSonotaTkyk,qIT_AnsyuKihon).getResults();
    }

    public ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean() {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykSya qIT_KykSa = new QIT_KykSya("qIT_KykSa");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");


        String mainStr = $SELECT + $NEW(Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.class, qIT_KykKihon, qIT_KykSyouhn, qIT_KykDairiten, qIT_KykSonotaTkyk, qIT_HhknSya,qIT_KykSa, qIT_AnsyuKihon)+
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_KykDairiten, qIT_KykSonotaTkyk, qIT_HhknSya, qIT_KykSa,qIT_AnsyuKihon) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSa.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykDairiten.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU);


        return em.createJPQL(mainStr, Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.class).bind(qIT_KykKihon,qIT_KykSyouhn,qIT_KykDairiten,qIT_KykSonotaTkyk,qIT_HhknSya,qIT_KykSa,qIT_AnsyuKihon).getResults();

    }

    public ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> getKokyakuYuyukykMeisaiFTaisyouDataBean() {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykSya qIT_KykSa = new QIT_KykSya("qIT_KykSa");


        String mainStr = $SELECT + $NEW(KokyakuYuyukykMeisaiFTaisyouDataBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSonotaTkyk,
            qIT_HhknSya,
            qIT_KykSa)+
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_HhknSya,
                qIT_KykSa) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSa.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono)+
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU)+
                $ORDER_BY (qIT_KykKihon.syono.asc());


        return em.createJPQL(mainStr).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSonotaTkyk, qIT_HhknSya, qIT_KykSa).getResults();
    }

    public ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(
        BizDate pTyouhyouymd) {

        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken("qIT_HokenSyouken");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_HhknSya qIT_HhknSya  = new QIT_HhknSya("qIT_HhknSya");


        String mainStry = $SELECT +
            $NEW(SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean.class,
                qIT_HokenSyouken.syono,
                qIT_HokenSyouken.tyouhyouymd,
                qIT_HokenSyouken.sinsaihkkbn,
                qIT_HokenSyouken.syoukensaihkkbn,
                qIT_HokenSyouken.insizeishryouhikbn,
                qIT_HokenSyouken.hassoukbn,
                qIT_HokenSyouken.koujyosyoumeiumukbn,
                qIT_HokenSyouken.suiihyouumukbn,
                qIT_HokenSyouken.kanryoutuutiumukbn,
                qIT_HokenSyouken.stdrsktirasidouhuukbn,
                qIT_HokenSyouken.dstirasidouhuukbn,
                qIT_HokenSyouken.aisyoumeikbn,
                qIT_HokenSyouken.hknsyukigou,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn1,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn2,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn3,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn4,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn5,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn6,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn7,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn8,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn9,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn10,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn11,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn12,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn13,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn14,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn15,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn16,
                qIT_HokenSyouken.tokusyusyorinaiyoukbn17,
                qIT_HokenSyouken.gyoumuKousinKinou,
                qIT_HokenSyouken.gyoumuKousinsyaId,
                qIT_HokenSyouken.tantocd,
                qIT_HokenSyouken.yakkanbunsyono,
                qIT_KykKihon,
                qIT_KykSya,
                qIT_HhknSya) +
                $FROM  (
                    qIT_HokenSyouken,
                    qIT_KykKihon,
                    qIT_KykSya,
                    qIT_HhknSya) +
                    $WHERE + qIT_HokenSyouken.syono.eq(qIT_KykKihon.syono) +
                    $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
                    $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
                    $AND + qIT_HokenSyouken.tyouhyouymd.eq(pTyouhyouymd) +
                    $ORDER_BY (qIT_KykKihon.syono.asc());


        return em.createJPQL(mainStry, SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean.class).bind(qIT_HokenSyouken, qIT_KykKihon, qIT_KykSya, qIT_HhknSya).getResults();
    }



    public ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(
        BizDate pSyoriYmd, String[] pGyoumuKousinKinouList, String pGyoumuKousinKinou) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_ansyuKihon");


        String sql = $SELECT + $NEW(HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.class,
            qIT_KykKihon,
            qIT_KhTtdkRireki,
            qIT_KykSyouhn,
            qIT_HhknSya,
            qIT_KykDairiten,
            qIT_KykSonotaTkyk,
            qIT_KykSya,
            qIT_AnsyuKihon) +
            $FROM (
                qIT_KykKihon,
                qIT_KhTtdkRireki,
                qIT_KykSyouhn,
                qIT_HhknSya,
                qIT_KykDairiten,
                qIT_KykSonotaTkyk,
                qIT_KykSya,
                qIT_AnsyuKihon) +
                $WHERE + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
                $AND + "(" + qIT_KhTtdkRireki.gyoumuKousinKinou.in(pGyoumuKousinKinouList) +
                $OR + "(" + qIT_KhTtdkRireki. gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
                $AND + qIT_KhTtdkRireki.syorikbn.in(C_SyoriKbn.SBMUKOU_KIHRKPSHR,
                    C_SyoriKbn.SBMUKOU_SHRNASI,
                    C_SyoriKbn.SBMUKOU,
                    C_SyoriKbn.SBKAIJO,
                    C_SyoriKbn.SBMENSEKI,
                    C_SyoriKbn.SBMENSEKI_SHRNASI,
                    C_SyoriKbn.SIBOU,
                    C_SyoriKbn.SBKYUUHUSHR) + "))" +
                    $AND + qIT_KykKihon.syono.eq(qIT_KhTtdkRireki.syono) +
                    $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                    $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                    $AND + qIT_KykKihon.syono.eq(qIT_KykDairiten.syono) +
                    $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                    $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                    $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                    $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);


        return em.createJPQL(sql, HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.class).bind(qIT_KykKihon,qIT_KhTtdkRireki,qIT_KykSyouhn,qIT_HhknSya,qIT_KykDairiten,qIT_KykSonotaTkyk, qIT_KykSya, qIT_AnsyuKihon).getResults();
    }

    public Long getKeiyakuInfoCountByItems(BizDateYM pKykym, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn,
        String pKyknmkj, BizDate pKykseiymd, String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj,
        BizDate pHhknseiymd, String pDrtencd) {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");


        QIT_KykDairiten qIT_KykDairiten1 = new QIT_KykDairiten("qIT_KykDairiten1");


        QIT_KykDairiten qIT_KykDairiten2 = new QIT_KykDairiten("qIT_KykDairiten2");


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");


        String subquery = "";


        String mainquery = "";


        if (!StringUtil.isNullOrBlank(pDrtencd)) {
            subquery = $AND + qIT_KykDairiten1.drtencd.eq(pDrtencd);
        }


        String subQuerry = $SELECT + $MIN(qIT_KykDairiten1.drtenrenno) +
            $FROM(qIT_KykDairiten1) +
            $WHERE + qIT_KykDairiten1.syono.eq(qIT_KykDairiten2.syono) +
            subquery;




        if (pKykym != null) {
            mainquery = $AND + qIT_KykSyouhn.kykymd.substring(1, 6).eq(pKykym.toString());
        }


        if (pYuukousyoumetukbn != null && !pYuukousyoumetukbn.eq(C_YuukousyoumetuKbn.BLNK)) {
            mainquery = mainquery + $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(pYuukousyoumetukbn);
        }


        if (!StringUtil.isNullOrBlank(pKyknmkn)) {
            mainquery = mainquery + $AND + qIT_KykSya.kyknmkn.like("%" + pKyknmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pKyknmkj)) {
            mainquery = mainquery + $AND + qIT_KykSya.kyknmkj.like("%" + pKyknmkj + "%");
        }


        if (pKykseiymd != null) {
            mainquery = mainquery + $AND + qIT_KykSya.kykseiymd.eq(pKykseiymd);
        }


        if (!StringUtil.isNullOrBlank(pTelno)) {
            mainquery = mainquery + $AND + $(qIT_KykSya.tsintelno.eq(pTelno) +
                $OR + qIT_KykSya.dai2tsintelno.eq(pTelno));
        }


        if (!StringUtil.isNullOrBlank(pTsinyno)) {
            mainquery = mainquery + $AND + $(qIT_KykSya.tsinyno.eq(pTsinyno));
        }


        if (!StringUtil.isNullOrBlank(pHhknnmkn)) {
            mainquery = mainquery + $AND + qIT_HhknSya.hhknnmkn.like("%" + pHhknnmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pHhknnmkj)) {
            mainquery = mainquery + $AND + qIT_HhknSya.hhknnmkj.like("%" + pHhknnmkj + "%");
        }


        if (pHhknseiymd != null) {
            mainquery = mainquery + $AND + qIT_HhknSya.hhknseiymd.eq(pHhknseiymd);
        }


        String mainQuery = $SELECT + $COUNT(qIT_KykKihon.syono) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KykDairiten2,
                qBM_SyouhnZokusei) +
                $WHERE + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykDairiten2.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykDairiten2.drtenrenno + $EQ + $(subQuerry) +
                $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
                $AND + qBM_SyouhnZokusei.syouhncd.eq(qIT_KykSyouhn.syouhncd) +
                $AND + qBM_SyouhnZokusei.syouhnsdno.eq(qIT_KykSyouhn.syouhnsdno) +
                $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
                mainquery;

        return em.createJPQL(mainQuery).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya, qIT_KykDairiten1, qIT_KykDairiten2, qBM_SyouhnZokusei).getSingleResult();
    }

    public ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> getSmbckykdtlInfosByKakutyoujobcd() {


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_KykSya qIT_KykSa = new QIT_KykSya("qIT_KykSa");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");


        String mainStr = $SELECT +
            qIT_KykKihon + "," +
            qIT_KykSyouhn+ "," +
            qIT_KykSonotaTkyk+ "," +
            qIT_KykSa+ "," +
            qIT_HhknSya + "," +
            qIT_AnsyuKihon +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_KykSa,
                qIT_HhknSya,
                qIT_AnsyuKihon) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU)+
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU)+
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSa.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono);


        return em.createJPQL(mainStr).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSonotaTkyk, qIT_HhknSya, qIT_KykSa, qIT_AnsyuKihon).getResults(SmbckykdtlInfosByKakutyoujobcdBean.class);
    }
}
