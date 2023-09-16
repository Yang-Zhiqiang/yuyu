package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;

/**
 * 有効性確認ＮＧ通知テーブル(IT_YuukouseiNgTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YuukouseiNgTuutiDao extends AbstractDao<IT_YuukouseiNgTuuti> {

    public IT_YuukouseiNgTuutiDao() {
        super(IT_YuukouseiNgTuuti.class);
    }

    public IT_YuukouseiNgTuuti getYuukouseiNgTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_YuukouseiNgTuuti iT_YuukouseiNgTuuti =  new IT_YuukouseiNgTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_YuukouseiNgTuuti);
    }
}
