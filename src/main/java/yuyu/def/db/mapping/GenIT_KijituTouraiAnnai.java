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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.id.PKIT_KijituTouraiAnnai;
import yuyu.def.db.meta.GenQIT_KijituTouraiAnnai;
import yuyu.def.db.meta.QIT_KijituTouraiAnnai;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 期日到来案内テーブル テーブルのマッピング情報クラスで、 {@link IT_KijituTouraiAnnai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KijituTouraiAnnai}</td><td colspan="3">期日到来案内テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KijituTouraiAnnai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KijituTouraiAnnai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_KijituTouraiAnnai ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getTuutinm20keta tuutinm20keta}</td><td>通知名称（２０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta1 hrkykkmsg32keta1}</td><td>振替予告メッセージ（３２桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta2 hrkykkmsg32keta2}</td><td>振替予告メッセージ（３２桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta3 hrkykkmsg32keta3}</td><td>振替予告メッセージ（３２桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta4 hrkykkmsg32keta4}</td><td>振替予告メッセージ（３２桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta5 hrkykkmsg32keta5}</td><td>振替予告メッセージ（３２桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta6 hrkykkmsg32keta6}</td><td>振替予告メッセージ（３２桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta7 hrkykkmsg32keta7}</td><td>振替予告メッセージ（３２桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg32keta8 hrkykkmsg32keta8}</td><td>振替予告メッセージ（３２桁）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea1 kjttrnnfreearea1}</td><td>期日到来案内フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea2 kjttrnnfreearea2}</td><td>期日到来案内フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea3 kjttrnnfreearea3}</td><td>期日到来案内フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea4 kjttrnnfreearea4}</td><td>期日到来案内フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea5 kjttrnnfreearea5}</td><td>期日到来案内フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea6 kjttrnnfreearea6}</td><td>期日到来案内フリーエリア６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea7 kjttrnnfreearea7}</td><td>期日到来案内フリーエリア７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKzinfo1 kzinfo1}</td><td>口座情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo2 kzinfo2}</td><td>口座情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo3 kzinfo3}</td><td>口座情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo4 kzinfo4}</td><td>口座情報４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo5 kzinfo5}</td><td>口座情報５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo6 kzinfo6}</td><td>口座情報６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo7 kzinfo7}</td><td>口座情報７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo8 kzinfo8}</td><td>口座情報８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknjytukikan hknjytukikan}</td><td>保険充当期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkgk1 hrkgk1}</td><td>払込金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkgk2 hrkgk2}</td><td>払込金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkgk3 hrkgk3}</td><td>払込金額３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkgk4 hrkgk4}</td><td>払込金額４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea8 kjttrnnfreearea8}</td><td>期日到来案内フリーエリア８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea9 kjttrnnfreearea9}</td><td>期日到来案内フリーエリア９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea10 kjttrnnfreearea10}</td><td>期日到来案内フリーエリア１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea11 kjttrnnfreearea11}</td><td>期日到来案内フリーエリア１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea12 kjttrnnfreearea12}</td><td>期日到来案内フリーエリア１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjttrnnfreearea13 kjttrnnfreearea13}</td><td>期日到来案内フリーエリア１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KijituTouraiAnnai
 * @see     PKIT_KijituTouraiAnnai
 * @see     QIT_KijituTouraiAnnai
 * @see     GenQIT_KijituTouraiAnnai
 */
