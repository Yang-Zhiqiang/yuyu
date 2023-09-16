package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_MosMatiKknKeikaWk;
import yuyu.def.db.mapping.GenHW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.GenQHW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.QHW_MosMatiKknKeikaWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 申込書入力待期間経過ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_MosMatiKknKeikaWk} の JavaDoc を参照してください。
 * @see     GenHW_MosMatiKknKeikaWk
 * @see     PKHW_MosMatiKknKeikaWk
 * @see     QHW_MosMatiKknKeikaWk
 * @see     GenQHW_MosMatiKknKeikaWk
 */
@Entity
public class HW_MosMatiKknKeikaWk extends GenHW_MosMatiKknKeikaWk {

    private static final long serialVersionUID = 1L;

    public HW_MosMatiKknKeikaWk() {
    }

    public HW_MosMatiKknKeikaWk(BizDate pNyksyoriymd, String pItirenno) {
        super(pNyksyoriymd, pItirenno);
    }

}
