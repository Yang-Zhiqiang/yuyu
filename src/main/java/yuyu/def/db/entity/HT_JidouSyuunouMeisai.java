package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_JidouSyuunouMeisai;
import yuyu.def.db.mapping.GenHT_JidouSyuunouMeisai;
import yuyu.def.db.meta.GenQHT_JidouSyuunouMeisai;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 自動収納照合明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_JidouSyuunouMeisai} の JavaDoc を参照してください。
 * @see     GenHT_JidouSyuunouMeisai
 * @see     PKHT_JidouSyuunouMeisai
 * @see     QHT_JidouSyuunouMeisai
 * @see     GenQHT_JidouSyuunouMeisai
 */
@Entity
public class HT_JidouSyuunouMeisai extends GenHT_JidouSyuunouMeisai {

    private static final long serialVersionUID = 1L;

    public HT_JidouSyuunouMeisai() {
    }

    public HT_JidouSyuunouMeisai(
        BizDate pSyoriYmd,
        C_KessanKbn pKessankbn,
        C_Tuukasyu pRstuukasyu
    ) {
        super(
            pSyoriYmd,
            pKessankbn,
            pRstuukasyu
        );
    }

}
