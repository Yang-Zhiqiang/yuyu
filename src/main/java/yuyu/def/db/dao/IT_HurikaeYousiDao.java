package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_HurikaeYousi;

/**
 * 振替用紙テーブル(IT_HurikaeYousiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HurikaeYousiDao extends AbstractDao<IT_HurikaeYousi> {

    public IT_HurikaeYousiDao() {
        super(IT_HurikaeYousi.class);
    }

    public IT_HurikaeYousi getHurikaeYousi(String pSyono, String pHenkousikibetukey) {
        IT_HurikaeYousi iT_HurikaeYousi =  new IT_HurikaeYousi( pSyono,  pHenkousikibetukey);
        return this.selectOne(iT_HurikaeYousi);
    }

}
