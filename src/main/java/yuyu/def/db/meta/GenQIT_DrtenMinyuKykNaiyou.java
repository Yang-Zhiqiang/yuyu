package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.db.type.UserType_C_DrtenChannelSyurui;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 代理店未入契約明細内容テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_DrtenMinyuKykNaiyou extends AbstractExDBTable<IT_DrtenMinyuKykNaiyou> {

    public GenQIT_DrtenMinyuKykNaiyou() {
        this("IT_DrtenMinyuKykNaiyou");
    }

    public GenQIT_DrtenMinyuKykNaiyou(String pAlias) {
        super("IT_DrtenMinyuKykNaiyou", IT_DrtenMinyuKykNaiyou.class, pAlias);
    }

    public String IT_DrtenMinyuKykNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDateYM> syoriym = new ExDBFieldString<>("syoriym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> syuukeikbn = new ExDBFieldString<>("syuukeikbn", this);

    public final ExDBFieldNumber<IT_DrtenMinyuKykNaiyou, Integer> minyukaisuu = new ExDBFieldNumber<>("minyukaisuu", this);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykNaiyou> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykNaiyou> hsys = new ExDBFieldBizCurrency<>("hsys", this);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykNaiyou> syuuseis = new ExDBFieldBizCurrency<>("syuuseis", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> hukkatutyuuikbn = new ExDBFieldString<>("hukkatutyuuikbn", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> mrarihyj = new ExDBFieldString<>("mrarihyj", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> fstttkekykhyj = new ExDBFieldString<>("fstttkekykhyj", this);

    public final ExDBFieldNumber<IT_DrtenMinyuKykNaiyou, Integer> ttkernzkkaisuu = new ExDBFieldNumber<>("ttkernzkkaisuu", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> keizokutyuuihyj = new ExDBFieldString<>("keizokutyuuihyj", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> syouhinbunruikbn = new ExDBFieldString<>("syouhinbunruikbn", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> syouhnnmkbn = new ExDBFieldString<>("syouhnnmkbn", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> autocallkykhyj = new ExDBFieldString<>("autocallkykhyj", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_BosyuuDairitenAtkiKeitaiKbn> bosyuudairitenatkikeitaikbn = new ExDBFieldString<>("bosyuudairitenatkikeitaikbn", this, UserType_C_BosyuuDairitenAtkiKeitaiKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> drtenkanrisosikicd1 = new ExDBFieldString<>("drtenkanrisosikicd1", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> drtenkanrisosikicd2 = new ExDBFieldString<>("drtenkanrisosikicd2", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_DrtenChannelSyurui> drtenchannelsyuruikbn1 = new ExDBFieldString<>("drtenchannelsyuruikbn1", this, UserType_C_DrtenChannelSyurui.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_DrtenChannelSyurui> drtenchannelsyuruikbn2 = new ExDBFieldString<>("drtenchannelsyuruikbn2", this, UserType_C_DrtenChannelSyurui.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> bosyuucd1 = new ExDBFieldString<>("bosyuucd1", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> bosyuucd2 = new ExDBFieldString<>("bosyuucd2", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDate> bosyuuningyouhaiymd1 = new ExDBFieldString<>("bosyuuningyouhaiymd1", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDate> bosyuuningyouhaiymd2 = new ExDBFieldString<>("bosyuuningyouhaiymd2", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> kydatkikbnkj = new ExDBFieldString<>("kydatkikbnkj", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_IkkatubaraiKbn> ikkatubaraikbn = new ExDBFieldString<>("ikkatubaraikbn", this, UserType_C_IkkatubaraiKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_IkkatubaraiKaisuuKbn> ikkatubaraikaisuu = new ExDBFieldString<>("ikkatubaraikaisuu", this, UserType_C_IkkatubaraiKaisuuKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDate> yykknmnryymd = new ExDBFieldString<>("yykknmnryymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> kyknm35keta = new ExDBFieldString<>("kyknm35keta", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> tsinkihontikucd = new ExDBFieldString<>("tsinkihontikucd", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> kanjitsinkaiadr = new ExDBFieldString<>("kanjitsinkaiadr", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDate> nexthurikaeymd = new ExDBFieldString<>("nexthurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDate> minyusyoriymd = new ExDBFieldString<>("minyusyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykNaiyou> jkiannaikg = new ExDBFieldBizCurrency<>("jkiannaikg", this);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykNaiyou> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_DrtenMinyuKykNaiyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
