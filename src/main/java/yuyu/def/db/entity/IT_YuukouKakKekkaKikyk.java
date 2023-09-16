package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_YuukouKakKekkaKikyk;
import yuyu.def.db.mapping.GenIT_YuukouKakKekkaKikyk;
import yuyu.def.db.meta.GenQIT_YuukouKakKekkaKikyk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaKikyk;

/**
 * 有効性確認結果（既契約）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YuukouKakKekkaKikyk} の JavaDoc を参照してください。
 * @see     GenIT_YuukouKakKekkaKikyk
 * @see     PKIT_YuukouKakKekkaKikyk
 * @see     QIT_YuukouKakKekkaKikyk
 * @see     GenQIT_YuukouKakKekkaKikyk
 */
@Entity
public class IT_YuukouKakKekkaKikyk extends GenIT_YuukouKakKekkaKikyk {

    private static final long serialVersionUID = 1L;

    public IT_YuukouKakKekkaKikyk() {
    }

    public IT_YuukouKakKekkaKikyk(String pCreditkessaiyouno) {
        super(pCreditkessaiyouno);
    }

}
