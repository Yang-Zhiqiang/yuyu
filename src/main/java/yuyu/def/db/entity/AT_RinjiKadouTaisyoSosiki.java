package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.mapping.GenAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.GenQAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.QAT_RinjiKadouTaisyoSosiki;

/**
 * 臨時稼働対象組織テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_RinjiKadouTaisyoSosiki} の JavaDoc を参照してください。
 * @see     GenAT_RinjiKadouTaisyoSosiki
 * @see     PKAT_RinjiKadouTaisyoSosiki
 * @see     QAT_RinjiKadouTaisyoSosiki
 * @see     GenQAT_RinjiKadouTaisyoSosiki
 */
@Entity
public class AT_RinjiKadouTaisyoSosiki extends GenAT_RinjiKadouTaisyoSosiki {

    private static final long serialVersionUID = 1L;

    public AT_RinjiKadouTaisyoSosiki() {
    }

    public AT_RinjiKadouTaisyoSosiki(String pKadouSosikiCd) {
        super(pKadouSosikiCd);
    }

}
