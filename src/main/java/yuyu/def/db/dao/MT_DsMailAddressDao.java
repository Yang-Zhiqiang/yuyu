package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsMailAddress;
import java.util.List;

/**
 * ＤＳメールアドレステーブル(MT_DsMailAddressDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsMailAddressDao extends AbstractDao<MT_DsMailAddress> {

    public MT_DsMailAddressDao() {
        super(MT_DsMailAddress.class);
    }

    @Deprecated
    public MT_DsMailAddress getDsMailAddress(String pDskokno, Integer pDsmailaddressrenban) {
        MT_DsMailAddress mT_DsMailAddress =  new MT_DsMailAddress();
        mT_DsMailAddress.setDskokno(pDskokno);
        mT_DsMailAddress.setDsmailaddressrenban(pDsmailaddressrenban);
        return this.selectOne(mT_DsMailAddress);
    }

    @Override
    @Deprecated
    public List<MT_DsMailAddress> selectAll() {
        return super.selectAll();
    }
}
