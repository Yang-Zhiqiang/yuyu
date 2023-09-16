package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkeiyakuSyoukenSuiiRn;
import yuyu.def.db.mapping.GenZT_SinkeiyakuSyoukenSuiiRn;
import yuyu.def.db.meta.GenQZT_SinkeiyakuSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuiiRn;

/**
 * 新契約保険証券推移表Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkeiyakuSyoukenSuiiRn} の JavaDoc を参照してください。
 * @see     GenZT_SinkeiyakuSyoukenSuiiRn
 * @see     PKZT_SinkeiyakuSyoukenSuiiRn
 * @see     QZT_SinkeiyakuSyoukenSuiiRn
 * @see     GenQZT_SinkeiyakuSyoukenSuiiRn
 */
@Entity
public class ZT_SinkeiyakuSyoukenSuiiRn extends GenZT_SinkeiyakuSyoukenSuiiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SinkeiyakuSyoukenSuiiRn() {
    }

    public ZT_SinkeiyakuSyoukenSuiiRn(
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
