package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhGengakuWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_GengkhouKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KykhnkKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 減額ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhGengakuWk extends AbstractExDBTable<IW_KhGengakuWk> {

    public GenQIW_KhGengakuWk() {
        this("IW_KhGengakuWk");
    }

    public GenQIW_KhGengakuWk(String pAlias) {
        super("IW_KhGengakuWk", IW_KhGengakuWk.class, pAlias);
    }

    public String IW_KhGengakuWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhGengakuWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhGengakuWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhGengakuWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhGengakuWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhGengakuWk, C_KykhnkKbn> kykhnkkbn = new ExDBFieldString<>("kykhnkkbn", this, UserType_C_KykhnkKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, C_GengkhouKbn> gengkhoukbn = new ExDBFieldString<>("gengkhoukbn", this, UserType_C_GengkhouKbn.class);

    public final ExDBFieldBizCurrency<IW_KhGengakuWk> newkihonhknkngaku = new ExDBFieldBizCurrency<>("newkihonhknkngaku", this);

    public final ExDBFieldBizCurrency<IW_KhGengakuWk> newhrkp = new ExDBFieldBizCurrency<>("newhrkp", this);

    public final ExDBFieldString<IW_KhGengakuWk, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhGengakuWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhGengakuWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhGengakuWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhGengakuWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhGengakuWk, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IW_KhGengakuWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhGengakuWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhGengakuWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhGengakuWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhGengakuWk, C_SoukinsakiKbn> soukinsakikbn = new ExDBFieldString<>("soukinsakikbn", this, UserType_C_SoukinsakiKbn.class);
}
