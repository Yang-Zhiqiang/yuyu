package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknKimatuVRn;
import yuyu.def.db.mapping.GenZT_KbkSsuRnduHknKimatuVRn;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknKimatuVRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknKimatuVRn;

/**
 * 株価指数連動保険期末ＶＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KbkSsuRnduHknKimatuVRn} の JavaDoc を参照してください。
 * @see     GenZT_KbkSsuRnduHknKimatuVRn
 * @see     PKZT_KbkSsuRnduHknKimatuVRn
 * @see     QZT_KbkSsuRnduHknKimatuVRn
 * @see     GenQZT_KbkSsuRnduHknKimatuVRn
 */
@Entity
public class ZT_KbkSsuRnduHknKimatuVRn extends GenZT_KbkSsuRnduHknKimatuVRn {

    private static final long serialVersionUID = 1L;

    public ZT_KbkSsuRnduHknKimatuVRn() {
    }

    public ZT_KbkSsuRnduHknKimatuVRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
