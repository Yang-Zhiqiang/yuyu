package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.meta.QST_SkOikmKaikei;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;

/**
 * 新契約追込会計取引データテーブル(ST_SkOikmKaikeiDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SkOikmKaikeiDao extends AbstractDao<ST_SkOikmKaikei> {

    public ST_SkOikmKaikeiDao() {
        super(ST_SkOikmKaikei.class);
    }

    public ST_SkOikmKaikei getSkOikmKaikei(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        ST_SkOikmKaikei sT_SkOikmKaikei =  new ST_SkOikmKaikei();
        sT_SkOikmKaikei.setDensyskbn(pDensyskbn);
        sT_SkOikmKaikei.setDenrenno(pDenrenno);
        sT_SkOikmKaikei.setEdano(pEdano);
        return this.selectOne(sT_SkOikmKaikei);
    }

    public ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(
        BizDate pDenymd, BizDate pSyoriYmd) {


        QST_SkOikmKaikei qST_SkOikmKaikei = new QST_SkOikmKaikei("qST_SkOikmKaikei");

        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("qBM_KanjyouKamoku");


        String queryStr = $SELECT + $NEW(SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.class,
            qST_SkOikmKaikei.mosno,
            qST_SkOikmKaikei.kanjyoukmkcd,
            qST_SkOikmKaikei.taisyakukbn,
            qST_SkOikmKaikei.naibukeiyakukbn,
            qST_SkOikmKaikei.tekiyoukbn,
            qST_SkOikmKaikei.seg1cd,
            qST_SkOikmKaikei.huridenatesakicd,
            qST_SkOikmKaikei.tantocd,
            qST_SkOikmKaikei.suitoubumoncd,
            qST_SkOikmKaikei.denyenkagk.getTypeFieldName(),
            qST_SkOikmKaikei.denyenkagk.getValueFieldName(),
            qBM_KanjyouKamoku.denkanjokamokucd) +
            $FROM(qST_SkOikmKaikei) +
            $LEFT_OUTER_JOIN + qST_SkOikmKaikei.BM_KanjyouKamoku() +
            $AS + qBM_KanjyouKamoku +
            $WHERE +$( qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.FP_GNKHRKM) +
                $OR + qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.FP_ONLINENYKN) +
                $OR + qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.FP_CREDITNYKN) +
                $OR + qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.SEIRITU) +
                $OR + qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.FP_HNKNKB) +
                $OR + qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.FP_KKN)) +
                $AND + qST_SkOikmKaikei.denymd.ge(pDenymd) +
                $AND + qST_SkOikmKaikei.syoriYmd.le(pSyoriYmd) +
                $ORDER_BY(qST_SkOikmKaikei.mosno.asc() + "," +
                    qST_SkOikmKaikei.kanjyoukmkcd.asc() + "," +
                    qST_SkOikmKaikei.naibukeiyakukbn.asc() + "," +
                    qST_SkOikmKaikei.tekiyoukbn.asc() + "," +
                    qST_SkOikmKaikei.seg1cd.asc() + "," +
                    qST_SkOikmKaikei.huridenatesakicd.asc() + "," +
                    qST_SkOikmKaikei.tantocd.asc() + "," +
                    qST_SkOikmKaikei.suitoubumoncd.asc() + "," +
                    qST_SkOikmKaikei.taisyakukbn.asc());

        return em.createJPQL(queryStr, SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.class).bind(qST_SkOikmKaikei, qBM_KanjyouKamoku).getResults();
    }

    public ExDBResults<ST_SkOikmKaikei> getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd) {


        QST_SkOikmKaikei qST_SkOikmKaikei = new QST_SkOikmKaikei();

        String queryStr = $SELECT + qST_SkOikmKaikei +
            $FROM + qST_SkOikmKaikei.ST_SkOikmKaikei() +
            $WHERE + qST_SkOikmKaikei.densyorikbn.eq(C_DensyoriKbn.SEIRITU) +
            $AND  + "(" + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD) +
            $OR  + qST_SkOikmKaikei.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU) + ")" +
            $AND + qST_SkOikmKaikei.denymd.ge(pDenymd) +
            $AND + qST_SkOikmKaikei.syoriYmd.le(pSyoriYmd);

        return em.createJPQL(queryStr).bind(qST_SkOikmKaikei).getResults();
    }
}
