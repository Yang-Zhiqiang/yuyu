package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KessanZennouFTy;
import yuyu.def.db.mapping.GenZT_KessanZennouFTy;
import yuyu.def.db.meta.GenQZT_KessanZennouFTy;
import yuyu.def.db.meta.QZT_KessanZennouFTy;

/**
 * 決算用前納Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KessanZennouFTy} の JavaDoc を参照してください。
 * @see     GenZT_KessanZennouFTy
 * @see     PKZT_KessanZennouFTy
 * @see     QZT_KessanZennouFTy
 * @see     GenQZT_KessanZennouFTy
 */
@Entity
public class ZT_KessanZennouFTy extends GenZT_KessanZennouFTy {

    private static final long serialVersionUID = 1L;

    public ZT_KessanZennouFTy() {
    }

    public ZT_KessanZennouFTy(
        String pZtysyono,
        String pZtykbnkeiriyousegmentcd,
        String pZtyzennoutoukeilistkbn,
        String pZtyzennoukbn
    ) {
        super(
            pZtysyono,
            pZtykbnkeiriyousegmentcd,
            pZtyzennoutoukeilistkbn,
            pZtyzennoukbn
        );
    }

}
