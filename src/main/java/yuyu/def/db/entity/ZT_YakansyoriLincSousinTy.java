package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YakansyoriLincSousinTy;
import yuyu.def.db.mapping.GenZT_YakansyoriLincSousinTy;
import yuyu.def.db.meta.GenQZT_YakansyoriLincSousinTy;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinTy;

/**
 * 夜間処理ＬＩＮＣ送信ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YakansyoriLincSousinTy} の JavaDoc を参照してください。
 * @see     GenZT_YakansyoriLincSousinTy
 * @see     PKZT_YakansyoriLincSousinTy
 * @see     QZT_YakansyoriLincSousinTy
 * @see     GenQZT_YakansyoriLincSousinTy
 */
@Entity
public class ZT_YakansyoriLincSousinTy extends GenZT_YakansyoriLincSousinTy {

    private static final long serialVersionUID = 1L;

    public ZT_YakansyoriLincSousinTy() {
    }

    public ZT_YakansyoriLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        super(pZtyrecordsyubetukbn, pZtykykkanrino);
    }

}
