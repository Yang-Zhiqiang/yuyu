package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateP;

/**
 * Ｐレートマスタ(BM_RatePDao) アクセス用の DAO クラスです。<br />
 */
public class BM_RatePDao extends AbstractDao<BM_RateP> {

    public BM_RatePDao() {
        super(BM_RateP.class);
    }

    public BM_RateP getRateP(String pPalhokensyuruikigou,
         String pPalhokensyuruikigousdicode,
         String pPalyoteiriritu,
         String pPalpmencode,
         String pPalharaikomikaisuu,
         String pPalhhknsei,
         String pPalkeiyakujihhknnen,
         String pPalsaimankihyouji,
         String pPalhokenkikan,
         String pPalpharaikomikikan){
        BM_RateP bM_RateP =  new BM_RateP();
        bM_RateP.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RateP.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RateP.setPalyoteiriritu(pPalyoteiriritu);
        bM_RateP.setPalpmencode(pPalpmencode);
        bM_RateP.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RateP.setPalhhknsei(pPalhhknsei);
        bM_RateP.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RateP.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RateP.setPalhokenkikan(pPalhokenkikan);
        bM_RateP.setPalpharaikomikikan(pPalpharaikomikikan);
        return this.selectOne(bM_RateP);
    }
}
