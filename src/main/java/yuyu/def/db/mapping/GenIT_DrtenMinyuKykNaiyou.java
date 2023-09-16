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
import yuyu.def.db.id.PKIT_DrtenMinyuKykNaiyou;
import yuyu.def.db.meta.GenQIT_DrtenMinyuKykNaiyou;
import yuyu.def.db.meta.QIT_DrtenMinyuKykNaiyou;
import yuyu.def.db.type.UserType_C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.db.type.UserType_C_DrtenChannelSyurui;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 代理店未入契約明細内容テーブル テーブルのマッピング情報クラスで、 {@link IT_DrtenMinyuKykNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DrtenMinyuKykNaiyou}</td><td colspan="3">代理店未入契約明細内容テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_DrtenMinyuKykNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_DrtenMinyuKykNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">{@link PKIT_DrtenMinyuKykNaiyou ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKeiyakuymd keiyakuymd}</td><td>契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSyuukeikbn syuukeikbn}</td><td>集計区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyukaisuu minyukaisuu}</td><td>未入回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHsys hsys}</td><td>保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyuuseis syuuseis}</td><td>修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHukkatutyuuikbn hukkatutyuuikbn}</td><td>復活注意区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMrarihyj mrarihyj}</td><td>ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFstttkekykhyj fstttkekykhyj}</td><td>初回立替契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtkernzkkaisuu ttkernzkkaisuu}</td><td>立替計上連続回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKeizokutyuuihyj keizokutyuuihyj}</td><td>継続注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhinbunruikbn syouhinbunruikbn}</td><td>商品分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmkbn syouhnnmkbn}</td><td>商品名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHurihunokbn hurihunokbn}</td><td>振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HurihunoKbn}</td></tr>
 *  <tr><td>{@link #getAutocallkykhyj autocallkykhyj}</td><td>オートコール対象契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuudairitenatkikeitaikbn bosyuudairitenatkikeitaikbn}</td><td>募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BosyuuDairitenAtkiKeitaiKbn}</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd1 drtenkanrisosikicd1}</td><td>代理店管理組織コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd2 drtenkanrisosikicd2}</td><td>代理店管理組織コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenchannelsyuruikbn1 drtenchannelsyuruikbn1}</td><td>代理店チャネル種類区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtenChannelSyurui}</td></tr>
 *  <tr><td>{@link #getDrtenchannelsyuruikbn2 drtenchannelsyuruikbn2}</td><td>代理店チャネル種類区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtenChannelSyurui}</td></tr>
 *  <tr><td>{@link #getBosyuucd1 bosyuucd1}</td><td>募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd2 bosyuucd2}</td><td>募集人コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuuningyouhaiymd1 bosyuuningyouhaiymd1}</td><td>募集人業廃年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuningyouhaiymd2 bosyuuningyouhaiymd2}</td><td>募集人業廃年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKydatkikbnkj kydatkikbnkj}</td><td>共同扱区分（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkkatubaraikbn ikkatubaraikbn}</td><td>一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatubaraikaisuu ikkatubaraikaisuu}</td><td>一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYykknmnryymd yykknmnryymd}</td><td>猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknm35keta kyknm35keta}</td><td>契約者名（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinkihontikucd tsinkihontikucd}</td><td>通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjitsinkaiadr kanjitsinkaiadr}</td><td>漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNexthurikaeymd nexthurikaeymd}</td><td>次回振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMinyusyoriymd minyusyoriymd}</td><td>未入処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getJkiannaikg jkiannaikg}</td><td>次回案内金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DrtenMinyuKykNaiyou
 * @see     PKIT_DrtenMinyuKykNaiyou
 * @see     QIT_DrtenMinyuKykNaiyou
 * @see     GenQIT_DrtenMinyuKykNaiyou
 */
@MappedSuperclass
@Table(name=GenIT_DrtenMinyuKykNaiyou.TABLE_NAME)
@IdClass(value=PKIT_DrtenMinyuKykNaiyou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_BosyuuDairitenAtkiKeitaiKbn", typeClass=UserType_C_BosyuuDairitenAtkiKeitaiKbn.class),
    @TypeDef(name="UserType_C_DrtenChannelSyurui", typeClass=UserType_C_DrtenChannelSyurui.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_HurihunoKbn", typeClass=UserType_C_HurihunoKbn.class),
    @TypeDef(name="UserType_C_IkkatubaraiKaisuuKbn", typeClass=UserType_C_IkkatubaraiKaisuuKbn.class),
    @TypeDef(name="UserType_C_IkkatubaraiKbn", typeClass=UserType_C_IkkatubaraiKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_DrtenMinyuKykNaiyou extends AbstractExDBEntity<IT_DrtenMinyuKykNaiyou, PKIT_DrtenMinyuKykNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_DrtenMinyuKykNaiyou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYORIYM                  = "syoriym";
    public static final String KEIYAKUYMD               = "keiyakuymd";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SYUUKEIKBN               = "syuukeikbn";
    public static final String MINYUKAISUU              = "minyukaisuu";
    public static final String HRKP                     = "hrkp";
    public static final String HSYS                     = "hsys";
    public static final String SYUUSEIS                 = "syuuseis";
    public static final String HUKKATUTYUUIKBN          = "hukkatutyuuikbn";
    public static final String MRARIHYJ                 = "mrarihyj";
    public static final String FSTTTKEKYKHYJ            = "fstttkekykhyj";
    public static final String TTKERNZKKAISUU           = "ttkernzkkaisuu";
    public static final String KEIZOKUTYUUIHYJ          = "keizokutyuuihyj";
    public static final String SYOUHINBUNRUIKBN         = "syouhinbunruikbn";
    public static final String SYOUHNNMKBN              = "syouhnnmkbn";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String HURIHUNOKBN              = "hurihunokbn";
    public static final String AUTOCALLKYKHYJ           = "autocallkykhyj";
    public static final String BOSYUUDAIRITENATKIKEITAIKBN = "bosyuudairitenatkikeitaikbn";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String DRTENKANRISOSIKICD1      = "drtenkanrisosikicd1";
    public static final String DRTENKANRISOSIKICD2      = "drtenkanrisosikicd2";
    public static final String DRTENCHANNELSYURUIKBN1   = "drtenchannelsyuruikbn1";
    public static final String DRTENCHANNELSYURUIKBN2   = "drtenchannelsyuruikbn2";
    public static final String BOSYUUCD1                = "bosyuucd1";
    public static final String BOSYUUCD2                = "bosyuucd2";
    public static final String BOSYUUNINGYOUHAIYMD1     = "bosyuuningyouhaiymd1";
    public static final String BOSYUUNINGYOUHAIYMD2     = "bosyuuningyouhaiymd2";
    public static final String KYDATKIKBNKJ             = "kydatkikbnkj";
    public static final String IKKATUBARAIKBN           = "ikkatubaraikbn";
    public static final String IKKATUBARAIKAISUU        = "ikkatubaraikaisuu";
    public static final String CIFCD                    = "cifcd";
    public static final String YYKKNMNRYYMD             = "yykknmnryymd";
    public static final String KYKNM35KETA              = "kyknm35keta";
    public static final String TSINKIHONTIKUCD          = "tsinkihontikucd";
    public static final String KANJITSINKAIADR          = "kanjitsinkaiadr";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String NEXTHURIKAEYMD           = "nexthurikaeymd";
    public static final String MINYUSYORIYMD            = "minyusyoriymd";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String JKIANNAIKG               = "jkiannaikg";
    public static final String MISYUUP                  = "misyuup";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_DrtenMinyuKykNaiyou primaryKey;

    public GenIT_DrtenMinyuKykNaiyou() {
        primaryKey = new PKIT_DrtenMinyuKykNaiyou();
    }

    public GenIT_DrtenMinyuKykNaiyou(
        String pKbnkey,
        String pSyono,
        BizDateYM pSyoriym
    ) {
        primaryKey = new PKIT_DrtenMinyuKykNaiyou(
            pKbnkey,
            pSyono,
            pSyoriym
        );
    }

    @Transient
    @Override
    public PKIT_DrtenMinyuKykNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_DrtenMinyuKykNaiyou> getMetaClass() {
        return QIT_DrtenMinyuKykNaiyou.class;
    }

    @Id
    @Column(name=GenIT_DrtenMinyuKykNaiyou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_DrtenMinyuKykNaiyou.SYONO)
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
    @Type(type="BizDateYMType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.SYORIYM)
    public BizDateYM getSyoriym() {
        return getPrimaryKey().getSyoriym();
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        getPrimaryKey().setSyoriym(pSyoriym);
    }

    private BizDate keiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String syuukeikbn;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.SYUUKEIKBN)
    public String getSyuukeikbn() {
        return syuukeikbn;
    }

    public void setSyuukeikbn(String pSyuukeikbn) {
        syuukeikbn = pSyuukeikbn;
    }

    private Integer minyukaisuu;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.MINYUKAISUU)
    public Integer getMinyukaisuu() {
        return minyukaisuu;
    }

    public void setMinyukaisuu(Integer pMinyukaisuu) {
        minyukaisuu = pMinyukaisuu;
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

    private BizCurrency hsys;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHsys() {
        return hsys;
    }

    public void setHsys(BizCurrency pHsys) {
        hsys = pHsys;
        hsysValue = null;
        hsysType  = null;
    }

    transient private BigDecimal hsysValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HSYS, nullable=true)
    protected BigDecimal getHsysValue() {
        if (hsysValue == null && hsys != null) {
            if (hsys.isOptional()) return null;
            return hsys.absolute();
        }
        return hsysValue;
    }

    protected void setHsysValue(BigDecimal value) {
        hsysValue = value;
        hsys = Optional.fromNullable(toCurrencyType(hsysType))
            .transform(bizCurrencyTransformer(getHsysValue()))
            .orNull();
    }

    transient private String hsysType = null;

    @Column(name=HSYS + "$", nullable=true)
    protected String getHsysType() {
        if (hsysType == null && hsys != null) return hsys.getType().toString();
        if (hsysType == null && getHsysValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hsys$' should not be NULL."));
        }
        return hsysType;
    }

    protected void setHsysType(String type) {
        hsysType = type;
        hsys = Optional.fromNullable(toCurrencyType(hsysType))
            .transform(bizCurrencyTransformer(getHsysValue()))
            .orNull();
    }

    private BizCurrency syuuseis;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyuuseis() {
        return syuuseis;
    }

    public void setSyuuseis(BizCurrency pSyuuseis) {
        syuuseis = pSyuuseis;
        syuuseisValue = null;
        syuuseisType  = null;
    }

    transient private BigDecimal syuuseisValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUUSEIS, nullable=true)
    protected BigDecimal getSyuuseisValue() {
        if (syuuseisValue == null && syuuseis != null) {
            if (syuuseis.isOptional()) return null;
            return syuuseis.absolute();
        }
        return syuuseisValue;
    }

    protected void setSyuuseisValue(BigDecimal value) {
        syuuseisValue = value;
        syuuseis = Optional.fromNullable(toCurrencyType(syuuseisType))
            .transform(bizCurrencyTransformer(getSyuuseisValue()))
            .orNull();
    }

    transient private String syuuseisType = null;

    @Column(name=SYUUSEIS + "$", nullable=true)
    protected String getSyuuseisType() {
        if (syuuseisType == null && syuuseis != null) return syuuseis.getType().toString();
        if (syuuseisType == null && getSyuuseisValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syuuseis$' should not be NULL."));
        }
        return syuuseisType;
    }

    protected void setSyuuseisType(String type) {
        syuuseisType = type;
        syuuseis = Optional.fromNullable(toCurrencyType(syuuseisType))
            .transform(bizCurrencyTransformer(getSyuuseisValue()))
            .orNull();
    }

    private String hukkatutyuuikbn;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.HUKKATUTYUUIKBN)
    public String getHukkatutyuuikbn() {
        return hukkatutyuuikbn;
    }

    public void setHukkatutyuuikbn(String pHukkatutyuuikbn) {
        hukkatutyuuikbn = pHukkatutyuuikbn;
    }

    private String mrarihyj;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.MRARIHYJ)
    public String getMrarihyj() {
        return mrarihyj;
    }

    public void setMrarihyj(String pMrarihyj) {
        mrarihyj = pMrarihyj;
    }

    private String fstttkekykhyj;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.FSTTTKEKYKHYJ)
    public String getFstttkekykhyj() {
        return fstttkekykhyj;
    }

    public void setFstttkekykhyj(String pFstttkekykhyj) {
        fstttkekykhyj = pFstttkekykhyj;
    }

    private Integer ttkernzkkaisuu;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.TTKERNZKKAISUU)
    public Integer getTtkernzkkaisuu() {
        return ttkernzkkaisuu;
    }

    public void setTtkernzkkaisuu(Integer pTtkernzkkaisuu) {
        ttkernzkkaisuu = pTtkernzkkaisuu;
    }

    private String keizokutyuuihyj;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.KEIZOKUTYUUIHYJ)
    public String getKeizokutyuuihyj() {
        return keizokutyuuihyj;
    }

    public void setKeizokutyuuihyj(String pKeizokutyuuihyj) {
        keizokutyuuihyj = pKeizokutyuuihyj;
    }

    private String syouhinbunruikbn;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.SYOUHINBUNRUIKBN)
    public String getSyouhinbunruikbn() {
        return syouhinbunruikbn;
    }

    public void setSyouhinbunruikbn(String pSyouhinbunruikbn) {
        syouhinbunruikbn = pSyouhinbunruikbn;
    }

    private String syouhnnmkbn;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.SYOUHNNMKBN)
    public String getSyouhnnmkbn() {
        return syouhnnmkbn;
    }

    public void setSyouhnnmkbn(String pSyouhnnmkbn) {
        syouhnnmkbn = pSyouhnnmkbn;
    }

    private String hknsyukigou;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private C_HurihunoKbn hurihunokbn;

    @Type(type="UserType_C_HurihunoKbn")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.HURIHUNOKBN)
    public C_HurihunoKbn getHurihunokbn() {
        return hurihunokbn;
    }

    public void setHurihunokbn(C_HurihunoKbn pHurihunokbn) {
        hurihunokbn = pHurihunokbn;
    }

    private String autocallkykhyj;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.AUTOCALLKYKHYJ)
    public String getAutocallkykhyj() {
        return autocallkykhyj;
    }

    public void setAutocallkykhyj(String pAutocallkykhyj) {
        autocallkykhyj = pAutocallkykhyj;
    }

    private C_BosyuuDairitenAtkiKeitaiKbn bosyuudairitenatkikeitaikbn;

    @Type(type="UserType_C_BosyuuDairitenAtkiKeitaiKbn")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.BOSYUUDAIRITENATKIKEITAIKBN)
    public C_BosyuuDairitenAtkiKeitaiKbn getBosyuudairitenatkikeitaikbn() {
        return bosyuudairitenatkikeitaikbn;
    }

    public void setBosyuudairitenatkikeitaikbn(C_BosyuuDairitenAtkiKeitaiKbn pBosyuudairitenatkikeitaikbn) {
        bosyuudairitenatkikeitaikbn = pBosyuudairitenatkikeitaikbn;
    }

    private String dairitencd1;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String dairitencd2;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String drtenkanrisosikicd1;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.DRTENKANRISOSIKICD1)
    @MaxLength(max=7)
    @SingleByteStrings
    public String getDrtenkanrisosikicd1() {
        return drtenkanrisosikicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenkanrisosikicd1(String pDrtenkanrisosikicd1) {
        drtenkanrisosikicd1 = pDrtenkanrisosikicd1;
    }

    private String drtenkanrisosikicd2;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.DRTENKANRISOSIKICD2)
    public String getDrtenkanrisosikicd2() {
        return drtenkanrisosikicd2;
    }

    public void setDrtenkanrisosikicd2(String pDrtenkanrisosikicd2) {
        drtenkanrisosikicd2 = pDrtenkanrisosikicd2;
    }

    private C_DrtenChannelSyurui drtenchannelsyuruikbn1;

    @Type(type="UserType_C_DrtenChannelSyurui")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.DRTENCHANNELSYURUIKBN1)
    public C_DrtenChannelSyurui getDrtenchannelsyuruikbn1() {
        return drtenchannelsyuruikbn1;
    }

    public void setDrtenchannelsyuruikbn1(C_DrtenChannelSyurui pDrtenchannelsyuruikbn1) {
        drtenchannelsyuruikbn1 = pDrtenchannelsyuruikbn1;
    }

    private C_DrtenChannelSyurui drtenchannelsyuruikbn2;

    @Type(type="UserType_C_DrtenChannelSyurui")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.DRTENCHANNELSYURUIKBN2)
    public C_DrtenChannelSyurui getDrtenchannelsyuruikbn2() {
        return drtenchannelsyuruikbn2;
    }

    public void setDrtenchannelsyuruikbn2(C_DrtenChannelSyurui pDrtenchannelsyuruikbn2) {
        drtenchannelsyuruikbn2 = pDrtenchannelsyuruikbn2;
    }

    private String bosyuucd1;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.BOSYUUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    private String bosyuucd2;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.BOSYUUCD2)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getBosyuucd2() {
        return bosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd2(String pBosyuucd2) {
        bosyuucd2 = pBosyuucd2;
    }

    private BizDate bosyuuningyouhaiymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.BOSYUUNINGYOUHAIYMD1)
    public BizDate getBosyuuningyouhaiymd1() {
        return bosyuuningyouhaiymd1;
    }

    public void setBosyuuningyouhaiymd1(BizDate pBosyuuningyouhaiymd1) {
        bosyuuningyouhaiymd1 = pBosyuuningyouhaiymd1;
    }

    private BizDate bosyuuningyouhaiymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.BOSYUUNINGYOUHAIYMD2)
    public BizDate getBosyuuningyouhaiymd2() {
        return bosyuuningyouhaiymd2;
    }

    public void setBosyuuningyouhaiymd2(BizDate pBosyuuningyouhaiymd2) {
        bosyuuningyouhaiymd2 = pBosyuuningyouhaiymd2;
    }

    private String kydatkikbnkj;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.KYDATKIKBNKJ)
    public String getKydatkikbnkj() {
        return kydatkikbnkj;
    }

    public void setKydatkikbnkj(String pKydatkikbnkj) {
        kydatkikbnkj = pKydatkikbnkj;
    }

    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Type(type="UserType_C_IkkatubaraiKbn")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.IKKATUBARAIKBN)
    public C_IkkatubaraiKbn getIkkatubaraikbn() {
        return ikkatubaraikbn;
    }

    public void setIkkatubaraikbn(C_IkkatubaraiKbn pIkkatubaraikbn) {
        ikkatubaraikbn = pIkkatubaraikbn;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Type(type="UserType_C_IkkatubaraiKaisuuKbn")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.IKKATUBARAIKAISUU)
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private String cifcd;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.CIFCD)
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

    private BizDate yykknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.YYKKNMNRYYMD)
    public BizDate getYykknmnryymd() {
        return yykknmnryymd;
    }

    @Trim("both")
    public void setYykknmnryymd(BizDate pYykknmnryymd) {
        yykknmnryymd = pYykknmnryymd;
    }

    private String kyknm35keta;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.KYKNM35KETA)
    public String getKyknm35keta() {
        return kyknm35keta;
    }

    public void setKyknm35keta(String pKyknm35keta) {
        kyknm35keta = pKyknm35keta;
    }

    private String tsinkihontikucd;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.TSINKIHONTIKUCD)
    public String getTsinkihontikucd() {
        return tsinkihontikucd;
    }

    public void setTsinkihontikucd(String pTsinkihontikucd) {
        tsinkihontikucd = pTsinkihontikucd;
    }

    private String kanjitsinkaiadr;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.KANJITSINKAIADR)
    public String getKanjitsinkaiadr() {
        return kanjitsinkaiadr;
    }

    public void setKanjitsinkaiadr(String pKanjitsinkaiadr) {
        kanjitsinkaiadr = pKanjitsinkaiadr;
    }

    private String tsintelno;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.TSINTELNO)
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

    @Column(name=GenIT_DrtenMinyuKykNaiyou.DAI2TSINTELNO)
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

    private String hhknnmkj;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.HHKNNMKJ)
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

    private BizDate nexthurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.NEXTHURIKAEYMD)
    public BizDate getNexthurikaeymd() {
        return nexthurikaeymd;
    }

    public void setNexthurikaeymd(BizDate pNexthurikaeymd) {
        nexthurikaeymd = pNexthurikaeymd;
    }

    private BizDate minyusyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.MINYUSYORIYMD)
    public BizDate getMinyusyoriymd() {
        return minyusyoriymd;
    }

    public void setMinyusyoriymd(BizDate pMinyusyoriymd) {
        minyusyoriymd = pMinyusyoriymd;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private String bankcd;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.BANKCD)
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

    @Column(name=GenIT_DrtenMinyuKykNaiyou.SITENCD)
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
    @Column(name=GenIT_DrtenMinyuKykNaiyou.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.KOUZANO)
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

    private String kzmeiginmkn;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.KZMEIGINMKN)
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

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_DrtenMinyuKykNaiyou.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
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

    private BizCurrency misyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
        misyuupValue = null;
        misyuupType  = null;
    }

    transient private BigDecimal misyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUP, nullable=true)
    protected BigDecimal getMisyuupValue() {
        if (misyuupValue == null && misyuup != null) {
            if (misyuup.isOptional()) return null;
            return misyuup.absolute();
        }
        return misyuupValue;
    }

    protected void setMisyuupValue(BigDecimal value) {
        misyuupValue = value;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    transient private String misyuupType = null;

    @Column(name=MISYUUP + "$", nullable=true)
    protected String getMisyuupType() {
        if (misyuupType == null && misyuup != null) return misyuup.getType().toString();
        if (misyuupType == null && getMisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuup$' should not be NULL."));
        }
        return misyuupType;
    }

    protected void setMisyuupType(String type) {
        misyuupType = type;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_DrtenMinyuKykNaiyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}