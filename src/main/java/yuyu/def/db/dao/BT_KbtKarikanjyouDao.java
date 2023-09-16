package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_KbtKarikanjyou;

/**
 * 個別仮勘定テーブル(BT_KbtKarikanjyouDao) アクセス用の DAO クラスです。<br />
 */
public class BT_KbtKarikanjyouDao extends AbstractDao<BT_KbtKarikanjyou> {

    public BT_KbtKarikanjyouDao() {
        super(BT_KbtKarikanjyou.class);
    }

    public BT_KbtKarikanjyou getKbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey) {
        BT_KbtKarikanjyou bT_KbtKarikanjyou =  new BT_KbtKarikanjyou();
        bT_KbtKarikanjyou.setKbtkarikanjyouskbtkey(pKbtkarikanjyouskbtkey);
        return this.selectOne(bT_KbtKarikanjyou);
    }
}
