package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;

/**
 * 精算Ｄ反映通知テーブル(IT_SeisanDHaneiTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SeisanDHaneiTuutiDao extends AbstractDao<IT_SeisanDHaneiTuuti> {

    public IT_SeisanDHaneiTuutiDao() {
        super(IT_SeisanDHaneiTuuti.class);
    }

    public IT_SeisanDHaneiTuuti getSeisanDHaneiTuuti(String pSyono, BizDateY pHaitounendo) {
        IT_SeisanDHaneiTuuti iT_SeisanDHaneiTuuti =  new IT_SeisanDHaneiTuuti( pSyono,  pHaitounendo);
        return this.selectOne(iT_SeisanDHaneiTuuti);
    }
}
