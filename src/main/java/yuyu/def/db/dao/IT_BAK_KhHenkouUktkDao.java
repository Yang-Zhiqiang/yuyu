package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;

/**
 * 契約保全変更受付バックアップテーブル(IT_BAK_KhHenkouUktkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHenkouUktkDao extends AbstractDao<IT_BAK_KhHenkouUktk> {

    public IT_BAK_KhHenkouUktkDao() {
        super(IT_BAK_KhHenkouUktk.class);
    }

    public IT_BAK_KhHenkouUktk getBAKKhHenkouUktk(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno) {
        IT_BAK_KhHenkouUktk iT_BAK_KhHenkouUktk =  new IT_BAK_KhHenkouUktk( pSyono,  pTrkssikibetukey,  pHozenhenkouuktkrenno);
        return this.selectOne(iT_BAK_KhHenkouUktk);
    }

    public List<IT_BAK_KhHenkouUktk> getBAKKhHenkouUktksBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        IT_BAK_KhHenkouUktk iT_BAK_KhHenkouUktk = new IT_BAK_KhHenkouUktk();
        iT_BAK_KhHenkouUktk.setSyono(pSyono);
        iT_BAK_KhHenkouUktk.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(iT_BAK_KhHenkouUktk);
    }

}
