package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;

/**
 * 契約保全発生時課税履歴テーブル(IT_KhHasseijiKazeiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHasseijiKazeiRirekiDao extends AbstractDao<IT_KhHasseijiKazeiRireki> {

    public IT_KhHasseijiKazeiRirekiDao() {
        super(IT_KhHasseijiKazeiRireki.class);
    }

    public IT_KhHasseijiKazeiRireki getKhHasseijiKazeiRireki(String pSyono, String pHenkousikibetukey) {
        IT_KhHasseijiKazeiRireki iT_KhHasseijiKazeiRireki =  new IT_KhHasseijiKazeiRireki();
        iT_KhHasseijiKazeiRireki.setSyono(pSyono);
        iT_KhHasseijiKazeiRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_KhHasseijiKazeiRireki);
    }

}
