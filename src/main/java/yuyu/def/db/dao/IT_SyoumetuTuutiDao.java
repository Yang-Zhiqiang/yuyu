package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_SyoumetuTuuti;

/**
 * 消滅通知テーブル(IT_SyoumetuTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SyoumetuTuutiDao extends AbstractDao<IT_SyoumetuTuuti> {

    public IT_SyoumetuTuutiDao() {
        super(IT_SyoumetuTuuti.class);
    }

    public IT_SyoumetuTuuti getSyoumetuTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_SyoumetuTuuti iT_SyoumetuTuuti =  new IT_SyoumetuTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_SyoumetuTuuti);
    }
}
