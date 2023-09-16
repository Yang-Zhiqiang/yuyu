package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateD;

/**
 * Ｄレートマスタ(BM_RateDDao) アクセス用の DAO クラスです。<br />
 */
public class BM_RateDDao extends AbstractDao<BM_RateD> {

    public BM_RateDDao() {
        super(BM_RateD.class);
    }

    public BM_RateD getRateD(String pPalhokensyuruikigou,
         String pPalhokensyuruikigousdicode,
         String pPalyoteiriritu,
         String pPalpmencode,
         String pPalharaikomikaisuu,
         String pPalhhknsei,
         String pPalkeiyakujihhknnen,
         String pPalsaimankihyouji,
         String pPalhokenkikan,
         String pPalpharaikomikikan,
         String pPaldnendo,
         String pPaldratenaikakucode){
        BM_RateD bM_RateD =  new BM_RateD();
        bM_RateD.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RateD.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RateD.setPalyoteiriritu(pPalyoteiriritu);
        bM_RateD.setPalpmencode(pPalpmencode);
        bM_RateD.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RateD.setPalhhknsei(pPalhhknsei);
        bM_RateD.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RateD.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RateD.setPalhokenkikan(pPalhokenkikan);
        bM_RateD.setPalpharaikomikikan(pPalpharaikomikikan);
        bM_RateD.setPaldnendo(pPaldnendo);
        bM_RateD.setPaldratenaikakucode(pPaldratenaikakucode);
        return this.selectOne(bM_RateD);
    }
}
