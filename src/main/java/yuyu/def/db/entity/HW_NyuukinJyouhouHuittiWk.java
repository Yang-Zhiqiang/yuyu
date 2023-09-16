package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.mapping.GenHW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.meta.GenQHW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.meta.QHW_NyuukinJyouhouHuittiWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 入金情報不一致ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_NyuukinJyouhouHuittiWk} の JavaDoc を参照してください。
 * @see     GenHW_NyuukinJyouhouHuittiWk
 * @see     PKHW_NyuukinJyouhouHuittiWk
 * @see     QHW_NyuukinJyouhouHuittiWk
 * @see     GenQHW_NyuukinJyouhouHuittiWk
 */
@Entity
public class HW_NyuukinJyouhouHuittiWk extends GenHW_NyuukinJyouhouHuittiWk {

    private static final long serialVersionUID = 1L;

    public HW_NyuukinJyouhouHuittiWk() {
    }

    public HW_NyuukinJyouhouHuittiWk(BizDate pNyksyoriymd, String pItirenno) {
        super(pNyksyoriymd, pItirenno);
    }

}
