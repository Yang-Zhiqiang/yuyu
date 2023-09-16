package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;

/**
 * 募集口座情報テーブル(HT_BosKouzaJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosKouzaJyouhouDao extends AbstractDao<HT_BosKouzaJyouhou> {

    public HT_BosKouzaJyouhouDao() {
        super(HT_BosKouzaJyouhou.class);
    }

    public HT_BosKouzaJyouhou getBosKouzaJyouhou(String pMosno) {
        HT_BosKouzaJyouhou hT_BosKouzaJyouhou =  new HT_BosKouzaJyouhou();
        hT_BosKouzaJyouhou.setMosno(pMosno);
        return this.selectOne(hT_BosKouzaJyouhou);
    }

}
