package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_HknkykIdouInfoTy;
import yuyu.def.db.id.PKZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.GenQZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.QZT_HknkykIdouInfoTy;

/**
 * 保険契約異動情報テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_HknkykIdouInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HknkykIdouInfoTy}</td><td colspan="3">保険契約異動情報テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykyktuukasyu ztykyktuukasyu}</td><td>（中継用）契約通貨種類</td><td align="center">{@link PKZT_HknkykIdouInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidouymd ztyidouymd}</td><td>（中継用）異動日</td><td align="center">{@link PKZT_HknkykIdouInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidoujiyuukbnzfi ztyidoujiyuukbnzfi}</td><td>（中継用）異動事由区分（資産運用）</td><td align="center">{@link PKZT_HknkykIdouInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">{@link PKZT_HknkykIdouInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrenno ztyrenno}</td><td>（中継用）連番</td><td align="center">{@link PKZT_HknkykIdouInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2 ztyhhknnen2}</td><td>（中継用）被保険者年齢Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsei ztyhhknsei}</td><td>（中継用）被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisyoumeikbn ztyaisyoumeikbn}</td><td>（中継用）愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzougenkbn ztyzougenkbn}</td><td>（中継用）増減区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenkngk13 ztyhokenkngk13}</td><td>（中継用）保険金額Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyp13 ztyp13}</td><td>（中継用）保険料Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyptumitatekin13 ztyptumitatekin13}</td><td>（中継用）保険料積立金Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykiykhnrikn13 ztykiykhnrikn13}</td><td>（中継用）解約返戻金Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyidouhokenkngk ztyidouhokenkngk}</td><td>（中継用）異動保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyidoup ztyidoup}</td><td>（中継用）異動保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyidouptumitatekin ztyidouptumitatekin}</td><td>（中継用）異動保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyidoukiykhnrikn ztyidoukiykhnrikn}</td><td>（中継用）異動解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5 ztyyoteiriritun5}</td><td>（中継用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitatekinkbn ztytumitatekinkbn}</td><td>（中継用）積立金区分</td><td align="center">{@link PKZT_HknkykIdouInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbnkykidou ztyharaikatakbnkykidou}</td><td>（中継用）払方区分（保険契約異動情報）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HknkykIdouInfoTy
 * @see     PKZT_HknkykIdouInfoTy
 * @see     QZT_HknkykIdouInfoTy
 * @see     GenQZT_HknkykIdouInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_HknkykIdouInfoTy.TABLE_NAME)
@IdClass(value=PKZT_HknkykIdouInfoTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_HknkykIdouInfoTy extends AbstractExDBEntity<ZT_HknkykIdouInfoTy, PKZT_HknkykIdouInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HknkykIdouInfoTy";
    public static final String ZTYKYKTUUKASYU           = "ztykyktuukasyu";
    public static final String ZTYIDOUYMD               = "ztyidouymd";
    public static final String ZTYIDOUJIYUUKBNZFI       = "ztyidoujiyuukbnzfi";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYRENNO                 = "ztyrenno";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYHHKNNEN2              = "ztyhhknnen2";
    public static final String ZTYHHKNSEI               = "ztyhhknsei";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYAISYOUMEIKBN          = "ztyaisyoumeikbn";
    public static final String ZTYZOUGENKBN             = "ztyzougenkbn";
    public static final String ZTYHOKENKNGK13           = "ztyhokenkngk13";
    public static final String ZTYP13                   = "ztyp13";
    public static final String ZTYPTUMITATEKIN13        = "ztyptumitatekin13";
    public static final String ZTYKIYKHNRIKN13          = "ztykiykhnrikn13";
    public static final String ZTYIDOUHOKENKNGK         = "ztyidouhokenkngk";
    public static final String ZTYIDOUP                 = "ztyidoup";
    public static final String ZTYIDOUPTUMITATEKIN      = "ztyidouptumitatekin";
    public static final String ZTYIDOUKIYKHNRIKN        = "ztyidoukiykhnrikn";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYYOTEIRIRITUN5         = "ztyyoteiriritun5";
    public static final String ZTYTUMITATEKINKBN        = "ztytumitatekinkbn";
    public static final String ZTYHARAIKATAKBNKYKIDOU   = "ztyharaikatakbnkykidou";

    private final PKZT_HknkykIdouInfoTy primaryKey;

    public GenZT_HknkykIdouInfoTy() {
        primaryKey = new PKZT_HknkykIdouInfoTy();
    }

    public GenZT_HknkykIdouInfoTy(
        String pZtykyktuukasyu,
        String pZtyidouymd,
        String pZtyidoujiyuukbnzfi,
        String pZtydatakanrino,
        String pZtyrenno,
        String pZtytumitatekinkbn
    ) {
        primaryKey = new PKZT_HknkykIdouInfoTy(
            pZtykyktuukasyu,
            pZtyidouymd,
            pZtyidoujiyuukbnzfi,
            pZtydatakanrino,
            pZtyrenno,
            pZtytumitatekinkbn
        );
    }

    @Transient
    @Override
    public PKZT_HknkykIdouInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HknkykIdouInfoTy> getMetaClass() {
        return QZT_HknkykIdouInfoTy.class;
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYKYKTUUKASYU)
    public String getZtykyktuukasyu() {
        return getPrimaryKey().getZtykyktuukasyu();
    }

    public void setZtykyktuukasyu(String pZtykyktuukasyu) {
        getPrimaryKey().setZtykyktuukasyu(pZtykyktuukasyu);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYIDOUYMD)
    public String getZtyidouymd() {
        return getPrimaryKey().getZtyidouymd();
    }

    public void setZtyidouymd(String pZtyidouymd) {
        getPrimaryKey().setZtyidouymd(pZtyidouymd);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYIDOUJIYUUKBNZFI)
    public String getZtyidoujiyuukbnzfi() {
        return getPrimaryKey().getZtyidoujiyuukbnzfi();
    }

    public void setZtyidoujiyuukbnzfi(String pZtyidoujiyuukbnzfi) {
        getPrimaryKey().setZtyidoujiyuukbnzfi(pZtyidoujiyuukbnzfi);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return getPrimaryKey().getZtydatakanrino();
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        getPrimaryKey().setZtydatakanrino(pZtydatakanrino);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYRENNO)
    public String getZtyrenno() {
        return getPrimaryKey().getZtyrenno();
    }

    public void setZtyrenno(String pZtyrenno) {
        getPrimaryKey().setZtyrenno(pZtyrenno);
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztyhhknnen2;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYHHKNNEN2)
    public String getZtyhhknnen2() {
        return ztyhhknnen2;
    }

    public void setZtyhhknnen2(String pZtyhhknnen2) {
        ztyhhknnen2 = pZtyhhknnen2;
    }

    private String ztyhhknsei;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYHHKNSEI)
    public String getZtyhhknsei() {
        return ztyhhknsei;
    }

    public void setZtyhhknsei(String pZtyhhknsei) {
        ztyhhknsei = pZtyhhknsei;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyaisyoumeikbn;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYAISYOUMEIKBN)
    public String getZtyaisyoumeikbn() {
        return ztyaisyoumeikbn;
    }

    public void setZtyaisyoumeikbn(String pZtyaisyoumeikbn) {
        ztyaisyoumeikbn = pZtyaisyoumeikbn;
    }

    private String ztyzougenkbn;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYZOUGENKBN)
    public String getZtyzougenkbn() {
        return ztyzougenkbn;
    }

    public void setZtyzougenkbn(String pZtyzougenkbn) {
        ztyzougenkbn = pZtyzougenkbn;
    }

    private BizNumber ztyhokenkngk13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYHOKENKNGK13)
    public BizNumber getZtyhokenkngk13() {
        return ztyhokenkngk13;
    }

    public void setZtyhokenkngk13(BizNumber pZtyhokenkngk13) {
        ztyhokenkngk13 = pZtyhokenkngk13;
    }

    private BizNumber ztyp13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYP13)
    public BizNumber getZtyp13() {
        return ztyp13;
    }

    public void setZtyp13(BizNumber pZtyp13) {
        ztyp13 = pZtyp13;
    }

    private BizNumber ztyptumitatekin13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYPTUMITATEKIN13)
    public BizNumber getZtyptumitatekin13() {
        return ztyptumitatekin13;
    }

    public void setZtyptumitatekin13(BizNumber pZtyptumitatekin13) {
        ztyptumitatekin13 = pZtyptumitatekin13;
    }

    private BizNumber ztykiykhnrikn13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYKIYKHNRIKN13)
    public BizNumber getZtykiykhnrikn13() {
        return ztykiykhnrikn13;
    }

    public void setZtykiykhnrikn13(BizNumber pZtykiykhnrikn13) {
        ztykiykhnrikn13 = pZtykiykhnrikn13;
    }

    private BizNumber ztyidouhokenkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYIDOUHOKENKNGK)
    public BizNumber getZtyidouhokenkngk() {
        return ztyidouhokenkngk;
    }

    public void setZtyidouhokenkngk(BizNumber pZtyidouhokenkngk) {
        ztyidouhokenkngk = pZtyidouhokenkngk;
    }

    private BizNumber ztyidoup;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYIDOUP)
    public BizNumber getZtyidoup() {
        return ztyidoup;
    }

    public void setZtyidoup(BizNumber pZtyidoup) {
        ztyidoup = pZtyidoup;
    }

    private BizNumber ztyidouptumitatekin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYIDOUPTUMITATEKIN)
    public BizNumber getZtyidouptumitatekin() {
        return ztyidouptumitatekin;
    }

    public void setZtyidouptumitatekin(BizNumber pZtyidouptumitatekin) {
        ztyidouptumitatekin = pZtyidouptumitatekin;
    }

    private BizNumber ztyidoukiykhnrikn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYIDOUKIYKHNRIKN)
    public BizNumber getZtyidoukiykhnrikn() {
        return ztyidoukiykhnrikn;
    }

    public void setZtyidoukiykhnrikn(BizNumber pZtyidoukiykhnrikn) {
        ztyidoukiykhnrikn = pZtyidoukiykhnrikn;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private BizNumber ztyyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYYOTEIRIRITUN5)
    public BizNumber getZtyyoteiriritun5() {
        return ztyyoteiriritun5;
    }

    public void setZtyyoteiriritun5(BizNumber pZtyyoteiriritun5) {
        ztyyoteiriritun5 = pZtyyoteiriritun5;
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoTy.ZTYTUMITATEKINKBN)
    public String getZtytumitatekinkbn() {
        return getPrimaryKey().getZtytumitatekinkbn();
    }

    public void setZtytumitatekinkbn(String pZtytumitatekinkbn) {
        getPrimaryKey().setZtytumitatekinkbn(pZtytumitatekinkbn);
    }

    private String ztyharaikatakbnkykidou;

    @Column(name=GenZT_HknkykIdouInfoTy.ZTYHARAIKATAKBNKYKIDOU)
    public String getZtyharaikatakbnkykidou() {
        return ztyharaikatakbnkykidou;
    }

    public void setZtyharaikatakbnkykidou(String pZtyharaikatakbnkykidou) {
        ztyharaikatakbnkykidou = pZtyharaikatakbnkykidou;
    }
}