package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateP2;
import yuyu.def.db.meta.QBM_RateP2;

/**
 * Ｐレートマスタ２(BM_RateP2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_RateP2Dao extends AbstractDao<BM_RateP2> {

    public BM_RateP2Dao() {
        super(BM_RateP2.class);
    }

    public BM_RateP2 getRateP2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode, String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn, String pRatedai1hknkkn, String pPalryouritukbn) {
        BM_RateP2 bM_RateP2 =  new BM_RateP2();
        bM_RateP2.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RateP2.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RateP2.setPalyoteiriritu(pPalyoteiriritu);
        bM_RateP2.setPalpmencode(pPalpmencode);
        bM_RateP2.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RateP2.setPalhhknsei(pPalhhknsei);
        bM_RateP2.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RateP2.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RateP2.setPalhokenkikan(pPalhokenkikan);
        bM_RateP2.setPalpharaikomikikan(pPalpharaikomikikan);
        bM_RateP2.setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
        bM_RateP2.setRatetuukasyukbn(pRatetuukasyukbn);
        bM_RateP2.setRatedai1hknkkn(pRatedai1hknkkn);
        bM_RateP2.setPalryouritukbn(pPalryouritukbn);
        return this.selectOne(bM_RateP2);
    }

    public BM_RateP2 getRateP2byRatePkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode, String pPalharaikomikaisuu,
        String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan) {


        QBM_RateP2 qBM_RateP2 = new QBM_RateP2("qBM_RateP2");


        String queryStr = $SELECT + qBM_RateP2 +
            $FROM (qBM_RateP2) +
            $WHERE + qBM_RateP2.palhokensyuruikigou.eq(pPalhokensyuruikigou) +
            $AND + qBM_RateP2.palhokensyuruikigousdicode.eq(pPalhokensyuruikigousdicode) +
            $AND + qBM_RateP2.palyoteiriritu.eq(pPalyoteiriritu) +
            $AND + qBM_RateP2.palpmencode.eq(pPalpmencode) +
            $AND + qBM_RateP2.palharaikomikaisuu.eq(pPalharaikomikaisuu) +
            $AND + qBM_RateP2.palhhknsei.eq(pPalhhknsei) +
            $AND + qBM_RateP2.palkeiyakujihhknnen.eq(pPalkeiyakujihhknnen) +
            $AND + qBM_RateP2.palsaimankihyouji.eq(pPalsaimankihyouji) +
            $AND + qBM_RateP2.palhokenkikan.eq(pPalhokenkikan) +
            $AND + qBM_RateP2.palpharaikomikikan.eq(pPalpharaikomikikan);


        return em.createJPQL(queryStr).bind(qBM_RateP2).getSingleResult();
    }
}
