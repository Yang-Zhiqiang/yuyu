package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;

/**
 * 売上請求データ収納管理テーブル(IT_UriageSkDataSyuKnrDao) アクセス用の DAO クラスです。<br />
 */
public class IT_UriageSkDataSyuKnrDao extends AbstractDao<IT_UriageSkDataSyuKnr> {

    public IT_UriageSkDataSyuKnrDao() {
        super(IT_UriageSkDataSyuKnr.class);
    }

    public IT_UriageSkDataSyuKnr getUriageSkDataSyuKnr(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        IT_UriageSkDataSyuKnr iT_UriageSkDataSyuKnr =  new IT_UriageSkDataSyuKnr( pSyono,  pCreditkessaiyouno,  pUriagenengappi,  pRenno3keta);
        return this.selectOne(iT_UriageSkDataSyuKnr);
    }
}
