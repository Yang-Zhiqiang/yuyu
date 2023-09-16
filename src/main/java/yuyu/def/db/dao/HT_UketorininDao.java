package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * 受取人テーブル(HT_UketorininDao) アクセス用の DAO クラスです。<br />
 */
public class HT_UketorininDao extends AbstractDao<HT_Uketorinin> {

    public HT_UketorininDao() {
        super(HT_Uketorinin.class);
    }

    @Deprecated
    public HT_Uketorinin getUketorinin(String pMosno,
         C_UktsyuKbn pUktsyukbn,
         Integer pUktsyurenno){
        HT_Uketorinin hT_Uketorinin =  new HT_Uketorinin();
        hT_Uketorinin.setMosno(pMosno);
        hT_Uketorinin.setUktsyukbn(pUktsyukbn);
        hT_Uketorinin.setUktsyurenno(pUktsyurenno);
        return this.selectOne(hT_Uketorinin);
    }

    @Override
    @Deprecated
    public List<HT_Uketorinin> selectAll() {
        return super.selectAll();
    }
}
