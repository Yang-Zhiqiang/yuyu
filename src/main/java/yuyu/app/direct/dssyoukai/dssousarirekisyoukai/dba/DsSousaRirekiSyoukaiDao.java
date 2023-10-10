package yuyu.app.direct.dssyoukai.dssousarirekisyoukai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import yuyu.def.db.meta.QMT_SousaRireki;
import yuyu.def.db.meta.QMT_SousaRirekiSyousai;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * ダイレクトサービス 照会 操作履歴照会機能DAOクラス<br/>
 *
 */
public class DsSousaRirekiSyoukaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<MT_SousaRireki> getSousaRirekiByKensakuJyouken(BizDate pTtdkstartymdFrom, BizDate pTtdkstartymdTo,
        String pTtdkstarttimeFrom, String pTtdkstarttimeTo, String pSyono, boolean  pSyonoMisetteiKensaku,
        C_TtdkKinouKbn pTtdkkinoukbn, C_SousaRirekiJkKbn pSousarirekijkkbn, C_TtdkKekkaKbn pSousarirekikekkakbn) {

        QMT_SousaRireki qMT_SousaRireki = new QMT_SousaRireki("qMT_SousaRireki");

        String jyoukenHensuu = "";

        if (pTtdkstartymdFrom != null) {
            jyoukenHensuu = qMT_SousaRireki.ttdkstartymd.ge(pTtdkstartymdFrom);
        }

        if (pTtdkstartymdTo != null) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.ttdkstartymd.le(pTtdkstartymdTo);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.ttdkstartymd.le(pTtdkstartymdTo);
            }
        }

        if (!BizUtil.isBlank(pTtdkstarttimeFrom)) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.ttdkstarttime.substring(1, 4).ge(pTtdkstarttimeFrom);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.ttdkstarttime.substring(1, 4).ge(pTtdkstarttimeFrom);
            }
        }

        if (!BizUtil.isBlank(pTtdkstarttimeTo)) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.ttdkstarttime.substring(1, 4).le(pTtdkstarttimeTo);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.ttdkstarttime.substring(1, 4).le(pTtdkstarttimeTo);
            }
        }

        if (!BizUtil.isBlank(pSyono)) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.syono.eq(pSyono);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.syono.eq(pSyono);
            }
        }

        if (pSyonoMisetteiKensaku) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + $(qMT_SousaRireki.syono.isNull() + $OR + qMT_SousaRireki.syono.eq(""));
            }
            else {
                jyoukenHensuu = $(qMT_SousaRireki.syono.isNull() + $OR + qMT_SousaRireki.syono.eq(""));
            }
        }

        if (!C_TtdkKinouKbn.BLANK.eq(pTtdkkinoukbn)) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.ttdkkinoukbn.eq(pTtdkkinoukbn);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.ttdkkinoukbn.eq(pTtdkkinoukbn);
            }
        }

        if (!C_SousaRirekiJkKbn.BLNK.eq(pSousarirekijkkbn)) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.sousarirekijkkbn.eq(pSousarirekijkkbn);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.sousarirekijkkbn.eq(pSousarirekijkkbn);
            }
        }

        if (!C_TtdkKekkaKbn.BLNK.eq(pSousarirekikekkakbn)) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_SousaRireki.sousarirekikekkakbn.eq(pSousarirekikekkakbn);
            }
            else {
                jyoukenHensuu = qMT_SousaRireki.sousarirekikekkakbn.eq(pSousarirekikekkakbn);
            }
        }

        String strSql = $SELECT + qMT_SousaRireki +
            $FROM(qMT_SousaRireki)  +
            $WHERE + jyoukenHensuu +
            $ORDER_BY(qMT_SousaRireki.ttdkstartymd.desc(),
                qMT_SousaRireki.ttdkstarttime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qMT_SousaRireki).getResultList();
    }

    public List<MT_SousaRirekiSyousai> getSousaRirekiSyousaiByTtdkSikibetuId(String pTtdksikibetuid) {

        QMT_SousaRirekiSyousai qMT_SousaRirekiSyousai = new QMT_SousaRirekiSyousai("qMT_SousaRirekiSyousai");

        String strSql = $SELECT + qMT_SousaRirekiSyousai +
            $FROM(qMT_SousaRirekiSyousai)  +
            $WHERE + qMT_SousaRirekiSyousai.ttdksikibetuid.eq(pTtdksikibetuid) +
            $ORDER_BY(qMT_SousaRirekiSyousai.syoriendymd.asc(),
                qMT_SousaRirekiSyousai.syoriendtime.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qMT_SousaRirekiSyousai).getResultList();
    }
}
