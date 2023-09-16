package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.mapping.GenZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.GenQZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfRn;

/**
 * 口座振替案内ＵＬＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KzhuriAnnaiUlfRn} の JavaDoc を参照してください。
 * @see     GenZT_KzhuriAnnaiUlfRn
 * @see     PKZT_KzhuriAnnaiUlfRn
 * @see     QZT_KzhuriAnnaiUlfRn
 * @see     GenQZT_KzhuriAnnaiUlfRn
 */
@Entity
public class ZT_KzhuriAnnaiUlfRn extends GenZT_KzhuriAnnaiUlfRn {

    private static final long serialVersionUID = 1L;

    public ZT_KzhuriAnnaiUlfRn() {
    }

    public ZT_KzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym) {
        super(pZrnsyono, pZrnjyuutouym);
    }

}
