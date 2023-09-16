package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateW;

/**
 * Ｗレートマスタ(BM_RateWDao) アクセス用の DAO クラスです。<br />
 */
public class BM_RateWDao extends AbstractDao<BM_RateW> {

    public BM_RateWDao() {
        super(BM_RateW.class);
    }

    public BM_RateW getRateW(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode, String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn, String pRatedai1hknkkn) {
        BM_RateW bM_RateW =  new BM_RateW();
        bM_RateW.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RateW.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RateW.setPalyoteiriritu(pPalyoteiriritu);
        bM_RateW.setPalpmencode(pPalpmencode);
        bM_RateW.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RateW.setPalhhknsei(pPalhhknsei);
        bM_RateW.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RateW.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RateW.setPalhokenkikan(pPalhokenkikan);
        bM_RateW.setPalpharaikomikikan(pPalpharaikomikikan);
        bM_RateW.setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
        bM_RateW.setRatetuukasyukbn(pRatetuukasyukbn);
        bM_RateW.setRatedai1hknkkn(pRatedai1hknkkn);
        return this.selectOne(bM_RateW);
    }
}
