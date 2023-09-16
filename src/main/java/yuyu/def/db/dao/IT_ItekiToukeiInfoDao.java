package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;

/**
 * 医的統計用情報テーブル(IT_ItekiToukeiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ItekiToukeiInfoDao extends AbstractDao<IT_ItekiToukeiInfo> {

    public IT_ItekiToukeiInfoDao() {
        super(IT_ItekiToukeiInfo.class);
    }

    public IT_ItekiToukeiInfo getItekiToukeiInfo(String pSyono) {
        IT_ItekiToukeiInfo iT_ItekiToukeiInfo =  new IT_ItekiToukeiInfo();
        iT_ItekiToukeiInfo.setSyono(pSyono);
        return this.selectOne(iT_ItekiToukeiInfo);
    }
}
