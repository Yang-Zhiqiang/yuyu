package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;

/**
 * マイナス売上契約明細リストテーブル(IT_MinusUriageKykDtlListDao) アクセス用の DAO クラスです。<br />
 */
public class IT_MinusUriageKykDtlListDao extends AbstractDao<IT_MinusUriageKykDtlList> {

    public IT_MinusUriageKykDtlListDao() {
        super(IT_MinusUriageKykDtlList.class);
    }

    public IT_MinusUriageKykDtlList getMinusUriageKykDtlList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        IT_MinusUriageKykDtlList iT_MinusUriageKykDtlList =  new IT_MinusUriageKykDtlList();
        iT_MinusUriageKykDtlList.setSyono(pSyono);
        iT_MinusUriageKykDtlList.setCreditkessaiyouno(pCreditkessaiyouno);
        iT_MinusUriageKykDtlList.setUriagenengappi(pUriagenengappi);
        iT_MinusUriageKykDtlList.setRenno3keta(pRenno3keta);
        return this.selectOne(iT_MinusUriageKykDtlList);
    }
}
