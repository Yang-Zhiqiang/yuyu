package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;

/**
 * 案内収納基本バックアップテーブル(IT_BAK_AnsyuKihonDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_AnsyuKihonDao extends AbstractDao<IT_BAK_AnsyuKihon> {

    public IT_BAK_AnsyuKihonDao() {
        super(IT_BAK_AnsyuKihon.class);
    }

    public IT_BAK_AnsyuKihon getBAKAnsyuKihon(String pSyono, String pTrkssikibetukey) {
        IT_BAK_AnsyuKihon iT_BAK_AnsyuKihon =  new IT_BAK_AnsyuKihon( pSyono,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_AnsyuKihon);
    }
}
