package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_DsKariPasswordTuutiRn;
import yuyu.def.db.mapping.GenZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.GenQZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiRn;

/**
 * 仮パスワード通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DsKariPasswordTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_DsKariPasswordTuutiRn
 * @see     PKZT_DsKariPasswordTuutiRn
 * @see     QZT_DsKariPasswordTuutiRn
 * @see     GenQZT_DsKariPasswordTuutiRn
 */
@Entity
public class ZT_DsKariPasswordTuutiRn extends GenZT_DsKariPasswordTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DsKariPasswordTuutiRn() {
    }

    public ZT_DsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey) {
        super(pZrnkrpasswordtuutikey);
    }

}
