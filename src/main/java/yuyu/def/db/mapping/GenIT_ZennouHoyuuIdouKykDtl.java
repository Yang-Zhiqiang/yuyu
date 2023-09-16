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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.classification.C_ZennoubikinKbn;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.id.PKIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.GenQIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.QIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ZennouKbn;
import yuyu.def.db.type.UserType_C_ZennouToukeiListKbn;
import yuyu.def.db.type.UserType_C_ZennoubikinKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 前納保有異動契約明細テーブル テーブルのマッピング情報クラスで、 {@link IT_ZennouHoyuuIdouKykDtl} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ZennouHoyuuIdouKykDtl}</td><td colspan="3">前納保有異動契約明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_ZennouHoyuuIdouKykDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_ZennouHoyuuIdouKykDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">{@link PKIT_ZennouHoyuuIdouKykDtl ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">{@link PKIT_ZennouHoyuuIdouKykDtl ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmfksnctr kykmfksnctr}</td><td>契約ＭＦ更新ＣＴＲ</td><td align="center">{@link PKIT_ZennouHoyuuIdouKykDtl ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenkousyoriymd henkousyoriymd}</td><td>変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukessanrecordkbn zennoukessanrecordkbn}</td><td>前納決算レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeijyouym keijyouym}</td><td>計上年月</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoucalckijyunymd zennoucalckijyunymd}</td><td>前納計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoubikinkbn zennoubikinkbn}</td><td>前納備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZennoubikinKbn}</td></tr>
 *  <tr><td>{@link #getSyukeiyakusyuruicd syukeiyakusyuruicd}</td><td>主契約種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZennouToukeiListKbn}</td></tr>
 *  <tr><td>{@link #getKeiyakuymd keiyakuymd}</td><td>契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouwrbkrt zennouwrbkrt}</td><td>前納割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTndmatutkyrt tndmatutkyrt}</td><td>当年度末適用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTndzndkhikakukbn tndzndkhikakukbn}</td><td>当年度残高比較区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZennouKbn}</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennounyuukinymd zennounyuukinymd}</td><td>前納入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgk zennounyuukinkgk}</td><td>前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getToukimatuzennouzndk toukimatuzennouzndk}</td><td>当期末前納残高金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getToukijyuutoup toukijyuutoup}</td><td>当期充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getToukizennouseisangk toukizennouseisangk}</td><td>当期前納精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getToukizennounyuukinkgk toukizennounyuukinkgk}</td><td>当期前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYokukinenbaraip yokukinenbaraip}</td><td>翌期年払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getWrbkrttkyrt wrbkrttkyrt}</td><td>割引利率適用残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkdtznnhyj gkdtznnhyj}</td><td>外貨建前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZnngaikakbn znngaikakbn}</td><td>前納外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenkanyknhyj yenkanyknhyj}</td><td>円貨入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZnnnyknjikawaserate znnnyknjikawaserate}</td><td>前納入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZnnnyknjikawaseratetkyuymd znnnyknjikawaseratetkyuymd}</td><td>前納入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKsnkisikawaserate ksnkisikawaserate}</td><td>決算期始為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZnncalckjynymdkwsrate znncalckjynymdkwsrate}</td><td>前納計算基準日時点為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKsnkimatukawaserate ksnkimatukawaserate}</td><td>決算期末時点為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgktkmatu zennounyuukinkgktkmatu}</td><td>前納入金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkmatuznnzndktkmatu tkmatuznnzndktkmatu}</td><td>当期末前納残高金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ZennouHoyuuIdouKykDtl
 * @see     PKIT_ZennouHoyuuIdouKykDtl
 * @see     QIT_ZennouHoyuuIdouKykDtl
 * @see     GenQIT_ZennouHoyuuIdouKykDtl
 */
@MappedSuperclass
@Table(name=GenIT_ZennouHoyuuIdouKykDtl.TABLE_NAME)
@IdClass(value=PKIT_ZennouHoyuuIdouKykDtl.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_ZennouKbn", typeClass=UserType_C_ZennouKbn.class),
    @TypeDef(name="UserType_C_ZennouToukeiListKbn", typeClass=UserType_C_ZennouToukeiListKbn.class),
    @TypeDef(name="UserType_C_ZennoubikinKbn", typeClass=UserType_C_ZennoubikinKbn.class)
})
public abstract class GenIT_ZennouHoyuuIdouKykDtl extends AbstractExDBEntity<IT_ZennouHoyuuIdouKykDtl, PKIT_ZennouHoyuuIdouKykDtl> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_ZennouHoyuuIdouKykDtl";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SAKUSEIYMD               = "sakuseiymd";
    public static final String SYORICD                  = "syoricd";
    public static final String KYKMFKSNCTR              = "kykmfksnctr";
    public static final String HENKOUSYORIYMD           = "henkousyoriymd";
    public static final String ZENNOUKESSANRECORDKBN    = "zennoukessanrecordkbn";
    public static final String KEIJYOUYM                = "keijyouym";
    public static final String DENYMD                   = "denymd";
    public static final String ZENNOUCALCKIJYUNYMD      = "zennoucalckijyunymd";
    public static final String ZENNOUBIKINKBN           = "zennoubikinkbn";
    public static final String SYUKEIYAKUSYURUICD       = "syukeiyakusyuruicd";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String ZENNOUTOUKEILISTKBN      = "zennoutoukeilistkbn";
    public static final String KEIYAKUYMD               = "keiyakuymd";
    public static final String ZENNOUWRBKRT             = "zennouwrbkrt";
    public static final String TNDMATUTKYRT             = "tndmatutkyrt";
    public static final String TNDZNDKHIKAKUKBN         = "tndzndkhikakukbn";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String ZENNOUKBN                = "zennoukbn";
    public static final String ZENNOUKIKAN              = "zennoukikan";
    public static final String ZENNOUNYUUKINYMD         = "zennounyuukinymd";
    public static final String ZENNOUNYUUKINKGK         = "zennounyuukinkgk";
    public static final String TOUKIMATUZENNOUZNDK      = "toukimatuzennouzndk";
    public static final String TOUKIJYUUTOUP            = "toukijyuutoup";
    public static final String TOUKIZENNOUSEISANGK      = "toukizennouseisangk";
    public static final String TOUKIZENNOUNYUUKINKGK    = "toukizennounyuukinkgk";
    public static final String YOKUKINENBARAIP          = "yokukinenbaraip";
    public static final String WRBKRTTKYRT              = "wrbkrttkyrt";
    public static final String GKDTZNNHYJ               = "gkdtznnhyj";
    public static final String ZNNGAIKAKBN              = "znngaikakbn";
    public static final String YENKANYKNHYJ             = "yenkanyknhyj";
    public static final String ZNNNYKNJIKAWASERATE      = "znnnyknjikawaserate";
    public static final String ZNNNYKNJIKAWASERATETKYUYMD = "znnnyknjikawaseratetkyuymd";
    public static final String KSNKISIKAWASERATE        = "ksnkisikawaserate";
    public static final String ZNNCALCKJYNYMDKWSRATE    = "znncalckjynymdkwsrate";
    public static final String KSNKIMATUKAWASERATE      = "ksnkimatukawaserate";
    public static final String ZENNOUNYUUKINKGKTKMATU   = "zennounyuukinkgktkmatu";
    public static final String TKMATUZNNZNDKTKMATU      = "tkmatuznnzndktkmatu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_ZennouHoyuuIdouKykDtl primaryKey;

    public GenIT_ZennouHoyuuIdouKykDtl() {
        primaryKey = new PKIT_ZennouHoyuuIdouKykDtl();
    }

    public GenIT_ZennouHoyuuIdouKykDtl(
        String pKbnkey,
        String pSyono,
        BizDate pSakuseiymd,
        String pSyoricd,
        Integer pKykmfksnctr
    ) {
        primaryKey = new PKIT_ZennouHoyuuIdouKykDtl(
            pKbnkey,
            pSyono,
            pSakuseiymd,
            pSyoricd,
            pKykmfksnctr
        );
    }

    @Transient
    @Override
    public PKIT_ZennouHoyuuIdouKykDtl getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_ZennouHoyuuIdouKykDtl> getMetaClass() {
        return QIT_ZennouHoyuuIdouKykDtl.class;
    }

    @Id
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.SYONO)
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
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.SAKUSEIYMD)
    @ValidDate
    public BizDate getSakuseiymd() {
        return getPrimaryKey().getSakuseiymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseiymd(BizDate pSakuseiymd) {
        getPrimaryKey().setSakuseiymd(pSakuseiymd);
    }

    @Id
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.SYORICD)
    public String getSyoricd() {
        return getPrimaryKey().getSyoricd();
    }

    public void setSyoricd(String pSyoricd) {
        getPrimaryKey().setSyoricd(pSyoricd);
    }

    @Id
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KYKMFKSNCTR)
    public Integer getKykmfksnctr() {
        return getPrimaryKey().getKykmfksnctr();
    }

    public void setKykmfksnctr(Integer pKykmfksnctr) {
        getPrimaryKey().setKykmfksnctr(pKykmfksnctr);
    }

    private BizDate henkousyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.HENKOUSYORIYMD)
    public BizDate getHenkousyoriymd() {
        return henkousyoriymd;
    }

    public void setHenkousyoriymd(BizDate pHenkousyoriymd) {
        henkousyoriymd = pHenkousyoriymd;
    }

    private String zennoukessanrecordkbn;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUKESSANRECORDKBN)
    public String getZennoukessanrecordkbn() {
        return zennoukessanrecordkbn;
    }

    public void setZennoukessanrecordkbn(String pZennoukessanrecordkbn) {
        zennoukessanrecordkbn = pZennoukessanrecordkbn;
    }

    private BizDateYM keijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KEIJYOUYM)
    public BizDateYM getKeijyouym() {
        return keijyouym;
    }

    public void setKeijyouym(BizDateYM pKeijyouym) {
        keijyouym = pKeijyouym;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private BizDate zennoucalckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUCALCKIJYUNYMD)
    public BizDate getZennoucalckijyunymd() {
        return zennoucalckijyunymd;
    }

    public void setZennoucalckijyunymd(BizDate pZennoucalckijyunymd) {
        zennoucalckijyunymd = pZennoucalckijyunymd;
    }

    private C_ZennoubikinKbn zennoubikinkbn;

    @Type(type="UserType_C_ZennoubikinKbn")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUBIKINKBN)
    public C_ZennoubikinKbn getZennoubikinkbn() {
        return zennoubikinkbn;
    }

    public void setZennoubikinkbn(C_ZennoubikinKbn pZennoubikinkbn) {
        zennoubikinkbn = pZennoubikinkbn;
    }

    private String syukeiyakusyuruicd;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.SYUKEIYAKUSYURUICD)
    public String getSyukeiyakusyuruicd() {
        return syukeiyakusyuruicd;
    }

    public void setSyukeiyakusyuruicd(String pSyukeiyakusyuruicd) {
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
    }

    private C_Segcd kbnkeirisegcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @Type(type="UserType_C_ZennouToukeiListKbn")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUTOUKEILISTKBN)
    public C_ZennouToukeiListKbn getZennoutoukeilistkbn() {
        return zennoutoukeilistkbn;
    }

    public void setZennoutoukeilistkbn(C_ZennouToukeiListKbn pZennoutoukeilistkbn) {
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
    }

    private BizDate keiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private BizNumber zennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUWRBKRT)
    public BizNumber getZennouwrbkrt() {
        return zennouwrbkrt;
    }

    public void setZennouwrbkrt(BizNumber pZennouwrbkrt) {
        zennouwrbkrt = pZennouwrbkrt;
    }

    private BizNumber tndmatutkyrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.TNDMATUTKYRT)
    public BizNumber getTndmatutkyrt() {
        return tndmatutkyrt;
    }

    public void setTndmatutkyrt(BizNumber pTndmatutkyrt) {
        tndmatutkyrt = pTndmatutkyrt;
    }

    private String tndzndkhikakukbn;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.TNDZNDKHIKAKUKBN)
    public String getTndzndkhikakukbn() {
        return tndzndkhikakukbn;
    }

    public void setTndzndkhikakukbn(String pTndzndkhikakukbn) {
        tndzndkhikakukbn = pTndzndkhikakukbn;
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    private C_ZennouKbn zennoukbn;

    @Type(type="UserType_C_ZennouKbn")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUKBN)
    public C_ZennouKbn getZennoukbn() {
        return zennoukbn;
    }

    public void setZennoukbn(C_ZennouKbn pZennoukbn) {
        zennoukbn = pZennoukbn;
    }

    private String zennoukikan;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }

    private BizDate zennounyuukinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZENNOUNYUUKINYMD)
    public BizDate getZennounyuukinymd() {
        return zennounyuukinymd;
    }

    public void setZennounyuukinymd(BizDate pZennounyuukinymd) {
        zennounyuukinymd = pZennounyuukinymd;
    }

    private BizCurrency zennounyuukinkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennounyuukinkgk() {
        return zennounyuukinkgk;
    }

    public void setZennounyuukinkgk(BizCurrency pZennounyuukinkgk) {
        zennounyuukinkgk = pZennounyuukinkgk;
        zennounyuukinkgkValue = null;
        zennounyuukinkgkType  = null;
    }

    transient private BigDecimal zennounyuukinkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUNYUUKINKGK, nullable=true)
    protected BigDecimal getZennounyuukinkgkValue() {
        if (zennounyuukinkgkValue == null && zennounyuukinkgk != null) {
            if (zennounyuukinkgk.isOptional()) return null;
            return zennounyuukinkgk.absolute();
        }
        return zennounyuukinkgkValue;
    }

    protected void setZennounyuukinkgkValue(BigDecimal value) {
        zennounyuukinkgkValue = value;
        zennounyuukinkgk = Optional.fromNullable(toCurrencyType(zennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkValue()))
            .orNull();
    }

    transient private String zennounyuukinkgkType = null;

    @Column(name=ZENNOUNYUUKINKGK + "$", nullable=true)
    protected String getZennounyuukinkgkType() {
        if (zennounyuukinkgkType == null && zennounyuukinkgk != null) return zennounyuukinkgk.getType().toString();
        if (zennounyuukinkgkType == null && getZennounyuukinkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennounyuukinkgk$' should not be NULL."));
        }
        return zennounyuukinkgkType;
    }

    protected void setZennounyuukinkgkType(String type) {
        zennounyuukinkgkType = type;
        zennounyuukinkgk = Optional.fromNullable(toCurrencyType(zennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkValue()))
            .orNull();
    }

    private BizCurrency toukimatuzennouzndk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getToukimatuzennouzndk() {
        return toukimatuzennouzndk;
    }

    public void setToukimatuzennouzndk(BizCurrency pToukimatuzennouzndk) {
        toukimatuzennouzndk = pToukimatuzennouzndk;
        toukimatuzennouzndkValue = null;
        toukimatuzennouzndkType  = null;
    }

    transient private BigDecimal toukimatuzennouzndkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUKIMATUZENNOUZNDK, nullable=true)
    protected BigDecimal getToukimatuzennouzndkValue() {
        if (toukimatuzennouzndkValue == null && toukimatuzennouzndk != null) {
            if (toukimatuzennouzndk.isOptional()) return null;
            return toukimatuzennouzndk.absolute();
        }
        return toukimatuzennouzndkValue;
    }

    protected void setToukimatuzennouzndkValue(BigDecimal value) {
        toukimatuzennouzndkValue = value;
        toukimatuzennouzndk = Optional.fromNullable(toCurrencyType(toukimatuzennouzndkType))
            .transform(bizCurrencyTransformer(getToukimatuzennouzndkValue()))
            .orNull();
    }

    transient private String toukimatuzennouzndkType = null;

    @Column(name=TOUKIMATUZENNOUZNDK + "$", nullable=true)
    protected String getToukimatuzennouzndkType() {
        if (toukimatuzennouzndkType == null && toukimatuzennouzndk != null) return toukimatuzennouzndk.getType().toString();
        if (toukimatuzennouzndkType == null && getToukimatuzennouzndkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'toukimatuzennouzndk$' should not be NULL."));
        }
        return toukimatuzennouzndkType;
    }

    protected void setToukimatuzennouzndkType(String type) {
        toukimatuzennouzndkType = type;
        toukimatuzennouzndk = Optional.fromNullable(toCurrencyType(toukimatuzennouzndkType))
            .transform(bizCurrencyTransformer(getToukimatuzennouzndkValue()))
            .orNull();
    }

    private BizCurrency toukijyuutoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getToukijyuutoup() {
        return toukijyuutoup;
    }

    public void setToukijyuutoup(BizCurrency pToukijyuutoup) {
        toukijyuutoup = pToukijyuutoup;
        toukijyuutoupValue = null;
        toukijyuutoupType  = null;
    }

    transient private BigDecimal toukijyuutoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUKIJYUUTOUP, nullable=true)
    protected BigDecimal getToukijyuutoupValue() {
        if (toukijyuutoupValue == null && toukijyuutoup != null) {
            if (toukijyuutoup.isOptional()) return null;
            return toukijyuutoup.absolute();
        }
        return toukijyuutoupValue;
    }

    protected void setToukijyuutoupValue(BigDecimal value) {
        toukijyuutoupValue = value;
        toukijyuutoup = Optional.fromNullable(toCurrencyType(toukijyuutoupType))
            .transform(bizCurrencyTransformer(getToukijyuutoupValue()))
            .orNull();
    }

    transient private String toukijyuutoupType = null;

    @Column(name=TOUKIJYUUTOUP + "$", nullable=true)
    protected String getToukijyuutoupType() {
        if (toukijyuutoupType == null && toukijyuutoup != null) return toukijyuutoup.getType().toString();
        if (toukijyuutoupType == null && getToukijyuutoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'toukijyuutoup$' should not be NULL."));
        }
        return toukijyuutoupType;
    }

    protected void setToukijyuutoupType(String type) {
        toukijyuutoupType = type;
        toukijyuutoup = Optional.fromNullable(toCurrencyType(toukijyuutoupType))
            .transform(bizCurrencyTransformer(getToukijyuutoupValue()))
            .orNull();
    }

    private BizCurrency toukizennouseisangk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getToukizennouseisangk() {
        return toukizennouseisangk;
    }

    public void setToukizennouseisangk(BizCurrency pToukizennouseisangk) {
        toukizennouseisangk = pToukizennouseisangk;
        toukizennouseisangkValue = null;
        toukizennouseisangkType  = null;
    }

    transient private BigDecimal toukizennouseisangkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUKIZENNOUSEISANGK, nullable=true)
    protected BigDecimal getToukizennouseisangkValue() {
        if (toukizennouseisangkValue == null && toukizennouseisangk != null) {
            if (toukizennouseisangk.isOptional()) return null;
            return toukizennouseisangk.absolute();
        }
        return toukizennouseisangkValue;
    }

    protected void setToukizennouseisangkValue(BigDecimal value) {
        toukizennouseisangkValue = value;
        toukizennouseisangk = Optional.fromNullable(toCurrencyType(toukizennouseisangkType))
            .transform(bizCurrencyTransformer(getToukizennouseisangkValue()))
            .orNull();
    }

    transient private String toukizennouseisangkType = null;

    @Column(name=TOUKIZENNOUSEISANGK + "$", nullable=true)
    protected String getToukizennouseisangkType() {
        if (toukizennouseisangkType == null && toukizennouseisangk != null) return toukizennouseisangk.getType().toString();
        if (toukizennouseisangkType == null && getToukizennouseisangkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'toukizennouseisangk$' should not be NULL."));
        }
        return toukizennouseisangkType;
    }

    protected void setToukizennouseisangkType(String type) {
        toukizennouseisangkType = type;
        toukizennouseisangk = Optional.fromNullable(toCurrencyType(toukizennouseisangkType))
            .transform(bizCurrencyTransformer(getToukizennouseisangkValue()))
            .orNull();
    }

    private BizCurrency toukizennounyuukinkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getToukizennounyuukinkgk() {
        return toukizennounyuukinkgk;
    }

    public void setToukizennounyuukinkgk(BizCurrency pToukizennounyuukinkgk) {
        toukizennounyuukinkgk = pToukizennounyuukinkgk;
        toukizennounyuukinkgkValue = null;
        toukizennounyuukinkgkType  = null;
    }

    transient private BigDecimal toukizennounyuukinkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUKIZENNOUNYUUKINKGK, nullable=true)
    protected BigDecimal getToukizennounyuukinkgkValue() {
        if (toukizennounyuukinkgkValue == null && toukizennounyuukinkgk != null) {
            if (toukizennounyuukinkgk.isOptional()) return null;
            return toukizennounyuukinkgk.absolute();
        }
        return toukizennounyuukinkgkValue;
    }

    protected void setToukizennounyuukinkgkValue(BigDecimal value) {
        toukizennounyuukinkgkValue = value;
        toukizennounyuukinkgk = Optional.fromNullable(toCurrencyType(toukizennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getToukizennounyuukinkgkValue()))
            .orNull();
    }

    transient private String toukizennounyuukinkgkType = null;

    @Column(name=TOUKIZENNOUNYUUKINKGK + "$", nullable=true)
    protected String getToukizennounyuukinkgkType() {
        if (toukizennounyuukinkgkType == null && toukizennounyuukinkgk != null) return toukizennounyuukinkgk.getType().toString();
        if (toukizennounyuukinkgkType == null && getToukizennounyuukinkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'toukizennounyuukinkgk$' should not be NULL."));
        }
        return toukizennounyuukinkgkType;
    }

    protected void setToukizennounyuukinkgkType(String type) {
        toukizennounyuukinkgkType = type;
        toukizennounyuukinkgk = Optional.fromNullable(toCurrencyType(toukizennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getToukizennounyuukinkgkValue()))
            .orNull();
    }

    private BizCurrency yokukinenbaraip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYokukinenbaraip() {
        return yokukinenbaraip;
    }

    public void setYokukinenbaraip(BizCurrency pYokukinenbaraip) {
        yokukinenbaraip = pYokukinenbaraip;
        yokukinenbaraipValue = null;
        yokukinenbaraipType  = null;
    }

    transient private BigDecimal yokukinenbaraipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YOKUKINENBARAIP, nullable=true)
    protected BigDecimal getYokukinenbaraipValue() {
        if (yokukinenbaraipValue == null && yokukinenbaraip != null) {
            if (yokukinenbaraip.isOptional()) return null;
            return yokukinenbaraip.absolute();
        }
        return yokukinenbaraipValue;
    }

    protected void setYokukinenbaraipValue(BigDecimal value) {
        yokukinenbaraipValue = value;
        yokukinenbaraip = Optional.fromNullable(toCurrencyType(yokukinenbaraipType))
            .transform(bizCurrencyTransformer(getYokukinenbaraipValue()))
            .orNull();
    }

    transient private String yokukinenbaraipType = null;

    @Column(name=YOKUKINENBARAIP + "$", nullable=true)
    protected String getYokukinenbaraipType() {
        if (yokukinenbaraipType == null && yokukinenbaraip != null) return yokukinenbaraip.getType().toString();
        if (yokukinenbaraipType == null && getYokukinenbaraipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yokukinenbaraip$' should not be NULL."));
        }
        return yokukinenbaraipType;
    }

    protected void setYokukinenbaraipType(String type) {
        yokukinenbaraipType = type;
        yokukinenbaraip = Optional.fromNullable(toCurrencyType(yokukinenbaraipType))
            .transform(bizCurrencyTransformer(getYokukinenbaraipValue()))
            .orNull();
    }

    private BizCurrency wrbkrttkyrt;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getWrbkrttkyrt() {
        return wrbkrttkyrt;
    }

    public void setWrbkrttkyrt(BizCurrency pWrbkrttkyrt) {
        wrbkrttkyrt = pWrbkrttkyrt;
        wrbkrttkyrtValue = null;
        wrbkrttkyrtType  = null;
    }

    transient private BigDecimal wrbkrttkyrtValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=WRBKRTTKYRT, nullable=true)
    protected BigDecimal getWrbkrttkyrtValue() {
        if (wrbkrttkyrtValue == null && wrbkrttkyrt != null) {
            if (wrbkrttkyrt.isOptional()) return null;
            return wrbkrttkyrt.absolute();
        }
        return wrbkrttkyrtValue;
    }

    protected void setWrbkrttkyrtValue(BigDecimal value) {
        wrbkrttkyrtValue = value;
        wrbkrttkyrt = Optional.fromNullable(toCurrencyType(wrbkrttkyrtType))
            .transform(bizCurrencyTransformer(getWrbkrttkyrtValue()))
            .orNull();
    }

    transient private String wrbkrttkyrtType = null;

    @Column(name=WRBKRTTKYRT + "$", nullable=true)
    protected String getWrbkrttkyrtType() {
        if (wrbkrttkyrtType == null && wrbkrttkyrt != null) return wrbkrttkyrt.getType().toString();
        if (wrbkrttkyrtType == null && getWrbkrttkyrtValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'wrbkrttkyrt$' should not be NULL."));
        }
        return wrbkrttkyrtType;
    }

    protected void setWrbkrttkyrtType(String type) {
        wrbkrttkyrtType = type;
        wrbkrttkyrt = Optional.fromNullable(toCurrencyType(wrbkrttkyrtType))
            .transform(bizCurrencyTransformer(getWrbkrttkyrtValue()))
            .orNull();
    }

    private String gkdtznnhyj;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.GKDTZNNHYJ)
    public String getGkdtznnhyj() {
        return gkdtznnhyj;
    }

    public void setGkdtznnhyj(String pGkdtznnhyj) {
        gkdtznnhyj = pGkdtznnhyj;
    }

    private String znngaikakbn;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZNNGAIKAKBN)
    public String getZnngaikakbn() {
        return znngaikakbn;
    }

    public void setZnngaikakbn(String pZnngaikakbn) {
        znngaikakbn = pZnngaikakbn;
    }

    private String yenkanyknhyj;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.YENKANYKNHYJ)
    public String getYenkanyknhyj() {
        return yenkanyknhyj;
    }

    public void setYenkanyknhyj(String pYenkanyknhyj) {
        yenkanyknhyj = pYenkanyknhyj;
    }

    private BizNumber znnnyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZNNNYKNJIKAWASERATE)
    public BizNumber getZnnnyknjikawaserate() {
        return znnnyknjikawaserate;
    }

    public void setZnnnyknjikawaserate(BizNumber pZnnnyknjikawaserate) {
        znnnyknjikawaserate = pZnnnyknjikawaserate;
    }

    private BizDate znnnyknjikawaseratetkyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZNNNYKNJIKAWASERATETKYUYMD)
    public BizDate getZnnnyknjikawaseratetkyuymd() {
        return znnnyknjikawaseratetkyuymd;
    }

    public void setZnnnyknjikawaseratetkyuymd(BizDate pZnnnyknjikawaseratetkyuymd) {
        znnnyknjikawaseratetkyuymd = pZnnnyknjikawaseratetkyuymd;
    }

    private BizNumber ksnkisikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KSNKISIKAWASERATE)
    public BizNumber getKsnkisikawaserate() {
        return ksnkisikawaserate;
    }

    public void setKsnkisikawaserate(BizNumber pKsnkisikawaserate) {
        ksnkisikawaserate = pKsnkisikawaserate;
    }

    private BizNumber znncalckjynymdkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.ZNNCALCKJYNYMDKWSRATE)
    public BizNumber getZnncalckjynymdkwsrate() {
        return znncalckjynymdkwsrate;
    }

    public void setZnncalckjynymdkwsrate(BizNumber pZnncalckjynymdkwsrate) {
        znncalckjynymdkwsrate = pZnncalckjynymdkwsrate;
    }

    private BizNumber ksnkimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.KSNKIMATUKAWASERATE)
    public BizNumber getKsnkimatukawaserate() {
        return ksnkimatukawaserate;
    }

    public void setKsnkimatukawaserate(BizNumber pKsnkimatukawaserate) {
        ksnkimatukawaserate = pKsnkimatukawaserate;
    }

    private BizCurrency zennounyuukinkgktkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennounyuukinkgktkmatu() {
        return zennounyuukinkgktkmatu;
    }

    public void setZennounyuukinkgktkmatu(BizCurrency pZennounyuukinkgktkmatu) {
        zennounyuukinkgktkmatu = pZennounyuukinkgktkmatu;
        zennounyuukinkgktkmatuValue = null;
        zennounyuukinkgktkmatuType  = null;
    }

    transient private BigDecimal zennounyuukinkgktkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUNYUUKINKGKTKMATU, nullable=true)
    protected BigDecimal getZennounyuukinkgktkmatuValue() {
        if (zennounyuukinkgktkmatuValue == null && zennounyuukinkgktkmatu != null) {
            if (zennounyuukinkgktkmatu.isOptional()) return null;
            return zennounyuukinkgktkmatu.absolute();
        }
        return zennounyuukinkgktkmatuValue;
    }

    protected void setZennounyuukinkgktkmatuValue(BigDecimal value) {
        zennounyuukinkgktkmatuValue = value;
        zennounyuukinkgktkmatu = Optional.fromNullable(toCurrencyType(zennounyuukinkgktkmatuType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgktkmatuValue()))
            .orNull();
    }

    transient private String zennounyuukinkgktkmatuType = null;

    @Column(name=ZENNOUNYUUKINKGKTKMATU + "$", nullable=true)
    protected String getZennounyuukinkgktkmatuType() {
        if (zennounyuukinkgktkmatuType == null && zennounyuukinkgktkmatu != null) return zennounyuukinkgktkmatu.getType().toString();
        if (zennounyuukinkgktkmatuType == null && getZennounyuukinkgktkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennounyuukinkgktkmatu$' should not be NULL."));
        }
        return zennounyuukinkgktkmatuType;
    }

    protected void setZennounyuukinkgktkmatuType(String type) {
        zennounyuukinkgktkmatuType = type;
        zennounyuukinkgktkmatu = Optional.fromNullable(toCurrencyType(zennounyuukinkgktkmatuType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgktkmatuValue()))
            .orNull();
    }

    private BizCurrency tkmatuznnzndktkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkmatuznnzndktkmatu() {
        return tkmatuznnzndktkmatu;
    }

    public void setTkmatuznnzndktkmatu(BizCurrency pTkmatuznnzndktkmatu) {
        tkmatuznnzndktkmatu = pTkmatuznnzndktkmatu;
        tkmatuznnzndktkmatuValue = null;
        tkmatuznnzndktkmatuType  = null;
    }

    transient private BigDecimal tkmatuznnzndktkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKMATUZNNZNDKTKMATU, nullable=true)
    protected BigDecimal getTkmatuznnzndktkmatuValue() {
        if (tkmatuznnzndktkmatuValue == null && tkmatuznnzndktkmatu != null) {
            if (tkmatuznnzndktkmatu.isOptional()) return null;
            return tkmatuznnzndktkmatu.absolute();
        }
        return tkmatuznnzndktkmatuValue;
    }

    protected void setTkmatuznnzndktkmatuValue(BigDecimal value) {
        tkmatuznnzndktkmatuValue = value;
        tkmatuznnzndktkmatu = Optional.fromNullable(toCurrencyType(tkmatuznnzndktkmatuType))
            .transform(bizCurrencyTransformer(getTkmatuznnzndktkmatuValue()))
            .orNull();
    }

    transient private String tkmatuznnzndktkmatuType = null;

    @Column(name=TKMATUZNNZNDKTKMATU + "$", nullable=true)
    protected String getTkmatuznnzndktkmatuType() {
        if (tkmatuznnzndktkmatuType == null && tkmatuznnzndktkmatu != null) return tkmatuznnzndktkmatu.getType().toString();
        if (tkmatuznnzndktkmatuType == null && getTkmatuznnzndktkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkmatuznnzndktkmatu$' should not be NULL."));
        }
        return tkmatuznnzndktkmatuType;
    }

    protected void setTkmatuznnzndktkmatuType(String type) {
        tkmatuznnzndktkmatuType = type;
        tkmatuznnzndktkmatu = Optional.fromNullable(toCurrencyType(tkmatuznnzndktkmatuType))
            .transform(bizCurrencyTransformer(getTkmatuznnzndktkmatuValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_ZennouHoyuuIdouKykDtl.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}