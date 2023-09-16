package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;

/**
 * 平準払入金用資金移動リスト作成用テーブル(BT_HijynNykSikinIdouListSksDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HijynNykSikinIdouListSksDao extends AbstractDao<BT_HijynNykSikinIdouListSks> {

    public BT_HijynNykSikinIdouListSksDao() {
        super(BT_HijynNykSikinIdouListSks.class);
    }

    public BT_HijynNykSikinIdouListSks getHijynNykSikinIdouListSks(String pSyono, BizDateYM pSikinidoupjytym) {
        BT_HijynNykSikinIdouListSks bT_HijynNykSikinIdouListSks =  new BT_HijynNykSikinIdouListSks();
        bT_HijynNykSikinIdouListSks.setSyono(pSyono);
        bT_HijynNykSikinIdouListSks.setSikinidoupjytym(pSikinidoupjytym);
        return this.selectOne(bT_HijynNykSikinIdouListSks);
    }
}
