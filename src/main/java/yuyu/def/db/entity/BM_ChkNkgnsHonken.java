package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkNkgnsHonken;
import yuyu.def.db.mapping.GenBM_ChkNkgnsHonken;
import yuyu.def.db.meta.GenQBM_ChkNkgnsHonken;
import yuyu.def.db.meta.QBM_ChkNkgnsHonken;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 年金原資本件チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNkgnsHonken} の JavaDoc を参照してください。
 * @see     GenBM_ChkNkgnsHonken
 * @see     PKBM_ChkNkgnsHonken
 * @see     QBM_ChkNkgnsHonken
 * @see     GenQBM_ChkNkgnsHonken
 */
@Entity
public class BM_ChkNkgnsHonken extends GenBM_ChkNkgnsHonken {

    private static final long serialVersionUID = 1L;

    public BM_ChkNkgnsHonken() {
    }

    public BM_ChkNkgnsHonken(
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
