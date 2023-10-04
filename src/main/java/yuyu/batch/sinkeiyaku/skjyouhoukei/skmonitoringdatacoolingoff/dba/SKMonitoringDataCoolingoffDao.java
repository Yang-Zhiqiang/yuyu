package yuyu.batch.sinkeiyaku.skjyouhoukei.skmonitoringdatacoolingoff.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_DakuhiKettei;
import yuyu.def.db.meta.QHT_SyoriCTL;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 新契約 情報系 新契約モニタリングデータ抽出（クーリングオフ）の機能DAOクラスです
 */
public class SKMonitoringDataCoolingoffDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymdHuseirituItems(String pIbKakutyoujobcd,
        BizDate pTaisyoukknFrom, BizDate pTaisyoukknTo) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_DakuhiKettei qHT_DakuhiKettei1 = new QHT_DakuhiKettei("qHT_DakuhiKettei1");
        QHT_DakuhiKettei qHT_DakuhiKettei2 = new QHT_DakuhiKettei("qHT_DakuhiKettei2");

        String subSql1 = $SELECT + $MAX(qHT_DakuhiKettei2.dakuhiktrenno) +
            $FROM(qHT_DakuhiKettei2) +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_DakuhiKettei2.mosno);

        String sql = $SELECT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL,
                qHT_DakuhiKettei1) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_DakuhiKettei1.mosno) +
                $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.HUSEIRITU) +
                $AND + qHT_SyoriCTL.srsyoriymd.ge(pTaisyoukknFrom) +
                $AND + qHT_SyoriCTL.srsyoriymd.le(pTaisyoukknTo) +
                $AND + qHT_DakuhiKettei1.dakuhiktrenno + $EQ + $(subSql1) +
                $AND + $(qHT_DakuhiKettei1.ketkekkacd.eq(C_Ketkekkacd.MOS_TORIKESI)+
                    $OR + qHT_DakuhiKettei1.ketkekkacd.eq(C_Ketkekkacd.COOLINGOFF)) +
                    $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        ExDBResults<HT_SyoriCTL> exDBResults = exDBEntityManager.createJPQL(sql).bind(qHT_SyoriCTL, qHT_DakuhiKettei1, qHT_DakuhiKettei2).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBResults;
    }

}
