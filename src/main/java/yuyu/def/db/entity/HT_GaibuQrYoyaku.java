package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.mapping.GenHT_GaibuQrYoyaku;


/**
 * 外部用ＱＲ予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_GaibuQrYoyaku} の JavaDoc を参照してください。<br />
 * @see     GenHT_GaibuQrYoyaku<br />
 * @see     PKHT_GaibuQrYoyaku<br />
 * @see     QHT_GaibuQrYoyaku<br />
 * @see     GenQHT_GaibuQrYoyaku<br />
 */
@Entity
public class HT_GaibuQrYoyaku extends GenHT_GaibuQrYoyaku {

    private static final long serialVersionUID = 1L;

    public HT_GaibuQrYoyaku() {
    }

    public HT_GaibuQrYoyaku(BizDate pSyoriYmd,C_SkeijimuKbn pSkeijimukbn,C_HknsyuruiNo pHknsyuruino) {
        super(pSyoriYmd,pSkeijimukbn,pHknsyuruino);
    }



}

