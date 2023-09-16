package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KykSya;

/**
 * 契約者テーブル(IT_KykSyaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykSyaDao extends AbstractDao<IT_KykSya> {

    public IT_KykSyaDao() {
        super(IT_KykSya.class);
    }

    @Deprecated
    public IT_KykSya getKykSya(String pSyono){
        IT_KykSya iT_KykSya =  new IT_KykSya();
        iT_KykSya.setSyono(pSyono);
        return this.selectOne(iT_KykSya);
    }

    @Override
    @Deprecated
    public List<IT_KykSya> selectAll() {
        return super.selectAll();
    }
}
