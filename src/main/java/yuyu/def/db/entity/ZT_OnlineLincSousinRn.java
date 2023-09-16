package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_OnlineLincSousinRn;
import yuyu.def.db.mapping.GenZT_OnlineLincSousinRn;
import yuyu.def.db.meta.GenQZT_OnlineLincSousinRn;
import yuyu.def.db.meta.QZT_OnlineLincSousinRn;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_OnlineLincSousinRn} の JavaDoc を参照してください。
 * @see     GenZT_OnlineLincSousinRn
 * @see     PKZT_OnlineLincSousinRn
 * @see     QZT_OnlineLincSousinRn
 * @see     GenQZT_OnlineLincSousinRn
 */
@Entity
public class ZT_OnlineLincSousinRn extends GenZT_OnlineLincSousinRn {

    private static final long serialVersionUID = 1L;

    public ZT_OnlineLincSousinRn() {
    }

    public ZT_OnlineLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        super(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }

}
