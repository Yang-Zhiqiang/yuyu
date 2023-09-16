package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 申告予告通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SinkokuyokokuTuuti extends AbstractExDBTable<IT_SinkokuyokokuTuuti> {

    public GenQIT_SinkokuyokokuTuuti() {
        this("IT_SinkokuyokokuTuuti");
    }

    public GenQIT_SinkokuyokokuTuuti(String pAlias) {
        super("IT_SinkokuyokokuTuuti", IT_SinkokuyokokuTuuti.class, pAlias);
    }

    public String IT_SinkokuyokokuTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> nendo = new ExDBFieldString<>("nendo", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_SinkokuyokokuTuuti, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> aisatumongon32keta1 = new ExDBFieldString<>("aisatumongon32keta1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> aisatumongon32keta2 = new ExDBFieldString<>("aisatumongon32keta2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> aisatumongon32keta3 = new ExDBFieldString<>("aisatumongon32keta3", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> sinkokunen = new ExDBFieldString<>("sinkokunen", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi1 = new ExDBFieldString<>("midasi1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi2 = new ExDBFieldString<>("midasi2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi3 = new ExDBFieldString<>("midasi3", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi4 = new ExDBFieldString<>("midasi4", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi5 = new ExDBFieldString<>("midasi5", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi6 = new ExDBFieldString<>("midasi6", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> midasi7 = new ExDBFieldString<>("midasi7", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon1 = new ExDBFieldString<>("kihonjouhoumongon1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon2 = new ExDBFieldString<>("kihonjouhoumongon2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon3 = new ExDBFieldString<>("kihonjouhoumongon3", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon4 = new ExDBFieldString<>("kihonjouhoumongon4", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon5 = new ExDBFieldString<>("kihonjouhoumongon5", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon6 = new ExDBFieldString<>("kihonjouhoumongon6", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kihonjouhoumongon7 = new ExDBFieldString<>("kihonjouhoumongon7", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newippanykkp = new ExDBFieldBizCurrency<>("newippanykkp", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newippanykkhaitoukin = new ExDBFieldBizCurrency<>("newippanykkhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newippanykksyoumeigk = new ExDBFieldBizCurrency<>("newippanykksyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newiryouykkp = new ExDBFieldBizCurrency<>("newiryouykkp", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newiryouykkhaitoukin = new ExDBFieldBizCurrency<>("newiryouykkhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newiryouykksyoumeigk = new ExDBFieldBizCurrency<>("newiryouykksyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newnenkinykkp = new ExDBFieldBizCurrency<>("newnenkinykkp", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newnenkinykkhaitoukin = new ExDBFieldBizCurrency<>("newnenkinykkhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_SinkokuyokokuTuuti> newnenkinykksyoumeigk = new ExDBFieldBizCurrency<>("newnenkinykksyoumeigk", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> hknjyutoukikan = new ExDBFieldString<>("hknjyutoukikan", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuinm = new ExDBFieldString<>("goryuuinm", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg1 = new ExDBFieldString<>("goryuuimsg1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg2 = new ExDBFieldString<>("goryuuimsg2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg3 = new ExDBFieldString<>("goryuuimsg3", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg4 = new ExDBFieldString<>("goryuuimsg4", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg5 = new ExDBFieldString<>("goryuuimsg5", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg6 = new ExDBFieldString<>("goryuuimsg6", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg7 = new ExDBFieldString<>("goryuuimsg7", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg8 = new ExDBFieldString<>("goryuuimsg8", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> goryuuimsg9 = new ExDBFieldString<>("goryuuimsg9", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> freearea32keta1 = new ExDBFieldString<>("freearea32keta1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> freearea32keta2 = new ExDBFieldString<>("freearea32keta2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> freearea32keta3 = new ExDBFieldString<>("freearea32keta3", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> freearea32keta4 = new ExDBFieldString<>("freearea32keta4", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> freearea32keta5 = new ExDBFieldString<>("freearea32keta5", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsgnm = new ExDBFieldString<>("kaiseimsgnm", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg1 = new ExDBFieldString<>("kaiseimsg1", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg2 = new ExDBFieldString<>("kaiseimsg2", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg3 = new ExDBFieldString<>("kaiseimsg3", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg4 = new ExDBFieldString<>("kaiseimsg4", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg5 = new ExDBFieldString<>("kaiseimsg5", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg6 = new ExDBFieldString<>("kaiseimsg6", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> kaiseimsg7 = new ExDBFieldString<>("kaiseimsg7", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SinkokuyokokuTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
