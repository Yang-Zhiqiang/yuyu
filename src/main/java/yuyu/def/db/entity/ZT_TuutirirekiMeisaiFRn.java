package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.mapping.GenZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.GenQZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFRn;

/**
 * 通知履歴明細ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TuutirirekiMeisaiFRn} の JavaDoc を参照してください。
 * @see     GenZT_TuutirirekiMeisaiFRn
 * @see     PKZT_TuutirirekiMeisaiFRn
 * @see     QZT_TuutirirekiMeisaiFRn
 * @see     GenQZT_TuutirirekiMeisaiFRn
 */
@Entity
public class ZT_TuutirirekiMeisaiFRn extends GenZT_TuutirirekiMeisaiFRn {

    private static final long serialVersionUID = 1L;

    public ZT_TuutirirekiMeisaiFRn() {
    }

    public ZT_TuutirirekiMeisaiFRn(
        String pZrntuutirirekino,
        String pZrntuutisakuseiymd,
        String pZrntuutisakuseino
    ) {
        super(
            pZrntuutirirekino,
            pZrntuutisakuseiymd,
            pZrntuutisakuseino
        );
    }

}
