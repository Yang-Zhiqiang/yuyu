package yuyu.common.hozen.khcommon.dba4editkyknaiyouosirase;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QBM_KawaseRate;
import yuyu.def.db.meta.QBM_YoteiRiritu3;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集Daoクラス
 */
public class EditKykNaiyouOsiraseDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttkns(String pSyono, BizDate pSyoriYmd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttknMain = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttknMain");
        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttknSub = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttknSub");

        String subSql = $SELECT + qIT_KhSisuurendoTmttknSub.tmttkntaisyouym +
            $FROM(qIT_KhSisuurendoTmttknSub) +
            $WHERE + qIT_KhSisuurendoTmttknSub.syono.eq(qIT_KhSisuurendoTmttknMain.syono) +
            $AND + qIT_KhSisuurendoTmttknSub.tmttknkouryokukaisiymd.le(pSyoriYmd) +
            $AND + qIT_KhSisuurendoTmttknSub.tmttkntaisyouym.eq(qIT_KhSisuurendoTmttknMain.tmttkntaisyouym) +
            $GROUP_BY + qIT_KhSisuurendoTmttknSub.tmttkntaisyouym +
            $HAVING + $MIN(qIT_KhSisuurendoTmttknSub.renno) + $EQ + qIT_KhSisuurendoTmttknMain.renno;

        String mainSql = $SELECT + qIT_KhSisuurendoTmttknMain +
            $FROM(qIT_KhSisuurendoTmttknMain) +
            $WHERE + qIT_KhSisuurendoTmttknMain.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttknMain.tmttknkouryokukaisiymd.le(pSyoriYmd) +
            $AND + $EXISTS(subSql) +
            $ORDER_BY(qIT_KhSisuurendoTmttknMain.tmttkntaisyouym.asc());

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = exDBEntityManager.createJPQL(mainSql).bind(
            qIT_KhSisuurendoTmttknMain, qIT_KhSisuurendoTmttknSub).getResultList();

        return khSisuurendoTmttknLst;
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttkns2(String pSyono, BizDateYM pTmttkntaisyouym) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM(qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttkntaisyouym.eq(pTmttkntaisyouym) +
            $ORDER_BY(qIT_KhSisuurendoTmttkn.renno.asc());

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = exDBEntityManager.createJPQL(strSql).bind(
            qIT_KhSisuurendoTmttkn).getResultList();

        return khSisuurendoTmttknLst;
    }

    public List<BM_YoteiRiritu3> getYoteiRiritu3List(
        String pSyouhnCd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd) {

        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3("qBM_YoteiRiritu3");

        String strSql = $SELECT + qBM_YoteiRiritu3 +
            $FROM (qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr1.eq(pYoteiriritutkybr1) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr2.eq(pYoteiriritutkybr2) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.ge(pKijyunfromymd) +
            $AND + qBM_YoteiRiritu3.kijyuntoymd.le(pKijyuntoymd) +
            $ORDER_BY(qBM_YoteiRiritu3.kijyunfromymd.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_YoteiRiritu3).getResultList();
    }

    public List<BM_KawaseRate> getKawaseRateList(
        List<BizDate> pKwsratekjymdList,
        C_KwsrendouKbn pKwsrendouKbn,
        C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka,
        C_KawasetekiyoKbn pKawasetekiyokbn,
        C_KawasetsryKbn pKawasetsrykbn) {

        QBM_KawaseRate qBM_KawaseRate = new QBM_KawaseRate("qBM_KawaseRate");

        String strSql = $SELECT + qBM_KawaseRate +
            $FROM (qBM_KawaseRate) +
            $WHERE + qBM_KawaseRate.kwsratekjymd.in(pKwsratekjymdList) +
            $AND + qBM_KawaseRate.kwsrendoukbn.eq(pKwsrendouKbn) +
            $AND + qBM_KawaseRate.mototuuka.eq(pMototuuka) +
            $AND + qBM_KawaseRate.kanzantuuka.eq(pKanzantuuka) +
            $AND + qBM_KawaseRate.kawasetekiyokbn.eq(pKawasetekiyokbn) +
            $AND + qBM_KawaseRate.kawasetsrykbn.eq(pKawasetsrykbn) +
            $ORDER_BY(qBM_KawaseRate.kwsratekjymd.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_KawaseRate).getResultList();
    }
}
