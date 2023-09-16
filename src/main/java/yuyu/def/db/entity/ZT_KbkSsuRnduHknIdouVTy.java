package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.mapping.GenZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVTy;

/**
 * 株価指数連動保険異動ＶＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KbkSsuRnduHknIdouVTy} の JavaDoc を参照してください。
 * @see     GenZT_KbkSsuRnduHknIdouVTy
 * @see     PKZT_KbkSsuRnduHknIdouVTy
 * @see     QZT_KbkSsuRnduHknIdouVTy
 * @see     GenQZT_KbkSsuRnduHknIdouVTy
 */
@Entity
public class ZT_KbkSsuRnduHknIdouVTy extends GenZT_KbkSsuRnduHknIdouVTy {

    private static final long serialVersionUID = 1L;

    public ZT_KbkSsuRnduHknIdouVTy() {
    }

    public ZT_KbkSsuRnduHknIdouVTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
