package yuyu.common.biz.bzcommon.dba4getyoteiriritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_YoteiRiritu3;

/**
 * 業務共通 業務共通 予定利率取得の機能DAOクラス
 */
public class GetYoteirirituDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_YoteiRiritu3> getYoteiRiritus3BySyouhncdYoteiriritutkybr1Yoteiriritutkybr2KijyunfromymdKijyuntoymd(
        String pSyouhnCd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd,
        BizDate pKijyuntoymd) {

        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3
            ("qBM_YoteiRiritu3");

        String strSql = $SELECT + qBM_YoteiRiritu3 +
            $FROM (qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr1.eq(pYoteiriritutkybr1) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr2.eq(pYoteiriritutkybr2) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.le(pKijyunfromymd) +
            $AND + qBM_YoteiRiritu3.kijyuntoymd.ge(pKijyuntoymd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_YoteiRiritu3).getResultList();
    }

    public BizNumber getYoteiRiritu3SumSyouhncdYoteiriritutkybr1Yoteiriritutkybr2Kijyunfromymd(String pSyouhnCd,
        String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd, BizDate pCalckijyunymd) {

        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3("qBM_YoteiRiritu3");

        String strSql = $SELECT + $SUM + $(qBM_YoteiRiritu3.yoteiriritu) +
            $FROM (qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr1.eq(pYoteiriritutkybr1) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr2.eq(pYoteiriritutkybr2) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.ge(pKijyunfromymd) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.le(pCalckijyunymd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_YoteiRiritu3).getSingleResult();
    }

    public List<BM_YoteiRiritu3> getYoteiRiritus3BySyouhncdTuukasyuYoteiriritutkybr1Yoteiriritutkybr2KijyunfromymdKijyuntoymd(
        String pSyouhnCd, C_Tuukasyu pTuukasyu, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd,
        BizDate pKijyuntoymd) {

        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3("qBM_YoteiRiritu3");

        String strSql = $SELECT + qBM_YoteiRiritu3 +
            $FROM (qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_YoteiRiritu3.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr1.eq(pYoteiriritutkybr1) +
            $AND + qBM_YoteiRiritu3.yoteiriritutkybr2.eq(pYoteiriritutkybr2) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.le(pKijyunfromymd) +
            $AND + qBM_YoteiRiritu3.kijyuntoymd.ge(pKijyuntoymd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_YoteiRiritu3).getResultList();
    }
}
