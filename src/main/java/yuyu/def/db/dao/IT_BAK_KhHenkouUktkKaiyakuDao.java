package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkKaiyaku;
import java.util.List;

/**
 * 契約保全変更受付内容（解約）バックアップテーブル(IT_BAK_KhHenkouUktkKaiyakuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHenkouUktkKaiyakuDao extends AbstractDao<IT_BAK_KhHenkouUktkKaiyaku> {

    public IT_BAK_KhHenkouUktkKaiyakuDao() {
        super(IT_BAK_KhHenkouUktkKaiyaku.class);
    }

    @Deprecated
    public IT_BAK_KhHenkouUktkKaiyaku getBAKKhHenkouUktkKaiyaku(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno) {
        IT_BAK_KhHenkouUktkKaiyaku iT_BAK_KhHenkouUktkKaiyaku =  new IT_BAK_KhHenkouUktkKaiyaku( pSyono,  pTrkssikibetukey,  pHozenhenkouuktkrenno);
        return this.selectOne(iT_BAK_KhHenkouUktkKaiyaku);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhHenkouUktkKaiyaku> selectAll() {
        return super.selectAll();
    }
}
