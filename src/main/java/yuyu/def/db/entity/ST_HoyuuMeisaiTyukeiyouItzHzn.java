package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.mapping.GenST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.GenQST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_HoyuuMeisaiTyukeiyouItzHzn;

/**
 * 保有明細中継用一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_HoyuuMeisaiTyukeiyouItzHzn} の JavaDoc を参照してください。
 * @see     GenST_HoyuuMeisaiTyukeiyouItzHzn
 * @see     PKST_HoyuuMeisaiTyukeiyouItzHzn
 * @see     QST_HoyuuMeisaiTyukeiyouItzHzn
 * @see     GenQST_HoyuuMeisaiTyukeiyouItzHzn
 */
@Entity
public class ST_HoyuuMeisaiTyukeiyouItzHzn extends GenST_HoyuuMeisaiTyukeiyouItzHzn {

    private static final long serialVersionUID = 1L;

    public ST_HoyuuMeisaiTyukeiyouItzHzn() {
    }

    public ST_HoyuuMeisaiTyukeiyouItzHzn(
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
