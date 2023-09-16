package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;

/**
 * 申込未確定情報管理テーブル(HT_MosMikakuteiJyouhouKanriDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosMikakuteiJyouhouKanriDao extends AbstractDao<HT_MosMikakuteiJyouhouKanri> {

    public HT_MosMikakuteiJyouhouKanriDao() {
        super(HT_MosMikakuteiJyouhouKanri.class);
    }

    public HT_MosMikakuteiJyouhouKanri getMosMikakuteiJyouhouKanri(String pMosno){
        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri =  new HT_MosMikakuteiJyouhouKanri();
        hT_MosMikakuteiJyouhouKanri.setMosno(pMosno);
        return this.selectOne(hT_MosMikakuteiJyouhouKanri);
    }
}
