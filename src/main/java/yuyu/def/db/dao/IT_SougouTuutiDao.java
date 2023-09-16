package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_SougouTuuti;

/**
 * 総合通知テーブル(IT_SougouTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SougouTuutiDao extends AbstractDao<IT_SougouTuuti> {

    public IT_SougouTuutiDao() {
        super(IT_SougouTuuti.class);
    }

    public IT_SougouTuuti getSougouTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_SougouTuuti iT_SougouTuuti =  new IT_SougouTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_SougouTuuti);
    }
}
