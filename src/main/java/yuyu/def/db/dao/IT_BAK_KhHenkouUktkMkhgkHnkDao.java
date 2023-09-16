package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkMkhgkHnk;
import java.util.List;

/**
 * 契約保全変更受付内容（目標額変更）バックアップテーブル(IT_BAK_KhHenkouUktkMkhgkHnkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHenkouUktkMkhgkHnkDao extends AbstractDao<IT_BAK_KhHenkouUktkMkhgkHnk> {

    public IT_BAK_KhHenkouUktkMkhgkHnkDao() {
        super(IT_BAK_KhHenkouUktkMkhgkHnk.class);
    }

    @Deprecated
    public IT_BAK_KhHenkouUktkMkhgkHnk getBAKKhHenkouUktkMkhgkHnk(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno) {
        IT_BAK_KhHenkouUktkMkhgkHnk iT_BAK_KhHenkouUktkMkhgkHnk =  new IT_BAK_KhHenkouUktkMkhgkHnk( pSyono,  pTrkssikibetukey,  pHozenhenkouuktkrenno);
        return this.selectOne(iT_BAK_KhHenkouUktkMkhgkHnk);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhHenkouUktkMkhgkHnk> selectAll() {
        return super.selectAll();
    }
}
