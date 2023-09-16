package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_DairitenBuntanInfoRn;
import yuyu.def.db.mapping.GenZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.GenQZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.QZT_DairitenBuntanInfoRn;

/**
 * 代理店手数料分担情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DairitenBuntanInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_DairitenBuntanInfoRn
 * @see     PKZT_DairitenBuntanInfoRn
 * @see     QZT_DairitenBuntanInfoRn
 * @see     GenQZT_DairitenBuntanInfoRn
 */
@Entity
public class ZT_DairitenBuntanInfoRn extends GenZT_DairitenBuntanInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_DairitenBuntanInfoRn() {
    }

    public ZT_DairitenBuntanInfoRn(
        String pZrndairitencd,
        String pZrndairitensyouhincd,
        String pZrntesuuryoubuntanaitedrtcd,
        String pZrntesuuryoubuntanstartym
    ) {
        super(
            pZrndairitencd,
            pZrndairitensyouhincd,
            pZrntesuuryoubuntanaitedrtcd,
            pZrntesuuryoubuntanstartym
        );
    }

}
