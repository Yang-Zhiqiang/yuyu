package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayKimatuVRn;
import yuyu.def.db.mapping.GenZT_RayKimatuVRn;
import yuyu.def.db.meta.GenQZT_RayKimatuVRn;
import yuyu.def.db.meta.QZT_RayKimatuVRn;

/**
 * ＲＡＹ期末ＶＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayKimatuVRn} の JavaDoc を参照してください。
 * @see     GenZT_RayKimatuVRn
 * @see     PKZT_RayKimatuVRn
 * @see     QZT_RayKimatuVRn
 * @see     GenQZT_RayKimatuVRn
 */
@Entity
public class ZT_RayKimatuVRn extends GenZT_RayKimatuVRn {

    private static final long serialVersionUID = 1L;

    public ZT_RayKimatuVRn() {
    }

    public ZT_RayKimatuVRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