@MappedSuperclass
@Table(name=GenIT_KijituTouraiAnnai.TABLE_NAME)
@IdClass(value=PKIT_KijituTouraiAnnai.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_KijituTouraiAnnai extends AbstractExDBEntity<IT_KijituTouraiAnnai, PKIT_KijituTouraiAnnai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KijituTouraiAnnai";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
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
    public static final String TUUTINM20KETA            = "tuutinm20keta";
    public static final String HRKYKKMSG32KETA1         = "hrkykkmsg32keta1";
    public static final String HRKYKKMSG32KETA2         = "hrkykkmsg32keta2";
    public static final String HRKYKKMSG32KETA3         = "hrkykkmsg32keta3";
    public static final String HRKYKKMSG32KETA4         = "hrkykkmsg32keta4";
    public static final String HRKYKKMSG32KETA5         = "hrkykkmsg32keta5";
    public static final String HRKYKKMSG32KETA6         = "hrkykkmsg32keta6";
    public static final String HRKYKKMSG32KETA7         = "hrkykkmsg32keta7";
    public static final String HRKYKKMSG32KETA8         = "hrkykkmsg32keta8";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String KYKYMD                   = "kykymd";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String KJTTRNNFREEAREA1         = "kjttrnnfreearea1";
    public static final String KJTTRNNFREEAREA2         = "kjttrnnfreearea2";
    public static final String KJTTRNNFREEAREA3         = "kjttrnnfreearea3";
    public static final String KJTTRNNFREEAREA4         = "kjttrnnfreearea4";
    public static final String KJTTRNNFREEAREA5         = "kjttrnnfreearea5";
    public static final String KJTTRNNFREEAREA6         = "kjttrnnfreearea6";
    public static final String KJTTRNNFREEAREA7         = "kjttrnnfreearea7";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String KZINFO1                  = "kzinfo1";
    public static final String KZINFO2                  = "kzinfo2";
    public static final String KZINFO3                  = "kzinfo3";
    public static final String KZINFO4                  = "kzinfo4";
    public static final String KZINFO5                  = "kzinfo5";
    public static final String KZINFO6                  = "kzinfo6";
    public static final String KZINFO7                  = "kzinfo7";
    public static final String KZINFO8                  = "kzinfo8";
    public static final String HKNJYTUKIKAN             = "hknjytukikan";
    public static final String HRKGK1                   = "hrkgk1";
    public static final String HRKGK2                   = "hrkgk2";
    public static final String HRKGK3                   = "hrkgk3";
    public static final String HRKGK4                   = "hrkgk4";
    public static final String KJTTRNNFREEAREA8         = "kjttrnnfreearea8";
    public static final String KJTTRNNFREEAREA9         = "kjttrnnfreearea9";
    public static final String KJTTRNNFREEAREA10        = "kjttrnnfreearea10";
    public static final String KJTTRNNFREEAREA11        = "kjttrnnfreearea11";
    public static final String KJTTRNNFREEAREA12        = "kjttrnnfreearea12";
    public static final String KJTTRNNFREEAREA13        = "kjttrnnfreearea13";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KijituTouraiAnnai primaryKey;

    public GenIT_KijituTouraiAnnai() {
        primaryKey = new PKIT_KijituTouraiAnnai();
    }

    public GenIT_KijituTouraiAnnai(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_KijituTouraiAnnai(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_KijituTouraiAnnai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KijituTouraiAnnai> getMetaClass() {
        return QIT_KijituTouraiAnnai.class;
    }

    @Id
    @Column(name=GenIT_KijituTouraiAnnai.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KijituTouraiAnnai.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_KijituTouraiAnnai.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String shskyno;

    @Column(name=GenIT_KijituTouraiAnnai.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIT_KijituTouraiAnnai.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIT_KijituTouraiAnnai.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIT_KijituTouraiAnnai.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIT_KijituTouraiAnnai.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASETELNO)
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

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_KijituTouraiAnnai.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private String tuutinm20keta;

    @Column(name=GenIT_KijituTouraiAnnai.TUUTINM20KETA)
    public String getTuutinm20keta() {
        return tuutinm20keta;
    }

    public void setTuutinm20keta(String pTuutinm20keta) {
        tuutinm20keta = pTuutinm20keta;
    }

    private String hrkykkmsg32keta1;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA1)
    public String getHrkykkmsg32keta1() {
        return hrkykkmsg32keta1;
    }

    public void setHrkykkmsg32keta1(String pHrkykkmsg32keta1) {
        hrkykkmsg32keta1 = pHrkykkmsg32keta1;
    }

    private String hrkykkmsg32keta2;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA2)
    public String getHrkykkmsg32keta2() {
        return hrkykkmsg32keta2;
    }

    public void setHrkykkmsg32keta2(String pHrkykkmsg32keta2) {
        hrkykkmsg32keta2 = pHrkykkmsg32keta2;
    }

    private String hrkykkmsg32keta3;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA3)
    public String getHrkykkmsg32keta3() {
        return hrkykkmsg32keta3;
    }

    public void setHrkykkmsg32keta3(String pHrkykkmsg32keta3) {
        hrkykkmsg32keta3 = pHrkykkmsg32keta3;
    }

    private String hrkykkmsg32keta4;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA4)
    public String getHrkykkmsg32keta4() {
        return hrkykkmsg32keta4;
    }

    public void setHrkykkmsg32keta4(String pHrkykkmsg32keta4) {
        hrkykkmsg32keta4 = pHrkykkmsg32keta4;
    }

    private String hrkykkmsg32keta5;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA5)
    public String getHrkykkmsg32keta5() {
        return hrkykkmsg32keta5;
    }

    public void setHrkykkmsg32keta5(String pHrkykkmsg32keta5) {
        hrkykkmsg32keta5 = pHrkykkmsg32keta5;
    }

    private String hrkykkmsg32keta6;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA6)
    public String getHrkykkmsg32keta6() {
        return hrkykkmsg32keta6;
    }

    public void setHrkykkmsg32keta6(String pHrkykkmsg32keta6) {
        hrkykkmsg32keta6 = pHrkykkmsg32keta6;
    }

    private String hrkykkmsg32keta7;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA7)
    public String getHrkykkmsg32keta7() {
        return hrkykkmsg32keta7;
    }

    public void setHrkykkmsg32keta7(String pHrkykkmsg32keta7) {
        hrkykkmsg32keta7 = pHrkykkmsg32keta7;
    }

    private String hrkykkmsg32keta8;

    @Column(name=GenIT_KijituTouraiAnnai.HRKYKKMSG32KETA8)
    public String getHrkykkmsg32keta8() {
        return hrkykkmsg32keta8;
    }

    public void setHrkykkmsg32keta8(String pHrkykkmsg32keta8) {
        hrkykkmsg32keta8 = pHrkykkmsg32keta8;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_KijituTouraiAnnai.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String syouhnnm;

    @Column(name=GenIT_KijituTouraiAnnai.SYOUHNNM)
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

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KijituTouraiAnnai.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String hhknnmkj;

    @Column(name=GenIT_KijituTouraiAnnai.HHKNNMKJ)
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

    private String kjttrnnfreearea1;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA1)
    public String getKjttrnnfreearea1() {
        return kjttrnnfreearea1;
    }

    public void setKjttrnnfreearea1(String pKjttrnnfreearea1) {
        kjttrnnfreearea1 = pKjttrnnfreearea1;
    }

    private String kjttrnnfreearea2;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA2)
    public String getKjttrnnfreearea2() {
        return kjttrnnfreearea2;
    }

    public void setKjttrnnfreearea2(String pKjttrnnfreearea2) {
        kjttrnnfreearea2 = pKjttrnnfreearea2;
    }

    private String kjttrnnfreearea3;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA3)
    public String getKjttrnnfreearea3() {
        return kjttrnnfreearea3;
    }

    public void setKjttrnnfreearea3(String pKjttrnnfreearea3) {
        kjttrnnfreearea3 = pKjttrnnfreearea3;
    }

    private String kjttrnnfreearea4;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA4)
    public String getKjttrnnfreearea4() {
        return kjttrnnfreearea4;
    }

    public void setKjttrnnfreearea4(String pKjttrnnfreearea4) {
        kjttrnnfreearea4 = pKjttrnnfreearea4;
    }

    private String kjttrnnfreearea5;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA5)
    public String getKjttrnnfreearea5() {
        return kjttrnnfreearea5;
    }

    public void setKjttrnnfreearea5(String pKjttrnnfreearea5) {
        kjttrnnfreearea5 = pKjttrnnfreearea5;
    }

    private String kjttrnnfreearea6;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA6)
    public String getKjttrnnfreearea6() {
        return kjttrnnfreearea6;
    }

    public void setKjttrnnfreearea6(String pKjttrnnfreearea6) {
        kjttrnnfreearea6 = pKjttrnnfreearea6;
    }

    private String kjttrnnfreearea7;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA7)
    public String getKjttrnnfreearea7() {
        return kjttrnnfreearea7;
    }

    public void setKjttrnnfreearea7(String pKjttrnnfreearea7) {
        kjttrnnfreearea7 = pKjttrnnfreearea7;
    }

    private BizDate hurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KijituTouraiAnnai.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

    private String kzinfo1;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO1)
    public String getKzinfo1() {
        return kzinfo1;
    }

    public void setKzinfo1(String pKzinfo1) {
        kzinfo1 = pKzinfo1;
    }

    private String kzinfo2;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO2)
    public String getKzinfo2() {
        return kzinfo2;
    }

    public void setKzinfo2(String pKzinfo2) {
        kzinfo2 = pKzinfo2;
    }

    private String kzinfo3;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO3)
    public String getKzinfo3() {
        return kzinfo3;
    }

    public void setKzinfo3(String pKzinfo3) {
        kzinfo3 = pKzinfo3;
    }

    private String kzinfo4;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO4)
    public String getKzinfo4() {
        return kzinfo4;
    }

    public void setKzinfo4(String pKzinfo4) {
        kzinfo4 = pKzinfo4;
    }

    private String kzinfo5;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO5)
    public String getKzinfo5() {
        return kzinfo5;
    }

    public void setKzinfo5(String pKzinfo5) {
        kzinfo5 = pKzinfo5;
    }

    private String kzinfo6;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO6)
    public String getKzinfo6() {
        return kzinfo6;
    }

    public void setKzinfo6(String pKzinfo6) {
        kzinfo6 = pKzinfo6;
    }

    private String kzinfo7;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO7)
    public String getKzinfo7() {
        return kzinfo7;
    }

    public void setKzinfo7(String pKzinfo7) {
        kzinfo7 = pKzinfo7;
    }

    private String kzinfo8;

    @Column(name=GenIT_KijituTouraiAnnai.KZINFO8)
    public String getKzinfo8() {
        return kzinfo8;
    }

    public void setKzinfo8(String pKzinfo8) {
        kzinfo8 = pKzinfo8;
    }

    private String hknjytukikan;

    @Column(name=GenIT_KijituTouraiAnnai.HKNJYTUKIKAN)
    public String getHknjytukikan() {
        return hknjytukikan;
    }

    public void setHknjytukikan(String pHknjytukikan) {
        hknjytukikan = pHknjytukikan;
    }

    private String hrkgk1;

    @Column(name=GenIT_KijituTouraiAnnai.HRKGK1)
    public String getHrkgk1() {
        return hrkgk1;
    }

    public void setHrkgk1(String pHrkgk1) {
        hrkgk1 = pHrkgk1;
    }

    private String hrkgk2;

    @Column(name=GenIT_KijituTouraiAnnai.HRKGK2)
    public String getHrkgk2() {
        return hrkgk2;
    }

    public void setHrkgk2(String pHrkgk2) {
        hrkgk2 = pHrkgk2;
    }

    private String hrkgk3;

    @Column(name=GenIT_KijituTouraiAnnai.HRKGK3)
    public String getHrkgk3() {
        return hrkgk3;
    }

    public void setHrkgk3(String pHrkgk3) {
        hrkgk3 = pHrkgk3;
    }

    private String hrkgk4;

    @Column(name=GenIT_KijituTouraiAnnai.HRKGK4)
    public String getHrkgk4() {
        return hrkgk4;
    }

    public void setHrkgk4(String pHrkgk4) {
        hrkgk4 = pHrkgk4;
    }

    private String kjttrnnfreearea8;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA8)
    public String getKjttrnnfreearea8() {
        return kjttrnnfreearea8;
    }

    public void setKjttrnnfreearea8(String pKjttrnnfreearea8) {
        kjttrnnfreearea8 = pKjttrnnfreearea8;
    }

    private String kjttrnnfreearea9;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA9)
    public String getKjttrnnfreearea9() {
        return kjttrnnfreearea9;
    }

    public void setKjttrnnfreearea9(String pKjttrnnfreearea9) {
        kjttrnnfreearea9 = pKjttrnnfreearea9;
    }

    private String kjttrnnfreearea10;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA10)
    public String getKjttrnnfreearea10() {
        return kjttrnnfreearea10;
    }

    public void setKjttrnnfreearea10(String pKjttrnnfreearea10) {
        kjttrnnfreearea10 = pKjttrnnfreearea10;
    }

    private String kjttrnnfreearea11;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA11)
    public String getKjttrnnfreearea11() {
        return kjttrnnfreearea11;
    }

    public void setKjttrnnfreearea11(String pKjttrnnfreearea11) {
        kjttrnnfreearea11 = pKjttrnnfreearea11;
    }

    private String kjttrnnfreearea12;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA12)
    public String getKjttrnnfreearea12() {
        return kjttrnnfreearea12;
    }

    public void setKjttrnnfreearea12(String pKjttrnnfreearea12) {
        kjttrnnfreearea12 = pKjttrnnfreearea12;
    }

    private String kjttrnnfreearea13;

    @Column(name=GenIT_KijituTouraiAnnai.KJTTRNNFREEAREA13)
    public String getKjttrnnfreearea13() {
        return kjttrnnfreearea13;
    }

    public void setKjttrnnfreearea13(String pKjttrnnfreearea13) {
        kjttrnnfreearea13 = pKjttrnnfreearea13;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_KijituTouraiAnnai.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_KijituTouraiAnnai.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KijituTouraiAnnai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KijituTouraiAnnai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KijituTouraiAnnai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}