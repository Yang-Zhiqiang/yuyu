package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenKykIdouDetailRn;
import yuyu.def.db.mapping.GenZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.GenQZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailRn;

/**
 * 代理店契約異動明細テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenKykIdouDetailRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenKykIdouDetailRn
 * @see     PKZT_DrtenKykIdouDetailRn
 * @see     QZT_DrtenKykIdouDetailRn
 * @see     GenQZT_DrtenKykIdouDetailRn
 */
@Entity
public class ZT_DrtenKykIdouDetailRn extends GenZT_DrtenKykIdouDetailRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenKykIdouDetailRn() {
    }

    public ZT_DrtenKykIdouDetailRn(
        String pZrnbsydrtencd,
        String pZrnbosyuunincd,
        String pZrnsyono,
        String pZrnidouhasseiymd,
        String pZrnidoukbn
    ) {
        super(
            pZrnbsydrtencd,
            pZrnbosyuunincd,
            pZrnsyono,
            pZrnidouhasseiymd,
            pZrnidoukbn
        );
    }

}
