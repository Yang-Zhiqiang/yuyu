package yuyu.batch.hozen.khansyuu.khcreditcardtourokukekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KhTRAuthoriKekkaHihoji;

/**
 * 契約保全 案内収納 クレジットカード情報登録結果反映の機能DAOクラス
 */
public class KhCreditCardTourokuKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<AuthoriKekkaTrBean> getAuthoriKekkaTrBeans(String pKakutyoujobcd) {

        QIT_KhTRAuthoriKekkaHihoji qIT_KhTRAuthoriKekkaHihoji = new QIT_KhTRAuthoriKekkaHihoji(
            "qIT_KhTRAuthoriKekkaHihoji");

        String strSql = $SELECT + $NEW(AuthoriKekkaTrBean.class,
            qIT_KhTRAuthoriKekkaHihoji.creditkessaiyouno,
            qIT_KhTRAuthoriKekkaHihoji.syoriYmd,
            qIT_KhTRAuthoriKekkaHihoji.syono,
            qIT_KhTRAuthoriKekkaHihoji.cardbrandkbn,
            qIT_KhTRAuthoriKekkaHihoji.creditkaiinnosimo4keta,
            qIT_KhTRAuthoriKekkaHihoji.authorijkkbn,
            qIT_KhTRAuthoriKekkaHihoji.datajyusinymd) +
            $FROM(qIT_KhTRAuthoriKekkaHihoji);

        ExDBResults<AuthoriKekkaTrBean> exDBResults = exDBEntityManager.createJPQL(strSql, AuthoriKekkaTrBean.class)
            .bind(qIT_KhTRAuthoriKekkaHihoji).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
