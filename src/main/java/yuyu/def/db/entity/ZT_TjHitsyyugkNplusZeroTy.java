package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusZeroTy} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusZeroTy
 * @see     PKZT_TjHitsyyugkNplusZeroTy
 * @see     QZT_TjHitsyyugkNplusZeroTy
 * @see     GenQZT_TjHitsyyugkNplusZeroTy
 */
@Entity
public class ZT_TjHitsyyugkNplusZeroTy extends GenZT_TjHitsyyugkNplusZeroTy implements TuujyuHitusyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusZeroTy() {
    }

    public ZT_TjHitsyyugkNplusZeroTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
