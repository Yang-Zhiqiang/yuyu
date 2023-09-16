package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.def.db.id.PKZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroTy;

/**
 * 通常配当所要額Ｆ（Ｎ－０）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNminusZeroTy} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNminusZeroTy
 * @see     PKZT_TjHitsyyugkNminusZeroTy
 * @see     QZT_TjHitsyyugkNminusZeroTy
 * @see     GenQZT_TjHitsyyugkNminusZeroTy
 */
@Entity
public class ZT_TjHitsyyugkNminusZeroTy extends GenZT_TjHitsyyugkNminusZeroTy implements TuujyuHitusyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNminusZeroTy() {
    }

    public ZT_TjHitsyyugkNminusZeroTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
