package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_SyuunouHenknRireki;

/**
 * 収納返金履歴バックアップテーブル(IT_BAK_SyuunouHenknRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_SyuunouHenknRirekiDao extends AbstractDao<IT_BAK_SyuunouHenknRireki> {

    public IT_BAK_SyuunouHenknRirekiDao() {
        super(IT_BAK_SyuunouHenknRireki.class);
    }

    @Deprecated
    public IT_BAK_SyuunouHenknRireki getBAKSyuunouHenknRireki(String pSyono,
         String pTrkssikibetukey,
         String pDenrenno,
         Integer pEdano){
        IT_BAK_SyuunouHenknRireki iT_BAK_SyuunouHenknRireki =  new IT_BAK_SyuunouHenknRireki();
        iT_BAK_SyuunouHenknRireki.setSyono(pSyono);
        iT_BAK_SyuunouHenknRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_SyuunouHenknRireki.setDenrenno(pDenrenno);
        iT_BAK_SyuunouHenknRireki.setEdano(pEdano);
        return this.selectOne(iT_BAK_SyuunouHenknRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_SyuunouHenknRireki> selectAll() {
        return super.selectAll();
    }
}
