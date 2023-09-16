package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DairitenGtmtZndkTy;
import yuyu.def.db.mapping.GenZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.GenQZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkTy;

/**
 * 代理店月末残高情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DairitenGtmtZndkTy} の JavaDoc を参照してください。
 * @see     GenZT_DairitenGtmtZndkTy
 * @see     PKZT_DairitenGtmtZndkTy
 * @see     QZT_DairitenGtmtZndkTy
 * @see     GenQZT_DairitenGtmtZndkTy
 */
@Entity
public class ZT_DairitenGtmtZndkTy extends GenZT_DairitenGtmtZndkTy {

    private static final long serialVersionUID = 1L;

    public ZT_DairitenGtmtZndkTy() {
    }

    public ZT_DairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono) {
        super(pZtydatakijyunymd, pZtysyono);
    }

}
