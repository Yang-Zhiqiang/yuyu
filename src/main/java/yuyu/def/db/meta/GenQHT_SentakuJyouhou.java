package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SntkinfoKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_KankeisyaKbn;
import yuyu.def.db.type.UserType_C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.type.UserType_C_SntkinfoKbn;
import yuyu.def.db.type.UserType_C_SysCdKbn;

/**
 * 選択情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SentakuJyouhou extends AbstractExDBTable<HT_SentakuJyouhou> {

    public GenQHT_SentakuJyouhou() {
        this("HT_SentakuJyouhou");
    }

    public GenQHT_SentakuJyouhou(String pAlias) {
        super("HT_SentakuJyouhou", HT_SentakuJyouhou.class, pAlias);
    }

    public String HT_SentakuJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SentakuJyouhou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SentakuJyouhou, C_SntkInfoTaisyousyaKbn> sntkinfotaisyousyakbn = new ExDBFieldString<>("sntkinfotaisyousyakbn", this, UserType_C_SntkInfoTaisyousyaKbn.class);

    public final ExDBFieldNumber<HT_SentakuJyouhou, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<HT_SentakuJyouhou, String> sntkinfono = new ExDBFieldString<>("sntkinfono", this);

    public final ExDBFieldString<HT_SentakuJyouhou, C_SysCdKbn> syscdkbn = new ExDBFieldString<>("syscdkbn", this, UserType_C_SysCdKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_KankeisyaKbn> sntkinfokankeisyakbn = new ExDBFieldString<>("sntkinfokankeisyakbn", this, UserType_C_KankeisyaKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, String> sntkinfofkojinkbn = new ExDBFieldString<>("sntkinfofkojinkbn", this);

    public final ExDBFieldString<HT_SentakuJyouhou, C_SntkinfoKbn> sntkinfokbn = new ExDBFieldString<>("sntkinfokbn", this, UserType_C_SntkinfoKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, BizDate> sntkinfosakuseiymd = new ExDBFieldString<>("sntkinfosakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> mrumukbn = new ExDBFieldString<>("mrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> decumukbn = new ExDBFieldString<>("decumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> infokoukanumukbn = new ExDBFieldString<>("infokoukanumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> nyuuinkyhkshrumukbn = new ExDBFieldString<>("nyuuinkyhkshrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> syujyutukyhkshrumukbn = new ExDBFieldString<>("syujyutukyhkshrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> syougaikyhkshrumukbn = new ExDBFieldString<>("syougaikyhkshrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> koudosyougaiumukbn = new ExDBFieldString<>("koudosyougaiumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> pmenumukbn = new ExDBFieldString<>("pmenumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> torikaijoumukbn = new ExDBFieldString<>("torikaijoumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> soukikeakyhkshrumukbn = new ExDBFieldString<>("soukikeakyhkshrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> sonotakyhkshrumukbn = new ExDBFieldString<>("sonotakyhkshrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> kghsjjtkyhkshrumukbn = new ExDBFieldString<>("kghsjjtkyhkshrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> huho2mrumukbn = new ExDBFieldString<>("huho2mrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> huho2decumukbn = new ExDBFieldString<>("huho2decumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> huho2kdumukbn = new ExDBFieldString<>("huho2kdumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, C_BlnktkumuKbn> huho2torikaijoumukbn = new ExDBFieldString<>("huho2torikaijoumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_SentakuJyouhou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SentakuJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
