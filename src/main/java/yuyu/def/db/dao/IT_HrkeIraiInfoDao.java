package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_HrkeIraiInfo;

/**
 * 振替依頼情報テーブル(IT_HrkeIraiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HrkeIraiInfoDao extends AbstractDao<IT_HrkeIraiInfo> {

    public IT_HrkeIraiInfoDao() {
        super(IT_HrkeIraiInfo.class);
    }

    public IT_HrkeIraiInfo getHrkeIraiInfo(String pSyono, String pHenkousikibetukey) {
        IT_HrkeIraiInfo iT_HrkeIraiInfo =  new IT_HrkeIraiInfo( pSyono,  pHenkousikibetukey);
        return this.selectOne(iT_HrkeIraiInfo);
    }

}
