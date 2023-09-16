package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.mapping.GenZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.GenQZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiRn;

/**
 * 外貨建顧客通知Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GaikaKokyakuTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_GaikaKokyakuTuutiRn
 * @see     PKZT_GaikaKokyakuTuutiRn
 * @see     QZT_GaikaKokyakuTuutiRn
 * @see     GenQZT_GaikaKokyakuTuutiRn
 */
@Entity
public class ZT_GaikaKokyakuTuutiRn extends GenZT_GaikaKokyakuTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_GaikaKokyakuTuutiRn() {
    }

    public ZT_GaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
