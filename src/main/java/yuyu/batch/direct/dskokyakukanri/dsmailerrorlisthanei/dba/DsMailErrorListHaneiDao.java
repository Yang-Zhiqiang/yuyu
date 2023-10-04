package yuyu.batch.direct.dskokyakukanri.dsmailerrorlisthanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti2;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * メールエラーリストＦ反映 の機能DAOクラス
 */
public class DsMailErrorListHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public String getDsHanyouKokyakuateTuuti2MaxDskoktuutirennoByDsdatasakuseiymd(BizDate pDsDataDakuseiYmd) {

        QMT_DsHanyouKokyakuateTuuti2 qMT_DsHanyouKokyakuateTuuti2 = new QMT_DsHanyouKokyakuateTuuti2("qMT_DsHanyouKokyakuateTuuti2");

        String strSql = $SELECT + $MAX(qMT_DsHanyouKokyakuateTuuti2.dskoktuutirenno) +
            $FROM(qMT_DsHanyouKokyakuateTuuti2) +
            $WHERE + qMT_DsHanyouKokyakuateTuuti2.dsdatasakuseiymd.eq(pDsDataDakuseiYmd) +
            $GROUP_BY + $(qMT_DsHanyouKokyakuateTuuti2.dsdatasakuseiymd);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsHanyouKokyakuateTuuti2).getSingleResult();
    }

}
