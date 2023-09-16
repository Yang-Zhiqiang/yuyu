package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_CreditTrkNgList;
import yuyu.def.db.mapping.GenHW_CreditTrkNgList;
import yuyu.def.db.meta.GenQHW_CreditTrkNgList;
import yuyu.def.db.meta.QHW_CreditTrkNgList;
import jp.co.slcs.swak.date.BizDate;

/**
 * クレジットカード会員登録ＮＧリストワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_CreditTrkNgList} の JavaDoc を参照してください。
 * @see     GenHW_CreditTrkNgList
 * @see     PKHW_CreditTrkNgList
 * @see     QHW_CreditTrkNgList
 * @see     GenQHW_CreditTrkNgList
 */
@Entity
public class HW_CreditTrkNgList extends GenHW_CreditTrkNgList {

    private static final long serialVersionUID = 1L;

    public HW_CreditTrkNgList() {
    }

    public HW_CreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno) {
        super(pTyouhyouymd, pDatarenno);
    }

}
