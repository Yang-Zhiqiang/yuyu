package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenIT_MinusUriageKykDtlList;


/**
 * マイナス売上契約明細リストテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_MinusUriageKykDtlList} の JavaDoc を参照してください。<br />
 * @see     GenIT_MinusUriageKykDtlList<br />
 * @see     PKIT_MinusUriageKykDtlList<br />
 * @see     QIT_MinusUriageKykDtlList<br />
 * @see     GenQIT_MinusUriageKykDtlList<br />
 */
@Entity
public class IT_MinusUriageKykDtlList extends GenIT_MinusUriageKykDtlList {

    private static final long serialVersionUID = 1L;

    public IT_MinusUriageKykDtlList() {
    }

    public IT_MinusUriageKykDtlList(String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }



}

