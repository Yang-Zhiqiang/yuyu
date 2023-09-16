package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_YykIdouUktk;

/**
 * 予約異動受付バックアップテーブル(IT_BAK_YykIdouUktkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_YykIdouUktkDao extends AbstractDao<IT_BAK_YykIdouUktk> {

    public IT_BAK_YykIdouUktkDao() {
        super(IT_BAK_YykIdouUktk.class);
    }

    @Deprecated
    public IT_BAK_YykIdouUktk getBAKYykIdouUktk(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey,
         String pKinouId){
        IT_BAK_YykIdouUktk iT_BAK_YykIdouUktk =  new IT_BAK_YykIdouUktk();
        iT_BAK_YykIdouUktk.setSyono(pSyono);
        iT_BAK_YykIdouUktk.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_YykIdouUktk.setHenkousikibetukey(pHenkousikibetukey);
        iT_BAK_YykIdouUktk.setKinouId(pKinouId);
        return this.selectOne(iT_BAK_YykIdouUktk);
    }

    @Override
    @Deprecated
    public List<IT_BAK_YykIdouUktk> selectAll() {
        return super.selectAll();
    }
}
