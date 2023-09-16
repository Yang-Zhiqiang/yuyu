package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.mapping.GenZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.GenQZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiTy;

/**
 * ＤＳ汎用顧客宛通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DsHanyouKokyakuTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_DsHanyouKokyakuTuutiTy
 * @see     PKZT_DsHanyouKokyakuTuutiTy
 * @see     QZT_DsHanyouKokyakuTuutiTy
 * @see     GenQZT_DsHanyouKokyakuTuutiTy
 */
@Entity
public class ZT_DsHanyouKokyakuTuutiTy extends GenZT_DsHanyouKokyakuTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DsHanyouKokyakuTuutiTy() {
    }

    public ZT_DsHanyouKokyakuTuutiTy(
        String pZtydshanyoukokatetuutikey,
        String pZtydskokno,
        String pZtydstuutikbn
    ) {
        super(
            pZtydshanyoukokatetuutikey,
            pZtydskokno,
            pZtydstuutikbn
        );
    }

}
