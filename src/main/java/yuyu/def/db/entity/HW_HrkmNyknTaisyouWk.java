package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_HrkmNyknTaisyouWk;
import yuyu.def.db.mapping.GenHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.GenQHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 振込入金対象ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_HrkmNyknTaisyouWk} の JavaDoc を参照してください。
 * @see     GenHW_HrkmNyknTaisyouWk
 * @see     PKHW_HrkmNyknTaisyouWk
 * @see     QHW_HrkmNyknTaisyouWk
 * @see     GenQHW_HrkmNyknTaisyouWk
 */
@Entity
public class HW_HrkmNyknTaisyouWk extends GenHW_HrkmNyknTaisyouWk {

    private static final long serialVersionUID = 1L;

    public HW_HrkmNyknTaisyouWk() {
    }

    public HW_HrkmNyknTaisyouWk(
        BizDate pSyoriYmd,
        String pMosno,
        Integer pRenno
    ) {
        super(
            pSyoriYmd,
            pMosno,
            pRenno
        );
    }

}
