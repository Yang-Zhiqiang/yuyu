package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.id.PKIT_KouzahuriStartAnnai;
import yuyu.def.db.meta.GenQIT_KouzahuriStartAnnai;
import yuyu.def.db.meta.QIT_KouzahuriStartAnnai;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 口座振替開始案内テーブル テーブルのマッピング情報クラスで、 {@link IT_KouzahuriStartAnnai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KouzahuriStartAnnai}</td><td colspan="3">口座振替開始案内テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KouzahuriStartAnnai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KouzahuriStartAnnai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutinm tuutinm}</td><td>通知名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon1 aisatumongon1}</td><td>挨拶文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon2 aisatumongon2}</td><td>挨拶文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon3 aisatumongon3}</td><td>挨拶文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon4 aisatumongon4}</td><td>挨拶文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon5 aisatumongon5}</td><td>挨拶文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai1 kzhurikaeonegai1}</td><td>口座振替についてのお願い１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai2 kzhurikaeonegai2}</td><td>口座振替についてのお願い２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai3 kzhurikaeonegai3}</td><td>口座振替についてのお願い３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai4 kzhurikaeonegai4}</td><td>口座振替についてのお願い４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai5 kzhurikaeonegai5}</td><td>口座振替についてのお願い５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai6 kzhurikaeonegai6}</td><td>口座振替についてのお願い６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai7 kzhurikaeonegai7}</td><td>口座振替についてのお願い７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai8 kzhurikaeonegai8}</td><td>口座振替についてのお願い８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai9 kzhurikaeonegai9}</td><td>口座振替についてのお願い９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai10 kzhurikaeonegai10}</td><td>口座振替についてのお願い１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai11 kzhurikaeonegai11}</td><td>口座振替についてのお願い１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai12 kzhurikaeonegai12}</td><td>口座振替についてのお願い１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai13 kzhurikaeonegai13}</td><td>口座振替についてのお願い１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai14 kzhurikaeonegai14}</td><td>口座振替についてのお願い１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaeonegai15 kzhurikaeonegai15}</td><td>口座振替についてのお願い１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkbriphurikaeyoteigk tkbriphurikaeyoteigk}</td><td>月払保険料（振替予定金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekzhosokumongon hurikaekzhosokumongon}</td><td>振替口座補足文言</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz1 hurikaekz1}</td><td>振替口座１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz2 hurikaekz2}</td><td>振替口座２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz3 hurikaekz3}</td><td>振替口座３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz4 hurikaekz4}</td><td>振替口座４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz5 hurikaekz5}</td><td>振替口座５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea1 kzhuristartanfreearea1}</td><td>口座振替開始案内フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea2 kzhuristartanfreearea2}</td><td>口座振替開始案内フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea3 kzhuristartanfreearea3}</td><td>口座振替開始案内フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea4 kzhuristartanfreearea4}</td><td>口座振替開始案内フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea5 kzhuristartanfreearea5}</td><td>口座振替開始案内フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea6 kzhuristartanfreearea6}</td><td>口座振替開始案内フリーエリア６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea7 kzhuristartanfreearea7}</td><td>口座振替開始案内フリーエリア７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea8 kzhuristartanfreearea8}</td><td>口座振替開始案内フリーエリア８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea9 kzhuristartanfreearea9}</td><td>口座振替開始案内フリーエリア９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhuristartanfreearea10 kzhuristartanfreearea10}</td><td>口座振替開始案内フリーエリア１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KouzahuriStartAnnai
 * @see     PKIT_KouzahuriStartAnnai
 * @see     QIT_KouzahuriStartAnnai
 * @see     GenQIT_KouzahuriStartAnnai
 */
