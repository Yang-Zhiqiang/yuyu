package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_YuukouKakErrorList;
import yuyu.def.db.mapping.GenIT_YuukouKakErrorList;
import yuyu.def.db.meta.GenQIT_YuukouKakErrorList;
import yuyu.def.db.meta.QIT_YuukouKakErrorList;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 有効確認エラーリストテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YuukouKakErrorList} の JavaDoc を参照してください。
 * @see     GenIT_YuukouKakErrorList
 * @see     PKIT_YuukouKakErrorList
 * @see     QIT_YuukouKakErrorList
 * @see     GenQIT_YuukouKakErrorList
 */
@Entity
public class IT_YuukouKakErrorList extends GenIT_YuukouKakErrorList {

    private static final long serialVersionUID = 1L;

    public IT_YuukouKakErrorList() {
    }

    public IT_YuukouKakErrorList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDateYM pSyoriym
    ) {
        super(
            pSyono,
            pCreditkessaiyouno,
            pSyoriym
        );
    }

}
