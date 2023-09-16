package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.mapping.GenHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.GenQHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.QHW_SyuHukugouSikkanZhkWk;

/**
 * 主契約複合疾患増幅ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_SyuHukugouSikkanZhkWk} の JavaDoc を参照してください。
 * @see     GenHW_SyuHukugouSikkanZhkWk
 * @see     PKHW_SyuHukugouSikkanZhkWk
 * @see     QHW_SyuHukugouSikkanZhkWk
 * @see     GenQHW_SyuHukugouSikkanZhkWk
 */
@Entity
public class HW_SyuHukugouSikkanZhkWk extends GenHW_SyuHukugouSikkanZhkWk {

    private static final long serialVersionUID = 1L;

    public HW_SyuHukugouSikkanZhkWk() {
    }

    public HW_SyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo) {
        super(pSyono, pHknnendo);
    }

}
