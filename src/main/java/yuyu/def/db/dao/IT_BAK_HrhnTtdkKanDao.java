package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_HrhnTtdkKan;

/**
 * 手続完了（払方変更）バックアップテーブル(IT_BAK_HrhnTtdkKanDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HrhnTtdkKanDao extends AbstractDao<IT_BAK_HrhnTtdkKan> {

    public IT_BAK_HrhnTtdkKanDao() {
        super(IT_BAK_HrhnTtdkKan.class);
    }

    public IT_BAK_HrhnTtdkKan getBAKHrhnTtdkKan(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey) {
        IT_BAK_HrhnTtdkKan iT_BAK_HrhnTtdkKan =  new IT_BAK_HrhnTtdkKan( pSyono,  pTrkssikibetukey,  pHenkousikibetukey);
        return this.selectOne(iT_BAK_HrhnTtdkKan);
    }

}
