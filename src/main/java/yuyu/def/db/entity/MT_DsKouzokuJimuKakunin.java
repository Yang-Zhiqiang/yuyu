package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMT_DsKouzokuJimuKakunin;
import yuyu.def.db.mapping.GenMT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.GenQMT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.QMT_DsKouzokuJimuKakunin;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;

/**
 * ＤＳ後続事務確認テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsKouzokuJimuKakunin} の JavaDoc を参照してください。
 * @see     GenMT_DsKouzokuJimuKakunin
 * @see     PKMT_DsKouzokuJimuKakunin
 * @see     QMT_DsKouzokuJimuKakunin
 * @see     GenQMT_DsKouzokuJimuKakunin
 */
@Entity
public class MT_DsKouzokuJimuKakunin extends GenMT_DsKouzokuJimuKakunin {

    private static final long serialVersionUID = 1L;

    public MT_DsKouzokuJimuKakunin() {
    }

    public MT_DsKouzokuJimuKakunin(
        BizDate pHasseiymd,
        C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn,
        String pSyono
    ) {
        super(
            pHasseiymd,
            pDskzkjmkknhsjykbn,
            pSyono
        );
    }

}
