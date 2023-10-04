package yuyu.batch.hozen.khansyuu.khauthorikekkabunritrsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QIT_SkCreditCardTourokuKekka;

/**
 * 契約保全 案内収納 オーソリ結果分離およびＴＲ作成機能DAOクラス
 */
public class KhAuthoriKekkaBunriTrSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<BunrimaeAuthoriKekkaBean> getBunrimaeAuthoriKekka(String pKakutyoujobcd) {

        QIT_BunrimaeAuthoriKekka qIT_BunrimaeAuthoriKekka = new QIT_BunrimaeAuthoriKekka("qIT_BunrimaeAuthoriKekka");

        String sql = $SELECT + $NEW(BunrimaeAuthoriKekkaBean.class,
            qIT_BunrimaeAuthoriKekka.creditkessaiyouno,
            qIT_BunrimaeAuthoriKekka.datajyusinymd,
            qIT_BunrimaeAuthoriKekka.syoriYmd,
            qIT_BunrimaeAuthoriKekka.kaiintourokukbn,
            qIT_BunrimaeAuthoriKekka.creditcardno,
            qIT_BunrimaeAuthoriKekka.cardyuukoukigen4keta,
            qIT_BunrimaeAuthoriKekka.authorigk7keta,
            qIT_BunrimaeAuthoriKekka.authorikekkaerrorcd,
            qIT_BunrimaeAuthoriKekka.bluegateerrorcd,
            qIT_BunrimaeAuthoriKekka.hisimukekaisyacd,
            qIT_BunrimaeAuthoriKekka.wentryuserid,
            qIT_BunrimaeAuthoriKekka.errorcomment,
            qIT_BunrimaeAuthoriKekka.niniinfo,
            qIT_BunrimaeAuthoriKekka.datasyorijyoukyou,
            qIT_BunrimaeAuthoriKekka.gyoumuKousinKinou,
            qIT_BunrimaeAuthoriKekka.gyoumuKousinsyaId,
            qIT_BunrimaeAuthoriKekka.gyoumuKousinTime) +
            $FROM(qIT_BunrimaeAuthoriKekka);

        ExDBResults<BunrimaeAuthoriKekkaBean> exDBResults = exDBEntityManager.createJPQL(
            sql, BunrimaeAuthoriKekkaBean.class).bind(qIT_BunrimaeAuthoriKekka).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public int deleteSkCreditCardTourokuKekka() {

        QIT_SkCreditCardTourokuKekka qIT_SkCreditCardTourokuKekka = new QIT_SkCreditCardTourokuKekka("qIT_SkCreditCardTourokuKekka");

        String sql = $DELETE_FROM(qIT_SkCreditCardTourokuKekka);

        return exDBEntityManager.createJPQL(sql).bind(qIT_SkCreditCardTourokuKekka).executeUpdate();
    }
}
