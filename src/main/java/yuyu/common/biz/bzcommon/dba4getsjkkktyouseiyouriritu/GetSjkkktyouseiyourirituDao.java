package yuyu.common.biz.bzcommon.dba4getsjkkktyouseiyouriritu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu2;

/**
 * 業務共通 業務共通 市場価格調整用利率取得の機能DAOクラス
 */
public class GetSjkkktyouseiyourirituDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRiritus2ByPK(String pSyouhnCd,
        String pSjkkktyouseiriritutkybr1, String pSjkkktyouseiriritutkybr2, BizDate pKijyunfromymd,
        BizDate pKijyuntoymd) {

        QBM_SjkkkTyouseiyouRiritu2 qBM_SjkkkTyouseiyouRiritu2 = new QBM_SjkkkTyouseiyouRiritu2
            ("qBM_SjkkkTyouseiyouRiritu2");

        String strSql = $SELECT + qBM_SjkkkTyouseiyouRiritu2 +
            $FROM(qBM_SjkkkTyouseiyouRiritu2) +
            $WHERE + qBM_SjkkkTyouseiyouRiritu2.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr1.eq(pSjkkktyouseiriritutkybr1) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr2.eq(pSjkkktyouseiriritutkybr2) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.kijyunfromymd.le(pKijyunfromymd) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.kijyuntoymd.ge(pKijyuntoymd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_SjkkkTyouseiyouRiritu2).getResultList();
    }

    public List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRiritu2sBy3PKMaxKyktoymd(String pSyouhnCd,
        String pSjkkktyouseiriritutkybr1, String pSjkkktyouseiriritutkybr2) {

        QBM_SjkkkTyouseiyouRiritu2 qBM_SjkkkTyouseiyouRiritu2 = new QBM_SjkkkTyouseiyouRiritu2
            ("qBM_SjkkkTyouseiyouRiritu2");

        String subquery = $SELECT + $MAX(qBM_SjkkkTyouseiyouRiritu2.kijyuntoymd) +
            $FROM(qBM_SjkkkTyouseiyouRiritu2) +
            $WHERE + qBM_SjkkkTyouseiyouRiritu2.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr1.eq(pSjkkktyouseiriritutkybr1) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr2.eq(pSjkkktyouseiriritutkybr2);

        String strSql = $SELECT + qBM_SjkkkTyouseiyouRiritu2 +
            $FROM(qBM_SjkkkTyouseiyouRiritu2) +
            $WHERE + qBM_SjkkkTyouseiyouRiritu2.syouhncd.eq(pSyouhnCd) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr1.eq(pSjkkktyouseiriritutkybr1) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr2.eq(pSjkkktyouseiriritutkybr2) +
            $AND + qBM_SjkkkTyouseiyouRiritu2.kijyuntoymd + $EQ + $(subquery);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_SjkkkTyouseiyouRiritu2).getResultList();
    }
}
