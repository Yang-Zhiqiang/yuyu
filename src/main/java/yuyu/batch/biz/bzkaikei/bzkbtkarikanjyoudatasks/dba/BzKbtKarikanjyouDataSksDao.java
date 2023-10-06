package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoudatasks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QBT_KbtKarikanjyou;
import yuyu.def.db.meta.QIT_NyuukinKakusyouData;

/**
 * 業務共通 経理･会計 個別仮勘定データ作成DAOクラスです。<br />
 */
public class BzKbtKarikanjyouDataSksDao {

    @Inject
    private ExDBEntityManager em;

    public ExDBResults<KbtKarikanjyouKrDenpyoDataBean> getKbtKarikanjyouKrDenpyoDataBeans(BizDate pDenymdFrom,
        BizDate pDenymdTo) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");
        QIT_NyuukinKakusyouData qIT_NyuukinKakusyouData = new QIT_NyuukinKakusyouData("qIT_NyuukinKakusyouData");
        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("qBM_KanjyouKamoku");

        String strSql = $SELECT + $NEW(KbtKarikanjyouKrDenpyoDataBean.class,
            qBT_DenpyoData.densyskbn,
            qBT_DenpyoData.denrenno,
            qBT_DenpyoData.edano,
            qBT_DenpyoData.keirisyono,
            qBT_DenpyoData.syoriYmd,
            qBT_DenpyoData.denymd,
            qBT_DenpyoData.huridenatesakicd,
            qBT_DenpyoData.taisyakukbn,
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            qBT_DenpyoData.denyenkagk.getValueFieldName(),
            qBT_DenpyoData.syoricd,
            qBT_DenpyoData.syorisosikicd,
            qBT_DenpyoData.seg1cd,
            qIT_NyuukinKakusyouData.nyuukinkakusyouno,
            qBM_KanjyouKamoku.denkanjokamokucd) +
            $FROM(qBT_DenpyoData, qBM_KanjyouKamoku) +
            $LEFT_OUTER_JOIN + qBT_DenpyoData.IT_NyuukinKakusyouData() +
            $AS + qIT_NyuukinKakusyouData +
            $WHERE + qBT_DenpyoData.denymd.ge(pDenymdFrom) +
            $AND + qBT_DenpyoData.denymd.le(pDenymdTo) +
            $AND + "(" + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY) +
            $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD) +
            $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD) +
            $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU) + ")" +
            $AND + qBM_KanjyouKamoku.kanjyoukmkcd.eq(qBT_DenpyoData.kanjyoukmkcd);

        return em.createJPQL(strSql, KbtKarikanjyouKrDenpyoDataBean.class)
            .bind(qBT_DenpyoData, qIT_NyuukinKakusyouData, qBM_KanjyouKamoku).getResults();
    }

    public BizNumber getKbtKarikanjyouSkbtkeyMax() {

        QBT_KbtKarikanjyou qBT_KbtKarikanjyou = new QBT_KbtKarikanjyou("qBT_KbtKarikanjyou");

        String strSql = $SELECT + $MAX(qBT_KbtKarikanjyou.kbtkarikanjyouskbtkey) +
            $FROM(qBT_KbtKarikanjyou);

        return em.createJPQL(strSql).bind(qBT_KbtKarikanjyou).getSingleResult();
    }
}
