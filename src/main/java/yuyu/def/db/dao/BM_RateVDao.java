package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateV;

/**
 * Ｖレートマスタ(BM_RateVimport jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateV;
br />
 */
public class BM_RateVDao extends AbstractDao<BM_RateV> {

    public BM_RateVDao() {
        super(BM_RateV.class);
    }

    public BM_RateV getRateV(String pPalhokensyuruikigou,
         String pPalhokensyuruikigousdicode,
         String pPalyoteiriritu,
         String pPalpmencode,
         String pPalharaikomikaisuu,
         String pPalhhknsei,
         String pPalkeiyakujihhknnen,
         String pPalsaimankihyouji,
         String pPalhokenkikan,
         String pPalpharaikomikikan){
        BM_RateV bM_RateV =  new BM_RateV();
        bM_RateV.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RateV.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RateV.setPalyoteiriritu(pPalyoteiriritu);
        bM_RateV.setPalpmencode(pPalpmencode);
        bM_RateV.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RateV.setPalhhknsei(pPalhhknsei);
        bM_RateV.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RateV.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RateV.setPalhokenkikan(pPalhokenkikan);
        bM_RateV.setPalpharaikomikikan(pPalpharaikomikikan);
        return this.selectOne(bM_RateV);
    }
}
