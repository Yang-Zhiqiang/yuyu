package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_GrossNykn;

/**
 * グロス入金テーブル(HT_GrossNyknDao) アクセス用の DAO クラスです。<br />
 */
public class HT_GrossNyknDao extends AbstractDao<HT_GrossNykn> {

    public HT_GrossNyknDao() {
        super(HT_GrossNykn.class);
    }

    public HT_GrossNykn getGrossNykn(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno) {
        HT_GrossNykn hT_GrossNykn = new HT_GrossNykn();
        hT_GrossNykn.setRyosyuymd(pRyosyuymd);
        hT_GrossNykn.setOyadrtencd(pOyadrtencd);
        hT_GrossNykn.setRenno(pRenno);
        return this.selectOne(hT_GrossNykn);
    }
}
