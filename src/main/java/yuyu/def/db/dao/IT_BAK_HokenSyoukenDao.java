package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_HokenSyouken;
/**
 * 保険証券バックアップテーブル(IT_BAK_HokenSyoukenDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HokenSyoukenDao extends AbstractDao<IT_BAK_HokenSyouken> {

    public IT_BAK_HokenSyoukenDao() {
        super(IT_BAK_HokenSyouken.class);
    }

    @Deprecated
    public IT_BAK_HokenSyouken getBAKHokenSyouken(String pSyono,
         String pTrkssikibetukey,
         BizDate pTyouhyouymd){
        IT_BAK_HokenSyouken iT_BAK_HokenSyouken =  new IT_BAK_HokenSyouken();
        iT_BAK_HokenSyouken.setSyono(pSyono);
        iT_BAK_HokenSyouken.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_HokenSyouken.setTyouhyouymd(pTyouhyouymd);
        return this.selectOne(iT_BAK_HokenSyouken);
    }

    @Override
    @Deprecated
    public List<IT_BAK_HokenSyouken> selectAll() {
        return super.selectAll();
    }
}
