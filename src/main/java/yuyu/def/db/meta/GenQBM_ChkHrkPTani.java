package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 払込Ｐ単位チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkHrkPTani extends AbstractExDBTable<BM_ChkHrkPTani> {

    public GenQBM_ChkHrkPTani() {
        this("BM_ChkHrkPTani");
    }

    public GenQBM_ChkHrkPTani(String pAlias) {
        super("BM_ChkHrkPTani", BM_ChkHrkPTani.class, pAlias);
    }

    public String BM_ChkHrkPTani() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkHrkPTani, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_ChkHrkPTani, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldNumber<BM_ChkHrkPTani, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkHrkPTani, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkHrkPTani, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_ChkHrkPTani, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BM_ChkHrkPTani> hrkptani = new ExDBFieldBizCurrency<>("hrkptani", this);
}
