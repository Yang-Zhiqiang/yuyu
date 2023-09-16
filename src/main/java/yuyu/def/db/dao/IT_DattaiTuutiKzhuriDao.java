package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;

/**
 * 脱退通知（口座振替）テーブル(IT_DattaiTuutiKzhuriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DattaiTuutiKzhuriDao extends AbstractDao<IT_DattaiTuutiKzhuri> {

    public IT_DattaiTuutiKzhuriDao() {
        super(IT_DattaiTuutiKzhuri.class);
    }

    public IT_DattaiTuutiKzhuri getDattaiTuutiKzhuri(String pSyono, BizDate pTyouhyouymd) {
        IT_DattaiTuutiKzhuri iT_DattaiTuutiKzhuri =  new IT_DattaiTuutiKzhuri( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_DattaiTuutiKzhuri);
    }

}
