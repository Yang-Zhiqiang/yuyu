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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AzukarijikiKbn;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.id.PKIT_AzukarikinKessankanri;
import yuyu.def.db.meta.GenQIT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;
import yuyu.def.db.type.UserType_C_AzukarijikiKbn;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 預り金決算管理テーブル テーブルのマッピング情報クラスで、 {@link IT_AzukarikinKessankanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AzukarikinKessankanri}</td><td colspan="3">預り金決算管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_AzukarikinKessankanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">{@link PKIT_AzukarikinKessankanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_AzukarikinKessankanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKIT_AzukarikinKessankanri ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYuukousyoumetukbn yuukousyoumetukbn}</td><td>有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAzukarikinhsiymd azukarikinhsiymd}</td><td>預り金発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAzukarigankin azukarigankin}</td><td>預り元金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAzukarijikikbn azukarijikikbn}</td><td>預り時期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AzukarijikiKbn}</td></tr>
 *  <tr><td>{@link #getAzukariganrikin azukariganrikin}</td><td>預り元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTounendgankin tounendgankin}</td><td>当年度元金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTounendrsk tounendrsk}</td><td>当年度利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKwsratekjymd kwsratekjymd}</td><td>為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKawaserate kawaserate}</td><td>為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGaikaazukariganrikin gaikaazukariganrikin}</td><td>外貨預り元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikatounendgankin gaikatounendgankin}</td><td>外貨当年度元金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikatounendrsk gaikatounendrsk}</td><td>外貨当年度利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikashrkwsratekjnymd gaikashrkwsratekjnymd}</td><td>外貨支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGaikashrkwsrate gaikashrkwsrate}</td><td>外貨支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGaikaknsnmaeazukariganrikin gaikaknsnmaeazukariganrikin}</td><td>外貨換算前預り元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikaknsnmaetounendgankin gaikaknsnmaetounendgankin}</td><td>外貨換算前当年度元金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikaknsnmaetounendrsk gaikaknsnmaetounendrsk}</td><td>外貨換算前当年度利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAzukarikinshrgk azukarikinshrgk}</td><td>預り金支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAzukarikinshrrskgk azukarikinshrrskgk}</td><td>預り金支払利息額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTounendsyoumetuukemishrgk tounendsyoumetuukemishrgk}</td><td>当年度消滅受付未支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSinbikinkeirskgk sinbikinkeirskgk}</td><td>新備金計上利息額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBknjkukbn bknjkukbn}</td><td>備金時効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknJkuKbn}</td></tr>
 *  <tr><td>{@link #getBikinkeiymd bikinkeiymd}</td><td>備金計上日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getTounendrsksyukeisitu tounendrsksyukeisitu}</td><td>当年度利息（主計室用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennendrsksyukeisitu zennendrsksyukeisitu}</td><td>前年度利息（主計室用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKwsratekjymd1q kwsratekjymd1q}</td><td>（１Ｑ）為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKawaserate1q kawaserate1q}</td><td>（１Ｑ）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getAzukarikinrsk1q azukarikinrsk1q}</td><td>（１Ｑ）預り金利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKwsratekjymd2q kwsratekjymd2q}</td><td>（２Ｑ）為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKawaserate2q kawaserate2q}</td><td>（２Ｑ）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getAzukarikinrsk2q azukarikinrsk2q}</td><td>（２Ｑ）預り金利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKwsratekjymd3q kwsratekjymd3q}</td><td>（３Ｑ）為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKawaserate3q kawaserate3q}</td><td>（３Ｑ）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getAzukarikinrsk3q azukarikinrsk3q}</td><td>（３Ｑ）預り金利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKwsratekjymd4q kwsratekjymd4q}</td><td>（４Ｑ）為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKawaserate4q kawaserate4q}</td><td>（４Ｑ）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getAzukarikinrsk4q azukarikinrsk4q}</td><td>（４Ｑ）預り金利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AzukarikinKessankanri
 * @see     PKIT_AzukarikinKessankanri
 * @see     QIT_AzukarikinKessankanri
 * @see     GenQIT_AzukarikinKessankanri
 */
@MappedSuperclass
@Table(name=GenIT_AzukarikinKessankanri.TABLE_NAME)
@IdClass(value=PKIT_AzukarikinKessankanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AzukarijikiKbn", typeClass=UserType_C_AzukarijikiKbn.class),
    @TypeDef(name="UserType_C_BknJkuKbn", typeClass=UserType_C_BknJkuKbn.class),
    @TypeDef(name="UserType_C_BkncdKbn", typeClass=UserType_C_BkncdKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_YuukousyoumetuKbn", typeClass=UserType_C_YuukousyoumetuKbn.class)
})
public abstract class GenIT_AzukarikinKessankanri extends AbstractExDBEntity<IT_AzukarikinKessankanri, PKIT_AzukarikinKessankanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_AzukarikinKessankanri";
    public static final String SYONO                    = "syono";
    public static final String KESSANKIJYUNYMD          = "kessankijyunymd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYKYMD                   = "kykymd";
    public static final String YUUKOUSYOUMETUKBN        = "yuukousyoumetukbn";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String AZUKARIKINHSIYMD         = "azukarikinhsiymd";
    public static final String AZUKARIGANKIN            = "azukarigankin";
    public static final String AZUKARIJIKIKBN           = "azukarijikikbn";
    public static final String AZUKARIGANRIKIN          = "azukariganrikin";
    public static final String TOUNENDGANKIN            = "tounendgankin";
    public static final String TOUNENDRSK               = "tounendrsk";
    public static final String KWSRATEKJYMD             = "kwsratekjymd";
    public static final String KAWASERATE               = "kawaserate";
    public static final String GAIKAAZUKARIGANRIKIN     = "gaikaazukariganrikin";
    public static final String GAIKATOUNENDGANKIN       = "gaikatounendgankin";
    public static final String GAIKATOUNENDRSK          = "gaikatounendrsk";
    public static final String GAIKASHRKWSRATEKJNYMD    = "gaikashrkwsratekjnymd";
    public static final String GAIKASHRKWSRATE          = "gaikashrkwsrate";
    public static final String GAIKAKNSNMAEAZUKARIGANRIKIN = "gaikaknsnmaeazukariganrikin";
    public static final String GAIKAKNSNMAETOUNENDGANKIN = "gaikaknsnmaetounendgankin";
    public static final String GAIKAKNSNMAETOUNENDRSK   = "gaikaknsnmaetounendrsk";
    public static final String AZUKARIKINSHRGK          = "azukarikinshrgk";
    public static final String AZUKARIKINSHRRSKGK       = "azukarikinshrrskgk";
    public static final String TOUNENDSYOUMETUUKEMISHRGK = "tounendsyoumetuukemishrgk";
    public static final String SINBIKINKEIRSKGK         = "sinbikinkeirskgk";
    public static final String BKNJKUKBN                = "bknjkukbn";
    public static final String BIKINKEIYMD              = "bikinkeiymd";
    public static final String BKNCDKBN                 = "bkncdkbn";
    public static final String TOUNENDRSKSYUKEISITU     = "tounendrsksyukeisitu";
    public static final String ZENNENDRSKSYUKEISITU     = "zennendrsksyukeisitu";
    public static final String KWSRATEKJYMD1Q           = "kwsratekjymd1q";
    public static final String KAWASERATE1Q             = "kawaserate1q";
    public static final String AZUKARIKINRSK1Q          = "azukarikinrsk1q";
    public static final String KWSRATEKJYMD2Q           = "kwsratekjymd2q";
    public static final String KAWASERATE2Q             = "kawaserate2q";
    public static final String AZUKARIKINRSK2Q          = "azukarikinrsk2q";
    public static final String KWSRATEKJYMD3Q           = "kwsratekjymd3q";
    public static final String KAWASERATE3Q             = "kawaserate3q";
    public static final String AZUKARIKINRSK3Q          = "azukarikinrsk3q";
    public static final String KWSRATEKJYMD4Q           = "kwsratekjymd4q";
    public static final String KAWASERATE4Q             = "kawaserate4q";
    public static final String AZUKARIKINRSK4Q          = "azukarikinrsk4q";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_AzukarikinKessankanri primaryKey;

    public GenIT_AzukarikinKessankanri() {
        primaryKey = new PKIT_AzukarikinKessankanri();
    }

    public GenIT_AzukarikinKessankanri(
        String pSyono,
        BizDate pKessankijyunymd,
        String pHenkousikibetukey,
        C_Tuukasyu pTuukasyu
    ) {
        primaryKey = new PKIT_AzukarikinKessankanri(
            pSyono,
            pKessankijyunymd,
            pHenkousikibetukey,
            pTuukasyu
        );
    }

    @Transient
    @Override
    public PKIT_AzukarikinKessankanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_AzukarikinKessankanri> getMetaClass() {
        return QIT_AzukarikinKessankanri.class;
    }

    @Id
    @Column(name=GenIT_AzukarikinKessankanri.SYONO)
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
    @Column(name=GenIT_AzukarikinKessankanri.KESSANKIJYUNYMD)
    @ValidDate
    public BizDate getKessankijyunymd() {
        return getPrimaryKey().getKessankijyunymd();
    }

    @Trim("both")
    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        getPrimaryKey().setKessankijyunymd(pKessankijyunymd);
    }

    @Id
    @Column(name=GenIT_AzukarikinKessankanri.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_AzukarikinKessankanri.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    private String syouhncd;

    @Column(name=GenIT_AzukarikinKessankanri.SYOUHNCD)
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

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Type(type="UserType_C_YuukousyoumetuKbn")
    @Column(name=GenIT_AzukarikinKessankanri.YUUKOUSYOUMETUKBN)
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenIT_AzukarikinKessankanri.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private C_Segcd kbnkeirisegcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_AzukarikinKessankanri.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private BizDate azukarikinhsiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.AZUKARIKINHSIYMD)
    public BizDate getAzukarikinhsiymd() {
        return azukarikinhsiymd;
    }

    public void setAzukarikinhsiymd(BizDate pAzukarikinhsiymd) {
        azukarikinhsiymd = pAzukarikinhsiymd;
    }

    private BizCurrency azukarigankin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarigankin() {
        return azukarigankin;
    }

    public void setAzukarigankin(BizCurrency pAzukarigankin) {
        azukarigankin = pAzukarigankin;
        azukarigankinValue = null;
        azukarigankinType  = null;
    }

    transient private BigDecimal azukarigankinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIGANKIN, nullable=true)
    protected BigDecimal getAzukarigankinValue() {
        if (azukarigankinValue == null && azukarigankin != null) {
            if (azukarigankin.isOptional()) return null;
            return azukarigankin.absolute();
        }
        return azukarigankinValue;
    }

    protected void setAzukarigankinValue(BigDecimal value) {
        azukarigankinValue = value;
        azukarigankin = Optional.fromNullable(toCurrencyType(azukarigankinType))
            .transform(bizCurrencyTransformer(getAzukarigankinValue()))
            .orNull();
    }

    transient private String azukarigankinType = null;

    @Column(name=AZUKARIGANKIN + "$", nullable=true)
    protected String getAzukarigankinType() {
        if (azukarigankinType == null && azukarigankin != null) return azukarigankin.getType().toString();
        if (azukarigankinType == null && getAzukarigankinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarigankin$' should not be NULL."));
        }
        return azukarigankinType;
    }

    protected void setAzukarigankinType(String type) {
        azukarigankinType = type;
        azukarigankin = Optional.fromNullable(toCurrencyType(azukarigankinType))
            .transform(bizCurrencyTransformer(getAzukarigankinValue()))
            .orNull();
    }

    private C_AzukarijikiKbn azukarijikikbn;

    @Type(type="UserType_C_AzukarijikiKbn")
    @Column(name=GenIT_AzukarikinKessankanri.AZUKARIJIKIKBN)
    public C_AzukarijikiKbn getAzukarijikikbn() {
        return azukarijikikbn;
    }

    public void setAzukarijikikbn(C_AzukarijikiKbn pAzukarijikikbn) {
        azukarijikikbn = pAzukarijikikbn;
    }

    private BizCurrency azukariganrikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukariganrikin() {
        return azukariganrikin;
    }

    public void setAzukariganrikin(BizCurrency pAzukariganrikin) {
        azukariganrikin = pAzukariganrikin;
        azukariganrikinValue = null;
        azukariganrikinType  = null;
    }

    transient private BigDecimal azukariganrikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIGANRIKIN, nullable=true)
    protected BigDecimal getAzukariganrikinValue() {
        if (azukariganrikinValue == null && azukariganrikin != null) {
            if (azukariganrikin.isOptional()) return null;
            return azukariganrikin.absolute();
        }
        return azukariganrikinValue;
    }

    protected void setAzukariganrikinValue(BigDecimal value) {
        azukariganrikinValue = value;
        azukariganrikin = Optional.fromNullable(toCurrencyType(azukariganrikinType))
            .transform(bizCurrencyTransformer(getAzukariganrikinValue()))
            .orNull();
    }

    transient private String azukariganrikinType = null;

    @Column(name=AZUKARIGANRIKIN + "$", nullable=true)
    protected String getAzukariganrikinType() {
        if (azukariganrikinType == null && azukariganrikin != null) return azukariganrikin.getType().toString();
        if (azukariganrikinType == null && getAzukariganrikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukariganrikin$' should not be NULL."));
        }
        return azukariganrikinType;
    }

    protected void setAzukariganrikinType(String type) {
        azukariganrikinType = type;
        azukariganrikin = Optional.fromNullable(toCurrencyType(azukariganrikinType))
            .transform(bizCurrencyTransformer(getAzukariganrikinValue()))
            .orNull();
    }

    private BizCurrency tounendgankin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendgankin() {
        return tounendgankin;
    }

    public void setTounendgankin(BizCurrency pTounendgankin) {
        tounendgankin = pTounendgankin;
        tounendgankinValue = null;
        tounendgankinType  = null;
    }

    transient private BigDecimal tounendgankinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDGANKIN, nullable=true)
    protected BigDecimal getTounendgankinValue() {
        if (tounendgankinValue == null && tounendgankin != null) {
            if (tounendgankin.isOptional()) return null;
            return tounendgankin.absolute();
        }
        return tounendgankinValue;
    }

    protected void setTounendgankinValue(BigDecimal value) {
        tounendgankinValue = value;
        tounendgankin = Optional.fromNullable(toCurrencyType(tounendgankinType))
            .transform(bizCurrencyTransformer(getTounendgankinValue()))
            .orNull();
    }

    transient private String tounendgankinType = null;

    @Column(name=TOUNENDGANKIN + "$", nullable=true)
    protected String getTounendgankinType() {
        if (tounendgankinType == null && tounendgankin != null) return tounendgankin.getType().toString();
        if (tounendgankinType == null && getTounendgankinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendgankin$' should not be NULL."));
        }
        return tounendgankinType;
    }

    protected void setTounendgankinType(String type) {
        tounendgankinType = type;
        tounendgankin = Optional.fromNullable(toCurrencyType(tounendgankinType))
            .transform(bizCurrencyTransformer(getTounendgankinValue()))
            .orNull();
    }

    private BizCurrency tounendrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendrsk() {
        return tounendrsk;
    }

    public void setTounendrsk(BizCurrency pTounendrsk) {
        tounendrsk = pTounendrsk;
        tounendrskValue = null;
        tounendrskType  = null;
    }

    transient private BigDecimal tounendrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDRSK, nullable=true)
    protected BigDecimal getTounendrskValue() {
        if (tounendrskValue == null && tounendrsk != null) {
            if (tounendrsk.isOptional()) return null;
            return tounendrsk.absolute();
        }
        return tounendrskValue;
    }

    protected void setTounendrskValue(BigDecimal value) {
        tounendrskValue = value;
        tounendrsk = Optional.fromNullable(toCurrencyType(tounendrskType))
            .transform(bizCurrencyTransformer(getTounendrskValue()))
            .orNull();
    }

    transient private String tounendrskType = null;

    @Column(name=TOUNENDRSK + "$", nullable=true)
    protected String getTounendrskType() {
        if (tounendrskType == null && tounendrsk != null) return tounendrsk.getType().toString();
        if (tounendrskType == null && getTounendrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendrsk$' should not be NULL."));
        }
        return tounendrskType;
    }

    protected void setTounendrskType(String type) {
        tounendrskType = type;
        tounendrsk = Optional.fromNullable(toCurrencyType(tounendrskType))
            .transform(bizCurrencyTransformer(getTounendrskValue()))
            .orNull();
    }

    private BizDate kwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.KWSRATEKJYMD)
    public BizDate getKwsratekjymd() {
        return kwsratekjymd;
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        kwsratekjymd = pKwsratekjymd;
    }

    private BizNumber kawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AzukarikinKessankanri.KAWASERATE)
    public BizNumber getKawaserate() {
        return kawaserate;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    private BizCurrency gaikaazukariganrikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikaazukariganrikin() {
        return gaikaazukariganrikin;
    }

    public void setGaikaazukariganrikin(BizCurrency pGaikaazukariganrikin) {
        gaikaazukariganrikin = pGaikaazukariganrikin;
        gaikaazukariganrikinValue = null;
        gaikaazukariganrikinType  = null;
    }

    transient private BigDecimal gaikaazukariganrikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAAZUKARIGANRIKIN, nullable=true)
    protected BigDecimal getGaikaazukariganrikinValue() {
        if (gaikaazukariganrikinValue == null && gaikaazukariganrikin != null) {
            if (gaikaazukariganrikin.isOptional()) return null;
            return gaikaazukariganrikin.absolute();
        }
        return gaikaazukariganrikinValue;
    }

    protected void setGaikaazukariganrikinValue(BigDecimal value) {
        gaikaazukariganrikinValue = value;
        gaikaazukariganrikin = Optional.fromNullable(toCurrencyType(gaikaazukariganrikinType))
            .transform(bizCurrencyTransformer(getGaikaazukariganrikinValue()))
            .orNull();
    }

    transient private String gaikaazukariganrikinType = null;

    @Column(name=GAIKAAZUKARIGANRIKIN + "$", nullable=true)
    protected String getGaikaazukariganrikinType() {
        if (gaikaazukariganrikinType == null && gaikaazukariganrikin != null) return gaikaazukariganrikin.getType().toString();
        if (gaikaazukariganrikinType == null && getGaikaazukariganrikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikaazukariganrikin$' should not be NULL."));
        }
        return gaikaazukariganrikinType;
    }

    protected void setGaikaazukariganrikinType(String type) {
        gaikaazukariganrikinType = type;
        gaikaazukariganrikin = Optional.fromNullable(toCurrencyType(gaikaazukariganrikinType))
            .transform(bizCurrencyTransformer(getGaikaazukariganrikinValue()))
            .orNull();
    }

    private BizCurrency gaikatounendgankin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikatounendgankin() {
        return gaikatounendgankin;
    }

    public void setGaikatounendgankin(BizCurrency pGaikatounendgankin) {
        gaikatounendgankin = pGaikatounendgankin;
        gaikatounendgankinValue = null;
        gaikatounendgankinType  = null;
    }

    transient private BigDecimal gaikatounendgankinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKATOUNENDGANKIN, nullable=true)
    protected BigDecimal getGaikatounendgankinValue() {
        if (gaikatounendgankinValue == null && gaikatounendgankin != null) {
            if (gaikatounendgankin.isOptional()) return null;
            return gaikatounendgankin.absolute();
        }
        return gaikatounendgankinValue;
    }

    protected void setGaikatounendgankinValue(BigDecimal value) {
        gaikatounendgankinValue = value;
        gaikatounendgankin = Optional.fromNullable(toCurrencyType(gaikatounendgankinType))
            .transform(bizCurrencyTransformer(getGaikatounendgankinValue()))
            .orNull();
    }

    transient private String gaikatounendgankinType = null;

    @Column(name=GAIKATOUNENDGANKIN + "$", nullable=true)
    protected String getGaikatounendgankinType() {
        if (gaikatounendgankinType == null && gaikatounendgankin != null) return gaikatounendgankin.getType().toString();
        if (gaikatounendgankinType == null && getGaikatounendgankinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikatounendgankin$' should not be NULL."));
        }
        return gaikatounendgankinType;
    }

    protected void setGaikatounendgankinType(String type) {
        gaikatounendgankinType = type;
        gaikatounendgankin = Optional.fromNullable(toCurrencyType(gaikatounendgankinType))
            .transform(bizCurrencyTransformer(getGaikatounendgankinValue()))
            .orNull();
    }

    private BizCurrency gaikatounendrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikatounendrsk() {
        return gaikatounendrsk;
    }

    public void setGaikatounendrsk(BizCurrency pGaikatounendrsk) {
        gaikatounendrsk = pGaikatounendrsk;
        gaikatounendrskValue = null;
        gaikatounendrskType  = null;
    }

    transient private BigDecimal gaikatounendrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKATOUNENDRSK, nullable=true)
    protected BigDecimal getGaikatounendrskValue() {
        if (gaikatounendrskValue == null && gaikatounendrsk != null) {
            if (gaikatounendrsk.isOptional()) return null;
            return gaikatounendrsk.absolute();
        }
        return gaikatounendrskValue;
    }

    protected void setGaikatounendrskValue(BigDecimal value) {
        gaikatounendrskValue = value;
        gaikatounendrsk = Optional.fromNullable(toCurrencyType(gaikatounendrskType))
            .transform(bizCurrencyTransformer(getGaikatounendrskValue()))
            .orNull();
    }

    transient private String gaikatounendrskType = null;

    @Column(name=GAIKATOUNENDRSK + "$", nullable=true)
    protected String getGaikatounendrskType() {
        if (gaikatounendrskType == null && gaikatounendrsk != null) return gaikatounendrsk.getType().toString();
        if (gaikatounendrskType == null && getGaikatounendrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikatounendrsk$' should not be NULL."));
        }
        return gaikatounendrskType;
    }

    protected void setGaikatounendrskType(String type) {
        gaikatounendrskType = type;
        gaikatounendrsk = Optional.fromNullable(toCurrencyType(gaikatounendrskType))
            .transform(bizCurrencyTransformer(getGaikatounendrskValue()))
            .orNull();
    }

    private BizDate gaikashrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.GAIKASHRKWSRATEKJNYMD)
    public BizDate getGaikashrkwsratekjnymd() {
        return gaikashrkwsratekjnymd;
    }

    public void setGaikashrkwsratekjnymd(BizDate pGaikashrkwsratekjnymd) {
        gaikashrkwsratekjnymd = pGaikashrkwsratekjnymd;
    }

    private BizNumber gaikashrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AzukarikinKessankanri.GAIKASHRKWSRATE)
    public BizNumber getGaikashrkwsrate() {
        return gaikashrkwsrate;
    }

    public void setGaikashrkwsrate(BizNumber pGaikashrkwsrate) {
        gaikashrkwsrate = pGaikashrkwsrate;
    }

    private BizCurrency gaikaknsnmaeazukariganrikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikaknsnmaeazukariganrikin() {
        return gaikaknsnmaeazukariganrikin;
    }

    public void setGaikaknsnmaeazukariganrikin(BizCurrency pGaikaknsnmaeazukariganrikin) {
        gaikaknsnmaeazukariganrikin = pGaikaknsnmaeazukariganrikin;
        gaikaknsnmaeazukariganrikinValue = null;
        gaikaknsnmaeazukariganrikinType  = null;
    }

    transient private BigDecimal gaikaknsnmaeazukariganrikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAKNSNMAEAZUKARIGANRIKIN, nullable=true)
    protected BigDecimal getGaikaknsnmaeazukariganrikinValue() {
        if (gaikaknsnmaeazukariganrikinValue == null && gaikaknsnmaeazukariganrikin != null) {
            if (gaikaknsnmaeazukariganrikin.isOptional()) return null;
            return gaikaknsnmaeazukariganrikin.absolute();
        }
        return gaikaknsnmaeazukariganrikinValue;
    }

    protected void setGaikaknsnmaeazukariganrikinValue(BigDecimal value) {
        gaikaknsnmaeazukariganrikinValue = value;
        gaikaknsnmaeazukariganrikin = Optional.fromNullable(toCurrencyType(gaikaknsnmaeazukariganrikinType))
            .transform(bizCurrencyTransformer(getGaikaknsnmaeazukariganrikinValue()))
            .orNull();
    }

    transient private String gaikaknsnmaeazukariganrikinType = null;

    @Column(name=GAIKAKNSNMAEAZUKARIGANRIKIN + "$", nullable=true)
    protected String getGaikaknsnmaeazukariganrikinType() {
        if (gaikaknsnmaeazukariganrikinType == null && gaikaknsnmaeazukariganrikin != null) return gaikaknsnmaeazukariganrikin.getType().toString();
        if (gaikaknsnmaeazukariganrikinType == null && getGaikaknsnmaeazukariganrikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikaknsnmaeazukariganrikin$' should not be NULL."));
        }
        return gaikaknsnmaeazukariganrikinType;
    }

    protected void setGaikaknsnmaeazukariganrikinType(String type) {
        gaikaknsnmaeazukariganrikinType = type;
        gaikaknsnmaeazukariganrikin = Optional.fromNullable(toCurrencyType(gaikaknsnmaeazukariganrikinType))
            .transform(bizCurrencyTransformer(getGaikaknsnmaeazukariganrikinValue()))
            .orNull();
    }

    private BizCurrency gaikaknsnmaetounendgankin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikaknsnmaetounendgankin() {
        return gaikaknsnmaetounendgankin;
    }

    public void setGaikaknsnmaetounendgankin(BizCurrency pGaikaknsnmaetounendgankin) {
        gaikaknsnmaetounendgankin = pGaikaknsnmaetounendgankin;
        gaikaknsnmaetounendgankinValue = null;
        gaikaknsnmaetounendgankinType  = null;
    }

    transient private BigDecimal gaikaknsnmaetounendgankinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAKNSNMAETOUNENDGANKIN, nullable=true)
    protected BigDecimal getGaikaknsnmaetounendgankinValue() {
        if (gaikaknsnmaetounendgankinValue == null && gaikaknsnmaetounendgankin != null) {
            if (gaikaknsnmaetounendgankin.isOptional()) return null;
            return gaikaknsnmaetounendgankin.absolute();
        }
        return gaikaknsnmaetounendgankinValue;
    }

    protected void setGaikaknsnmaetounendgankinValue(BigDecimal value) {
        gaikaknsnmaetounendgankinValue = value;
        gaikaknsnmaetounendgankin = Optional.fromNullable(toCurrencyType(gaikaknsnmaetounendgankinType))
            .transform(bizCurrencyTransformer(getGaikaknsnmaetounendgankinValue()))
            .orNull();
    }

    transient private String gaikaknsnmaetounendgankinType = null;

    @Column(name=GAIKAKNSNMAETOUNENDGANKIN + "$", nullable=true)
    protected String getGaikaknsnmaetounendgankinType() {
        if (gaikaknsnmaetounendgankinType == null && gaikaknsnmaetounendgankin != null) return gaikaknsnmaetounendgankin.getType().toString();
        if (gaikaknsnmaetounendgankinType == null && getGaikaknsnmaetounendgankinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikaknsnmaetounendgankin$' should not be NULL."));
        }
        return gaikaknsnmaetounendgankinType;
    }

    protected void setGaikaknsnmaetounendgankinType(String type) {
        gaikaknsnmaetounendgankinType = type;
        gaikaknsnmaetounendgankin = Optional.fromNullable(toCurrencyType(gaikaknsnmaetounendgankinType))
            .transform(bizCurrencyTransformer(getGaikaknsnmaetounendgankinValue()))
            .orNull();
    }

    private BizCurrency gaikaknsnmaetounendrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikaknsnmaetounendrsk() {
        return gaikaknsnmaetounendrsk;
    }

    public void setGaikaknsnmaetounendrsk(BizCurrency pGaikaknsnmaetounendrsk) {
        gaikaknsnmaetounendrsk = pGaikaknsnmaetounendrsk;
        gaikaknsnmaetounendrskValue = null;
        gaikaknsnmaetounendrskType  = null;
    }

    transient private BigDecimal gaikaknsnmaetounendrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAKNSNMAETOUNENDRSK, nullable=true)
    protected BigDecimal getGaikaknsnmaetounendrskValue() {
        if (gaikaknsnmaetounendrskValue == null && gaikaknsnmaetounendrsk != null) {
            if (gaikaknsnmaetounendrsk.isOptional()) return null;
            return gaikaknsnmaetounendrsk.absolute();
        }
        return gaikaknsnmaetounendrskValue;
    }

    protected void setGaikaknsnmaetounendrskValue(BigDecimal value) {
        gaikaknsnmaetounendrskValue = value;
        gaikaknsnmaetounendrsk = Optional.fromNullable(toCurrencyType(gaikaknsnmaetounendrskType))
            .transform(bizCurrencyTransformer(getGaikaknsnmaetounendrskValue()))
            .orNull();
    }

    transient private String gaikaknsnmaetounendrskType = null;

    @Column(name=GAIKAKNSNMAETOUNENDRSK + "$", nullable=true)
    protected String getGaikaknsnmaetounendrskType() {
        if (gaikaknsnmaetounendrskType == null && gaikaknsnmaetounendrsk != null) return gaikaknsnmaetounendrsk.getType().toString();
        if (gaikaknsnmaetounendrskType == null && getGaikaknsnmaetounendrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikaknsnmaetounendrsk$' should not be NULL."));
        }
        return gaikaknsnmaetounendrskType;
    }

    protected void setGaikaknsnmaetounendrskType(String type) {
        gaikaknsnmaetounendrskType = type;
        gaikaknsnmaetounendrsk = Optional.fromNullable(toCurrencyType(gaikaknsnmaetounendrskType))
            .transform(bizCurrencyTransformer(getGaikaknsnmaetounendrskValue()))
            .orNull();
    }

    private BizCurrency azukarikinshrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikinshrgk() {
        return azukarikinshrgk;
    }

    public void setAzukarikinshrgk(BizCurrency pAzukarikinshrgk) {
        azukarikinshrgk = pAzukarikinshrgk;
        azukarikinshrgkValue = null;
        azukarikinshrgkType  = null;
    }

    transient private BigDecimal azukarikinshrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINSHRGK, nullable=true)
    protected BigDecimal getAzukarikinshrgkValue() {
        if (azukarikinshrgkValue == null && azukarikinshrgk != null) {
            if (azukarikinshrgk.isOptional()) return null;
            return azukarikinshrgk.absolute();
        }
        return azukarikinshrgkValue;
    }

    protected void setAzukarikinshrgkValue(BigDecimal value) {
        azukarikinshrgkValue = value;
        azukarikinshrgk = Optional.fromNullable(toCurrencyType(azukarikinshrgkType))
            .transform(bizCurrencyTransformer(getAzukarikinshrgkValue()))
            .orNull();
    }

    transient private String azukarikinshrgkType = null;

    @Column(name=AZUKARIKINSHRGK + "$", nullable=true)
    protected String getAzukarikinshrgkType() {
        if (azukarikinshrgkType == null && azukarikinshrgk != null) return azukarikinshrgk.getType().toString();
        if (azukarikinshrgkType == null && getAzukarikinshrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikinshrgk$' should not be NULL."));
        }
        return azukarikinshrgkType;
    }

    protected void setAzukarikinshrgkType(String type) {
        azukarikinshrgkType = type;
        azukarikinshrgk = Optional.fromNullable(toCurrencyType(azukarikinshrgkType))
            .transform(bizCurrencyTransformer(getAzukarikinshrgkValue()))
            .orNull();
    }

    private BizCurrency azukarikinshrrskgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikinshrrskgk() {
        return azukarikinshrrskgk;
    }

    public void setAzukarikinshrrskgk(BizCurrency pAzukarikinshrrskgk) {
        azukarikinshrrskgk = pAzukarikinshrrskgk;
        azukarikinshrrskgkValue = null;
        azukarikinshrrskgkType  = null;
    }

    transient private BigDecimal azukarikinshrrskgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINSHRRSKGK, nullable=true)
    protected BigDecimal getAzukarikinshrrskgkValue() {
        if (azukarikinshrrskgkValue == null && azukarikinshrrskgk != null) {
            if (azukarikinshrrskgk.isOptional()) return null;
            return azukarikinshrrskgk.absolute();
        }
        return azukarikinshrrskgkValue;
    }

    protected void setAzukarikinshrrskgkValue(BigDecimal value) {
        azukarikinshrrskgkValue = value;
        azukarikinshrrskgk = Optional.fromNullable(toCurrencyType(azukarikinshrrskgkType))
            .transform(bizCurrencyTransformer(getAzukarikinshrrskgkValue()))
            .orNull();
    }

    transient private String azukarikinshrrskgkType = null;

    @Column(name=AZUKARIKINSHRRSKGK + "$", nullable=true)
    protected String getAzukarikinshrrskgkType() {
        if (azukarikinshrrskgkType == null && azukarikinshrrskgk != null) return azukarikinshrrskgk.getType().toString();
        if (azukarikinshrrskgkType == null && getAzukarikinshrrskgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikinshrrskgk$' should not be NULL."));
        }
        return azukarikinshrrskgkType;
    }

    protected void setAzukarikinshrrskgkType(String type) {
        azukarikinshrrskgkType = type;
        azukarikinshrrskgk = Optional.fromNullable(toCurrencyType(azukarikinshrrskgkType))
            .transform(bizCurrencyTransformer(getAzukarikinshrrskgkValue()))
            .orNull();
    }

    private BizCurrency tounendsyoumetuukemishrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendsyoumetuukemishrgk() {
        return tounendsyoumetuukemishrgk;
    }

    public void setTounendsyoumetuukemishrgk(BizCurrency pTounendsyoumetuukemishrgk) {
        tounendsyoumetuukemishrgk = pTounendsyoumetuukemishrgk;
        tounendsyoumetuukemishrgkValue = null;
        tounendsyoumetuukemishrgkType  = null;
    }

    transient private BigDecimal tounendsyoumetuukemishrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDSYOUMETUUKEMISHRGK, nullable=true)
    protected BigDecimal getTounendsyoumetuukemishrgkValue() {
        if (tounendsyoumetuukemishrgkValue == null && tounendsyoumetuukemishrgk != null) {
            if (tounendsyoumetuukemishrgk.isOptional()) return null;
            return tounendsyoumetuukemishrgk.absolute();
        }
        return tounendsyoumetuukemishrgkValue;
    }

    protected void setTounendsyoumetuukemishrgkValue(BigDecimal value) {
        tounendsyoumetuukemishrgkValue = value;
        tounendsyoumetuukemishrgk = Optional.fromNullable(toCurrencyType(tounendsyoumetuukemishrgkType))
            .transform(bizCurrencyTransformer(getTounendsyoumetuukemishrgkValue()))
            .orNull();
    }

    transient private String tounendsyoumetuukemishrgkType = null;

    @Column(name=TOUNENDSYOUMETUUKEMISHRGK + "$", nullable=true)
    protected String getTounendsyoumetuukemishrgkType() {
        if (tounendsyoumetuukemishrgkType == null && tounendsyoumetuukemishrgk != null) return tounendsyoumetuukemishrgk.getType().toString();
        if (tounendsyoumetuukemishrgkType == null && getTounendsyoumetuukemishrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendsyoumetuukemishrgk$' should not be NULL."));
        }
        return tounendsyoumetuukemishrgkType;
    }

    protected void setTounendsyoumetuukemishrgkType(String type) {
        tounendsyoumetuukemishrgkType = type;
        tounendsyoumetuukemishrgk = Optional.fromNullable(toCurrencyType(tounendsyoumetuukemishrgkType))
            .transform(bizCurrencyTransformer(getTounendsyoumetuukemishrgkValue()))
            .orNull();
    }

    private BizCurrency sinbikinkeirskgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSinbikinkeirskgk() {
        return sinbikinkeirskgk;
    }

    public void setSinbikinkeirskgk(BizCurrency pSinbikinkeirskgk) {
        sinbikinkeirskgk = pSinbikinkeirskgk;
        sinbikinkeirskgkValue = null;
        sinbikinkeirskgkType  = null;
    }

    transient private BigDecimal sinbikinkeirskgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SINBIKINKEIRSKGK, nullable=true)
    protected BigDecimal getSinbikinkeirskgkValue() {
        if (sinbikinkeirskgkValue == null && sinbikinkeirskgk != null) {
            if (sinbikinkeirskgk.isOptional()) return null;
            return sinbikinkeirskgk.absolute();
        }
        return sinbikinkeirskgkValue;
    }

    protected void setSinbikinkeirskgkValue(BigDecimal value) {
        sinbikinkeirskgkValue = value;
        sinbikinkeirskgk = Optional.fromNullable(toCurrencyType(sinbikinkeirskgkType))
            .transform(bizCurrencyTransformer(getSinbikinkeirskgkValue()))
            .orNull();
    }

    transient private String sinbikinkeirskgkType = null;

    @Column(name=SINBIKINKEIRSKGK + "$", nullable=true)
    protected String getSinbikinkeirskgkType() {
        if (sinbikinkeirskgkType == null && sinbikinkeirskgk != null) return sinbikinkeirskgk.getType().toString();
        if (sinbikinkeirskgkType == null && getSinbikinkeirskgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sinbikinkeirskgk$' should not be NULL."));
        }
        return sinbikinkeirskgkType;
    }

    protected void setSinbikinkeirskgkType(String type) {
        sinbikinkeirskgkType = type;
        sinbikinkeirskgk = Optional.fromNullable(toCurrencyType(sinbikinkeirskgkType))
            .transform(bizCurrencyTransformer(getSinbikinkeirskgkValue()))
            .orNull();
    }

    private C_BknJkuKbn bknjkukbn;

    @Type(type="UserType_C_BknJkuKbn")
    @Column(name=GenIT_AzukarikinKessankanri.BKNJKUKBN)
    public C_BknJkuKbn getBknjkukbn() {
        return bknjkukbn;
    }

    public void setBknjkukbn(C_BknJkuKbn pBknjkukbn) {
        bknjkukbn = pBknjkukbn;
    }

    private BizDate bikinkeiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.BIKINKEIYMD)
    public BizDate getBikinkeiymd() {
        return bikinkeiymd;
    }

    public void setBikinkeiymd(BizDate pBikinkeiymd) {
        bikinkeiymd = pBikinkeiymd;
    }

    private C_BkncdKbn bkncdkbn;

    @Type(type="UserType_C_BkncdKbn")
    @Column(name=GenIT_AzukarikinKessankanri.BKNCDKBN)
    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }

    private BizCurrency tounendrsksyukeisitu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendrsksyukeisitu() {
        return tounendrsksyukeisitu;
    }

    public void setTounendrsksyukeisitu(BizCurrency pTounendrsksyukeisitu) {
        tounendrsksyukeisitu = pTounendrsksyukeisitu;
        tounendrsksyukeisituValue = null;
        tounendrsksyukeisituType  = null;
    }

    transient private BigDecimal tounendrsksyukeisituValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDRSKSYUKEISITU, nullable=true)
    protected BigDecimal getTounendrsksyukeisituValue() {
        if (tounendrsksyukeisituValue == null && tounendrsksyukeisitu != null) {
            if (tounendrsksyukeisitu.isOptional()) return null;
            return tounendrsksyukeisitu.absolute();
        }
        return tounendrsksyukeisituValue;
    }

    protected void setTounendrsksyukeisituValue(BigDecimal value) {
        tounendrsksyukeisituValue = value;
        tounendrsksyukeisitu = Optional.fromNullable(toCurrencyType(tounendrsksyukeisituType))
            .transform(bizCurrencyTransformer(getTounendrsksyukeisituValue()))
            .orNull();
    }

    transient private String tounendrsksyukeisituType = null;

    @Column(name=TOUNENDRSKSYUKEISITU + "$", nullable=true)
    protected String getTounendrsksyukeisituType() {
        if (tounendrsksyukeisituType == null && tounendrsksyukeisitu != null) return tounendrsksyukeisitu.getType().toString();
        if (tounendrsksyukeisituType == null && getTounendrsksyukeisituValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendrsksyukeisitu$' should not be NULL."));
        }
        return tounendrsksyukeisituType;
    }

    protected void setTounendrsksyukeisituType(String type) {
        tounendrsksyukeisituType = type;
        tounendrsksyukeisitu = Optional.fromNullable(toCurrencyType(tounendrsksyukeisituType))
            .transform(bizCurrencyTransformer(getTounendrsksyukeisituValue()))
            .orNull();
    }

    private BizCurrency zennendrsksyukeisitu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennendrsksyukeisitu() {
        return zennendrsksyukeisitu;
    }

    public void setZennendrsksyukeisitu(BizCurrency pZennendrsksyukeisitu) {
        zennendrsksyukeisitu = pZennendrsksyukeisitu;
        zennendrsksyukeisituValue = null;
        zennendrsksyukeisituType  = null;
    }

    transient private BigDecimal zennendrsksyukeisituValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNENDRSKSYUKEISITU, nullable=true)
    protected BigDecimal getZennendrsksyukeisituValue() {
        if (zennendrsksyukeisituValue == null && zennendrsksyukeisitu != null) {
            if (zennendrsksyukeisitu.isOptional()) return null;
            return zennendrsksyukeisitu.absolute();
        }
        return zennendrsksyukeisituValue;
    }

    protected void setZennendrsksyukeisituValue(BigDecimal value) {
        zennendrsksyukeisituValue = value;
        zennendrsksyukeisitu = Optional.fromNullable(toCurrencyType(zennendrsksyukeisituType))
            .transform(bizCurrencyTransformer(getZennendrsksyukeisituValue()))
            .orNull();
    }

    transient private String zennendrsksyukeisituType = null;

    @Column(name=ZENNENDRSKSYUKEISITU + "$", nullable=true)
    protected String getZennendrsksyukeisituType() {
        if (zennendrsksyukeisituType == null && zennendrsksyukeisitu != null) return zennendrsksyukeisitu.getType().toString();
        if (zennendrsksyukeisituType == null && getZennendrsksyukeisituValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennendrsksyukeisitu$' should not be NULL."));
        }
        return zennendrsksyukeisituType;
    }

    protected void setZennendrsksyukeisituType(String type) {
        zennendrsksyukeisituType = type;
        zennendrsksyukeisitu = Optional.fromNullable(toCurrencyType(zennendrsksyukeisituType))
            .transform(bizCurrencyTransformer(getZennendrsksyukeisituValue()))
            .orNull();
    }

    private BizDate kwsratekjymd1q;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.KWSRATEKJYMD1Q)
    public BizDate getKwsratekjymd1q() {
        return kwsratekjymd1q;
    }

    public void setKwsratekjymd1q(BizDate pKwsratekjymd1q) {
        kwsratekjymd1q = pKwsratekjymd1q;
    }

    private BizNumber kawaserate1q;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AzukarikinKessankanri.KAWASERATE1Q)
    public BizNumber getKawaserate1q() {
        return kawaserate1q;
    }

    public void setKawaserate1q(BizNumber pKawaserate1q) {
        kawaserate1q = pKawaserate1q;
    }

    private BizCurrency azukarikinrsk1q;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikinrsk1q() {
        return azukarikinrsk1q;
    }

    public void setAzukarikinrsk1q(BizCurrency pAzukarikinrsk1q) {
        azukarikinrsk1q = pAzukarikinrsk1q;
        azukarikinrsk1qValue = null;
        azukarikinrsk1qType  = null;
    }

    transient private BigDecimal azukarikinrsk1qValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINRSK1Q, nullable=true)
    protected BigDecimal getAzukarikinrsk1qValue() {
        if (azukarikinrsk1qValue == null && azukarikinrsk1q != null) {
            if (azukarikinrsk1q.isOptional()) return null;
            return azukarikinrsk1q.absolute();
        }
        return azukarikinrsk1qValue;
    }

    protected void setAzukarikinrsk1qValue(BigDecimal value) {
        azukarikinrsk1qValue = value;
        azukarikinrsk1q = Optional.fromNullable(toCurrencyType(azukarikinrsk1qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk1qValue()))
            .orNull();
    }

    transient private String azukarikinrsk1qType = null;

    @Column(name=AZUKARIKINRSK1Q + "$", nullable=true)
    protected String getAzukarikinrsk1qType() {
        if (azukarikinrsk1qType == null && azukarikinrsk1q != null) return azukarikinrsk1q.getType().toString();
        if (azukarikinrsk1qType == null && getAzukarikinrsk1qValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikinrsk1q$' should not be NULL."));
        }
        return azukarikinrsk1qType;
    }

    protected void setAzukarikinrsk1qType(String type) {
        azukarikinrsk1qType = type;
        azukarikinrsk1q = Optional.fromNullable(toCurrencyType(azukarikinrsk1qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk1qValue()))
            .orNull();
    }

    private BizDate kwsratekjymd2q;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.KWSRATEKJYMD2Q)
    public BizDate getKwsratekjymd2q() {
        return kwsratekjymd2q;
    }

    public void setKwsratekjymd2q(BizDate pKwsratekjymd2q) {
        kwsratekjymd2q = pKwsratekjymd2q;
    }

    private BizNumber kawaserate2q;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AzukarikinKessankanri.KAWASERATE2Q)
    public BizNumber getKawaserate2q() {
        return kawaserate2q;
    }

    public void setKawaserate2q(BizNumber pKawaserate2q) {
        kawaserate2q = pKawaserate2q;
    }

    private BizCurrency azukarikinrsk2q;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikinrsk2q() {
        return azukarikinrsk2q;
    }

    public void setAzukarikinrsk2q(BizCurrency pAzukarikinrsk2q) {
        azukarikinrsk2q = pAzukarikinrsk2q;
        azukarikinrsk2qValue = null;
        azukarikinrsk2qType  = null;
    }

    transient private BigDecimal azukarikinrsk2qValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINRSK2Q, nullable=true)
    protected BigDecimal getAzukarikinrsk2qValue() {
        if (azukarikinrsk2qValue == null && azukarikinrsk2q != null) {
            if (azukarikinrsk2q.isOptional()) return null;
            return azukarikinrsk2q.absolute();
        }
        return azukarikinrsk2qValue;
    }

    protected void setAzukarikinrsk2qValue(BigDecimal value) {
        azukarikinrsk2qValue = value;
        azukarikinrsk2q = Optional.fromNullable(toCurrencyType(azukarikinrsk2qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk2qValue()))
            .orNull();
    }

    transient private String azukarikinrsk2qType = null;

    @Column(name=AZUKARIKINRSK2Q + "$", nullable=true)
    protected String getAzukarikinrsk2qType() {
        if (azukarikinrsk2qType == null && azukarikinrsk2q != null) return azukarikinrsk2q.getType().toString();
        if (azukarikinrsk2qType == null && getAzukarikinrsk2qValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikinrsk2q$' should not be NULL."));
        }
        return azukarikinrsk2qType;
    }

    protected void setAzukarikinrsk2qType(String type) {
        azukarikinrsk2qType = type;
        azukarikinrsk2q = Optional.fromNullable(toCurrencyType(azukarikinrsk2qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk2qValue()))
            .orNull();
    }

    private BizDate kwsratekjymd3q;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.KWSRATEKJYMD3Q)
    public BizDate getKwsratekjymd3q() {
        return kwsratekjymd3q;
    }

    public void setKwsratekjymd3q(BizDate pKwsratekjymd3q) {
        kwsratekjymd3q = pKwsratekjymd3q;
    }

    private BizNumber kawaserate3q;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AzukarikinKessankanri.KAWASERATE3Q)
    public BizNumber getKawaserate3q() {
        return kawaserate3q;
    }

    public void setKawaserate3q(BizNumber pKawaserate3q) {
        kawaserate3q = pKawaserate3q;
    }

    private BizCurrency azukarikinrsk3q;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikinrsk3q() {
        return azukarikinrsk3q;
    }

    public void setAzukarikinrsk3q(BizCurrency pAzukarikinrsk3q) {
        azukarikinrsk3q = pAzukarikinrsk3q;
        azukarikinrsk3qValue = null;
        azukarikinrsk3qType  = null;
    }

    transient private BigDecimal azukarikinrsk3qValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINRSK3Q, nullable=true)
    protected BigDecimal getAzukarikinrsk3qValue() {
        if (azukarikinrsk3qValue == null && azukarikinrsk3q != null) {
            if (azukarikinrsk3q.isOptional()) return null;
            return azukarikinrsk3q.absolute();
        }
        return azukarikinrsk3qValue;
    }

    protected void setAzukarikinrsk3qValue(BigDecimal value) {
        azukarikinrsk3qValue = value;
        azukarikinrsk3q = Optional.fromNullable(toCurrencyType(azukarikinrsk3qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk3qValue()))
            .orNull();
    }

    transient private String azukarikinrsk3qType = null;

    @Column(name=AZUKARIKINRSK3Q + "$", nullable=true)
    protected String getAzukarikinrsk3qType() {
        if (azukarikinrsk3qType == null && azukarikinrsk3q != null) return azukarikinrsk3q.getType().toString();
        if (azukarikinrsk3qType == null && getAzukarikinrsk3qValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikinrsk3q$' should not be NULL."));
        }
        return azukarikinrsk3qType;
    }

    protected void setAzukarikinrsk3qType(String type) {
        azukarikinrsk3qType = type;
        azukarikinrsk3q = Optional.fromNullable(toCurrencyType(azukarikinrsk3qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk3qValue()))
            .orNull();
    }

    private BizDate kwsratekjymd4q;

    @Type(type="BizDateType")
    @Column(name=GenIT_AzukarikinKessankanri.KWSRATEKJYMD4Q)
    public BizDate getKwsratekjymd4q() {
        return kwsratekjymd4q;
    }

    public void setKwsratekjymd4q(BizDate pKwsratekjymd4q) {
        kwsratekjymd4q = pKwsratekjymd4q;
    }

    private BizNumber kawaserate4q;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AzukarikinKessankanri.KAWASERATE4Q)
    public BizNumber getKawaserate4q() {
        return kawaserate4q;
    }

    public void setKawaserate4q(BizNumber pKawaserate4q) {
        kawaserate4q = pKawaserate4q;
    }

    private BizCurrency azukarikinrsk4q;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikinrsk4q() {
        return azukarikinrsk4q;
    }

    public void setAzukarikinrsk4q(BizCurrency pAzukarikinrsk4q) {
        azukarikinrsk4q = pAzukarikinrsk4q;
        azukarikinrsk4qValue = null;
        azukarikinrsk4qType  = null;
    }

    transient private BigDecimal azukarikinrsk4qValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINRSK4Q, nullable=true)
    protected BigDecimal getAzukarikinrsk4qValue() {
        if (azukarikinrsk4qValue == null && azukarikinrsk4q != null) {
            if (azukarikinrsk4q.isOptional()) return null;
            return azukarikinrsk4q.absolute();
        }
        return azukarikinrsk4qValue;
    }

    protected void setAzukarikinrsk4qValue(BigDecimal value) {
        azukarikinrsk4qValue = value;
        azukarikinrsk4q = Optional.fromNullable(toCurrencyType(azukarikinrsk4qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk4qValue()))
            .orNull();
    }

    transient private String azukarikinrsk4qType = null;

    @Column(name=AZUKARIKINRSK4Q + "$", nullable=true)
    protected String getAzukarikinrsk4qType() {
        if (azukarikinrsk4qType == null && azukarikinrsk4q != null) return azukarikinrsk4q.getType().toString();
        if (azukarikinrsk4qType == null && getAzukarikinrsk4qValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikinrsk4q$' should not be NULL."));
        }
        return azukarikinrsk4qType;
    }

    protected void setAzukarikinrsk4qType(String type) {
        azukarikinrsk4qType = type;
        azukarikinrsk4q = Optional.fromNullable(toCurrencyType(azukarikinrsk4qType))
            .transform(bizCurrencyTransformer(getAzukarikinrsk4qValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_AzukarikinKessankanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_AzukarikinKessankanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_AzukarikinKessankanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}