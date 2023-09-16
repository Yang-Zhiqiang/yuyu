package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_CreditTrkhouKbn;

/**
 * クレジットカード登録反映エラーリストワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_CreditTrkHaneierrList extends AbstractExDBTable<HW_CreditTrkHaneierrList> {

    public GenQHW_CreditTrkHaneierrList() {
        this("HW_CreditTrkHaneierrList");
    }

    public GenQHW_CreditTrkHaneierrList(String pAlias) {
        super("HW_CreditTrkHaneierrList", HW_CreditTrkHaneierrList.class, pAlias);
    }

    public String HW_CreditTrkHaneierrList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_CreditTrkHaneierrList, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<HW_CreditTrkHaneierrList, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<HW_CreditTrkHaneierrList, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HW_CreditTrkHaneierrList, C_CreditTrkhouKbn> credittrkhoukbn = new ExDBFieldString<>("credittrkhoukbn", this, UserType_C_CreditTrkhouKbn.class);

    public final ExDBFieldString<HW_CreditTrkHaneierrList, String> sosikicd = new ExDBFieldString<>("sosikicd", this);

    public final ExDBFieldString<HW_CreditTrkHaneierrList, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<HW_CreditTrkHaneierrList, String> credittrkhaneierrriyuu = new ExDBFieldString<>("credittrkhaneierrriyuu", this);
}
