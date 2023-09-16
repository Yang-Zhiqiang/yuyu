package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.id.PKHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.GenQHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.QHW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.type.UserType_C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_IjitoukeiHokensyuruiKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiTikShrTkykKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiZennouKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_SirajiKykKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 主契約複合疾患増幅ワークテーブル テーブルのマッピング情報クラスで、 {@link HW_SyuHukugouSikkanZhkWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_SyuHukugouSikkanZhkWk}</td><td colspan="3">主契約複合疾患増幅ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKHW_SyuHukugouSikkanZhkWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknnendo hknnendo}</td><td>保険年度</td><td align="center">{@link PKHW_SyuHukugouSikkanZhkWk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIjitoukeidaihyousyurui ijitoukeidaihyousyurui}</td><td>医事統計用代表種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknendo kyknendo}</td><td>契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getKykage kykage}</td><td>加入年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getToutatunenrei toutatunenrei}</td><td>到達年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAtukaibetu atukaibetu}</td><td>扱別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIjitoukeisinsahouhou ijitoukeisinsahouhou}</td><td>医事統計用診査方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetteikekkaa ketteikekkaa}</td><td>決定結果Ａ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSibousrank sibousrank}</td><td>死亡Ｓランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJissituhosyousrank jissituhosyousrank}</td><td>実質保障Ｓランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSirajikykkbn sirajikykkbn}</td><td>白地契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SirajiKykKbn}</td></tr>
 *  <tr><td>{@link #getHrkhouhoukbn hrkhouhoukbn}</td><td>払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIjitoukeihokensyuruikbn ijitoukeihokensyuruikbn}</td><td>医事統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiHokensyuruiKbn}</td></tr>
 *  <tr><td>{@link #getDaisiincd daisiincd}</td><td>大死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyuusiincd tyuusiincd}</td><td>中死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiincd siincd}</td><td>死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenreihousikikbn nenreihousikikbn}</td><td>年令方式区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntodouhukencd hhkntodouhukencd}</td><td>被保険者都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBotaisisyaeigyouhonbu botaisisyaeigyouhonbu}</td><td>母体支社営業本部</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisyaeigyoubu sisyaeigyoubu}</td><td>支社営業部</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAatsukaishasoshikicd aatsukaishasoshikicd}</td><td>Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnensyuukbn hhknnensyuukbn}</td><td>被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getHanbaikeirokbn hanbaikeirokbn}</td><td>販売経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuudairitenatkikeitaikbn bosyuudairitenatkikeitaikbn}</td><td>募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BosyuuDairitenAtkiKeitaiKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaumu jyudkaigomeharaitkhukaumu}</td><td>重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIjitoukeizennoukbn ijitoukeizennoukbn}</td><td>医事統計用前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiZennouKbn}</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIjitoukeitikshrtkykkbn ijitoukeitikshrtkykkbn}</td><td>医事統計用定期支払特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiTikShrTkykKbn}</td></tr>
 *  <tr><td>{@link #getIjitoukeikeikan ijitoukeikeikan}</td><td>医事統計用経過Ｎ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getIjitoukeisiboun ijitoukeisiboun}</td><td>医事統計用死亡Ｎ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIjitoukeikeikas ijitoukeikeikas}</td><td>医事統計用経過Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getIjitoukeisibous ijitoukeisibous}</td><td>医事統計用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HW_SyuHukugouSikkanZhkWk
 * @see     PKHW_SyuHukugouSikkanZhkWk
 * @see     QHW_SyuHukugouSikkanZhkWk
 * @see     GenQHW_SyuHukugouSikkanZhkWk
 */
@MappedSuperclass
@Table(name=GenHW_SyuHukugouSikkanZhkWk.TABLE_NAME)
@IdClass(value=PKHW_SyuHukugouSikkanZhkWk.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BosyuuDairitenAtkiKeitaiKbn", typeClass=UserType_C_BosyuuDairitenAtkiKeitaiKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_IjitoukeiHokensyuruiKbn", typeClass=UserType_C_IjitoukeiHokensyuruiKbn.class),
    @TypeDef(name="UserType_C_IjitoukeiTikShrTkykKbn", typeClass=UserType_C_IjitoukeiTikShrTkykKbn.class),
    @TypeDef(name="UserType_C_IjitoukeiZennouKbn", typeClass=UserType_C_IjitoukeiZennouKbn.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class),
    @TypeDef(name="UserType_C_SirajiKykKbn", typeClass=UserType_C_SirajiKykKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHW_SyuHukugouSikkanZhkWk extends AbstractExDBEntity<HW_SyuHukugouSikkanZhkWk, PKHW_SyuHukugouSikkanZhkWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_SyuHukugouSikkanZhkWk";
    public static final String SYONO                    = "syono";
    public static final String HKNNENDO                 = "hknnendo";
    public static final String IJITOUKEIDAIHYOUSYURUI   = "ijitoukeidaihyousyurui";
    public static final String KYKNENDO                 = "kyknendo";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String KYKAGE                   = "kykage";
    public static final String TOUTATUNENREI            = "toutatunenrei";
    public static final String ATUKAIBETU               = "atukaibetu";
    public static final String IJITOUKEISINSAHOUHOU     = "ijitoukeisinsahouhou";
    public static final String KETTEIKEKKAA             = "ketteikekkaa";
    public static final String SIBOUSRANK               = "sibousrank";
    public static final String JISSITUHOSYOUSRANK       = "jissituhosyousrank";
    public static final String SIRAJIKYKKBN             = "sirajikykkbn";
    public static final String HRKHOUHOUKBN             = "hrkhouhoukbn";
    public static final String IJITOUKEIHOKENSYURUIKBN  = "ijitoukeihokensyuruikbn";
    public static final String DAISIINCD                = "daisiincd";
    public static final String TYUUSIINCD               = "tyuusiincd";
    public static final String SIINCD                   = "siincd";
    public static final String NENREIHOUSIKIKBN         = "nenreihousikikbn";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String HHKNTODOUHUKENCD         = "hhkntodouhukencd";
    public static final String BOTAISISYAEIGYOUHONBU    = "botaisisyaeigyouhonbu";
    public static final String SISYAEIGYOUBU            = "sisyaeigyoubu";
    public static final String AATSUKAISHASOSHIKICD     = "aatsukaishasoshikicd";
    public static final String HHKNNENSYUUKBN           = "hhknnensyuukbn";
    public static final String HANBAIKEIROKBN           = "hanbaikeirokbn";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String BOSYUUDAIRITENATKIKEITAIKBN = "bosyuudairitenatkikeitaikbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String JYUDKAIGOMEHARAITKHUKAUMU = "jyudkaigomeharaitkhukaumu";
    public static final String IJITOUKEIZENNOUKBN       = "ijitoukeizennoukbn";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String IJITOUKEITIKSHRTKYKKBN   = "ijitoukeitikshrtkykkbn";
    public static final String IJITOUKEIKEIKAN          = "ijitoukeikeikan";
    public static final String IJITOUKEISIBOUN          = "ijitoukeisiboun";
    public static final String IJITOUKEIKEIKAS          = "ijitoukeikeikas";
    public static final String IJITOUKEISIBOUS          = "ijitoukeisibous";

    private final PKHW_SyuHukugouSikkanZhkWk primaryKey;

    public GenHW_SyuHukugouSikkanZhkWk() {
        primaryKey = new PKHW_SyuHukugouSikkanZhkWk();
    }

    public GenHW_SyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo) {
        primaryKey = new PKHW_SyuHukugouSikkanZhkWk(pSyono, pHknnendo);
    }

    @Transient
    @Override
    public PKHW_SyuHukugouSikkanZhkWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_SyuHukugouSikkanZhkWk> getMetaClass() {
        return QHW_SyuHukugouSikkanZhkWk.class;
    }

    @Id
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.SYONO)
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
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HKNNENDO)
    public Integer getHknnendo() {
        return getPrimaryKey().getHknnendo();
    }

    public void setHknnendo(Integer pHknnendo) {
        getPrimaryKey().setHknnendo(pHknnendo);
    }

    private String ijitoukeidaihyousyurui;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEIDAIHYOUSYURUI)
    public String getIjitoukeidaihyousyurui() {
        return ijitoukeidaihyousyurui;
    }

    public void setIjitoukeidaihyousyurui(String pIjitoukeidaihyousyurui) {
        ijitoukeidaihyousyurui = pIjitoukeidaihyousyurui;
    }

    private String kyknendo;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.KYKNENDO)
    public String getKyknendo() {
        return kyknendo;
    }

    public void setKyknendo(String pKyknendo) {
        kyknendo = pKyknendo;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private Integer kykage;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.KYKAGE)
    public Integer getKykage() {
        return kykage;
    }

    public void setKykage(Integer pKykage) {
        kykage = pKykage;
    }

    private Integer toutatunenrei;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.TOUTATUNENREI)
    public Integer getToutatunenrei() {
        return toutatunenrei;
    }

    public void setToutatunenrei(Integer pToutatunenrei) {
        toutatunenrei = pToutatunenrei;
    }

    private String atukaibetu;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.ATUKAIBETU)
    public String getAtukaibetu() {
        return atukaibetu;
    }

    public void setAtukaibetu(String pAtukaibetu) {
        atukaibetu = pAtukaibetu;
    }

    private String ijitoukeisinsahouhou;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEISINSAHOUHOU)
    public String getIjitoukeisinsahouhou() {
        return ijitoukeisinsahouhou;
    }

    public void setIjitoukeisinsahouhou(String pIjitoukeisinsahouhou) {
        ijitoukeisinsahouhou = pIjitoukeisinsahouhou;
    }

    private String ketteikekkaa;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.KETTEIKEKKAA)
    public String getKetteikekkaa() {
        return ketteikekkaa;
    }

    public void setKetteikekkaa(String pKetteikekkaa) {
        ketteikekkaa = pKetteikekkaa;
    }

    private String sibousrank;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.SIBOUSRANK)
    public String getSibousrank() {
        return sibousrank;
    }

    public void setSibousrank(String pSibousrank) {
        sibousrank = pSibousrank;
    }

    private String jissituhosyousrank;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.JISSITUHOSYOUSRANK)
    public String getJissituhosyousrank() {
        return jissituhosyousrank;
    }

    public void setJissituhosyousrank(String pJissituhosyousrank) {
        jissituhosyousrank = pJissituhosyousrank;
    }

    private C_SirajiKykKbn sirajikykkbn;

    @Type(type="UserType_C_SirajiKykKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.SIRAJIKYKKBN)
    public C_SirajiKykKbn getSirajikykkbn() {
        return sirajikykkbn;
    }

    public void setSirajikykkbn(C_SirajiKykKbn pSirajikykkbn) {
        sirajikykkbn = pSirajikykkbn;
    }

    private String hrkhouhoukbn;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HRKHOUHOUKBN)
    public String getHrkhouhoukbn() {
        return hrkhouhoukbn;
    }

    public void setHrkhouhoukbn(String pHrkhouhoukbn) {
        hrkhouhoukbn = pHrkhouhoukbn;
    }

    private C_IjitoukeiHokensyuruiKbn ijitoukeihokensyuruikbn;

    @Type(type="UserType_C_IjitoukeiHokensyuruiKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEIHOKENSYURUIKBN)
    public C_IjitoukeiHokensyuruiKbn getIjitoukeihokensyuruikbn() {
        return ijitoukeihokensyuruikbn;
    }

    public void setIjitoukeihokensyuruikbn(C_IjitoukeiHokensyuruiKbn pIjitoukeihokensyuruikbn) {
        ijitoukeihokensyuruikbn = pIjitoukeihokensyuruikbn;
    }

    private String daisiincd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.DAISIINCD)
    public String getDaisiincd() {
        return daisiincd;
    }

    public void setDaisiincd(String pDaisiincd) {
        daisiincd = pDaisiincd;
    }

    private String tyuusiincd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.TYUUSIINCD)
    public String getTyuusiincd() {
        return tyuusiincd;
    }

    public void setTyuusiincd(String pTyuusiincd) {
        tyuusiincd = pTyuusiincd;
    }

    private String siincd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.SIINCD)
    public String getSiincd() {
        return siincd;
    }

    public void setSiincd(String pSiincd) {
        siincd = pSiincd;
    }

    private String nenreihousikikbn;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.NENREIHOUSIKIKBN)
    public String getNenreihousikikbn() {
        return nenreihousikikbn;
    }

    public void setNenreihousikikbn(String pNenreihousikikbn) {
        nenreihousikikbn = pNenreihousikikbn;
    }

    private String hhknsykgycd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HHKNSYKGYCD)
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

    private String hhkntodouhukencd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HHKNTODOUHUKENCD)
    public String getHhkntodouhukencd() {
        return hhkntodouhukencd;
    }

    public void setHhkntodouhukencd(String pHhkntodouhukencd) {
        hhkntodouhukencd = pHhkntodouhukencd;
    }

    private String botaisisyaeigyouhonbu;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.BOTAISISYAEIGYOUHONBU)
    public String getBotaisisyaeigyouhonbu() {
        return botaisisyaeigyouhonbu;
    }

    public void setBotaisisyaeigyouhonbu(String pBotaisisyaeigyouhonbu) {
        botaisisyaeigyouhonbu = pBotaisisyaeigyouhonbu;
    }

    private String sisyaeigyoubu;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.SISYAEIGYOUBU)
    public String getSisyaeigyoubu() {
        return sisyaeigyoubu;
    }

    public void setSisyaeigyoubu(String pSisyaeigyoubu) {
        sisyaeigyoubu = pSisyaeigyoubu;
    }

    private String aatsukaishasoshikicd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.AATSUKAISHASOSHIKICD)
    public String getAatsukaishasoshikicd() {
        return aatsukaishasoshikicd;
    }

    public void setAatsukaishasoshikicd(String pAatsukaishasoshikicd) {
        aatsukaishasoshikicd = pAatsukaishasoshikicd;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HHKNNENSYUUKBN)
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private String hanbaikeirokbn;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HANBAIKEIROKBN)
    public String getHanbaikeirokbn() {
        return hanbaikeirokbn;
    }

    public void setHanbaikeirokbn(String pHanbaikeirokbn) {
        hanbaikeirokbn = pHanbaikeirokbn;
    }

    private String oyadrtencd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String tratkiagcd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private C_BosyuuDairitenAtkiKeitaiKbn bosyuudairitenatkikeitaikbn;

    @Type(type="UserType_C_BosyuuDairitenAtkiKeitaiKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.BOSYUUDAIRITENATKIKEITAIKBN)
    public C_BosyuuDairitenAtkiKeitaiKbn getBosyuudairitenatkikeitaikbn() {
        return bosyuudairitenatkikeitaikbn;
    }

    public void setBosyuudairitenatkikeitaikbn(C_BosyuuDairitenAtkiKeitaiKbn pBosyuudairitenatkikeitaikbn) {
        bosyuudairitenatkikeitaikbn = pBosyuudairitenatkikeitaikbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    private String syouhncd;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.JYUDKAIGOMEHARAITKHUKAUMU)
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {
        return jyudkaigomeharaitkhukaumu;
    }

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu) {
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
    }

    private C_IjitoukeiZennouKbn ijitoukeizennoukbn;

    @Type(type="UserType_C_IjitoukeiZennouKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEIZENNOUKBN)
    public C_IjitoukeiZennouKbn getIjitoukeizennoukbn() {
        return ijitoukeizennoukbn;
    }

    public void setIjitoukeizennoukbn(C_IjitoukeiZennouKbn pIjitoukeizennoukbn) {
        ijitoukeizennoukbn = pIjitoukeizennoukbn;
    }

    private Integer dai1hknkkn;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private C_IjitoukeiTikShrTkykKbn ijitoukeitikshrtkykkbn;

    @Type(type="UserType_C_IjitoukeiTikShrTkykKbn")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEITIKSHRTKYKKBN)
    public C_IjitoukeiTikShrTkykKbn getIjitoukeitikshrtkykkbn() {
        return ijitoukeitikshrtkykkbn;
    }

    public void setIjitoukeitikshrtkykkbn(C_IjitoukeiTikShrTkykKbn pIjitoukeitikshrtkykkbn) {
        ijitoukeitikshrtkykkbn = pIjitoukeitikshrtkykkbn;
    }

    private BizNumber ijitoukeikeikan;

    @Type(type="BizNumberType")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEIKEIKAN)
    public BizNumber getIjitoukeikeikan() {
        return ijitoukeikeikan;
    }

    public void setIjitoukeikeikan(BizNumber pIjitoukeikeikan) {
        ijitoukeikeikan = pIjitoukeikeikan;
    }

    private Integer ijitoukeisiboun;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEISIBOUN)
    public Integer getIjitoukeisiboun() {
        return ijitoukeisiboun;
    }

    public void setIjitoukeisiboun(Integer pIjitoukeisiboun) {
        ijitoukeisiboun = pIjitoukeisiboun;
    }

    private BizNumber ijitoukeikeikas;

    @Type(type="BizNumberType")
    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEIKEIKAS)
    public BizNumber getIjitoukeikeikas() {
        return ijitoukeikeikas;
    }

    public void setIjitoukeikeikas(BizNumber pIjitoukeikeikas) {
        ijitoukeikeikas = pIjitoukeikeikas;
    }

    private Integer ijitoukeisibous;

    @Column(name=GenHW_SyuHukugouSikkanZhkWk.IJITOUKEISIBOUS)
    public Integer getIjitoukeisibous() {
        return ijitoukeisibous;
    }

    public void setIjitoukeisibous(Integer pIjitoukeisibous) {
        ijitoukeisibous = pIjitoukeisibous;
    }
}