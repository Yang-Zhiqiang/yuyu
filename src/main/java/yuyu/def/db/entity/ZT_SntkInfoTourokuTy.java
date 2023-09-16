package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SntkInfoTourokuTy;
import yuyu.def.db.mapping.GenZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.GenQZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.QZT_SntkInfoTourokuTy;

/**
 * 選択情報登録テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SntkInfoTourokuTy} の JavaDoc を参照してください。
 * @see     GenZT_SntkInfoTourokuTy
 * @see     PKZT_SntkInfoTourokuTy
 * @see     QZT_SntkInfoTourokuTy
 * @see     GenQZT_SntkInfoTourokuTy
 */
@Entity
public class ZT_SntkInfoTourokuTy extends GenZT_SntkInfoTourokuTy {

    private static final long serialVersionUID = 1L;

    public ZT_SntkInfoTourokuTy() {
    }

    public ZT_SntkInfoTourokuTy(
        String pZtysntkinfono,
        String pZtyrenno,
        String pZtysntkinfotourokusyskbn
        ) {
        super(
            pZtysntkinfono,
            pZtyrenno,
            pZtysntkinfotourokusyskbn
            );
    }

}
