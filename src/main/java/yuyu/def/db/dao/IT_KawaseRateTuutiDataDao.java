package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KawaseRateTuutiData;

/**
 * 為替レート通知データテーブル(IT_KawaseRateTuutiDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KawaseRateTuutiDataDao extends AbstractDao<IT_KawaseRateTuutiData> {

    public IT_KawaseRateTuutiDataDao() {
        super(IT_KawaseRateTuutiData.class);
    }

    public IT_KawaseRateTuutiData getKawaseRateTuutiData(String pSyono, BizDate pTyouhyouymd, Integer pRenno) {
        IT_KawaseRateTuutiData iT_KawaseRateTuutiData =  new IT_KawaseRateTuutiData( pSyono,  pTyouhyouymd,  pRenno);
        return this.selectOne(iT_KawaseRateTuutiData);
    }
}
