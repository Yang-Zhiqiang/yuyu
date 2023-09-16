package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosDairitenVrf;

/**
 * 申込代理店ベリファイテーブル(HT_MosDairitenVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosDairitenVrfDao extends AbstractDao<HT_MosDairitenVrf> {

    public HT_MosDairitenVrfDao() {
        super(HT_MosDairitenVrf.class);
    }

    @Deprecated
    public HT_MosDairitenVrf getMosDairitenVrf(String pMosno,
         Integer pRenno){
        HT_MosDairitenVrf hT_MosDairitenVrf =  new HT_MosDairitenVrf();
        hT_MosDairitenVrf.setMosno(pMosno);
        hT_MosDairitenVrf.setRenno(pRenno);
        return this.selectOne(hT_MosDairitenVrf);
    }

    @Override
    @Deprecated
    public List<HT_MosDairitenVrf> selectAll() {
        return super.selectAll();
    }
}
