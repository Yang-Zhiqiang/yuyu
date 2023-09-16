package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_DsKariPasswordTuutiTy;
import yuyu.def.db.mapping.GenZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.GenQZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiTy;

/**
 * 仮パスワード通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DsKariPasswordTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_DsKariPasswordTuutiTy
 * @see     PKZT_DsKariPasswordTuutiTy
 * @see     QZT_DsKariPasswordTuutiTy
 * @see     GenQZT_DsKariPasswordTuutiTy
 */
@Entity
public class ZT_DsKariPasswordTuutiTy extends GenZT_DsKariPasswordTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DsKariPasswordTuutiTy() {
    }

    public ZT_DsKariPasswordTuutiTy(String pZtykrpasswordtuutikey) {
        super(pZtykrpasswordtuutikey);
    }

}
