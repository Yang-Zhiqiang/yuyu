package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_HrkmNyknData;
import yuyu.def.db.mapping.GenHT_HrkmNyknData;
import yuyu.def.db.meta.GenQHT_HrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknData;
import yuyu.def.classification.C_DensysKbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 振込入金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_HrkmNyknData} の JavaDoc を参照してください。
 * @see     GenHT_HrkmNyknData
 * @see     PKHT_HrkmNyknData
 * @see     QHT_HrkmNyknData
 * @see     GenQHT_HrkmNyknData
 */
@Entity
public class HT_HrkmNyknData extends GenHT_HrkmNyknData {

    private static final long serialVersionUID = 1L;

    public HT_HrkmNyknData() {
    }

    public HT_HrkmNyknData(
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
