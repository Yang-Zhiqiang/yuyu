package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_UriageSkDataSyuKnr;

/**
 * 売上請求データ収納管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_UriageSkDataSyuKnr} の JavaDoc を参照してください。<br />
 * @see     GenIT_UriageSkDataSyuKnr<br />
 * @see     PKIT_UriageSkDataSyuKnr<br />
 * @see     QIT_UriageSkDataSyuKnr<br />
 * @see     GenQIT_UriageSkDataSyuKnr<br />
 */
@Entity
public class IT_UriageSkDataSyuKnr extends GenIT_UriageSkDataSyuKnr {

    private static final long serialVersionUID = 1L;

    public IT_UriageSkDataSyuKnr() {
    }

    public IT_UriageSkDataSyuKnr(String pKbnkey,String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }

    public IT_UriageSkDataSyuKnr(String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }


}

