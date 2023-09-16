package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KsnRayJigyohiRn;
import yuyu.def.db.mapping.GenZT_KsnRayJigyohiRn;
import yuyu.def.db.meta.GenQZT_KsnRayJigyohiRn;
import yuyu.def.db.meta.QZT_KsnRayJigyohiRn;

/**
 * 決算計上用ＲＡＹ事業費Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KsnRayJigyohiRn} の JavaDoc を参照してください。
 * @see     GenZT_KsnRayJigyohiRn
 * @see     PKZT_KsnRayJigyohiRn
 * @see     QZT_KsnRayJigyohiRn
 * @see     GenQZT_KsnRayJigyohiRn
 */
@Entity
public class ZT_KsnRayJigyohiRn extends GenZT_KsnRayJigyohiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KsnRayJigyohiRn() {
    }

    public ZT_KsnRayJigyohiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
