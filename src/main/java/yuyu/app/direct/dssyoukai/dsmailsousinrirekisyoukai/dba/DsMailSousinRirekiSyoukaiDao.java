package yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.DsMailSousinRirekiKensakuBean;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.meta.QMV_DsMailSosinRirekiSyoukai;

/**
 * ダイレクトサービス 照会 ＤＳメール送信履歴照会機能DAOクラス<br/>
 *
 */
public class DsMailSousinRirekiSyoukaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<MV_DsMailSosinRirekiSyoukai> getDsMailSosinRirekiSyoukaiByDsMailSosinRirekiKensaku(
        DsMailSousinRirekiKensakuBean pDsMailSousinRirekiKensakuBean) {

        QMV_DsMailSosinRirekiSyoukai qMV_DsMailSosinRirekiSyoukai = new QMV_DsMailSosinRirekiSyoukai("qMV_DsMailSosinRirekiSyoukai");

        String jyoukenHensuu = "";

        if (!BizUtil.isBlank(pDsMailSousinRirekiKensakuBean.getDsKokNo())) {
            jyoukenHensuu = qMV_DsMailSosinRirekiSyoukai.dskokno.eq(pDsMailSousinRirekiKensakuBean.getDsKokNo());
        }

        if (!BizUtil.isBlank(pDsMailSousinRirekiKensakuBean.getSyoNo())) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMV_DsMailSosinRirekiSyoukai.syono.eq(pDsMailSousinRirekiKensakuBean.getSyoNo());
            }
            else {
                jyoukenHensuu = qMV_DsMailSosinRirekiSyoukai.syono.eq(pDsMailSousinRirekiKensakuBean.getSyoNo());
            }
        }

        if (!BizUtil.isBlank(pDsMailSousinRirekiKensakuBean.getDsSousinNo())) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMV_DsMailSosinRirekiSyoukai.dssousinno.eq(pDsMailSousinRirekiKensakuBean.getDsSousinNo());
            }
            else {
                jyoukenHensuu = qMV_DsMailSosinRirekiSyoukai.dssousinno.eq(pDsMailSousinRirekiKensakuBean.getDsSousinNo());
            }
        }

        if (!C_DsSousinMailSyubetuKbn.BLNK.eq(pDsMailSousinRirekiKensakuBean.getDsSousinMailSyubetuKbn())) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMV_DsMailSosinRirekiSyoukai.dssousinmailsyubetukbn.eq(pDsMailSousinRirekiKensakuBean.getDsSousinMailSyubetuKbn());
            }
            else {
                jyoukenHensuu = qMV_DsMailSosinRirekiSyoukai.dssousinmailsyubetukbn.eq(pDsMailSousinRirekiKensakuBean.getDsSousinMailSyubetuKbn());
            }
        }

        if (pDsMailSousinRirekiKensakuBean.getSousinYmdFrom() != null) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMV_DsMailSosinRirekiSyoukai.dsdatasakuseiymd.ge(pDsMailSousinRirekiKensakuBean.getSousinYmdFrom());
            }
            else {
                jyoukenHensuu = qMV_DsMailSosinRirekiSyoukai.dsdatasakuseiymd.ge(pDsMailSousinRirekiKensakuBean.getSousinYmdFrom());
            }
        }

        if (pDsMailSousinRirekiKensakuBean.getSousinYmdTo() != null) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMV_DsMailSosinRirekiSyoukai.dsdatasakuseiymd.le(pDsMailSousinRirekiKensakuBean.getSousinYmdTo());
            }
            else {
                jyoukenHensuu = qMV_DsMailSosinRirekiSyoukai.dsdatasakuseiymd.le(pDsMailSousinRirekiKensakuBean.getSousinYmdTo());
            }
        }

        String strSql = $SELECT + qMV_DsMailSosinRirekiSyoukai +
            $FROM(qMV_DsMailSosinRirekiSyoukai)  +
            $WHERE + jyoukenHensuu +
            $ORDER_BY(qMV_DsMailSosinRirekiSyoukai.dsdatasakuseiymd.desc(),
                qMV_DsMailSosinRirekiSyoukai.dskokno.asc(),
                qMV_DsMailSosinRirekiSyoukai.syono.asc(),
                qMV_DsMailSosinRirekiSyoukai.dssousinmailsyubetukbn.asc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(
            pDsMailSousinRirekiKensakuBean.getKensakuResultMaxKensuu()).bind(qMV_DsMailSosinRirekiSyoukai).getResultList();

    }
}
