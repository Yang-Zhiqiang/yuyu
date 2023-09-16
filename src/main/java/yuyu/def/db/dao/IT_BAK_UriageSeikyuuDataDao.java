package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_UriageSeikyuuData;

/**
 * 売上請求データバックアップテーブル(IT_BAK_UriageSeikyuuDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_UriageSeikyuuDataDao extends AbstractDao<IT_BAK_UriageSeikyuuData> {

    public IT_BAK_UriageSeikyuuDataDao() {
        super(IT_BAK_UriageSeikyuuData.class);
    }

    public IT_BAK_UriageSeikyuuData getBAKUriageSeikyuuData(String pSyono, String pTrkssikibetukey, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        IT_BAK_UriageSeikyuuData iT_BAK_UriageSeikyuuData =  new IT_BAK_UriageSeikyuuData( pSyono,  pTrkssikibetukey,  pCreditkessaiyouno,  pUriagenengappi,  pRenno3keta);
        return this.selectOne(iT_BAK_UriageSeikyuuData);
    }
}
