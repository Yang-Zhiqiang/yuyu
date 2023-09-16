package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_ChkJhNenreiHani2;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;

/**
 * 年齢範囲事方書チェックマスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhNenreiHani2 extends AbstractExDBTable<BM_ChkJhNenreiHani2> {

    public GenQBM_ChkJhNenreiHani2() {
        this("BM_ChkJhNenreiHani2");
    }

    public GenQBM_ChkJhNenreiHani2(String pAlias) {
        super("BM_ChkJhNenreiHani2", BM_ChkJhNenreiHani2.class, pAlias);
    }

    public String BM_ChkJhNenreiHani2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhNenreiHani2, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> hhknseifrom = new ExDBFieldNumber<>("hhknseifrom", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> hhknseito = new ExDBFieldNumber<>("hhknseito", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, C_KataKbn> syukatakbn = new ExDBFieldString<>("syukatakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syuhknkkn = new ExDBFieldNumber<>("syuhknkkn", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syuhknkknto = new ExDBFieldNumber<>("syuhknkknto", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, C_HknkknsmnKbn> syuhknkknsmnkbn = new ExDBFieldString<>("syuhknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syuhrkkkn = new ExDBFieldNumber<>("syuhrkkkn", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syuhrkkknto = new ExDBFieldNumber<>("syuhrkkknto", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, C_HrkkknsmnKbn> syuhrkkknsmnkbn = new ExDBFieldString<>("syuhrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> syufromnen = new ExDBFieldString<>("syufromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> syutonen = new ExDBFieldString<>("syutonen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> syuyoteiriritufrom = new ExDBFieldString<>("syuyoteiriritufrom", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> syuyoteirirituto = new ExDBFieldString<>("syuyoteirirituto", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> syudai1hknkkn = new ExDBFieldNumber<>("syudai1hknkkn", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> tokusyuchkno = new ExDBFieldString<>("tokusyuchkno", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, String> tksyouhncd = new ExDBFieldString<>("tksyouhncd", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> tkhknkkn = new ExDBFieldString<>("tkhknkkn", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> tkhknkknto = new ExDBFieldNumber<>("tkhknkknto", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, C_HknkknsmnKbn> tkhknkknsmnkbn = new ExDBFieldString<>("tkhknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> tkhrkkkn = new ExDBFieldString<>("tkhrkkkn", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhNenreiHani2, Integer> tkhrkkknto = new ExDBFieldNumber<>("tkhrkkknto", this);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, C_HrkkknsmnKbn> tkhrkkknsmnkbn = new ExDBFieldString<>("tkhrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> tkfromnen = new ExDBFieldString<>("tkfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNenreiHani2, BizNumber> tktonen = new ExDBFieldString<>("tktonen", this, BizNumberType.class);
}
