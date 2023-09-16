package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KykDairiten;

/**
 * 契約代理店バックアップテーブル(IT_BAK_KykDairitenDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykDairitenDao extends AbstractDao<IT_BAK_KykDairiten> {

    public IT_BAK_KykDairitenDao() {
        super(IT_BAK_KykDairiten.class);
    }

    @Deprecated
    public IT_BAK_KykDairiten getBAKKykDairiten(String pSyono,
         String pTrkssikibetukey,
         Integer pDrtenrenno){
        IT_BAK_KykDairiten iT_BAK_KykDairiten =  new IT_BAK_KykDairiten();
        iT_BAK_KykDairiten.setSyono(pSyono);
        iT_BAK_KykDairiten.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KykDairiten.setDrtenrenno(pDrtenrenno);
        return this.selectOne(iT_BAK_KykDairiten);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykDairiten> selectAll() {
        return super.selectAll();
    }
}
