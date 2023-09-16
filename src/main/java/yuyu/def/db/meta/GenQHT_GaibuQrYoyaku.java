package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;

/**
 * 外部用ＱＲ予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_GaibuQrYoyaku extends AbstractExDBTable<HT_GaibuQrYoyaku> {

    public GenQHT_GaibuQrYoyaku() {
        this("HT_GaibuQrYoyaku");
    }

    public GenQHT_GaibuQrYoyaku(String pAlias) {
        super("HT_GaibuQrYoyaku", HT_GaibuQrYoyaku.class, pAlias);
    }

    public String HT_GaibuQrYoyaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_GaibuQrYoyaku, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldNumber<HT_GaibuQrYoyaku, Integer> sakuseikensuu = new ExDBFieldNumber<>("sakuseikensuu", this);

    public final ExDBFieldString<HT_GaibuQrYoyaku, BizDate> qrsakuseiymd = new ExDBFieldString<>("qrsakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_GaibuQrYoyaku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
