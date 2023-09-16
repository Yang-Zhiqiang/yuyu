package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;

/**
 * 収納返金履歴テーブル(IT_SyuunouHenknRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SyuunouHenknRirekiDao extends AbstractDao<IT_SyuunouHenknRireki> {

    public IT_SyuunouHenknRirekiDao() {
        super(IT_SyuunouHenknRireki.class);
    }

    @Deprecated
    public IT_SyuunouHenknRireki getSyuunouHenknRireki(String pSyono,
         String pDenrenno,
         Integer pEdano){
        IT_SyuunouHenknRireki iT_SyuunouHenknRireki =  new IT_SyuunouHenknRireki();
        iT_SyuunouHenknRireki.setSyono(pSyono);
        iT_SyuunouHenknRireki.setDenrenno(pDenrenno);
        iT_SyuunouHenknRireki.setEdano(pEdano);
        return this.selectOne(iT_SyuunouHenknRireki);
    }

    @Override
    @Deprecated
    public List<IT_SyuunouHenknRireki> selectAll() {
        return super.selectAll();
    }
}
