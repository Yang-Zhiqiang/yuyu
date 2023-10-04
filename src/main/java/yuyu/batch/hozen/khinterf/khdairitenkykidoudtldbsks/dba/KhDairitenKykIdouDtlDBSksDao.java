package yuyu.batch.hozen.khinterf.khdairitenkykidoudtldbsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;

/**
 * 代理店契約異動明細ＤＢ作成DAOクラスです。
 */
public class KhDairitenKykIdouDtlDBSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KhTtdkRireki> getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(String pKakutyoujobcd, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");
        QIT_KhTtdkRireki qIT_KhTtdkRireki1 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki1");
        QIT_KhTtdkRireki qIT_KhTtdkRireki2 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki2");
        QIT_KhTtdkRireki qIT_KhTtdkRireki3 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki3");
        QIT_KhTtdkRireki qIT_KhTtdkRireki4 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki4");
        QIT_KhTtdkRireki qIT_KhTtdkRireki5 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki5");
        QIT_KhTtdkRireki qIT_KhTtdkRireki6 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki6");
        QIT_KhTtdkRireki qIT_KhTtdkRireki7 = new QIT_KhTtdkRireki("qIT_KhTtdkRireki7");

        String strSubSql1 = $SELECT + qIT_KhTtdkRireki1.syono +
            $FROM + qIT_KhTtdkRireki1.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki1.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki1.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki1.gyoumuKousinKinou.in(
                IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU,
                IKhozenCommonConstants.KINOUID_MEIGIHENKOU,
                IKhozenCommonConstants.KINOUID_KAIYAKU,
                IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU,
                IKhozenCommonConstants.KINOUID_GENGAKU,
                IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA,
                IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU,
                IKhozenCommonConstants.KINOUID_SEINENGAPPISEI,
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK,
                IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU,
                IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN,
                IKhozenCommonConstants.KINOUID_DATTAI,
                IKhozenCommonConstants.KINOUID_ONLINEDATTAI,
                IKhozenCommonConstants.KINOUID_KZSEIBI,
                IKhozenCommonConstants.KINOUID_DSHR,
                IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU,
                IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK);

        String strSubSql2 = $SELECT + qIT_KhTtdkRireki2.syono +
            $FROM + qIT_KhTtdkRireki2.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki2.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki2.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki2.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI) +
            $AND + qIT_KhTtdkRireki2.syorikbn.in(
                C_SyoriKbn.CLGOFF,
                C_SyoriKbn.KYKTORIKESI,
                C_SyoriKbn.KAIJO,
                C_SyoriKbn.MUKOU);

        String strSubSql3 = $SELECT + qIT_KhTtdkRireki3.syono +
            $FROM + qIT_KhTtdkRireki3.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki3.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki3.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki3.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_SYOUKENSAIHAKKOU) +
            $AND + qIT_KhTtdkRireki3.syorikbn.eq(C_SyoriKbn.BLNK);

        String strSubSql4 = $SELECT + qIT_KhTtdkRireki4.syono +
            $FROM + qIT_KhTtdkRireki4.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki4.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki4.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki4.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI) +
            $AND + qIT_KhTtdkRireki4.syorikbn.in(
                C_SyoriKbn.SIBOU,
                C_SyoriKbn.KOUDOSYOUGAI,
                C_SyoriKbn.SBKYUUHUSHR);

        String strSubSql5 = $SELECT + qIT_KhTtdkRireki5.syono +
            $FROM + qIT_KhTtdkRireki5.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki5.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki5.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki5.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + $((qIT_KhTtdkRireki5.syorikbn.eq(C_SyoriKbn.ZEISEITEKIKAKUHUKA) +
                $OR + qIT_KhTtdkRireki5.syorikbn.eq(C_SyoriKbn.ZEISEITEKIKAKUSYOUMETU) +
                $OR + qIT_KhTtdkRireki5.syorikbn.eq(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI) +
                $OR + qIT_KhTtdkRireki5.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI)));

        String strSubSql6 = $SELECT + qIT_KhTtdkRireki6.syono +
            $FROM + qIT_KhTtdkRireki6.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki6.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki6.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + $(qIT_KhTtdkRireki6.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU) +
                $OR + qIT_KhTtdkRireki6.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU));

        String strSubSql7 = $SELECT + qIT_KhTtdkRireki7.syono +
            $FROM + qIT_KhTtdkRireki7.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki7.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRireki7.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki7.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) +
            $AND + $((qIT_KhTtdkRireki7.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_ITEN)));

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qIT_KhTtdkRireki.syoriYmd.le(pSyoriYmdTo) +
            $AND + $($EXISTS(strSubSql1) +
                $OR + $EXISTS(strSubSql2) +
                $OR + $EXISTS(strSubSql3) +
                $OR + $EXISTS(strSubSql4) +
                $OR + $EXISTS(strSubSql5) +
                $OR + $EXISTS(strSubSql6) +
                $OR + $EXISTS(strSubSql7)) +
                $ORDER_BY(qIT_KhTtdkRireki.syono.asc(),
                    qIT_KhTtdkRireki.syoriYmd.asc(),
                    qIT_KhTtdkRireki.gyoumuKousinKinou.asc(),
                    qIT_KhTtdkRireki.henkousikibetukey.desc());

        ExDBResults<IT_KhTtdkRireki> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki,
            qIT_KhTtdkRireki1, qIT_KhTtdkRireki2, qIT_KhTtdkRireki3, qIT_KhTtdkRireki4, qIT_KhTtdkRireki5,
            qIT_KhTtdkRireki6, qIT_KhTtdkRireki7).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;

    }
}
