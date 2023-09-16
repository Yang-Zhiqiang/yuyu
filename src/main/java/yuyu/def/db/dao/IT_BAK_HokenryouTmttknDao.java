package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_BAK_HokenryouTmttkn;

/**
 * 保険料積立金バックアップテーブル(IT_BAK_HokenryouTmttknDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HokenryouTmttknDao extends AbstractDao<IT_BAK_HokenryouTmttkn> {

    public IT_BAK_HokenryouTmttknDao() {
        super(IT_BAK_HokenryouTmttkn.class);
    }

    public IT_BAK_HokenryouTmttkn getBAKHokenryouTmttkn(String pSyono, String pTrkssikibetukey, BizDateYM pTmttkntaisyouym, Integer pRenno) {
        IT_BAK_HokenryouTmttkn iT_BAK_HokenryouTmttkn =  new IT_BAK_HokenryouTmttkn( pSyono,  pTrkssikibetukey,  pTmttkntaisyouym,  pRenno);
        return this.selectOne(iT_BAK_HokenryouTmttkn);
    }

}
