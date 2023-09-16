package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKSV_BikinIdouMeisai;
import yuyu.def.db.mapping.GenSV_BikinIdouMeisai;
import yuyu.def.db.meta.GenQSV_BikinIdouMeisai;
import yuyu.def.db.meta.QSV_BikinIdouMeisai;

/**
 * 備金異動明細情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_BikinIdouMeisai} の JavaDoc を参照してください。
 * @see     GenSV_BikinIdouMeisai
 * @see     PKSV_BikinIdouMeisai
 * @see     QSV_BikinIdouMeisai
 * @see     GenQSV_BikinIdouMeisai
 */
@Entity
public class SV_BikinIdouMeisai extends GenSV_BikinIdouMeisai {

    private static final long serialVersionUID = 1L;

    public SV_BikinIdouMeisai() {
    }

    public SV_BikinIdouMeisai(
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
