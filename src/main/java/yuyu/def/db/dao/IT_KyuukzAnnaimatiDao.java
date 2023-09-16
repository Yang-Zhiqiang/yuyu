package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;

/**
 * 旧口座案内待ちテーブル(IT_KyuukzAnnaimatiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KyuukzAnnaimatiDao extends AbstractDao<IT_KyuukzAnnaimati> {

    public IT_KyuukzAnnaimatiDao() {
        super(IT_KyuukzAnnaimati.class);
    }

    public IT_KyuukzAnnaimati getKyuukzAnnaimati(String pKouteikanriid) {
        IT_KyuukzAnnaimati iT_KyuukzAnnaimati =  new IT_KyuukzAnnaimati();
        iT_KyuukzAnnaimati.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iT_KyuukzAnnaimati);
    }

}
