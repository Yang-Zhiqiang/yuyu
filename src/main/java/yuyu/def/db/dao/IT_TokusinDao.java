package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_Tokusin;

/**
 * 特伸テーブル(IT_TokusinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TokusinDao extends AbstractDao<IT_Tokusin> {

    public IT_TokusinDao() {
        super(IT_Tokusin.class);
    }

    @Deprecated
    public IT_Tokusin getTokusin(String pSyono){
        IT_Tokusin iT_Tokusin =  new IT_Tokusin();
        iT_Tokusin.setSyono(pSyono);
        return this.selectOne(iT_Tokusin);
    }

    @Override
    @Deprecated
    public List<IT_Tokusin> selectAll() {
        return super.selectAll();
    }
}
