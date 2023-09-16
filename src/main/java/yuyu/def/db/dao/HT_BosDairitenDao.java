package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BosDairiten;

/**
 * 募集代理店テーブル(HT_BosDairitenDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosDairitenDao extends AbstractDao<HT_BosDairiten> {

    public HT_BosDairitenDao() {
        super(HT_BosDairiten.class);
    }

    @Deprecated
    public HT_BosDairiten getBosDairiten(String pMosno,
         Integer pRenno){
        HT_BosDairiten hT_BosDairiten =  new HT_BosDairiten();
        hT_BosDairiten.setMosno(pMosno);
        hT_BosDairiten.setRenno(pRenno);
        return this.selectOne(hT_BosDairiten);
    }

    @Override
    @Deprecated
    public List<HT_BosDairiten> selectAll() {
        return super.selectAll();
    }
}
