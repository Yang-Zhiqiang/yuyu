package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Delflag;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_NykshrKbn;
import yuyu.def.db.type.UserType_C_Nyktrksflg;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_ShrsyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動用履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_SikinIdouRireki extends AbstractExDBTable<BT_SikinIdouRireki> {

    public GenQBT_SikinIdouRireki() {
        this("BT_SikinIdouRireki");
    }

    public GenQBT_SikinIdouRireki(String pAlias) {
        super("BT_SikinIdouRireki", BT_SikinIdouRireki.class, pAlias);
    }

    public String BT_SikinIdouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_SikinIdouRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, String> keirisyorirenno = new ExDBFieldString<>("keirisyorirenno", this);

    public final ExDBFieldString<BT_SikinIdouRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_SikinIdouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<BT_SikinIdouRireki, String> targetKinouId = new ExDBFieldString<>("targetKinouId", this);

    public final ExDBFieldString<BT_SikinIdouRireki, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldNumber<BT_SikinIdouRireki, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Delflag> sakujyoflg = new ExDBFieldString<>("sakujyoflg", this, UserType_C_Delflag.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_NykshrKbn> nykshrkbn = new ExDBFieldString<>("nykshrkbn", this, UserType_C_NykshrKbn.class);

    public final ExDBFieldString<BT_SikinIdouRireki, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BT_SikinIdouRireki, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_SikinIdouRireki, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<BT_SikinIdouRireki, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BT_SikinIdouRireki, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<BT_SikinIdouRireki, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<BT_SikinIdouRireki, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDateYM> phendoukaisiym = new ExDBFieldString<>("phendoukaisiym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<BT_SikinIdouRireki> phendoumaegk = new ExDBFieldBizCurrency<>("phendoumaegk", this);

    public final ExDBFieldBizCurrency<BT_SikinIdouRireki> phendougogk = new ExDBFieldBizCurrency<>("phendougogk", this);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDate> seirituymd = new ExDBFieldString<>("seirituymd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDateYM> misyuupjyuutouym = new ExDBFieldString<>("misyuupjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_ShrsyoriKbn> shrsyorikbn = new ExDBFieldString<>("shrsyorikbn", this, UserType_C_ShrsyoriKbn.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDateYM> jyutoustartym = new ExDBFieldString<>("jyutoustartym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, BizDateYM> jyutouendym = new ExDBFieldString<>("jyutouendym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<BT_SikinIdouRireki, C_Nyktrksflg> nyktrksflg = new ExDBFieldString<>("nyktrksflg", this, UserType_C_Nyktrksflg.class);

    public final ExDBFieldBizCurrency<BT_SikinIdouRireki> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldBizCurrency<BT_SikinIdouRireki> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);
}
