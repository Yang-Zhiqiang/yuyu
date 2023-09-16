package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.mapping.GenBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.GenQBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.QBT_KijituTouraiHonbanKensyou;
import jp.co.slcs.swak.date.BizDate;

/**
 * 期日到来本番検証用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KijituTouraiHonbanKensyou} の JavaDoc を参照してください。
 * @see     GenBT_KijituTouraiHonbanKensyou
 * @see     PKBT_KijituTouraiHonbanKensyou
 * @see     QBT_KijituTouraiHonbanKensyou
 * @see     GenQBT_KijituTouraiHonbanKensyou
 */
@Entity
public class BT_KijituTouraiHonbanKensyou extends GenBT_KijituTouraiHonbanKensyou {

    private static final long serialVersionUID = 1L;

    public BT_KijituTouraiHonbanKensyou() {
    }

    public BT_KijituTouraiHonbanKensyou(
        BizDate pSyoriYmd,
        String pSubSystemId,
        Integer pTysytno,
        String pDatakanrino
    ) {
        super(
            pSyoriYmd,
            pSubSystemId,
            pTysytno,
            pDatakanrino
        );
    }

}
