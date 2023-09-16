package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HknkykIdouInfoRn;
import yuyu.def.db.mapping.GenZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.GenQZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.QZT_HknkykIdouInfoRn;

/**
 * 保険契約異動情報テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HknkykIdouInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_HknkykIdouInfoRn
 * @see     PKZT_HknkykIdouInfoRn
 * @see     QZT_HknkykIdouInfoRn
 * @see     GenQZT_HknkykIdouInfoRn
 */
@Entity
public class ZT_HknkykIdouInfoRn extends GenZT_HknkykIdouInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_HknkykIdouInfoRn() {
    }

    public ZT_HknkykIdouInfoRn(
        String pZrnkyktuukasyu,
        String pZrnidouymd,
        String pZrnidoujiyuukbnzfi,
        String pZrndatakanrino,
        String pZrnrenno,
        String pZrntumitatekinkbn
    ) {
        super(
            pZrnkyktuukasyu,
            pZrnidouymd,
            pZrnidoujiyuukbnzfi,
            pZrndatakanrino,
            pZrnrenno,
            pZrntumitatekinkbn
        );
    }

}
