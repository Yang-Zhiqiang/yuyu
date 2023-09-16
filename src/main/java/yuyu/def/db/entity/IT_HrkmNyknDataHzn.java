package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_HrkmNyknDataHzn;
import yuyu.def.db.mapping.GenIT_HrkmNyknDataHzn;
import yuyu.def.db.meta.GenQIT_HrkmNyknDataHzn;
import yuyu.def.db.meta.QIT_HrkmNyknDataHzn;
import yuyu.def.classification.C_DensysKbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 振込入金データ（保全用）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HrkmNyknDataHzn} の JavaDoc を参照してください。
 * @see     GenIT_HrkmNyknDataHzn
 * @see     PKIT_HrkmNyknDataHzn
 * @see     QIT_HrkmNyknDataHzn
 * @see     GenQIT_HrkmNyknDataHzn
 */
@Entity
public class IT_HrkmNyknDataHzn extends GenIT_HrkmNyknDataHzn {

    private static final long serialVersionUID = 1L;

    public IT_HrkmNyknDataHzn() {
    }

    public IT_HrkmNyknDataHzn(
        C_DensysKbn pDensyskbn,
        BizDate pSyoriYmd,
        String pItirenno
    ) {
        super(
            pDensyskbn,
            pSyoriYmd,
            pItirenno
        );
    }

}
