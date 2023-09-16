package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenMinyuKykDtlSyokaiRn;
import yuyu.def.db.mapping.GenZT_DrtenMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.GenQZT_DrtenMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiRn;

/**
 * 代理店未入契約明細照会用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenMinyuKykDtlSyokaiRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenMinyuKykDtlSyokaiRn
 * @see     PKZT_DrtenMinyuKykDtlSyokaiRn
 * @see     QZT_DrtenMinyuKykDtlSyokaiRn
 * @see     GenQZT_DrtenMinyuKykDtlSyokaiRn
 */
@Entity
public class ZT_DrtenMinyuKykDtlSyokaiRn extends GenZT_DrtenMinyuKykDtlSyokaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenMinyuKykDtlSyokaiRn() {
    }

    public ZT_DrtenMinyuKykDtlSyokaiRn(
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
