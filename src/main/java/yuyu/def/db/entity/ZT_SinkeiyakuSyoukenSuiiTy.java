package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.db.mapping.GenZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuiiTy;

/**
 * 新契約保険証券推移表Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkeiyakuSyoukenSuiiTy} の JavaDoc を参照してください。
 * @see     GenZT_SinkeiyakuSyoukenSuiiTy
 * @see     PKZT_SinkeiyakuSyoukenSuiiTy
 * @see     QZT_SinkeiyakuSyoukenSuiiTy
 * @see     GenQZT_SinkeiyakuSyoukenSuiiTy
 */
@Entity
public class ZT_SinkeiyakuSyoukenSuiiTy extends GenZT_SinkeiyakuSyoukenSuiiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SinkeiyakuSyoukenSuiiTy() {
    }

    public ZT_SinkeiyakuSyoukenSuiiTy(
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
