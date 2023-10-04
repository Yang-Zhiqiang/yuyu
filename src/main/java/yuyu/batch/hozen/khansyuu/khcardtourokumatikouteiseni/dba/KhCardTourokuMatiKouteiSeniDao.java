package yuyu.batch.hozen.khansyuu.khcardtourokumatikouteiseni.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.meta.QIT_CardTourokuMati;
import yuyu.def.db.meta.QIT_HrhnCreditCardTouroku;

/**
 * 契約保全 案内収納 カード情報登録待ち契約工程遷移処理の機能DAOクラス
 * @author  桑　海東
 * @version 2019/10/18 桑　海東 : 新規作成<br />
 */
public class KhCardTourokuMatiKouteiSeniDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<CardTourokuMatiBean> getCardTourokuMatiBeans(String pKakutyouJobCd) {

        QIT_CardTourokuMati qIT_CardTourokuMati = new QIT_CardTourokuMati("qIT_CardTourokuMati");

        String sql =  $SELECT + $NEW(CardTourokuMatiBean.class,
            qIT_CardTourokuMati.kouteikanriid,
            qIT_CardTourokuMati.creditkessaiyouno) +
            $FROM(qIT_CardTourokuMati) +
            $WHERE + qIT_CardTourokuMati.syorizumiflg.eq(C_Syorizumiflg.MISYORI);

        ExDBResults<CardTourokuMatiBean> exDBResults = exDBEntityManager.createJPQL(sql,
            CardTourokuMatiBean.class).bind(qIT_CardTourokuMati).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Long getHrhnCreditCardTourokuCount(String pCreditKessaiyouNo) {

        QIT_HrhnCreditCardTouroku qIT_HrhnCreditCardTouroku = new QIT_HrhnCreditCardTouroku("qIT_HrhnCreditCardTouroku");

        String sql =  $SELECT + $COUNT + "(" + qIT_HrhnCreditCardTouroku.creditkessaiyouno + ")" + $AS + "kensuu" +
            $FROM(qIT_HrhnCreditCardTouroku) +
            $WHERE + qIT_HrhnCreditCardTouroku.creditkessaiyouno.eq(pCreditKessaiyouNo) +
            $AND + qIT_HrhnCreditCardTouroku.authorijkkbn.eq(C_AuthorijkKbn.OK);

        return exDBEntityManager.createJPQL(sql).bind(qIT_HrhnCreditCardTouroku).<Long>getSingleResult().longValue();
    }
}
