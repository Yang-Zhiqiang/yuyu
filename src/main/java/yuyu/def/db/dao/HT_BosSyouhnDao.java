package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BosSyouhn;

/**
 * 募集商品テーブル(HT_BosSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosSyouhnDao extends AbstractDao<HT_BosSyouhn> {

    public HT_BosSyouhnDao() {
        super(HT_BosSyouhn.class);
    }

    @Deprecated
    public HT_BosSyouhn getBosSyouhn(String pMosno,
         String pSyouhncd){
        HT_BosSyouhn hT_BosSyouhn =  new HT_BosSyouhn();
        hT_BosSyouhn.setMosno(pMosno);
        hT_BosSyouhn.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_BosSyouhn);
    }

    @Override
    @Deprecated
    public List<HT_BosSyouhn> selectAll() {
        return super.selectAll();
    }
}
