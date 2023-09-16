package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SouseirituKihon;

/**
 * 総成立基本テーブル(HT_SouseirituKihonDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SouseirituKihonDao extends AbstractDao<HT_SouseirituKihon> {

    public HT_SouseirituKihonDao() {
        super(HT_SouseirituKihon.class);
    }

    public HT_SouseirituKihon getSouseirituKihon(String pSyono){
        HT_SouseirituKihon hT_SouseirituKihon =  new HT_SouseirituKihon();
        hT_SouseirituKihon.setSyono(pSyono);
        return this.selectOne(hT_SouseirituKihon);
    }
}
