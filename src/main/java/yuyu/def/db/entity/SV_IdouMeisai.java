package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKSV_IdouMeisai;
import yuyu.def.db.mapping.GenSV_IdouMeisai;
import yuyu.def.db.meta.GenQSV_IdouMeisai;
import yuyu.def.db.meta.QSV_IdouMeisai;

/**
 * 異動明細情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_IdouMeisai} の JavaDoc を参照してください。
 * @see     GenSV_IdouMeisai
 * @see     PKSV_IdouMeisai
 * @see     QSV_IdouMeisai
 * @see     GenQSV_IdouMeisai
 */
@Entity
public class SV_IdouMeisai extends GenSV_IdouMeisai {

    private static final long serialVersionUID = 1L;

    public SV_IdouMeisai() {
    }

    public SV_IdouMeisai(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        super(
            pSyono,
            pGyoumuKousinKinou,
            pGyoumuKousinTime
        );
    }

}
