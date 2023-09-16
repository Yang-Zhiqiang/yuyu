package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_MukouTuuti;

/**
 * 無効通知テーブル(IT_MukouTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_MukouTuutiDao extends AbstractDao<IT_MukouTuuti> {

    public IT_MukouTuutiDao() {
        super(IT_MukouTuuti.class);
    }

    public IT_MukouTuuti getMukouTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_MukouTuuti iT_MukouTuuti =  new IT_MukouTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_MukouTuuti);
    }
}
