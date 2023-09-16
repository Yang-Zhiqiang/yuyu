package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknIdouVRn;
import yuyu.def.db.mapping.GenZT_KbkSsuRnduHknIdouVRn;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknIdouVRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVRn;

/**
 * 株価指数連動保険異動ＶＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KbkSsuRnduHknIdouVRn} の JavaDoc を参照してください。
 * @see     GenZT_KbkSsuRnduHknIdouVRn
 * @see     PKZT_KbkSsuRnduHknIdouVRn
 * @see     QZT_KbkSsuRnduHknIdouVRn
 * @see     GenQZT_KbkSsuRnduHknIdouVRn
 */
@Entity
public class ZT_KbkSsuRnduHknIdouVRn extends GenZT_KbkSsuRnduHknIdouVRn {

    private static final long serialVersionUID = 1L;

    public ZT_KbkSsuRnduHknIdouVRn() {
    }

    public ZT_KbkSsuRnduHknIdouVRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
