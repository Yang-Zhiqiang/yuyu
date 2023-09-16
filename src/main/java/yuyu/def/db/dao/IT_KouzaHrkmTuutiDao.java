package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KouzaHrkmTuuti;

/**
 * 口座振込通知テーブル(IT_KouzaHrkmTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KouzaHrkmTuutiDao extends AbstractDao<IT_KouzaHrkmTuuti> {

    public IT_KouzaHrkmTuutiDao() {
        super(IT_KouzaHrkmTuuti.class);
    }

    public IT_KouzaHrkmTuuti getKouzaHrkmTuuti(String pSyono, Integer pKrkno) {
        IT_KouzaHrkmTuuti iT_KouzaHrkmTuuti =  new IT_KouzaHrkmTuuti( pSyono,  pKrkno);
        return this.selectOne(iT_KouzaHrkmTuuti);
    }

}
