package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_AiKyuubuByoumeiRn;
import yuyu.def.db.mapping.GenZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.GenQZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.QZT_AiKyuubuByoumeiRn;

/**
 * あいキューブ病名マスタ送信データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_AiKyuubuByoumeiRn} の JavaDoc を参照してください。
 * @see     GenZT_AiKyuubuByoumeiRn
 * @see     PKZT_AiKyuubuByoumeiRn
 * @see     QZT_AiKyuubuByoumeiRn
 * @see     GenQZT_AiKyuubuByoumeiRn
 */
@Entity
public class ZT_AiKyuubuByoumeiRn extends GenZT_AiKyuubuByoumeiRn {

    private static final long serialVersionUID = 1L;

    public ZT_AiKyuubuByoumeiRn() {
    }

    public ZT_AiKyuubuByoumeiRn(String pZrnbyoumeitourokuno) {
        super(pZrnbyoumeitourokuno);
    }

}
