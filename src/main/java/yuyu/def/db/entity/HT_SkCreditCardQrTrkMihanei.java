package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.mapping.GenHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.GenQHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.QHT_SkCreditCardQrTrkMihanei;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約クレジットカードＱＲ登録結果未反映テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkCreditCardQrTrkMihanei} の JavaDoc を参照してください。
 * @see     GenHT_SkCreditCardQrTrkMihanei
 * @see     PKHT_SkCreditCardQrTrkMihanei
 * @see     QHT_SkCreditCardQrTrkMihanei
 * @see     GenQHT_SkCreditCardQrTrkMihanei
 */
@Entity
public class HT_SkCreditCardQrTrkMihanei extends GenHT_SkCreditCardQrTrkMihanei {

    private static final long serialVersionUID = 1L;

    public HT_SkCreditCardQrTrkMihanei() {
    }

    public HT_SkCreditCardQrTrkMihanei(
        BizDate pSyoriYmd,
        BizDate pSystemjyusinymd,
        String pSystemjyusintime,
        String pCreditkessaiyouno
    ) {
        super(
            pSyoriYmd,
            pSystemjyusinymd,
            pSystemjyusintime,
            pCreditkessaiyouno
        );
    }

}
