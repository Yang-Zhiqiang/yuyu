package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.mapping.GenZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.GenQZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlRn;

/**
 * 前納保有異動契約明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_ZennouHoyuuIdouKykDtlRn} の JavaDoc を参照してください。
 * @see     GenZT_ZennouHoyuuIdouKykDtlRn
 * @see     PKZT_ZennouHoyuuIdouKykDtlRn
 * @see     QZT_ZennouHoyuuIdouKykDtlRn
 * @see     GenQZT_ZennouHoyuuIdouKykDtlRn
 */
@Entity
public class ZT_ZennouHoyuuIdouKykDtlRn extends GenZT_ZennouHoyuuIdouKykDtlRn {

    private static final long serialVersionUID = 1L;

    public ZT_ZennouHoyuuIdouKykDtlRn() {
    }

    public ZT_ZennouHoyuuIdouKykDtlRn(
        String pZrndatakanrino,
        String pZrnsyoricd,
        Integer pZrnkykmfksnctr
    ) {
        super(
            pZrndatakanrino,
            pZrnsyoricd,
            pZrnkykmfksnctr
        );
    }

}
