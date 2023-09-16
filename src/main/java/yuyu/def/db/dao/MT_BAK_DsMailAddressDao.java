package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsMailAddress;
import java.util.List;

/**
 * ＤＳメールアドレスバックアップテーブル(MT_BAK_DsMailAddressDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsMailAddressDao extends AbstractDao<MT_BAK_DsMailAddress> {

    public MT_BAK_DsMailAddressDao() {
        super(MT_BAK_DsMailAddress.class);
    }

    @Deprecated
    public MT_BAK_DsMailAddress getBAKDsMailAddress(String pDskokno, Integer pDsmailaddressrenban) {
        MT_BAK_DsMailAddress mT_BAK_DsMailAddress =  new MT_BAK_DsMailAddress();
        mT_BAK_DsMailAddress.setDskokno(pDskokno);
        mT_BAK_DsMailAddress.setDsmailaddressrenban(pDsmailaddressrenban);
        return this.selectOne(mT_BAK_DsMailAddress);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsMailAddress> selectAll() {
        return super.selectAll();
    }
}
