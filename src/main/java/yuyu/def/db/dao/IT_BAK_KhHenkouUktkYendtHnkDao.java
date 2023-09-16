package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkYendtHnk;
import java.util.List;

/**
 * 契約保全変更受付内容（円建変更）バックアップテーブル(IT_BAK_KhHenkouUktkYendtHnkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHenkouUktkYendtHnkDao extends AbstractDao<IT_BAK_KhHenkouUktkYendtHnk> {

    public IT_BAK_KhHenkouUktkYendtHnkDao() {
        super(IT_BAK_KhHenkouUktkYendtHnk.class);
    }

    @Deprecated
    public IT_BAK_KhHenkouUktkYendtHnk getBAKKhHenkouUktkYendtHnk(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno) {
        IT_BAK_KhHenkouUktkYendtHnk iT_BAK_KhHenkouUktkYendtHnk =  new IT_BAK_KhHenkouUktkYendtHnk( pSyono,  pTrkssikibetukey,  pHozenhenkouuktkrenno);
        return this.selectOne(iT_BAK_KhHenkouUktkYendtHnk);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhHenkouUktkYendtHnk> selectAll() {
        return super.selectAll();
    }
}
