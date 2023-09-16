package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_LincJyusinRn;
import yuyu.def.db.mapping.GenZT_LincJyusinRn;
import yuyu.def.db.meta.GenQZT_LincJyusinRn;
import yuyu.def.db.meta.QZT_LincJyusinRn;

/**
 * ＬＩＮＣ受信内容反映テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_LincJyusinRn} の JavaDoc を参照してください。
 * @see     GenZT_LincJyusinRn
 * @see     PKZT_LincJyusinRn
 * @see     QZT_LincJyusinRn
 * @see     GenQZT_LincJyusinRn
 */
@Entity
public class ZT_LincJyusinRn extends GenZT_LincJyusinRn {

    private static final long serialVersionUID = 1L;

    public ZT_LincJyusinRn() {
    }

    public ZT_LincJyusinRn(String pZrnsyoriymd, String pZrnrenno10) {
        super(pZrnsyoriymd, pZrnrenno10);
    }

}
