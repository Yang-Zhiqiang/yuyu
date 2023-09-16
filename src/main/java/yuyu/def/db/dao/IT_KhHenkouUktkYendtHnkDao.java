package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import java.util.List;

/**
 * 契約保全変更受付内容（円建変更）テーブル(IT_KhHenkouUktkYendtHnkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHenkouUktkYendtHnkDao extends AbstractDao<IT_KhHenkouUktkYendtHnk> {

    public IT_KhHenkouUktkYendtHnkDao() {
        super(IT_KhHenkouUktkYendtHnk.class);
    }

    @Deprecated
    public IT_KhHenkouUktkYendtHnk getKhHenkouUktkYendtHnk(String pSyono, Integer pHozenhenkouuktkrenno) {
        IT_KhHenkouUktkYendtHnk iT_KhHenkouUktkYendtHnk = new IT_KhHenkouUktkYendtHnk(pSyono, pHozenhenkouuktkrenno);
        return this.selectOne(iT_KhHenkouUktkYendtHnk);
    }

    @Override
    @Deprecated
    public List<IT_KhHenkouUktkYendtHnk> selectAll() {
        return super.selectAll();
    }
}
