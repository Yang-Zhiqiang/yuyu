package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.IT_BAK_KhHenreikin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrsyuruiKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Siharaijyoutaikbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;

/**
 * 契約保全返戻金バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhHenreikin extends AbstractExDBTable<IT_BAK_KhHenreikin> {

    public GenQIT_BAK_KhHenreikin() {
        this("IT_BAK_KhHenreikin");
    }

    public GenQIT_BAK_KhHenreikin(String pAlias) {
        super("IT_BAK_KhHenreikin", IT_BAK_KhHenreikin.class, pAlias);
    }

    public String IT_BAK_KhHenreikin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, C_HrsyuruiKbn> hrsyuruikbn = new ExDBFieldString<>("hrsyuruikbn", this, UserType_C_HrsyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, BizDate> hrhsiymd = new ExDBFieldString<>("hrhsiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, BizDate> hrhsisyoriymd = new ExDBFieldString<>("hrhsisyoriymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenreikin> henreikingk = new ExDBFieldBizCurrency<>("henreikingk", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, C_Siharaijyoutaikbn> hrsiharaijyoutaikbn = new ExDBFieldString<>("hrsiharaijyoutaikbn", this, UserType_C_Siharaijyoutaikbn.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, C_Segcd> seg2cd = new ExDBFieldString<>("seg2cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhHenreikin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
