package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenBM_ChkJhNkgns;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 年金原資限度事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhNkgns} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkJhNkgns<br />
 * @see     PKBM_ChkJhNkgns<br />
 * @see     QBM_ChkJhNkgns<br />
 * @see     GenQBM_ChkJhNkgns<br />
 */
@Entity
public class BM_ChkJhNkgns extends GenBM_ChkJhNkgns {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhNkgns() {
    }

    public BM_ChkJhNkgns(BizNumber pHhknfromnen,BizNumber pHhkntonen) {
        super(pHhknfromnen,pHhkntonen);
    }

}
