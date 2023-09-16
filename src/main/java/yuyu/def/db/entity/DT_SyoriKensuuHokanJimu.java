package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKDT_SyoriKensuuHokanJimu;
import yuyu.def.db.mapping.GenDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.GenQDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanJimu;
import jp.co.slcs.swak.date.BizDate;

/**
 * 処理件数保管（事務手続別）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDT_SyoriKensuuHokanJimu} の JavaDoc を参照してください。
 * @see     GenDT_SyoriKensuuHokanJimu
 * @see     PKDT_SyoriKensuuHokanJimu
 * @see     QDT_SyoriKensuuHokanJimu
 * @see     GenQDT_SyoriKensuuHokanJimu
 */
@Entity
public class DT_SyoriKensuuHokanJimu extends GenDT_SyoriKensuuHokanJimu {

    private static final long serialVersionUID = 1L;

    public DT_SyoriKensuuHokanJimu() {
    }

    public DT_SyoriKensuuHokanJimu(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pAccountId
    ) {
        super(
            pKensuuHokanYmd,
            pJimutetuzukicd,
            pAccountId
        );
    }

}
