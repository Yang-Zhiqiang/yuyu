package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_KouzaJyouhou;

/**
 * 口座情報テーブル(HT_KouzaJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KouzaJyouhouDao extends AbstractDao<HT_KouzaJyouhou> {

    public HT_KouzaJyouhouDao() {
        super(HT_KouzaJyouhou.class);
    }

    @Deprecated
    public HT_KouzaJyouhou getKouzaJyouhou(String pMosno){
        HT_KouzaJyouhou hT_KouzaJyouhou =  new HT_KouzaJyouhou();
        hT_KouzaJyouhou.setMosno(pMosno);
        return this.selectOne(hT_KouzaJyouhou);
    }

    @Override
    @Deprecated
    public List<HT_KouzaJyouhou> selectAll() {
        return super.selectAll();
    }
}
