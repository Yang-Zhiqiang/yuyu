package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_DairitenSyougou;

/**
 * 代理店法人商号マスタ(BM_DairitenSyougouDao) アクセス用の DAO クラスです。<br />
 */
public class BM_DairitenSyougouDao extends AbstractDao<BM_DairitenSyougou> {

    public BM_DairitenSyougouDao() {
        super(BM_DairitenSyougou.class);
    }

    public BM_DairitenSyougou getDairitenSyougou(String pDrtencd){
        BM_DairitenSyougou bM_DairitenSyougou =  new BM_DairitenSyougou();
        bM_DairitenSyougou.setDrtencd(pDrtencd);
        return this.selectOne(bM_DairitenSyougou);
    }
}
