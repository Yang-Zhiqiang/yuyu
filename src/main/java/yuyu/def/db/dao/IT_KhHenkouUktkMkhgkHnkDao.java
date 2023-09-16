package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import java.util.List;

/**
 * 契約保全変更受付内容（目標額変更）テーブル(IT_KhHenkouUktkMkhgkHnkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHenkouUktkMkhgkHnkDao extends AbstractDao<IT_KhHenkouUktkMkhgkHnk> {

    public IT_KhHenkouUktkMkhgkHnkDao() {
        super(IT_KhHenkouUktkMkhgkHnk.class);
    }

    @Deprecated
    public IT_KhHenkouUktkMkhgkHnk getKhHenkouUktkMkhgkHnk(String pSyono, Integer pHozenhenkouuktkrenno) {
        IT_KhHenkouUktkMkhgkHnk iT_KhHenkouUktkMkhgkHnk =  new IT_KhHenkouUktkMkhgkHnk( pSyono,  pHozenhenkouuktkrenno);
        return this.selectOne(iT_KhHenkouUktkMkhgkHnk);
    }

    @Override
    @Deprecated
    public List<IT_KhHenkouUktkMkhgkHnk> selectAll() {
        return super.selectAll();
    }
}
