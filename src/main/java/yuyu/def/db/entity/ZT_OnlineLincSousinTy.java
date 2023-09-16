package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_OnlineLincSousinTy;
import yuyu.def.db.mapping.GenZT_OnlineLincSousinTy;
import yuyu.def.db.meta.GenQZT_OnlineLincSousinTy;
import yuyu.def.db.meta.QZT_OnlineLincSousinTy;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_OnlineLincSousinTy} の JavaDoc を参照してください。
 * @see     GenZT_OnlineLincSousinTy
 * @see     PKZT_OnlineLincSousinTy
 * @see     QZT_OnlineLincSousinTy
 * @see     GenQZT_OnlineLincSousinTy
 */
@Entity
public class ZT_OnlineLincSousinTy extends GenZT_OnlineLincSousinTy {

    private static final long serialVersionUID = 1L;

    public ZT_OnlineLincSousinTy() {
    }

    public ZT_OnlineLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        super(pZtyrecordsyubetukbn, pZtykykkanrino);
    }

}
