package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KykSonotaTkyk;

/**
 * 契約その他特約バックアップテーブル(IT_BAK_KykSonotaTkykDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykSonotaTkykDao extends AbstractDao<IT_BAK_KykSonotaTkyk> {

    public IT_BAK_KykSonotaTkykDao() {
        super(IT_BAK_KykSonotaTkyk.class);
    }

    @Deprecated
    public IT_BAK_KykSonotaTkyk getBAKKykSonotaTkyk(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_KykSonotaTkyk iT_BAK_KykSonotaTkyk =  new IT_BAK_KykSonotaTkyk();
        iT_BAK_KykSonotaTkyk.setSyono(pSyono);
        iT_BAK_KykSonotaTkyk.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_KykSonotaTkyk);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykSonotaTkyk> selectAll() {
        return super.selectAll();
    }
}
