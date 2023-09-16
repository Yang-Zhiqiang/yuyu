package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SouseirituDairiten;

/**
 * 総成立代理店テーブル(HT_SouseirituDairitenDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SouseirituDairitenDao extends AbstractDao<HT_SouseirituDairiten> {

    public HT_SouseirituDairitenDao() {
        super(HT_SouseirituDairiten.class);
    }

    @Deprecated
    public HT_SouseirituDairiten getSouseirituDairiten(String pSyono,
         Integer pRenno){
        HT_SouseirituDairiten hT_SouseirituDairiten =  new HT_SouseirituDairiten();
        hT_SouseirituDairiten.setSyono(pSyono);
        hT_SouseirituDairiten.setRenno(pRenno);
        return this.selectOne(hT_SouseirituDairiten);
    }

    @Override
    @Deprecated
    public List<HT_SouseirituDairiten> selectAll() {
        return super.selectAll();
    }
}
