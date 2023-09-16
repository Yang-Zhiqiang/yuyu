package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusOneTy;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusOneTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusOneTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusOneTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋１）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusOneTy} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusOneTy
 * @see     PKZT_TjHitsyyugkNplusOneTy
 * @see     QZT_TjHitsyyugkNplusOneTy
 * @see     GenQZT_TjHitsyyugkNplusOneTy
 */
@Entity
public class ZT_TjHitsyyugkNplusOneTy extends GenZT_TjHitsyyugkNplusOneTy implements TuujyuHitusyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusOneTy() {
    }

    public ZT_TjHitsyyugkNplusOneTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
