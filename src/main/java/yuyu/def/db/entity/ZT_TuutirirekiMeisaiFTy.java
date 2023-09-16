package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.mapping.GenZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.GenQZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFTy;

/**
 * 通知履歴明細ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TuutirirekiMeisaiFTy} の JavaDoc を参照してください。
 * @see     GenZT_TuutirirekiMeisaiFTy
 * @see     PKZT_TuutirirekiMeisaiFTy
 * @see     QZT_TuutirirekiMeisaiFTy
 * @see     GenQZT_TuutirirekiMeisaiFTy
 */
@Entity
public class ZT_TuutirirekiMeisaiFTy extends GenZT_TuutirirekiMeisaiFTy {

    private static final long serialVersionUID = 1L;

    public ZT_TuutirirekiMeisaiFTy() {
    }

    public ZT_TuutirirekiMeisaiFTy(
        String pZtytuutirirekino,
        String pZtytuutisakuseiymd,
        String pZtytuutisakuseino
    ) {
        super(
            pZtytuutirirekino,
            pZtytuutisakuseiymd,
            pZtytuutisakuseino
        );
    }

}
