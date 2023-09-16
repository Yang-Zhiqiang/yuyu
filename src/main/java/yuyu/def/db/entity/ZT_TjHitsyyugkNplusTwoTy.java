package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusTwoTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋２）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusTwoTy} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusTwoTy
 * @see     PKZT_TjHitsyyugkNplusTwoTy
 * @see     QZT_TjHitsyyugkNplusTwoTy
 * @see     GenQZT_TjHitsyyugkNplusTwoTy
 */
@Entity
public class ZT_TjHitsyyugkNplusTwoTy extends GenZT_TjHitsyyugkNplusTwoTy implements TuujyuHitusyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusTwoTy() {
    }

    public ZT_TjHitsyyugkNplusTwoTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
