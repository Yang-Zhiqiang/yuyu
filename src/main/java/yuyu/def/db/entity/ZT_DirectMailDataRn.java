package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DirectMailDataRn;
import yuyu.def.db.mapping.GenZT_DirectMailDataRn;
import yuyu.def.db.meta.GenQZT_DirectMailDataRn;
import yuyu.def.db.meta.QZT_DirectMailDataRn;

/**
 * ダイレクトメールデータテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DirectMailDataRn} の JavaDoc を参照してください。
 * @see     GenZT_DirectMailDataRn
 * @see     PKZT_DirectMailDataRn
 * @see     QZT_DirectMailDataRn
 * @see     GenQZT_DirectMailDataRn
 */
@Entity
public class ZT_DirectMailDataRn extends GenZT_DirectMailDataRn {

    private static final long serialVersionUID = 1L;

    public ZT_DirectMailDataRn() {
    }

    public ZT_DirectMailDataRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
