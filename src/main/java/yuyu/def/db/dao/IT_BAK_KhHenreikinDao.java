package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHenreikin;
import java.util.List;

/**
 * 契約保全返戻金バックアップテーブル(IT_BAK_KhHenreikinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHenreikinDao extends AbstractDao<IT_BAK_KhHenreikin> {

    public IT_BAK_KhHenreikinDao() {
        super(IT_BAK_KhHenreikin.class);
    }

    @Deprecated
    public IT_BAK_KhHenreikin getBAKKhHenreikin(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey) {
        IT_BAK_KhHenreikin iT_BAK_KhHenreikin =  new IT_BAK_KhHenreikin( pSyono,  pTrkssikibetukey,  pHenkousikibetukey);
        return this.selectOne(iT_BAK_KhHenreikin);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhHenreikin> selectAll() {
        return super.selectAll();
    }
}
