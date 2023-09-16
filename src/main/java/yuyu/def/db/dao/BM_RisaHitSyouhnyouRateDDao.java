package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD;

/**
 * 利差配当商品用Ｄレートマスタ(BM_RisaHitSyouhnyouRateDDao) アクセス用の DAO クラスです。<br />
 */
public class BM_RisaHitSyouhnyouRateDDao extends AbstractDao<BM_RisaHitSyouhnyouRateD> {

    public BM_RisaHitSyouhnyouRateDDao() {
        super(BM_RisaHitSyouhnyouRateD.class);
    }

    public BM_RisaHitSyouhnyouRateD getRisaHitSyouhnyouRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode, String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {
        BM_RisaHitSyouhnyouRateD bM_RisaHitSyouhnyouRateD =  new BM_RisaHitSyouhnyouRateD();
        bM_RisaHitSyouhnyouRateD.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RisaHitSyouhnyouRateD.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RisaHitSyouhnyouRateD.setPalyoteiriritu(pPalyoteiriritu);
        bM_RisaHitSyouhnyouRateD.setPalpmencode(pPalpmencode);
        bM_RisaHitSyouhnyouRateD.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RisaHitSyouhnyouRateD.setPalhhknsei(pPalhhknsei);
        bM_RisaHitSyouhnyouRateD.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RisaHitSyouhnyouRateD.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RisaHitSyouhnyouRateD.setPalhokenkikan(pPalhokenkikan);
        bM_RisaHitSyouhnyouRateD.setPalpharaikomikikan(pPalpharaikomikikan);
        bM_RisaHitSyouhnyouRateD.setPaldnendo(pPaldnendo);
        bM_RisaHitSyouhnyouRateD.setPaldratenaikakucode(pPaldratenaikakucode);
        return this.selectOne(bM_RisaHitSyouhnyouRateD);
    }
}
