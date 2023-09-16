package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SbRituRendouRn;
import yuyu.def.db.mapping.GenZT_SbRituRendouRn;
import yuyu.def.db.meta.GenQZT_SbRituRendouRn;
import yuyu.def.db.meta.QZT_SbRituRendouRn;

/**
 * 死亡率用連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SbRituRendouRn} の JavaDoc を参照してください。
 * @see     GenZT_SbRituRendouRn
 * @see     PKZT_SbRituRendouRn
 * @see     QZT_SbRituRendouRn
 * @see     GenQZT_SbRituRendouRn
 */
@Entity
public class ZT_SbRituRendouRn extends GenZT_SbRituRendouRn {

    private static final long serialVersionUID = 1L;

    public ZT_SbRituRendouRn() {
    }

    public ZT_SbRituRendouRn(String pZrndatakanrino) {
        super(pZrndatakanrino);
    }

}
