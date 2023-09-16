package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_ChkNenreiHani;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;

/**
 * 年齢範囲チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNenreiHani extends AbstractExDBTable<BM_ChkNenreiHani> {

    public GenQBM_ChkNenreiHani() {
        this("BM_ChkNenreiHani");
    }

    public GenQBM_ChkNenreiHani(String pAlias) {
        super("BM_ChkNenreiHani", BM_ChkNenreiHani.class, pAlias);
    }

    public String BM_ChkNenreiHani() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkNenreiHani, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_ChkNenreiHani, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> hhknseifrom = new ExDBFieldNumber<>("hhknseifrom", this);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> hhknseito = new ExDBFieldNumber<>("hhknseito", this);

    public final ExDBFieldString<BM_ChkNenreiHani, C_KataKbn> syukatakbn = new ExDBFieldString<>("syukatakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> syuhknkkn = new ExDBFieldNumber<>("syuhknkkn", this);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> syuhknkknto = new ExDBFieldNumber<>("syuhknkknto", this);

    public final ExDBFieldString<BM_ChkNenreiHani, C_HknkknsmnKbn> syuhknkknsmnkbn = new ExDBFieldString<>("syuhknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> syuhrkkkn = new ExDBFieldNumber<>("syuhrkkkn", this);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> syuhrkkknto = new ExDBFieldNumber<>("syuhrkkknto", this);

    public final ExDBFieldString<BM_ChkNenreiHani, C_HrkkknsmnKbn> syuhrkkknsmnkbn = new ExDBFieldString<>("syuhrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> syufromnen = new ExDBFieldString<>("syufromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> syutonen = new ExDBFieldString<>("syutonen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> syuyoteiriritufrom = new ExDBFieldString<>("syuyoteiriritufrom", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> syuyoteirirituto = new ExDBFieldString<>("syuyoteirirituto", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> tokusyuchkno = new ExDBFieldString<>("tokusyuchkno", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiHani, String> tksyouhncd = new ExDBFieldString<>("tksyouhncd", this);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> tkhknkkn = new ExDBFieldString<>("tkhknkkn", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> tkhknkknto = new ExDBFieldNumber<>("tkhknkknto", this);

    public final ExDBFieldString<BM_ChkNenreiHani, C_HknkknsmnKbn> tkhknkknsmnkbn = new ExDBFieldString<>("tkhknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> tkhrkkkn = new ExDBFieldString<>("tkhrkkkn", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkNenreiHani, Integer> tkhrkkknto = new ExDBFieldNumber<>("tkhrkkknto", this);

    public final ExDBFieldString<BM_ChkNenreiHani, C_HrkkknsmnKbn> tkhrkkknsmnkbn = new ExDBFieldString<>("tkhrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> tkfromnen = new ExDBFieldString<>("tkfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiHani, BizNumber> tktonen = new ExDBFieldString<>("tktonen", this, BizNumberType.class);
}
