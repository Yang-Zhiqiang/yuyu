package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;

/**
 * Ｄ精算追払管理テーブル(IT_DSeisanTuibaraiKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DSeisanTuibaraiKanriDao extends AbstractDao<IT_DSeisanTuibaraiKanri> {

    public IT_DSeisanTuibaraiKanriDao() {
        super(IT_DSeisanTuibaraiKanri.class);
    }

    public IT_DSeisanTuibaraiKanri getDSeisanTuibaraiKanri(String pSyono, BizDateY pHaitounendo) {
        IT_DSeisanTuibaraiKanri iT_DSeisanTuibaraiKanri =  new IT_DSeisanTuibaraiKanri( pSyono,  pHaitounendo);
        return this.selectOne(iT_DSeisanTuibaraiKanri);
    }
}
