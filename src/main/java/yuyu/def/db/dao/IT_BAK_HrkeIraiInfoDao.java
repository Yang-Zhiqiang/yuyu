package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_HrkeIraiInfo;

/**
 * 振替依頼情報バックアップテーブル(IT_BAK_HrkeIraiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HrkeIraiInfoDao extends AbstractDao<IT_BAK_HrkeIraiInfo> {

    public IT_BAK_HrkeIraiInfoDao() {
        super(IT_BAK_HrkeIraiInfo.class);
    }

    public IT_BAK_HrkeIraiInfo getBAKHrkeIraiInfo(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey) {
        IT_BAK_HrkeIraiInfo iT_BAK_HrkeIraiInfo =  new IT_BAK_HrkeIraiInfo( pSyono,  pTrkssikibetukey,  pHenkousikibetukey);
        return this.selectOne(iT_BAK_HrkeIraiInfo);
    }

}
