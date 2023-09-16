package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenTsryInfoRn;
import yuyu.def.db.mapping.GenZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.GenQZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.QZT_DrtenTsryInfoRn;

/**
 * 代理店手数料情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenTsryInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenTsryInfoRn
 * @see     PKZT_DrtenTsryInfoRn
 * @see     QZT_DrtenTsryInfoRn
 * @see     GenQZT_DrtenTsryInfoRn
 */
@Entity
public class ZT_DrtenTsryInfoRn extends GenZT_DrtenTsryInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenTsryInfoRn() {
    }

    public ZT_DrtenTsryInfoRn(
        String pZrndairitencd,
        String pZrnbosyuunincd,
        String pZrnsyono,
        String pZrnkikaisyoriymd,
        Long pZrnkykmfksnctrlkh,
        String pZrnsikibetujyunjyo
    ) {
        super(
            pZrndairitencd,
            pZrnbosyuunincd,
            pZrnsyono,
            pZrnkikaisyoriymd,
            pZrnkykmfksnctrlkh,
            pZrnsikibetujyunjyo
        );
    }

}
