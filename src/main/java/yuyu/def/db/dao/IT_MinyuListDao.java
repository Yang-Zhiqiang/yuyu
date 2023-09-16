package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_MinyuList;

/**
 * 未入一覧表テーブル(IT_MinyuListDao) アクセス用の DAO クラスです。<br />
 */
public class IT_MinyuListDao extends AbstractDao<IT_MinyuList> {

    public IT_MinyuListDao() {
        super(IT_MinyuList.class);
    }

    public IT_MinyuList getMinyuList(String pSyono, BizDate pTyouhyouymd) {
        IT_MinyuList iT_MinyuList =  new IT_MinyuList( pSyono,  pTyouhyouymd);
        return this.selectOne(iT_MinyuList);
    }
}
