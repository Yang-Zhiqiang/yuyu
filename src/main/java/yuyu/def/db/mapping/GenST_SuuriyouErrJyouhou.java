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
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.id.PKST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.GenQST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.QST_SuuriyouErrJyouhou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 数理用エラー情報テーブル テーブルのマッピング情報クラスで、 {@link ST_SuuriyouErrJyouhou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SuuriyouErrJyouhou}</td><td colspan="3">数理用エラー情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKST_SuuriyouErrJyouhou ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">{@link PKST_SuuriyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKST_SuuriyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">{@link PKST_SuuriyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSuuritoukeiyouerrnaiyou suuritoukeiyouerrnaiyou}</td><td>数理統計用エラー内容</td><td align="center">{@link PKST_SuuriyouErrJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SuuriyouErrJyouhou
 * @see     PKST_SuuriyouErrJyouhou
 * @see     QST_SuuriyouErrJyouhou
 * @see     GenQST_SuuriyouErrJyouhou
 */
@MappedSuperclass
@Table(name=GenST_SuuriyouErrJyouhou.TABLE_NAME)
@IdClass(value=PKST_SuuriyouErrJyouhou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenST_SuuriyouErrJyouhou extends AbstractExDBEntity<ST_SuuriyouErrJyouhou, PKST_SuuriyouErrJyouhou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_SuuriyouErrJyouhou";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KAKUTYOUJOBCD            = "kakutyoujobcd";
    public static final String SYONO                    = "syono";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SUURITOUKEIYOUERRNAIYOU  = "suuritoukeiyouerrnaiyou";

    private final PKST_SuuriyouErrJyouhou primaryKey;

    public GenST_SuuriyouErrJyouhou() {
        primaryKey = new PKST_SuuriyouErrJyouhou();
    }

    public GenST_SuuriyouErrJyouhou(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pGyoumuKousinTime,
        String pSuuritoukeiyouerrnaiyou
    ) {
        primaryKey = new PKST_SuuriyouErrJyouhou(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pGyoumuKousinTime,
            pSuuritoukeiyouerrnaiyou
        );
    }

    @Transient
    @Override
    public PKST_SuuriyouErrJyouhou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_SuuriyouErrJyouhou> getMetaClass() {
        return QST_SuuriyouErrJyouhou.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenST_SuuriyouErrJyouhou.SYORIYMD)
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
    @Column(name=GenST_SuuriyouErrJyouhou.KAKUTYOUJOBCD)
    public String getKakutyoujobcd() {
        return getPrimaryKey().getKakutyoujobcd();
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        getPrimaryKey().setKakutyoujobcd(pKakutyoujobcd);
    }

    @Id
    @Column(name=GenST_SuuriyouErrJyouhou.SYONO)
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
    @Column(name=GenST_SuuriyouErrJyouhou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return getPrimaryKey().getGyoumuKousinTime();
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        getPrimaryKey().setGyoumuKousinTime(pGyoumuKousinTime);
    }

    @Id
    @Column(name=GenST_SuuriyouErrJyouhou.SUURITOUKEIYOUERRNAIYOU)
    public String getSuuritoukeiyouerrnaiyou() {
        return getPrimaryKey().getSuuritoukeiyouerrnaiyou();
    }

    public void setSuuritoukeiyouerrnaiyou(String pSuuritoukeiyouerrnaiyou) {
        getPrimaryKey().setSuuritoukeiyouerrnaiyou(pSuuritoukeiyouerrnaiyou);
    }
}