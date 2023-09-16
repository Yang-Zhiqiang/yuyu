package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.mapping.GenZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.GenQZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrRn;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkCreditTourokukekkaQrRn} の JavaDoc を参照してください。
 * @see     GenZT_SkCreditTourokukekkaQrRn
 * @see     PKZT_SkCreditTourokukekkaQrRn
 * @see     QZT_SkCreditTourokukekkaQrRn
 * @see     GenQZT_SkCreditTourokukekkaQrRn
 */
@Entity
public class ZT_SkCreditTourokukekkaQrRn extends GenZT_SkCreditTourokukekkaQrRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkCreditTourokukekkaQrRn() {
    }

    public ZT_SkCreditTourokukekkaQrRn(
        String pZrnsystemjyusinymd,
        String pZrnsystemjyusintime,
        String pZrncreditkessaiyouno
    ) {
        super(
            pZrnsystemjyusinymd,
            pZrnsystemjyusintime,
            pZrncreditkessaiyouno
        );
    }

}
