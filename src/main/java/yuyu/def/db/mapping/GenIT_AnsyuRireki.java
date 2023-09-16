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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_SyuyakukyohiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.id.PKIT_AnsyuRireki;
import yuyu.def.db.meta.GenQIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.type.UserType_C_AnnaijkKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Skszumiflg;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_SyuyakukyohiKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納履歴テーブル テーブルのマッピング情報クラスで、 {@link IT_AnsyuRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AnsyuRireki}</td><td colspan="3">案内収納履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_AnsyuRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_AnsyuRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">{@link PKIT_AnsyuRireki ○}</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">{@link PKIT_AnsyuRireki ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getAnnaino annaino}</td><td>案内番号</td><td align="center">{@link PKIT_AnsyuRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRyosyukwsratekjymd ryosyukwsratekjymd}</td><td>領収為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyukwsrate ryosyukwsrate}</td><td>領収為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIktwaribikikgk iktwaribikikgk}</td><td>一括割引料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAnnaijkkbn annaijkkbn}</td><td>案内状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AnnaijkKbn}</td></tr>
 *  <tr><td>{@link #getAnnaisakuseiymd annaisakuseiymd}</td><td>案内作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMinyusyoriymd minyusyoriymd}</td><td>未入処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDattaiuktkymd dattaiuktkymd}</td><td>脱退受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHurihunokbn hurihunokbn}</td><td>振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HurihunoKbn}</td></tr>
 *  <tr><td>{@link #getUriageymdkon uriageymdkon}</td><td>売上日（今回）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKrkkeijyoflg krkkeijyoflg}</td><td>仮受計上フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKrkkeijyoymd krkkeijyoymd}</td><td>仮受計上処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinkeizkkbn sinkeizkkbn}</td><td>新規継続区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinkeizkKbn}</td></tr>
 *  <tr><td>{@link #getSyuyakukyohikbn syuyakukyohikbn}</td><td>集約拒否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuyakukyohiKbn}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYukoukachkymd yukoukachkymd}</td><td>有効性確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAuthorikanryoymd authorikanryoymd}</td><td>オーソリ完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUriageymdzen uriageymdzen}</td><td>売上日（前回）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkigen hrkkigen}</td><td>払込期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMinyutuutizumiflg minyutuutizumiflg}</td><td>未入通知作成済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Skszumiflg}</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredituriagengjiyuu credituriagengjiyuu}</td><td>クレジットカード売上請求ＮＧ事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AnsyuRireki
 * @see     PKIT_AnsyuRireki
 * @see     QIT_AnsyuRireki
 * @see     GenQIT_AnsyuRireki
 */
@MappedSuperclass
@Table(name=GenIT_AnsyuRireki.TABLE_NAME)
@IdClass(value=PKIT_AnsyuRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AnnaijkKbn", typeClass=UserType_C_AnnaijkKbn.class),
    @TypeDef(name="UserType_C_CreditUriageNgJiyuuKbn", typeClass=UserType_C_CreditUriageNgJiyuuKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_HurihunoKbn", typeClass=UserType_C_HurihunoKbn.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_SinkeizkKbn", typeClass=UserType_C_SinkeizkKbn.class),
    @TypeDef(name="UserType_C_Skszumiflg", typeClass=UserType_C_Skszumiflg.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_SyuyakukyohiKbn", typeClass=UserType_C_SyuyakukyohiKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_AnsyuRireki extends AbstractExDBEntity<IT_AnsyuRireki, PKIT_AnsyuRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_AnsyuRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String ANNAINO                  = "annaino";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String RSGAKU                   = "rsgaku";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String RYOSYUKWSRATEKJYMD       = "ryosyukwsratekjymd";
    public static final String RYOSYUKWSRATE            = "ryosyukwsrate";
    public static final String HRKP                     = "hrkp";
    public static final String IKTWARIBIKIKGK           = "iktwaribikikgk";
    public static final String ANNAIJKKBN               = "annaijkkbn";
    public static final String ANNAISAKUSEIYMD          = "annaisakuseiymd";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String MINYUSYORIYMD            = "minyusyoriymd";
    public static final String DATTAIUKTKYMD            = "dattaiuktkymd";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String HURIHUNOKBN              = "hurihunokbn";
    public static final String URIAGEYMDKON             = "uriageymdkon";
    public static final String KRKKEIJYOFLG             = "krkkeijyoflg";
    public static final String KRKKEIJYOYMD             = "krkkeijyoymd";
    public static final String KRKNO                    = "krkno";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String SINKEIZKKBN              = "sinkeizkkbn";
    public static final String SYUYAKUKYOHIKBN          = "syuyakukyohikbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String YUKOUKACHKYMD            = "yukoukachkymd";
    public static final String AUTHORIKANRYOYMD         = "authorikanryoymd";
    public static final String URIAGEYMDZEN             = "uriageymdzen";
    public static final String HRKKIGEN                 = "hrkkigen";
    public static final String MINYUTUUTIZUMIFLG        = "minyutuutizumiflg";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CREDITURIAGENGJIYUU      = "credituriagengjiyuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_AnsyuRireki primaryKey;

    public GenIT_AnsyuRireki() {
        primaryKey = new PKIT_AnsyuRireki();
    }

    public GenIT_AnsyuRireki(
        String pKbnkey,
        String pSyono,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym,
        Integer pAnnaino
    ) {
        primaryKey = new PKIT_AnsyuRireki(
            pKbnkey,
            pSyono,
            pNyknaiyoukbn,
            pJyuutouym,
            pAnnaino
        );
    }

    @Transient
    @Override
    public PKIT_AnsyuRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_AnsyuRireki> getMetaClass() {
        return QIT_AnsyuRireki.class;
    }

    @Id
    @Column(name=GenIT_AnsyuRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_AnsyuRireki.SYONO)
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
    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_AnsyuRireki.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return getPrimaryKey().getNyknaiyoukbn();
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        getPrimaryKey().setNyknaiyoukbn(pNyknaiyoukbn);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_AnsyuRireki.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return getPrimaryKey().getJyuutouym();
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        getPrimaryKey().setJyuutouym(pJyuutouym);
    }

    @Id
    @Column(name=GenIT_AnsyuRireki.ANNAINO)
    public Integer getAnnaino() {
        return getPrimaryKey().getAnnaino();
    }

    public void setAnnaino(Integer pAnnaino) {
        getPrimaryKey().setAnnaino(pAnnaino);
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_AnsyuRireki.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_AnsyuRireki.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_AnsyuRireki.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private BizCurrency rsgaku;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
        rsgakuValue = null;
        rsgakuType  = null;
    }

    transient private BigDecimal rsgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKU, nullable=true)
    protected BigDecimal getRsgakuValue() {
        if (rsgakuValue == null && rsgaku != null) {
            if (rsgaku.isOptional()) return null;
            return rsgaku.absolute();
        }
        return rsgakuValue;
    }

    protected void setRsgakuValue(BigDecimal value) {
        rsgakuValue = value;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    transient private String rsgakuType = null;

    @Column(name=RSGAKU + "$", nullable=true)
    protected String getRsgakuType() {
        if (rsgakuType == null && rsgaku != null) return rsgaku.getType().toString();
        if (rsgakuType == null && getRsgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgaku$' should not be NULL."));
        }
        return rsgakuType;
    }

    protected void setRsgakuType(String type) {
        rsgakuType = type;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_AnsyuRireki.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizDate ryosyukwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.RYOSYUKWSRATEKJYMD)
    public BizDate getRyosyukwsratekjymd() {
        return ryosyukwsratekjymd;
    }

    public void setRyosyukwsratekjymd(BizDate pRyosyukwsratekjymd) {
        ryosyukwsratekjymd = pRyosyukwsratekjymd;
    }

    private BizNumber ryosyukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AnsyuRireki.RYOSYUKWSRATE)
    public BizNumber getRyosyukwsrate() {
        return ryosyukwsrate;
    }

    public void setRyosyukwsrate(BizNumber pRyosyukwsrate) {
        ryosyukwsrate = pRyosyukwsrate;
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

    private BizCurrency iktwaribikikgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public void setIktwaribikikgk(BizCurrency pIktwaribikikgk) {
        iktwaribikikgk = pIktwaribikikgk;
        iktwaribikikgkValue = null;
        iktwaribikikgkType  = null;
    }

    transient private BigDecimal iktwaribikikgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IKTWARIBIKIKGK, nullable=true)
    protected BigDecimal getIktwaribikikgkValue() {
        if (iktwaribikikgkValue == null && iktwaribikikgk != null) {
            if (iktwaribikikgk.isOptional()) return null;
            return iktwaribikikgk.absolute();
        }
        return iktwaribikikgkValue;
    }

    protected void setIktwaribikikgkValue(BigDecimal value) {
        iktwaribikikgkValue = value;
        iktwaribikikgk = Optional.fromNullable(toCurrencyType(iktwaribikikgkType))
            .transform(bizCurrencyTransformer(getIktwaribikikgkValue()))
            .orNull();
    }

    transient private String iktwaribikikgkType = null;

    @Column(name=IKTWARIBIKIKGK + "$", nullable=true)
    protected String getIktwaribikikgkType() {
        if (iktwaribikikgkType == null && iktwaribikikgk != null) return iktwaribikikgk.getType().toString();
        if (iktwaribikikgkType == null && getIktwaribikikgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'iktwaribikikgk$' should not be NULL."));
        }
        return iktwaribikikgkType;
    }

    protected void setIktwaribikikgkType(String type) {
        iktwaribikikgkType = type;
        iktwaribikikgk = Optional.fromNullable(toCurrencyType(iktwaribikikgkType))
            .transform(bizCurrencyTransformer(getIktwaribikikgkValue()))
            .orNull();
    }

    private C_AnnaijkKbn annaijkkbn;

    @Type(type="UserType_C_AnnaijkKbn")
    @Column(name=GenIT_AnsyuRireki.ANNAIJKKBN)
    public C_AnnaijkKbn getAnnaijkkbn() {
        return annaijkkbn;
    }

    public void setAnnaijkkbn(C_AnnaijkKbn pAnnaijkkbn) {
        annaijkkbn = pAnnaijkkbn;
    }

    private BizDate annaisakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.ANNAISAKUSEIYMD)
    public BizDate getAnnaisakuseiymd() {
        return annaisakuseiymd;
    }

    public void setAnnaisakuseiymd(BizDate pAnnaisakuseiymd) {
        annaisakuseiymd = pAnnaisakuseiymd;
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private BizDate minyusyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.MINYUSYORIYMD)
    public BizDate getMinyusyoriymd() {
        return minyusyoriymd;
    }

    public void setMinyusyoriymd(BizDate pMinyusyoriymd) {
        minyusyoriymd = pMinyusyoriymd;
    }

    private BizDate dattaiuktkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.DATTAIUKTKYMD)
    public BizDate getDattaiuktkymd() {
        return dattaiuktkymd;
    }

    public void setDattaiuktkymd(BizDate pDattaiuktkymd) {
        dattaiuktkymd = pDattaiuktkymd;
    }

    private BizDate hurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

    private C_HurihunoKbn hurihunokbn;

    @Type(type="UserType_C_HurihunoKbn")
    @Column(name=GenIT_AnsyuRireki.HURIHUNOKBN)
    public C_HurihunoKbn getHurihunokbn() {
        return hurihunokbn;
    }

    public void setHurihunokbn(C_HurihunoKbn pHurihunokbn) {
        hurihunokbn = pHurihunokbn;
    }

    private BizDate uriageymdkon;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.URIAGEYMDKON)
    public BizDate getUriageymdkon() {
        return uriageymdkon;
    }

    public void setUriageymdkon(BizDate pUriageymdkon) {
        uriageymdkon = pUriageymdkon;
    }

    private C_UmuKbn krkkeijyoflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_AnsyuRireki.KRKKEIJYOFLG)
    public C_UmuKbn getKrkkeijyoflg() {
        return krkkeijyoflg;
    }

    public void setKrkkeijyoflg(C_UmuKbn pKrkkeijyoflg) {
        krkkeijyoflg = pKrkkeijyoflg;
    }

    private BizDate krkkeijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.KRKKEIJYOYMD)
    public BizDate getKrkkeijyoymd() {
        return krkkeijyoymd;
    }

    @Trim("both")
    public void setKrkkeijyoymd(BizDate pKrkkeijyoymd) {
        krkkeijyoymd = pKrkkeijyoymd;
    }

    private Integer krkno;

    @Column(name=GenIT_AnsyuRireki.KRKNO)
    @Range(min="0", max="99999")
    public Integer getKrkno() {
        return krkno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKrkno(Integer pKrkno) {
        krkno = pKrkno;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_AnsyuRireki.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_AnsyuRireki.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_AnsyuRireki.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_AnsyuRireki.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_AnsyuRireki.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private String bankcd;

    @Column(name=GenIT_AnsyuRireki.BANKCD)
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

    @Column(name=GenIT_AnsyuRireki.SITENCD)
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
    @Column(name=GenIT_AnsyuRireki.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_AnsyuRireki.KOUZANO)
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

    private C_SinkeizkKbn sinkeizkkbn;

    @Type(type="UserType_C_SinkeizkKbn")
    @Column(name=GenIT_AnsyuRireki.SINKEIZKKBN)
    public C_SinkeizkKbn getSinkeizkkbn() {
        return sinkeizkkbn;
    }

    public void setSinkeizkkbn(C_SinkeizkKbn pSinkeizkkbn) {
        sinkeizkkbn = pSinkeizkkbn;
    }

    private C_SyuyakukyohiKbn syuyakukyohikbn;

    @Type(type="UserType_C_SyuyakukyohiKbn")
    @Column(name=GenIT_AnsyuRireki.SYUYAKUKYOHIKBN)
    public C_SyuyakukyohiKbn getSyuyakukyohikbn() {
        return syuyakukyohikbn;
    }

    public void setSyuyakukyohikbn(C_SyuyakukyohiKbn pSyuyakukyohikbn) {
        syuyakukyohikbn = pSyuyakukyohikbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIT_AnsyuRireki.KZMEIGINMKN)
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

    private String cardkaisyacd;

    @Column(name=GenIT_AnsyuRireki.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private String creditcardno1;

    @Column(name=GenIT_AnsyuRireki.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_AnsyuRireki.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_AnsyuRireki.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_AnsyuRireki.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private BizDate yukoukachkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.YUKOUKACHKYMD)
    public BizDate getYukoukachkymd() {
        return yukoukachkymd;
    }

    @Trim("both")
    public void setYukoukachkymd(BizDate pYukoukachkymd) {
        yukoukachkymd = pYukoukachkymd;
    }

    private BizDate authorikanryoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.AUTHORIKANRYOYMD)
    @ValidDate
    public BizDate getAuthorikanryoymd() {
        return authorikanryoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikanryoymd(BizDate pAuthorikanryoymd) {
        authorikanryoymd = pAuthorikanryoymd;
    }

    private BizDate uriageymdzen;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.URIAGEYMDZEN)
    public BizDate getUriageymdzen() {
        return uriageymdzen;
    }

    public void setUriageymdzen(BizDate pUriageymdzen) {
        uriageymdzen = pUriageymdzen;
    }

    private BizDate hrkkigen;

    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuRireki.HRKKIGEN)
    public BizDate getHrkkigen() {
        return hrkkigen;
    }

    @Trim("both")
    public void setHrkkigen(BizDate pHrkkigen) {
        hrkkigen = pHrkkigen;
    }

    private C_Skszumiflg minyutuutizumiflg;

    @Type(type="UserType_C_Skszumiflg")
    @Column(name=GenIT_AnsyuRireki.MINYUTUUTIZUMIFLG)
    public C_Skszumiflg getMinyutuutizumiflg() {
        return minyutuutizumiflg;
    }

    public void setMinyutuutizumiflg(C_Skszumiflg pMinyutuutizumiflg) {
        minyutuutizumiflg = pMinyutuutizumiflg;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_AnsyuRireki.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Type(type="UserType_C_CreditUriageNgJiyuuKbn")
    @Column(name=GenIT_AnsyuRireki.CREDITURIAGENGJIYUU)
    public C_CreditUriageNgJiyuuKbn getCredituriagengjiyuu() {
        return credituriagengjiyuu;
    }

    public void setCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn pCredituriagengjiyuu) {
        credituriagengjiyuu = pCredituriagengjiyuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_AnsyuRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_AnsyuRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_AnsyuRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}