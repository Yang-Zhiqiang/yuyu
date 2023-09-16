package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenIpToukeiRn;
import yuyu.def.db.mapping.GenZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.GenQZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.QZT_DrtenIpToukeiRn;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenIpToukeiRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenIpToukeiRn
 * @see     PKZT_DrtenIpToukeiRn
 * @see     QZT_DrtenIpToukeiRn
 * @see     GenQZT_DrtenIpToukeiRn
 */
@Entity
public class ZT_DrtenIpToukeiRn extends GenZT_DrtenIpToukeiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenIpToukeiRn() {
    }

    public ZT_DrtenIpToukeiRn(
        String pZrneigyouhonbusisyacd,
        String pZrnsosikicd,
        String pZrnatukaikojincd,
        String pZrnmosym,
        String pZrnmosno
    ) {
        super(
            pZrneigyouhonbusisyacd,
            pZrnsosikicd,
            pZrnatukaikojincd,
            pZrnmosym,
            pZrnmosno
        );
    }

}
