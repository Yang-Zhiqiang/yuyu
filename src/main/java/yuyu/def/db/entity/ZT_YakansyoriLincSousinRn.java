package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YakansyoriLincSousinRn;
import yuyu.def.db.mapping.GenZT_YakansyoriLincSousinRn;
import yuyu.def.db.meta.GenQZT_YakansyoriLincSousinRn;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinRn;

/**
 * 夜間処理ＬＩＮＣ送信ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YakansyoriLincSousinRn} の JavaDoc を参照してください。
 * @see     GenZT_YakansyoriLincSousinRn
 * @see     PKZT_YakansyoriLincSousinRn
 * @see     QZT_YakansyoriLincSousinRn
 * @see     GenQZT_YakansyoriLincSousinRn
 */
@Entity
public class ZT_YakansyoriLincSousinRn extends GenZT_YakansyoriLincSousinRn {

    private static final long serialVersionUID = 1L;

    public ZT_YakansyoriLincSousinRn() {
    }

    public ZT_YakansyoriLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        super(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }

}
