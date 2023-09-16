package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;

/**
 * 売上請求結果エラーリストテーブル(IT_UriageSeikyuuKkErrorListDao) アクセス用の DAO クラスです。<br />
 */
public class IT_UriageSeikyuuKkErrorListDao extends AbstractDao<IT_UriageSeikyuuKkErrorList> {

    public IT_UriageSeikyuuKkErrorListDao() {
        super(IT_UriageSeikyuuKkErrorList.class);
    }

    public IT_UriageSeikyuuKkErrorList getUriageSeikyuuKkErrorList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        IT_UriageSeikyuuKkErrorList iT_UriageSeikyuuKkErrorList =  new IT_UriageSeikyuuKkErrorList();
        iT_UriageSeikyuuKkErrorList.setSyono(pSyono);
        iT_UriageSeikyuuKkErrorList.setCreditkessaiyouno(pCreditkessaiyouno);
        iT_UriageSeikyuuKkErrorList.setUriagenengappi(pUriagenengappi);
        iT_UriageSeikyuuKkErrorList.setRenno3keta(pRenno3keta);
        return this.selectOne(iT_UriageSeikyuuKkErrorList);
    }
}
