package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 有効性確認ＮＧ通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_YuukouseiNgTuuti extends AbstractExDBTable<IT_YuukouseiNgTuuti> {

    public GenQIT_YuukouseiNgTuuti() {
        this("IT_YuukouseiNgTuuti");
    }

    public GenQIT_YuukouseiNgTuuti(String pAlias) {
        super("IT_YuukouseiNgTuuti", IT_YuukouseiNgTuuti.class, pAlias);
    }

    public String IT_YuukouseiNgTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta1 = new ExDBFieldString<>("osirasemongon46keta1", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta2 = new ExDBFieldString<>("osirasemongon46keta2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta3 = new ExDBFieldString<>("osirasemongon46keta3", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta4 = new ExDBFieldString<>("osirasemongon46keta4", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta5 = new ExDBFieldString<>("osirasemongon46keta5", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta6 = new ExDBFieldString<>("osirasemongon46keta6", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta7 = new ExDBFieldString<>("osirasemongon46keta7", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta8 = new ExDBFieldString<>("osirasemongon46keta8", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta9 = new ExDBFieldString<>("osirasemongon46keta9", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> osirasemongon46keta10 = new ExDBFieldString<>("osirasemongon46keta10", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldBizCurrency<IT_YuukouseiNgTuuti> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> creditcardinfo1 = new ExDBFieldString<>("creditcardinfo1", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> creditcardinfo2 = new ExDBFieldString<>("creditcardinfo2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> creditcardinfo3 = new ExDBFieldString<>("creditcardinfo3", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> creditcardmaskingmsg = new ExDBFieldString<>("creditcardmaskingmsg", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> goiraijikoutoumongon1 = new ExDBFieldString<>("goiraijikoutoumongon1", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> goiraijikoutoumongon2 = new ExDBFieldString<>("goiraijikoutoumongon2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> goiraijikoutoumongon3 = new ExDBFieldString<>("goiraijikoutoumongon3", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon1 = new ExDBFieldString<>("phrkmongon1", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon2 = new ExDBFieldString<>("phrkmongon2", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon3 = new ExDBFieldString<>("phrkmongon3", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon4 = new ExDBFieldString<>("phrkmongon4", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon5 = new ExDBFieldString<>("phrkmongon5", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon6 = new ExDBFieldString<>("phrkmongon6", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon7 = new ExDBFieldString<>("phrkmongon7", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon8 = new ExDBFieldString<>("phrkmongon8", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> phrkmongon9 = new ExDBFieldString<>("phrkmongon9", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_YuukouseiNgTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
