package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KenpoTaisyouKbn;
import yuyu.def.classification.C_KnptsgetcKbn;
import yuyu.def.classification.C_KnptsgkkmsnKbn;
import yuyu.def.classification.C_KnptsgknmsnyKbn;
import yuyu.def.classification.C_KnptsgsnsnKbn;
import yuyu.def.classification.C_KnptsgtknKbn;
import yuyu.def.classification.C_LnSeikyuuKbn;
import yuyu.def.classification.C_NyuuinJyoukyou;
import yuyu.def.classification.C_PmenKbn;
import yuyu.def.classification.C_SaigaiGeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;
import yuyu.def.db.entity.JT_SkJiyuu;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_KenpoTaisyouKbn;
import yuyu.def.db.type.UserType_C_KnptsgetcKbn;
import yuyu.def.db.type.UserType_C_KnptsgkkmsnKbn;
import yuyu.def.db.type.UserType_C_KnptsgknmsnyKbn;
import yuyu.def.db.type.UserType_C_KnptsgsnsnKbn;
import yuyu.def.db.type.UserType_C_KnptsgtknKbn;
import yuyu.def.db.type.UserType_C_LnSeikyuuKbn;
import yuyu.def.db.type.UserType_C_NyuuinJyoukyou;
import yuyu.def.db.type.UserType_C_PmenKbn;
import yuyu.def.db.type.UserType_C_SaigaiGeninKbn;
import yuyu.def.db.type.UserType_C_SibouBasyoKbn;

/**
 * 請求事由テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SkJiyuu extends AbstractExDBTable<JT_SkJiyuu> {

    public GenQJT_SkJiyuu() {
        this("JT_SkJiyuu");
    }

    public GenQJT_SkJiyuu(String pAlias) {
        super("JT_SkJiyuu", JT_SkJiyuu.class, pAlias);
    }

    public String JT_SkJiyuu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SkJiyuu, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SkJiyuu, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SkJiyuu, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_SkJiyuu, Integer> uketukeno = new ExDBFieldNumber<>("uketukeno", this);

    public final ExDBFieldString<JT_SkJiyuu, C_GeninKbn> geninkbn = new ExDBFieldString<>("geninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, BizDate> jikosyosinymd = new ExDBFieldString<>("jikosyosinymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkJiyuu, BizDate> syoubyouhsymd = new ExDBFieldString<>("syoubyouhsymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkJiyuu, C_SaigaiGeninKbn> saigaigeninkbn = new ExDBFieldString<>("saigaigeninkbn", this, UserType_C_SaigaiGeninKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, String> gansindankakuteiymd = new ExDBFieldString<>("gansindankakuteiymd", this);

    public final ExDBFieldString<JT_SkJiyuu, C_NyuuinJyoukyou> nyuuinjyoukyou = new ExDBFieldString<>("nyuuinjyoukyou", this, UserType_C_NyuuinJyoukyou.class);

    public final ExDBFieldString<JT_SkJiyuu, BizDateYM> syuyouzaisiyouyoteiym = new ExDBFieldString<>("syuyouzaisiyouyoteiym", this, BizDateYMType.class);

    public final ExDBFieldString<JT_SkJiyuu, C_KenpoTaisyouKbn> kenpotaisyoukbn = new ExDBFieldString<>("kenpotaisyoukbn", this, UserType_C_KenpoTaisyouKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, C_KnptsgtknKbn> knptsgairytikenkbn = new ExDBFieldString<>("knptsgairytikenkbn", this, UserType_C_KnptsgtknKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, C_KnptsgsnsnKbn> knptsgairysensinkbn = new ExDBFieldString<>("knptsgairysensinkbn", this, UserType_C_KnptsgsnsnKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, C_KnptsgknmsnyKbn> knptsgairykknaimsynnyakukbn = new ExDBFieldString<>("knptsgairykknaimsynnyakukbn", this, UserType_C_KnptsgknmsnyKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, C_KnptsgkkmsnKbn> knptsgairykyyhkkyhmsynnkbn = new ExDBFieldString<>("knptsgairykyyhkkyhmsynnkbn", this, UserType_C_KnptsgkkmsnKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, C_KnptsgetcKbn> knptsgairysonotakbn = new ExDBFieldString<>("knptsgairysonotakbn", this, UserType_C_KnptsgetcKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, String> knptsgairysonotanaiyou = new ExDBFieldString<>("knptsgairysonotanaiyou", this);

    public final ExDBFieldString<JT_SkJiyuu, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkJiyuu, C_SibouBasyoKbn> siboubasyokbn = new ExDBFieldString<>("siboubasyokbn", this, UserType_C_SibouBasyoKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, String> siboubasyo = new ExDBFieldString<>("siboubasyo", this);

    public final ExDBFieldString<JT_SkJiyuu, BizDate> syougaikoteiymd = new ExDBFieldString<>("syougaikoteiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkJiyuu, C_PmenKbn> pmenkbn = new ExDBFieldString<>("pmenkbn", this, UserType_C_PmenKbn.class);

    public final ExDBFieldString<JT_SkJiyuu, BizDate> pmenkoteiymd = new ExDBFieldString<>("pmenkoteiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkJiyuu, C_LnSeikyuuKbn> lnseikyuukbn = new ExDBFieldString<>("lnseikyuukbn", this, UserType_C_LnSeikyuuKbn.class);

    public final ExDBFieldBizCurrency<JT_SkJiyuu> lnsiteihokenkngk = new ExDBFieldBizCurrency<>("lnsiteihokenkngk", this);

    public final ExDBFieldString<JT_SkJiyuu, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SkJiyuu, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SkJiyuu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SkJiyuu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
