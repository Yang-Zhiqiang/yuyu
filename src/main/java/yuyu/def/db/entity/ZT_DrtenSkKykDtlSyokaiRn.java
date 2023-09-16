package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenSkKykDtlSyokaiRn;
import yuyu.def.db.mapping.GenZT_DrtenSkKykDtlSyokaiRn;
import yuyu.def.db.meta.GenQZT_DrtenSkKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiRn;

/**
 * 代理店失効契約明細照会用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenSkKykDtlSyokaiRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenSkKykDtlSyokaiRn
 * @see     PKZT_DrtenSkKykDtlSyokaiRn
 * @see     QZT_DrtenSkKykDtlSyokaiRn
 * @see     GenQZT_DrtenSkKykDtlSyokaiRn
 */
@Entity
public class ZT_DrtenSkKykDtlSyokaiRn extends GenZT_DrtenSkKykDtlSyokaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenSkKykDtlSyokaiRn() {
    }

    public ZT_DrtenSkKykDtlSyokaiRn(
        String pZrnsakuseiym,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono
    ) {
        super(
            pZrnsakuseiym,
            pZrnbsydrtencd,
            pZrntntusycd,
            pZrnsyono
        );
    }

}
