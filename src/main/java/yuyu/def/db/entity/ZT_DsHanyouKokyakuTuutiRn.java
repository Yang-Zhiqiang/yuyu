package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.mapping.GenZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.GenQZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiRn;

/**
 * ＤＳ汎用顧客宛通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DsHanyouKokyakuTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_DsHanyouKokyakuTuutiRn
 * @see     PKZT_DsHanyouKokyakuTuutiRn
 * @see     QZT_DsHanyouKokyakuTuutiRn
 * @see     GenQZT_DsHanyouKokyakuTuutiRn
 */
@Entity
public class ZT_DsHanyouKokyakuTuutiRn extends GenZT_DsHanyouKokyakuTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DsHanyouKokyakuTuutiRn() {
    }

    public ZT_DsHanyouKokyakuTuutiRn(
        String pZrndshanyoukokatetuutikey,
        String pZrndskokno,
        String pZrndstuutikbn
    ) {
        super(
            pZrndshanyoukokatetuutikey,
            pZrndskokno,
            pZrndstuutikbn
        );
    }

}
