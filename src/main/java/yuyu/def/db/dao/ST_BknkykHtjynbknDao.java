package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;

/**
 * 備金契約配当準備金テーブル(ST_BknkykHtjynbknDao) アクセス用の DAO クラスです。<br />
 */
public class ST_BknkykHtjynbknDao extends AbstractDao<ST_BknkykHtjynbkn> {

    public ST_BknkykHtjynbknDao() {
        super(ST_BknkykHtjynbkn.class);
    }

    public ST_BknkykHtjynbkn getBknkykHtjynbkn(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {
        ST_BknkykHtjynbkn sT_BknkykHtjynbkn =  new ST_BknkykHtjynbkn();
        sT_BknkykHtjynbkn.setSyoriYmd(pSyoriYmd);
        sT_BknkykHtjynbkn.setKakutyoujobcd(pKakutyoujobcd);
        sT_BknkykHtjynbkn.setSyono(pSyono);
        sT_BknkykHtjynbkn.setSrkijyunym(pSrkijyunym);
        return this.selectOne(sT_BknkykHtjynbkn);
    }
}
