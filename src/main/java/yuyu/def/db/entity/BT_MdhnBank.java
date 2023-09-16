package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBT_MdhnBank;


/**
 * 窓販銀行テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_MdhnBank} の JavaDoc を参照してください。<br />
 * @see     GenBT_MdhnBank<br />
 * @see     PKBT_MdhnBank<br />
 * @see     QBT_MdhnBank<br />
 * @see     GenQBT_MdhnBank<br />
 */
@Entity
public class BT_MdhnBank extends GenBT_MdhnBank {

    private static final long serialVersionUID = 1L;

    public BT_MdhnBank() {
    }

    public BT_MdhnBank(String pDrtencd) {
        super(pDrtencd);
    }



}

