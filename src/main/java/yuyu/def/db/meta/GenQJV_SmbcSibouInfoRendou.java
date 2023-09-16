package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JV_SmbcSibouInfoRendou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_UktKbn;

/**
 * ＳＭＢＣ死亡情報連動ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJV_SmbcSibouInfoRendou extends AbstractExDBTable<JV_SmbcSibouInfoRendou> {

    public GenQJV_SmbcSibouInfoRendou() {
        this("JV_SmbcSibouInfoRendou");
    }

    public GenQJV_SmbcSibouInfoRendou(String pAlias) {
        super("JV_SmbcSibouInfoRendou", JV_SmbcSibouInfoRendou.class, pAlias);
    }

    public String JV_SmbcSibouInfoRendou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldNumber<JV_SmbcSibouInfoRendou, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, C_SeikyuusyaKbn> seikyuusyakbn = new ExDBFieldString<>("seikyuusyakbn", this, UserType_C_SeikyuusyaKbn.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> seikyuusyanmkn = new ExDBFieldString<>("seikyuusyanmkn", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> seikyuusyanmkj = new ExDBFieldString<>("seikyuusyanmkj", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, BizDate> seikyuusyaseiymd = new ExDBFieldString<>("seikyuusyaseiymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, BizDate> hubikanryouymd = new ExDBFieldString<>("hubikanryouymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JV_SmbcSibouInfoRendou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
