package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;

/**
 * 募集受取口座情報テーブル(HT_BosUketoriKouzaJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosUketoriKouzaJyouhouDao extends AbstractDao<HT_BosUketoriKouzaJyouhou> {

    public HT_BosUketoriKouzaJyouhouDao() {
        super(HT_BosUketoriKouzaJyouhou.class);
    }

    @Deprecated
    public HT_BosUketoriKouzaJyouhou getBosUketoriKouzaJyouhou(String pMosno,
         C_UketorikouzasyubetuKbn pUktkzsyubetukbn){
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou =  new HT_BosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou.setMosno(pMosno);
        hT_BosUketoriKouzaJyouhou.setUktkzsyubetukbn(pUktkzsyubetukbn);
        return this.selectOne(hT_BosUketoriKouzaJyouhou);
    }

    @Override
    @Deprecated
    public List<HT_BosUketoriKouzaJyouhou> selectAll() {
        return super.selectAll();
    }
}
