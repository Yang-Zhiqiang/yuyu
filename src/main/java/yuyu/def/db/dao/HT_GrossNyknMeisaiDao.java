package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_GrossNyknMeisai;

/**
 * グロス入金明細テーブル(HT_GrossNyknMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_GrossNyknMeisaiDao extends AbstractDao<HT_GrossNyknMeisai> {

    public HT_GrossNyknMeisaiDao() {
        super(HT_GrossNyknMeisai.class);
    }

    public HT_GrossNyknMeisai getGrossNyknMeisai(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno,
        Integer pMeisairenno) {
        HT_GrossNyknMeisai hT_GrossNyknMeisai = new HT_GrossNyknMeisai();
        hT_GrossNyknMeisai.setRyosyuymd(pRyosyuymd);
        hT_GrossNyknMeisai.setOyadrtencd(pOyadrtencd);
        hT_GrossNyknMeisai.setRenno(pRenno);
        hT_GrossNyknMeisai.setMeisairenno(pMeisairenno);
        return this.selectOne(hT_GrossNyknMeisai);
    }
}
