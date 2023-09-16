package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.mapping.GenMT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.GenQMT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.QMT_DsKouzokuJimuKakunin;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ後続事務確認テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsKouzokuJimuKakunin}</td><td colspan="3">ＤＳ後続事務確認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHasseiymd hasseiymd}</td><td>発生日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskzkjmkknhsjykbn dskzkjmkknhsjykbn}</td><td>ＤＳ後続事務確認発生事由区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DsKzkJmKknHsJyKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsKouzokuJimuKakunin
 * @see     GenMT_DsKouzokuJimuKakunin
 * @see     QMT_DsKouzokuJimuKakunin
 * @see     GenQMT_DsKouzokuJimuKakunin
 */
public class PKMT_DsKouzokuJimuKakunin extends AbstractExDBPrimaryKey<MT_DsKouzokuJimuKakunin, PKMT_DsKouzokuJimuKakunin> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsKouzokuJimuKakunin() {
    }

    public PKMT_DsKouzokuJimuKakunin(
        BizDate pHasseiymd,
        C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn,
        String pSyono
    ) {
        hasseiymd = pHasseiymd;
        dskzkjmkknhsjykbn = pDskzkjmkknhsjykbn;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<MT_DsKouzokuJimuKakunin> getEntityClass() {
        return MT_DsKouzokuJimuKakunin.class;
    }

    private BizDate hasseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getHasseiymd() {
        return hasseiymd;
    }

    public void setHasseiymd(BizDate pHasseiymd) {
        hasseiymd = pHasseiymd;
    }
    private C_DsKzkJmKknHsJyKbn dskzkjmkknhsjykbn;

    @org.hibernate.annotations.Type(type="UserType_C_DsKzkJmKknHsJyKbn")
    public C_DsKzkJmKknHsJyKbn getDskzkjmkknhsjykbn() {
        return dskzkjmkknhsjykbn;
    }

    public void setDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn) {
        dskzkjmkknhsjykbn = pDskzkjmkknhsjykbn;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}