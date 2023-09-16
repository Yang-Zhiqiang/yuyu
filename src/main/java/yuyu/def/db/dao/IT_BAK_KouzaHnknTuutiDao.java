package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KouzaHnknTuuti;

/**
 * 口座返金通知バックアップテーブル(IT_BAK_KouzaHnknTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KouzaHnknTuutiDao extends AbstractDao<IT_BAK_KouzaHnknTuuti> {

    public IT_BAK_KouzaHnknTuutiDao() {
        super(IT_BAK_KouzaHnknTuuti.class);
    }

    public IT_BAK_KouzaHnknTuuti getBAKKouzaHnknTuuti(String pSyono, String pDenrenno, Integer pEdano, String pTrkssikibetukey) {
        IT_BAK_KouzaHnknTuuti iT_BAK_KouzaHnknTuuti =  new IT_BAK_KouzaHnknTuuti( pSyono,  pDenrenno,  pEdano,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_KouzaHnknTuuti);
    }

}
