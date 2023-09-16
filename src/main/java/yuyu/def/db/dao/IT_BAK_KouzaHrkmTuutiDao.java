package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KouzaHrkmTuuti;

/**
 * 口座振込通知バックアップテーブル(IT_BAK_KouzaHrkmTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KouzaHrkmTuutiDao extends AbstractDao<IT_BAK_KouzaHrkmTuuti> {

    public IT_BAK_KouzaHrkmTuutiDao() {
        super(IT_BAK_KouzaHrkmTuuti.class);
    }

    public IT_BAK_KouzaHrkmTuuti getBAKKouzaHrkmTuuti(String pSyono, Integer pKrkno, String pTrkssikibetukey) {
        IT_BAK_KouzaHrkmTuuti iT_BAK_KouzaHrkmTuuti =  new IT_BAK_KouzaHrkmTuuti( pSyono,  pKrkno,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_KouzaHrkmTuuti);
    }

}
