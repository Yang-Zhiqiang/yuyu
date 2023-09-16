package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_YykIdouUktk;

/**
 * 予約異動受付テーブル(IT_YykIdouUktkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YykIdouUktkDao extends AbstractDao<IT_YykIdouUktk> {

    public IT_YykIdouUktkDao() {
        super(IT_YykIdouUktk.class);
    }

    @Deprecated
    public IT_YykIdouUktk getYykIdouUktk(String pSyono,
         String pHenkousikibetukey,
         String pKinouId){
        IT_YykIdouUktk iT_YykIdouUktk =  new IT_YykIdouUktk();
        iT_YykIdouUktk.setSyono(pSyono);
        iT_YykIdouUktk.setHenkousikibetukey(pHenkousikibetukey);
        iT_YykIdouUktk.setKinouId(pKinouId);
        return this.selectOne(iT_YykIdouUktk);
    }

    @Override
    @Deprecated
    public List<IT_YykIdouUktk> selectAll() {
        return super.selectAll();
    }
}
