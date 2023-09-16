package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DirectMailDataTy;
import yuyu.def.db.mapping.GenZT_DirectMailDataTy;
import yuyu.def.db.meta.GenQZT_DirectMailDataTy;
import yuyu.def.db.meta.QZT_DirectMailDataTy;

/**
 * ダイレクトメールデータテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DirectMailDataTy} の JavaDoc を参照してください。
 * @see     GenZT_DirectMailDataTy
 * @see     PKZT_DirectMailDataTy
 * @see     QZT_DirectMailDataTy
 * @see     GenQZT_DirectMailDataTy
 */
@Entity
public class ZT_DirectMailDataTy extends GenZT_DirectMailDataTy {

    private static final long serialVersionUID = 1L;

    public ZT_DirectMailDataTy() {
    }

    public ZT_DirectMailDataTy(String pZtysyono) {
        super(pZtysyono);
    }

}
