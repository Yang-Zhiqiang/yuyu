package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_NrkDif;

/**
 * 入力差異テーブル(HT_NrkDifDao) アクセス用の DAO クラスです。<br />
 */
public class HT_NrkDifDao extends AbstractDao<HT_NrkDif> {

    public HT_NrkDifDao() {
        super(HT_NrkDif.class);
    }

    @Deprecated
    public HT_NrkDif getNrkDif(String pMosno,
         String pVrfkinouid,
         Integer pRenno3keta){
        HT_NrkDif hT_NrkDif =  new HT_NrkDif();
        hT_NrkDif.setMosno(pMosno);
        hT_NrkDif.setVrfkinouid(pVrfkinouid);
        hT_NrkDif.setRenno3keta(pRenno3keta);
        return this.selectOne(hT_NrkDif);
    }

    @Override
    @Deprecated
    public List<HT_NrkDif> selectAll() {
        return super.selectAll();
    }
}
