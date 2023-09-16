package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_DattaiUktk;

/**
 * 脱退受付テーブル(IT_DattaiUktkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DattaiUktkDao extends AbstractDao<IT_DattaiUktk> {

    public IT_DattaiUktkDao() {
        super(IT_DattaiUktk.class);
    }

    @Deprecated
    public IT_DattaiUktk getDattaiUktk(String pSyono){
        IT_DattaiUktk iT_DattaiUktk =  new IT_DattaiUktk();
        iT_DattaiUktk.setSyono(pSyono);
        return this.selectOne(iT_DattaiUktk);
    }

    @Override
    @Deprecated
    public List<IT_DattaiUktk> selectAll() {
        return super.selectAll();
    }
}
