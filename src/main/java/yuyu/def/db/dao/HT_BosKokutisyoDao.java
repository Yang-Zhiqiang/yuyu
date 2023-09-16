package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BosKokutisyo;
import java.util.List;

/**
 * 募集告知書テーブル(HT_BosKokutisyoDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosKokutisyoDao extends AbstractDao<HT_BosKokutisyo> {

    public HT_BosKokutisyoDao() {
        super(HT_BosKokutisyo.class);
    }

    @Deprecated
    public HT_BosKokutisyo getBosKokutisyo(String pMosno) {
        HT_BosKokutisyo hT_BosKokutisyo =  new HT_BosKokutisyo();
        hT_BosKokutisyo.setMosno(pMosno);
        return this.selectOne(hT_BosKokutisyo);
    }

    @Override
    @Deprecated
    public List<HT_BosKokutisyo> selectAll() {
        return super.selectAll();
    }
}
