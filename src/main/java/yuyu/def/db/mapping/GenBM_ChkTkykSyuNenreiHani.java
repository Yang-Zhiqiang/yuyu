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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import yuyu.def.db.id.PKBM_ChkTkykSyuNenreiHani;
import yuyu.def.db.meta.GenQBM_ChkTkykSyuNenreiHani;
import yuyu.def.db.meta.QBM_ChkTkykSyuNenreiHani;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;

/**
 * 特約種類年齢範囲チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkTkykSyuNenreiHani} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTkykSyuNenreiHani}</td><td colspan="3">特約種類年齢範囲チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">{@link PKBM_ChkTkykSyuNenreiHani ○}</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_ChkTkykSyuNenreiHani
 * @see     PKBM_ChkTkykSyuNenreiHani
 * @see     QBM_ChkTkykSyuNenreiHani
 * @see     GenQBM_ChkTkykSyuNenreiHani
 */
@MappedSuperclass
@Table(name=GenBM_ChkTkykSyuNenreiHani.TABLE_NAME)
@IdClass(value=PKBM_ChkTkykSyuNenreiHani.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class)
})
public abstract class GenBM_ChkTkykSyuNenreiHani extends AbstractExDBEntity<BM_ChkTkykSyuNenreiHani, PKBM_ChkTkykSyuNenreiHani> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkTkykSyuNenreiHani";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";

    private final PKBM_ChkTkykSyuNenreiHani primaryKey;

    public GenBM_ChkTkykSyuNenreiHani() {
        primaryKey = new PKBM_ChkTkykSyuNenreiHani();
    }

    public GenBM_ChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn) {
        primaryKey = new PKBM_ChkTkykSyuNenreiHani(pPmnjtkkbn);
    }

    @Transient
    @Override
    public PKBM_ChkTkykSyuNenreiHani getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkTkykSyuNenreiHani> getMetaClass() {
        return QBM_ChkTkykSyuNenreiHani.class;
    }

    @Id
    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenBM_ChkTkykSyuNenreiHani.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return getPrimaryKey().getPmnjtkkbn();
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        getPrimaryKey().setPmnjtkkbn(pPmnjtkkbn);
    }

    private BizNumber hhknfromnen;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkTkykSyuNenreiHani.HHKNFROMNEN)
    public BizNumber getHhknfromnen() {
        return hhknfromnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknfromnen(BizNumber pHhknfromnen) {
        hhknfromnen = pHhknfromnen;
    }

    private BizNumber hhkntonen;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkTkykSyuNenreiHani.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return hhkntonen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        hhkntonen = pHhkntonen;
    }
}
