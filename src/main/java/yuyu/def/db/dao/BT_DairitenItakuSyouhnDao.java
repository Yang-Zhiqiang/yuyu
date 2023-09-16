package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;

/**
 * 代理店委託商品情報テーブル(BT_DairitenItakuSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class BT_DairitenItakuSyouhnDao extends AbstractDao<BT_DairitenItakuSyouhn> {

    public BT_DairitenItakuSyouhnDao() {
        super(BT_DairitenItakuSyouhn.class);
    }

    public BT_DairitenItakuSyouhn getDairitenItakuSyouhn(String pDrtencd, String pDrtsyouhinsikibetukbnstr, String pDrthrkhouhoukbn, String pDrtplannmkbn, BizDate pItakuhknhnbkaisiymd) {
        BT_DairitenItakuSyouhn bT_DairitenItakuSyouhn =  new BT_DairitenItakuSyouhn();
        bT_DairitenItakuSyouhn.setDrtencd(pDrtencd);
        bT_DairitenItakuSyouhn.setDrtsyouhinsikibetukbnstr(pDrtsyouhinsikibetukbnstr);
        bT_DairitenItakuSyouhn.setDrthrkhouhoukbn(pDrthrkhouhoukbn);
        bT_DairitenItakuSyouhn.setDrtplannmkbn(pDrtplannmkbn);
        bT_DairitenItakuSyouhn.setItakuhknhnbkaisiymd(pItakuhknhnbkaisiymd);
        return this.selectOne(bT_DairitenItakuSyouhn);
    }
}
