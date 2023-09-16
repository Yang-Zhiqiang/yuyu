package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_MosnoSaibanKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;

/**
 * 外部用ＱＲ予約テーブル２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_GaibuQrYoyaku2 extends AbstractExDBTable<HT_GaibuQrYoyaku2> {

    public GenQHT_GaibuQrYoyaku2() {
        this("HT_GaibuQrYoyaku2");
    }

    public GenQHT_GaibuQrYoyaku2(String pAlias) {
        super("HT_GaibuQrYoyaku2", HT_GaibuQrYoyaku2.class, pAlias);
    }

    public String HT_GaibuQrYoyaku2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_GaibuQrYoyaku2, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku2, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku2, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku2, C_MosnoSaibanKbn> mosnosaibankbn = new ExDBFieldString<>("mosnosaibankbn", this, UserType_C_MosnoSaibanKbn.class);

    public final ExDBFieldNumber<HT_GaibuQrYoyaku2, Integer> mosnosaibansuu = new ExDBFieldNumber<>("mosnosaibansuu", this);

    public final ExDBFieldNumber<HT_GaibuQrYoyaku2, Integer> sakuseikensuu = new ExDBFieldNumber<>("sakuseikensuu", this);

    public final ExDBFieldString<HT_GaibuQrYoyaku2, BizDate> qrsakuseiymd = new ExDBFieldString<>("qrsakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaibuQrYoyaku2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_GaibuQrYoyaku2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
