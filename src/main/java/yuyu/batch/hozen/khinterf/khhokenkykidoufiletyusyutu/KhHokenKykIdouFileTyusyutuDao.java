package yuyu.batch.hozen.khinterf.khhokenkykidoufiletyusyutu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_HokenKykIdouRireki;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;

/**
 * 保険契約異動情報ファイル抽出DAOクラスです。
 */
public class KhHokenKykIdouFileTyusyutuDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon();
        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String strSql = $SELECT +
            qIT_KykKihon +","+
            qIT_KhTtdkRireki +
            $FROM + qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
            $AND +"("+ qIT_KhTtdkRireki.gyoumuKousinKinou.in(
                IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI,
                IKhozenCommonConstants.KINOUID_KAIYAKU,
                IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU,
                IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU,
                IKhozenCommonConstants.KINOUID_GENGAKU,
                IKhozenCommonConstants.KINOUID_SEINENGAPPISEI,
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK,
                IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) +
                $OR + "(" +qIT_KhTtdkRireki.gyoumuKousinKinou.eq(
                    IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI) +
                    $AND +"("+ qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.CLGOFF) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.KYKTORIKESI) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.KAIJO) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.MUKOU) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBKAIJO) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMUKOU_KIHRKPSHR) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMUKOU_SHRNASI) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMENSEKI) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMENSEKI_SHRNASI) + "))" +
                    $OR + "(" + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(
                        IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI) +
                        $AND + "(" + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SIBOU) +
                        $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMUKOU) +
                        $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBKYUUHUSHR) +
                        $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.KOUDOSYOUGAI) + "))" +
                        $OR + "(" + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(
                            IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
                            $AND + "("+ qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI) +
                            $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI) +"))" +  ")" +
                            $AND + qIT_KykKihon.syono.eq(qIT_KhTtdkRireki.syono) +
                            $ORDER_BY( qIT_KhTtdkRireki.syono.asc(),
                                qIT_KhTtdkRireki.henkousikibetukey.desc());

        ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults = exDBEntityManager
            .createJPQL(strSql)
            .bind(qIT_KykKihon, qIT_KhTtdkRireki)
            .getResults(KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekiBySyonoSyorikbnGyoumukousinkinou(
        String pSyono, C_SyoriKbn syorikbn[], String gyoumuKousinKinou) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String mainStry = $SELECT + qIT_KhTtdkRireki +
            $FROM (qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syorikbn.in(syorikbn) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(gyoumuKousinKinou) +
            $ORDER_BY (qIT_KhTtdkRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KhTtdkRireki).getResultList();
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttknBySyonoGyoumukousinkinou(
        String pSyono, String gyoumuKousinKinou) {

        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn();

        String mainStry = $SELECT + qIT_HokenryouTmttkn +
            $FROM (qIT_HokenryouTmttkn) +
            $WHERE + qIT_HokenryouTmttkn.syono.eq(pSyono) +
            $AND + qIT_HokenryouTmttkn.gyoumuKousinKinou.eq(gyoumuKousinKinou)  +
            $ORDER_BY (qIT_HokenryouTmttkn.tmttkntaisyouym.desc(),
                qIT_HokenryouTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_HokenryouTmttkn).getResultList();
    }

    public IT_KykSyouhnRireki getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukeyLt(
        String pSyono, C_SyutkKbn pSyutkkbn, String pHenkouSikibetukey) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String mainStry = $SELECT + qIT_KykSyouhnRireki +
            $FROM (qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.lt(pHenkouSikibetukey) +
            $ORDER_BY (qIT_KykSyouhnRireki.henkousikibetukey.desc());


        return exDBEntityManager.createJPQL(mainStry).setFirstResult(0).setMaxResults(1)
            .bind(qIT_KykSyouhnRireki).getSingleResult();
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukey(
        String pSyono, C_SyutkKbn pSyutkkbn, String pHenkouSikibetukey) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String mainStry = $SELECT + qIT_KykSyouhnRireki +
            $FROM (qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.eq(pHenkouSikibetukey);

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KykSyouhnRireki).getResultList();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknsBySyonoTmttknkouryokukaisiymdLe(
        String pSyono, BizDate pTmttknkouryokukaisiymd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String mainStry = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM (qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.le(pTmttknkouryokukaisiymd) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public IT_KhSisuurendoTmttkn getKhSisuurendoTmttknsBySyono(String pSyono) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String mainStry = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM (qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttkntaisyouym.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(mainStry).setFirstResult(0).setMaxResults(1)
            .bind(qIT_KhSisuurendoTmttkn).getSingleResult();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknsBySyonoTmttknkouryokukaisiymdGe(String pSyono, BizDateYM pTmttkntaisyouym) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String mainStry = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM (qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttkntaisyouym.ge(pTmttkntaisyouym) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttkntaisyouym.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknsAllBySyono(String pSyono) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String mainStry = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM (qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttkntaisyouym.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekiForTotugouBySyono(String pSyono) {
        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String mainStry = $SELECT +
            qIT_KhTtdkRireki +
            $FROM  (qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND +"("+ qIT_KhTtdkRireki.gyoumuKousinKinou.in(
                IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI,
                IKhozenCommonConstants.KINOUID_KAIYAKU,
                IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU,
                IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU,
                IKhozenCommonConstants.KINOUID_GENGAKU,
                IKhozenCommonConstants.KINOUID_SEINENGAPPISEI,
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK,
                IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) +
                $OR + "(" +qIT_KhTtdkRireki.gyoumuKousinKinou.eq(
                    IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI) +
                    $AND +"("+ qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.CLGOFF) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.KYKTORIKESI) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.KAIJO) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.MUKOU) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBKAIJO) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMUKOU_KIHRKPSHR) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMUKOU_SHRNASI) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMENSEKI) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMENSEKI_SHRNASI) + "))" +
                    $OR + "(" + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(
                        IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI) +
                        $AND + "(" + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SIBOU) +
                        $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBMUKOU) +
                        $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SBKYUUHUSHR) +
                        $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.KOUDOSYOUGAI) + "))" +
                        $OR + "(" + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(
                            IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
                            $AND + "("+ qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI) +
                            $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_TORIKESI) +
                            $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI) +"))" +  ")" +
                            $ORDER_BY(qIT_KhTtdkRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KhTtdkRireki).getResultList();
    }

    public IT_KhHenkouRireki getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukey(
        String pSyono, String pHenkouSikibetukey) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki();

        String mainStry = $SELECT + qIT_KhHenkouRireki +
            $FROM (qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkouSikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq("IT_KhSisuurendoTmttkn");

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_KhHenkouRireki).getSingleResult();
    }

    public List<IT_HokenKykIdouRireki> getHokenKykIdouRirekiBySyonoHenkouSikibetukey(
        String pSyono, String pHenkouSikibetukey) {

        QIT_HokenKykIdouRireki qIT_HokenKykIdouRireki = new QIT_HokenKykIdouRireki();

        String mainStry = $SELECT + qIT_HokenKykIdouRireki +
            $FROM (qIT_HokenKykIdouRireki) +
            $WHERE + qIT_HokenKykIdouRireki.syono.eq(pSyono) +
            $AND + qIT_HokenKykIdouRireki.henkousikibetukey.eq(pHenkouSikibetukey) +
            $ORDER_BY (qIT_HokenKykIdouRireki.zougenkbn.desc());

        return exDBEntityManager.createJPQL(mainStry).bind(qIT_HokenKykIdouRireki).getResultList();
    }

}
