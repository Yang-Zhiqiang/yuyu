package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KessanZennouFRn;
import yuyu.def.db.mapping.GenZT_KessanZennouFRn;
import yuyu.def.db.meta.GenQZT_KessanZennouFRn;
import yuyu.def.db.meta.QZT_KessanZennouFRn;

/**
 * 決算用前納Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KessanZennouFRn} の JavaDoc を参照してください。
 * @see     GenZT_KessanZennouFRn
 * @see     PKZT_KessanZennouFRn
 * @see     QZT_KessanZennouFRn
 * @see     GenQZT_KessanZennouFRn
 */
@Entity
public class ZT_KessanZennouFRn extends GenZT_KessanZennouFRn {

    private static final long serialVersionUID = 1L;

    public ZT_KessanZennouFRn() {
    }

    public ZT_KessanZennouFRn(
        String pZrnsyono,
        String pZrnkbnkeiriyousegmentcd,
        String pZrnzennoutoukeilistkbn,
        String pZrnzennoukbn
    ) {
        super(
            pZrnsyono,
            pZrnkbnkeiriyousegmentcd,
            pZrnzennoutoukeilistkbn,
            pZrnzennoukbn
        );
    }

}
