package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.mapping.GenZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Ty;

/**
 * 新契約保険証券推移表Ｆテーブル２（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkeiyakuSyoukenSuii2Ty} の JavaDoc を参照してください。
 * @see     GenZT_SinkeiyakuSyoukenSuii2Ty
 * @see     PKZT_SinkeiyakuSyoukenSuii2Ty
 * @see     QZT_SinkeiyakuSyoukenSuii2Ty
 * @see     GenQZT_SinkeiyakuSyoukenSuii2Ty
 */
@Entity
public class ZT_SinkeiyakuSyoukenSuii2Ty extends GenZT_SinkeiyakuSyoukenSuii2Ty {

    private static final long serialVersionUID = 1L;

    public ZT_SinkeiyakuSyoukenSuii2Ty() {
    }

    public ZT_SinkeiyakuSyoukenSuii2Ty(
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
