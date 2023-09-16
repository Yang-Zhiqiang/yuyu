package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.mapping.GenZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.GenQZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFRn;

/**
 * 継続率連絡データＵＬＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KeizokurituRenrakuULFRn} の JavaDoc を参照してください。
 * @see     GenZT_KeizokurituRenrakuULFRn
 * @see     PKZT_KeizokurituRenrakuULFRn
 * @see     QZT_KeizokurituRenrakuULFRn
 * @see     GenQZT_KeizokurituRenrakuULFRn
 */
@Entity
public class ZT_KeizokurituRenrakuULFRn extends GenZT_KeizokurituRenrakuULFRn {

    private static final long serialVersionUID = 1L;

    public ZT_KeizokurituRenrakuULFRn() {
    }

    public ZT_KeizokurituRenrakuULFRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
