package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KydGWKykInfoRn;
import yuyu.def.db.mapping.GenZT_KydGWKykInfoRn;
import yuyu.def.db.meta.GenQZT_KydGWKykInfoRn;
import yuyu.def.db.meta.QZT_KydGWKykInfoRn;

/**
 * 共同GW用契約情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KydGWKykInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_KydGWKykInfoRn
 * @see     PKZT_KydGWKykInfoRn
 * @see     QZT_KydGWKykInfoRn
 * @see     GenQZT_KydGWKykInfoRn
 */
@Entity
public class ZT_KydGWKykInfoRn extends GenZT_KydGWKykInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_KydGWKykInfoRn() {
    }

    public ZT_KydGWKykInfoRn(
        String pZrnsyono,
        String pZrnsyoriymd,
        Long pZrnkykmfksnctrlkh
    ) {
        super(
            pZrnsyono,
            pZrnsyoriymd,
            pZrnkykmfksnctrlkh
        );
    }

}
