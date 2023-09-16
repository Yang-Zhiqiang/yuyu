package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KubunKeiriFileRn;
import yuyu.def.db.mapping.GenZT_KubunKeiriFileRn;
import yuyu.def.db.meta.GenQZT_KubunKeiriFileRn;
import yuyu.def.db.meta.QZT_KubunKeiriFileRn;

/**
 * 区分経理ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KubunKeiriFileRn} の JavaDoc を参照してください。
 * @see     GenZT_KubunKeiriFileRn
 * @see     PKZT_KubunKeiriFileRn
 * @see     QZT_KubunKeiriFileRn
 * @see     GenQZT_KubunKeiriFileRn
 */
@Entity
public class ZT_KubunKeiriFileRn extends GenZT_KubunKeiriFileRn {

    private static final long serialVersionUID = 1L;

    public ZT_KubunKeiriFileRn() {
    }

    public ZT_KubunKeiriFileRn(
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
