package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinninTouhyouRn;
import yuyu.def.db.mapping.GenZT_SinninTouhyouRn;
import yuyu.def.db.meta.GenQZT_SinninTouhyouRn;
import yuyu.def.db.meta.QZT_SinninTouhyouRn;

/**
 * 信任投票データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinninTouhyouRn} の JavaDoc を参照してください。
 * @see     GenZT_SinninTouhyouRn
 * @see     PKZT_SinninTouhyouRn
 * @see     QZT_SinninTouhyouRn
 * @see     GenQZT_SinninTouhyouRn
 */
@Entity
public class ZT_SinninTouhyouRn extends GenZT_SinninTouhyouRn {

    private static final long serialVersionUID = 1L;

    public ZT_SinninTouhyouRn() {
    }

    public ZT_SinninTouhyouRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
