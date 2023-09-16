package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.mapping.GenZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.GenQZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoRn;

/**
 * 迅速支払手続情報テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_JinsokuShrTtdkInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_JinsokuShrTtdkInfoRn
 * @see     PKZT_JinsokuShrTtdkInfoRn
 * @see     QZT_JinsokuShrTtdkInfoRn
 * @see     GenQZT_JinsokuShrTtdkInfoRn
 */
@Entity
public class ZT_JinsokuShrTtdkInfoRn extends GenZT_JinsokuShrTtdkInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_JinsokuShrTtdkInfoRn() {
    }

    public ZT_JinsokuShrTtdkInfoRn(
        String pZrnsyorisosikicd,
        String pZrnsyoricd,
        String pZrnhknknshrsntkno,
        String pZrnsyoruiukeymd,
        String pZrnsyoriymd,
        String pZrndenymd,
        String pZrnsyono
    ) {
        super(
            pZrnsyorisosikicd,
            pZrnsyoricd,
            pZrnhknknshrsntkno,
            pZrnsyoruiukeymd,
            pZrnsyoriymd,
            pZrndenymd,
            pZrnsyono
        );
    }

}
