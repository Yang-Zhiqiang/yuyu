package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu2Rn;
import yuyu.def.db.mapping.GenZT_Sp2RnduyuSouseiritu2Rn;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu2Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu2Rn;

/**
 * ＳＰ２連動用総成立Fテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Sp2RnduyuSouseiritu2Rn} の JavaDoc を参照してください。
 * @see     GenZT_Sp2RnduyuSouseiritu2Rn
 * @see     PKZT_Sp2RnduyuSouseiritu2Rn
 * @see     QZT_Sp2RnduyuSouseiritu2Rn
 * @see     GenQZT_Sp2RnduyuSouseiritu2Rn
 */
@Entity
public class ZT_Sp2RnduyuSouseiritu2Rn extends GenZT_Sp2RnduyuSouseiritu2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Sp2RnduyuSouseiritu2Rn() {
    }

    public ZT_Sp2RnduyuSouseiritu2Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
