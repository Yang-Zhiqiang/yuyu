package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_Kokutisyo;

/**
 * 告知書テーブル(HT_KokutisyoDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KokutisyoDao extends AbstractDao<HT_Kokutisyo> {

    public HT_KokutisyoDao() {
        super(HT_Kokutisyo.class);
    }

    @Deprecated
    public HT_Kokutisyo getKokutisyo(String pMosno){
        HT_Kokutisyo hT_Kokutisyo =  new HT_Kokutisyo();
        hT_Kokutisyo.setMosno(pMosno);
        return this.selectOne(hT_Kokutisyo);
    }

    @Override
    @Deprecated
    public List<HT_Kokutisyo> selectAll() {
        return super.selectAll();
    }
}
