package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAM_IdCardYakusyoku;
import yuyu.def.db.mapping.GenAM_IdCardYakusyoku;
import yuyu.def.db.meta.GenQAM_IdCardYakusyoku;
import yuyu.def.db.meta.QAM_IdCardYakusyoku;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＩＤカード役職マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_IdCardYakusyoku} の JavaDoc を参照してください。
 * @see     GenAM_IdCardYakusyoku
 * @see     PKAM_IdCardYakusyoku
 * @see     QAM_IdCardYakusyoku
 * @see     GenQAM_IdCardYakusyoku
 */
@Entity
public class AM_IdCardYakusyoku extends GenAM_IdCardYakusyoku {

    private static final long serialVersionUID = 1L;

    public AM_IdCardYakusyoku() {
    }

    public AM_IdCardYakusyoku(
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
