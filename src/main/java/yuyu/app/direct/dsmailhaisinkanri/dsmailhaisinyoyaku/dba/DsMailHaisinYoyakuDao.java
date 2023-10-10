package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.QMT_DsMailHaisinYoyaku;

/**
 * ダイレクトサービス ＤＳメール配信予約機能DAOクラス<br/>
 *
 */
public class DsMailHaisinYoyakuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<MT_DsMailHaisinYoyaku> getDsMailHaisinYoyakuDaoByMailSyubetuHaisinYoteiYmdStatus(
        C_DsSousinMailSyubetuKbn pDsSousinMailSyubetuKbn, BizDate pHaisinYmdFrom, BizDate pHaisinYmdTo,
        C_DsHaisinYoyakuStatusKbn[] pDsHaisinYoyakuStatusKbn, int pSearchResultMaxCnt) {

        QMT_DsMailHaisinYoyaku qMT_DsMailHaisinYoyaku = new QMT_DsMailHaisinYoyaku("qMT_DsMailHaisinYoyaku");

        String strSql = $SELECT + qMT_DsMailHaisinYoyaku +
            $FROM(qMT_DsMailHaisinYoyaku);

        if (C_DsSousinMailSyubetuKbn.BLNK.eq(pDsSousinMailSyubetuKbn)){

            strSql = strSql + $WHERE + qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.in(pDsHaisinYoyakuStatusKbn);
            strSql = strSql + $AND + qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd.ge(pHaisinYmdFrom);
            strSql = strSql + $AND + qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd.le(pHaisinYmdTo);
        }

        else{

            strSql = strSql + $WHERE + qMT_DsMailHaisinYoyaku.dssousinmailsyubetukbn.eq(pDsSousinMailSyubetuKbn);
            strSql = strSql + $AND + qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.in(pDsHaisinYoyakuStatusKbn);
            strSql = strSql + $AND + qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd.ge(pHaisinYmdFrom);
            strSql = strSql + $AND + qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd.le(pHaisinYmdTo);
        }

        strSql = strSql + $ORDER_BY(qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd.desc(),
            qMT_DsMailHaisinYoyaku.dssousinmailsyubetukbn.asc(),
            qMT_DsMailHaisinYoyaku.dsmailhaisinyoyakuskbtkey.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(
            pSearchResultMaxCnt).bind(qMT_DsMailHaisinYoyaku).getResultList();
    }

    public List<MT_DsMailHaisinYoyaku> getDsMailHaisinYoyakuByMailSyubetu(
        C_DsSousinMailSyubetuKbn pDsSousinMailSyubetuKbn) {

        QMT_DsMailHaisinYoyaku qMT_DsMailHaisinYoyaku = new QMT_DsMailHaisinYoyaku("qMT_DsMailHaisinYoyaku");

        String strSql = $SELECT + qMT_DsMailHaisinYoyaku +
            $FROM(qMT_DsMailHaisinYoyaku);

        if ( C_DsSousinMailSyubetuKbn.BLNK.eq(pDsSousinMailSyubetuKbn) ){

            strSql = strSql + $WHERE +
                $(qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.eq(C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI) +
                    $OR + qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.eq(C_DsHaisinYoyakuStatusKbn.SYOUNIN_SUMI));

        }

        else {

            strSql = strSql + $WHERE + qMT_DsMailHaisinYoyaku.dssousinmailsyubetukbn.eq(pDsSousinMailSyubetuKbn) +
                $AND + $(qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.eq(C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI) +
                    $OR + qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.eq(C_DsHaisinYoyakuStatusKbn.SYOUNIN_SUMI));

        }

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinYoyaku).getResultList();
    }

    public long getDsMailHaisinYoyakuCountHaisinTourokuYmd (BizDate pDsMailHaisinTourokuYmd){

        QMT_DsMailHaisinYoyaku qMT_DsMailHaisinYoyaku = new QMT_DsMailHaisinYoyaku();

        return  exDBEntityManager.createJPQL(
            $SELECT + $COUNT(qMT_DsMailHaisinYoyaku.dsmailhaisinyoyakuskbtkey) +
            $FROM   + qMT_DsMailHaisinYoyaku.MT_DsMailHaisinYoyaku() +
            $WHERE   + qMT_DsMailHaisinYoyaku.dsmailhaisintourokuymd.eq(pDsMailHaisinTourokuYmd)
            ).bind(qMT_DsMailHaisinYoyaku).<Long>getSingleResult().intValue();
    }

    public MT_DsMailHaisinYoyaku getDsMailHaisinYoyakuByDsMailHaisinSkbtKey(
        String pDsMailHaisinYoyakuSkbtKey) {

        QMT_DsMailHaisinYoyaku qMT_DsMailHaisinYoyaku = new QMT_DsMailHaisinYoyaku();

        String strSql = $SELECT + qMT_DsMailHaisinYoyaku +
            $FROM   + qMT_DsMailHaisinYoyaku.MT_DsMailHaisinYoyaku() +
            $WHERE + qMT_DsMailHaisinYoyaku.dsmailhaisinyoyakuskbtkey.eq(pDsMailHaisinYoyakuSkbtKey);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinYoyaku).getSingleResult();

    }


}
