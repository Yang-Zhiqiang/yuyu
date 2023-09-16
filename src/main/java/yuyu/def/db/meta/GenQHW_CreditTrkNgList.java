package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Dbhanei;

/**
 * クレジットカード会員登録ＮＧリストワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_CreditTrkNgList extends AbstractExDBTable<HW_CreditTrkNgList> {

    public GenQHW_CreditTrkNgList() {
        this("HW_CreditTrkNgList");
    }

    public GenQHW_CreditTrkNgList(String pAlias) {
        super("HW_CreditTrkNgList", HW_CreditTrkNgList.class, pAlias);
    }

    public String HW_CreditTrkNgList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_CreditTrkNgList, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<HW_CreditTrkNgList, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<HW_CreditTrkNgList, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HW_CreditTrkNgList, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<HW_CreditTrkNgList, String> creditqrerrorcd = new ExDBFieldString<>("creditqrerrorcd", this);

    public final ExDBFieldString<HW_CreditTrkNgList, String> bluegateerrorcd = new ExDBFieldString<>("bluegateerrorcd", this);

    public final ExDBFieldString<HW_CreditTrkNgList, C_Dbhanei> dbhaneikbn = new ExDBFieldString<>("dbhaneikbn", this, UserType_C_Dbhanei.class);

    public final ExDBFieldString<HW_CreditTrkNgList, String> credittrkhaneierrriyuu = new ExDBFieldString<>("credittrkhaneierrriyuu", this);

    public final ExDBFieldString<HW_CreditTrkNgList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HW_CreditTrkNgList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
