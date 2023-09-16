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
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;
import yuyu.def.db.id.PKBM_SyouhnbetuSegment;
import yuyu.def.db.meta.GenQBM_SyouhnbetuSegment;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;
import yuyu.def.db.type.UserType_C_SegbunruiKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 商品別セグメントマスタ テーブルのマッピング情報クラスで、 {@link BM_SyouhnbetuSegment} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyouhnbetuSegment}</td><td colspan="3">商品別セグメントマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_SyouhnbetuSegment ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">{@link PKBM_SyouhnbetuSegment ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSegbunrui1 segbunrui1}</td><td>セグメント分類１</td><td align="center">{@link PKBM_SyouhnbetuSegment ○}</td><td align="center">V</td><td>{@link C_SegbunruiKbn}</td></tr>
 *  <tr><td>{@link #getSegbunrui2 segbunrui2}</td><td>セグメント分類２</td><td align="center">{@link PKBM_SyouhnbetuSegment ○}</td><td align="center">V</td><td>{@link C_SegbunruiKbn}</td></tr>
 *  <tr><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 * </table>
 * @see     BM_SyouhnbetuSegment
 * @see     PKBM_SyouhnbetuSegment
 * @see     QBM_SyouhnbetuSegment
 * @see     GenQBM_SyouhnbetuSegment
 */
@MappedSuperclass
@Table(name=GenBM_SyouhnbetuSegment.TABLE_NAME)
@IdClass(value=PKBM_SyouhnbetuSegment.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SegbunruiKbn", typeClass=UserType_C_SegbunruiKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_SyouhnbetuSegment extends AbstractExDBEntity<BM_SyouhnbetuSegment, PKBM_SyouhnbetuSegment> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SyouhnbetuSegment";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SEGBUNRUI1               = "segbunrui1";
    public static final String SEGBUNRUI2               = "segbunrui2";
    public static final String SEGCD                    = "segcd";

    private final PKBM_SyouhnbetuSegment primaryKey;

    public GenBM_SyouhnbetuSegment() {
        primaryKey = new PKBM_SyouhnbetuSegment();
    }

    public GenBM_SyouhnbetuSegment(
        String pSyouhncd,
        C_Tuukasyu pKyktuukasyu,
        C_SegbunruiKbn pSegbunrui1,
        C_SegbunruiKbn pSegbunrui2
    ) {
        primaryKey = new PKBM_SyouhnbetuSegment(
            pSyouhncd,
            pKyktuukasyu,
            pSegbunrui1,
            pSegbunrui2
        );
    }

    @Transient
    @Override
    public PKBM_SyouhnbetuSegment getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SyouhnbetuSegment> getMetaClass() {
        return QBM_SyouhnbetuSegment.class;
    }

    @Id
    @Column(name=GenBM_SyouhnbetuSegment.SYOUHNCD)
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
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SyouhnbetuSegment.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return getPrimaryKey().getKyktuukasyu();
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        getPrimaryKey().setKyktuukasyu(pKyktuukasyu);
    }

    @Id
    @Type(type="UserType_C_SegbunruiKbn")
    @Column(name=GenBM_SyouhnbetuSegment.SEGBUNRUI1)
    public C_SegbunruiKbn getSegbunrui1() {
        return getPrimaryKey().getSegbunrui1();
    }

    public void setSegbunrui1(C_SegbunruiKbn pSegbunrui1) {
        getPrimaryKey().setSegbunrui1(pSegbunrui1);
    }

    @Id
    @Type(type="UserType_C_SegbunruiKbn")
    @Column(name=GenBM_SyouhnbetuSegment.SEGBUNRUI2)
    public C_SegbunruiKbn getSegbunrui2() {
        return getPrimaryKey().getSegbunrui2();
    }

    public void setSegbunrui2(C_SegbunruiKbn pSegbunrui2) {
        getPrimaryKey().setSegbunrui2(pSegbunrui2);
    }

    private C_Segcd segcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBM_SyouhnbetuSegment.SEGCD)
    public C_Segcd getSegcd() {
        return segcd;
    }

    public void setSegcd(C_Segcd pSegcd) {
        segcd = pSegcd;
    }
}