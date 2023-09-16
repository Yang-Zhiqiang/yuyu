package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.id.PKBM_Sisuu;
import yuyu.def.db.meta.GenQBM_Sisuu;
import yuyu.def.db.meta.QBM_Sisuu;
import yuyu.def.db.type.UserType_C_Sisuukbn;

/**
 * 指数マスタ テーブルのマッピング情報クラスで、 {@link BM_Sisuu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Sisuu}</td><td colspan="3">指数マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">{@link PKBM_Sisuu ○}</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getSisuukouhyouymd sisuukouhyouymd}</td><td>指数公表日</td><td align="center">{@link PKBM_Sisuu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSisuu sisuu}</td><td>指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisuucalckijyunymd sisuucalckijyunymd}</td><td>指数計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_Sisuu
 * @see     PKBM_Sisuu
 * @see     QBM_Sisuu
 * @see     GenQBM_Sisuu
 */
@MappedSuperclass
@Table(name=GenBM_Sisuu.TABLE_NAME)
@IdClass(value=PKBM_Sisuu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class)
})
public abstract class GenBM_Sisuu extends AbstractExDBEntity<BM_Sisuu, PKBM_Sisuu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Sisuu";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String SISUUKOUHYOUYMD          = "sisuukouhyouymd";
    public static final String SISUU                    = "sisuu";
    public static final String SISUUCALCKIJYUNYMD       = "sisuucalckijyunymd";

    private final PKBM_Sisuu primaryKey;

    public GenBM_Sisuu() {
        primaryKey = new PKBM_Sisuu();
    }

    public GenBM_Sisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd) {
        primaryKey = new PKBM_Sisuu(pSisuukbn, pSisuukouhyouymd);
    }

    @Transient
    @Override
    public PKBM_Sisuu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Sisuu> getMetaClass() {
        return QBM_Sisuu.class;
    }

    @Id
    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenBM_Sisuu.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return getPrimaryKey().getSisuukbn();
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        getPrimaryKey().setSisuukbn(pSisuukbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_Sisuu.SISUUKOUHYOUYMD)
    public BizDate getSisuukouhyouymd() {
        return getPrimaryKey().getSisuukouhyouymd();
    }

    public void setSisuukouhyouymd(BizDate pSisuukouhyouymd) {
        getPrimaryKey().setSisuukouhyouymd(pSisuukouhyouymd);
    }

    private BizNumber sisuu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Sisuu.SISUU)
    public BizNumber getSisuu() {
        return sisuu;
    }

    public void setSisuu(BizNumber pSisuu) {
        sisuu = pSisuu;
    }

    private BizDate sisuucalckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Sisuu.SISUUCALCKIJYUNYMD)
    public BizDate getSisuucalckijyunymd() {
        return sisuucalckijyunymd;
    }

    public void setSisuucalckijyunymd(BizDate pSisuucalckijyunymd) {
        sisuucalckijyunymd = pSisuucalckijyunymd;
    }
}