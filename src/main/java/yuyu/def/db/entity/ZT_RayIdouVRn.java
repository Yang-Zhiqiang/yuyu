package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayIdouVRn;
import yuyu.def.db.mapping.GenZT_RayIdouVRn;
import yuyu.def.db.meta.GenQZT_RayIdouVRn;
import yuyu.def.db.meta.QZT_RayIdouVRn;

/**
 * ＲＡＹ異動ＶＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayIdouVRn} の JavaDoc を参照してください。
 * @see     GenZT_RayIdouVRn
 * @see     PKZT_RayIdouVRn
 * @see     QZT_RayIdouVRn
 * @see     GenQZT_RayIdouVRn
 */
@Entity
public class ZT_RayIdouVRn extends GenZT_RayIdouVRn {

    private static final long serialVersionUID = 1L;

    public ZT_RayIdouVRn() {
    }

    public ZT_RayIdouVRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
