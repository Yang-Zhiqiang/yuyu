package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;

/**
 * 代理店未入契約明細内容テーブル(IT_DrtenMinyuKykNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DrtenMinyuKykNaiyouDao extends AbstractDao<IT_DrtenMinyuKykNaiyou> {

    public IT_DrtenMinyuKykNaiyouDao() {
        super(IT_DrtenMinyuKykNaiyou.class);
    }

    public IT_DrtenMinyuKykNaiyou getDrtenMinyuKykNaiyou(String pSyono, BizDateYM pSyoriym) {
        IT_DrtenMinyuKykNaiyou iT_DrtenMinyuKykNaiyou =  new IT_DrtenMinyuKykNaiyou( pSyono,  pSyoriym);
        return this.selectOne(iT_DrtenMinyuKykNaiyou);
    }
}
