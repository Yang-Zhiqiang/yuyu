package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_DattaiUktk;

/**
 * 脱退受付バックアップテーブル(IT_BAK_DattaiUktkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_DattaiUktkDao extends AbstractDao<IT_BAK_DattaiUktk> {

    public IT_BAK_DattaiUktkDao() {
        super(IT_BAK_DattaiUktk.class);
    }

    @Deprecated
    public IT_BAK_DattaiUktk getBAKDattaiUktk(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_DattaiUktk iT_BAK_DattaiUktk =  new IT_BAK_DattaiUktk();
        iT_BAK_DattaiUktk.setSyono(pSyono);
        iT_BAK_DattaiUktk.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_DattaiUktk);
    }

    @Override
    @Deprecated
    public List<IT_BAK_DattaiUktk> selectAll() {
        return super.selectAll();
    }
}
