package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJM_ChkSiJimuttdk;
import yuyu.def.db.mapping.GenJM_ChkSiJimuttdk;
import yuyu.def.db.meta.GenQJM_ChkSiJimuttdk;
import yuyu.def.db.meta.QJM_ChkSiJimuttdk;

/**
 * 支払事務手続チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_ChkSiJimuttdk} の JavaDoc を参照してください。
 * @see     GenJM_ChkSiJimuttdk
 * @see     PKJM_ChkSiJimuttdk
 * @see     QJM_ChkSiJimuttdk
 * @see     GenQJM_ChkSiJimuttdk
 */
@Entity
public class JM_ChkSiJimuttdk extends GenJM_ChkSiJimuttdk {

    private static final long serialVersionUID = 1L;

    public JM_ChkSiJimuttdk() {
    }

    public JM_ChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd) {
        super(pKinouId, pSyorijimuttdkcd);
    }

}
