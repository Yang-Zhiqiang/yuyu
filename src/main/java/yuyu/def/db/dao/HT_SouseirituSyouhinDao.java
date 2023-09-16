package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SouseirituSyouhin;

/**
 * 総成立商品テーブル(HT_SouseirituSyouhinDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SouseirituSyouhinDao extends AbstractDao<HT_SouseirituSyouhin> {

    public HT_SouseirituSyouhinDao() {
        super(HT_SouseirituSyouhin.class);
    }

    @Deprecated
    public HT_SouseirituSyouhin getSouseirituSyouhin(String pSyono,
         String pSyouhncd){
        HT_SouseirituSyouhin hT_SouseirituSyouhin =  new HT_SouseirituSyouhin();
        hT_SouseirituSyouhin.setSyono(pSyono);
        hT_SouseirituSyouhin.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_SouseirituSyouhin);
    }

    @Override
    @Deprecated
    public List<HT_SouseirituSyouhin> selectAll() {
        return super.selectAll();
    }
}
