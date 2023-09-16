package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.mapping.GenZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.GenQZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrTr;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkCreditTourokukekkaQrTr} の JavaDoc を参照してください。
 * @see     GenZT_SkCreditTourokukekkaQrTr
 * @see     PKZT_SkCreditTourokukekkaQrTr
 * @see     QZT_SkCreditTourokukekkaQrTr
 * @see     GenQZT_SkCreditTourokukekkaQrTr
 */
@Entity
public class ZT_SkCreditTourokukekkaQrTr extends GenZT_SkCreditTourokukekkaQrTr {

    private static final long serialVersionUID = 1L;

    public ZT_SkCreditTourokukekkaQrTr() {
    }

    public ZT_SkCreditTourokukekkaQrTr(
        String pZtrsystemjyusinymd,
        String pZtrsystemjyusintime,
        String pZtrcreditkessaiyouno
    ) {
        super(
            pZtrsystemjyusinymd,
            pZtrsystemjyusintime,
            pZtrcreditkessaiyouno
        );
    }

}
