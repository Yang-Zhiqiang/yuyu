package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;

/**
 * 受取口座情報テーブル(HT_UketoriKouzaJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_UketoriKouzaJyouhouDao extends AbstractDao<HT_UketoriKouzaJyouhou> {

    public HT_UketoriKouzaJyouhouDao() {
        super(HT_UketoriKouzaJyouhou.class);
    }

    @Deprecated
    public HT_UketoriKouzaJyouhou getUketoriKouzaJyouhou(String pMosno,
         C_UketorikouzasyubetuKbn pUktkzsyubetukbn){
        HT_UketoriKouzaJyouhou hT_UketoriKouzaJyouhou =  new HT_UketoriKouzaJyouhou();
        hT_UketoriKouzaJyouhou.setMosno(pMosno);
        hT_UketoriKouzaJyouhou.setUktkzsyubetukbn(pUktkzsyubetukbn);
        return this.selectOne(hT_UketoriKouzaJyouhou);
    }

    @Override
    @Deprecated
    public List<HT_UketoriKouzaJyouhou> selectAll() {
        return super.selectAll();
    }
}
