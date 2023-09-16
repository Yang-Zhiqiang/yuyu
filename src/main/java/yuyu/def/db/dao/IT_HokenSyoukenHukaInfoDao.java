package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;

/**
 * 保険証券付加情報データテーブル(IT_HokenSyoukenHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HokenSyoukenHukaInfoDao extends AbstractDao<IT_HokenSyoukenHukaInfo> {

    public IT_HokenSyoukenHukaInfoDao() {
        super(IT_HokenSyoukenHukaInfo.class);
    }

    public IT_HokenSyoukenHukaInfo getHokenSyoukenHukaInfo(String pSyono, BizDate pTyouhyouymd) {
        IT_HokenSyoukenHukaInfo iT_HokenSyoukenHukaInfo =  new IT_HokenSyoukenHukaInfo( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_HokenSyoukenHukaInfo);
    }
}
