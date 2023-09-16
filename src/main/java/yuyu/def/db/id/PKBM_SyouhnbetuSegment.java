package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;
import yuyu.def.db.mapping.GenBM_SyouhnbetuSegment;
import yuyu.def.db.meta.GenQBM_SyouhnbetuSegment;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;

/**
 * 商品別セグメントマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyouhnbetuSegment}</td><td colspan="3">商品別セグメントマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegbunrui1 segbunrui1}</td><td>セグメント分類１</td><td align="center">○</td><td align="center">V</td><td>{@link C_SegbunruiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegbunrui2 segbunrui2}</td><td>セグメント分類２</td><td align="center">○</td><td align="center">V</td><td>{@link C_SegbunruiKbn}</td></tr>
 *  <tr><td>segcd</td><td>セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 * </table>
 * @see     BM_SyouhnbetuSegment
 * @see     GenBM_SyouhnbetuSegment
 * @see     QBM_SyouhnbetuSegment
 * @see     GenQBM_SyouhnbetuSegment
 */
public class PKBM_SyouhnbetuSegment extends AbstractExDBPrimaryKey<BM_SyouhnbetuSegment, PKBM_SyouhnbetuSegment> {

    private static final long serialVersionUID = 1L;

    public PKBM_SyouhnbetuSegment() {
    }

    public PKBM_SyouhnbetuSegment(
        String pSyouhncd,
        C_Tuukasyu pKyktuukasyu,
        C_SegbunruiKbn pSegbunrui1,
        C_SegbunruiKbn pSegbunrui2
    ) {
        syouhncd = pSyouhncd;
        kyktuukasyu = pKyktuukasyu;
        segbunrui1 = pSegbunrui1;
        segbunrui2 = pSegbunrui2;
    }

    @Transient
    @Override
    public Class<BM_SyouhnbetuSegment> getEntityClass() {
        return BM_SyouhnbetuSegment.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private C_Tuukasyu kyktuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }
    private C_SegbunruiKbn segbunrui1;

    @org.hibernate.annotations.Type(type="UserType_C_SegbunruiKbn")
    public C_SegbunruiKbn getSegbunrui1() {
        return segbunrui1;
    }

    public void setSegbunrui1(C_SegbunruiKbn pSegbunrui1) {
        segbunrui1 = pSegbunrui1;
    }
    private C_SegbunruiKbn segbunrui2;

    @org.hibernate.annotations.Type(type="UserType_C_SegbunruiKbn")
    public C_SegbunruiKbn getSegbunrui2() {
        return segbunrui2;
    }

    public void setSegbunrui2(C_SegbunruiKbn pSegbunrui2) {
        segbunrui2 = pSegbunrui2;
    }

}