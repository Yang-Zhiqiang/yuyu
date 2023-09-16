package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.db.mapping.GenZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Ty;

/**
 * 再発行保険証券推移表Ｆテーブル２（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SaihakkouSyoukenSuii2Ty} の JavaDoc を参照してください。
 * @see     GenZT_SaihakkouSyoukenSuii2Ty
 * @see     PKZT_SaihakkouSyoukenSuii2Ty
 * @see     QZT_SaihakkouSyoukenSuii2Ty
 * @see     GenQZT_SaihakkouSyoukenSuii2Ty
 */
@Entity
public class ZT_SaihakkouSyoukenSuii2Ty extends GenZT_SaihakkouSyoukenSuii2Ty {

    private static final long serialVersionUID = 1L;

    public ZT_SaihakkouSyoukenSuii2Ty() {
    }

    public ZT_SaihakkouSyoukenSuii2Ty(
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
