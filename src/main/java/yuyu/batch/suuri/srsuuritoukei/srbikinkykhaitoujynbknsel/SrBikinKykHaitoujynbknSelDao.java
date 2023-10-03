package yuyu.batch.suuri.srsuuritoukei.srbikinkykhaitoujynbknsel;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.QIT_KhDshrTuki;
import yuyu.def.db.meta.QJT_SiBikinkanri;
import yuyu.def.db.meta.QJT_SiDshrTuki;
import yuyu.def.db.meta.QSV_BikinKykHaitouMeisai;

/**
 * 数理 数理統計 備金契約配当明細情報作成DAOクラス
 */
public class SrBikinKykHaitoujynbknSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_BikinKykHaitouMeisai> getBikinKykHaitouMeisaisByBknrigikbnKessankijyunymd(
        C_BknrigiKbn pBknrigiKbn, BizDate pKessanKijyunYmd) {

        QSV_BikinKykHaitouMeisai qSV_BikinKykHaitouMeisai = new QSV_BikinKykHaitouMeisai("qSV_BikinKykHaitouMeisai");

        String strSql = $SELECT + qSV_BikinKykHaitouMeisai +
            $FROM(qSV_BikinKykHaitouMeisai) +
            $WHERE + qSV_BikinKykHaitouMeisai.bkncdkbn.ne(C_BkncdKbn.GENGK) +
            $AND + qSV_BikinKykHaitouMeisai.bkncdkbn.ne(C_BkncdKbn.YENDTHNKHR) +
            $AND + qSV_BikinKykHaitouMeisai.bknjkukbn.ne(C_BknJkuKbn.BLNK) +
            $AND + qSV_BikinKykHaitouMeisai.bknjkukbn.ne(C_BknJkuKbn.JIKOU) +
            $AND + "(" + qSV_BikinKykHaitouMeisai.bknrigikbn.ne(pBknrigiKbn) +
            $OR + qSV_BikinKykHaitouMeisai.bknrigikbn.isNull()+")" +
            $AND + qSV_BikinKykHaitouMeisai.kessankijyunymd.eq(pKessanKijyunYmd) +
            $ORDER_BY(qSV_BikinKykHaitouMeisai.shrsyoriymd.asc(),
                qSV_BikinKykHaitouMeisai.syono.asc(),
                qSV_BikinKykHaitouMeisai.gyoumuKousinTime.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qSV_BikinKykHaitouMeisai).getResults();
    }

    public List<JT_SiBikinkanri> getSiBikinkanris(String pSkno, String pSyono,
        BizDate pKessankijyunYmd, BizDate pBknkktYmd) {

        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");

        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM(qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.skno.eq(pSkno) +
            $AND + qJT_SiBikinkanri.syono.eq(pSyono) +
            $AND + qJT_SiBikinkanri.kessankijyunymd.eq(pKessankijyunYmd) +
            $AND + qJT_SiBikinkanri.bkncdkbn.eq(C_BkncdKbn.SIBOUUKETUKE) +
            $AND + qJT_SiBikinkanri.bknkktymd.eq(pBknkktYmd) +
            $ORDER_BY(qJT_SiBikinkanri.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qJT_SiBikinkanri).getResultList();
    }

    public List<IT_KhDshrTuki> getKhDshrTukis(String pSyono, C_Syoumetujiyuu pSyoumetujiyuu, String pGyoumuKousinKinou) {

        QIT_KhDshrTuki qIT_KhDshrTuki = new QIT_KhDshrTuki("qIT_KhDshrTuki");

        String joukenhensuu = "";

        if (!C_Syoumetujiyuu.BLNK.eq(pSyoumetujiyuu)) {

            joukenhensuu = joukenhensuu +
                $AND + qIT_KhDshrTuki.syoumetujiyuu.eq(pSyoumetujiyuu);
        }

        String strSql = $SELECT + qIT_KhDshrTuki +
            $FROM(qIT_KhDshrTuki) +
            $WHERE + qIT_KhDshrTuki.syono.eq(pSyono) +
            $AND + qIT_KhDshrTuki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            joukenhensuu +
            $ORDER_BY(qIT_KhDshrTuki.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhDshrTuki).getResultList();
    }

    public List<IT_KhDshrTuki> getKhDshrTukisBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        QIT_KhDshrTuki qIT_KhDshrTuki = new QIT_KhDshrTuki("qIT_KhDshrTuki");

        String strSql = $SELECT + qIT_KhDshrTuki +
            $FROM(qIT_KhDshrTuki) +
            $WHERE + qIT_KhDshrTuki.syono.eq(pSyono) +
            $AND + qIT_KhDshrTuki.henkousikibetukey.eq(pHenkousikibetukey) +
            $ORDER_BY(qIT_KhDshrTuki.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhDshrTuki).getResultList();
    }

    public List<JT_SiDshrTuki> getSiDshrTukis(String pSyono, String pGyoumuKousinKinou) {

        QJT_SiDshrTuki qJT_SiDshrTuki = new QJT_SiDshrTuki("qJT_SiDshrTuki");

        String strSql = $SELECT + qJT_SiDshrTuki +
            $FROM(qJT_SiDshrTuki) +
            $WHERE + qJT_SiDshrTuki.syono.eq(pSyono) +
            $AND + qJT_SiDshrTuki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $ORDER_BY(qJT_SiDshrTuki.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qJT_SiDshrTuki).getResultList();
    }
}
