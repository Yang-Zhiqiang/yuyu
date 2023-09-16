package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.mapping.GenIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.GenQIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.QIT_UriageSeikyuuKkErrorList;
import jp.co.slcs.swak.date.BizDate;

/**
 * 売上請求結果エラーリストテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_UriageSeikyuuKkErrorList} の JavaDoc を参照してください。
 * @see     GenIT_UriageSeikyuuKkErrorList
 * @see     PKIT_UriageSeikyuuKkErrorList
 * @see     QIT_UriageSeikyuuKkErrorList
 * @see     GenQIT_UriageSeikyuuKkErrorList
 */
@Entity
public class IT_UriageSeikyuuKkErrorList extends GenIT_UriageSeikyuuKkErrorList {

    private static final long serialVersionUID = 1L;

    public IT_UriageSeikyuuKkErrorList() {
    }

    public IT_UriageSeikyuuKkErrorList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        super(
            pSyono,
            pCreditkessaiyouno,
            pUriagenengappi,
            pRenno3keta
        );
    }

}
