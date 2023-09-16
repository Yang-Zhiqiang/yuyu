package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.mapping.GenIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.GenQIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.QIT_KhTRAuthoriKekkaHihoji;
import jp.co.slcs.swak.date.BizDate;

/**
 * オーソリ結果ＴＲ（クレカ非保持）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhTRAuthoriKekkaHihoji} の JavaDoc を参照してください。
 * @see     GenIT_KhTRAuthoriKekkaHihoji
 * @see     PKIT_KhTRAuthoriKekkaHihoji
 * @see     QIT_KhTRAuthoriKekkaHihoji
 * @see     GenQIT_KhTRAuthoriKekkaHihoji
 */
@Entity
public class IT_KhTRAuthoriKekkaHihoji extends GenIT_KhTRAuthoriKekkaHihoji {

    private static final long serialVersionUID = 1L;

    public IT_KhTRAuthoriKekkaHihoji() {
    }

    public IT_KhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd) {
        super(pCreditkessaiyouno, pSyoriYmd);
    }

}
