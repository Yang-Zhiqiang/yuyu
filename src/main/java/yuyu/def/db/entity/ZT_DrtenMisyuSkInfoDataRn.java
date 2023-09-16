package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.mapping.GenZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.GenQZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataRn;

/**
 * 代理店未収・失効情報連動データＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenMisyuSkInfoDataRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenMisyuSkInfoDataRn
 * @see     PKZT_DrtenMisyuSkInfoDataRn
 * @see     QZT_DrtenMisyuSkInfoDataRn
 * @see     GenQZT_DrtenMisyuSkInfoDataRn
 */
@Entity
public class ZT_DrtenMisyuSkInfoDataRn extends GenZT_DrtenMisyuSkInfoDataRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenMisyuSkInfoDataRn() {
    }

    public ZT_DrtenMisyuSkInfoDataRn(
        String pZrnsyono,
        String pZrnbsydrtencd,
        String pZrnhanteiymd
    ) {
        super(
            pZrnsyono,
            pZrnbsydrtencd,
            pZrnhanteiymd
        );
    }

}
