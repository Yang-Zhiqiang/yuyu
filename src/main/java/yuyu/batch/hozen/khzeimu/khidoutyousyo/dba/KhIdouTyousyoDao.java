package yuyu.batch.hozen.khzeimu.khidoutyousyo.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyaHenkouRireki;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 税務 契約保全異動調書作成機能DAOクラス
 */
public class KhIdouTyousyoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean> getKhIdouTyousyoInfosByKakutyoujobcdSyoriYmd(
        String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_KykSyaHenkouRireki qIT_KykSyaHenkouRireki = new QIT_KykSyaHenkouRireki("qIT_KykSyaHenkouRireki");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String strSql = $SELECT + $NEW(KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean.class,
            qIT_KykSyaHenkouRireki,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_KhTtdkRireki) +

            $FROM(qIT_KykSyaHenkouRireki,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KhTtdkRireki) +

                $WHERE + qIT_KykSyaHenkouRireki.meighnksyoriymd.eq(pSyoriYmd) +
                $AND + qIT_KykSyaHenkouRireki.meigihnkjiyuu.eq(C_Meigihnkjiyuu.KYKSB) +
                $AND + qIT_KykSyaHenkouRireki.syono.eq(qIT_KhTtdkRireki.syono) +
                $AND + qIT_KykSyaHenkouRireki.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
                $AND + qIT_KykSyaHenkouRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $ORDER_BY(qIT_KykSyaHenkouRireki.syono.asc());

        ExDBResults<KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean.class)
            .bind(qIT_KykSyaHenkouRireki, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya, qIT_KhTtdkRireki)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
