package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.db.id.PKJM_SiinHantei;
import yuyu.def.db.meta.GenQJM_SiinHantei;
import yuyu.def.db.meta.QJM_SiinHantei;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 死因判定マスタ テーブルのマッピング情報クラスで、 {@link JM_SiinHantei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiinHantei}</td><td colspan="3">死因判定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSiboukariuketukejigeninkbn siboukariuketukejigeninkbn}</td><td>死亡仮受付時原因区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuuuketukejigeninkbn seikyuuuketukejigeninkbn}</td><td>請求受付時原因区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getKansensyouumukbn kansensyouumukbn}</td><td>感染症有無区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaigaikanouseiumukbn saigaikanouseiumukbn}</td><td>災害可能性有無区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHusyounosiumukbn husyounosiumukbn}</td><td>不詳の死有無区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikaksaigaikanouseikbn sateikaksaigaikanouseikbn}</td><td>査定回送要否確認（災害可能性）区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikakhusyousikbn sateikakhusyousikbn}</td><td>査定回送要否確認（不詳の死）区分</td><td align="center">{@link PKJM_SiinHantei ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSiinkbn siinkbn}</td><td>死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiinKbn}</td></tr>
 * </table>
 * @see     JM_SiinHantei
 * @see     PKJM_SiinHantei
 * @see     QJM_SiinHantei
 * @see     GenQJM_SiinHantei
 */
@MappedSuperclass
@Table(name=GenJM_SiinHantei.TABLE_NAME)
@IdClass(value=PKJM_SiinHantei.class)
@TypeDefs({
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_SiinKbn", typeClass=UserType_C_SiinKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJM_SiinHantei extends AbstractExDBEntity<JM_SiinHantei, PKJM_SiinHantei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_SiinHantei";
    public static final String SIBOUKARIUKETUKEJIGENINKBN = "siboukariuketukejigeninkbn";
    public static final String SEIKYUUUKETUKEJIGENINKBN = "seikyuuuketukejigeninkbn";
    public static final String KANSENSYOUUMUKBN         = "kansensyouumukbn";
    public static final String SAIGAIKANOUSEIUMUKBN     = "saigaikanouseiumukbn";
    public static final String HUSYOUNOSIUMUKBN         = "husyounosiumukbn";
    public static final String SATEIKAKSAIGAIKANOUSEIKBN = "sateikaksaigaikanouseikbn";
    public static final String SATEIKAKHUSYOUSIKBN      = "sateikakhusyousikbn";
    public static final String SIINKBN                  = "siinkbn";

    private final PKJM_SiinHantei primaryKey;

    public GenJM_SiinHantei() {
        primaryKey = new PKJM_SiinHantei();
    }

    public GenJM_SiinHantei(
        C_GeninKbn pSiboukariuketukejigeninkbn,
        C_GeninKbn pSeikyuuuketukejigeninkbn,
        C_UmuKbn pKansensyouumukbn,
        C_UmuKbn pSaigaikanouseiumukbn,
        C_UmuKbn pHusyounosiumukbn,
        C_UmuKbn pSateikaksaigaikanouseikbn,
        C_UmuKbn pSateikakhusyousikbn
    ) {
        primaryKey = new PKJM_SiinHantei(
            pSiboukariuketukejigeninkbn,
            pSeikyuuuketukejigeninkbn,
            pKansensyouumukbn,
            pSaigaikanouseiumukbn,
            pHusyounosiumukbn,
            pSateikaksaigaikanouseikbn,
            pSateikakhusyousikbn
        );
    }

    @Transient
    @Override
    public PKJM_SiinHantei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_SiinHantei> getMetaClass() {
        return QJM_SiinHantei.class;
    }

    @Id
    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJM_SiinHantei.SIBOUKARIUKETUKEJIGENINKBN)
    public C_GeninKbn getSiboukariuketukejigeninkbn() {
        return getPrimaryKey().getSiboukariuketukejigeninkbn();
    }

    public void setSiboukariuketukejigeninkbn(C_GeninKbn pSiboukariuketukejigeninkbn) {
        getPrimaryKey().setSiboukariuketukejigeninkbn(pSiboukariuketukejigeninkbn);
    }

    @Id
    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJM_SiinHantei.SEIKYUUUKETUKEJIGENINKBN)
    public C_GeninKbn getSeikyuuuketukejigeninkbn() {
        return getPrimaryKey().getSeikyuuuketukejigeninkbn();
    }

    public void setSeikyuuuketukejigeninkbn(C_GeninKbn pSeikyuuuketukejigeninkbn) {
        getPrimaryKey().setSeikyuuuketukejigeninkbn(pSeikyuuuketukejigeninkbn);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiinHantei.KANSENSYOUUMUKBN)
    public C_UmuKbn getKansensyouumukbn() {
        return getPrimaryKey().getKansensyouumukbn();
    }

    public void setKansensyouumukbn(C_UmuKbn pKansensyouumukbn) {
        getPrimaryKey().setKansensyouumukbn(pKansensyouumukbn);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiinHantei.SAIGAIKANOUSEIUMUKBN)
    public C_UmuKbn getSaigaikanouseiumukbn() {
        return getPrimaryKey().getSaigaikanouseiumukbn();
    }

    public void setSaigaikanouseiumukbn(C_UmuKbn pSaigaikanouseiumukbn) {
        getPrimaryKey().setSaigaikanouseiumukbn(pSaigaikanouseiumukbn);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiinHantei.HUSYOUNOSIUMUKBN)
    public C_UmuKbn getHusyounosiumukbn() {
        return getPrimaryKey().getHusyounosiumukbn();
    }

    public void setHusyounosiumukbn(C_UmuKbn pHusyounosiumukbn) {
        getPrimaryKey().setHusyounosiumukbn(pHusyounosiumukbn);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiinHantei.SATEIKAKSAIGAIKANOUSEIKBN)
    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return getPrimaryKey().getSateikaksaigaikanouseikbn();
    }

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        getPrimaryKey().setSateikaksaigaikanouseikbn(pSateikaksaigaikanouseikbn);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiinHantei.SATEIKAKHUSYOUSIKBN)
    public C_UmuKbn getSateikakhusyousikbn() {
        return getPrimaryKey().getSateikakhusyousikbn();
    }

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        getPrimaryKey().setSateikakhusyousikbn(pSateikakhusyousikbn);
    }

    private C_SiinKbn siinkbn;

    @Type(type="UserType_C_SiinKbn")
    @Column(name=GenJM_SiinHantei.SIINKBN)
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }
}
