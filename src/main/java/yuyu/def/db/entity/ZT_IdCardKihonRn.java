package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_IdCardKihonRn;
import yuyu.def.db.mapping.GenZT_IdCardKihonRn;
import yuyu.def.db.meta.GenQZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;

/**
 * ＩＤカードＦ基本テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IdCardKihonRn} の JavaDoc を参照してください。
 * @see     GenZT_IdCardKihonRn
 * @see     PKZT_IdCardKihonRn
 * @see     QZT_IdCardKihonRn
 * @see     GenQZT_IdCardKihonRn
 */
@Entity
public class ZT_IdCardKihonRn extends GenZT_IdCardKihonRn {

    private static final long serialVersionUID = 1L;

    public ZT_IdCardKihonRn() {
    }

    public ZT_IdCardKihonRn(String pZrnidkbn, String pZrnidcd) {
        super(pZrnidkbn, pZrnidcd);
    }

}
