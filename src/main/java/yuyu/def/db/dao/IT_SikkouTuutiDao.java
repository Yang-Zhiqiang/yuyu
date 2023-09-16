package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_SikkouTuuti;

/**
 * 失効通知テーブル(IT_SikkouTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SikkouTuutiDao extends AbstractDao<IT_SikkouTuuti> {

    public IT_SikkouTuutiDao() {
        super(IT_SikkouTuuti.class);
    }

    public IT_SikkouTuuti getSikkouTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_SikkouTuuti iT_SikkouTuuti =  new IT_SikkouTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_SikkouTuuti);
    }
}
