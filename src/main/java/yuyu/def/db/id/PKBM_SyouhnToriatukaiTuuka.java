package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.def.db.mapping.GenBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.GenQBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.QBM_SyouhnToriatukaiTuuka;

/**
 * 商品取扱通貨マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyouhnToriatukaiTuuka}</td><td colspan="3">商品取扱通貨マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkyfromymd tkyfromymd}</td><td>適用日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkytoymd tkytoymd}</td><td>適用日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZenkizennouumu zenkizennouumu}</td><td>全期前納有無</td><td align="center">○</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 * </table>
 * @see     BM_SyouhnToriatukaiTuuka
 * @see     GenBM_SyouhnToriatukaiTuuka
 * @see     QBM_SyouhnToriatukaiTuuka
 * @see     GenQBM_SyouhnToriatukaiTuuka
 */
public class PKBM_SyouhnToriatukaiTuuka extends AbstractExDBPrimaryKey<BM_SyouhnToriatukaiTuuka, PKBM_SyouhnToriatukaiTuuka> {

    private static final long serialVersionUID = 1L;

    public PKBM_SyouhnToriatukaiTuuka() {
    }

    public PKBM_SyouhnToriatukaiTuuka(
        String pSyouhncd,
        BizDate pTkyfromymd,
        BizDate pTkytoymd,
        C_BlnktkumuKbn pZenkizennouumu,
        C_Tuukasyu pKyktuukasyu,
        C_Tuukasyu pHrktuukasyu
    ) {
        syouhncd = pSyouhncd;
        tkyfromymd = pTkyfromymd;
        tkytoymd = pTkytoymd;
        zenkizennouumu = pZenkizennouumu;
        kyktuukasyu = pKyktuukasyu;
        hrktuukasyu = pHrktuukasyu;
    }

    @Transient
    @Override
    public Class<BM_SyouhnToriatukaiTuuka> getEntityClass() {
        return BM_SyouhnToriatukaiTuuka.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private BizDate tkyfromymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTkyfromymd() {
        return tkyfromymd;
    }

    public void setTkyfromymd(BizDate pTkyfromymd) {
        tkyfromymd = pTkyfromymd;
    }
    private BizDate tkytoymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTkytoymd() {
        return tkytoymd;
    }

    public void setTkytoymd(BizDate pTkytoymd) {
        tkytoymd = pTkytoymd;
    }
    private C_BlnktkumuKbn zenkizennouumu;

    @org.hibernate.annotations.Type(type="UserType_C_BlnktkumuKbn")
    public C_BlnktkumuKbn getZenkizennouumu() {
        return zenkizennouumu;
    }

    public void setZenkizennouumu(C_BlnktkumuKbn pZenkizennouumu) {
        zenkizennouumu = pZenkizennouumu;
    }
    private C_Tuukasyu kyktuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }
    private C_Tuukasyu hrktuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

}