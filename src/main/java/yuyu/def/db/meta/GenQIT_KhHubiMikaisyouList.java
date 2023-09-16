package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備未解消リストテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHubiMikaisyouList extends AbstractExDBTable<IT_KhHubiMikaisyouList> {

    public GenQIT_KhHubiMikaisyouList() {
        this("IT_KhHubiMikaisyouList");
    }

    public GenQIT_KhHubiMikaisyouList(String pAlias) {
        super("IT_KhHubiMikaisyouList", IT_KhHubiMikaisyouList.class, pAlias);
    }

    public String IT_KhHubiMikaisyouList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, BizDate> sksreadymd = new ExDBFieldString<>("sksreadymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, C_UmuKbn> genponhnkykumu = new ExDBFieldString<>("genponhnkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> hubitourokuktntnm = new ExDBFieldString<>("hubitourokuktntnm", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> hubisyouninktntnm = new ExDBFieldString<>("hubisyouninktntnm", this);

    public final ExDBFieldNumber<IT_KhHubiMikaisyouList, Integer> hassinkaisuu = new ExDBFieldNumber<>("hassinkaisuu", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, BizDate> fsthubbihasinymd = new ExDBFieldString<>("fsthubbihasinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, BizDate> lasthubbihasinymd = new ExDBFieldString<>("lasthubbihasinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHubiMikaisyouList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
