package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_HrhnTtdkKan;

/**
 * 手続完了（払方変更）テーブル(IT_HrhnTtdkKanDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HrhnTtdkKanDao extends AbstractDao<IT_HrhnTtdkKan> {

    public IT_HrhnTtdkKanDao() {
        super(IT_HrhnTtdkKan.class);
    }

    public IT_HrhnTtdkKan getHrhnTtdkKan(String pSyono, String pHenkousikibetukey) {
        IT_HrhnTtdkKan iT_HrhnTtdkKan =  new IT_HrhnTtdkKan( pSyono,  pHenkousikibetukey);
        return this.selectOne(iT_HrhnTtdkKan);
    }

}
