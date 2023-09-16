package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;

/**
 * 期日到来案内テーブル(IT_KijituTouraiAnnaiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KijituTouraiAnnaiDao extends AbstractDao<IT_KijituTouraiAnnai> {

    public IT_KijituTouraiAnnaiDao() {
        super(IT_KijituTouraiAnnai.class);
    }

    public IT_KijituTouraiAnnai getKijituTouraiAnnai(String pSyono, BizDate pTyouhyouymd) {
        IT_KijituTouraiAnnai iT_KijituTouraiAnnai =  new IT_KijituTouraiAnnai( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_KijituTouraiAnnai);
    }
}
