package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_Tuusan;

/**
 * 通算テーブル(HT_TuusanDao) アクセス用の DAO クラスです。<br />
 */
public class HT_TuusanDao extends AbstractDao<HT_Tuusan> {

    public HT_TuusanDao() {
        super(HT_Tuusan.class);
    }

    @Deprecated
    public HT_Tuusan getTuusan(String pMosno){
        HT_Tuusan hT_Tuusan =  new HT_Tuusan();
        hT_Tuusan.setMosno(pMosno);
        return this.selectOne(hT_Tuusan);
    }

    @Override
    @Deprecated
    public List<HT_Tuusan> selectAll() {
        return super.selectAll();
    }
}
