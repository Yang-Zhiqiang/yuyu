package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.db.entity.BM_ChkNenkinSyurui;
import yuyu.def.db.id.PKBM_ChkNenkinSyurui;
import yuyu.def.db.meta.GenQBM_ChkNenkinSyurui;
import yuyu.def.db.meta.QBM_ChkNenkinSyurui;
import yuyu.def.db.type.UserType_C_Sknenkinsyu;

/**
 * 年金種類チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkNenkinSyurui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenkinSyurui}</td><td colspan="3">年金種類チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkNenkinSyurui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkNenkinSyurui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkNenkinSyurui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSknenkinsyu sknenkinsyu}</td><td>新契約年金種類</td><td align="center">{@link PKBM_ChkNenkinSyurui ○}</td><td align="center">V</td><td>{@link C_Sknenkinsyu}</td></tr>
 * </table>
 * @see     BM_ChkNenkinSyurui
 * @see     PKBM_ChkNenkinSyurui
 * @see     QBM_ChkNenkinSyurui
 * @see     GenQBM_ChkNenkinSyurui
 */
@MappedSuperclass
@Table(name=GenBM_ChkNenkinSyurui.TABLE_NAME)
@IdClass(value=PKBM_ChkNenkinSyurui.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Sknenkinsyu", typeClass=UserType_C_Sknenkinsyu.class)
})
public abstract class GenBM_ChkNenkinSyurui extends AbstractExDBEntity<BM_ChkNenkinSyurui, PKBM_ChkNenkinSyurui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkNenkinSyurui";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String SKNENKINSYU              = "sknenkinsyu";

    private final PKBM_ChkNenkinSyurui primaryKey;

    public GenBM_ChkNenkinSyurui() {
        primaryKey = new PKBM_ChkNenkinSyurui();
    }

    public GenBM_ChkNenkinSyurui(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Sknenkinsyu pSknenkinsyu
    ) {
        primaryKey = new PKBM_ChkNenkinSyurui(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pSknenkinsyu
        );
    }

    @Transient
    @Override
    public PKBM_ChkNenkinSyurui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkNenkinSyurui> getMetaClass() {
        return QBM_ChkNenkinSyurui.class;
    }

    @Id
    @Column(name=GenBM_ChkNenkinSyurui.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkNenkinSyurui.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkNenkinSyurui.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_Sknenkinsyu")
    @Column(name=GenBM_ChkNenkinSyurui.SKNENKINSYU)
    public C_Sknenkinsyu getSknenkinsyu() {
        return getPrimaryKey().getSknenkinsyu();
    }

    public void setSknenkinsyu(C_Sknenkinsyu pSknenkinsyu) {
        getPrimaryKey().setSknenkinsyu(pSknenkinsyu);
    }
}
