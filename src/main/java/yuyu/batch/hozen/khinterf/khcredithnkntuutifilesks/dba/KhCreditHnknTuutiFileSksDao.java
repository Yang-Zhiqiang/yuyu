package yuyu.batch.hozen.khinterf.khcredithnkntuutifilesks.dba;


import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_CreditHnknTuuti;

/**
 * 契約保全 インターフェイス クレカ返金通知Ｆ作成の機能DAOクラス
 */
public class KhCreditHnknTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhCredithnknTuutiDataBean> getKhCredithnknTuutiDataBeans(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_CreditHnknTuuti qIT_CreditHnknTuuti = new QIT_CreditHnknTuuti("qIT_CreditHnknTuuti");

        String strSql = $SELECT + $NEW(KhCredithnknTuutiDataBean.class,
            qIT_CreditHnknTuuti.syono,
            qIT_CreditHnknTuuti.tyouhyouymd,
            qIT_CreditHnknTuuti.henkousikibetukey,
            qIT_CreditHnknTuuti.hassoukbn,
            qIT_CreditHnknTuuti.shskyno,
            qIT_CreditHnknTuuti.shsadr1kj,
            qIT_CreditHnknTuuti.shsadr2kj,
            qIT_CreditHnknTuuti.shsadr3kj,
            qIT_CreditHnknTuuti.shsnmkj,
            qIT_CreditHnknTuuti.toiawasesosikinmkj,
            qIT_CreditHnknTuuti.toiawaseyno,
            qIT_CreditHnknTuuti.toiawaseadr1kj,
            qIT_CreditHnknTuuti.toiawaseadr2kj,
            qIT_CreditHnknTuuti.toiawaseadr3kj,
            qIT_CreditHnknTuuti.toiawasetelno,
            qIT_CreditHnknTuuti.toiawaseteluktkkanou1,
            qIT_CreditHnknTuuti.toiawaseteluktkkanou2,
            qIT_CreditHnknTuuti.toiawasesosikinmkj2,
            qIT_CreditHnknTuuti.toiawasetelno2,
            qIT_CreditHnknTuuti.shrriyuukbn,
            qIT_CreditHnknTuuti.uriageseikyuuymd,
            qIT_CreditHnknTuuti.hnkngk.getTypeFieldName(),
            qIT_CreditHnknTuuti.hnkngk.getValueFieldName(),
            qIT_CreditHnknTuuti.krkriyuukbn,
            qIT_CreditHnknTuuti.uriageymd,
            qIT_CreditHnknTuuti.uriagegk.getTypeFieldName(),
            qIT_CreditHnknTuuti.uriagegk.getValueFieldName(),
            qIT_CreditHnknTuuti.jyuutouym,
            qIT_CreditHnknTuuti.jyutoukaisuum,
            qIT_CreditHnknTuuti.hnkntaisyouinjiflg,
            qIT_CreditHnknTuuti.kbnkey) +
            $FROM(qIT_CreditHnknTuuti) +
            $WHERE + qIT_CreditHnknTuuti.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<KhCredithnknTuutiDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KhCredithnknTuutiDataBean.class).bind(qIT_CreditHnknTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
