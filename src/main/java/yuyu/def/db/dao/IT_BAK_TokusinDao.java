package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_Tokusin;

/**
 * 特伸バックアップテーブル(IT_BAK_TokusinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TokusinDao extends AbstractDao<IT_BAK_Tokusin> {

    public IT_BAK_TokusinDao() {
        super(IT_BAK_Tokusin.class);
    }

    @Deprecated
    public IT_BAK_Tokusin getBAKTokusin(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_Tokusin iT_BAK_Tokusin =  new IT_BAK_Tokusin();
        iT_BAK_Tokusin.setSyono(pSyono);
        iT_BAK_Tokusin.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_Tokusin);
    }

    @Override
    @Deprecated
    public List<IT_BAK_Tokusin> selectAll() {
        return super.selectAll();
    }
}
