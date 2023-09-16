package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosSyouhnVrf;

/**
 * 申込商品ベリファイテーブル(HT_MosSyouhnVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosSyouhnVrfDao extends AbstractDao<HT_MosSyouhnVrf> {

    public HT_MosSyouhnVrfDao() {
        super(HT_MosSyouhnVrf.class);
    }

    @Deprecated
    public HT_MosSyouhnVrf getMosSyouhnVrf(String pMosno,
         String pSyouhncd){
        HT_MosSyouhnVrf hT_MosSyouhnVrf =  new HT_MosSyouhnVrf();
        hT_MosSyouhnVrf.setMosno(pMosno);
        hT_MosSyouhnVrf.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_MosSyouhnVrf);
    }

    @Override
    @Deprecated
    public List<HT_MosSyouhnVrf> selectAll() {
        return super.selectAll();
    }
}
