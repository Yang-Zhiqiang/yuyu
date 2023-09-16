package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMV_MailAddressRenbanSaisin;
import yuyu.def.db.mapping.GenMV_MailAddressRenbanSaisin;
import yuyu.def.db.meta.GenQMV_MailAddressRenbanSaisin;
import yuyu.def.db.meta.QMV_MailAddressRenbanSaisin;

/**
 * ＤＳメールアドレス連番最新ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMV_MailAddressRenbanSaisin} の JavaDoc を参照してください。
 * @see     GenMV_MailAddressRenbanSaisin
 * @see     PKMV_MailAddressRenbanSaisin
 * @see     QMV_MailAddressRenbanSaisin
 * @see     GenQMV_MailAddressRenbanSaisin
 */
@Entity
public class MV_MailAddressRenbanSaisin extends GenMV_MailAddressRenbanSaisin {

    private static final long serialVersionUID = 1L;

    public MV_MailAddressRenbanSaisin() {
    }

    public MV_MailAddressRenbanSaisin(String pDskokno, Integer pDsmailaddressrenban) {
        super(pDskokno, pDsmailaddressrenban);
    }

}
