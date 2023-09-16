package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;

/**
 * 口座振替未入通知テーブル(IT_KouzahuriMinyuTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KouzahuriMinyuTuutiDao extends AbstractDao<IT_KouzahuriMinyuTuuti> {

    public IT_KouzahuriMinyuTuutiDao() {
        super(IT_KouzahuriMinyuTuuti.class);
    }

    public IT_KouzahuriMinyuTuuti getKouzahuriMinyuTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_KouzahuriMinyuTuuti iT_KouzahuriMinyuTuuti =  new IT_KouzahuriMinyuTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_KouzahuriMinyuTuuti);
    }
}
