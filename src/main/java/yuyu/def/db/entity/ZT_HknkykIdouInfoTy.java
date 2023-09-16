package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HknkykIdouInfoTy;
import yuyu.def.db.mapping.GenZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.GenQZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.QZT_HknkykIdouInfoTy;

/**
 * 保険契約異動情報テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HknkykIdouInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_HknkykIdouInfoTy
 * @see     PKZT_HknkykIdouInfoTy
 * @see     QZT_HknkykIdouInfoTy
 * @see     GenQZT_HknkykIdouInfoTy
 */
@Entity
public class ZT_HknkykIdouInfoTy extends GenZT_HknkykIdouInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_HknkykIdouInfoTy() {
    }

    public ZT_HknkykIdouInfoTy(
        String pZtykyktuukasyu,
        String pZtyidouymd,
        String pZtyidoujiyuukbnzfi,
        String pZtydatakanrino,
        String pZtyrenno,
        String pZtytumitatekinkbn
    ) {
        super(
            pZtykyktuukasyu,
            pZtyidouymd,
            pZtyidoujiyuukbnzfi,
            pZtydatakanrino,
            pZtyrenno,
            pZtytumitatekinkbn
        );
    }

}
