package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_UriageSousinTy;
import yuyu.def.db.id.PKZT_UriageSousinTy;
import yuyu.def.db.meta.GenQZT_UriageSousinTy;
import yuyu.def.db.meta.QZT_UriageSousinTy;

/**
 * 売上送信Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_UriageSousinTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_UriageSousinTy}</td><td colspan="3">売上送信Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtycreditkessaiyouno ztycreditkessaiyouno}</td><td>（中継用）クレジットカード決済用番号</td><td align="center">{@link PKZT_UriageSousinTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyauthorikbn ztyauthorikbn}</td><td>（中継用）オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuriageseikyuuymd ztyuriageseikyuuymd}</td><td>（中継用）売上請求年月日</td><td align="center">{@link PKZT_UriageSousinTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrsgaku ztyrsgaku}</td><td>（中継用）領収金額</td><td align="center">{@link PKZT_UriageSousinTy ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyfukusuukameitennokey ztyfukusuukameitennokey}</td><td>（中継用）複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_UriageSousinTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordno ztyrecordno}</td><td>（中継用）レコード番号</td><td align="center">{@link PKZT_UriageSousinTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuriagetaisyouym ztyuriagetaisyouym}</td><td>（中継用）売上対象年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv33 ztyyobiv33}</td><td>（中継用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_UriageSousinTy
 * @see     PKZT_UriageSousinTy
 * @see     QZT_UriageSousinTy
 * @see     GenQZT_UriageSousinTy
 */
@MappedSuperclass
@Table(name=GenZT_UriageSousinTy.TABLE_NAME)
@IdClass(value=PKZT_UriageSousinTy.class)
public abstract class GenZT_UriageSousinTy extends AbstractExDBEntity<ZT_UriageSousinTy, PKZT_UriageSousinTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_UriageSousinTy";
    public static final String ZTYCREDITKESSAIYOUNO     = "ztycreditkessaiyouno";
    public static final String ZTYAUTHORIKBN            = "ztyauthorikbn";
    public static final String ZTYURIAGESEIKYUUYMD      = "ztyuriageseikyuuymd";
    public static final String ZTYRSGAKU                = "ztyrsgaku";
    public static final String ZTYFUKUSUUKAMEITENNOKEY  = "ztyfukusuukameitennokey";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYRECORDNO              = "ztyrecordno";
    public static final String ZTYURIAGETAISYOUYM       = "ztyuriagetaisyouym";
    public static final String ZTYYOBIV33               = "ztyyobiv33";

    private final PKZT_UriageSousinTy primaryKey;

    public GenZT_UriageSousinTy() {
        primaryKey = new PKZT_UriageSousinTy();
    }

    public GenZT_UriageSousinTy(
        String pZtycreditkessaiyouno,
        String pZtysyono,
        String pZtyuriageseikyuuymd,
        Long pZtyrsgaku,
        String pZtyrecordno
    ) {
        primaryKey = new PKZT_UriageSousinTy(
            pZtycreditkessaiyouno,
            pZtysyono,
            pZtyuriageseikyuuymd,
            pZtyrsgaku,
            pZtyrecordno
        );
    }

    @Transient
    @Override
    public PKZT_UriageSousinTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_UriageSousinTy> getMetaClass() {
        return QZT_UriageSousinTy.class;
    }

    @Id
    @Column(name=GenZT_UriageSousinTy.ZTYCREDITKESSAIYOUNO)
    public String getZtycreditkessaiyouno() {
        return getPrimaryKey().getZtycreditkessaiyouno();
    }

    public void setZtycreditkessaiyouno(String pZtycreditkessaiyouno) {
        getPrimaryKey().setZtycreditkessaiyouno(pZtycreditkessaiyouno);
    }

    private String ztyauthorikbn;

    @Column(name=GenZT_UriageSousinTy.ZTYAUTHORIKBN)
    public String getZtyauthorikbn() {
        return ztyauthorikbn;
    }

    public void setZtyauthorikbn(String pZtyauthorikbn) {
        ztyauthorikbn = pZtyauthorikbn;
    }

    @Id
    @Column(name=GenZT_UriageSousinTy.ZTYURIAGESEIKYUUYMD)
    public String getZtyuriageseikyuuymd() {
        return getPrimaryKey().getZtyuriageseikyuuymd();
    }

    @DataConvert("toSingleByte")
    public void setZtyuriageseikyuuymd(String pZtyuriageseikyuuymd) {
        getPrimaryKey().setZtyuriageseikyuuymd(pZtyuriageseikyuuymd);
    }

    @Id
    @Column(name=GenZT_UriageSousinTy.ZTYRSGAKU)
    public Long getZtyrsgaku() {
        return getPrimaryKey().getZtyrsgaku();
    }

    public void setZtyrsgaku(Long pZtyrsgaku) {
        getPrimaryKey().setZtyrsgaku(pZtyrsgaku);
    }

    private String ztyfukusuukameitennokey;

    @Column(name=GenZT_UriageSousinTy.ZTYFUKUSUUKAMEITENNOKEY)
    public String getZtyfukusuukameitennokey() {
        return ztyfukusuukameitennokey;
    }

    public void setZtyfukusuukameitennokey(String pZtyfukusuukameitennokey) {
        ztyfukusuukameitennokey = pZtyfukusuukameitennokey;
    }

    @Id
    @Column(name=GenZT_UriageSousinTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_UriageSousinTy.ZTYRECORDNO)
    public String getZtyrecordno() {
        return getPrimaryKey().getZtyrecordno();
    }

    public void setZtyrecordno(String pZtyrecordno) {
        getPrimaryKey().setZtyrecordno(pZtyrecordno);
    }

    private String ztyuriagetaisyouym;

    @Column(name=GenZT_UriageSousinTy.ZTYURIAGETAISYOUYM)
    public String getZtyuriagetaisyouym() {
        return ztyuriagetaisyouym;
    }

    public void setZtyuriagetaisyouym(String pZtyuriagetaisyouym) {
        ztyuriagetaisyouym = pZtyuriagetaisyouym;
    }

    private String ztyyobiv33;

    @Column(name=GenZT_UriageSousinTy.ZTYYOBIV33)
    public String getZtyyobiv33() {
        return ztyyobiv33;
    }

    public void setZtyyobiv33(String pZtyyobiv33) {
        ztyyobiv33 = pZtyyobiv33;
    }
}