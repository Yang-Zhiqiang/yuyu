package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosKihonVrf;

/**
 * 申込基本ベリファイテーブル(HT_MosKihonVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosKihonVrfDao extends AbstractDao<HT_MosKihonVrf> {

    public HT_MosKihonVrfDao() {
        super(HT_MosKihonVrf.class);
    }

    @Deprecated
    public HT_MosKihonVrf getMosKihonVrf(String pMosno){
        HT_MosKihonVrf hT_MosKihonVrf =  new HT_MosKihonVrf();
        hT_MosKihonVrf.setMosno(pMosno);
        return this.selectOne(hT_MosKihonVrf);
    }

    @Override
    @Deprecated
    public List<HT_MosKihonVrf> selectAll() {
        return super.selectAll();
    }
}
