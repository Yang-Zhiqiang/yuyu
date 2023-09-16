package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KykSonotaTkyk;

/**
 * 契約その他特約テーブル(IT_KykSonotaTkykDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykSonotaTkykDao extends AbstractDao<IT_KykSonotaTkyk> {

    public IT_KykSonotaTkykDao() {
        super(IT_KykSonotaTkyk.class);
    }

    @Deprecated
    public IT_KykSonotaTkyk getKykSonotaTkyk(String pSyono){
        IT_KykSonotaTkyk iT_KykSonotaTkyk =  new IT_KykSonotaTkyk();
        iT_KykSonotaTkyk.setSyono(pSyono);
        return this.selectOne(iT_KykSonotaTkyk);
    }

    @Override
    @Deprecated
    public List<IT_KykSonotaTkyk> selectAll() {
        return super.selectAll();
    }
}
