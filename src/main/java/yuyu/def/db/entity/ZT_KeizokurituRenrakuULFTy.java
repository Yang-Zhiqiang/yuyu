package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.mapping.GenZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.GenQZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFTy;

/**
 * 継続率連絡データＵＬＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KeizokurituRenrakuULFTy} の JavaDoc を参照してください。
 * @see     GenZT_KeizokurituRenrakuULFTy
 * @see     PKZT_KeizokurituRenrakuULFTy
 * @see     QZT_KeizokurituRenrakuULFTy
 * @see     GenQZT_KeizokurituRenrakuULFTy
 */
@Entity
public class ZT_KeizokurituRenrakuULFTy extends GenZT_KeizokurituRenrakuULFTy {

    private static final long serialVersionUID = 1L;

    public ZT_KeizokurituRenrakuULFTy() {
    }

    public ZT_KeizokurituRenrakuULFTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
