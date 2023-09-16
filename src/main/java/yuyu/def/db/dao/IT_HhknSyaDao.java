package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_HhknSya;

/**
 * 被保険者テーブル(IT_HhknSyaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HhknSyaDao extends AbstractDao<IT_HhknSya> {

    public IT_HhknSyaDao() {
        super(IT_HhknSya.class);
    }

    @Deprecated
    public IT_HhknSya getHhknSya(String pSyono){
        IT_HhknSya iT_HhknSya =  new IT_HhknSya();
        iT_HhknSya.setSyono(pSyono);
        return this.selectOne(iT_HhknSya);
    }

    @Override
    @Deprecated
    public List<IT_HhknSya> selectAll() {
        return super.selectAll();
    }
}
