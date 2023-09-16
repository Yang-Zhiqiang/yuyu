package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_KouzaJyouhouVrf;

/**
 * 口座情報ベリファイテーブル(HT_KouzaJyouhouVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KouzaJyouhouVrfDao extends AbstractDao<HT_KouzaJyouhouVrf> {

    public HT_KouzaJyouhouVrfDao() {
        super(HT_KouzaJyouhouVrf.class);
    }

    @Deprecated
    public HT_KouzaJyouhouVrf getKouzaJyouhouVrf(String pMosno){
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf =  new HT_KouzaJyouhouVrf();
        hT_KouzaJyouhouVrf.setMosno(pMosno);
        return this.selectOne(hT_KouzaJyouhouVrf);
    }

    @Override
    @Deprecated
    public List<HT_KouzaJyouhouVrf> selectAll() {
        return super.selectAll();
    }
}
