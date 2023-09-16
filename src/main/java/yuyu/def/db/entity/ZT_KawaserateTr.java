package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KawaserateTr;
import yuyu.def.db.mapping.GenZT_KawaserateTr;
import yuyu.def.db.meta.GenQZT_KawaserateTr;
import yuyu.def.db.meta.QZT_KawaserateTr;

/**
 * 為替レートテーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KawaserateTr} の JavaDoc を参照してください。
 * @see     GenZT_KawaserateTr
 * @see     PKZT_KawaserateTr
 * @see     QZT_KawaserateTr
 * @see     GenQZT_KawaserateTr
 */
@Entity
public class ZT_KawaserateTr extends GenZT_KawaserateTr {

    private static final long serialVersionUID = 1L;

    public ZT_KawaserateTr() {
    }

    public ZT_KawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn) {
        super(pZtrkwsratekjymd, pZtrkawaserendoukbn);
    }

}
