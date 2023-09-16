package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.id.PKSV_BikinIdouMeisai;
import yuyu.def.db.meta.GenQSV_BikinIdouMeisai;
import yuyu.def.db.meta.QSV_BikinIdouMeisai;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 備金異動明細情報ビュー テーブルのマッピング情報クラスで、 {@link SV_BikinIdouMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_BikinIdouMeisai}</td><td colspan="3">備金異動明細情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKSV_BikinIdouMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFstpnyknymd fstpnyknymd}</td><td>初回保険料入金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenbunumu drtenbunumu}</td><td>代理店分担有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyksakuinmeino kyksakuinmeino}</td><td>契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKkkyktdk kkkyktdk}</td><td>契約管理契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkumu stdrsktkyhkumu}</td><td>被保険者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkymd stdrsktkyhkymd}</td><td>被保険者代理特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaumu jyudkaigomeharaitkhukaumu}</td><td>重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkhkumu targettkhkumu}</td><td>ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkykkykhenkoymd targettkykkykhenkoymd}</td><td>ターゲット特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTargettkykkijyungk targettkykkijyungk}</td><td>ターゲット特約基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaumu kykdrtkykhukaumu}</td><td>契約者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaymd kykdrtkykhukaymd}</td><td>契約者代理特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykdrtkykkaiyakuymd kykdrtkykkaiyakuymd}</td><td>契約者代理特約解約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTeikishrtkykhukaumu teikishrtkykhukaumu}</td><td>定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBknrigikbn bknrigikbn}</td><td>備金例外区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknrigiKbn}</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkngk bkngk}</td><td>備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBknjkukbn bknjkukbn}</td><td>備金時効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknJkuKbn}</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSitihsyutkyumaeyenhknkngk sitihsyutkyumaeyenhknkngk}</td><td>最低保証適用前円換算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSiinkbn siinkbn}</td><td>死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiinKbn}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">{@link PKSV_BikinIdouMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">{@link PKSV_BikinIdouMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     SV_BikinIdouMeisai
 * @see     PKSV_BikinIdouMeisai
 * @see     QSV_BikinIdouMeisai
 * @see     GenQSV_BikinIdouMeisai
 */
@MappedSuperclass
@Table(name=GenSV_BikinIdouMeisai.TABLE_NAME)
@IdClass(value=PKSV_BikinIdouMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BknJkuKbn", typeClass=UserType_C_BknJkuKbn.class),
    @TypeDef(name="UserType_C_BkncdKbn", typeClass=UserType_C_BkncdKbn.class),
    @TypeDef(name="UserType_C_BknrigiKbn", typeClass=UserType_C_BknrigiKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_SiinKbn", typeClass=UserType_C_SiinKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_BikinIdouMeisai extends AbstractExDBEntity<SV_BikinIdouMeisai, PKSV_BikinIdouMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_BikinIdouMeisai";
    public static final String SYONO                    = "syono";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String HRKP                     = "hrkp";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String CIFCD                    = "cifcd";
    public static final String FSTPNYKNYMD              = "fstpnyknymd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENBUNUMU              = "drtenbunumu";
    public static final String KYKSAKUINMEINO           = "kyksakuinmeino";
    public static final String KKKYKTDK                 = "kkkyktdk";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String STDRSKTKYHKUMU           = "stdrsktkyhkumu";
    public static final String STDRSKTKYHKYMD           = "stdrsktkyhkymd";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String JYUDKAIGOMEHARAITKHUKAUMU = "jyudkaigomeharaitkhukaumu";
    public static final String TARGETTKHKUMU            = "targettkhkumu";
    public static final String TARGETTKYKKYKHENKOYMD    = "targettkykkykhenkoymd";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String TARGETTKYKKIJYUNGK       = "targettkykkijyungk";
    public static final String KYKDRTKYKHUKAUMU         = "kykdrtkykhukaumu";
    public static final String KYKDRTKYKHUKAYMD         = "kykdrtkykhukaymd";
    public static final String KYKDRTKYKKAIYAKUYMD      = "kykdrtkykkaiyakuymd";
    public static final String TEIKISHRTKYKHUKAUMU      = "teikishrtkykhukaumu";
    public static final String KESSANKIJYUNYMD          = "kessankijyunymd";
    public static final String BKNCDKBN                 = "bkncdkbn";
    public static final String BKNKKTYMD                = "bknkktymd";
    public static final String RENNO                    = "renno";
    public static final String BKNRIGIKBN               = "bknrigikbn";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SKNO                     = "skno";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String BKNGK                    = "bkngk";
    public static final String BKNJKUKBN                = "bknjkukbn";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String SITIHSYUTKYUMAEYENHKNKNGK = "sitihsyutkyumaeyenhknkngk";
    public static final String SIINKBN                  = "siinkbn";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String ZENNOUKIKAN              = "zennoukikan";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String YENDTHNKYMD              = "yendthnkymd";

    private final PKSV_BikinIdouMeisai primaryKey;

    public GenSV_BikinIdouMeisai() {
        primaryKey = new PKSV_BikinIdouMeisai();
    }

    public GenSV_BikinIdouMeisai(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        primaryKey = new PKSV_BikinIdouMeisai(
            pSyono,
            pGyoumuKousinKinou,
            pGyoumuKousinTime
        );
    }

    @Transient
    @Override
    public PKSV_BikinIdouMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_BikinIdouMeisai> getMetaClass() {
        return QSV_BikinIdouMeisai.class;
    }

    @Id
    @Column(name=GenSV_BikinIdouMeisai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_BikinIdouMeisai.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_BikinIdouMeisai.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_BikinIdouMeisai.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private String hhknsykgycd;

    @Column(name=GenSV_BikinIdouMeisai.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenSV_BikinIdouMeisai.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private String cifcd;

    @Column(name=GenSV_BikinIdouMeisai.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private BizDate fstpnyknymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.FSTPNYKNYMD)
    public BizDate getFstpnyknymd() {
        return fstpnyknymd;
    }

    public void setFstpnyknymd(BizDate pFstpnyknymd) {
        fstpnyknymd = pFstpnyknymd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_BikinIdouMeisai.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_BikinIdouMeisai.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenSV_BikinIdouMeisai.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenSV_BikinIdouMeisai.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private String drtencd;

    @Column(name=GenSV_BikinIdouMeisai.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenSV_BikinIdouMeisai.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_BikinIdouMeisai.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private C_UmuKbn drtenbunumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.DRTENBUNUMU)
    public C_UmuKbn getDrtenbunumu() {
        return drtenbunumu;
    }

    public void setDrtenbunumu(C_UmuKbn pDrtenbunumu) {
        drtenbunumu = pDrtenbunumu;
    }

    private String kyksakuinmeino;

    @Column(name=GenSV_BikinIdouMeisai.KYKSAKUINMEINO)
    public String getKyksakuinmeino() {
        return kyksakuinmeino;
    }

    public void setKyksakuinmeino(String pKyksakuinmeino) {
        kyksakuinmeino = pKyksakuinmeino;
    }

    private C_Tdk kkkyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenSV_BikinIdouMeisai.KKKYKTDK)
    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        kkkyktdk = pKkkyktdk;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenSV_BikinIdouMeisai.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private String palketsyacd;

    @Column(name=GenSV_BikinIdouMeisai.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private C_UmuKbn stdrsktkyhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.STDRSKTKYHKUMU)
    public C_UmuKbn getStdrsktkyhkumu() {
        return stdrsktkyhkumu;
    }

    public void setStdrsktkyhkumu(C_UmuKbn pStdrsktkyhkumu) {
        stdrsktkyhkumu = pStdrsktkyhkumu;
    }

    private BizDate stdrsktkyhkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.STDRSKTKYHKYMD)
    public BizDate getStdrsktkyhkymd() {
        return stdrsktkyhkymd;
    }

    @Trim("both")
    public void setStdrsktkyhkymd(BizDate pStdrsktkyhkymd) {
        stdrsktkyhkymd = pStdrsktkyhkymd;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.JYUDKAIGOMEHARAITKHUKAUMU)
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {
        return jyudkaigomeharaitkhukaumu;
    }

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu) {
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
    }

    private C_UmuKbn targettkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.TARGETTKHKUMU)
    public C_UmuKbn getTargettkhkumu() {
        return targettkhkumu;
    }

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        targettkhkumu = pTargettkhkumu;
    }

    private BizDate targettkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.TARGETTKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getTargettkykkykhenkoymd() {
        return targettkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        targettkykkykhenkoymd = pTargettkykkykhenkoymd;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenSV_BikinIdouMeisai.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private BizCurrency targettkykkijyungk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTargettkykkijyungk() {
        return targettkykkijyungk;
    }

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        targettkykkijyungk = pTargettkykkijyungk;
        targettkykkijyungkValue = null;
        targettkykkijyungkType  = null;
    }

    transient private BigDecimal targettkykkijyungkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TARGETTKYKKIJYUNGK, nullable=true)
    protected BigDecimal getTargettkykkijyungkValue() {
        if (targettkykkijyungkValue == null && targettkykkijyungk != null) {
            if (targettkykkijyungk.isOptional()) return null;
            return targettkykkijyungk.absolute();
        }
        return targettkykkijyungkValue;
    }

    protected void setTargettkykkijyungkValue(BigDecimal value) {
        targettkykkijyungkValue = value;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    transient private String targettkykkijyungkType = null;

    @Column(name=TARGETTKYKKIJYUNGK + "$", nullable=true)
    protected String getTargettkykkijyungkType() {
        if (targettkykkijyungkType == null && targettkykkijyungk != null) return targettkykkijyungk.getType().toString();
        if (targettkykkijyungkType == null && getTargettkykkijyungkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'targettkykkijyungk$' should not be NULL."));
        }
        return targettkykkijyungkType;
    }

    protected void setTargettkykkijyungkType(String type) {
        targettkykkijyungkType = type;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    private C_UmuKbn kykdrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.KYKDRTKYKHUKAUMU)
    public C_UmuKbn getKykdrtkykhukaumu() {
        return kykdrtkykhukaumu;
    }

    public void setKykdrtkykhukaumu(C_UmuKbn pKykdrtkykhukaumu) {
        kykdrtkykhukaumu = pKykdrtkykhukaumu;
    }

    private BizDate kykdrtkykhukaymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.KYKDRTKYKHUKAYMD)
    @ValidDate
    public BizDate getKykdrtkykhukaymd() {
        return kykdrtkykhukaymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtkykhukaymd(BizDate pKykdrtkykhukaymd) {
        kykdrtkykhukaymd = pKykdrtkykhukaymd;
    }

    private BizDate kykdrtkykkaiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.KYKDRTKYKKAIYAKUYMD)
    @ValidDate
    public BizDate getKykdrtkykkaiyakuymd() {
        return kykdrtkykkaiyakuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtkykkaiyakuymd(BizDate pKykdrtkykkaiyakuymd) {
        kykdrtkykkaiyakuymd = pKykdrtkykkaiyakuymd;
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinIdouMeisai.TEIKISHRTKYKHUKAUMU)
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    private BizDate kessankijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.KESSANKIJYUNYMD)
    @ValidDate
    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    @Trim("both")
    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }

    private C_BkncdKbn bkncdkbn;

    @Type(type="UserType_C_BkncdKbn")
    @Column(name=GenSV_BikinIdouMeisai.BKNCDKBN)
    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }

    private BizDate bknkktymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.BKNKKTYMD)
    @ValidDate
    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
    }

    private Integer renno;

    @Column(name=GenSV_BikinIdouMeisai.RENNO)
    public Integer getRenno() {
        return renno;
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    private C_BknrigiKbn bknrigikbn;

    @Type(type="UserType_C_BknrigiKbn")
    @Column(name=GenSV_BikinIdouMeisai.BKNRIGIKBN)
    public C_BknrigiKbn getBknrigikbn() {
        return bknrigikbn;
    }

    public void setBknrigikbn(C_BknrigiKbn pBknrigikbn) {
        bknrigikbn = pBknrigikbn;
    }

    private String henkousikibetukey;

    @Column(name=GenSV_BikinIdouMeisai.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private String skno;

    @Column(name=GenSV_BikinIdouMeisai.SKNO)
    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private BizCurrency bkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getBkngk() {
        return bkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBkngk(BizCurrency pBkngk) {
        bkngk = pBkngk;
        bkngkValue = null;
        bkngkType  = null;
    }

    transient private BigDecimal bkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=BKNGK, nullable=true)
    protected BigDecimal getBkngkValue() {
        if (bkngkValue == null && bkngk != null) {
            if (bkngk.isOptional()) return null;
            return bkngk.absolute();
        }
        return bkngkValue;
    }

    protected void setBkngkValue(BigDecimal value) {
        bkngkValue = value;
        bkngk = Optional.fromNullable(toCurrencyType(bkngkType))
            .transform(bizCurrencyTransformer(getBkngkValue()))
            .orNull();
    }

    transient private String bkngkType = null;

    @Column(name=BKNGK + "$", nullable=true)
    protected String getBkngkType() {
        if (bkngkType == null && bkngk != null) return bkngk.getType().toString();
        if (bkngkType == null && getBkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'bkngk$' should not be NULL."));
        }
        return bkngkType;
    }

    protected void setBkngkType(String type) {
        bkngkType = type;
        bkngk = Optional.fromNullable(toCurrencyType(bkngkType))
            .transform(bizCurrencyTransformer(getBkngkValue()))
            .orNull();
    }

    private C_BknJkuKbn bknjkukbn;

    @Type(type="UserType_C_BknJkuKbn")
    @Column(name=GenSV_BikinIdouMeisai.BKNJKUKBN)
    public C_BknJkuKbn getBknjkukbn() {
        return bknjkukbn;
    }

    public void setBknjkukbn(C_BknJkuKbn pBknjkukbn) {
        bknjkukbn = pBknjkukbn;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_BikinIdouMeisai.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenSV_BikinIdouMeisai.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizCurrency sitihsyutkyumaeyenhknkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSitihsyutkyumaeyenhknkngk() {
        return sitihsyutkyumaeyenhknkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitihsyutkyumaeyenhknkngk(BizCurrency pSitihsyutkyumaeyenhknkngk) {
        sitihsyutkyumaeyenhknkngk = pSitihsyutkyumaeyenhknkngk;
        sitihsyutkyumaeyenhknkngkValue = null;
        sitihsyutkyumaeyenhknkngkType  = null;
    }

    transient private BigDecimal sitihsyutkyumaeyenhknkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK, nullable=true)
    protected BigDecimal getSitihsyutkyumaeyenhknkngkValue() {
        if (sitihsyutkyumaeyenhknkngkValue == null && sitihsyutkyumaeyenhknkngk != null) {
            if (sitihsyutkyumaeyenhknkngk.isOptional()) return null;
            return sitihsyutkyumaeyenhknkngk.absolute();
        }
        return sitihsyutkyumaeyenhknkngkValue;
    }

    protected void setSitihsyutkyumaeyenhknkngkValue(BigDecimal value) {
        sitihsyutkyumaeyenhknkngkValue = value;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    transient private String sitihsyutkyumaeyenhknkngkType = null;

    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK + "$", nullable=true)
    protected String getSitihsyutkyumaeyenhknkngkType() {
        if (sitihsyutkyumaeyenhknkngkType == null && sitihsyutkyumaeyenhknkngk != null) return sitihsyutkyumaeyenhknkngk.getType().toString();
        if (sitihsyutkyumaeyenhknkngkType == null && getSitihsyutkyumaeyenhknkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sitihsyutkyumaeyenhknkngk$' should not be NULL."));
        }
        return sitihsyutkyumaeyenhknkngkType;
    }

    protected void setSitihsyutkyumaeyenhknkngkType(String type) {
        sitihsyutkyumaeyenhknkngkType = type;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    private C_SiinKbn siinkbn;

    @Type(type="UserType_C_SiinKbn")
    @Column(name=GenSV_BikinIdouMeisai.SIINKBN)
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_BikinIdouMeisai.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    private String zennoukikan;

    @Column(name=GenSV_BikinIdouMeisai.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }

    @Id
    @Column(name=GenSV_BikinIdouMeisai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return getPrimaryKey().getGyoumuKousinKinou();
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        getPrimaryKey().setGyoumuKousinKinou(pGyoumuKousinKinou);
    }

    @Id
    @Column(name=GenSV_BikinIdouMeisai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return getPrimaryKey().getGyoumuKousinTime();
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        getPrimaryKey().setGyoumuKousinTime(pGyoumuKousinTime);
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinIdouMeisai.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }
}