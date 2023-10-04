package yuyu.batch.hozen.khzeimu.khgensenlistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.meta.QIT_KhShrRireki;

/**
 * 契約保全 税務 源泉徴収リスト作成機能DAOクラス
 */
public class KhGensenListSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KhShrRirekiInfoBean> getKhShrRirekiInfo(String pKakutyouJobCd, BizDate pTysytStartDate,
            BizDate pTysytEndDate) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String strSql = $SELECT + $NEW(IT_KhShrRirekiInfoBean.class,
                qIT_KhShrRireki) +
                $FROM(qIT_KhShrRireki) +
                $WHERE + qIT_KhShrRireki.gsbunritaisyou.eq(C_UmuKbn.ARI) +
                $AND + qIT_KhShrRireki.shrymd.ge(pTysytStartDate) +
                $AND + qIT_KhShrRireki.shrymd.le(pTysytEndDate) +
                $AND + qIT_KhShrRireki.yengstszeigk.gtZero() +
                $ORDER_BY(qIT_KhShrRireki.nztodouhukencd, qIT_KhShrRireki.shrymd, qIT_KhShrRireki.syono);

        ExDBResults<IT_KhShrRirekiInfoBean> exDBResults = exDBEntityManager.createJPQL(
                strSql, IT_KhShrRirekiInfoBean.class).bind(qIT_KhShrRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

}
