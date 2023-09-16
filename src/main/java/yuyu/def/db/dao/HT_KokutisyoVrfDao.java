package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_KokutisyoVrf;

/**
 * 告知書ベリファイテーブル(HT_KokutisyoVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KokutisyoVrfDao extends AbstractDao<HT_KokutisyoVrf> {

    public HT_KokutisyoVrfDao() {
        super(HT_KokutisyoVrf.class);
    }

    @Deprecated
    public HT_KokutisyoVrf getKokutisyoVrf(String pMosno){
        HT_KokutisyoVrf hT_KokutisyoVrf =  new HT_KokutisyoVrf();
        hT_KokutisyoVrf.setMosno(pMosno);
        return this.selectOne(hT_KokutisyoVrf);
    }

    @Override
    @Deprecated
    public List<HT_KokutisyoVrf> selectAll() {
        return super.selectAll();
    }
}
