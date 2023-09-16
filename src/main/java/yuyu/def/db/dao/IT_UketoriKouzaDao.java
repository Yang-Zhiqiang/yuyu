package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_UketoriKouza;

/**
 * 受取口座テーブル(IT_UketoriKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_UketoriKouzaDao extends AbstractDao<IT_UketoriKouza> {

    public IT_UketoriKouzaDao() {
        super(IT_UketoriKouza.class);
    }

    public IT_UketoriKouza getUketoriKouza(String pSyono, C_UktsyuKbn pUktsyukbn, Integer pUktsyurenno) {
        IT_UketoriKouza iT_UketoriKouza =  new IT_UketoriKouza( pSyono,  pUktsyukbn,  pUktsyurenno);
        return this.selectOne(iT_UketoriKouza);
    }
}
