package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.mapping.GenZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.meta.GenQZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Rn;

/**
 * 再発行保険証券推移表Ｆテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SaihakkouSyoukenSuii2Rn} の JavaDoc を参照してください。
 * @see     GenZT_SaihakkouSyoukenSuii2Rn
 * @see     PKZT_SaihakkouSyoukenSuii2Rn
 * @see     QZT_SaihakkouSyoukenSuii2Rn
 * @see     GenQZT_SaihakkouSyoukenSuii2Rn
 */
@Entity
public class ZT_SaihakkouSyoukenSuii2Rn extends GenZT_SaihakkouSyoukenSuii2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_SaihakkouSyoukenSuii2Rn() {
    }

    public ZT_SaihakkouSyoukenSuii2Rn(
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
