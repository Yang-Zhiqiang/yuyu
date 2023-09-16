package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_YuukouKakKekkaSk;
import yuyu.def.db.mapping.GenIT_YuukouKakKekkaSk;
import yuyu.def.db.meta.GenQIT_YuukouKakKekkaSk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaSk;

/**
 * 有効性確認結果（新契約）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YuukouKakKekkaSk} の JavaDoc を参照してください。
 * @see     GenIT_YuukouKakKekkaSk
 * @see     PKIT_YuukouKakKekkaSk
 * @see     QIT_YuukouKakKekkaSk
 * @see     GenQIT_YuukouKakKekkaSk
 */
@Entity
public class IT_YuukouKakKekkaSk extends GenIT_YuukouKakKekkaSk {

    private static final long serialVersionUID = 1L;

    public IT_YuukouKakKekkaSk() {
    }

    public IT_YuukouKakKekkaSk(String pCreditkessaiyouno) {
        super(pCreditkessaiyouno);
    }

}
