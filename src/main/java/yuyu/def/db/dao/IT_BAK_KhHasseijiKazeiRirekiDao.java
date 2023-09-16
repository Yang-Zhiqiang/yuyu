package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHasseijiKazeiRireki;
import java.util.List;

/**
 * 契約保全発生時課税履歴バックアップテーブル(IT_BAK_KhHasseijiKazeiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHasseijiKazeiRirekiDao extends AbstractDao<IT_BAK_KhHasseijiKazeiRireki> {

    public IT_BAK_KhHasseijiKazeiRirekiDao() {
        super(IT_BAK_KhHasseijiKazeiRireki.class);
    }

    @Deprecated
    public IT_BAK_KhHasseijiKazeiRireki getBAKKhHasseijiKazeiRireki(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey) {
        IT_BAK_KhHasseijiKazeiRireki iT_BAK_KhHasseijiKazeiRireki =  new IT_BAK_KhHasseijiKazeiRireki( pSyono,  pTrkssikibetukey,  pHenkousikibetukey);
        return this.selectOne(iT_BAK_KhHasseijiKazeiRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhHasseijiKazeiRireki> selectAll() {
        return super.selectAll();
    }
}
