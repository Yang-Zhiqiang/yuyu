package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;

/**
 * 契約保全変更受付内容（解約）テーブル(IT_KhHenkouUktkKaiyakuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHenkouUktkKaiyakuDao extends AbstractDao<IT_KhHenkouUktkKaiyaku> {

    public IT_KhHenkouUktkKaiyakuDao() {
        super(IT_KhHenkouUktkKaiyaku.class);
    }

    @Deprecated
    public IT_KhHenkouUktkKaiyaku getKhHenkouUktkKaiyaku(String pSyono, Integer pHozenhenkouuktkrenno) {
        IT_KhHenkouUktkKaiyaku iT_KhHenkouUktkKaiyaku =  new IT_KhHenkouUktkKaiyaku();
        iT_KhHenkouUktkKaiyaku.setSyono(pSyono);
        iT_KhHenkouUktkKaiyaku.setHozenhenkouuktkrenno(pHozenhenkouuktkrenno);
        return this.selectOne(iT_KhHenkouUktkKaiyaku);
    }

    @Override
    @Deprecated
    public List<IT_KhHenkouUktkKaiyaku> selectAll() {
        return super.selectAll();
    }
}
