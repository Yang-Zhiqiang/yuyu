package yuyu.app.direct.dskokyakukanri.dskokyakuseibi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static yuyu.app.direct.dskokyakukanri.dskokyakuseibi.DsKokyakuSeibiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QBM_Ginkou;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsTorihikiServiceKanri;


/**
 * ダイレクトサービス 顧客整備機能DAOクラス
 */
public class DsKokyakuSeibiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<TktiTrhkyuKzInfoBean>getTktiTrhkyuKzInfoBeanByBankcdSitencdHaisiymd(
        String pBankcd, String pSitencd, BizDate pHaisiYmdFrom, BizDate pHaisiYmdTo, Integer pKensakuresultmaxkensuu ) {

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou("qBM_Ginkou");
        QMT_DsSoukinyouKouza qMT_DsSoukinyouKouza = new QMT_DsSoukinyouKouza("qMT_DsSoukinyouKouza");
        QMT_DsTorihikiServiceKanri qMT_DsTorihikiServiceKanri = new QMT_DsTorihikiServiceKanri("qMT_DsTorihikiServiceKanri");

        String strSubSql1 = $SELECT + qIT_KykSyouhn.syono +
            $FROM(qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU);

        String strSubSql2 = $SELECT + qMT_DsTorihikiServiceKanri.dskokno +
            $FROM(qMT_DsTorihikiServiceKanri) +
            $WHERE + qMT_DsTorihikiServiceKanri.dskokno.eq(qMT_DsSoukinyouKouza.dskokno) +
            $AND + qMT_DsTorihikiServiceKanri.syono.eq(qMT_DsSoukinyouKouza.syono) +
            $AND + qMT_DsTorihikiServiceKanri.dstrhkserviceriyoujkkbn.eq(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA);

        String strSubSql3 = $SELECT + qIT_KykSya.kyknmkn +
            $FROM(qIT_KykSya) +
            $WHERE + qIT_KykSya.syono.eq(qMT_DsSoukinyouKouza.syono);

        String joukenhensuu = "";

        if (!BizUtil.isBlank(pBankcd)) {
            joukenhensuu = joukenhensuu +
                $AND + qMT_DsSoukinyouKouza.bankcd.eq(pBankcd);
        }
        if (!BizUtil.isBlank(pSitencd)) {
            joukenhensuu = joukenhensuu +
                $AND + qMT_DsSoukinyouKouza.sitencd.eq(pSitencd);
        }
        if (pHaisiYmdFrom != null && pHaisiYmdTo != null) {
            joukenhensuu = joukenhensuu +
                $AND + qMT_DsSoukinyouKouza.bankcd.ne(YUUTYO_BANK) +
                $AND + $(qBM_Ginkou.bankcd.isNull() +
                    $OR + $(qBM_Ginkou.haisiymd.ge(pHaisiYmdFrom) +
                        $AND + qBM_Ginkou.haisiymd.le(pHaisiYmdTo)));
        }

        String queryStr = $SELECT + $NEW(
            TktiTrhkyuKzInfoBean.class,
            qMT_DsSoukinyouKouza.dskokno,
            qMT_DsSoukinyouKouza.syono,
            qMT_DsSoukinyouKouza.kzsyuruikbn,
            qMT_DsSoukinyouKouza.bankcd,
            qMT_DsSoukinyouKouza.sitencd,
            qMT_DsSoukinyouKouza.kouzano,
            qMT_DsSoukinyouKouza.kzdoukbn,
            qMT_DsSoukinyouKouza.kzmeiginmkn,
            qBM_Ginkou.sinsetuymd,
            qBM_Ginkou.haisiymd,
            qBM_Ginkou.banknmkj,
            qBM_Ginkou.sitennmkj,
            $(strSubSql3)
            ) +
            $FROM (qMT_DsSoukinyouKouza)+
            $LEFT_OUTER_JOIN + qMT_DsSoukinyouKouza.BM_Ginkou() +
            $AS + qBM_Ginkou +
            $WHERE + $EXISTS(strSubSql1) +
            $AND + $EXISTS(strSubSql2) +
            joukenhensuu +
            $ORDER_BY(qMT_DsSoukinyouKouza.bankcd.asc(),
                qMT_DsSoukinyouKouza.sitencd.asc(),
                qMT_DsSoukinyouKouza.dskokno.asc(),
                qMT_DsSoukinyouKouza.syono.asc());

        return exDBEntityManager.createJPQL(queryStr, TktiTrhkyuKzInfoBean.class).setFirstResult(0).setMaxResults(
            pKensakuresultmaxkensuu).bind(qIT_KykSya,qIT_KykSyouhn, qBM_Ginkou, qMT_DsSoukinyouKouza, qMT_DsTorihikiServiceKanri).getResultList();

    }

}
