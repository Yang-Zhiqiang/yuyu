package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_BAK_UketoriKouza;

/**
 * 受取口座バックアップテーブル(IT_BAK_UketoriKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_UketoriKouzaDao extends AbstractDao<IT_BAK_UketoriKouza> {

    public IT_BAK_UketoriKouzaDao() {
        super(IT_BAK_UketoriKouza.class);
    }

    public IT_BAK_UketoriKouza getBAKUketoriKouza(String pSyono, String pTrkssikibetukey, C_UktsyuKbn pUktsyukbn, Integer pUktsyurenno) {
        IT_BAK_UketoriKouza iT_BAK_UketoriKouza =  new IT_BAK_UketoriKouza( pSyono,  pTrkssikibetukey,  pUktsyukbn,  pUktsyurenno);
        return this.selectOne(iT_BAK_UketoriKouza);
    }
}
