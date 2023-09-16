package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenTsryInfoTy;
import yuyu.def.db.mapping.GenZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.GenQZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.QZT_DrtenTsryInfoTy;

/**
 * 代理店手数料情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenTsryInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenTsryInfoTy
 * @see     PKZT_DrtenTsryInfoTy
 * @see     QZT_DrtenTsryInfoTy
 * @see     GenQZT_DrtenTsryInfoTy
 */
@Entity
public class ZT_DrtenTsryInfoTy extends GenZT_DrtenTsryInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenTsryInfoTy() {
    }

    public ZT_DrtenTsryInfoTy(
        String pZtydairitencd,
        String pZtybosyuunincd,
        String pZtysyono,
        String pZtykikaisyoriymd,
        Long pZtykykmfksnctrlkh,
        String pZtysikibetujyunjyo
    ) {
        super(
            pZtydairitencd,
            pZtybosyuunincd,
            pZtysyono,
            pZtykikaisyoriymd,
            pZtykykmfksnctrlkh,
            pZtysikibetujyunjyo
        );
    }

}
