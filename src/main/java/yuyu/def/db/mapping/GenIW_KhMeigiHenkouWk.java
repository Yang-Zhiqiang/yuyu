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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkaijyoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.db.id.PKIW_KhMeigiHenkouWk;
import yuyu.def.db.meta.GenQIW_KhMeigiHenkouWk;
import yuyu.def.db.meta.QIW_KhMeigiHenkouWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Meigihnkjiyuu;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TyhysakuseiyhKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktkaijyoKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 名義変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhMeigiHenkouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhMeigiHenkouWk}</td><td colspan="3">名義変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhMeigiHenkouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMeigihnkjiyuu meigihnkjiyuu}</td><td>名義変更事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Meigihnkjiyuu}</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkjkhukakbn kyknmkjkhukakbn}</td><td>契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getKkkyktdk kkkyktdk}</td><td>契約管理契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkjkhukakbn hhknnmkjkhukakbn}</td><td>被保険者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getNenkinuktkbn nenkinuktkbn}</td><td>年金受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSbuktkaijyokbn1 sbuktkaijyokbn1}</td><td>死亡受取人解除区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkaijyoKbn}</td></tr>
 *  <tr><td>{@link #getSbuktkbn1 sbuktkbn1}</td><td>死亡受取人区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getSbuktnmkn1 sbuktnmkn1}</td><td>死亡受取人名（カナ）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj1 sbuktnmkj1}</td><td>死亡受取人名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkjhukakbn1 sbuktnmkjhukakbn1}</td><td>死亡受取人名漢字化不可区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getSbuktseiymd1 sbuktseiymd1}</td><td>死亡受取人生年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSbuktbnwari1 sbuktbnwari1}</td><td>死亡受取人分割割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSbuktkaijyokbn2 sbuktkaijyokbn2}</td><td>死亡受取人解除区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkaijyoKbn}</td></tr>
 *  <tr><td>{@link #getSbuktkbn2 sbuktkbn2}</td><td>死亡受取人区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getSbuktnmkn2 sbuktnmkn2}</td><td>死亡受取人名（カナ）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj2 sbuktnmkj2}</td><td>死亡受取人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkjhukakbn2 sbuktnmkjhukakbn2}</td><td>死亡受取人名漢字化不可区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getSbuktseiymd2 sbuktseiymd2}</td><td>死亡受取人生年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSbuktbnwari2 sbuktbnwari2}</td><td>死亡受取人分割割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSbuktkaijyokbn3 sbuktkaijyokbn3}</td><td>死亡受取人解除区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkaijyoKbn}</td></tr>
 *  <tr><td>{@link #getSbuktkbn3 sbuktkbn3}</td><td>死亡受取人区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getSbuktnmkn3 sbuktnmkn3}</td><td>死亡受取人名（カナ）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj3 sbuktnmkj3}</td><td>死亡受取人名（漢字）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkjhukakbn3 sbuktnmkjhukakbn3}</td><td>死亡受取人名漢字化不可区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getSbuktseiymd3 sbuktseiymd3}</td><td>死亡受取人生年月日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSbuktbnwari3 sbuktbnwari3}</td><td>死亡受取人分割割合３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSbuktkaijyokbn4 sbuktkaijyokbn4}</td><td>死亡受取人解除区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkaijyoKbn}</td></tr>
 *  <tr><td>{@link #getSbuktkbn4 sbuktkbn4}</td><td>死亡受取人区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getSbuktnmkn4 sbuktnmkn4}</td><td>死亡受取人名（カナ）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj4 sbuktnmkj4}</td><td>死亡受取人名（漢字）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkjhukakbn4 sbuktnmkjhukakbn4}</td><td>死亡受取人名漢字化不可区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getSbuktseiymd4 sbuktseiymd4}</td><td>死亡受取人生年月日４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSbuktbnwari4 sbuktbnwari4}</td><td>死亡受取人分割割合４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getStdrskkaijyokbn stdrskkaijyokbn}</td><td>指定代理請求人解除区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkaijyoKbn}</td></tr>
 *  <tr><td>{@link #getStdruktkbn stdruktkbn}</td><td>指定代理受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getStdrsknmkn stdrsknmkn}</td><td>指定代理請求人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkj stdrsknmkj}</td><td>指定代理請求人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkjhukakbn stdrsknmkjhukakbn}</td><td>指定代理請求人名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getTyhysakuseiyhkbn tyhysakuseiyhkbn}</td><td>帳票作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhysakuseiyhKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAdrhenkouumu adrhenkouumu}</td><td>住所変更有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkyksibouymd oldkyksibouymd}</td><td>（旧）契約者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getStdrskseiymd stdrskseiymd}</td><td>指定代理請求人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IW_KhMeigiHenkouWk
 * @see     PKIW_KhMeigiHenkouWk
 * @see     QIW_KhMeigiHenkouWk
 * @see     GenQIW_KhMeigiHenkouWk
 */
@MappedSuperclass
@Table(name=GenIW_KhMeigiHenkouWk.TABLE_NAME)
@IdClass(value=PKIW_KhMeigiHenkouWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_Meigihnkjiyuu", typeClass=UserType_C_Meigihnkjiyuu.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TyhysakuseiyhKbn", typeClass=UserType_C_TyhysakuseiyhKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class),
    @TypeDef(name="UserType_C_UktkaijyoKbn", typeClass=UserType_C_UktkaijyoKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIW_KhMeigiHenkouWk extends AbstractExDBEntity<IW_KhMeigiHenkouWk, PKIW_KhMeigiHenkouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhMeigiHenkouWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String MEIGIHNKJIYUU            = "meigihnkjiyuu";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKJKHUKAKBN          = "kyknmkjkhukakbn";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKSEI                   = "kyksei";
    public static final String KKKYKTDK                 = "kkkyktdk";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKJKHUKAKBN         = "hhknnmkjkhukakbn";
    public static final String NENKINUKTKBN             = "nenkinuktkbn";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String SBUKTKAIJYOKBN1          = "sbuktkaijyokbn1";
    public static final String SBUKTKBN1                = "sbuktkbn1";
    public static final String SBUKTNMKN1               = "sbuktnmkn1";
    public static final String SBUKTNMKJ1               = "sbuktnmkj1";
    public static final String SBUKTNMKJHUKAKBN1        = "sbuktnmkjhukakbn1";
    public static final String SBUKTSEIYMD1             = "sbuktseiymd1";
    public static final String SBUKTBNWARI1             = "sbuktbnwari1";
    public static final String SBUKTKAIJYOKBN2          = "sbuktkaijyokbn2";
    public static final String SBUKTKBN2                = "sbuktkbn2";
    public static final String SBUKTNMKN2               = "sbuktnmkn2";
    public static final String SBUKTNMKJ2               = "sbuktnmkj2";
    public static final String SBUKTNMKJHUKAKBN2        = "sbuktnmkjhukakbn2";
    public static final String SBUKTSEIYMD2             = "sbuktseiymd2";
    public static final String SBUKTBNWARI2             = "sbuktbnwari2";
    public static final String SBUKTKAIJYOKBN3          = "sbuktkaijyokbn3";
    public static final String SBUKTKBN3                = "sbuktkbn3";
    public static final String SBUKTNMKN3               = "sbuktnmkn3";
    public static final String SBUKTNMKJ3               = "sbuktnmkj3";
    public static final String SBUKTNMKJHUKAKBN3        = "sbuktnmkjhukakbn3";
    public static final String SBUKTSEIYMD3             = "sbuktseiymd3";
    public static final String SBUKTBNWARI3             = "sbuktbnwari3";
    public static final String SBUKTKAIJYOKBN4          = "sbuktkaijyokbn4";
    public static final String SBUKTKBN4                = "sbuktkbn4";
    public static final String SBUKTNMKN4               = "sbuktnmkn4";
    public static final String SBUKTNMKJ4               = "sbuktnmkj4";
    public static final String SBUKTNMKJHUKAKBN4        = "sbuktnmkjhukakbn4";
    public static final String SBUKTSEIYMD4             = "sbuktseiymd4";
    public static final String SBUKTBNWARI4             = "sbuktbnwari4";
    public static final String STDRSKKAIJYOKBN          = "stdrskkaijyokbn";
    public static final String STDRUKTKBN               = "stdruktkbn";
    public static final String STDRSKNMKN               = "stdrsknmkn";
    public static final String STDRSKNMKJ               = "stdrsknmkj";
    public static final String STDRSKNMKJHUKAKBN        = "stdrsknmkjhukakbn";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String TYHYSAKUSEIYHKBN         = "tyhysakuseiyhkbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String ADRHENKOUUMU             = "adrhenkouumu";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String OLDKYKSIBOUYMD           = "oldkyksibouymd";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String STDRSKSEIYMD             = "stdrskseiymd";

    private final PKIW_KhMeigiHenkouWk primaryKey;

    public GenIW_KhMeigiHenkouWk() {
        primaryKey = new PKIW_KhMeigiHenkouWk();
    }

    public GenIW_KhMeigiHenkouWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhMeigiHenkouWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhMeigiHenkouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhMeigiHenkouWk> getMetaClass() {
        return QIW_KhMeigiHenkouWk.class;
    }

    @Id
    @Column(name=GenIW_KhMeigiHenkouWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhMeigiHenkouWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDate skssakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_Meigihnkjiyuu meigihnkjiyuu;

    @Type(type="UserType_C_Meigihnkjiyuu")
    @Column(name=GenIW_KhMeigiHenkouWk.MEIGIHNKJIYUU)
    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        meigihnkjiyuu = pMeigihnkjiyuu;
    }

    private String kyknmkn;

    @Column(name=GenIW_KhMeigiHenkouWk.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenIW_KhMeigiHenkouWk.KYKNMKJ)
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

    private C_KjkhukaKbn kyknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.KYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenIW_KhMeigiHenkouWk.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private C_Tdk kkkyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIW_KhMeigiHenkouWk.KKKYKTDK)
    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        kkkyktdk = pKkkyktdk;
    }

    private String hhknnmkn;

    @Column(name=GenIW_KhMeigiHenkouWk.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenIW_KhMeigiHenkouWk.HHKNNMKJ)
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

    private C_KjkhukaKbn hhknnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.HHKNNMKJKHUKAKBN)
    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
    }

    private C_UktKbn nenkinuktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.NENKINUKTKBN)
    public C_UktKbn getNenkinuktkbn() {
        return nenkinuktkbn;
    }

    public void setNenkinuktkbn(C_UktKbn pNenkinuktkbn) {
        nenkinuktkbn = pNenkinuktkbn;
    }

    private Integer sbuktnin;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn1;

    @Type(type="UserType_C_UktkaijyoKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKAIJYOKBN1)
    public C_UktkaijyoKbn getSbuktkaijyokbn1() {
        return sbuktkaijyokbn1;
    }

    public void setSbuktkaijyokbn1(C_UktkaijyoKbn pSbuktkaijyokbn1) {
        sbuktkaijyokbn1 = pSbuktkaijyokbn1;
    }

    private C_UktKbn sbuktkbn1;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKBN1)
    public C_UktKbn getSbuktkbn1() {
        return sbuktkbn1;
    }

    public void setSbuktkbn1(C_UktKbn pSbuktkbn1) {
        sbuktkbn1 = pSbuktkbn1;
    }

    private String sbuktnmkn1;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKN1)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn1() {
        return sbuktnmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn1(String pSbuktnmkn1) {
        sbuktnmkn1 = pSbuktnmkn1;
    }

    private String sbuktnmkj1;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJ1)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj1() {
        return sbuktnmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj1(String pSbuktnmkj1) {
        sbuktnmkj1 = pSbuktnmkj1;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn1;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJHUKAKBN1)
    public C_KjkhukaKbn getSbuktnmkjhukakbn1() {
        return sbuktnmkjhukakbn1;
    }

    public void setSbuktnmkjhukakbn1(C_KjkhukaKbn pSbuktnmkjhukakbn1) {
        sbuktnmkjhukakbn1 = pSbuktnmkjhukakbn1;
    }

    private BizDate sbuktseiymd1;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTSEIYMD1)
    @ValidDate
    public BizDate getSbuktseiymd1() {
        return sbuktseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd1(BizDate pSbuktseiymd1) {
        sbuktseiymd1 = pSbuktseiymd1;
    }

    private BizNumber sbuktbnwari1;

    @Type(type="BizNumberType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTBNWARI1)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getSbuktbnwari1() {
        return sbuktbnwari1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari1(BizNumber pSbuktbnwari1) {
        sbuktbnwari1 = pSbuktbnwari1;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn2;

    @Type(type="UserType_C_UktkaijyoKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKAIJYOKBN2)
    public C_UktkaijyoKbn getSbuktkaijyokbn2() {
        return sbuktkaijyokbn2;
    }

    public void setSbuktkaijyokbn2(C_UktkaijyoKbn pSbuktkaijyokbn2) {
        sbuktkaijyokbn2 = pSbuktkaijyokbn2;
    }

    private C_UktKbn sbuktkbn2;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKBN2)
    public C_UktKbn getSbuktkbn2() {
        return sbuktkbn2;
    }

    public void setSbuktkbn2(C_UktKbn pSbuktkbn2) {
        sbuktkbn2 = pSbuktkbn2;
    }

    private String sbuktnmkn2;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKN2)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn2() {
        return sbuktnmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn2(String pSbuktnmkn2) {
        sbuktnmkn2 = pSbuktnmkn2;
    }

    private String sbuktnmkj2;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj2() {
        return sbuktnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj2(String pSbuktnmkj2) {
        sbuktnmkj2 = pSbuktnmkj2;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn2;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJHUKAKBN2)
    public C_KjkhukaKbn getSbuktnmkjhukakbn2() {
        return sbuktnmkjhukakbn2;
    }

    public void setSbuktnmkjhukakbn2(C_KjkhukaKbn pSbuktnmkjhukakbn2) {
        sbuktnmkjhukakbn2 = pSbuktnmkjhukakbn2;
    }

    private BizDate sbuktseiymd2;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTSEIYMD2)
    @ValidDate
    public BizDate getSbuktseiymd2() {
        return sbuktseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd2(BizDate pSbuktseiymd2) {
        sbuktseiymd2 = pSbuktseiymd2;
    }

    private BizNumber sbuktbnwari2;

    @Type(type="BizNumberType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTBNWARI2)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getSbuktbnwari2() {
        return sbuktbnwari2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari2(BizNumber pSbuktbnwari2) {
        sbuktbnwari2 = pSbuktbnwari2;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn3;

    @Type(type="UserType_C_UktkaijyoKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKAIJYOKBN3)
    public C_UktkaijyoKbn getSbuktkaijyokbn3() {
        return sbuktkaijyokbn3;
    }

    public void setSbuktkaijyokbn3(C_UktkaijyoKbn pSbuktkaijyokbn3) {
        sbuktkaijyokbn3 = pSbuktkaijyokbn3;
    }

    private C_UktKbn sbuktkbn3;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKBN3)
    public C_UktKbn getSbuktkbn3() {
        return sbuktkbn3;
    }

    public void setSbuktkbn3(C_UktKbn pSbuktkbn3) {
        sbuktkbn3 = pSbuktkbn3;
    }

    private String sbuktnmkn3;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKN3)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn3() {
        return sbuktnmkn3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn3(String pSbuktnmkn3) {
        sbuktnmkn3 = pSbuktnmkn3;
    }

    private String sbuktnmkj3;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJ3)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj3() {
        return sbuktnmkj3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj3(String pSbuktnmkj3) {
        sbuktnmkj3 = pSbuktnmkj3;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn3;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJHUKAKBN3)
    public C_KjkhukaKbn getSbuktnmkjhukakbn3() {
        return sbuktnmkjhukakbn3;
    }

    public void setSbuktnmkjhukakbn3(C_KjkhukaKbn pSbuktnmkjhukakbn3) {
        sbuktnmkjhukakbn3 = pSbuktnmkjhukakbn3;
    }

    private BizDate sbuktseiymd3;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTSEIYMD3)
    @ValidDate
    public BizDate getSbuktseiymd3() {
        return sbuktseiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd3(BizDate pSbuktseiymd3) {
        sbuktseiymd3 = pSbuktseiymd3;
    }

    private BizNumber sbuktbnwari3;

    @Type(type="BizNumberType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTBNWARI3)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getSbuktbnwari3() {
        return sbuktbnwari3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari3(BizNumber pSbuktbnwari3) {
        sbuktbnwari3 = pSbuktbnwari3;
    }

    private C_UktkaijyoKbn sbuktkaijyokbn4;

    @Type(type="UserType_C_UktkaijyoKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKAIJYOKBN4)
    public C_UktkaijyoKbn getSbuktkaijyokbn4() {
        return sbuktkaijyokbn4;
    }

    public void setSbuktkaijyokbn4(C_UktkaijyoKbn pSbuktkaijyokbn4) {
        sbuktkaijyokbn4 = pSbuktkaijyokbn4;
    }

    private C_UktKbn sbuktkbn4;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTKBN4)
    public C_UktKbn getSbuktkbn4() {
        return sbuktkbn4;
    }

    public void setSbuktkbn4(C_UktKbn pSbuktkbn4) {
        sbuktkbn4 = pSbuktkbn4;
    }

    private String sbuktnmkn4;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKN4)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn4() {
        return sbuktnmkn4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn4(String pSbuktnmkn4) {
        sbuktnmkn4 = pSbuktnmkn4;
    }

    private String sbuktnmkj4;

    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJ4)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj4() {
        return sbuktnmkj4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj4(String pSbuktnmkj4) {
        sbuktnmkj4 = pSbuktnmkj4;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn4;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTNMKJHUKAKBN4)
    public C_KjkhukaKbn getSbuktnmkjhukakbn4() {
        return sbuktnmkjhukakbn4;
    }

    public void setSbuktnmkjhukakbn4(C_KjkhukaKbn pSbuktnmkjhukakbn4) {
        sbuktnmkjhukakbn4 = pSbuktnmkjhukakbn4;
    }

    private BizDate sbuktseiymd4;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTSEIYMD4)
    @ValidDate
    public BizDate getSbuktseiymd4() {
        return sbuktseiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd4(BizDate pSbuktseiymd4) {
        sbuktseiymd4 = pSbuktseiymd4;
    }

    private BizNumber sbuktbnwari4;

    @Type(type="BizNumberType")
    @Column(name=GenIW_KhMeigiHenkouWk.SBUKTBNWARI4)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getSbuktbnwari4() {
        return sbuktbnwari4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari4(BizNumber pSbuktbnwari4) {
        sbuktbnwari4 = pSbuktbnwari4;
    }

    private C_UktkaijyoKbn stdrskkaijyokbn;

    @Type(type="UserType_C_UktkaijyoKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.STDRSKKAIJYOKBN)
    public C_UktkaijyoKbn getStdrskkaijyokbn() {
        return stdrskkaijyokbn;
    }

    public void setStdrskkaijyokbn(C_UktkaijyoKbn pStdrskkaijyokbn) {
        stdrskkaijyokbn = pStdrskkaijyokbn;
    }

    private C_UktKbn stdruktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.STDRUKTKBN)
    public C_UktKbn getStdruktkbn() {
        return stdruktkbn;
    }

    public void setStdruktkbn(C_UktKbn pStdruktkbn) {
        stdruktkbn = pStdruktkbn;
    }

    private String stdrsknmkn;

    @Column(name=GenIW_KhMeigiHenkouWk.STDRSKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getStdrsknmkn() {
        return stdrsknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkn(String pStdrsknmkn) {
        stdrsknmkn = pStdrsknmkn;
    }

    private String stdrsknmkj;

    @Column(name=GenIW_KhMeigiHenkouWk.STDRSKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getStdrsknmkj() {
        return stdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrsknmkj = pStdrsknmkj;
    }

    private C_KjkhukaKbn stdrsknmkjhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.STDRSKNMKJHUKAKBN)
    public C_KjkhukaKbn getStdrsknmkjhukakbn() {
        return stdrsknmkjhukakbn;
    }

    public void setStdrsknmkjhukakbn(C_KjkhukaKbn pStdrsknmkjhukakbn) {
        stdrsknmkjhukakbn = pStdrsknmkjhukakbn;
    }

    private String shsnmkj;

    @Column(name=GenIW_KhMeigiHenkouWk.SHSNMKJ)
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

    private String shskyno;

    @Column(name=GenIW_KhMeigiHenkouWk.SHSKYNO)
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

    @Column(name=GenIW_KhMeigiHenkouWk.SHSADR1KJ)
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

    @Column(name=GenIW_KhMeigiHenkouWk.SHSADR2KJ)
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

    @Column(name=GenIW_KhMeigiHenkouWk.SHSADR3KJ)
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

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_TyhysakuseiyhKbn tyhysakuseiyhkbn;

    @Type(type="UserType_C_TyhysakuseiyhKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.TYHYSAKUSEIYHKBN)
    public C_TyhysakuseiyhKbn getTyhysakuseiyhkbn() {
        return tyhysakuseiyhkbn;
    }

    public void setTyhysakuseiyhkbn(C_TyhysakuseiyhKbn pTyhysakuseiyhkbn) {
        tyhysakuseiyhkbn = pTyhysakuseiyhkbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhMeigiHenkouWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhMeigiHenkouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhMeigiHenkouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_UmuKbn adrhenkouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_KhMeigiHenkouWk.ADRHENKOUUMU)
    public C_UmuKbn getAdrhenkouumu() {
        return adrhenkouumu;
    }

    public void setAdrhenkouumu(C_UmuKbn pAdrhenkouumu) {
        adrhenkouumu = pAdrhenkouumu;
    }

    private String tsinyno;

    @Column(name=GenIW_KhMeigiHenkouWk.TSINYNO)
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

    @Column(name=GenIW_KhMeigiHenkouWk.TSINADR1KJ)
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

    @Column(name=GenIW_KhMeigiHenkouWk.TSINADR2KJ)
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

    @Column(name=GenIW_KhMeigiHenkouWk.TSINADR3KJ)
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

    private String tsintelno;

    @Column(name=GenIW_KhMeigiHenkouWk.TSINTELNO)
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

    @Column(name=GenIW_KhMeigiHenkouWk.DAI2TSINTELNO)
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

    private BizDate oldkyksibouymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.OLDKYKSIBOUYMD)
    @ValidDate
    public BizDate getOldkyksibouymd() {
        return oldkyksibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkyksibouymd(BizDate pOldkyksibouymd) {
        oldkyksibouymd = pOldkyksibouymd;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate stdrskseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhMeigiHenkouWk.STDRSKSEIYMD)
    @ValidDate
    public BizDate getStdrskseiymd() {
        return stdrskseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setStdrskseiymd(BizDate pStdrskseiymd) {
        stdrskseiymd = pStdrskseiymd;
    }
}