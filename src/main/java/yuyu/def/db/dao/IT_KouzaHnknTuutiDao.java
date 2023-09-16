package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;

/**
 * 口座返金通知テーブル(IT_KouzaHnknTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KouzaHnknTuutiDao extends AbstractDao<IT_KouzaHnknTuuti> {

    public IT_KouzaHnknTuutiDao() {
        super(IT_KouzaHnknTuuti.class);
    }

    public IT_KouzaHnknTuuti getKouzaHnknTuuti(String pSyono, String pDenrenno, Integer pEdano) {
        IT_KouzaHnknTuuti iT_KouzaHnknTuuti =  new IT_KouzaHnknTuuti( pSyono,  pDenrenno,  pEdano);
        return this.selectOne(iT_KouzaHnknTuuti);
    }

}
