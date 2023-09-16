package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhDShrWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TumitateDSakuseiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 配当金支払ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhDShrWk extends AbstractExDBTable<IW_KhDShrWk> {

    public GenQIW_KhDShrWk() {
        this("IW_KhDShrWk");
    }

    public GenQIW_KhDShrWk(String pAlias) {
        super("IW_KhDShrWk", IW_KhDShrWk.class, pAlias);
    }

    public String IW_KhDShrWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhDShrWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhDShrWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhDShrWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhDShrWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhDShrWk, C_TumitateDSakuseiKbn> haitoukinskkbn = new ExDBFieldString<>("haitoukinskkbn", this, UserType_C_TumitateDSakuseiKbn.class);

    public final ExDBFieldBizCurrency<IW_KhDShrWk> haitoukinskkngk = new ExDBFieldBizCurrency<>("haitoukinskkngk", this);

    public final ExDBFieldString<IW_KhDShrWk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IW_KhDShrWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhDShrWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhDShrWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhDShrWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhDShrWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhDShrWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhDShrWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhDShrWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhDShrWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhDShrWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhDShrWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhDShrWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhDShrWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhDShrWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhDShrWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
