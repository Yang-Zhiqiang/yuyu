package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhSeinengappiSeiTeiseiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 被保険者生年月日・性訂正ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhSeinengappiSeiTeiseiWk extends AbstractExDBTable<IW_KhSeinengappiSeiTeiseiWk> {

    public GenQIW_KhSeinengappiSeiTeiseiWk() {
        this("IW_KhSeinengappiSeiTeiseiWk");
    }

    public GenQIW_KhSeinengappiSeiTeiseiWk(String pAlias) {
        super("IW_KhSeinengappiSeiTeiseiWk", IW_KhSeinengappiSeiTeiseiWk.class, pAlias);
    }

    public String IW_KhSeinengappiSeiTeiseiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, BizDate> newhhknseiymd = new ExDBFieldString<>("newhhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_Hhknsei> newhhknsei = new ExDBFieldString<>("newhhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_SoukinsakiKbn> soukinsakikbn = new ExDBFieldString<>("soukinsakikbn", this, UserType_C_SoukinsakiKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhSeinengappiSeiTeiseiWk, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);
}
