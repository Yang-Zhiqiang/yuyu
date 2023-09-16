package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenBM_ChkNkgns;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 年金原資限度チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNkgns} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkNkgns<br />
 * @see     PKBM_ChkNkgns<br />
 * @see     QBM_ChkNkgns<br />
 * @see     GenQBM_ChkNkgns<br />
 */
@Entity
public class BM_ChkNkgns extends GenBM_ChkNkgns {

    private static final long serialVersionUID = 1L;

    public BM_ChkNkgns() {
    }

    public BM_ChkNkgns(BizNumber pHhknfromnen,BizNumber pHhkntonen) {
        super(pHhknfromnen,pHhkntonen);
    }

}
