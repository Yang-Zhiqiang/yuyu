package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KawaserateRn;
import yuyu.def.db.mapping.GenZT_KawaserateRn;
import yuyu.def.db.meta.GenQZT_KawaserateRn;
import yuyu.def.db.meta.QZT_KawaserateRn;

/**
 * 為替レートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KawaserateRn} の JavaDoc を参照してください。
 * @see     GenZT_KawaserateRn
 * @see     PKZT_KawaserateRn
 * @see     QZT_KawaserateRn
 * @see     GenQZT_KawaserateRn
 */
@Entity
public class ZT_KawaserateRn extends GenZT_KawaserateRn {

    private static final long serialVersionUID = 1L;

    public ZT_KawaserateRn() {
    }

    public ZT_KawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn) {
        super(pZrnkwsratekjymd, pZrnkawaserendoukbn);
    }

}
