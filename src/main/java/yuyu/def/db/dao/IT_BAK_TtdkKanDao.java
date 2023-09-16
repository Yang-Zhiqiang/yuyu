package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_TtdkKan;

/**
 * 手続完了バックアップテーブル(IT_BAK_TtdkKanDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TtdkKanDao extends AbstractDao<IT_BAK_TtdkKan> {

    public IT_BAK_TtdkKanDao() {
        super(IT_BAK_TtdkKan.class);
    }

    @Deprecated
    public IT_BAK_TtdkKan getBAKTtdkKan(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey){
        IT_BAK_TtdkKan iT_BAK_TtdkKan =  new IT_BAK_TtdkKan();
        iT_BAK_TtdkKan.setSyono(pSyono);
        iT_BAK_TtdkKan.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_TtdkKan.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_TtdkKan);
    }

    @Override
    @Deprecated
    public List<IT_BAK_TtdkKan> selectAll() {
        return super.selectAll();
    }
}
