package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TyhysakuseiyhKbn;

/**
 * 住所変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhJyuusyoHenkouWk extends AbstractExDBTable<IW_KhJyuusyoHenkouWk> {

    public GenQIW_KhJyuusyoHenkouWk() {
        this("IW_KhJyuusyoHenkouWk");
    }

    public GenQIW_KhJyuusyoHenkouWk(String pAlias) {
        super("IW_KhJyuusyoHenkouWk", IW_KhJyuusyoHenkouWk.class, pAlias);
    }

    public String IW_KhJyuusyoHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, C_TyhysakuseiyhKbn> tyhysakuseiyhkbn = new ExDBFieldString<>("tyhysakuseiyhkbn", this, UserType_C_TyhysakuseiyhKbn.class);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhJyuusyoHenkouWk, String> doujiskkinouid = new ExDBFieldString<>("doujiskkinouid", this);
}
