package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.mapping.GenST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.GenQST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.QST_SynypTukiTugtTykiyuHozon;

/**
 * 収入Ｐ統計当月処理中継用保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_SynypTukiTugtTykiyuHozon} の JavaDoc を参照してください。
 * @see     GenST_SynypTukiTugtTykiyuHozon
 * @see     PKST_SynypTukiTugtTykiyuHozon
 * @see     QST_SynypTukiTugtTykiyuHozon
 * @see     GenQST_SynypTukiTugtTykiyuHozon
 */
@Entity
public class ST_SynypTukiTugtTykiyuHozon extends GenST_SynypTukiTugtTykiyuHozon {

    private static final long serialVersionUID = 1L;

    public ST_SynypTukiTugtTykiyuHozon() {
    }

    public ST_SynypTukiTugtTykiyuHozon(
        String pZtysrkijyunym,
        String pZtysrkakutyoujobcd,
        Integer pZtysequenceno
    ) {
        super(
            pZtysrkijyunym,
            pZtysrkakutyoujobcd,
            pZtysequenceno
        );
    }

}
