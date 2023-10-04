package yuyu.batch.hozen.khinterf.khmonitoringdatapeps.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（ＰＥＰｓ）Daoクラス<br />
 */
public class KhMonitoringDataPepsDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhMonitoringDataPepsInfosBean> getKhMonitoringDataPepsInfos(String pKakutyoujobcd) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KhTtdkTyuui qIT_KhTtdkTyuui = new QIT_KhTtdkTyuui("qIT_KhTtdkTyuui");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String strSql = $SELECT + $NEW(KhMonitoringDataPepsInfosBean.class,
            qIT_KhTtdkTyuui.kbnkey,
            qIT_KhTtdkTyuui.syono,
            qIT_KykKihon) +
            $FROM(qIT_KykSyouhn,
                qIT_KhTtdkTyuui,
                qIT_KykKihon) +
                $WHERE + qIT_KykSyouhn.syono.eq(qIT_KhTtdkTyuui.syono) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + $(qIT_KhTtdkTyuui.ttdktyuuikbn1.eq(C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU) +
                    $OR + qIT_KhTtdkTyuui.ttdktyuuikbn2.eq(C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU) +
                    $OR + qIT_KhTtdkTyuui.ttdktyuuikbn3.eq(C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU) +
                    $OR + qIT_KhTtdkTyuui.ttdktyuuikbn4.eq(C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU) +
                    $OR + qIT_KhTtdkTyuui.ttdktyuuikbn5.eq(C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU));

        ExDBResults<KhMonitoringDataPepsInfosBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhMonitoringDataPepsInfosBean.class).bind(qIT_KykSyouhn, qIT_KhTtdkTyuui, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}