package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_HurikaeYousi;

/**
 * 振替用紙バックアップテーブル(IT_BAK_HurikaeYousiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HurikaeYousiDao extends AbstractDao<IT_BAK_HurikaeYousi> {

    public IT_BAK_HurikaeYousiDao() {
        super(IT_BAK_HurikaeYousi.class);
    }

    public IT_BAK_HurikaeYousi getBAKHurikaeYousi(String pSyono, String pHenkousikibetukey, String pTrkssikibetukey) {
        IT_BAK_HurikaeYousi iT_BAK_HurikaeYousi =  new IT_BAK_HurikaeYousi( pSyono,  pHenkousikibetukey,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_HurikaeYousi);
    }

}
