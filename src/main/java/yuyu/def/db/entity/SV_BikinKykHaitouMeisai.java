package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKSV_BikinKykHaitouMeisai;
import yuyu.def.db.mapping.GenSV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.GenQSV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.QSV_BikinKykHaitouMeisai;

/**
 * 備金契約配当明細情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_BikinKykHaitouMeisai} の JavaDoc を参照してください。
 * @see     GenSV_BikinKykHaitouMeisai
 * @see     PKSV_BikinKykHaitouMeisai
 * @see     QSV_BikinKykHaitouMeisai
 * @see     GenQSV_BikinKykHaitouMeisai
 */
@Entity
public class SV_BikinKykHaitouMeisai extends GenSV_BikinKykHaitouMeisai {

    private static final long serialVersionUID = 1L;

    public SV_BikinKykHaitouMeisai() {
    }

    public SV_BikinKykHaitouMeisai(
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
