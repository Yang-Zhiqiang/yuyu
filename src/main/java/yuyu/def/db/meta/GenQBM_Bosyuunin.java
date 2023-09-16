package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BosyuuKbn;
import yuyu.def.classification.C_BsKahiKbn;
import yuyu.def.db.entity.BM_Bosyuunin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BosyuuKbn;
import yuyu.def.db.type.UserType_C_BsKahiKbn;

/**
 * 募集人マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Bosyuunin extends AbstractExDBTable<BM_Bosyuunin> {

    public GenQBM_Bosyuunin() {
        this("BM_Bosyuunin");
    }

    public GenQBM_Bosyuunin(String pAlias) {
        super("BM_Bosyuunin", BM_Bosyuunin.class, pAlias);
    }

    public String BM_Bosyuunin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Bosyuunin, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<BM_Bosyuunin, String> bosyuunm = new ExDBFieldString<>("bosyuunm", this);

    public final ExDBFieldString<BM_Bosyuunin, String> kanjibosyuuninnm = new ExDBFieldString<>("kanjibosyuuninnm", this);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> itakuymd = new ExDBFieldString<>("itakuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, String> dairiten1cd = new ExDBFieldString<>("dairiten1cd", this);

    public final ExDBFieldString<BM_Bosyuunin, String> dairiten2cd = new ExDBFieldString<>("dairiten2cd", this);

    public final ExDBFieldString<BM_Bosyuunin, String> dairiten3cd = new ExDBFieldString<>("dairiten3cd", this);

    public final ExDBFieldString<BM_Bosyuunin, String> dairitenkanrisosikicd1 = new ExDBFieldString<>("dairitenkanrisosikicd1", this);

    public final ExDBFieldString<BM_Bosyuunin, String> dairitenkanrisosikicd2 = new ExDBFieldString<>("dairitenkanrisosikicd2", this);

    public final ExDBFieldString<BM_Bosyuunin, String> dairitenkanrisosikicd3 = new ExDBFieldString<>("dairitenkanrisosikicd3", this);

    public final ExDBFieldString<BM_Bosyuunin, C_BosyuuKbn> bosyuukbn = new ExDBFieldString<>("bosyuukbn", this, UserType_C_BosyuuKbn.class);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> bosyuunintourokuymd = new ExDBFieldString<>("bosyuunintourokuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, C_BsKahiKbn> bosyuukahikbn = new ExDBFieldString<>("bosyuukahikbn", this, UserType_C_BsKahiKbn.class);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> bosyuuningyouhaiymd = new ExDBFieldString<>("bosyuuningyouhaiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> hngkhknskktrkymd = new ExDBFieldString<>("hngkhknskktrkymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> hngkhknskktrkmsuymd = new ExDBFieldString<>("hngkhknskktrkmsuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> bosyuuseiymd = new ExDBFieldString<>("bosyuuseiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, BizDate> itakukaiyakuymd = new ExDBFieldString<>("itakukaiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Bosyuunin, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<BM_Bosyuunin, String> bosyuutrkno = new ExDBFieldString<>("bosyuutrkno", this);
}
