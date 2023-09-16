package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_SikinIdouListCsvFSks;
import yuyu.def.db.mapping.GenBT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.GenQBT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.QBT_SikinIdouListCsvFSks;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SikinidoulistKbn;

/**
 * 資金移動リストＣＳＶファイル作成用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_SikinIdouListCsvFSks} の JavaDoc を参照してください。
 * @see     GenBT_SikinIdouListCsvFSks
 * @see     PKBT_SikinIdouListCsvFSks
 * @see     QBT_SikinIdouListCsvFSks
 * @see     GenQBT_SikinIdouListCsvFSks
 */
@Entity
public class BT_SikinIdouListCsvFSks extends GenBT_SikinIdouListCsvFSks {

    private static final long serialVersionUID = 1L;

    public BT_SikinIdouListCsvFSks() {
    }

    public BT_SikinIdouListCsvFSks(
        BizDate pSyoriYmd,
        C_SikinidoulistKbn pSikinidoulistkbn,
        Integer pRenno
    ) {
        super(
            pSyoriYmd,
            pSikinidoulistkbn,
            pRenno
        );
    }

}
