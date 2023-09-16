package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBV_SiharaiTyousyo;
import yuyu.def.db.mapping.GenBV_SiharaiTyousyo;
import yuyu.def.db.meta.GenQBV_SiharaiTyousyo;
import yuyu.def.db.meta.QBV_SiharaiTyousyo;
import jp.co.slcs.swak.date.BizDate;

/**
 * 支払調書ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBV_SiharaiTyousyo} の JavaDoc を参照してください。
 * @see     GenBV_SiharaiTyousyo
 * @see     PKBV_SiharaiTyousyo
 * @see     QBV_SiharaiTyousyo
 * @see     GenQBV_SiharaiTyousyo
 */
@Entity
public class BV_SiharaiTyousyo extends GenBV_SiharaiTyousyo {

    private static final long serialVersionUID = 1L;

    public BV_SiharaiTyousyo() {
    }

    public BV_SiharaiTyousyo(
        String pSubSystemId,
        String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno
    ) {
        super(
            pSubSystemId,
            pSyono,
            pTyouhyouymd,
            pShrtysyrenno
        );
    }

}
