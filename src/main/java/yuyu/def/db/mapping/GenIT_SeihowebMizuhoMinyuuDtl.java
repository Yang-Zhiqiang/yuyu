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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.id.PKIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.meta.GenQIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.meta.QIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.type.UserType_C_DrtenChannelSyurui;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 生保Ｗｅｂ・みずほ用未入明細テーブル テーブルのマッピング情報クラスで、 {@link IT_SeihowebMizuhoMinyuuDtl} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SeihowebMizuhoMinyuuDtl}</td><td colspan="3">生保Ｗｅｂ・みずほ用未入明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SeihowebMizuhoMinyuuDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SeihowebMizuhoMinyuuDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKIT_SeihowebMizuhoMinyuuDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">{@link PKIT_SeihowebMizuhoMinyuuDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">{@link PKIT_SeihowebMizuhoMinyuuDtl ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMinyusyoriymd minyusyoriymd}</td><td>未入処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKydatkikbnkj kydatkikbnkj}</td><td>共同扱区分（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknm35keta kyknm35keta}</td><td>契約者名（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPjytym pjytym}</td><td>保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getAtesakinm atesakinm}</td><td>宛先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyujytymdyofuri minyujytymdyofuri}</td><td>未入充当年月（預振）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyujytymdyofuriigi minyujytymdyofuriigi}</td><td>未入充当年月（預振以外）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassinka hassinka}</td><td>発信課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTelno telno}</td><td>電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTntnm10keta tntnm10keta}</td><td>担当者名（１０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuukj hrkkaisuukj}</td><td>払込回数（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeirokj hrkkeirokj}</td><td>払込経路（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKnkimnyuuryu knkimnyuuryu}</td><td>今回未入理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJikaiminyuuji jikaiminyuuji}</td><td>次回未入時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTntusygyouhaiinfo tntusygyouhaiinfo}</td><td>担当者業廃情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeirobtjhmidasi hrkkeirobtjhmidasi}</td><td>払込経路別情報見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeirobtjh hrkkeirobtjh}</td><td>払込経路別情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyuruinm30keta hknsyuruinm30keta}</td><td>保険種類名（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDbskyoteiym dbskyoteiym}</td><td>ＤＢ削除予定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKeiyakuymd keiyakuymd}</td><td>契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHukkatukanoukknmnryymd hukkatukanoukknmnryymd}</td><td>復活可能期間満了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHjnkykhyj hjnkykhyj}</td><td>法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykjyutikbn kykjyutikbn}</td><td>契約状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinkihontikucd tsinkihontikucd}</td><td>通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjitsinkaiadr kanjitsinkaiadr}</td><td>漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJkiannaikg jkiannaikg}</td><td>次回案内金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYykknmnryymd yykknmnryymd}</td><td>猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkymd skymd}</td><td>失効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJhurikstkkahikbn jhurikstkkahikbn}</td><td>自動振替貸付可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHukkatumoskahikbn hukkatumoskahikbn}</td><td>復活申込可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdkkigenymd ttdkkigenymd}</td><td>手続き期限年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeikamon3keta keikamon3keta}</td><td>経過月数（３桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMisyuuhasseiym misyuuhasseiym}</td><td>未収発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMisyuujiyuu misyuujiyuu}</td><td>未収事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNexthurikaeymd nexthurikaeymd}</td><td>次回振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIkkatubaraikbn ikkatubaraikbn}</td><td>一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatubaraikaisuu ikkatubaraikaisuu}</td><td>一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>{@link #getBosyuudairitengyousyukbn bosyuudairitengyousyukbn}</td><td>募集代理店業種区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtenChannelSyurui}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SeihowebMizuhoMinyuuDtl
 * @see     PKIT_SeihowebMizuhoMinyuuDtl
 * @see     QIT_SeihowebMizuhoMinyuuDtl
 * @see     GenQIT_SeihowebMizuhoMinyuuDtl
 */
@MappedSuperclass
@Table(name=GenIT_SeihowebMizuhoMinyuuDtl.TABLE_NAME)
@IdClass(value=PKIT_SeihowebMizuhoMinyuuDtl.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_DrtenChannelSyurui", typeClass=UserType_C_DrtenChannelSyurui.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_IkkatubaraiKaisuuKbn", typeClass=UserType_C_IkkatubaraiKaisuuKbn.class),
    @TypeDef(name="UserType_C_IkkatubaraiKbn", typeClass=UserType_C_IkkatubaraiKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_SeihowebMizuhoMinyuuDtl extends AbstractExDBEntity<IT_SeihowebMizuhoMinyuuDtl, PKIT_SeihowebMizuhoMinyuuDtl> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SeihowebMizuhoMinyuuDtl";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String DRTENCD                  = "drtencd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String SYORIYM                  = "syoriym";
    public static final String MINYUSYORIYMD            = "minyusyoriymd";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String KYDATKIKBNKJ             = "kydatkikbnkj";
    public static final String KYKNM35KETA              = "kyknm35keta";
    public static final String CIFCD                    = "cifcd";
    public static final String PJYTYM                   = "pjytym";
    public static final String ATESAKINM                = "atesakinm";
    public static final String MINYUJYTYMDYOFURI        = "minyujytymdyofuri";
    public static final String MINYUJYTYMDYOFURIIGI     = "minyujytymdyofuriigi";
    public static final String HASSINKA                 = "hassinka";
    public static final String TELNO                    = "telno";
    public static final String TNTNM10KETA              = "tntnm10keta";
    public static final String HRKKAISUUKJ              = "hrkkaisuukj";
    public static final String HRKKEIROKJ               = "hrkkeirokj";
    public static final String HRKP                     = "hrkp";
    public static final String KNKIMNYUURYU             = "knkimnyuuryu";
    public static final String JIKAIMINYUUJI            = "jikaiminyuuji";
    public static final String TNTUSYGYOUHAIINFO        = "tntusygyouhaiinfo";
    public static final String HRKKEIROBTJHMIDASI       = "hrkkeirobtjhmidasi";
    public static final String HRKKEIROBTJH             = "hrkkeirobtjh";
    public static final String HKNSYURUINM30KETA        = "hknsyuruinm30keta";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String DBSKYOTEIYM              = "dbskyoteiym";
    public static final String KEIYAKUYMD               = "keiyakuymd";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HUKKATUKANOUKKNMNRYYMD   = "hukkatukanoukknmnryymd";
    public static final String HJNKYKHYJ                = "hjnkykhyj";
    public static final String KYKJYUTIKBN              = "kykjyutikbn";
    public static final String TSINKIHONTIKUCD          = "tsinkihontikucd";
    public static final String KANJITSINKAIADR          = "kanjitsinkaiadr";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String JKIANNAIKG               = "jkiannaikg";
    public static final String YYKKNMNRYYMD             = "yykknmnryymd";
    public static final String SKYMD                    = "skymd";
    public static final String JHURIKSTKKAHIKBN         = "jhurikstkkahikbn";
    public static final String HUKKATUMOSKAHIKBN        = "hukkatumoskahikbn";
    public static final String TTDKKIGENYMD             = "ttdkkigenymd";
    public static final String KEIKAMON3KETA            = "keikamon3keta";
    public static final String MISYUUHASSEIYM           = "misyuuhasseiym";
    public static final String MISYUUJIYUU              = "misyuujiyuu";
    public static final String NEXTHURIKAEYMD           = "nexthurikaeymd";
    public static final String IKKATUBARAIKBN           = "ikkatubaraikbn";
    public static final String IKKATUBARAIKAISUU        = "ikkatubaraikaisuu";
    public static final String BOSYUUDAIRITENGYOUSYUKBN = "bosyuudairitengyousyukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SeihowebMizuhoMinyuuDtl primaryKey;

    public GenIT_SeihowebMizuhoMinyuuDtl() {
        primaryKey = new PKIT_SeihowebMizuhoMinyuuDtl();
    }

    public GenIT_SeihowebMizuhoMinyuuDtl(
        String pKbnkey,
        String pSyono,
        String pDrtencd,
        String pBosyuucd,
        BizDateYM pSyoriym
    ) {
        primaryKey = new PKIT_SeihowebMizuhoMinyuuDtl(
            pKbnkey,
            pSyono,
            pDrtencd,
            pBosyuucd,
            pSyoriym
        );
    }

    @Transient
    @Override
    public PKIT_SeihowebMizuhoMinyuuDtl getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SeihowebMizuhoMinyuuDtl> getMetaClass() {
        return QIT_SeihowebMizuhoMinyuuDtl.class;
    }

    @Id
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return getPrimaryKey().getDrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        getPrimaryKey().setDrtencd(pDrtencd);
    }

    @Id
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return getPrimaryKey().getBosyuucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        getPrimaryKey().setBosyuucd(pBosyuucd);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.SYORIYM)
    public BizDateYM getSyoriym() {
        return getPrimaryKey().getSyoriym();
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        getPrimaryKey().setSyoriym(pSyoriym);
    }

    private BizDate minyusyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.MINYUSYORIYMD)
    public BizDate getMinyusyoriymd() {
        return minyusyoriymd;
    }

    public void setMinyusyoriymd(BizDate pMinyusyoriymd) {
        minyusyoriymd = pMinyusyoriymd;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private String kydatkikbnkj;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KYDATKIKBNKJ)
    public String getKydatkikbnkj() {
        return kydatkikbnkj;
    }

    public void setKydatkikbnkj(String pKydatkikbnkj) {
        kydatkikbnkj = pKydatkikbnkj;
    }

    private String kyknm35keta;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KYKNM35KETA)
    public String getKyknm35keta() {
        return kyknm35keta;
    }

    public void setKyknm35keta(String pKyknm35keta) {
        kyknm35keta = pKyknm35keta;
    }

    private String cifcd;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.CIFCD)
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

    private BizDateYM pjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.PJYTYM)
    public BizDateYM getPjytym() {
        return pjytym;
    }

    public void setPjytym(BizDateYM pPjytym) {
        pjytym = pPjytym;
    }

    private String atesakinm;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.ATESAKINM)
    public String getAtesakinm() {
        return atesakinm;
    }

    public void setAtesakinm(String pAtesakinm) {
        atesakinm = pAtesakinm;
    }

    private String minyujytymdyofuri;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.MINYUJYTYMDYOFURI)
    public String getMinyujytymdyofuri() {
        return minyujytymdyofuri;
    }

    public void setMinyujytymdyofuri(String pMinyujytymdyofuri) {
        minyujytymdyofuri = pMinyujytymdyofuri;
    }

    private String minyujytymdyofuriigi;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.MINYUJYTYMDYOFURIIGI)
    public String getMinyujytymdyofuriigi() {
        return minyujytymdyofuriigi;
    }

    public void setMinyujytymdyofuriigi(String pMinyujytymdyofuriigi) {
        minyujytymdyofuriigi = pMinyujytymdyofuriigi;
    }

    private String hassinka;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HASSINKA)
    public String getHassinka() {
        return hassinka;
    }

    public void setHassinka(String pHassinka) {
        hassinka = pHassinka;
    }

    private String telno;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.TELNO)
    public String getTelno() {
        return telno;
    }

    public void setTelno(String pTelno) {
        telno = pTelno;
    }

    private String tntnm10keta;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.TNTNM10KETA)
    public String getTntnm10keta() {
        return tntnm10keta;
    }

    public void setTntnm10keta(String pTntnm10keta) {
        tntnm10keta = pTntnm10keta;
    }

    private String hrkkaisuukj;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HRKKAISUUKJ)
    public String getHrkkaisuukj() {
        return hrkkaisuukj;
    }

    public void setHrkkaisuukj(String pHrkkaisuukj) {
        hrkkaisuukj = pHrkkaisuukj;
    }

    private String hrkkeirokj;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HRKKEIROKJ)
    public String getHrkkeirokj() {
        return hrkkeirokj;
    }

    public void setHrkkeirokj(String pHrkkeirokj) {
        hrkkeirokj = pHrkkeirokj;
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

    private String knkimnyuuryu;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KNKIMNYUURYU)
    public String getKnkimnyuuryu() {
        return knkimnyuuryu;
    }

    public void setKnkimnyuuryu(String pKnkimnyuuryu) {
        knkimnyuuryu = pKnkimnyuuryu;
    }

    private String jikaiminyuuji;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.JIKAIMINYUUJI)
    public String getJikaiminyuuji() {
        return jikaiminyuuji;
    }

    public void setJikaiminyuuji(String pJikaiminyuuji) {
        jikaiminyuuji = pJikaiminyuuji;
    }

    private String tntusygyouhaiinfo;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.TNTUSYGYOUHAIINFO)
    public String getTntusygyouhaiinfo() {
        return tntusygyouhaiinfo;
    }

    public void setTntusygyouhaiinfo(String pTntusygyouhaiinfo) {
        tntusygyouhaiinfo = pTntusygyouhaiinfo;
    }

    private String hrkkeirobtjhmidasi;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HRKKEIROBTJHMIDASI)
    public String getHrkkeirobtjhmidasi() {
        return hrkkeirobtjhmidasi;
    }

    public void setHrkkeirobtjhmidasi(String pHrkkeirobtjhmidasi) {
        hrkkeirobtjhmidasi = pHrkkeirobtjhmidasi;
    }

    private String hrkkeirobtjh;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HRKKEIROBTJH)
    public String getHrkkeirobtjh() {
        return hrkkeirobtjh;
    }

    public void setHrkkeirobtjh(String pHrkkeirobtjh) {
        hrkkeirobtjh = pHrkkeirobtjh;
    }

    private String hknsyuruinm30keta;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HKNSYURUINM30KETA)
    public String getHknsyuruinm30keta() {
        return hknsyuruinm30keta;
    }

    public void setHknsyuruinm30keta(String pHknsyuruinm30keta) {
        hknsyuruinm30keta = pHknsyuruinm30keta;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private BizDateYM dbskyoteiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.DBSKYOTEIYM)
    public BizDateYM getDbskyoteiym() {
        return dbskyoteiym;
    }

    public void setDbskyoteiym(BizDateYM pDbskyoteiym) {
        dbskyoteiym = pDbskyoteiym;
    }

    private BizDate keiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private String hhknnmkj;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private String tsintelno;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String dai2tsintelno;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.DAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private String bankcd;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private BizDate hukkatukanoukknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HUKKATUKANOUKKNMNRYYMD)
    public BizDate getHukkatukanoukknmnryymd() {
        return hukkatukanoukknmnryymd;
    }

    public void setHukkatukanoukknmnryymd(BizDate pHukkatukanoukknmnryymd) {
        hukkatukanoukknmnryymd = pHukkatukanoukknmnryymd;
    }

    private String hjnkykhyj;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HJNKYKHYJ)
    public String getHjnkykhyj() {
        return hjnkykhyj;
    }

    public void setHjnkykhyj(String pHjnkykhyj) {
        hjnkykhyj = pHjnkykhyj;
    }

    private String kykjyutikbn;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KYKJYUTIKBN)
    public String getKykjyutikbn() {
        return kykjyutikbn;
    }

    public void setKykjyutikbn(String pKykjyutikbn) {
        kykjyutikbn = pKykjyutikbn;
    }

    private String tsinkihontikucd;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.TSINKIHONTIKUCD)
    public String getTsinkihontikucd() {
        return tsinkihontikucd;
    }

    public void setTsinkihontikucd(String pTsinkihontikucd) {
        tsinkihontikucd = pTsinkihontikucd;
    }

    private String kanjitsinkaiadr;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KANJITSINKAIADR)
    public String getKanjitsinkaiadr() {
        return kanjitsinkaiadr;
    }

    public void setKanjitsinkaiadr(String pKanjitsinkaiadr) {
        kanjitsinkaiadr = pKanjitsinkaiadr;
    }

    private String kzmeiginmkn;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private BizCurrency jkiannaikg;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJkiannaikg() {
        return jkiannaikg;
    }

    public void setJkiannaikg(BizCurrency pJkiannaikg) {
        jkiannaikg = pJkiannaikg;
        jkiannaikgValue = null;
        jkiannaikgType  = null;
    }

    transient private BigDecimal jkiannaikgValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JKIANNAIKG, nullable=true)
    protected BigDecimal getJkiannaikgValue() {
        if (jkiannaikgValue == null && jkiannaikg != null) {
            if (jkiannaikg.isOptional()) return null;
            return jkiannaikg.absolute();
        }
        return jkiannaikgValue;
    }

    protected void setJkiannaikgValue(BigDecimal value) {
        jkiannaikgValue = value;
        jkiannaikg = Optional.fromNullable(toCurrencyType(jkiannaikgType))
            .transform(bizCurrencyTransformer(getJkiannaikgValue()))
            .orNull();
    }

    transient private String jkiannaikgType = null;

    @Column(name=JKIANNAIKG + "$", nullable=true)
    protected String getJkiannaikgType() {
        if (jkiannaikgType == null && jkiannaikg != null) return jkiannaikg.getType().toString();
        if (jkiannaikgType == null && getJkiannaikgValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jkiannaikg$' should not be NULL."));
        }
        return jkiannaikgType;
    }

    protected void setJkiannaikgType(String type) {
        jkiannaikgType = type;
        jkiannaikg = Optional.fromNullable(toCurrencyType(jkiannaikgType))
            .transform(bizCurrencyTransformer(getJkiannaikgValue()))
            .orNull();
    }

    private BizDate yykknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.YYKKNMNRYYMD)
    public BizDate getYykknmnryymd() {
        return yykknmnryymd;
    }

    @Trim("both")
    public void setYykknmnryymd(BizDate pYykknmnryymd) {
        yykknmnryymd = pYykknmnryymd;
    }

    private BizDate skymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.SKYMD)
    public BizDate getSkymd() {
        return skymd;
    }

    public void setSkymd(BizDate pSkymd) {
        skymd = pSkymd;
    }

    private String jhurikstkkahikbn;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.JHURIKSTKKAHIKBN)
    public String getJhurikstkkahikbn() {
        return jhurikstkkahikbn;
    }

    public void setJhurikstkkahikbn(String pJhurikstkkahikbn) {
        jhurikstkkahikbn = pJhurikstkkahikbn;
    }

    private String hukkatumoskahikbn;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.HUKKATUMOSKAHIKBN)
    public String getHukkatumoskahikbn() {
        return hukkatumoskahikbn;
    }

    public void setHukkatumoskahikbn(String pHukkatumoskahikbn) {
        hukkatumoskahikbn = pHukkatumoskahikbn;
    }

    private BizDate ttdkkigenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.TTDKKIGENYMD)
    public BizDate getTtdkkigenymd() {
        return ttdkkigenymd;
    }

    public void setTtdkkigenymd(BizDate pTtdkkigenymd) {
        ttdkkigenymd = pTtdkkigenymd;
    }

    private Integer keikamon3keta;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.KEIKAMON3KETA)
    public Integer getKeikamon3keta() {
        return keikamon3keta;
    }

    public void setKeikamon3keta(Integer pKeikamon3keta) {
        keikamon3keta = pKeikamon3keta;
    }

    private BizDateYM misyuuhasseiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.MISYUUHASSEIYM)
    public BizDateYM getMisyuuhasseiym() {
        return misyuuhasseiym;
    }

    public void setMisyuuhasseiym(BizDateYM pMisyuuhasseiym) {
        misyuuhasseiym = pMisyuuhasseiym;
    }

    private String misyuujiyuu;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.MISYUUJIYUU)
    public String getMisyuujiyuu() {
        return misyuujiyuu;
    }

    public void setMisyuujiyuu(String pMisyuujiyuu) {
        misyuujiyuu = pMisyuujiyuu;
    }

    private BizDate nexthurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.NEXTHURIKAEYMD)
    public BizDate getNexthurikaeymd() {
        return nexthurikaeymd;
    }

    public void setNexthurikaeymd(BizDate pNexthurikaeymd) {
        nexthurikaeymd = pNexthurikaeymd;
    }

    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Type(type="UserType_C_IkkatubaraiKbn")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.IKKATUBARAIKBN)
    public C_IkkatubaraiKbn getIkkatubaraikbn() {
        return ikkatubaraikbn;
    }

    public void setIkkatubaraikbn(C_IkkatubaraiKbn pIkkatubaraikbn) {
        ikkatubaraikbn = pIkkatubaraikbn;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Type(type="UserType_C_IkkatubaraiKaisuuKbn")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.IKKATUBARAIKAISUU)
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private C_DrtenChannelSyurui bosyuudairitengyousyukbn;

    @Type(type="UserType_C_DrtenChannelSyurui")
    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.BOSYUUDAIRITENGYOUSYUKBN)
    public C_DrtenChannelSyurui getBosyuudairitengyousyukbn() {
        return bosyuudairitengyousyukbn;
    }

    public void setBosyuudairitengyousyukbn(C_DrtenChannelSyurui pBosyuudairitengyousyukbn) {
        bosyuudairitengyousyukbn = pBosyuudairitengyousyukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SeihowebMizuhoMinyuuDtl.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}