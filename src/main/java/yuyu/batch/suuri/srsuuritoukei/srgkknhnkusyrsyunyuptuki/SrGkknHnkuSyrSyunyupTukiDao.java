package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.db.meta.QJT_SiKekka;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;

/**
 * 数理 数理統計 月間変更処理収入Ｐ統計情報作成
 */
public class SrGkknHnkuSyrSyunyupTukiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_NyknJissekiRireki> getNyknJissekiRirekisByNyksyoriymdNykkeiro(BizDate pHyksyoriymdfrom,
        BizDate pHyksyoriymdto, C_Nykkeiro pNykkeiro, Integer pRenNo) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE +qIT_NyknJissekiRireki.nyksyoriymd.gt(pHyksyoriymdfrom) +
            $AND + qIT_NyknJissekiRireki.nyksyoriymd.le(pHyksyoriymdto) +
            $AND + qIT_NyknJissekiRireki.nykkeiro.eq(pNykkeiro) +
            $AND + qIT_NyknJissekiRireki.renno.eq(pRenNo);

        return  exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResults();

    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasHnkuNyukinPBySyoriYmd(BizDate pSyoriYmdFrom,
        BizDate pSyoriYmdTo) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");

        String strSql = $SELECT + qBT_DenpyoData +
            $FROM(qBT_DenpyoData) +
            $WHERE + qBT_DenpyoData.syoriYmd.gt(pSyoriYmdFrom)  +
            $AND + qBT_DenpyoData.syoriYmd.le(pSyoriYmdTo) +
            $AND + $(qBT_DenpyoData.densyskbn.eq(C_DensysKbn.HOZEN) +
                $OR + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.HKSIHARAI)) +
                $AND + $(qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD) +
                    $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU)) +
                    $ORDER_BY (qBT_DenpyoData.denrenno.asc(),
                        qBT_DenpyoData.densyskbn.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qBT_DenpyoData).getResults();
    }

    public IT_KihrkmpSeisanRireki getKihrkmpSeisanRireki(String pSyono, String pHenkousikibetukey,
        C_KiharaiPseisanNaiyouKbn pKiharaiPseisanNaiyouKbn) {

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String strSql = $SELECT + qIT_KihrkmpSeisanRireki +
            $FROM(qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(pSyono) +
            $AND + qIT_KihrkmpSeisanRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KihrkmpSeisanRireki.kihrkpssnaiyoukbn.eq(pKiharaiPseisanNaiyouKbn);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KihrkmpSeisanRireki).getSingleResult();
    }

    public JT_SiKekka getSiKekkaBySyono(String pSyono) {

        QJT_SiKekka qJT_SiKekka = new QJT_SiKekka("qJT_SiKekka");

        String strSql = $SELECT + qJT_SiKekka +
            $FROM(qJT_SiKekka) +
            $WHERE + qJT_SiKekka.syono.eq(pSyono);

        return exDBEntityManager.createJPQL(strSql).bind(qJT_SiKekka).getSingleResult();
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoNyktrksdenno(String pSyono,
        String pNyktrksdenno) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.nyktrksdenno.eq(pNyktrksdenno) +
            $ORDER_BY (qIT_NyknJissekiRireki.jyutoustartym.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResultList();
    }

    public IT_Zennou getZennou(String pSyono, BizDate pZennoukaisiymd, Integer pRenno) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String strSql = $SELECT + qIT_Zennou +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono) +
            $AND + qIT_Zennou.zennoukaisiymd.eq(pZennoukaisiymd) +
            $AND + qIT_Zennou.renno.eq(pRenno);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Zennou).getSingleResult();
    }

    public List<JT_SkKihon> getSkKihons(String pSyono, C_SeikyuuSyubetu pSeikyuuSyubetu) {

        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");

        String strSql = $SELECT + qJT_SkKihon +
            $FROM(qJT_SkKihon) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(pSeikyuuSyubetu) +
            $ORDER_BY (qJT_SkKihon.skno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qJT_SkKihon).getResultList();
    }

    public List<JT_Sk> getSks(String pSkno, String pSyono) {

        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");

        String strSql = $SELECT + qJT_Sk +
            $FROM(qJT_Sk) +
            $WHERE + qJT_Sk.skno.eq(pSkno) +
            $AND + qJT_Sk.syono.eq(pSyono) +
            $ORDER_BY (qJT_Sk.seikyuurirekino.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qJT_Sk).getResultList();
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekis(String pSyono, BizDate pSyoriYmd, String pGyoumuKousinKinou) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM(qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $ORDER_BY (qIT_KhTtdkRireki.henkousikibetukey.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki).getResultList();
    }
}
