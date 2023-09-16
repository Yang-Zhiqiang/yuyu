package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoujyoutaiHanteiKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 配当金算出対象抽出ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhHaitouTaisyouWK extends AbstractExDBTable<IW_KhHaitouTaisyouWK> {

    public GenQIW_KhHaitouTaisyouWK() {
        this("IW_KhHaitouTaisyouWK");
    }

    public GenQIW_KhHaitouTaisyouWK(String pAlias) {
        super("IW_KhHaitouTaisyouWK", IW_KhHaitouTaisyouWK.class, pAlias);
    }

    public String IW_KhHaitouTaisyouWK() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_HaitoumeisaiKbn> haitoumeisaikbn = new ExDBFieldString<>("haitoumeisaikbn", this, UserType_C_HaitoumeisaiKbn.class);

    public final ExDBFieldNumber<IW_KhHaitouTaisyouWK, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_HaitoujyoutaiHanteiKbn> haitoujyoutaihanteikbn = new ExDBFieldString<>("haitoujyoutaihanteikbn", this, UserType_C_HaitoujyoutaiHanteiKbn.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, BizDate> haitoushrkijyunymd = new ExDBFieldString<>("haitoushrkijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldBizCurrency<IW_KhHaitouTaisyouWK> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldNumber<IW_KhHaitouTaisyouWK, Integer> haitoukaisuu = new ExDBFieldNumber<>("haitoukaisuu", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldNumber<IW_KhHaitouTaisyouWK, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<IW_KhHaitouTaisyouWK, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<IW_KhHaitouTaisyouWK, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, BizDateY> dratenendo = new ExDBFieldString<>("dratenendo", this, BizDateYType.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, BizDateY> keisandnendo = new ExDBFieldString<>("keisandnendo", this, BizDateYType.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldNumber<IW_KhHaitouTaisyouWK, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<IW_KhHaitouTaisyouWK, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);
}
