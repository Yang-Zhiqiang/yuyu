package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * 申込商品テーブル(HT_MosSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosSyouhnDao extends AbstractDao<HT_MosSyouhn> {

    public HT_MosSyouhnDao() {
        super(HT_MosSyouhn.class);
    }

    @Deprecated
    public HT_MosSyouhn getMosSyouhn(String pMosno,
         String pSyouhncd){
        HT_MosSyouhn hT_MosSyouhn =  new HT_MosSyouhn();
        hT_MosSyouhn.setMosno(pMosno);
        hT_MosSyouhn.setSyouhncd(pSyouhncd);
        return this.selectOne(hT_MosSyouhn);
    }

    @Override
    @Deprecated
    public List<HT_MosSyouhn> selectAll() {
        return super.selectAll();
    }
}
