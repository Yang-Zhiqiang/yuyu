package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_LincKaisyacd;

/**
 * ＬＩＮＣ会社コードマスタ(BM_LincKaisyacdDao) アクセス用の DAO クラスです。<br />
 */
public class BM_LincKaisyacdDao extends AbstractDao<BM_LincKaisyacd> {

    public BM_LincKaisyacdDao() {
        super(BM_LincKaisyacd.class);
    }

    public BM_LincKaisyacd getLincKaisyacd(String pLinckaisyacdnum) {
        BM_LincKaisyacd bM_LincKaisyacd =  new BM_LincKaisyacd();
        bM_LincKaisyacd.setLinckaisyacdnum(pLinckaisyacdnum);
        return this.selectOne(bM_LincKaisyacd);
    }
}
