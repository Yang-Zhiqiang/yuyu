package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.mapping.GenZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.GenQZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataTy;

/**
 * 代理店未収・失効情報連動データＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenMisyuSkInfoDataTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenMisyuSkInfoDataTy
 * @see     PKZT_DrtenMisyuSkInfoDataTy
 * @see     QZT_DrtenMisyuSkInfoDataTy
 * @see     GenQZT_DrtenMisyuSkInfoDataTy
 */
@Entity
public class ZT_DrtenMisyuSkInfoDataTy extends GenZT_DrtenMisyuSkInfoDataTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenMisyuSkInfoDataTy() {
    }

    public ZT_DrtenMisyuSkInfoDataTy(
        String pZtysyono,
        String pZtybsydrtencd,
        String pZtyhanteiymd
    ) {
        super(
            pZtysyono,
            pZtybsydrtencd,
            pZtyhanteiymd
        );
    }

}
