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
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;
import yuyu.def.db.id.PKBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.GenQBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.QBT_KijituTouraiHonbanKensyou;

/**
 * 期日到来本番検証用テーブル テーブルのマッピング情報クラスで、 {@link BT_KijituTouraiHonbanKensyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KijituTouraiHonbanKensyou}</td><td colspan="3">期日到来本番検証用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_KijituTouraiHonbanKensyou ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKBT_KijituTouraiHonbanKensyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytno tysytno}</td><td>抽出番号</td><td align="center">{@link PKBT_KijituTouraiHonbanKensyou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDatakanrino datakanrino}</td><td>データ管理番号</td><td align="center">{@link PKBT_KijituTouraiHonbanKensyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou1 tysytnaiyou1}</td><td>抽出内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou2 tysytnaiyou2}</td><td>抽出内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou3 tysytnaiyou3}</td><td>抽出内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou4 tysytnaiyou4}</td><td>抽出内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou5 tysytnaiyou5}</td><td>抽出内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou6 tysytnaiyou6}</td><td>抽出内容６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou7 tysytnaiyou7}</td><td>抽出内容７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou8 tysytnaiyou8}</td><td>抽出内容８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou9 tysytnaiyou9}</td><td>抽出内容９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytnaiyou10 tysytnaiyou10}</td><td>抽出内容１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_KijituTouraiHonbanKensyou
 * @see     PKBT_KijituTouraiHonbanKensyou
 * @see     QBT_KijituTouraiHonbanKensyou
 * @see     GenQBT_KijituTouraiHonbanKensyou
 */
@MappedSuperclass
@Table(name=GenBT_KijituTouraiHonbanKensyou.TABLE_NAME)
@IdClass(value=PKBT_KijituTouraiHonbanKensyou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenBT_KijituTouraiHonbanKensyou extends AbstractExDBEntity<BT_KijituTouraiHonbanKensyou, PKBT_KijituTouraiHonbanKensyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KijituTouraiHonbanKensyou";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String TYSYTNO                  = "tysytno";
    public static final String DATAKANRINO              = "datakanrino";
    public static final String TYSYTNAIYOU1             = "tysytnaiyou1";
    public static final String TYSYTNAIYOU2             = "tysytnaiyou2";
    public static final String TYSYTNAIYOU3             = "tysytnaiyou3";
    public static final String TYSYTNAIYOU4             = "tysytnaiyou4";
    public static final String TYSYTNAIYOU5             = "tysytnaiyou5";
    public static final String TYSYTNAIYOU6             = "tysytnaiyou6";
    public static final String TYSYTNAIYOU7             = "tysytnaiyou7";
    public static final String TYSYTNAIYOU8             = "tysytnaiyou8";
    public static final String TYSYTNAIYOU9             = "tysytnaiyou9";
    public static final String TYSYTNAIYOU10            = "tysytnaiyou10";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_KijituTouraiHonbanKensyou primaryKey;

    public GenBT_KijituTouraiHonbanKensyou() {
        primaryKey = new PKBT_KijituTouraiHonbanKensyou();
    }

    public GenBT_KijituTouraiHonbanKensyou(
        BizDate pSyoriYmd,
        String pSubSystemId,
        Integer pTysytno,
        String pDatakanrino
    ) {
        primaryKey = new PKBT_KijituTouraiHonbanKensyou(
            pSyoriYmd,
            pSubSystemId,
            pTysytno,
            pDatakanrino
        );
    }

    @Transient
    @Override
    public PKBT_KijituTouraiHonbanKensyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KijituTouraiHonbanKensyou> getMetaClass() {
        return QBT_KijituTouraiHonbanKensyou.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_KijituTouraiHonbanKensyou.SYORIYMD)
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
    @Column(name=GenBT_KijituTouraiHonbanKensyou.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNO)
    public Integer getTysytno() {
        return getPrimaryKey().getTysytno();
    }

    public void setTysytno(Integer pTysytno) {
        getPrimaryKey().setTysytno(pTysytno);
    }

    @Id
    @Column(name=GenBT_KijituTouraiHonbanKensyou.DATAKANRINO)
    public String getDatakanrino() {
        return getPrimaryKey().getDatakanrino();
    }

    public void setDatakanrino(String pDatakanrino) {
        getPrimaryKey().setDatakanrino(pDatakanrino);
    }

    private String tysytnaiyou1;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU1)
    public String getTysytnaiyou1() {
        return tysytnaiyou1;
    }

    public void setTysytnaiyou1(String pTysytnaiyou1) {
        tysytnaiyou1 = pTysytnaiyou1;
    }

    private String tysytnaiyou2;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU2)
    public String getTysytnaiyou2() {
        return tysytnaiyou2;
    }

    public void setTysytnaiyou2(String pTysytnaiyou2) {
        tysytnaiyou2 = pTysytnaiyou2;
    }

    private String tysytnaiyou3;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU3)
    public String getTysytnaiyou3() {
        return tysytnaiyou3;
    }

    public void setTysytnaiyou3(String pTysytnaiyou3) {
        tysytnaiyou3 = pTysytnaiyou3;
    }

    private String tysytnaiyou4;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU4)
    public String getTysytnaiyou4() {
        return tysytnaiyou4;
    }

    public void setTysytnaiyou4(String pTysytnaiyou4) {
        tysytnaiyou4 = pTysytnaiyou4;
    }

    private String tysytnaiyou5;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU5)
    public String getTysytnaiyou5() {
        return tysytnaiyou5;
    }

    public void setTysytnaiyou5(String pTysytnaiyou5) {
        tysytnaiyou5 = pTysytnaiyou5;
    }

    private String tysytnaiyou6;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU6)
    public String getTysytnaiyou6() {
        return tysytnaiyou6;
    }

    public void setTysytnaiyou6(String pTysytnaiyou6) {
        tysytnaiyou6 = pTysytnaiyou6;
    }

    private String tysytnaiyou7;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU7)
    public String getTysytnaiyou7() {
        return tysytnaiyou7;
    }

    public void setTysytnaiyou7(String pTysytnaiyou7) {
        tysytnaiyou7 = pTysytnaiyou7;
    }

    private String tysytnaiyou8;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU8)
    public String getTysytnaiyou8() {
        return tysytnaiyou8;
    }

    public void setTysytnaiyou8(String pTysytnaiyou8) {
        tysytnaiyou8 = pTysytnaiyou8;
    }

    private String tysytnaiyou9;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU9)
    public String getTysytnaiyou9() {
        return tysytnaiyou9;
    }

    public void setTysytnaiyou9(String pTysytnaiyou9) {
        tysytnaiyou9 = pTysytnaiyou9;
    }

    private String tysytnaiyou10;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.TYSYTNAIYOU10)
    public String getTysytnaiyou10() {
        return tysytnaiyou10;
    }

    public void setTysytnaiyou10(String pTysytnaiyou10) {
        tysytnaiyou10 = pTysytnaiyou10;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_KijituTouraiHonbanKensyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}