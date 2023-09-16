package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_IdCardYakusyokuWk;
import yuyu.def.db.mapping.GenBW_IdCardYakusyokuWk;
import yuyu.def.db.meta.GenQBW_IdCardYakusyokuWk;
import yuyu.def.db.meta.QBW_IdCardYakusyokuWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＩＤカード役職マスタワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_IdCardYakusyokuWk} の JavaDoc を参照してください。
 * @see     GenBW_IdCardYakusyokuWk
 * @see     PKBW_IdCardYakusyokuWk
 * @see     QBW_IdCardYakusyokuWk
 * @see     GenQBW_IdCardYakusyokuWk
 */
@Entity
public class BW_IdCardYakusyokuWk extends GenBW_IdCardYakusyokuWk {

    private static final long serialVersionUID = 1L;

    public BW_IdCardYakusyokuWk() {
    }

    public BW_IdCardYakusyokuWk(
        String pIdkbn,
        String pIdcd,
        BizDate pYakusyokuhatureiymd,
        String pYakusyokuhatureino
    ) {
        super(
            pIdkbn,
            pIdcd,
            pYakusyokuhatureiymd,
            pYakusyokuhatureino
        );
    }

}
