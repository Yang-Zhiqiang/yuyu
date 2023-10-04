package yuyu.batch.hozen.khinterf.khkzhrkmtuutifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KouzaHrkmTuuti;

/**
 * 契約保全 インターフェイス 口座振込通知Ｆ作成DAO
 */
public class KhKzhrkmTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKzhrkmTuutiDataBean> getKzhrkmTuutiDataBeans(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_KouzaHrkmTuuti qIT_KouzaHrkmTuuti = new QIT_KouzaHrkmTuuti("qIT_KouzaHrkmTuuti");

        String strSql = $SELECT + $NEW(KhKzhrkmTuutiDataBean.class,
            qIT_KouzaHrkmTuuti.kbnkey,
            qIT_KouzaHrkmTuuti.syoruiCd,
            qIT_KouzaHrkmTuuti.tyouhyouymd,
            qIT_KouzaHrkmTuuti.syono,
            qIT_KouzaHrkmTuuti.henkousikibetukey,
            qIT_KouzaHrkmTuuti.krkno,
            qIT_KouzaHrkmTuuti.hassoukbn,
            qIT_KouzaHrkmTuuti.shskyno,
            qIT_KouzaHrkmTuuti.shsadr1kj,
            qIT_KouzaHrkmTuuti.shsadr2kj,
            qIT_KouzaHrkmTuuti.shsadr3kj,
            qIT_KouzaHrkmTuuti.shsnmkj,
            qIT_KouzaHrkmTuuti.toiawasesosikinmkj,
            qIT_KouzaHrkmTuuti.toiawaseyno,
            qIT_KouzaHrkmTuuti.toiawaseadr1kj,
            qIT_KouzaHrkmTuuti.toiawaseadr2kj,
            qIT_KouzaHrkmTuuti.toiawaseadr3kj,
            qIT_KouzaHrkmTuuti.toiawasetelno,
            qIT_KouzaHrkmTuuti.toiawaseteluktkkanou1,
            qIT_KouzaHrkmTuuti.toiawaseteluktkkanou2,
            qIT_KouzaHrkmTuuti.toiawasesosikinmkj2,
            qIT_KouzaHrkmTuuti.toiawasetelno2,
            qIT_KouzaHrkmTuuti.hurikomiymd,
            qIT_KouzaHrkmTuuti.shrgk.getTypeFieldName(),
            qIT_KouzaHrkmTuuti.shrgk.getValueFieldName(),
            qIT_KouzaHrkmTuuti.shririyuu1,
            qIT_KouzaHrkmTuuti.shririyuu2,
            qIT_KouzaHrkmTuuti.shririyuu3,
            qIT_KouzaHrkmTuuti.siteikouza1,
            qIT_KouzaHrkmTuuti.siteikouza2,
            qIT_KouzaHrkmTuuti.siteikouza3,
            qIT_KouzaHrkmTuuti.siteikouza4,
            qIT_KouzaHrkmTuuti.siteikouza5) +
            $FROM(qIT_KouzaHrkmTuuti) +
            $WHERE + qIT_KouzaHrkmTuuti.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<KhKzhrkmTuutiDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhKzhrkmTuutiDataBean.class)
            .bind(qIT_KouzaHrkmTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
