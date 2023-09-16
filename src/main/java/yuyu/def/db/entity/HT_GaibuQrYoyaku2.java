package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_GaibuQrYoyaku2;
import yuyu.def.db.mapping.GenHT_GaibuQrYoyaku2;
import yuyu.def.db.meta.GenQHT_GaibuQrYoyaku2;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku2;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosnoSaibanKbn;

/**
 * 外部用ＱＲ予約テーブル２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_GaibuQrYoyaku2} の JavaDoc を参照してください。
 * @see     GenHT_GaibuQrYoyaku2
 * @see     PKHT_GaibuQrYoyaku2
 * @see     QHT_GaibuQrYoyaku2
 * @see     GenQHT_GaibuQrYoyaku2
 */
@Entity
public class HT_GaibuQrYoyaku2 extends GenHT_GaibuQrYoyaku2 {

    private static final long serialVersionUID = 1L;

    public HT_GaibuQrYoyaku2() {
    }

    public HT_GaibuQrYoyaku2(
        BizDate pSyoriYmd,
        C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino,
        C_MosnoSaibanKbn pMosnosaibankbn
    ) {
        super(
            pSyoriYmd,
            pSkeijimukbn,
            pHknsyuruino,
            pMosnosaibankbn
        );
    }

}
