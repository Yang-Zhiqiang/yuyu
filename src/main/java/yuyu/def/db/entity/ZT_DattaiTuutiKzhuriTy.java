package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.mapping.GenZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.meta.GenQZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriTy;

/**
 * 脱退通知（口座振替）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DattaiTuutiKzhuriTy} の JavaDoc を参照してください。
 * @see     GenZT_DattaiTuutiKzhuriTy
 * @see     PKZT_DattaiTuutiKzhuriTy
 * @see     QZT_DattaiTuutiKzhuriTy
 * @see     GenQZT_DattaiTuutiKzhuriTy
 */
@Entity
public class ZT_DattaiTuutiKzhuriTy extends GenZT_DattaiTuutiKzhuriTy {

    private static final long serialVersionUID = 1L;

    public ZT_DattaiTuutiKzhuriTy() {
    }

    public ZT_DattaiTuutiKzhuriTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
