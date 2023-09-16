package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;

/**
 * 売上請求結果データテーブル(IT_KhUriageSeikyuuKekkaDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhUriageSeikyuuKekkaDataDao extends AbstractDao<IT_KhUriageSeikyuuKekkaData> {

    public IT_KhUriageSeikyuuKekkaDataDao() {
        super(IT_KhUriageSeikyuuKekkaData.class);
    }

    public IT_KhUriageSeikyuuKekkaData getKhUriageSeikyuuKekkaData(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        IT_KhUriageSeikyuuKekkaData iT_KhUriageSeikyuuKekkaData =  new IT_KhUriageSeikyuuKekkaData( pSyono,  pCreditkessaiyouno,  pUriagenengappi,  pRenno3keta);
        return this.selectOne(iT_KhUriageSeikyuuKekkaData);
    }
}
