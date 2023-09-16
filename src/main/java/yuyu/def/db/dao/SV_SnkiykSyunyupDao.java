package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_SnkiykSyunyup;

/**
 * 新契約収入Ｐ統計情報ビュー(SV_SnkiykSyunyupDao) アクセス用の DAO クラスです。<br />
 */
public class SV_SnkiykSyunyupDao extends AbstractDao<SV_SnkiykSyunyup> {

    public SV_SnkiykSyunyupDao() {
        super(SV_SnkiykSyunyup.class);
    }

    public SV_SnkiykSyunyup getSnkiykSyunyup(String pMosno) {
        SV_SnkiykSyunyup sV_SnkiykSyunyup =  new SV_SnkiykSyunyup();
        sV_SnkiykSyunyup.setMosno(pMosno);
        return this.selectOne(sV_SnkiykSyunyup);
    }
}
