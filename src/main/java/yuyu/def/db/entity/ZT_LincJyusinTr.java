package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_LincJyusinTr;
import yuyu.def.db.mapping.GenZT_LincJyusinTr;
import yuyu.def.db.meta.GenQZT_LincJyusinTr;
import yuyu.def.db.meta.QZT_LincJyusinTr;

/**
 * ＬＩＮＣ受信内容反映テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_LincJyusinTr} の JavaDoc を参照してください。
 * @see     GenZT_LincJyusinTr
 * @see     PKZT_LincJyusinTr
 * @see     QZT_LincJyusinTr
 * @see     GenQZT_LincJyusinTr
 */
@Entity
public class ZT_LincJyusinTr extends GenZT_LincJyusinTr {

    private static final long serialVersionUID = 1L;

    public ZT_LincJyusinTr() {
    }

    public ZT_LincJyusinTr(String pZtrsyoriymd, String pZtrrenno10) {
        super(pZtrsyoriymd, pZtrrenno10);
    }

}
