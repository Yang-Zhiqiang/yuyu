package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;

/**
 * 被災害分割案内方法管理テーブル(IT_HsgbnktAnnaihouhoukanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HsgbnktAnnaihouhoukanriDao extends AbstractDao<IT_HsgbnktAnnaihouhoukanri> {

    public IT_HsgbnktAnnaihouhoukanriDao() {
        super(IT_HsgbnktAnnaihouhoukanri.class);
    }

    public IT_HsgbnktAnnaihouhoukanri getHsgbnktAnnaihouhoukanri(String pSyono, BizDate pHsgymd) {
        IT_HsgbnktAnnaihouhoukanri iT_HsgbnktAnnaihouhoukanri = new IT_HsgbnktAnnaihouhoukanri(pSyono, pHsgymd);
        return this.selectOne(iT_HsgbnktAnnaihouhoukanri);
    }
}
