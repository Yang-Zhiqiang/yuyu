package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_KhIdouTyousyo;
import yuyu.def.db.mapping.GenIT_KhIdouTyousyo;
import yuyu.def.db.meta.GenQIT_KhIdouTyousyo;
import yuyu.def.db.meta.QIT_KhIdouTyousyo;
import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全異動調書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhIdouTyousyo} の JavaDoc を参照してください。
 * @see     GenIT_KhIdouTyousyo
 * @see     PKIT_KhIdouTyousyo
 * @see     QIT_KhIdouTyousyo
 * @see     GenQIT_KhIdouTyousyo
 */
@Entity
public class IT_KhIdouTyousyo extends GenIT_KhIdouTyousyo {

    private static final long serialVersionUID = 1L;

    public IT_KhIdouTyousyo() {
    }

    public IT_KhIdouTyousyo(
        String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno
    ) {
        super(
            pSyono,
            pTyouhyouymd,
            pShrtysyrenno
        );
    }

}
