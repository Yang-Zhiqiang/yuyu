package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_CreditTrkHaneierrList;
import yuyu.def.db.mapping.GenHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.GenQHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;
import jp.co.slcs.swak.date.BizDate;

/**
 * クレジットカード登録反映エラーリストワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_CreditTrkHaneierrList} の JavaDoc を参照してください。
 * @see     GenHW_CreditTrkHaneierrList
 * @see     PKHW_CreditTrkHaneierrList
 * @see     QHW_CreditTrkHaneierrList
 * @see     GenQHW_CreditTrkHaneierrList
 */
@Entity
public class HW_CreditTrkHaneierrList extends GenHW_CreditTrkHaneierrList {

    private static final long serialVersionUID = 1L;

    public HW_CreditTrkHaneierrList() {
    }

    public HW_CreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno) {
        super(pTyouhyouymd, pDatarenno);
    }

}
