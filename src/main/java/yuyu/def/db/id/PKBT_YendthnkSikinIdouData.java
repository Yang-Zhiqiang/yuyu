package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.mapping.GenBT_YendthnkSikinIdouData;
import yuyu.def.db.meta.GenQBT_YendthnkSikinIdouData;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouData;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 円建変更資金移動データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_YendthnkSikinIdouData}</td><td colspan="3">円建変更資金移動データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeiriyendthnkkbn keiriyendthnkkbn}</td><td>経理用円建変更区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KeiriyendthnkKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>siteituuka</td><td>指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siteituukagk</td><td>指定通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>trhktuuka</td><td>取引通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>trhktuukagk</td><td>取引通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_YendthnkSikinIdouData
 * @see     GenBT_YendthnkSikinIdouData
 * @see     QBT_YendthnkSikinIdouData
 * @see     GenQBT_YendthnkSikinIdouData
 */
public class PKBT_YendthnkSikinIdouData extends AbstractExDBPrimaryKey<BT_YendthnkSikinIdouData, PKBT_YendthnkSikinIdouData> {

    private static final long serialVersionUID = 1L;

    public PKBT_YendthnkSikinIdouData() {
    }

    public PKBT_YendthnkSikinIdouData(
        String pSyono,
        C_KeiriyendthnkKbn pKeiriyendthnkkbn,
        BizDate pSyoriYmd
    ) {
        syono = pSyono;
        keiriyendthnkkbn = pKeiriyendthnkkbn;
        syoriYmd = pSyoriYmd;
    }

    @Transient
    @Override
    public Class<BT_YendthnkSikinIdouData> getEntityClass() {
        return BT_YendthnkSikinIdouData.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private C_KeiriyendthnkKbn keiriyendthnkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_KeiriyendthnkKbn")
    public C_KeiriyendthnkKbn getKeiriyendthnkkbn() {
        return keiriyendthnkkbn;
    }

    public void setKeiriyendthnkkbn(C_KeiriyendthnkKbn pKeiriyendthnkkbn) {
        keiriyendthnkkbn = pKeiriyendthnkkbn;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

}