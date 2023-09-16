package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateV2;
import yuyu.def.db.meta.QBM_RateV2;

/**
 * Ｖレートマスタ２(BM_RateV2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_RateV2Dao extends AbstractDao<BM_RateV2> {

    public BM_RateV2Dao() {
        super(BM_RateV2.class);
    }

    public BM_RateV2 getRateV2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode, String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn, String pRatedai1hknkkn) {
        BM_RateV2 bM_RateV2 =  new BM_RateV2();
        bM_RateV2.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RateV2.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RateV2.setPalyoteiriritu(pPalyoteiriritu);
        bM_RateV2.setPalpmencode(pPalpmencode);
        bM_RateV2.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RateV2.setPalhhknsei(pPalhhknsei);
        bM_RateV2.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RateV2.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RateV2.setPalhokenkikan(pPalhokenkikan);
        bM_RateV2.setPalpharaikomikikan(pPalpharaikomikikan);
        bM_RateV2.setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
        bM_RateV2.setRatetuukasyukbn(pRatetuukasyukbn);
        bM_RateV2.setRatedai1hknkkn(pRatedai1hknkkn);
        return this.selectOne(bM_RateV2);
    }

    public BM_RateV2 getRateV2byRateVkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode,
        String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan) {


        QBM_RateV2 qBM_RateV2 = new QBM_RateV2("qBM_RateV2");


        String queryStr = $SELECT + qBM_RateV2 +
            $FROM (qBM_RateV2) +
            $WHERE + qBM_RateV2.palhokensyuruikigou.eq(pPalhokensyuruikigou) +
            $AND + qBM_RateV2.palhokensyuruikigousdicode.eq(pPalhokensyuruikigousdicode) +
            $AND + qBM_RateV2.palyoteiriritu.eq(pPalyoteiriritu) +
            $AND + qBM_RateV2.palpmencode.eq(pPalpmencode) +
            $AND + qBM_RateV2.palharaikomikaisuu.eq(pPalharaikomikaisuu) +
            $AND + qBM_RateV2.palhhknsei.eq(pPalhhknsei) +
            $AND + qBM_RateV2.palkeiyakujihhknnen.eq(pPalkeiyakujihhknnen) +
            $AND + qBM_RateV2.palsaimankihyouji.eq(pPalsaimankihyouji) +
            $AND + qBM_RateV2.palhokenkikan.eq(pPalhokenkikan) +
            $AND + qBM_RateV2.palpharaikomikikan.eq(pPalpharaikomikikan);


        return em.createJPQL(queryStr).bind(qBM_RateV2).getSingleResult();
    }
}
