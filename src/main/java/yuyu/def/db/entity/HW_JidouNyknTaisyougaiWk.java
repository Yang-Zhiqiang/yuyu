package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.mapping.GenHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.GenQHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.QHW_JidouNyknTaisyougaiWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 自動入金対象外ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_JidouNyknTaisyougaiWk} の JavaDoc を参照してください。
 * @see     GenHW_JidouNyknTaisyougaiWk
 * @see     PKHW_JidouNyknTaisyougaiWk
 * @see     QHW_JidouNyknTaisyougaiWk
 * @see     GenQHW_JidouNyknTaisyougaiWk
 */
@Entity
public class HW_JidouNyknTaisyougaiWk extends GenHW_JidouNyknTaisyougaiWk {

    private static final long serialVersionUID = 1L;

    public HW_JidouNyknTaisyougaiWk() {
    }

    public HW_JidouNyknTaisyougaiWk(BizDate pNyksyoriymd, String pItirenno) {
        super(pNyksyoriymd, pItirenno);
    }

}
