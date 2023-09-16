package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;

/**
 * 勘定科目変換テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_ConvertKanjyouKamoku extends AbstractExDBTable<ST_ConvertKanjyouKamoku> {

    public GenQST_ConvertKanjyouKamoku() {
        this("ST_ConvertKanjyouKamoku");
    }

    public GenQST_ConvertKanjyouKamoku(String pAlias) {
        super("ST_ConvertKanjyouKamoku", ST_ConvertKanjyouKamoku.class, pAlias);
    }

    public String ST_ConvertKanjyouKamoku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_ConvertKanjyouKamoku, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<ST_ConvertKanjyouKamoku, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<ST_ConvertKanjyouKamoku, C_Kanjyoukmkcd> convertedkanjyoukmkcd = new ExDBFieldString<>("convertedkanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<ST_ConvertKanjyouKamoku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<ST_ConvertKanjyouKamoku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<ST_ConvertKanjyouKamoku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
