package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_IdCardYakusyokuRn;
import yuyu.def.db.mapping.GenZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.GenQZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.QZT_IdCardYakusyokuRn;

/**
 * ＩＤカードＦ役職テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IdCardYakusyokuRn} の JavaDoc を参照してください。
 * @see     GenZT_IdCardYakusyokuRn
 * @see     PKZT_IdCardYakusyokuRn
 * @see     QZT_IdCardYakusyokuRn
 * @see     GenQZT_IdCardYakusyokuRn
 */
@Entity
public class ZT_IdCardYakusyokuRn extends GenZT_IdCardYakusyokuRn {

    private static final long serialVersionUID = 1L;

    public ZT_IdCardYakusyokuRn() {
    }

    public ZT_IdCardYakusyokuRn(
        String pZrnidkbn,
        String pZrnidcd,
        String pZrnyakusyokuhatureiymd,
        String pZrnyakusyokuhatureino
    ) {
        super(
            pZrnidkbn,
            pZrnidcd,
            pZrnyakusyokuhatureiymd,
            pZrnyakusyokuhatureino
        );
    }

}
