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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ImagerenkeiKbn;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.id.PKDM_JimutetuzukiRireki;
import yuyu.def.db.meta.GenQDM_JimutetuzukiRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiRireki;
import yuyu.def.db.type.UserType_C_ImagerenkeiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 事務手続マスタ履歴保存テーブル テーブルのマッピング情報クラスで、 {@link DM_JimutetuzukiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_JimutetuzukiRireki}</td><td colspan="3">事務手続マスタ履歴保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">{@link PKDM_JimutetuzukiRireki ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKDM_JimutetuzukiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKDM_JimutetuzukiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukinm jimutetuzukinm}</td><td>事務手続名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getImagerenkeikbn imagerenkeikbn}</td><td>イメージ連携区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ImagerenkeiKbn}</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukouteijimutetuzukicd syukouteijimutetuzukicd}</td><td>主工程事務手続コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     DM_JimutetuzukiRireki
 * @see     PKDM_JimutetuzukiRireki
 * @see     QDM_JimutetuzukiRireki
 * @see     GenQDM_JimutetuzukiRireki
 */
@MappedSuperclass
@Table(name=GenDM_JimutetuzukiRireki.TABLE_NAME)
@IdClass(value=PKDM_JimutetuzukiRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_ImagerenkeiKbn", typeClass=UserType_C_ImagerenkeiKbn.class)
})
public abstract class GenDM_JimutetuzukiRireki extends AbstractExDBEntity<DM_JimutetuzukiRireki, PKDM_JimutetuzukiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "DM_JimutetuzukiRireki";
    public static final String KENSUUHOKANYMD           = "kensuuHokanYmd";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKINM           = "jimutetuzukinm";
    public static final String IMAGERENKEIKBN           = "imagerenkeikbn";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String SYUKOUTEIJIMUTETUZUKICD  = "syukouteijimutetuzukicd";

    private final PKDM_JimutetuzukiRireki primaryKey;

    public GenDM_JimutetuzukiRireki() {
        primaryKey = new PKDM_JimutetuzukiRireki();
    }

    public GenDM_JimutetuzukiRireki(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pSubSystemId
    ) {
        primaryKey = new PKDM_JimutetuzukiRireki(
            pKensuuHokanYmd,
            pJimutetuzukicd,
            pSubSystemId
        );
    }

    @Transient
    @Override
    public PKDM_JimutetuzukiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QDM_JimutetuzukiRireki> getMetaClass() {
        return QDM_JimutetuzukiRireki.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenDM_JimutetuzukiRireki.KENSUUHOKANYMD)
    public BizDate getKensuuHokanYmd() {
        return getPrimaryKey().getKensuuHokanYmd();
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        getPrimaryKey().setKensuuHokanYmd(pKensuuHokanYmd);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiRireki.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenDM_JimutetuzukiRireki.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    private String jimutetuzukinm;

    @Column(name=GenDM_JimutetuzukiRireki.JIMUTETUZUKINM)
    @InvalidCharacter
    @MaxLength(max=20)
    @MultiByteStrings
    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    @DataConvert("toMultiByte")
    public void setJimutetuzukinm(String pJimutetuzukinm) {
        jimutetuzukinm = pJimutetuzukinm;
    }

    private C_ImagerenkeiKbn imagerenkeikbn;

    @Type(type="UserType_C_ImagerenkeiKbn")
    @Column(name=GenDM_JimutetuzukiRireki.IMAGERENKEIKBN)
    public C_ImagerenkeiKbn getImagerenkeikbn() {
        return imagerenkeikbn;
    }

    public void setImagerenkeikbn(C_ImagerenkeiKbn pImagerenkeikbn) {
        imagerenkeikbn = pImagerenkeikbn;
    }

    private Integer hyoujijyun;

    @Column(name=GenDM_JimutetuzukiRireki.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private String syukouteijimutetuzukicd;

    @Column(name=GenDM_JimutetuzukiRireki.SYUKOUTEIJIMUTETUZUKICD)
    public String getSyukouteijimutetuzukicd() {
        return syukouteijimutetuzukicd;
    }

    public void setSyukouteijimutetuzukicd(String pSyukouteijimutetuzukicd) {
        syukouteijimutetuzukicd = pSyukouteijimutetuzukicd;
    }
}