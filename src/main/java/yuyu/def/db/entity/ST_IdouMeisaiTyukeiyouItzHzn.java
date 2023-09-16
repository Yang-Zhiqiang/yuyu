package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.mapping.GenST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.GenQST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_IdouMeisaiTyukeiyouItzHzn;

/**
 * 異動明細中継用一時保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_IdouMeisaiTyukeiyouItzHzn} の JavaDoc を参照してください。
 * @see     GenST_IdouMeisaiTyukeiyouItzHzn
 * @see     PKST_IdouMeisaiTyukeiyouItzHzn
 * @see     QST_IdouMeisaiTyukeiyouItzHzn
 * @see     GenQST_IdouMeisaiTyukeiyouItzHzn
 */
@Entity
public class ST_IdouMeisaiTyukeiyouItzHzn extends GenST_IdouMeisaiTyukeiyouItzHzn {

    private static final long serialVersionUID = 1L;

    public ST_IdouMeisaiTyukeiyouItzHzn() {
    }

    public ST_IdouMeisaiTyukeiyouItzHzn(
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
