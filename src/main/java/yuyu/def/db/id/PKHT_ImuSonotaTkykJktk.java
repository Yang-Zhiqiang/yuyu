package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.HT_ImuSonotaTkykJktk;
import yuyu.def.db.mapping.GenHT_ImuSonotaTkykJktk;
import yuyu.def.db.meta.GenQHT_ImuSonotaTkykJktk;
import yuyu.def.db.meta.QHT_ImuSonotaTkykJktk;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 医務査定その他特約条件付テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_ImuSonotaTkykJktk}</td><td colspan="3">医務査定その他特約条件付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>tknzkkbn</td><td>特約除き区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TknzkKbn C_TknzkKbn}</td></tr>
 *  <tr><td>seigens</td><td>制限Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_ImuSonotaTkykJktk
 * @see     GenHT_ImuSonotaTkykJktk
 * @see     QHT_ImuSonotaTkykJktk
 * @see     GenQHT_ImuSonotaTkykJktk
 */
public class PKHT_ImuSonotaTkykJktk extends AbstractExDBPrimaryKey<HT_ImuSonotaTkykJktk, PKHT_ImuSonotaTkykJktk> {

    private static final long serialVersionUID = 1L;

    public PKHT_ImuSonotaTkykJktk() {
    }

    public PKHT_ImuSonotaTkykJktk(
        String pMosno,
        Integer pRenno,
        C_PmnjtkKbn pPmnjtkkbn
    ) {
        mosno = pMosno;
        renno = pRenno;
        pmnjtkkbn = pPmnjtkkbn;
    }

    @Transient
    @Override
    public Class<HT_ImuSonotaTkykJktk> getEntityClass() {
        return HT_ImuSonotaTkykJktk.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }
    private C_PmnjtkKbn pmnjtkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_PmnjtkKbn")
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

}