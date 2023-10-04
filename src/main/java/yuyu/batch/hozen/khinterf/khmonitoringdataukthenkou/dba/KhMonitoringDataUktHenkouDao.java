package yuyu.batch.hozen.khinterf.khmonitoringdataukthenkou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（受取人変更）DAOクラス
 */
public class KhMonitoringDataUktHenkouDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<MonitoringDataUktHenkouInfoBean> getMonitoringDataUktHenkouInfos(String pKakutyouJobCd,
        BizDate pTaisyoukknFrom, BizDate pTaisyoukknTo) {

        QIT_KykKihon     qIT_KykKihonMain     = new QIT_KykKihon("qIT_KykKihonMain");
        QIT_KhTtdkRireki qIT_KhTtdkRirekiMain = new QIT_KhTtdkRireki("qIT_KhTtdkRirekiMain");
        QIT_KhTtdkRireki qIT_KhTtdkRirekiSub  = new QIT_KhTtdkRireki("qSubIT_KhTtdkRirekiSub");

        String subSql = $SELECT + qIT_KhTtdkRirekiSub.syono +
            $FROM(qIT_KhTtdkRirekiSub) +
            $WHERE + qIT_KhTtdkRirekiSub.syono.eq(qIT_KhTtdkRirekiMain.syono) +
            $AND + qIT_KhTtdkRirekiSub.kbnkey.eq(qIT_KhTtdkRirekiMain.kbnkey) +
            $AND + qIT_KhTtdkRirekiSub.syorikbn.eq(C_SyoriKbn.MEIHEN_HHKKAISEIUKEHENKOU)  +
            $AND + qIT_KhTtdkRirekiSub.syoriYmd.ge(pTaisyoukknFrom) +
            $AND + qIT_KhTtdkRirekiSub.syoriYmd.le(pTaisyoukknTo) +
            $GROUP_BY + qIT_KhTtdkRirekiSub.syono +
            $HAVING + $MAX(qIT_KhTtdkRirekiSub.henkousikibetukey) + $EQ + qIT_KhTtdkRirekiMain.henkousikibetukey;

        String mainSql = $SELECT +
            qIT_KykKihonMain + "," +
            qIT_KhTtdkRirekiMain.syoriYmd +
            $FROM(qIT_KykKihonMain,
                qIT_KhTtdkRirekiMain) +
                $WHERE + $EXISTS(subSql) +
                $AND + qIT_KykKihonMain.syono.eq(qIT_KhTtdkRirekiMain.syono) +
                $AND + qIT_KykKihonMain.kbnkey.eq(qIT_KhTtdkRirekiMain.kbnkey) +
                $AND + qIT_KhTtdkRirekiMain.syorikbn.eq(C_SyoriKbn.MEIHEN_HHKKAISEIUKEHENKOU)  +
                $AND + qIT_KhTtdkRirekiMain.syoriYmd.ge(pTaisyoukknFrom) +
                $AND + qIT_KhTtdkRirekiMain.syoriYmd.le(pTaisyoukknTo);

        ExDBResults<MonitoringDataUktHenkouInfoBean> exDBResults = exDBEntityManager.createJPQL(mainSql).
            bind(qIT_KykKihonMain, qIT_KhTtdkRirekiMain, qIT_KhTtdkRirekiSub).getResults(MonitoringDataUktHenkouInfoBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
