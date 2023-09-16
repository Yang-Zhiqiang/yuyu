package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KydGWKykInfoTy;
import yuyu.def.db.mapping.GenZT_KydGWKykInfoTy;
import yuyu.def.db.meta.GenQZT_KydGWKykInfoTy;
import yuyu.def.db.meta.QZT_KydGWKykInfoTy;

/**
 * 共同GW用契約情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KydGWKykInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_KydGWKykInfoTy
 * @see     PKZT_KydGWKykInfoTy
 * @see     QZT_KydGWKykInfoTy
 * @see     GenQZT_KydGWKykInfoTy
 */
@Entity
public class ZT_KydGWKykInfoTy extends GenZT_KydGWKykInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_KydGWKykInfoTy() {
    }

    public ZT_KydGWKykInfoTy(
        String pZtysyono,
        String pZtysyoriymd,
        Long pZtykykmfksnctrlkh
    ) {
        super(
            pZtysyono,
            pZtysyoriymd,
            pZtykykmfksnctrlkh
        );
    }

}
