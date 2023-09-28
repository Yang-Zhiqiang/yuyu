package yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_Azukarikin;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_KhDenpyoData;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.db.meta.QJT_SiDenpyoData;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;

/**
 * 業務共通 経理・会計 平準払資金移動データ抽出の機能DAOクラスです
 */
public class BzHijynbrSikinIdouDataTysytDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SkDenrennoBean> getSkDenrennoBeans(BizDate pSyoriYmd) {

        QHT_SkDenpyoData qHT_SkDenpyoData1 = new QHT_SkDenpyoData("qHT_SkDenpyoData1");
        QHT_SkDenpyoData qHT_SkDenpyoData2 = new QHT_SkDenpyoData("qHT_SkDenpyoData2");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String querry2 = $SELECT + qHT_SkDenpyoData2.denrenno +
            $FROM(qHT_SkDenpyoData2) +
            $WHERE + qHT_SkDenpyoData2.densyskbn.eq(qHT_SkDenpyoData1.densyskbn) +
            $AND + qHT_SkDenpyoData2.denrenno.eq(qHT_SkDenpyoData1.denrenno) +
            $AND + qHT_SkDenpyoData2.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            $AND + $(qHT_SkDenpyoData2.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN) +
                $OR + qHT_SkDenpyoData2.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN));

        String querry3 = $SELECT + qHT_MosKihon.mosno +
            $FROM(qHT_MosKihon) +
            $WHERE + qHT_MosKihon.mosno.eq(qHT_SkDenpyoData1.mosno) +
            $AND + qHT_MosKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
            $AND + qHT_MosKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI);

        String querry4 = $SELECT + qIT_KykKihon.syono +
            $FROM(qIT_KykKihon) +
            $WHERE + qIT_KykKihon.syono.eq(qHT_SkDenpyoData1.syono) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI);

        String sql = $SELECT_DISTINCT + $NEW(SkDenrennoBean.class,
            qHT_SkDenpyoData1.denrenno) +
            $FROM(qHT_SkDenpyoData1) +
            $WHERE + qHT_SkDenpyoData1.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_SkDenpyoData1.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
            $AND + qHT_SkDenpyoData1.kyktuukasyu.ne(C_Tuukasyu.JPY) +
            $AND + $EXISTS(querry2) +
            $AND + $( $EXISTS(querry3) +
                $OR  + $( $NOT_EXISTS(querry3) +
                    $AND + $EXISTS(querry4) )) +
                    $ORDER_BY(qHT_SkDenpyoData1.denrenno.asc());

        return exDBEntityManager.createJPQL(sql, SkDenrennoBean.class).bind(
            qHT_SkDenpyoData1, qHT_SkDenpyoData2, qHT_MosKihon, qIT_KykKihon).getResults();
    }

    public ExDBResults<KhDenrennoBean> getKhDenrennoBeans(BizDate pSyoriYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KhDenpyoData qIT_KhDenpyoData = new QIT_KhDenpyoData("qIT_KhDenpyoData");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String sql = $SELECT_DISTINCT + $NEW(KhDenrennoBean.class,
            qIT_KhDenpyoData.denrenno) +
            $FROM(qIT_KykKihon, qIT_KhDenpyoData, qIT_KykSyouhn) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KhDenpyoData.syono) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KhDenpyoData.syono) +
            $AND + qIT_KhDenpyoData.syoriYmd.eq(pSyoriYmd)  +
            $AND + qIT_KhDenpyoData.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
            $AND + qIT_KhDenpyoData.kyktuukasyu.ne(C_Tuukasyu.JPY) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
            $AND + $(qIT_KhDenpyoData.syoricd.ne("RB30") +
                $OR +  qIT_KykSyouhn.syoumetujiyuu.ne(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM)) +
                $AND + qIT_KhDenpyoData.kanjyoukmkcd.in(
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SONOTA) +
                    $ORDER_BY(qIT_KhDenpyoData.denrenno.asc());

        return exDBEntityManager.createJPQL(sql, KhDenrennoBean.class).bind(qIT_KykKihon, qIT_KhDenpyoData, qIT_KykSyouhn).getResults();
    }

    public ExDBResults<SiDenrennoBean> getSiDenrennoBeans(BizDate pSyoriYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QJT_SiDenpyoData qJT_SiDenpyoData = new QJT_SiDenpyoData("qJT_SiDenpyoData");

        String sql = $SELECT_DISTINCT + $NEW(SiDenrennoBean.class,
            qJT_SiDenpyoData.denrenno) +
            $FROM(qIT_KykKihon, qJT_SiDenpyoData) +
            $WHERE + qIT_KykKihon.syono.eq(qJT_SiDenpyoData.syono) +
            $AND + qJT_SiDenpyoData.syoriYmd.eq(pSyoriYmd)  +
            $AND + qJT_SiDenpyoData.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
            $AND + qJT_SiDenpyoData.kyktuukasyu.ne(C_Tuukasyu.JPY) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
            $AND + qJT_SiDenpyoData.kanjyoukmkcd.in(
                C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
                C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
                C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
                C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY,
                C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD,
                C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD) +
                $ORDER_BY(qJT_SiDenpyoData.denrenno.asc());

        return exDBEntityManager.createJPQL(sql, SiDenrennoBean.class).bind(qIT_KykKihon, qJT_SiDenpyoData).getResults();
    }

    public List<PZenhnjiSikinIdougkTysytBean> getPZenhnjiSikinIdougkTysytBeans(String pSyono,
        String pDenrenno) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");
        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks("qBT_HijynNykSikinIdouListSks");

        String sql = $SELECT + $NEW(PZenhnjiSikinIdougkTysytBean.class,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName()) +
            $FROM(qIT_KhShrRireki, qBT_HijynNykSikinIdouListSks) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.denrenno.eq(pDenrenno)  +
            $AND + $(qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.KYKTORIKESI) +
                $OR + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.CLGOFF) +
                $OR + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.SBMUKOU_KIHRKPSHR)) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUKANRYOU) +
                $AND + qIT_KhShrRireki.syono.eq(qBT_HijynNykSikinIdouListSks.syono) +
                $ORDER_BY(qBT_HijynNykSikinIdouListSks.sikinidoupjytym.asc());

        return exDBEntityManager.createJPQL(sql, PZenhnjiSikinIdougkTysytBean.class)
            .bind(qIT_KhShrRireki, qBT_HijynNykSikinIdouListSks).getResultList();
    }

    public BizDateYM getKihrkmpSeisanRirekiJyuutouym(String pSyono,
        String pDenrenno) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");
        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String sql = $SELECT + qIT_KihrkmpSeisanRireki.jyuutouym +
            $FROM(qIT_KhShrRireki, qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.denrenno.eq(pDenrenno) +
            $AND + qIT_KihrkmpSeisanRireki.kihrkpssnaiyoukbn.eq(C_KiharaiPseisanNaiyouKbn.SEISANP) +
            $AND + qIT_KihrkmpSeisanRireki.misyuumikeikakbn.eq(C_MisyuumikeikaKbn.MIKEIKAP) +
            $AND + qIT_KhShrRireki.syono.eq(qIT_KihrkmpSeisanRireki.syono) +
            $AND + qIT_KhShrRireki.henkousikibetukey.eq(qIT_KihrkmpSeisanRireki.henkousikibetukey);

        return exDBEntityManager.createJPQL(sql).bind(qIT_KhShrRireki, qIT_KihrkmpSeisanRireki).getSingleResult();
    }

    public String getKihrkmpSeisanRirekiSyono(String pSyono,
        String pDenrenno) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");
        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String sql = $SELECT + qIT_KihrkmpSeisanRireki.syono +
            $FROM(qIT_KhShrRireki, qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.denrenno.eq(pDenrenno) +
            $AND + qIT_KihrkmpSeisanRireki.kihrkpssnaiyoukbn.eq(C_KiharaiPseisanNaiyouKbn.SEISANP) +
            $AND + qIT_KihrkmpSeisanRireki.misyuumikeikakbn.eq(C_MisyuumikeikaKbn.MIKEIKAP) +
            $AND + qIT_KhShrRireki.syono.eq(qIT_KihrkmpSeisanRireki.syono) +
            $AND + qIT_KhShrRireki.henkousikibetukey.eq(qIT_KihrkmpSeisanRireki.henkousikibetukey);

        return exDBEntityManager.createJPQL(sql).bind(qIT_KhShrRireki, qIT_KihrkmpSeisanRireki).getSingleResult();
    }

    public SkDataTysytBean getSkDataTysytBeans(String pSyono) {

        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");
        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");

        String subSql = $SELECT + $MAX(qJT_Sk.seikyuurirekino) +
            $FROM(qJT_SkKihon, qJT_Sk) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
            $AND + qJT_SkKihon.syono.eq(qJT_Sk.syono);

        String sql = $SELECT + $NEW(SkDataTysytBean.class,
            qJT_Sk.mikeikapjyuutouym,
            qJT_Sk.zitkazukarikingksiteituuka.getTypeFieldName(),
            qJT_Sk.zitkazukarikingksiteituuka.getValueFieldName(),
            qJT_Sk.misyuup.getTypeFieldName(),
            qJT_Sk.misyuup.getValueFieldName()) +
            $FROM(qJT_SkKihon, qJT_Sk) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
            $AND + qJT_Sk.seikyuurirekino + $EQ + $(subSql) +
            $AND + qJT_SkKihon.syono.eq(qJT_Sk.syono);

        return exDBEntityManager.createJPQL(sql, SkDataTysytBean.class).bind(qJT_SkKihon, qJT_Sk).getSingleResult();
    }

    public String getSkSyono(String pSyono) {

        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");
        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");

        String subSql = $SELECT + $MAX(qJT_Sk.seikyuurirekino) +
            $FROM(qJT_SkKihon, qJT_Sk) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
            $AND + $ (
                qJT_Sk.yenkamikeikap.ne(BizCurrency.valueOf(0)) +
                $OR + qJT_Sk.yenkazennouseisankgk.ne(BizCurrency.valueOf(0))) +
                $AND + qJT_SkKihon.syono.eq(qJT_Sk.syono);

        String sql = $SELECT + qJT_Sk.syono +
            $FROM(qJT_SkKihon, qJT_Sk) +
            $WHERE + qJT_SkKihon.syono.eq(pSyono) +
            $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
            $AND + qJT_Sk.seikyuurirekino + $EQ + $(subSql) +
            $AND + $(qJT_Sk.yenkamikeikap.ne(BizCurrency.valueOf(0)) +
                $OR + qJT_Sk.yenkazennouseisankgk.ne(BizCurrency.valueOf(0))) +
                $AND + qJT_SkKihon.syono.eq(qJT_Sk.syono);

        return exDBEntityManager.createJPQL(sql).bind(qJT_SkKihon, qJT_Sk).getSingleResult();
    }

    public BizDate getZennouZennouSeisanKijyunymd(String pSyono) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String subSql = $SELECT + $MAX(qIT_Zennou.renno) +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono);

        String sql = $SELECT + qIT_Zennou.zennouseisankijyunymd +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono) +
            $AND + qIT_Zennou.renno + $EQ + $(subSql);

        return exDBEntityManager.createJPQL(sql).bind(qIT_Zennou).getSingleResult();
    }

    public BizDateYM getHokenryouTmttknTmttknTaisyouymMax(String pSyono, String pGyoumuKousinKinou) {

        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn("qIT_HokenryouTmttkn");
        String sql = $SELECT + $MAX(qIT_HokenryouTmttkn.tmttkntaisyouym) +
            $FROM(qIT_HokenryouTmttkn) +
            $WHERE + qIT_HokenryouTmttkn.syono.eq(pSyono) +
            $AND + qIT_HokenryouTmttkn.gyoumuKousinKinou.eq(pGyoumuKousinKinou);

        return exDBEntityManager.createJPQL(sql).bind(qIT_HokenryouTmttkn).getSingleResult();
    }

    public BizCurrency getKhShrRirekiZitkAzukarikingkSiteituuka(String pSyono, String pDenrenno) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String sql = $SELECT + $NEW(BizCurrencySum.class,
            qIT_KhShrRireki.zitkazukarikingksiteituuka.getTypeFieldName(),
            qIT_KhShrRireki.zitkazukarikingksiteituuka.getValueFieldName()) +
            $FROM(qIT_KhShrRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.denrenno.eq(pDenrenno);

        BizCurrencySum bs = exDBEntityManager.createJPQL(sql, BizCurrencySum.class)
            .bind(qIT_KhShrRireki).getSingleResult();

        if (bs == null) {

            return null;
        }
        return bs.toBizCurrency();
    }

    public BizCurrency getKhShrRirekiSyuShrgkkei(String pSyono, String pDenrenno) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String sql = $SELECT + $NEW(BizCurrencySum.class,
            qIT_KhShrRireki.syushrgkkei.getTypeFieldName(),
            qIT_KhShrRireki.syushrgkkei.getValueFieldName()) +
            $FROM(qIT_KhShrRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.denrenno.eq(pDenrenno) +
            $AND + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.SBMENSEKI);

        BizCurrencySum bs = exDBEntityManager.createJPQL(sql, BizCurrencySum.class)
            .bind(qIT_KhShrRireki).getSingleResult();

        if (bs == null) {

            return null;
        }
        return bs.toBizCurrency();
    }

    public List<SikinIdougkTysytBean> getSikinIdougkTysytBeans(String pSyono, BizDateYM pSikinidoupjytym) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks("qBT_HijynNykSikinIdouListSks");

        String sql = $SELECT + $NEW(SikinIdougkTysytBean.class,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.sikinidoukawaserate) +
            $FROM(qBT_HijynNykSikinIdouListSks) +
            $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(pSyono) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.ge(pSikinidoupjytym) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUKANRYOU) +
            $ORDER_BY(qBT_HijynNykSikinIdouListSks.sikinidoupjytym.asc());

        return exDBEntityManager.createJPQL(sql, SikinIdougkTysytBean.class)
            .bind(qBT_HijynNykSikinIdouListSks).getResultList();
    }

    public GengkZengoPTysytBean getGengkZengoPTysytBean(String pSyono, BizDate pSyoriYmd, String pGyoumuKousinKinou,
        String pTableid, String pKoumokuid) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");
        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String sql = $SELECT + $NEW(GengkZengoPTysytBean.class,
            qIT_KhHenkouRireki.bfrnaiyou,
            qIT_KhHenkouRireki.newnaiyou) +
            $FROM(qIT_KhTtdkRireki, qIT_KhHenkouRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pKoumokuid) +
            $AND + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey);

        return exDBEntityManager.createJPQL(sql, GengkZengoPTysytBean.class)
            .bind(qIT_KhTtdkRireki, qIT_KhHenkouRireki).getSingleResult();

    }

    public BizDate getKykSyouhnKykymd(String pSyono) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String sql = $SELECT + qIT_KykSyouhn.kykymd +
            $FROM(qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);

        return exDBEntityManager.createJPQL(sql).bind(qIT_KykSyouhn).getSingleResult();
    }

    public String getAzukarikinSyono(String pSyono) {

        QIT_Azukarikin qIT_Azukarikin = new QIT_Azukarikin("qIT_Azukarikin");

        String sql = $SELECT_DISTINCT + qIT_Azukarikin.syono +
            $FROM(qIT_Azukarikin) +
            $WHERE + qIT_Azukarikin.syono.eq(pSyono);

        return exDBEntityManager.createJPQL(sql).bind(qIT_Azukarikin).getSingleResult();
    }

    public String getKhShrRirekiSyono(String pSyono, String pDenrenno) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String sql = $SELECT + qIT_KhShrRireki.syono +
            $FROM(qIT_KhShrRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.denrenno.eq(pDenrenno) +
            $AND + qIT_KhShrRireki.yenzennomikeikap.gtZero();

        return exDBEntityManager.createJPQL(sql).bind(qIT_KhShrRireki).getSingleResult();
    }

    public BizDateYM getNyktrksJkiPJytYM(String pSyono, BizDate pSyoriYmd) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki2 = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki2");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");


        String subqueryStr = $SELECT + qIT_NyknJissekiRireki2.syono +
            $FROM(qIT_NyknJissekiRireki2) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(qIT_NyknJissekiRireki2.syono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_NyknJissekiRireki2.jyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.lt(qIT_NyknJissekiRireki2.renno);


        String sql = $SELECT + qIT_AnsyuKihon.jkipjytym +
            $FROM(qIT_NyknJissekiRireki,
                qIT_KykKihon,
                qIT_AnsyuKihon,
                qIT_KykSyouhn,
                qBM_SyouhnZokusei ) +
                $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
                $AND + qIT_NyknJissekiRireki.nyktrksymd.eq(pSyoriYmd) +
                $AND + qIT_NyknJissekiRireki.nykkeiro.ne(C_Nykkeiro.HKNKIN) +
                $AND + qIT_NyknJissekiRireki.nykkeiro.ne(C_Nykkeiro.KYHKIN) +
                $AND + $(
                    qIT_NyknJissekiRireki.nyknaiyoukbn.ne(C_NyknaiyouKbn.ZENNOUP) +
                    $OR + qIT_NyknJissekiRireki.nyktrksflg.ne(C_Nyktrksflg.TORIKESI)) +
                    $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
                    $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                    $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                    $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                    $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                    $AND + $NOT_EXISTS(subqueryStr) +
                    $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KykKihon.syono) +
                    $AND + qIT_NyknJissekiRireki.syono.eq(qIT_AnsyuKihon.syono) +
                    $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KykSyouhn.syono) +
                    $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                    $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno);



        return exDBEntityManager.createJPQL(sql).bind(qIT_NyknJissekiRireki, qIT_NyknJissekiRireki2,
            qIT_KykKihon, qIT_AnsyuKihon, qIT_KykSyouhn, qBM_SyouhnZokusei).getSingleResult();
    }
}
