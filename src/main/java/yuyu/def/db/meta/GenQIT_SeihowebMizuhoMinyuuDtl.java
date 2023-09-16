package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_DrtenChannelSyurui;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 生保Ｗｅｂ・みずほ用未入明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SeihowebMizuhoMinyuuDtl extends AbstractExDBTable<IT_SeihowebMizuhoMinyuuDtl> {

    public GenQIT_SeihowebMizuhoMinyuuDtl() {
        this("IT_SeihowebMizuhoMinyuuDtl");
    }

    public GenQIT_SeihowebMizuhoMinyuuDtl(String pAlias) {
        super("IT_SeihowebMizuhoMinyuuDtl", IT_SeihowebMizuhoMinyuuDtl.class, pAlias);
    }

    public String IT_SeihowebMizuhoMinyuuDtl() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDateYM> syoriym = new ExDBFieldString<>("syoriym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> minyusyoriymd = new ExDBFieldString<>("minyusyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kydatkikbnkj = new ExDBFieldString<>("kydatkikbnkj", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kyknm35keta = new ExDBFieldString<>("kyknm35keta", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDateYM> pjytym = new ExDBFieldString<>("pjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> atesakinm = new ExDBFieldString<>("atesakinm", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> minyujytymdyofuri = new ExDBFieldString<>("minyujytymdyofuri", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> minyujytymdyofuriigi = new ExDBFieldString<>("minyujytymdyofuriigi", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hassinka = new ExDBFieldString<>("hassinka", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> telno = new ExDBFieldString<>("telno", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> tntnm10keta = new ExDBFieldString<>("tntnm10keta", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hrkkaisuukj = new ExDBFieldString<>("hrkkaisuukj", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hrkkeirokj = new ExDBFieldString<>("hrkkeirokj", this);

    public final ExDBFieldBizCurrency<IT_SeihowebMizuhoMinyuuDtl> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> knkimnyuuryu = new ExDBFieldString<>("knkimnyuuryu", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> jikaiminyuuji = new ExDBFieldString<>("jikaiminyuuji", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> tntusygyouhaiinfo = new ExDBFieldString<>("tntusygyouhaiinfo", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hrkkeirobtjhmidasi = new ExDBFieldString<>("hrkkeirobtjhmidasi", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hrkkeirobtjh = new ExDBFieldString<>("hrkkeirobtjh", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hknsyuruinm30keta = new ExDBFieldString<>("hknsyuruinm30keta", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDateYM> dbskyoteiym = new ExDBFieldString<>("dbskyoteiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> hukkatukanoukknmnryymd = new ExDBFieldString<>("hukkatukanoukknmnryymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hjnkykhyj = new ExDBFieldString<>("hjnkykhyj", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kykjyutikbn = new ExDBFieldString<>("kykjyutikbn", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> tsinkihontikucd = new ExDBFieldString<>("tsinkihontikucd", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kanjitsinkaiadr = new ExDBFieldString<>("kanjitsinkaiadr", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldBizCurrency<IT_SeihowebMizuhoMinyuuDtl> jkiannaikg = new ExDBFieldBizCurrency<>("jkiannaikg", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> yykknmnryymd = new ExDBFieldString<>("yykknmnryymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> skymd = new ExDBFieldString<>("skymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> jhurikstkkahikbn = new ExDBFieldString<>("jhurikstkkahikbn", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> hukkatumoskahikbn = new ExDBFieldString<>("hukkatumoskahikbn", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> ttdkkigenymd = new ExDBFieldString<>("ttdkkigenymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_SeihowebMizuhoMinyuuDtl, Integer> keikamon3keta = new ExDBFieldNumber<>("keikamon3keta", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDateYM> misyuuhasseiym = new ExDBFieldString<>("misyuuhasseiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> misyuujiyuu = new ExDBFieldString<>("misyuujiyuu", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, BizDate> nexthurikaeymd = new ExDBFieldString<>("nexthurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, C_IkkatubaraiKbn> ikkatubaraikbn = new ExDBFieldString<>("ikkatubaraikbn", this, UserType_C_IkkatubaraiKbn.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, C_IkkatubaraiKaisuuKbn> ikkatubaraikaisuu = new ExDBFieldString<>("ikkatubaraikaisuu", this, UserType_C_IkkatubaraiKaisuuKbn.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, C_DrtenChannelSyurui> bosyuudairitengyousyukbn = new ExDBFieldString<>("bosyuudairitengyousyukbn", this, UserType_C_DrtenChannelSyurui.class);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SeihowebMizuhoMinyuuDtl, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
