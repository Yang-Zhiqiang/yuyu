package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_Zennou;

/**
 * 前納バックアップテーブル(IT_BAK_ZennouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_ZennouDao extends AbstractDao<IT_BAK_Zennou> {

    public IT_BAK_ZennouDao() {
        super(IT_BAK_Zennou.class);
    }

    public IT_BAK_Zennou getBAKZennou(String pSyono, String pTrkssikibetukey, BizDate pZennoukaisiymd, Integer pRenno) {
        IT_BAK_Zennou iT_BAK_Zennou =  new IT_BAK_Zennou( pSyono,  pTrkssikibetukey,  pZennoukaisiymd,  pRenno);
        return this.selectOne(iT_BAK_Zennou);
    }

}
