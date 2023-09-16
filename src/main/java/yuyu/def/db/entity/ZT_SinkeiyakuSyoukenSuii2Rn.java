package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.mapping.GenZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Rn;

/**
 * 新契約保険証券推移表Ｆテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkeiyakuSyoukenSuii2Rn} の JavaDoc を参照してください。
 * @see     GenZT_SinkeiyakuSyoukenSuii2Rn
 * @see     PKZT_SinkeiyakuSyoukenSuii2Rn
 * @see     QZT_SinkeiyakuSyoukenSuii2Rn
 * @see     GenQZT_SinkeiyakuSyoukenSuii2Rn
 */
@Entity
public class ZT_SinkeiyakuSyoukenSuii2Rn extends GenZT_SinkeiyakuSyoukenSuii2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_SinkeiyakuSyoukenSuii2Rn() {
    }

    public ZT_SinkeiyakuSyoukenSuii2Rn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsuiihyouptn
    ) {
        super(
            pZrnsyono,
            pZrntyouhyouymd,
            pZrnsuiihyouptn
        );
    }

}
