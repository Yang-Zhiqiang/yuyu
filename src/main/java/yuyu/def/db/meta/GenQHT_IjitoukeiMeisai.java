package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_IjitoukeiKaijyoKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiTikShrTkykKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiZennouKbn;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_KokutiKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_SirajiKykKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 医事統計明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_IjitoukeiMeisai extends AbstractExDBTable<HT_IjitoukeiMeisai> {

    public GenQHT_IjitoukeiMeisai() {
        this("HT_IjitoukeiMeisai");
    }

    public GenQHT_IjitoukeiMeisai(String pAlias) {
        super("HT_IjitoukeiMeisai", HT_IjitoukeiMeisai.class, pAlias);
    }

    public String HT_IjitoukeiMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDate> idousyoriymd = new ExDBFieldString<>("idousyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_KokutiKbn> kokutikbn = new ExDBFieldString<>("kokutikbn", this, UserType_C_KokutiKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_SirajiKykKbn> sirajikykkbn = new ExDBFieldString<>("sirajikykkbn", this, UserType_C_SirajiKykKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> aatsukaishasoshikicd = new ExDBFieldString<>("aatsukaishasoshikicd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> aatukaikojincd = new ExDBFieldString<>("aatukaikojincd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_BosyuuDairitenAtkiKeitaiKbn> bosyuudairitenatkikeitaikbn = new ExDBFieldString<>("bosyuudairitenatkikeitaikbn", this, UserType_C_BosyuuDairitenAtkiKeitaiKbn.class);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> hhkntodouhukencd = new ExDBFieldString<>("hhkntodouhukencd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_NensyuuKbn> hhknnensyuukbn = new ExDBFieldString<>("hhknnensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> sintyou = new ExDBFieldNumber<>("sintyou", this);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> taijyuu = new ExDBFieldNumber<>("taijyuu", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_KituenKbn> kituenkbn = new ExDBFieldString<>("kituenkbn", this, UserType_C_KituenKbn.class);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> kituenhon = new ExDBFieldNumber<>("kituenhon", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> seitoukihons = new ExDBFieldBizCurrency<>("seitoukihons", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> seitoukihonsmanen = new ExDBFieldBizCurrency<>("seitoukihonsmanen", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> syutkp = new ExDBFieldBizCurrency<>("syutkp", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> syutkpmanen = new ExDBFieldBizCurrency<>("syutkpmanen", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> imustiyusbus = new ExDBFieldBizCurrency<>("imustiyusbus", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> imustiyusbusmanen = new ExDBFieldBizCurrency<>("imustiyusbusmanen", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizNumber> yenkansantkykwsrate = new ExDBFieldString<>("yenkansantkykwsrate", this, BizNumberType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> syoubyoucd1 = new ExDBFieldString<>("syoubyoucd1", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> syoubyoucd2 = new ExDBFieldString<>("syoubyoucd2", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Ketkekkacd> dakuhiktkekkacd = new ExDBFieldString<>("dakuhiktkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> dakuhiketsyacd = new ExDBFieldString<>("dakuhiketsyacd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Tkhukaumu> syksbyensitihsyutkhkkbn = new ExDBFieldString<>("syksbyensitihsyutkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Tkhukaumu> jyudkaigomehrtkhkkbn = new ExDBFieldString<>("jyudkaigomehrtkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> symtgenincd = new ExDBFieldString<>("symtgenincd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> siincd = new ExDBFieldString<>("siincd", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_IjitoukeiKaijyoKbn> ijitoukeikaijyokbn = new ExDBFieldString<>("ijitoukeikaijyokbn", this, UserType_C_IjitoukeiKaijyoKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, BizDateYM> sysnikoujiym = new ExDBFieldString<>("sysnikoujiym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_IjitoukeiZennouKbn> ijitoukeizennoukbn = new ExDBFieldString<>("ijitoukeizennoukbn", this, UserType_C_IjitoukeiZennouKbn.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> jissituhosyous = new ExDBFieldBizCurrency<>("jissituhosyous", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> jissituhosyousmanen = new ExDBFieldBizCurrency<>("jissituhosyousmanen", this);

    public final ExDBFieldNumber<HT_IjitoukeiMeisai, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, C_IjitoukeiTikShrTkykKbn> ijitoukeitikshrtkykkbn = new ExDBFieldString<>("ijitoukeitikshrtkykkbn", this, UserType_C_IjitoukeiTikShrTkykKbn.class);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> teikisiharaikin = new ExDBFieldBizCurrency<>("teikisiharaikin", this);

    public final ExDBFieldBizCurrency<HT_IjitoukeiMeisai> teikisiharaikinmanen = new ExDBFieldBizCurrency<>("teikisiharaikinmanen", this);

    public final ExDBFieldString<HT_IjitoukeiMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
