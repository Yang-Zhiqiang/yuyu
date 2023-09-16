package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKubunKeiriFileRn;
import yuyu.def.db.mapping.GenZT_SkKubunKeiriFileRn;
import yuyu.def.db.meta.GenQZT_SkKubunKeiriFileRn;
import yuyu.def.db.meta.QZT_SkKubunKeiriFileRn;

/**
 * 新契約区分経理ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKubunKeiriFileRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKubunKeiriFileRn
 * @see     PKZT_SkKubunKeiriFileRn
 * @see     QZT_SkKubunKeiriFileRn
 * @see     GenQZT_SkKubunKeiriFileRn
 */
@Entity
public class ZT_SkKubunKeiriFileRn extends GenZT_SkKubunKeiriFileRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKubunKeiriFileRn() {
    }

    public ZT_SkKubunKeiriFileRn(
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
