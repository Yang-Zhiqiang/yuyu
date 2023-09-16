package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_BknkykHtjynbkn;
import yuyu.def.db.mapping.GenST_BknkykHtjynbkn;
import yuyu.def.db.meta.GenQST_BknkykHtjynbkn;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 備金契約配当準備金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_BknkykHtjynbkn} の JavaDoc を参照してください。
 * @see     GenST_BknkykHtjynbkn
 * @see     PKST_BknkykHtjynbkn
 * @see     QST_BknkykHtjynbkn
 * @see     GenQST_BknkykHtjynbkn
 */
@Entity
public class ST_BknkykHtjynbkn extends GenST_BknkykHtjynbkn {

    private static final long serialVersionUID = 1L;

    public ST_BknkykHtjynbkn() {
    }

    public ST_BknkykHtjynbkn(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        super(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pSrkijyunym
        );
    }

}
