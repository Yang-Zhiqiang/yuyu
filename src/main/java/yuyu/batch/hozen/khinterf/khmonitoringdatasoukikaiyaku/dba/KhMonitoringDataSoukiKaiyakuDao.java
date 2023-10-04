package yuyu.batch.hozen.khinterf.khmonitoringdatasoukikaiyaku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（早期解約）DAOクラスです。<br />
 */
public class KhMonitoringDataSoukiKaiyakuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KyMonitoringDataSoukiKaiyakuBean> getKhMonitoringDataSoukiKaiyakuBean (
        String pKakutyoujobCd, BizDate pTaisyoukknFrom, BizDate pTaisyoukknTo) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String strSql = $SELECT + qIT_KykKihon + "," + qIT_KykSyouhn + "," + qIT_KhShrRireki +
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_KhShrRireki) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.KAIYAKU) +
            $AND + qIT_KhShrRireki.shrsyoriymd.ge(pTaisyoukknFrom) +
            $AND + qIT_KhShrRireki.shrsyoriymd.le(pTaisyoukknTo) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.KAIYAKU);

        ExDBResults<KyMonitoringDataSoukiKaiyakuBean> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KhShrRireki)
            .getResults(KyMonitoringDataSoukiKaiyakuBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobCd));

        return exDBResults;
    }
}
