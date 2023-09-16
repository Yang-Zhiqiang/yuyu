package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenIpToukeiTy;
import yuyu.def.db.mapping.GenZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.GenQZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.QZT_DrtenIpToukeiTy;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenIpToukeiTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenIpToukeiTy
 * @see     PKZT_DrtenIpToukeiTy
 * @see     QZT_DrtenIpToukeiTy
 * @see     GenQZT_DrtenIpToukeiTy
 */
@Entity
public class ZT_DrtenIpToukeiTy extends GenZT_DrtenIpToukeiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenIpToukeiTy() {
    }

    public ZT_DrtenIpToukeiTy(
        String pZtyeigyouhonbusisyacd,
        String pZtysosikicd,
        String pZtyatukaikojincd,
        String pZtymosym,
        String pZtymosno
    ) {
        super(
            pZtyeigyouhonbusisyacd,
            pZtysosikicd,
            pZtyatukaikojincd,
            pZtymosym,
            pZtymosno
        );
    }

}
