package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.mapping.GenZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.GenQZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoTy;

/**
 * 迅速支払手続情報テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_JinsokuShrTtdkInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_JinsokuShrTtdkInfoTy
 * @see     PKZT_JinsokuShrTtdkInfoTy
 * @see     QZT_JinsokuShrTtdkInfoTy
 * @see     GenQZT_JinsokuShrTtdkInfoTy
 */
@Entity
public class ZT_JinsokuShrTtdkInfoTy extends GenZT_JinsokuShrTtdkInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_JinsokuShrTtdkInfoTy() {
    }

    public ZT_JinsokuShrTtdkInfoTy(
        String pZtysyorisosikicd,
        String pZtysyoricd,
        String pZtyhknknshrsntkno,
        String pZtysyoruiukeymd,
        String pZtysyoriymd,
        String pZtydenymd,
        String pZtysyono
    ) {
        super(
            pZtysyorisosikicd,
            pZtysyoricd,
            pZtyhknknshrsntkno,
            pZtysyoruiukeymd,
            pZtysyoriymd,
            pZtydenymd,
            pZtysyono
        );
    }

}
