package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_AnsyuKihon;

/**
 * 案内収納基本テーブル(IT_AnsyuKihonDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AnsyuKihonDao extends AbstractDao<IT_AnsyuKihon> {

    public IT_AnsyuKihonDao() {
        super(IT_AnsyuKihon.class);
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {
        IT_AnsyuKihon iT_AnsyuKihon =  new IT_AnsyuKihon( pSyono);
        return this.selectOne(iT_AnsyuKihon);
    }
}
