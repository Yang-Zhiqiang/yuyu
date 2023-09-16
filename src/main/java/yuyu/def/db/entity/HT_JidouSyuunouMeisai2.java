package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_JidouSyuunouMeisai2;
import yuyu.def.db.mapping.GenHT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.GenQHT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai2;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_NyktyhyoutKbn;

/**
 * 自動収納照合明細テーブル２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_JidouSyuunouMeisai2} の JavaDoc を参照してください。
 * @see     GenHT_JidouSyuunouMeisai2
 * @see     PKHT_JidouSyuunouMeisai2
 * @see     QHT_JidouSyuunouMeisai2
 * @see     GenQHT_JidouSyuunouMeisai2
 */
@Entity
public class HT_JidouSyuunouMeisai2 extends GenHT_JidouSyuunouMeisai2 {

    private static final long serialVersionUID = 1L;

    public HT_JidouSyuunouMeisai2() {
    }

    public HT_JidouSyuunouMeisai2(
        BizDate pSyoriYmd,
        C_KessanKbn pKessankbn,
        C_Tuukasyu pRstuukasyu,
        C_NyktyhyoutKbn pNyktyhyoutkbn
    ) {
        super(
            pSyoriYmd,
            pKessankbn,
            pRstuukasyu,
            pNyktyhyoutkbn
        );
    }

}
