package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkJhNkgnsHonken;
import yuyu.def.db.mapping.GenBM_ChkJhNkgnsHonken;
import yuyu.def.db.meta.GenQBM_ChkJhNkgnsHonken;
import yuyu.def.db.meta.QBM_ChkJhNkgnsHonken;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 年金原資本件事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhNkgnsHonken} の JavaDoc を参照してください。
 * @see     GenBM_ChkJhNkgnsHonken
 * @see     PKBM_ChkJhNkgnsHonken
 * @see     QBM_ChkJhNkgnsHonken
 * @see     GenQBM_ChkJhNkgnsHonken
 */
@Entity
public class BM_ChkJhNkgnsHonken extends GenBM_ChkJhNkgnsHonken {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhNkgnsHonken() {
    }

    public BM_ChkJhNkgnsHonken(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen
    ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen
        );
    }

}
