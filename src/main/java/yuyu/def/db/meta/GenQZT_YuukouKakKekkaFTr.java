package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFTr;

/**
 * 有効性確認結果Ｆテーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_YuukouKakKekkaFTr extends AbstractExDBTable<ZT_YuukouKakKekkaFTr> {

    public GenQZT_YuukouKakKekkaFTr() {
        this("ZT_YuukouKakKekkaFTr");
    }

    public GenQZT_YuukouKakKekkaFTr(String pAlias) {
        super("ZT_YuukouKakKekkaFTr", ZT_YuukouKakKekkaFTr.class, pAlias);
    }

    public String ZT_YuukouKakKekkaFTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrrecordkbn = new ExDBFieldString<>("ztrrecordkbn", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztryobiv1 = new ExDBFieldString<>("ztryobiv1", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrcreditkessaiyouno = new ExDBFieldString<>("ztrcreditkessaiyouno", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrdbkeykugirimoji1 = new ExDBFieldString<>("ztrdbkeykugirimoji1", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrdbkeykugirimoji2 = new ExDBFieldString<>("ztrdbkeykugirimoji2", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztryobiv32 = new ExDBFieldString<>("ztryobiv32", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrcardno = new ExDBFieldString<>("ztrcardno", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrcardyuukoukigen = new ExDBFieldString<>("ztrcardyuukoukigen", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztryuukouhanteikekka = new ExDBFieldString<>("ztryuukouhanteikekka", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztryobiv59 = new ExDBFieldString<>("ztryobiv59", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztrcreditkigyoucd = new ExDBFieldString<>("ztrcreditkigyoucd", this);

    public final ExDBFieldString<ZT_YuukouKakKekkaFTr, String> ztryobiv53 = new ExDBFieldString<>("ztryobiv53", this);
}
