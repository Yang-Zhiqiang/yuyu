package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknKimatuVTy;
import yuyu.def.db.mapping.GenZT_KbkSsuRnduHknKimatuVTy;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknKimatuVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknKimatuVTy;

/**
 * 株価指数連動保険期末ＶＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KbkSsuRnduHknKimatuVTy} の JavaDoc を参照してください。
 * @see     GenZT_KbkSsuRnduHknKimatuVTy
 * @see     PKZT_KbkSsuRnduHknKimatuVTy
 * @see     QZT_KbkSsuRnduHknKimatuVTy
 * @see     GenQZT_KbkSsuRnduHknKimatuVTy
 */
@Entity
public class ZT_KbkSsuRnduHknKimatuVTy extends GenZT_KbkSsuRnduHknKimatuVTy {

    private static final long serialVersionUID = 1L;

    public ZT_KbkSsuRnduHknKimatuVTy() {
    }

    public ZT_KbkSsuRnduHknKimatuVTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
