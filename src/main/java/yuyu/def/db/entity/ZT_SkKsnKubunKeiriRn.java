package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKsnKubunKeiriRn;
import yuyu.def.db.mapping.GenZT_SkKsnKubunKeiriRn;
import yuyu.def.db.meta.GenQZT_SkKsnKubunKeiriRn;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriRn;

/**
 * 新契約決算用区分経理Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnKubunKeiriRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnKubunKeiriRn
 * @see     PKZT_SkKsnKubunKeiriRn
 * @see     QZT_SkKsnKubunKeiriRn
 * @see     GenQZT_SkKsnKubunKeiriRn
 */
@Entity
public class ZT_SkKsnKubunKeiriRn extends GenZT_SkKsnKubunKeiriRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnKubunKeiriRn() {
    }

    public ZT_SkKsnKubunKeiriRn(
        String pZrntorihikiymd,
        String pZrntorihikinon7,
        String pZrntaisyakukbnn,
        String pZrnkanjyoukamokucdn,
        String pZrnsuitoubumoncd,
        String pZrnkizokusegment,
        String pZrnaitesegment
    ) {
        super(
            pZrntorihikiymd,
            pZrntorihikinon7,
            pZrntaisyakukbnn,
            pZrnkanjyoukamokucdn,
            pZrnsuitoubumoncd,
            pZrnkizokusegment,
            pZrnaitesegment
        );
    }

}