@MappedSuperclass
@Table(name=GenIT_KouzahuriStartAnnai.TABLE_NAME)
@IdClass(value=PKIT_KouzahuriStartAnnai.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_KouzahuriStartAnnai extends AbstractExDBEntity<IT_KouzahuriStartAnnai, PKIT_KouzahuriStartAnnai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KouzahuriStartAnnai";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String KYKYMD                   = "kykymd";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String TUUTINM                  = "tuutinm";
    public static final String AISATUMONGON1            = "aisatumongon1";
    public static final String AISATUMONGON2            = "aisatumongon2";
    public static final String AISATUMONGON3            = "aisatumongon3";
    public static final String AISATUMONGON4            = "aisatumongon4";
    public static final String AISATUMONGON5            = "aisatumongon5";
    public static final String KZHURIKAEONEGAI1         = "kzhurikaeonegai1";
    public static final String KZHURIKAEONEGAI2         = "kzhurikaeonegai2";
    public static final String KZHURIKAEONEGAI3         = "kzhurikaeonegai3";
    public static final String KZHURIKAEONEGAI4         = "kzhurikaeonegai4";
    public static final String KZHURIKAEONEGAI5         = "kzhurikaeonegai5";
    public static final String KZHURIKAEONEGAI6         = "kzhurikaeonegai6";
    public static final String KZHURIKAEONEGAI7         = "kzhurikaeonegai7";
    public static final String KZHURIKAEONEGAI8         = "kzhurikaeonegai8";
    public static final String KZHURIKAEONEGAI9         = "kzhurikaeonegai9";
    public static final String KZHURIKAEONEGAI10        = "kzhurikaeonegai10";
    public static final String KZHURIKAEONEGAI11        = "kzhurikaeonegai11";
    public static final String KZHURIKAEONEGAI12        = "kzhurikaeonegai12";
    public static final String KZHURIKAEONEGAI13        = "kzhurikaeonegai13";
    public static final String KZHURIKAEONEGAI14        = "kzhurikaeonegai14";
    public static final String KZHURIKAEONEGAI15        = "kzhurikaeonegai15";
    public static final String TKBRIPHURIKAEYOTEIGK     = "tkbriphurikaeyoteigk";
    public static final String HURIKAEKZHOSOKUMONGON    = "hurikaekzhosokumongon";
    public static final String HURIKAEKZ1               = "hurikaekz1";
    public static final String HURIKAEKZ2               = "hurikaekz2";
    public static final String HURIKAEKZ3               = "hurikaekz3";
    public static final String HURIKAEKZ4               = "hurikaekz4";
    public static final String HURIKAEKZ5               = "hurikaekz5";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String KZHURISTARTANFREEAREA1   = "kzhuristartanfreearea1";
    public static final String KZHURISTARTANFREEAREA2   = "kzhuristartanfreearea2";
    public static final String KZHURISTARTANFREEAREA3   = "kzhuristartanfreearea3";
    public static final String KZHURISTARTANFREEAREA4   = "kzhuristartanfreearea4";
    public static final String KZHURISTARTANFREEAREA5   = "kzhuristartanfreearea5";
    public static final String KZHURISTARTANFREEAREA6   = "kzhuristartanfreearea6";
    public static final String KZHURISTARTANFREEAREA7   = "kzhuristartanfreearea7";
    public static final String KZHURISTARTANFREEAREA8   = "kzhuristartanfreearea8";
    public static final String KZHURISTARTANFREEAREA9   = "kzhuristartanfreearea9";
    public static final String KZHURISTARTANFREEAREA10  = "kzhuristartanfreearea10";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KouzahuriStartAnnai primaryKey;

    public GenIT_KouzahuriStartAnnai() {
        primaryKey = new PKIT_KouzahuriStartAnnai();
    }

    public GenIT_KouzahuriStartAnnai(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_KouzahuriStartAnnai(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_KouzahuriStartAnnai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KouzahuriStartAnnai> getMetaClass() {
        return QIT_KouzahuriStartAnnai.class;
    }

    @Id
    @Column(name=GenIT_KouzahuriStartAnnai.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KouzahuriStartAnnai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate tyouhyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KouzahuriStartAnnai.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

    private String kyknmkj;

    @Column(name=GenIT_KouzahuriStartAnnai.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private String tsinyno;

    @Column(name=GenIT_KouzahuriStartAnnai.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenIT_KouzahuriStartAnnai.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenIT_KouzahuriStartAnnai.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenIT_KouzahuriStartAnnai.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KouzahuriStartAnnai.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String hhknnmkj;

    @Column(name=GenIT_KouzahuriStartAnnai.HHKNNMKJ)
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

    private String syouhnnm;

    @Column(name=GenIT_KouzahuriStartAnnai.SYOUHNNM)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private String tuutinm;

    @Column(name=GenIT_KouzahuriStartAnnai.TUUTINM)
    public String getTuutinm() {
        return tuutinm;
    }

    public void setTuutinm(String pTuutinm) {
        tuutinm = pTuutinm;
    }

    private String aisatumongon1;

    @Column(name=GenIT_KouzahuriStartAnnai.AISATUMONGON1)
    public String getAisatumongon1() {
        return aisatumongon1;
    }

    public void setAisatumongon1(String pAisatumongon1) {
        aisatumongon1 = pAisatumongon1;
    }

    private String aisatumongon2;

    @Column(name=GenIT_KouzahuriStartAnnai.AISATUMONGON2)
    public String getAisatumongon2() {
        return aisatumongon2;
    }

    public void setAisatumongon2(String pAisatumongon2) {
        aisatumongon2 = pAisatumongon2;
    }

    private String aisatumongon3;

    @Column(name=GenIT_KouzahuriStartAnnai.AISATUMONGON3)
    public String getAisatumongon3() {
        return aisatumongon3;
    }

    public void setAisatumongon3(String pAisatumongon3) {
        aisatumongon3 = pAisatumongon3;
    }

    private String aisatumongon4;

    @Column(name=GenIT_KouzahuriStartAnnai.AISATUMONGON4)
    public String getAisatumongon4() {
        return aisatumongon4;
    }

    public void setAisatumongon4(String pAisatumongon4) {
        aisatumongon4 = pAisatumongon4;
    }

    private String aisatumongon5;

    @Column(name=GenIT_KouzahuriStartAnnai.AISATUMONGON5)
    public String getAisatumongon5() {
        return aisatumongon5;
    }

    public void setAisatumongon5(String pAisatumongon5) {
        aisatumongon5 = pAisatumongon5;
    }

    private String kzhurikaeonegai1;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI1)
    public String getKzhurikaeonegai1() {
        return kzhurikaeonegai1;
    }

    public void setKzhurikaeonegai1(String pKzhurikaeonegai1) {
        kzhurikaeonegai1 = pKzhurikaeonegai1;
    }

    private String kzhurikaeonegai2;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI2)
    public String getKzhurikaeonegai2() {
        return kzhurikaeonegai2;
    }

    public void setKzhurikaeonegai2(String pKzhurikaeonegai2) {
        kzhurikaeonegai2 = pKzhurikaeonegai2;
    }

    private String kzhurikaeonegai3;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI3)
    public String getKzhurikaeonegai3() {
        return kzhurikaeonegai3;
    }

    public void setKzhurikaeonegai3(String pKzhurikaeonegai3) {
        kzhurikaeonegai3 = pKzhurikaeonegai3;
    }

    private String kzhurikaeonegai4;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI4)
    public String getKzhurikaeonegai4() {
        return kzhurikaeonegai4;
    }

    public void setKzhurikaeonegai4(String pKzhurikaeonegai4) {
        kzhurikaeonegai4 = pKzhurikaeonegai4;
    }

    private String kzhurikaeonegai5;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI5)
    public String getKzhurikaeonegai5() {
        return kzhurikaeonegai5;
    }

    public void setKzhurikaeonegai5(String pKzhurikaeonegai5) {
        kzhurikaeonegai5 = pKzhurikaeonegai5;
    }

    private String kzhurikaeonegai6;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI6)
    public String getKzhurikaeonegai6() {
        return kzhurikaeonegai6;
    }

    public void setKzhurikaeonegai6(String pKzhurikaeonegai6) {
        kzhurikaeonegai6 = pKzhurikaeonegai6;
    }

    private String kzhurikaeonegai7;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI7)
    public String getKzhurikaeonegai7() {
        return kzhurikaeonegai7;
    }

    public void setKzhurikaeonegai7(String pKzhurikaeonegai7) {
        kzhurikaeonegai7 = pKzhurikaeonegai7;
    }

    private String kzhurikaeonegai8;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI8)
    public String getKzhurikaeonegai8() {
        return kzhurikaeonegai8;
    }

    public void setKzhurikaeonegai8(String pKzhurikaeonegai8) {
        kzhurikaeonegai8 = pKzhurikaeonegai8;
    }

    private String kzhurikaeonegai9;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI9)
    public String getKzhurikaeonegai9() {
        return kzhurikaeonegai9;
    }

    public void setKzhurikaeonegai9(String pKzhurikaeonegai9) {
        kzhurikaeonegai9 = pKzhurikaeonegai9;
    }

    private String kzhurikaeonegai10;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI10)
    public String getKzhurikaeonegai10() {
        return kzhurikaeonegai10;
    }

    public void setKzhurikaeonegai10(String pKzhurikaeonegai10) {
        kzhurikaeonegai10 = pKzhurikaeonegai10;
    }

    private String kzhurikaeonegai11;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI11)
    public String getKzhurikaeonegai11() {
        return kzhurikaeonegai11;
    }

    public void setKzhurikaeonegai11(String pKzhurikaeonegai11) {
        kzhurikaeonegai11 = pKzhurikaeonegai11;
    }

    private String kzhurikaeonegai12;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI12)
    public String getKzhurikaeonegai12() {
        return kzhurikaeonegai12;
    }

    public void setKzhurikaeonegai12(String pKzhurikaeonegai12) {
        kzhurikaeonegai12 = pKzhurikaeonegai12;
    }

    private String kzhurikaeonegai13;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI13)
    public String getKzhurikaeonegai13() {
        return kzhurikaeonegai13;
    }

    public void setKzhurikaeonegai13(String pKzhurikaeonegai13) {
        kzhurikaeonegai13 = pKzhurikaeonegai13;
    }

    private String kzhurikaeonegai14;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI14)
    public String getKzhurikaeonegai14() {
        return kzhurikaeonegai14;
    }

    public void setKzhurikaeonegai14(String pKzhurikaeonegai14) {
        kzhurikaeonegai14 = pKzhurikaeonegai14;
    }

    private String kzhurikaeonegai15;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURIKAEONEGAI15)
    public String getKzhurikaeonegai15() {
        return kzhurikaeonegai15;
    }

    public void setKzhurikaeonegai15(String pKzhurikaeonegai15) {
        kzhurikaeonegai15 = pKzhurikaeonegai15;
    }

    private String tkbriphurikaeyoteigk;

    @Column(name=GenIT_KouzahuriStartAnnai.TKBRIPHURIKAEYOTEIGK)
    public String getTkbriphurikaeyoteigk() {
        return tkbriphurikaeyoteigk;
    }

    public void setTkbriphurikaeyoteigk(String pTkbriphurikaeyoteigk) {
        tkbriphurikaeyoteigk = pTkbriphurikaeyoteigk;
    }

    private String hurikaekzhosokumongon;

    @Column(name=GenIT_KouzahuriStartAnnai.HURIKAEKZHOSOKUMONGON)
    public String getHurikaekzhosokumongon() {
        return hurikaekzhosokumongon;
    }

    public void setHurikaekzhosokumongon(String pHurikaekzhosokumongon) {
        hurikaekzhosokumongon = pHurikaekzhosokumongon;
    }

    private String hurikaekz1;

    @Column(name=GenIT_KouzahuriStartAnnai.HURIKAEKZ1)
    public String getHurikaekz1() {
        return hurikaekz1;
    }

    public void setHurikaekz1(String pHurikaekz1) {
        hurikaekz1 = pHurikaekz1;
    }

    private String hurikaekz2;

    @Column(name=GenIT_KouzahuriStartAnnai.HURIKAEKZ2)
    public String getHurikaekz2() {
        return hurikaekz2;
    }

    public void setHurikaekz2(String pHurikaekz2) {
        hurikaekz2 = pHurikaekz2;
    }

    private String hurikaekz3;

    @Column(name=GenIT_KouzahuriStartAnnai.HURIKAEKZ3)
    public String getHurikaekz3() {
        return hurikaekz3;
    }

    public void setHurikaekz3(String pHurikaekz3) {
        hurikaekz3 = pHurikaekz3;
    }

    private String hurikaekz4;

    @Column(name=GenIT_KouzahuriStartAnnai.HURIKAEKZ4)
    public String getHurikaekz4() {
        return hurikaekz4;
    }

    public void setHurikaekz4(String pHurikaekz4) {
        hurikaekz4 = pHurikaekz4;
    }

    private String hurikaekz5;

    @Column(name=GenIT_KouzahuriStartAnnai.HURIKAEKZ5)
    public String getHurikaekz5() {
        return hurikaekz5;
    }

    public void setHurikaekz5(String pHurikaekz5) {
        hurikaekz5 = pHurikaekz5;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASESOSIKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    private String toiawaseyno;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String toiawaseteluktkkanou1;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_KouzahuriStartAnnai.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_KouzahuriStartAnnai.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_KouzahuriStartAnnai.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String kzhuristartanfreearea1;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA1)
    public String getKzhuristartanfreearea1() {
        return kzhuristartanfreearea1;
    }

    public void setKzhuristartanfreearea1(String pKzhuristartanfreearea1) {
        kzhuristartanfreearea1 = pKzhuristartanfreearea1;
    }

    private String kzhuristartanfreearea2;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA2)
    public String getKzhuristartanfreearea2() {
        return kzhuristartanfreearea2;
    }

    public void setKzhuristartanfreearea2(String pKzhuristartanfreearea2) {
        kzhuristartanfreearea2 = pKzhuristartanfreearea2;
    }

    private String kzhuristartanfreearea3;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA3)
    public String getKzhuristartanfreearea3() {
        return kzhuristartanfreearea3;
    }

    public void setKzhuristartanfreearea3(String pKzhuristartanfreearea3) {
        kzhuristartanfreearea3 = pKzhuristartanfreearea3;
    }

    private String kzhuristartanfreearea4;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA4)
    public String getKzhuristartanfreearea4() {
        return kzhuristartanfreearea4;
    }

    public void setKzhuristartanfreearea4(String pKzhuristartanfreearea4) {
        kzhuristartanfreearea4 = pKzhuristartanfreearea4;
    }

    private String kzhuristartanfreearea5;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA5)
    public String getKzhuristartanfreearea5() {
        return kzhuristartanfreearea5;
    }

    public void setKzhuristartanfreearea5(String pKzhuristartanfreearea5) {
        kzhuristartanfreearea5 = pKzhuristartanfreearea5;
    }

    private String kzhuristartanfreearea6;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA6)
    public String getKzhuristartanfreearea6() {
        return kzhuristartanfreearea6;
    }

    public void setKzhuristartanfreearea6(String pKzhuristartanfreearea6) {
        kzhuristartanfreearea6 = pKzhuristartanfreearea6;
    }

    private String kzhuristartanfreearea7;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA7)
    public String getKzhuristartanfreearea7() {
        return kzhuristartanfreearea7;
    }

    public void setKzhuristartanfreearea7(String pKzhuristartanfreearea7) {
        kzhuristartanfreearea7 = pKzhuristartanfreearea7;
    }

    private String kzhuristartanfreearea8;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA8)
    public String getKzhuristartanfreearea8() {
        return kzhuristartanfreearea8;
    }

    public void setKzhuristartanfreearea8(String pKzhuristartanfreearea8) {
        kzhuristartanfreearea8 = pKzhuristartanfreearea8;
    }

    private String kzhuristartanfreearea9;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA9)
    public String getKzhuristartanfreearea9() {
        return kzhuristartanfreearea9;
    }

    public void setKzhuristartanfreearea9(String pKzhuristartanfreearea9) {
        kzhuristartanfreearea9 = pKzhuristartanfreearea9;
    }

    private String kzhuristartanfreearea10;

    @Column(name=GenIT_KouzahuriStartAnnai.KZHURISTARTANFREEAREA10)
    public String getKzhuristartanfreearea10() {
        return kzhuristartanfreearea10;
    }

    public void setKzhuristartanfreearea10(String pKzhuristartanfreearea10) {
        kzhuristartanfreearea10 = pKzhuristartanfreearea10;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KouzahuriStartAnnai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KouzahuriStartAnnai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KouzahuriStartAnnai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}