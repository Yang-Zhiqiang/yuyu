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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_AnsyuyouErrJyouhou;
import yuyu.def.db.id.PKIT_AnsyuyouErrJyouhou;
import yuyu.def.db.meta.GenQIT_AnsyuyouErrJyouhou;
import yuyu.def.db.meta.QIT_AnsyuyouErrJyouhou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納用エラー情報テーブル テーブルのマッピング情報クラスで、 {@link IT_AnsyuyouErrJyouhou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AnsyuyouErrJyouhou}</td><td colspan="3">案内収納用エラー情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_AnsyuyouErrJyouhou ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">{@link PKIT_AnsyuyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_AnsyuyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">{@link PKIT_AnsyuyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnsyuyouerrnaiyou ansyuyouerrnaiyou}</td><td>案内収納用エラー内容</td><td align="center">{@link PKIT_AnsyuyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AnsyuyouErrJyouhou
 * @see     PKIT_AnsyuyouErrJyouhou
 * @see     QIT_AnsyuyouErrJyouhou
 * @see     GenQIT_AnsyuyouErrJyouhou
 */
@MappedSuperclass
@Table(name=GenIT_AnsyuyouErrJyouhou.TABLE_NAME)
@IdClass(value=PKIT_AnsyuyouErrJyouhou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenIT_AnsyuyouErrJyouhou extends AbstractExDBEntity<IT_AnsyuyouErrJyouhou, PKIT_AnsyuyouErrJyouhou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_AnsyuyouErrJyouhou";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KAKUTYOUJOBCD            = "kakutyoujobcd";
    public static final String SYONO                    = "syono";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String ANSYUYOUERRNAIYOU        = "ansyuyouerrnaiyou";

    private final PKIT_AnsyuyouErrJyouhou primaryKey;

    public GenIT_AnsyuyouErrJyouhou() {
        primaryKey = new PKIT_AnsyuyouErrJyouhou();
    }

    public GenIT_AnsyuyouErrJyouhou(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pGyoumuKousinTime,
        String pAnsyuyouerrnaiyou
    ) {
        primaryKey = new PKIT_AnsyuyouErrJyouhou(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pGyoumuKousinTime,
            pAnsyuyouerrnaiyou
        );
    }

    @Transient
    @Override
    public PKIT_AnsyuyouErrJyouhou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_AnsyuyouErrJyouhou> getMetaClass() {
        return QIT_AnsyuyouErrJyouhou.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_AnsyuyouErrJyouhou.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_AnsyuyouErrJyouhou.KAKUTYOUJOBCD)
    public String getKakutyoujobcd() {
        return getPrimaryKey().getKakutyoujobcd();
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        getPrimaryKey().setKakutyoujobcd(pKakutyoujobcd);
    }

    @Id
    @Column(name=GenIT_AnsyuyouErrJyouhou.SYONO)
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
    @Column(name=GenIT_AnsyuyouErrJyouhou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return getPrimaryKey().getGyoumuKousinTime();
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        getPrimaryKey().setGyoumuKousinTime(pGyoumuKousinTime);
    }

    @Id
    @Column(name=GenIT_AnsyuyouErrJyouhou.ANSYUYOUERRNAIYOU)
    public String getAnsyuyouerrnaiyou() {
        return getPrimaryKey().getAnsyuyouerrnaiyou();
    }

    public void setAnsyuyouerrnaiyou(String pAnsyuyouerrnaiyou) {
        getPrimaryKey().setAnsyuyouerrnaiyou(pAnsyuyouerrnaiyou);
    }
}