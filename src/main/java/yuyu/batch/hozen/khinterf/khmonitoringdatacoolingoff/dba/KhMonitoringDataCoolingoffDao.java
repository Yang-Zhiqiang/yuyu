package yuyu.batch.hozen.khinterf.khmonitoringdatacoolingoff.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KykKihon;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（クーリングオフ）Daoクラスです。<br />
 */
public class KhMonitoringDataCoolingoffDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhMonitoringDataCoolingoffBean> getKhMonitoringDataCoolingoffBeans(String pIbKakutyoujobcd,
        BizDate pTaisyoukknFrom, BizDate pTaisyoukknTo) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String sql = $SELECT + $NEW(KhMonitoringDataCoolingoffBean.class,
            qIT_KykKihon,
            qIT_KhShrRireki) +
            $FROM(qIT_KykKihon,
                qIT_KhShrRireki) +
                $WHERE + qIT_KhShrRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.CLGOFF) +
                $AND + qIT_KhShrRireki.kouryokuhasseiymd.ge(pTaisyoukknFrom) +
                $AND + qIT_KhShrRireki.kouryokuhasseiymd.le(pTaisyoukknTo);

        ExDBResults<KhMonitoringDataCoolingoffBean> exDBResults = exDBEntityManager.createJPQL(
            sql, KhMonitoringDataCoolingoffBean.class).bind(qIT_KykKihon, qIT_KhShrRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBResults;
    }
}
