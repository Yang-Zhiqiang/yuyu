package yuyu.batch.biz.bzinterf.bzidoutyousyosks.dba;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.meta.QIT_KhIdouTyousyo;

/**
 * 業務共通 インターフェイス 異動調書Ｆ作成機能DAOクラス<br />
 */
public class BzIdouTyousyoSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KhIdouTyousyo> getIdouTyousyosByKakutyoujobcdSyoriYmd(String pKakutyoujobcd,
        BizDate pSyoriYmd) {

        QIT_KhIdouTyousyo qIT_KhIdouTyousyo = new QIT_KhIdouTyousyo("q");

        String strSql = $SELECT + qIT_KhIdouTyousyo +
            $FROM (qIT_KhIdouTyousyo) +
            $WHERE + qIT_KhIdouTyousyo.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<IT_KhIdouTyousyo> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KhIdouTyousyo)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
