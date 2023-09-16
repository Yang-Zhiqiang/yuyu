package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.mapping.GenHT_GaikaHrkmNyknData;


/**
 * 外貨振込入金データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_GaikaHrkmNyknData} の JavaDoc を参照してください。<br />
 * @see     GenHT_GaikaHrkmNyknData<br />
 * @see     PKHT_GaikaHrkmNyknData<br />
 * @see     QHT_GaikaHrkmNyknData<br />
 * @see     GenQHT_GaikaHrkmNyknData<br />
 */
@Entity
public class HT_GaikaHrkmNyknData extends GenHT_GaikaHrkmNyknData {

    private static final long serialVersionUID = 1L;

    public HT_GaikaHrkmNyknData() {
    }

    public HT_GaikaHrkmNyknData(C_DensysKbn pDensyskbn,BizDate pSyoriYmd,String pItirenno) {
        super(pDensyskbn,pSyoriYmd,pItirenno);
    }



}

