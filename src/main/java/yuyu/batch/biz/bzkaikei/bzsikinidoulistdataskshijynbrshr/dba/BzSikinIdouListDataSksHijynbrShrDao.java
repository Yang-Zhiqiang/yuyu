package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_JidousoukinHukaRiyuuKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QIT_Azukarikin;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;

/**
 * 業務共通 経理・会計 資金移動リストデータ作成（平準払支払用）機能DAOクラス
 */
public class BzSikinIdouListDataSksHijynbrShrDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SikinIdouListDataHijynbrShrBean> getSikinIdouListDataSksHijynbrShrByKakutyoujobcdSyoriYmd(
        String pKakutyouJobcd, BizDate pSyoriYmd) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");

        QBT_DenpyoData qBT_DenpyoData_Sub = new QBT_DenpyoData("qBT_DenpyoData_Sub");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String subQuery = $SELECT + qBT_DenpyoData_Sub.denrenno +
            $FROM + qBT_DenpyoData_Sub.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData_Sub.densyskbn.eq(qBT_DenpyoData.densyskbn) +
            $AND + qBT_DenpyoData_Sub.denrenno.eq(qBT_DenpyoData.denrenno) +
            $AND + qBT_DenpyoData_Sub.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            $AND + "(" + qBT_DenpyoData_Sub.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN) +
            $OR + qBT_DenpyoData_Sub.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN) + ")";

        String strSql = $SELECT + $NEW(SikinIdouListDataHijynbrShrBean.class,
            qBT_DenpyoData.densyskbn,
            qBT_DenpyoData.denrenno,
            qBT_DenpyoData.edano,
            qBT_DenpyoData.denymd,
            qBT_DenpyoData.kyktuukasyu,
            qBT_DenpyoData.hijynbrsikinidougk.getTypeFieldName(),
            qBT_DenpyoData.hijynbrsikinidougk.getValueFieldName(),
            qBT_DenpyoData.syusyouhncd,
            qBT_DenpyoData.syouhnsdno,
            qBT_DenpyoData.syoricd,
            qBT_DenpyoData.tuukasyu,
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            qBT_DenpyoData.denyenkagk.getValueFieldName(),
            qBT_DenpyoData.dengaikagk.getTypeFieldName(),
            qBT_DenpyoData.dengaikagk.getValueFieldName(),
            qIT_KykKihon.syono) +
            $FROM(qBT_DenpyoData,
                qIT_KykKihon) +
                $WHERE + qBT_DenpyoData.keirisyono.eq(qIT_KykKihon.syono) +
                $AND + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
                $AND + "(" + qBT_DenpyoData.hijynbrsikinidouyoukbn.eq(C_HijynbrsikinidouyouKbn.YOU) +
                $OR + qBT_DenpyoData.hijynbrsikinidouyoukbn.eq(C_HijynbrsikinidouyouKbn.YOUP) + ")" +
                $AND + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KARIKATA) +
                $AND + $EXISTS(subQuery) +
                $ORDER_BY(qBT_DenpyoData.densyskbn.asc(),
                    qBT_DenpyoData.denrenno.asc(),
                    qBT_DenpyoData.edano.asc());

        ExDBResults<SikinIdouListDataHijynbrShrBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, SikinIdouListDataHijynbrShrBean.class).bind(qBT_DenpyoData, qBT_DenpyoData_Sub, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobcd));

        return exDBResults;
    }

    public ExDBResults<SikinIdouListDataHijynbrShrBean> getSikinIdouListDataSksHijynbrShrSkBySyoriYmd(
        BizDate pSyoriYmd) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");

        QBT_DenpyoData qBT_DenpyoData_Sub = new QBT_DenpyoData("qBT_DenpyoData_Sub");

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String subQuery = $SELECT + qBT_DenpyoData_Sub.denrenno +
            $FROM + qBT_DenpyoData_Sub.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData_Sub.densyskbn.eq(qBT_DenpyoData.densyskbn) +
            $AND + qBT_DenpyoData_Sub.denrenno.eq(qBT_DenpyoData.denrenno) +
            $AND + qBT_DenpyoData_Sub.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            $AND + "(" + qBT_DenpyoData_Sub.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN) +
            $OR + qBT_DenpyoData_Sub.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN) + ")";

        String strSql = $SELECT + $NEW(SikinIdouListDataHijynbrShrBean.class,
            qBT_DenpyoData.densyskbn,
            qBT_DenpyoData.denrenno,
            qBT_DenpyoData.edano,
            qBT_DenpyoData.denymd,
            qBT_DenpyoData.kyktuukasyu,
            qBT_DenpyoData.hijynbrsikinidougk.getTypeFieldName(),
            qBT_DenpyoData.hijynbrsikinidougk.getValueFieldName(),
            qBT_DenpyoData.syusyouhncd,
            qBT_DenpyoData.syouhnsdno,
            qBT_DenpyoData.syoricd,
            qBT_DenpyoData.tuukasyu,
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            qBT_DenpyoData.denyenkagk.getValueFieldName(),
            qBT_DenpyoData.dengaikagk.getTypeFieldName(),
            qBT_DenpyoData.dengaikagk.getValueFieldName(),
            "''" + $AS + "syono") +
            $FROM(qBT_DenpyoData,
                qHT_MosKihon) +
                $WHERE + qBT_DenpyoData.keirisyono.eq(qHT_MosKihon.mosno) +
                $AND + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
                $AND + "(" + qBT_DenpyoData.hijynbrsikinidouyoukbn.eq(C_HijynbrsikinidouyouKbn.YOU) +
                $OR + qBT_DenpyoData.hijynbrsikinidouyoukbn.eq(C_HijynbrsikinidouyouKbn.YOUP) + ")" +
                $AND + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KARIKATA) +
                $AND + $EXISTS(subQuery) +
                $ORDER_BY(qBT_DenpyoData.densyskbn.asc(),
                    qBT_DenpyoData.denrenno.asc(),
                    qBT_DenpyoData.edano.asc());

        ExDBResults<SikinIdouListDataHijynbrShrBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, SikinIdouListDataHijynbrShrBean.class).bind(qBT_DenpyoData, qBT_DenpyoData_Sub, qHT_MosKihon).getResults();

        return exDBResults;
    }

    public ExDBResults<GengakuIdouDataBean> getSikinIdouListDataSksHijynbrShrByKakutyoujobcdSyoriYmdGengaku(
        String pKakutyouJobcd, BizDate pSyoriYmd, String pGyoumuKousinKinou) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_Azukarikin qIT_Azukarikin = new QIT_Azukarikin("qIT_Azukarikin");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(GengakuIdouDataBean.class,
            qIT_KhTtdkRireki.syono,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.kyktuukasyu) +
            $FROM(qIT_KhTtdkRireki,
                qIT_Azukarikin,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_Azukarikin.syono) +
                $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_Azukarikin.henkousikibetukey) +
                $AND + qIT_KhTtdkRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
                $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $GROUP_BY + qIT_KhTtdkRireki.syono + "," +
                qIT_KykSyouhn.syouhncd + "," +
                qIT_KykSyouhn.kyktuukasyu;

        ExDBResults<GengakuIdouDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, GengakuIdouDataBean.class)
            .bind(qIT_KhTtdkRireki, qIT_Azukarikin, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobcd));

        return exDBResults;
    }

    public ExDBResults<PMinyuuSymtJidouSkHukaBean> getPMinyuuSymtJidouSkHukaBeans(String pKakutyouJobcd, BizDate pSyoriYmd) {

        QIT_PMinyuuSyoumetuInfo qIT_PMinyuuSyoumetuInfo = new QIT_PMinyuuSyoumetuInfo("qIT_PMinyuuSyoumetuInfo");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(PMinyuuSymtJidouSkHukaBean.class,
            qIT_PMinyuuSyoumetuInfo.syono,
            qIT_PMinyuuSyoumetuInfo.kaiyakuhrknsiteituuka.getTypeFieldName(),
            qIT_PMinyuuSyoumetuInfo.kaiyakuhrknsiteituuka.getValueFieldName(),
            qIT_PMinyuuSyoumetuInfo.zitkazukarikingksiteituuka.getTypeFieldName(),
            qIT_PMinyuuSyoumetuInfo.zitkazukarikingksiteituuka.getValueFieldName(),
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.kyktuukasyu) +
            $FROM(qIT_PMinyuuSyoumetuInfo,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_PMinyuuSyoumetuInfo.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_PMinyuuSyoumetuInfo.syoriYmd.eq(pSyoriYmd) +
                $AND + qIT_PMinyuuSyoumetuInfo.jidousoukinhukariyuu.ne(C_JidousoukinHukaRiyuuKbn.BLNK) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);

        ExDBResults<PMinyuuSymtJidouSkHukaBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, PMinyuuSymtJidouSkHukaBean.class)
            .bind(qIT_PMinyuuSyoumetuInfo, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobcd));

        return exDBResults;
    }

    public GengkKaisiYmZengoPTysytBean getGengkKaisiYmZengoPTysytBean(String pSyono, BizDate pSyoriYmd,
        String pGyoumuKousinKinou, String pTableId, String pKoumokuId) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn("qIT_HokenryouTmttkn");

        String strSql = $SELECT + $NEW(GengkKaisiYmZengoPTysytBean.class,
            qIT_KhHenkouRireki.bfrnaiyou,
            qIT_KhHenkouRireki.newnaiyou,
            $MAX(qIT_HokenryouTmttkn.tmttkntaisyouym)) +
            $FROM(qIT_KhTtdkRireki,
                qIT_KhHenkouRireki,
                qIT_HokenryouTmttkn) +
                $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
                $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey) +
                $AND + qIT_KhTtdkRireki.syono.eq(qIT_HokenryouTmttkn.syono) +
                $AND + qIT_KhTtdkRireki.syono.eq(pSyono) +
                $AND + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
                $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
                $AND + qIT_KhHenkouRireki.tableid.eq(pTableId) +
                $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pKoumokuId) +
                $AND + qIT_HokenryouTmttkn.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
                $GROUP_BY + qIT_KhHenkouRireki.bfrnaiyou + "," +
                qIT_KhHenkouRireki.newnaiyou;

        return exDBEntityManager.createJPQL(strSql, GengkKaisiYmZengoPTysytBean.class)
            .bind(qIT_KhTtdkRireki, qIT_KhHenkouRireki, qIT_HokenryouTmttkn).getSingleResult();
    }

    public List<SikinIdougkTysytBean> getSikinIdougkTysytBeans(String pSyono, BizDateYM pSikinidoupJytYm) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks");

        String strSql = $SELECT + $NEW(SikinIdougkTysytBean.class,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.sikinidoukawaserate) +
            $FROM(qBT_HijynNykSikinIdouListSks) +
            $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(pSyono) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.ge(pSikinidoupJytYm) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUKANRYOU) +
            $ORDER_BY(qBT_HijynNykSikinIdouListSks.sikinidoupjytym.asc());

        return exDBEntityManager.createJPQL(strSql, SikinIdougkTysytBean.class).bind(qBT_HijynNykSikinIdouListSks)
            .getResultList();
    }
}
