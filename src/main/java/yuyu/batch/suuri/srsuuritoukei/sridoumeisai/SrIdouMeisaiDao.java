package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QSV_IdouMeisai;

/**
 * 異動明細情報作成DAOクラスです。
 */
public class SrIdouMeisaiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_IdouMeisai> getIdouMeisaisBySyoriYmdSyutkkbn(BizDate pZenkaidensimeymd, BizDate pKonkaidensimeymd, C_SyutkKbn pSyutkkbn) {

        QSV_IdouMeisai qSV_IdouMeisai = new QSV_IdouMeisai();

        String strSql = $SELECT + qSV_IdouMeisai +
            $FROM(qSV_IdouMeisai) +
            $WHERE + "(((" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.KYKTORIKESI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.KYKTORIKESI)+ ")" +
            $OR + "(" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.CLGOFF) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.CLGOFF)+ ")" +
            $OR + "(" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.KAIJO) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.KAIJO)+ ")" +
            $OR + "(" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.MUKOU) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.MUKOU)+ ")" +
            $OR + "(" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.SBKAIJO) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.SBKAIJO)+ ")" +
            $OR + "(" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.MENSEKI) +
            $AND + "(" + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.SBMENSEKI) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.SBMENSEKI_SHRNASI)+ "))" +
            $OR + "(" + qSV_IdouMeisai.syoumetujiyuu.eq(C_Syoumetujiyuu.SBMUKOU) +
            $AND + "(" + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.SBMUKOU_KIHRKPSHR) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.SBMUKOU_SHRNASI) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.SBMUKOU)+ "))" +
            $OR + "(" + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KAIYAKU) +
            $AND + qSV_IdouMeisai.syoumetujiyuu.ne(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM) + ")" +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU) +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_GENGAKU) +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI) +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU) +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU) +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK) +
            $OR + "(" +
            qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI) + ")" +
            $OR + "(" +
            qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI) + ")" +
            $OR + "(" +
            qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_TORIKESI) + ")" +
            $OR + "(" +
            qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_ITEN) + ")" +
            $OR + "(" +
            qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI) + ")" +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU) + ")" +
            $OR + "(" +
            qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU) +
            $AND + "(" + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.KAISUUHENKOU) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.CRECAHENNYUU) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.YOHURIHENNYUU) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TIKIKTSYURUIHENKOU_CRECAHENNYUU) +
            $OR + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TIKIKTSYURUIHENKOU_YOHURIHENNYUU) + ")" + ")" +
            $OR + "(" + qSV_IdouMeisai.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
            $AND + qSV_IdouMeisai.shrkekkakbn.ne(C_ShrKekkaKbn.BLNK) +
            $AND + qSV_IdouMeisai.shrkekkakbn.ne(C_ShrKekkaKbn.HSHR) + ")" + ")" +
            $AND + qSV_IdouMeisai.syoriYmd.gt(pZenkaidensimeymd) +
            $AND + qSV_IdouMeisai.syoriYmd.le(pKonkaidensimeymd) +
            $AND + qSV_IdouMeisai.syutkkbn.eq(pSyutkkbn) +
            $ORDER_BY (qSV_IdouMeisai.syoriYmd.asc(),
                qSV_IdouMeisai.syono.asc(),
                qSV_IdouMeisai.gyoumuKousinTime.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qSV_IdouMeisai).getResults();
    }


    public BT_DenpyoData getDenpyoDataDenYmd(String pSyono, BizDate pSyoriYmd) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM (qBT_DenpyoData) +
            $WHERE + qBT_DenpyoData.keirisyono.eq(pSyono) +
            $AND + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);

        return exDBEntityManager.createJPQL(queryStr).setFirstResult(0).setMaxResults(1).bind(qBT_DenpyoData).getSingleResult();
    }

    public BT_DenpyoData getDenpyoDataDenYenkagk(String pSyono, BizDate pSyoriYmd) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM (qBT_DenpyoData) +
            $WHERE + qBT_DenpyoData.keirisyono.eq(pSyono) +
            $AND + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + $(qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUHOKENKIN_HUTUU) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_AUD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_HUTUU) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_AUD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_AUD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_HUTUU) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_AUD));

        return exDBEntityManager.createJPQL(queryStr).setFirstResult(0).setMaxResults(1).bind(qBT_DenpyoData).getSingleResult();
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekis(String pSyono, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String queryStr = $SELECT + qIT_KhTtdkRireki +
            $FROM (qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syoriYmd.gt(pSyoriYmdFrom) +
            $AND + qIT_KhTtdkRireki.syoriYmd.le(pSyoriYmdTo) +
            $ORDER_BY(qIT_KhTtdkRireki.syoriYmd.asc(),
                qIT_KhTtdkRireki.gyoumuKousinTime.asc());

        return exDBEntityManager.createJPQL(queryStr).bind(qIT_KhTtdkRireki).getResultList();
    }

    public ExDBResults<SV_IdouMeisai> getIdouMeisaiSokyuukikannai(String pSyono, C_SyutkKbn pSyutkkbn,
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pHenkousikibetukey) {

        QSV_IdouMeisai qSV_IdouMeisai = new QSV_IdouMeisai("qSV_IdouMeisai");

        String strSql = $SELECT + qSV_IdouMeisai +
            $FROM(qSV_IdouMeisai) +
            $WHERE + qSV_IdouMeisai.syono.eq(pSyono) +
            $AND + qSV_IdouMeisai.syutkkbn.eq(pSyutkkbn) +
            $AND + qSV_IdouMeisai.henkousikibetukey.lt(pHenkousikibetukey) +
            $AND + "(((" + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU) +
            $OR + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU) +
            $OR + "(" + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.MOKUHYOUGKWARIHENKOU) + "))" +
            $AND + qSV_IdouMeisai.syoriYmd.gt(pSyoriYmdFrom) +
            $AND + qSV_IdouMeisai.syoriYmd.le(pSyoriYmdTo) +  ")" +
            $OR +  "(((" + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI) + ")" +
            $OR + "(" + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + qSV_IdouMeisai.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_TORIKESI) + "))" +
            $AND + qSV_IdouMeisai.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qSV_IdouMeisai.syoriYmd.le(pSyoriYmdTo) +  "))" +
            $ORDER_BY (qSV_IdouMeisai.syoriYmd.desc(),
                qSV_IdouMeisai.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qSV_IdouMeisai).getResults();
    }

    public ExDBResults<SV_IdouMeisai> getIdouMeisaisSokyuugengaku(String pSyono, C_SyutkKbn pSyutkkbn,
        String pHenkousikibetukey) {

        QSV_IdouMeisai qSV_IdouMeisai = new QSV_IdouMeisai("qSV_IdouMeisai");

        String strSql = $SELECT + qSV_IdouMeisai +
            $FROM(qSV_IdouMeisai) +
            $WHERE + qSV_IdouMeisai.syono.eq(pSyono) +
            $AND + qSV_IdouMeisai.syutkkbn.eq(pSyutkkbn) +
            $AND + qSV_IdouMeisai.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_GENGAKU) +
            $AND  + qSV_IdouMeisai.henkousikibetukey.gt(pHenkousikibetukey) +
            $AND  + qSV_IdouMeisai.syoriYmd.gt(qSV_IdouMeisai.syoruiukeymd) +
            $ORDER_BY (qSV_IdouMeisai.syoriYmd.desc(),
                qSV_IdouMeisai.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qSV_IdouMeisai).getResults();
    }
}
