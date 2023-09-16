package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;

/**
 * 銀行窓販未収情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhGinkouMdhnMisyuuInfo extends AbstractExDBTable<IT_KhGinkouMdhnMisyuuInfo> {

    public GenQIT_KhGinkouMdhnMisyuuInfo() {
        this("IT_KhGinkouMdhnMisyuuInfo");
    }

    public GenQIT_KhGinkouMdhnMisyuuInfo(String pAlias) {
        super("IT_KhGinkouMdhnMisyuuInfo", IT_KhGinkouMdhnMisyuuInfo.class, pAlias);
    }

    public String IT_KhGinkouMdhnMisyuuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, BizDate> datarenymd = new ExDBFieldString<>("datarenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwbsydrtencd = new ExDBFieldString<>("gwbsydrtencd", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwdatakbn = new ExDBFieldString<>("gwdatakbn", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwdatasakuseiymd = new ExDBFieldString<>("gwdatasakuseiymd", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwhknkaisyacd = new ExDBFieldString<>("gwhknkaisyacd", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwhknsyuruicd = new ExDBFieldString<>("gwhknsyuruicd", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwsyonosyuban = new ExDBFieldString<>("gwsyonosyuban", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwmisyuutatekaekbn = new ExDBFieldString<>("gwmisyuutatekaekbn", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwmisyuutatekaeym = new ExDBFieldString<>("gwmisyuutatekaeym", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwmisyuukg = new ExDBFieldString<>("gwmisyuukg", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwbnkaisuu = new ExDBFieldString<>("gwbnkaisuu", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwmisyuujiyuu = new ExDBFieldString<>("gwmisyuujiyuu", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gwjikaidatakousinymd = new ExDBFieldString<>("gwjikaidatakousinymd", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, C_IkkatubaraiKbn> ikkatubaraikbn = new ExDBFieldString<>("ikkatubaraikbn", this, UserType_C_IkkatubaraiKbn.class);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, C_IkkatubaraiKaisuuKbn> ikkatubaraikaisuu = new ExDBFieldString<>("ikkatubaraikaisuu", this, UserType_C_IkkatubaraiKaisuuKbn.class);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhGinkouMdhnMisyuuInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
