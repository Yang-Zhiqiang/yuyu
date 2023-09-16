package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;

/**
 * 年金開始後Ｐ基礎Ｖレートマスタ(import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
an 新規作成<br />
 */
public class BM_RateNenkinPkisoVDao extends AbstractDao<BM_RateNenkinPkisoV> {

    public BM_RateNenkinPkisoVDao() {
        super(BM_RateNenkinPkisoV.class);
    }

    public BM_RateNenkinPkisoV getRateNenkinPkisoV(String pPalnenkinsisutemusyurui,
         String pPalnenkinsyuruikigou,
         String pPalnenkinkigousedaicode,
         String pPalnenkinsiharaikikan,
         String pPalnnknksgyoteiriritucode,
         String pPalnnknksgjmtesuuryoucode){
        BM_RateNenkinPkisoV bM_RateNenkinPkisoV =  new BM_RateNenkinPkisoV();
        bM_RateNenkinPkisoV.setPalnenkinsisutemusyurui(pPalnenkinsisutemusyurui);
        bM_RateNenkinPkisoV.setPalnenkinsyuruikigou(pPalnenkinsyuruikigou);
        bM_RateNenkinPkisoV.setPalnenkinkigousedaicode(pPalnenkinkigousedaicode);
        bM_RateNenkinPkisoV.setPalnenkinsiharaikikan(pPalnenkinsiharaikikan);
        bM_RateNenkinPkisoV.setPalnnknksgyoteiriritucode(pPalnnknksgyoteiriritucode);
        bM_RateNenkinPkisoV.setPalnnknksgjmtesuuryoucode(pPalnnknksgjmtesuuryoucode);
        return this.selectOne(bM_RateNenkinPkisoV);
    }
}
