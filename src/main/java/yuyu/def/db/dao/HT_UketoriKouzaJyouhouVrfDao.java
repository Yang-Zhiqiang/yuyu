package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;

/**
 * 受取口座情報ベリファイテーブル(HT_UketoriKouzaJyouhouVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_UketoriKouzaJyouhouVrfDao extends AbstractDao<HT_UketoriKouzaJyouhouVrf> {

    public HT_UketoriKouzaJyouhouVrfDao() {
        super(HT_UketoriKouzaJyouhouVrf.class);
    }

    @Deprecated
    public HT_UketoriKouzaJyouhouVrf getUketoriKouzaJyouhouVrf(String pMosno,
         C_UketorikouzasyubetuKbn pUktkzsyubetukbn){
        HT_UketoriKouzaJyouhouVrf hT_UketoriKouzaJyouhouVrf =  new HT_UketoriKouzaJyouhouVrf();
        hT_UketoriKouzaJyouhouVrf.setMosno(pMosno);
        hT_UketoriKouzaJyouhouVrf.setUktkzsyubetukbn(pUktkzsyubetukbn);
        return this.selectOne(hT_UketoriKouzaJyouhouVrf);
    }

    @Override
    @Deprecated
    public List<HT_UketoriKouzaJyouhouVrf> selectAll() {
        return super.selectAll();
    }
}
