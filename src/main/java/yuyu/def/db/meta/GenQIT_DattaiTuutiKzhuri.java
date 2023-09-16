package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 脱退通知（口座振替）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_DattaiTuutiKzhuri extends AbstractExDBTable<IT_DattaiTuutiKzhuri> {

    public GenQIT_DattaiTuutiKzhuri() {
        this("IT_DattaiTuutiKzhuri");
    }

    public GenQIT_DattaiTuutiKzhuri(String pAlias) {
        super("IT_DattaiTuutiKzhuri", IT_DattaiTuutiKzhuri.class, pAlias);
    }

    public String IT_DattaiTuutiKzhuri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon1 = new ExDBFieldString<>("osirasemongon1", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon2 = new ExDBFieldString<>("osirasemongon2", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon3 = new ExDBFieldString<>("osirasemongon3", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon4 = new ExDBFieldString<>("osirasemongon4", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon5 = new ExDBFieldString<>("osirasemongon5", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon6 = new ExDBFieldString<>("osirasemongon6", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon7 = new ExDBFieldString<>("osirasemongon7", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon8 = new ExDBFieldString<>("osirasemongon8", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> osirasemongon9 = new ExDBFieldString<>("osirasemongon9", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> kzinfo30keta1 = new ExDBFieldString<>("kzinfo30keta1", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> kzinfo30keta2 = new ExDBFieldString<>("kzinfo30keta2", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> kzinfo30keta3 = new ExDBFieldString<>("kzinfo30keta3", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> kouzamaskingmsg = new ExDBFieldString<>("kouzamaskingmsg", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_DattaiTuutiKzhuri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
