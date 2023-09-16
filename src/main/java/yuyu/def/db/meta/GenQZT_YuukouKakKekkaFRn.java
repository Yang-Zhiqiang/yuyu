package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFRn;

/**
 * 有効性確認結果Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_YuukouKakKekkaFRn extends AbstractExDBTable<ZT_YuukouKakKekkaFRn> {

    public GenQZT_YuukouKakKekkaFRn() {
        this("ZT_YuukouKakKekkaFRn");
    }

    public GenQZT_YuukouKakKekkaFRn(String pAlias) {
        super("ZT_YuukouKakKekkaFRn", ZT_YuukouKakKekkaFRn.class, pAlias);
    }

    public String ZT_YuukouKakKekkaFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrndbkeykugirimoji1 = new ExDBFieldString<>("zrndbkeykugirimoji1", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrndbkeykugirimoji2 = new ExDBFieldString<>("zrndbkeykugirimoji2", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrnyobiv32 = new ExDBFieldString<>("zrnyobiv32", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrncardno = new ExDBFieldString<>("zrncardno", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrncardyuukoukigen = new ExDBFieldString<>("zrncardyuukoukigen", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrnyuukouhanteikekka = new ExDBFieldString<>("zrnyuukouhanteikekka", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrnyobiv59 = new ExDBFieldString<>("zrnyobiv59", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrncreditkigyoucd = new ExDBFieldString<>("zrncreditkigyoucd", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFRn, String> zrnyobiv53 = new ExDBFieldString<>("zrnyobiv53", this);
}
