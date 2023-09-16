package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayJigyohiRn;
import yuyu.def.db.mapping.GenZT_RayJigyohiRn;
import yuyu.def.db.meta.GenQZT_RayJigyohiRn;
import yuyu.def.db.meta.QZT_RayJigyohiRn;

/**
 * ＲＡＹ事業費Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayJigyohiRn} の JavaDoc を参照してください。
 * @see     GenZT_RayJigyohiRn
 * @see     PKZT_RayJigyohiRn
 * @see     QZT_RayJigyohiRn
 * @see     GenQZT_RayJigyohiRn
 */
@Entity
public class ZT_RayJigyohiRn extends GenZT_RayJigyohiRn {

    private static final long serialVersionUID = 1L;

    public ZT_RayJigyohiRn() {
    }

    public ZT_RayJigyohiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
