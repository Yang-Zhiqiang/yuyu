package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_KessanYokukiP;

/**
 * 決算用翌期Ｐテーブル(IT_KessanYokukiPDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KessanYokukiPDao extends AbstractDao<IT_KessanYokukiP> {

    public IT_KessanYokukiPDao() {
        super(IT_KessanYokukiP.class);
    }

    public IT_KessanYokukiP getKessanYokukiP(BizDateYM pKeijyouym, String pSyono) {
        IT_KessanYokukiP iT_KessanYokukiP =  new IT_KessanYokukiP( pKeijyouym,  pSyono);
        return this.selectOne(iT_KessanYokukiP);
    }

}
