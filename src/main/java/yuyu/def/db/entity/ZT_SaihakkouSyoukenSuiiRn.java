package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.mapping.GenZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiRn;

/**
 * 再発行保険証券推移表Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SaihakkouSyoukenSuiiRn} の JavaDoc を参照してください。
 * @see     GenZT_SaihakkouSyoukenSuiiRn
 * @see     PKZT_SaihakkouSyoukenSuiiRn
 * @see     QZT_SaihakkouSyoukenSuiiRn
 * @see     GenQZT_SaihakkouSyoukenSuiiRn
 */
@Entity
public class ZT_SaihakkouSyoukenSuiiRn extends GenZT_SaihakkouSyoukenSuiiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SaihakkouSyoukenSuiiRn() {
    }

    public ZT_SaihakkouSyoukenSuiiRn(
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
