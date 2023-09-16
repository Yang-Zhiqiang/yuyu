package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.mapping.GenZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiTy;

/**
 * 再発行保険証券推移表Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SaihakkouSyoukenSuiiTy} の JavaDoc を参照してください。
 * @see     GenZT_SaihakkouSyoukenSuiiTy
 * @see     PKZT_SaihakkouSyoukenSuiiTy
 * @see     QZT_SaihakkouSyoukenSuiiTy
 * @see     GenQZT_SaihakkouSyoukenSuiiTy
 */
@Entity
public class ZT_SaihakkouSyoukenSuiiTy extends GenZT_SaihakkouSyoukenSuiiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SaihakkouSyoukenSuiiTy() {
    }

    public ZT_SaihakkouSyoukenSuiiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysuiihyouptn
    ) {
        super(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysuiihyouptn
        );
    }

}
