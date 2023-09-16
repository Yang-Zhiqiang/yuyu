package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateNenkinD;

/**
 * 年金開始後Ｄレートマスタ(BM_RateNenkinDDao) アクセス用の DAO クラスです。<br />
 */
public class BM_RateNenkinDDao extends AbstractDao<BM_RateNenkinD> {

    public BM_RateNenkinDDao() {
        super(BM_RateNenkinD.class);
    }

    public BM_RateNenkinD getRateNenkinD(String pPalnenkinsisutemusyurui,
         String pPalnenkinsyuruikigou,
         String pPalnenkinkigousedaicode,
         String pPalnenkinsiharaikikan,
         String pPalnnknksgyoteiriritucode,
         String pPalnnknksgjmtesuuryoucode,
         String pPaldnendo,
         String pPaldratenaikakucode){
        BM_RateNenkinD bM_RateNenkinD =  new BM_RateNenkinD();
        bM_RateNenkinD.setPalnenkinsisutemusyurui(pPalnenkinsisutemusyurui);
        bM_RateNenkinD.setPalnenkinsyuruikigou(pPalnenkinsyuruikigou);
        bM_RateNenkinD.setPalnenkinkigousedaicode(pPalnenkinkigousedaicode);
        bM_RateNenkinD.setPalnenkinsiharaikikan(pPalnenkinsiharaikikan);
        bM_RateNenkinD.setPalnnknksgyoteiriritucode(pPalnnknksgyoteiriritucode);
        bM_RateNenkinD.setPalnnknksgjmtesuuryoucode(pPalnnknksgjmtesuuryoucode);
        bM_RateNenkinD.setPaldnendo(pPaldnendo);
        bM_RateNenkinD.setPaldratenaikakucode(pPaldratenaikakucode);
        return this.selectOne(bM_RateNenkinD);
    }
}
