package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_ZennouTtdkKanryouTuuti;

/**
 * 前納手続完了通知書テーブル(IT_ZennouTtdkKanryouTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ZennouTtdkKanryouTuutiDao extends AbstractDao<IT_ZennouTtdkKanryouTuuti> {

    public IT_ZennouTtdkKanryouTuutiDao() {
        super(IT_ZennouTtdkKanryouTuuti.class);
    }

    public IT_ZennouTtdkKanryouTuuti getZennouTtdkKanryouTuuti(String pSyono, BizDate pTyouhyouymd) {
        IT_ZennouTtdkKanryouTuuti iT_ZennouTtdkKanryouTuuti =  new IT_ZennouTtdkKanryouTuuti( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_ZennouTtdkKanryouTuuti);
    }

}
