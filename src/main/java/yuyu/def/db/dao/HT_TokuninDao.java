package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 特認テーブル(HT_TokuninDao) アクセス用の DAO クラスです。<br />
 */
public class HT_TokuninDao extends AbstractDao<HT_Tokunin> {

    public HT_TokuninDao() {
        super(HT_Tokunin.class);
    }

    @Deprecated
    public HT_Tokunin getTokunin(String pMosno){
        HT_Tokunin hT_Tokunin =  new HT_Tokunin();
        hT_Tokunin.setMosno(pMosno);
        return this.selectOne(hT_Tokunin);
    }

    @Override
    @Deprecated
    public List<HT_Tokunin> selectAll() {
        return super.selectAll();
    }

    public List<HT_Tokunin> getTokuninsByKetsyacd(String pKetsyacd) {

        HT_Tokunin hT_Tokunin = new HT_Tokunin();
        hT_Tokunin.setKetsyacd(pKetsyacd);
        return this.select(hT_Tokunin);
    }
}
