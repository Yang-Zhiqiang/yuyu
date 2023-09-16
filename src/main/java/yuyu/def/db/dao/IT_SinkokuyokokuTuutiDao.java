package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;

/**
 * 申告予告通知テーブル(IT_SinkokuyokokuTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SinkokuyokokuTuutiDao extends AbstractDao<IT_SinkokuyokokuTuuti> {

    public IT_SinkokuyokokuTuutiDao() {
        super(IT_SinkokuyokokuTuuti.class);
    }

    public IT_SinkokuyokokuTuuti getSinkokuyokokuTuuti(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno) {
        IT_SinkokuyokokuTuuti iT_SinkokuyokokuTuuti =  new IT_SinkokuyokokuTuuti( pSyono,  pNendo,  pTyouhyouymd,  pRenno);
        return this.selectOne(iT_SinkokuyokokuTuuti);
    }
}
