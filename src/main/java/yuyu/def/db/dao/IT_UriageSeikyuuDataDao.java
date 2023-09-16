package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_UriageSeikyuuData;

/**
 * 売上請求データテーブル(IT_UriageSeikyuuDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_UriageSeikyuuDataDao extends AbstractDao<IT_UriageSeikyuuData> {

    public IT_UriageSeikyuuDataDao() {
        super(IT_UriageSeikyuuData.class);
    }

    public IT_UriageSeikyuuData getUriageSeikyuuData(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        IT_UriageSeikyuuData iT_UriageSeikyuuData =  new IT_UriageSeikyuuData( pSyono,  pCreditkessaiyouno,  pUriagenengappi,  pRenno3keta);
        return this.selectOne(iT_UriageSeikyuuData);
    }
}
