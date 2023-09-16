package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.mapping.GenZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.meta.GenQZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriRn;

/**
 * 脱退通知（口座振替）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DattaiTuutiKzhuriRn} の JavaDoc を参照してください。
 * @see     GenZT_DattaiTuutiKzhuriRn
 * @see     PKZT_DattaiTuutiKzhuriRn
 * @see     QZT_DattaiTuutiKzhuriRn
 * @see     GenQZT_DattaiTuutiKzhuriRn
 */
@Entity
public class ZT_DattaiTuutiKzhuriRn extends GenZT_DattaiTuutiKzhuriRn {

    private static final long serialVersionUID = 1L;

    public ZT_DattaiTuutiKzhuriRn() {
    }

    public ZT_DattaiTuutiKzhuriRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
