package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu1Param;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.mapping.GenZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu1Ty;

/**
 * ＳＰ２連動用総成立Fテーブル１（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Sp2RnduyuSouseiritu1Ty} の JavaDoc を参照してください。
 * @see     GenZT_Sp2RnduyuSouseiritu1Ty
 * @see     PKZT_Sp2RnduyuSouseiritu1Ty
 * @see     QZT_Sp2RnduyuSouseiritu1Ty
 * @see     GenQZT_Sp2RnduyuSouseiritu1Ty
 */
@Entity
public class ZT_Sp2RnduyuSouseiritu1Ty extends GenZT_Sp2RnduyuSouseiritu1Ty {

    private static final long serialVersionUID = 1L;

    public ZT_Sp2RnduyuSouseiritu1Ty() {
    }

    public ZT_Sp2RnduyuSouseiritu1Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
