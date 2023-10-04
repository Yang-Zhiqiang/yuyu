package yuyu.batch.hozen.khinterf.khfatcamonitoringkyk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_FatcaInfo;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;


/**
 * 契約保全 インターフェイス ＦＡＴＣＡモニタリング契約抽出機能DAOクラス
 */
public class KhFatcaMonitoringkykDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean> getKhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbn(
            String pKakutyoujobcd, BizDate pTysytymdFrom, BizDate pTysytymdTo) {

        QIT_FatcaInfo qIT_FatcaInfo = new QIT_FatcaInfo("qIT_FatcaInfo");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        String mainStry = $SELECT + qIT_FatcaInfo + "," +
                qIT_KykKihon + "," +
                qIT_KykSyouhn + "," +
                qIT_KykSya +
                $FROM + qIT_FatcaInfo.IT_FatcaInfo() + "," +
                qIT_KykKihon.IT_KykKihon() + "," +
                qIT_KykSyouhn.IT_KykSyouhn() + "," +
                qIT_KykSya.IT_KykSya()  +
                $WHERE + qIT_FatcaInfo.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_FatcaInfo.syoriYmd.ge(pTysytymdFrom) +
                $AND + qIT_FatcaInfo.syoriYmd.le(pTysytymdTo) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $ORDER_BY (qIT_KykKihon.syono.asc());

        ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean> exDBResults =
                exDBEntityManager.createJPQL(mainStry).bind(qIT_FatcaInfo, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya)
                .getResults(KhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}